package haha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;

public class ServerThread implements Runnable
{
	Socket s = null;
	BufferedReader br = null;
	public ServerThread(Socket s ) throws IOException,SQLException
	{
		this.s = s;
		br = new BufferedReader(new InputStreamReader(s.getInputStream(),"utf-8"));
		
		//1.鍔犺浇椹卞姩绋嬪簭
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void run()
	{
		try {
			String content = null;
			String contents[] = new String[3];
			int i = 0;
			while((content = readFromClient()) != null)
			{
				contents[i++] = content;
				if(i == 3)
				{
					OutputStream os =s.getOutputStream();				
					try {
						//2.鍒涘缓涓嶥B鏁版嵁搴撶殑杩炴帴
						//杩炴帴瀛楃涓�
						String url = "jdbc:mysql://localhost:3306/haode";
						Connection con=DriverManager.getConnection(url,"root","000000");
						//杩涜璇诲啓
						if(!con.isClosed()){
							System.out.print("娆㈣繋璁块棶鎴戠殑鏁版嵁搴�-----娉ㄥ唽\n");
							/*Statement st=con.createStatement();
								ResultSet rs= st.executeQuery("select account from regist1");
								while(rs.next())
								{							
									System.out.print( rs.getString("account")+"\n");
								}
							st.execute("insert into regist1 values('123','10001');");	*/
							
							//涓嬮潰鍑犺濂藉ソ鐪嬶綖锝烇綖锝烇綖锝烇綖
							String sql = "insert into regist values(?,?,?)"; //鈽�
							PreparedStatement sta = (PreparedStatement) con.prepareStatement(sql);						
					        sta.setString(1, contents[0]);
					        sta.setString(2, contents[1]);
					        sta.setString(3, contents[2]);
					        int rows = sta.executeUpdate();
					        if(rows > 0) {
					            System.out.println("operate successfully!");
					        }
					        sta.close();
					        con.close();
						}
						//鍏抽棴鏁版嵁搴�
						con.close();
						System.out.println("娉ㄥ唽鎴愬姛,娉ㄥ唽淇℃伅涓� : "+Arrays.toString(contents)); 
						os.write(("success"+"\n").getBytes("utf-8"));
						os.write(("success"+"\n").getBytes("utf-8"));
						os.write(("success"+"\n").getBytes("utf-8"));
						os.write(("success"+"\n").getBytes("utf-8"));
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("娉ㄥ唽澶辫触");
						os.write(("failure"+"\r\n").getBytes("utf-8"));
					}finally
					{
						i = 0;
					}
				}
			}
		}
		catch (IOException e) 
		{		
			e.printStackTrace();
		}
	}
	private String readFromClient()
	{
		try {
			return br.readLine();
		} catch (IOException e) {
			Regist.socketList.remove(s);
		}
		return null;
	}
}
