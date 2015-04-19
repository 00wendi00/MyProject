/**
 * 文件名：Mychat.java
 * 项目-包：JAVA编程思想 - 第七章复用类
 * 作者：张文迪
 * 创建日期：2014-9-9
 */
package 第七章复用类;

import java.util.Random;

/**
 * @author 张文迪
 * 类名：Mychat
 * 类说明： 练习18.static 强调 （一次）只有一份     （多次创建对象时不同）。final 强调 为常量，不变。。。static final则是   只有一份的 常量。
 *      练习19.
 */
public class Mychat
{   static int i=0;
	static Random random = new Random(47);
	private static final int VAl_1 = random.nextInt(25);
	private final  int v1 = random.nextInt(20) ;
	private static final Value10 value11 = new Value10(20);
	private final Value10 value12 = new Value10(i);
	private final int k;
     public static void main(String args[])
     { 
    	 Mychat mychat0 = new Mychat();
    	 System.out.println(VAl_1);
    	 System.out.println(mychat0.v1);

    	 
    	 Mychat mychat1 = new Mychat();
    	 System.out.println(VAl_1);
     	 System.out.println(mychat1.v1);
    	 
     	 System.out.println();
    	 
     	// mychat1.i++;
       
    	 mychat1.value11.i++;         
    	 System.out.println(mychat1.value11.i);
    	 System.out.println(mychat1.value11.i++);
    	 System.out.println(mychat1.value11.i);
     }
     public Mychat()
     {
    	 k = 5;
    	 // k++;
     }
}

class Value10
{
    int i;
    public Value10(int i)
    {
    	this.i = i;
    }
}

