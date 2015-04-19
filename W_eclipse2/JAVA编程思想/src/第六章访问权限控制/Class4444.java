/**
 * 文件名：Class4444.java
 * 项目-包：JAVA编程思想 - 第六章访问权限控制
 * 作者：张文迪
 * 创建日期：2014-9-7
 */
package 第六章访问权限控制;

/**
 * @author 张文迪
 * 类名：Class4444
 * 类说明：
 */
public class Class4444
{
    public void Haha111()
    {
    	System.out.println(111);
    }
    protected void Haha222()
    {
    	System.out.println(222);
    }
    void Haha333()
    {
    	System.out.println(333);
    }
    private void Haha444()
    {
    	System.err.println(444);
    }
}
