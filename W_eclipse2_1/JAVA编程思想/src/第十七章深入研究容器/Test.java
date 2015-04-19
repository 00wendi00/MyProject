/**
 * 文件名：Test.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-30
 */
package 第十七章深入研究容器;

/**
 * @author 张文迪
 * 类名：Test
 * 类说明：
 */
public abstract class Test<C> 
{
	  String name;
	  public Test(String name) { this.name = name; }
	  // Override this method for different tests.
	  // Returns actual number of repetitions of test.
	  abstract int test(C container, TestParam tp);
}
