/**
 * 文件名：All111.java
 * 项目-包：JAVA编程思想 - 第三章
 * 作者：张文迪
 * 创建日期：2014-9-3
 */
package 第三章;

/**
 * @author 张文迪
 * 类名：All111
 * 类说明：练习11,12,13---移位操作符
 */
public class All111
{
    public static void main(String args[])
    {
    	
    	int k;
    	k = 0xfedc;
    	System.out.println(k);
    	System.out.println(Integer.toBinaryString(k));
    	k>>=4;
    	System.out.println(Integer.toBinaryString(k));
    	k>>=4;
    	System.out.println(Integer.toBinaryString(k));
    	k>>=4;
    	System.out.println(Integer.toBinaryString(k));
    	k>>=4;
    	System.out.println(Integer.toBinaryString(k));
    	k>>=4;
    	System.out.println(Integer.toBinaryString(k));
    	
    	System.out.println();
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	int i;
        i = 0xffff;
        System.out.println(i);
        System.out.println(Integer.toBinaryString(i));
        i<<=2;
        System.out.println(Integer.toBinaryString(i));
        i>>>=4;
        System.out.println(Integer.toBinaryString(i));
        i>>>=4;
        System.out.println(Integer.toBinaryString(i));
        i>>>=4;
        System.out.println(Integer.toBinaryString(i));
        i>>>=4;
        System.out.println(Integer.toBinaryString(i));
        i>>>=4;
        System.out.println(Integer.toBinaryString(i));
        i>>>=4;
        System.out.println(Integer.toBinaryString(i));
        
        System.out.println();
        
        
        
        
        
        
        
        
        
        char c;
        c = 'i';
        System.out.println(Integer.toBinaryString('i'));
        System.out.println(Integer.toBinaryString(c));
        
        c = '\u0049';
        System.out.println(Integer.toBinaryString(c));
       
        c = 'k';
        System.out.println(Integer.toBinaryString(c));
    }
}
