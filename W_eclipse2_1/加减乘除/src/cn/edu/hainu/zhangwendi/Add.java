/**
 * 文件名：Add.java
 * 项目-包：一百位数的加减乘除 - cn.edu.hainu.wendizhang
 * 作者：张文迪
 * 创建日期：2014-9-15
 */
package cn.edu.hainu.zhangwendi;

/**
 * @author 张文迪
 * 类名：Add
 * 类说明：
 */
public class Add
{
	
	String[] num1 = new String[10000], 
	         num2 = new String[10000],
	         num3 = new String[10000];
	public  String[] add(String[] num10,String[] num20)
	{	
		int[]  add1 = new int [10000],
			   add2 = new int [10000],
			   add3 = new int [10000];
		int k1 = 0,
			k2 = 0, 
			k3 = 0,
			k4 = 0,
			s1 = 0,
			s2 = 0;
		for(int i =0;i<num10.length;i++ )
		{
			System.out.print(num10[i]);
		}
		System.out.println();
		for(int i =0;i<num20.length;i++ )
		{
			System.out.print(num20[i]);
		}
		System.out.println();
		
		if(num10[0].equalsIgnoreCase("-")||num10[0].equalsIgnoreCase("+"))
		{
			System.out.println();
			for(int i=0;i<num10.length-1;i++)
			{
				num10[i]=num10[i+1];
				
				System.out.print(num10[i]);
			}
			for(int i=0;i<num10.length-1;i++)
			{
				if(num10[i].equals("."))
				{
					break;
				}
				k1=i+1;
			} 
			k3 = num10.length-k1-2;
			System.out.println();
			//num1[num1.length]=null;
		}
		else 
		{
			for(int i=0;i<num10.length;i++)
			{
				if(num10[i].equals("."))
				{					
					break;
				}
				k1=i+1;
			} 
			k3 = num10.length-k1-1;
		}
		if(num20[0].equalsIgnoreCase("-")||num20[0].equalsIgnoreCase("+"))
		{
			for(int i=0;i<num20.length-1;i++)
			{
				num20[i]=num20[i+1];
				
				System.out.print(num20[i]);
			}
			for(int i=0;i<num20.length-1;i++)
			{
				if(num20[i].equals("."))
				{	
					break ;
				}			
				k2 = i+1;				
			}
			k4 = num20.length-k2-2;
			System.out.println();
		}
		else 
		{
			for(int i=0;i<num20.length;i++)
			{
				if(num20[i].equals("."))
				{
					break ;
				}
				k2 = i+1;				
			}
			k4 = num20.length-k2-1;          
		}
		
		System.out.println(k1);
		System.out.println(k2);
		System.out.println(k3);
		System.out.println(k4);
	    				
		if(k1>=k2)
		{
			s1 = k1;
			if(k3>=k4)
			{
				s2 = k3;
				for(int i = 0;i<k1+k3+1;i++)
					num1[i] = num10[i];
				for(int i=0;i<k1-k2;i++)
					num2[i] = "0";				   				    
				for(int i=k1-k2;i<k1+k4+1;i++)
					num2[i] = num20[i+k2-k1];
				for(int i=k1+k4+1;i<k1+k3+1;i++)
					num2[i] = "0";
			}
			else 
			{
				s2 = k4;
				for(int i=0;i<k1+k3+1;i++)
					num1[i] = num10[i];
				for(int i=k1+k3+1;i<k1+k4+1;i++)
					num1[i] = "0";
				for(int i=0;i<k1-k2;i++)
					num2[i] = "0";				   				    
				for(int i=k1-k2;i<k1+k4+1;i++)
					num2[i] = num20[i-k1+k2];
			}
		}
		else 
		{
			s1 = k2;
			if(k3>=k4)
			{
				s2 = k3;
				for(int i=0;i<k2-k1;i++)
					num1[i] = "0";
				for(int i=k2-k1;i<k2+k3+1;i++)
					num1[i] = num10[i+k1-k2];
				for(int i=0;i<k2+k4+1;i++)
					num2[i] = num20[i];				   				    
				for(int i=k2+k4+1;i<k2+k3+1;i++)
					num2[i] = "0";
			}
			else 
			{
				s2 = k4;
				for(int i=0;i<k2-k1;i++)
				    num1[i] = "0";
				for(int i=k2-k1;i<k2+k3+1;i++)
					num1[i] = num10[i+k1-k2];
				for(int i=k2+k3+1;i<k2+k4+1;i++)
					num1[i] = "0";
				for(int i=0;i<k2+k4+1;i++)
					num2[i] = num20[i];
			}
		}
										
       for(int i=0;i<s1;i++)
       {
    	   add1[i] = Integer.parseInt(num1[i]);
    	   add2[i] = Integer.parseInt(num2[i]);
       }
       for(int i=s1;i<s1+s2;i++)
       {
    	   add1[i] = Integer.parseInt(num1[i+1]);
    	   add2[i] = Integer.parseInt(num2[i+1]);
       }
         
       if(k3==-1&&k4==-1)//!!!!!!!!!!!!!   小数或是 整数！
    	   s2=0;
       
       for(int i=s1+s2-1;i>=0;i--)
       {
    	   add3[i+1] += add1[i]+add2[i];
    	   if(add3[i+1]>=10)
    	   {
    		   add3[i+1]-=10;
    		   add3[i]++;
    	   }
       }         
       if(add3[0]==0)
       {
    	   for(int i=0;i<s1;i++)
    		   num3[i] = Integer.toString(add3[i+1]);
    	   num3[s1] = ".";
       	   for(int i=s1+1;i<s1+s2+1;i++)
       		   num3[i] = Integer.toString(add3[i]);
       }
       else 
       {
		   for(int i=0;i<s1+1;i++)
			   num3[i] = Integer.toString(add3[i]);
		   num3[s1+1] = ".";
		   for(int i=s1+2;i<s1+s2+2;i++)
			   num3[i] = Integer.toString(add3[i-1]);
       }                         																
	   return num3;
	}	
	public String Print123456()
	{ 
		String s = "";
		for(int i = 0;i<num3.length;i++)
		{
			if(num3[i]!=null)
			s += num3[i];	  		
		}		
		return s;		
	}
}
