/**
 * 文件名：Feibolaqishu.java
 * 项目-包：JAVA编程思想 - 第四章
 * 作者：张文迪
 * 创建日期：2014-9-4
 */
package 第四章;

import javax.swing.JOptionPane;

/**
 * @author 张文迪
 * 类名：Feibolaqishu
 * 类说明：练习9.  + String 强制转换为 int
 */
public class Feibolaqishu
{
    public static void main(String args[])
    {
    	
    	int a;
    	a = Integer.parseInt(JOptionPane.showInputDialog(5));
    	//a = Integer.parseInt(args[0]);
    	int s = 1,k = 0,t=0;
    	for(int i = 0;i<a;i++)
    	{
    		
    		System.out.print(s+" ");
    		t=s;
    		s=k+s;
    		k=t;
		
    	}
    }
}
