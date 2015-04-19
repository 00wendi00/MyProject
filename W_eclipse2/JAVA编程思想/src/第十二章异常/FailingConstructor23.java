/**
 * 文件名：FailingConstructor23.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-12
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：FailingConstructor23
 * 类说明：
 */
class Disposable 
{
	private static int counter = 0;
	private int id = counter++;
	private boolean disposed;
	Disposable() 
	{
		disposed = false;
	}
	void dispose() 
	{
		disposed = true;
	}
	String checkStatus() 
	{
		return (id + " ~~~~~~~~~" + (disposed ? "disposed" : "not disposed"));
	}
}

public class FailingConstructor23 {
	private Integer[] ia = new Integer[2];
	private static Disposable d0;
	private static Disposable d1;	
	FailingConstructor23() throws Exception 
	{
		try 
		{
			d0 = new Disposable();//1111111
			try 
			{
				ia[2] = 2; 	// causes exception thrown and 
						// caught in middle try loop
				try 
				{ 
					d1 = new Disposable();	//222222			
				} 
				catch(Exception e) 
				{
					System.out.println("Caught e in inner try loop!!!");
					e.printStackTrace(System.err);
					System.out.println("Failed to create d1");
				}
			} 
			catch(Exception e) 
			{
				System.out.println("Caught e in middle try loop~~~");
				e.printStackTrace(System.err);
				System.out.println("Disposing d0");
				d0.dispose(); // d0 would have been created
			} 	
		} 
		catch(Exception e) 
		{
			System.out.println("Caught e in outer try loop");
			e.printStackTrace(System.err);
			System.out.println("Failed to create d0");
		}
		
	}
	public static void main(String[] args) 
	{
		try 
		{
			// the constructor catches its own exceptions:
			FailingConstructor23 fc = new FailingConstructor23();
		} 
		catch(Exception e) 
		{
			System.err.println("Caught Exception in main()");
			e.printStackTrace(System.err);
		} 
	}	
}