/**
 * 文件名：bpp6_5.java
 * 项目-包：测试 - 测试包
 * 作者：张文迪
 * 创建日期：2014-5-17
 */
package 测试包;

/**
 * @author 张文迪
 * 类名：bpp6_5
 * 类说明：
 */
public class bpp6_5            //定义主类
{
     public static void main(String args[])
     {
          int a[]={8,23,7,88,9,23};           //定义一维数组
          leastnumb Min=new leastnumb();      //创建对象
          Min.least(a);             //将一维数组a传入least()方法
     }
}
class leastnumb           //定义另一个类
{
     public void least(int array[])      //参数array[]接受一维整形数组
     {
          int temp=array[0];
          for(int i=0;i<array.length;i++)
          if(temp>array[i])
          temp=array[i];
          System.out.println("最小的数为："+temp);
     }
}