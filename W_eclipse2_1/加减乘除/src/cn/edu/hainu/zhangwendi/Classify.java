/**
 * �ļ�����Classify.java
 * ��Ŀ-�����Ӽ��˳� - cn.edu.hainu.zhangwendi
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-18
 */
package cn.edu.hainu.zhangwendi;

/**
 * @author ���ĵ�
 * ������Classify
 * ��˵����
 */
public class Classify
{
	public String addClass(String[] num1,String[] num2,int k)
	{
		String s = null;
		Add add000 = new Add();	
		Minus minus000 = new Minus();
		Multiply multiply000 = new Multiply();
		if(k==1)
		{
			if(num1[0].equalsIgnoreCase("-"))
			{
				if(num2[0].equalsIgnoreCase("-"))
				{												
					add000.add(num1, num2);			
					s = add000.Print123456();
					return s="-"+s;
				}
				else 
				{
					minus000.minus(num1, num2);
					s = minus000.Print123456();
					return s;
				}				
			}
			else  
			{				
				if(num2[0].equalsIgnoreCase("-"))
				{
					minus000.minus(num1, num2);
					s = minus000.Print123456();
					return s;
				}
				else 
				{												
					add000.add(num1, num2);
					System.out.println(s);				
					s = add000.Print123456();
					return s;				
				}
			}			
		}	
		if(k==2)
		{
			if(num1[0].equalsIgnoreCase("-"))
			{
				if(num2[0].equalsIgnoreCase("-"))
				{												
					minus000.minus(num1, num2);
					s = minus000.Print123456();
					return s;
				}
				else 
				{
					add000.add(num1, num2);
					System.out.println(s);				
					s = add000.Print123456();
					return s="-"+s;
				}				
			}
			else 
			{
				if(num2[0].equalsIgnoreCase("-"))
				{
					add000.add(num1, num2);
					System.out.println(s);				
					s = add000.Print123456();
					return s;
				}
				else
				{
					minus000.minus(num1, num2);
					s = minus000.Print123456();
					return s;
				}
			}				
		}
		if(k==3)
		{
			
			if(num1[0].equalsIgnoreCase("-"))
			{
				if(num2[0].equalsIgnoreCase("-"))
				{
					multiply000.multiply(num1, num2);
					s = multiply000.Print123456();
					return s;
				}
				else 
				{
					multiply000.multiply(num1, num2);
					s = multiply000.Print123456();
					return s = "-"+s ;
				}
			}
			else
			{
				if(num2[0].equalsIgnoreCase("-"))
				{
					multiply000.multiply(num1, num2);
					s = multiply000.Print123456();
					return s = "-"+s ;
				}
				else 
				{
					multiply000.multiply(num1, num2);
					s = multiply000.Print123456();
					return s;
				}
			}
		}
		return s;
	}
}
