package 第一二章;
/**
 * 文件名：ShowProperties.java
 * 项目-包：测试2 - 
 * 作者：张文迪
 * 创建日期：2014-9-2
 */

/**
 * @author 张文迪
 * 类名：ShowProperties
 * 类说明：listing properties
 */
public class ShowProperties
{
      public static void main(String args[])
      {
    	  System.getProperties().list(System.out);
    	  System.out.println(System.getProperty("user.name"));
    	  System.out.println(System.getProperty("java.labrary.path"));
      }
}
