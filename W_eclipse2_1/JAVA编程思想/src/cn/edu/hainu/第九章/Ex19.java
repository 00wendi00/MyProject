/**
 * 文件名：Ex19.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第九章
 * 作者：张文迪
 * 创建日期：2014-9-24
 */
package cn.edu.hainu.第九章;

import java.util.Random;

/**
 * @author 张文迪
 * 类名：Ex19
 * 类说明：练习19 ：  抛硬币一次，摇色子一次。！！！！！     工厂方法！
 */
public class Ex19
{
    public static void playcorn(CornFactory factory)
    {
    	Corn c = factory.getCorn();
    	while(c.result());
    }
    public static void main(String args[])
    {
    	int z = 0,
    	    f = 0,
    	    p1 = 0,
    	    p2 = 0,
    	    p3 = 0,
    	    p4 = 0,
    	    p5 = 0,
    	    p6 = 0;
    	Random random = new Random();
    	for(int i =0 ;i<500;i++)
    	{
    		if(random.nextInt(2) == 0)   
    		{
    			z++;
    			System.out.println("正");
    			playcorn(new CornZFFactory());
    		}
    		else 
    		{
    			f++;
    			System.out.println("反");
    			playcorn(new CornZFFactory());  		
    		}
    		switch (random.nextInt(6))
			{
			case 0:{
				       p1++;
				       playcorn(new CornSixFactory());
				       System.out.println(1);
				   }				
				break;
			case 1:{
						p2++;
					    playcorn(new CornSixFactory());
						System.out.println(2);
			       }
				break;
			case 2:{
						p3++;
						playcorn(new CornSixFactory());
						System.out.println(3);
					}			
				break;
			case 3:{
						p4++;
						playcorn(new CornSixFactory());
						System.out.println(4);
					}
				break;
			case 4:{
						p5++;
						playcorn(new CornSixFactory());
						System.out.println(5);
				   }
				break;
			case 5:{
						p6++;
						playcorn(new CornSixFactory());
						System.out.println(6);
					}
				break;
			default:
				break;
			}   	    
    	}
    	System.out.println("正"+z+"  反"+f);
    	System.out.println(1+":"+p1+" "+2+":"+p2+" "+3+":"+p3+" "+4+":"+p4+" "+5+":"+p5+" "+6+":"+p6);
    	
    }
}
interface Corn{boolean result();}
interface CornFactory{Corn getCorn();}

class CornZF implements Corn
{
	private int i = 1;
	public boolean result()
	{
		return --i !=0 ;
	}	
}
class CornZFFactory implements CornFactory
{
	public Corn getCorn()
	{
		return new CornZF();
	}	
}

class CornSix implements Corn
{
	private int i = 1;
	public boolean result()
	{			
		return --i != 0;
	}	
}
class CornSixFactory implements CornFactory
{
	public Corn getCorn()
	{
		return new CornSix();
	}	
}
