/**
 * 文件名：Human30.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-12
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：Human30
 * 类说明：
 */
class Annoyance extends RuntimeException {}
class Sneeze extends Annoyance {}


class WrapCheckedExceptions 
{
	void throwRuntimeException(int type) 
	{
		try 
		{
			switch(type) 
			{
				case(0): 
					throw new Annoyance();
				case(1): 
					throw new Sneeze();
				case(2): 
			throw new RuntimeException("Where am I?");
				default: return;
			}
		} 	catch(Exception e) { 
			// Adapt to unchecked:
			throw new RuntimeException(e);
		}
	}	
}

public class Human30 
{
	public static void main(String[] args) 
	{
		WrapCheckedExceptions wce = 
			new WrapCheckedExceptions();
		for(int i = 0; i < 4; i++)
			try 
		    {
				if(i < 3)
					wce.throwRuntimeException(i);
				else
					throw new RuntimeException();			
			}	
			catch(RuntimeException re) 
			{
				try 
				{
					throw re.getCause();
				} 	catch(Sneeze e) {
					System.out.println("Sneeze:~~~~~~~~ " + e);
				}	catch(Annoyance e) {
					System.out.println("Annoyance: " + e);
				}	catch(Throwable e) {
					System.out.println("Throwable: " + e);
				}
			}		
	}
}
