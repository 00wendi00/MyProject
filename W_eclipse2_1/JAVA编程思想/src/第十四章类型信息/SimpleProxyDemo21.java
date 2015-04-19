/**
 * 文件名：SimpleProxyDemo21.java
 * 项目-包：JAVA编程思想 - 第十四章类型信息
 * 作者：张文迪
 * 创建日期：2014-10-19
 */
package 第十四章类型信息;

/**
 * @author 张文迪
 * 类名：SimpleProxyDemo21
 * 类说明：
 */
import static net.mindview.util.Print.*;
import java.util.*;

interface Interface 
{
	void doSomething();
	void somethingElse(String arg);
}

class RealObject implements Interface 
{
	public void doSomething() { print("doSomething"); }
	public void somethingElse(String arg) 
	{
		print("somethingElse " + arg);
	}
}

class SimpleProxy implements Interface 
{
	private Interface proxied;
	private static int doCount = 1;
	private static int sECount = 1;
	public SimpleProxy(Interface proxied)
	{
		this.proxied = proxied;
	}
	public void doSomething() 
	{ 
		long timeIn = new Date().getTime();
		print("Time called doSomething() " + doCount + ": " + timeIn + " msecs");
		print("on " + new Date());
		doCount++;
		proxied.doSomething();
		print("Call-return time = " + ((new Date().getTime()) - timeIn) + " msecs");
	}
	public void somethingElse(String arg) 
	{
		long timeIn = new Date().getTime();
		print("Time called somethingElse() " + sECount + ": " + timeIn + " msecs");
		print("on " + new Date());
		sECount++;
		proxied.somethingElse(arg);
		print("Call-return time = " + ((new Date().getTime()) - timeIn) + " msecs");
	}
}

class SimpleProxyDemo21 
{
	public static void consumer(Interface iface) 
	{
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	public static void main(String[] args) {
		consumer(new RealObject());
		print();
		consumer(new SimpleProxy(new RealObject()));
		print();
		consumer(new SimpleProxy(new RealObject()));
		print();
		consumer(new SimpleProxy(new RealObject()));					
	}
}
