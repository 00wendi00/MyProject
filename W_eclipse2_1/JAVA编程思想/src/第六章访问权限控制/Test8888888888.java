/**
 * �ļ�����Test8888888888.java
 * ��Ŀ-����JAVA���˼�� - �����·���Ȩ�޿���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-7
 */
package �����·���Ȩ�޿���;

/**
 * @author ���ĵ�
 * ������Test8888888888
 * ��˵������ϰ8.  ��static ������ȡ private��Ķ���
 */
public class Test8888888888
{
    public static void main(String args[])
    {
    	ConnectionManager con = ConnectionManager.Haode123();
    	con = null ;//�̶�������Ȼ���ڣ����Ƕ����Ѿ������ڡ�
    	con.haha123();
    }
}

class ConnectionManager
{
	private ConnectionManager()
	{
		String Connection[] = {"weweqe","weqwewqewe","21231152"};
		for(int i = 0;i<Connection.length;i++)
		{
			System.out.print(Connection[i]+ " ");			
		}
		System.out.println();
	}
	public static ConnectionManager Haode123()
	{
		System.out.println("������123");
		return new ConnectionManager();		
	}
	public static  ConnectionManager haha123()
	{
		System.out.println("�޶�����");
		return null;
	}
}
