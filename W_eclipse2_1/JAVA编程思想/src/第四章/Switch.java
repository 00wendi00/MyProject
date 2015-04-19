/**
 * 文件名：Switch.java
 * 项目-包：JAVA编程思想 - 第四章
 * 作者：张文迪
 * 创建日期：2014-9-4
 */
package 第四章;

/**
 * @author 张文迪
 * 类名：Switch
 * 类说明：练习8  。 switch
 */
public class Switch
{
    public static void main(String args[])
    {
    	for(int i=1;i<6;i++)
    	{
    		switch (i)
			{
			case 1:
			case 2:
			case 3:System.out.println("小于4");break;
			case 4:System.out.println("等于4");break;
			default:System.out.println("尼玛");
				break;
			}
    	}
    }
}
