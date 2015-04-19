package 哈哈;

public class Strings 
{
	public static void main(String args[])
	{
		String a ="abc";
		String c ="abc";
		String d = new String("abc");
		String b = new String("abc");
		System.out.println(a==b);
		System.out.println(a.equals(b));
		
		System.out.println(a==c);
		System.out.println(a.equals(c));
		
		System.out.println(d==b);
		System.out.println(d.equals(b));
	}
}
