/**
 * 文件名：SimpleDynamicProxy22.java
 * 项目-包：JAVA编程思想 - 第十四章类型信息
 * 作者：张文迪
 * 创建日期：2014-10-19
 */
package 第十四章类型信息;

/**
 * @author 张文迪
 * 类名：SimpleDynamicProxy22
 * 类说明：
 */
import java.lang.reflect.*;
import java.util.*;

class DynamicProxyHandler implements InvocationHandler 
{
	private Object proxied;
	public DynamicProxyHandler(Object proxied) 
	{
		this.proxied = proxied;
	}
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable 
	{
		long timeIn = new Date().getTime();
		System.out.println("**** proxy: " + proxy.getClass() +
			", method: " + method + ", args: " + args +
			", invoked at " + timeIn + " on " + (new Date()));
		if(args != null)
			for(Object arg : args)
				System.out.println("  " + args);
		long timeOut = new Date().getTime();
		System.out.println("Method call-return time: " + (timeOut - timeIn) + " msecs");
		return method.invoke(proxied, args);
		
		
	}
}

class SimpleDynamicProxy22 
{
	public static void consumer(Interface iface) 
	{
		iface.doSomething();
		iface.somethingElse("bonobo");
	}
	public static void main(String[] args) 
	{
		RealObject real = new RealObject();
		consumer(real);
		// Insert a proxy and call again:
		Interface proxy = (Interface)Proxy.newProxyInstance(
			Interface.class.getClassLoader(),
			new Class[]{ Interface.class },
			new DynamicProxyHandler(real));
		consumer(proxy);
	}
}
