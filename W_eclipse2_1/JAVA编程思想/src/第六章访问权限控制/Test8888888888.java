/**
 * 文件名：Test8888888888.java
 * 项目-包：JAVA编程思想 - 第六章访问权限控制
 * 作者：张文迪
 * 创建日期：2014-9-7
 */
package 第六章访问权限控制;

/**
 * @author 张文迪
 * 类名：Test8888888888
 * 类说明：练习8.  用static 方法获取 private类的对象。
 */
public class Test8888888888
{
    public static void main(String args[])
    {
    	ConnectionManager con = ConnectionManager.Haode123();
    	con = null ;//固定数组依然存在，但是对象已经不存在。
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
		System.out.println("调用了123");
		return new ConnectionManager();		
	}
	public static  ConnectionManager haha123()
	{
		System.out.println("无对象了");
		return null;
	}
}
