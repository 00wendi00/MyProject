/**
 * 文件名：Test.java
 * 项目-包：打地鼠2 - Test
 * 作者：张文迪
 * 创建日期：2014-6-7
 */
package Test;



/**
 * @author 张文迪
 * 类名：Test
 * 类说明：
 */
public class Test 
{
   public static void main(String args[])
   {	                       
      ClientView frame = new ClientView();  //创建窗体	  
      frame.setVisible(true);             //显示窗体
      new Thread(frame).start();          //启动线程
   }
}
