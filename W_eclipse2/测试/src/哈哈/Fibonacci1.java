package 哈哈;

public class Fibonacci1
{
	int f1 = 0;
	int f2 = 1;
	static int m = 1;
	public Fibonacci1()
	{
		for(int i = 0;i<10;i++)
		{
			System.out.print(m+" ");
			m = f1 + f2;
			f1 = f2 ;
			f2 = m;		
		}
	}
	public static void main(String args[])
	{
		new Fibonacci1(); 
	}
}
