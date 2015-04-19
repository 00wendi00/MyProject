/**
 * 文件名：Ex5.java
 * 项目-包：JAVA编程思想 - 第十二章异常
 * 作者：张文迪
 * 创建日期：2014-10-11
 */
package 第十二章异常;

/**
 * @author 张文迪
 * 类名：Ex5
 * 类说明：
 */
public class Ex5 {
	private static int[] ia = new int[2];
	static int x = 5;	
	public static void main(String[] args) {
		while(true) 
		{
			try {
				ia[x] = 1;
				System.out.println(ia[x]);
				break;	//精髓
			} catch(ArrayIndexOutOfBoundsException e) {
				System.err.println(
					"Caught ArrayIndexOutOfBoundsException");
					e.printStackTrace();
				x--;
			} finally {
				System.out.println("Are we done yet?");		
			}
		}
		System.out.println("Now, we're done.");
	}	
}
