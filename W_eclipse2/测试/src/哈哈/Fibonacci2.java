package 哈哈;

public class Fibonacci2 
{
	int m;
	Fibonacci2()
	{
		m = getFib(7);
		System.out.println(m+"~");
		
		System.out.println();
		for(int i = 0 ;i<10;i++)   // ��������ʱ~~~
		{
			System.out.print(getFib(i)+" ");
		}
	}
	public int getFib(int n)
	{
		if(n<=2) 
			return 1;
		return getFib(n-2)+getFib(n-1);
	}
	public static void main(String args[])
	{
		new Fibonacci2();
	}
}
