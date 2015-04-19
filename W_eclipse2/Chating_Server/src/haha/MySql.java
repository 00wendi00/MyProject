package haha;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class MySql 
{
	Map<String, String> accoutMap;
	public MySql() throws SQLException
	{
		int index = 0;
		//1.加载驱动程序
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//2.创建与DB数据库的连接
		//连接字符串
		String url = "jdbc:mysql://localhost:3306/haode";
		Connection con=DriverManager.getConnection(url,"root","000000");
		//进行读写
		if(!con.isClosed()){
			System.out.print("欢迎访问我的数据库\n");
			Statement st=con.createStatement();
				ResultSet rs= st.executeQuery("select * from regist");
				while(rs.next())
				{
					accoutMap.put(rs.getString(0), rs.getString(1));
					//System.out.print( rs.getString("name")+","+rs.getString("pwd")+"\n");
				}
		}
		//关闭数据库
		//con.close();
	}
	
}