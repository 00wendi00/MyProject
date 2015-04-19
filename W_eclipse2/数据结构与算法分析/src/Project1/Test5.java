/**
 *文件名:Test4.java
 *项目-包:数据结构与算法分析,Project1
 *作者:张文迪
 *时间:2015年4月5日
 */
package Project1;

/**
 * @author 张文迪
 * 类名:Test4
 * 类说明:递归~~~~~
 */
public class Test5 {
	static int c = 0;
	public static void main(String args[]){
		System.out.println(digui(1));
		System.out.println(c);
	}
	public static int digui( int n )
	{
		if( n < 2 )
			return n;	
		c++;
		return n % 2 + digui( n / 2 );
	}
}
