package 哈哈;

public class CharAt
{
	public static void main(String args[])
	{
		String s = "11111111111111111111111"
				+ "11111111111111111111111111111111"
				+ "1111111111111111111111111"
				+ "1111111111111111111111111111"
				+ "111111111";
		
		double i = s.charAt(0);
		double p = Double.parseDouble(s);
		
		String o = Double.toString(i);
		
		System.out.println(s.charAt(2));  
		System.out.println(i-48);    // 这个也是精髓的不行啊　　　－４８　，因为多了个０　
		System.out.println(p);
		System.out.println(o);
	}
}
