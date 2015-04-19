/**
 * 文件名：ClassTypeCreator22.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-25
 */
package 第十五章泛型;

/**
 * @author 张文迪
 * 类名：ClassTypeCreator22
 * 类说明：  //  这章学 傻了。 放几天 回头看
 */
import java.util.*;
import java.lang.reflect.*;
import static org.greggordon.tools.Print.*;

class Building1 {}
class House1 extends Building1 
{
	private String location;
	private Integer area;
	public House1() { location = null; }
	public House1(Integer area) { this.area = area; }
	public House1(String location) 
	{
		this.location = location;
	}
	public House1(String location, Integer area) 
	{
		this.location = location;
		this.area = area;
	}
	public String toString() 
	{
		return "House" + ((location == null) ? "" :  " in " + location) +
			((area != null) ? (", "+ area + " sqft") : "");
	}
}

public class ClassTypeCreator22<T> 
{
	Class<?> kind;
	public ClassTypeCreator22(Class<?> kind) 
	{
		this.kind = kind;
	}
	public Object createNew(String typename) 
		throws 	IllegalAccessException, 
			InstantiationException, 
			ClassNotFoundException 
	{
		return Class.forName(typename).newInstance();
	}	
	/** To create instance of typename with constructors taking arguments args: */
	public Object createNew(String typename, Object... args) 
		throws 	IllegalAccessException, 
			InstantiationException, 
			ClassNotFoundException,
			NoSuchMethodException,
			InvocationTargetException 
	{
		switch(args.length) 
		{
		case 1 : return Class.forName(typename).getConstructor(args[0].getClass()).newInstance(args[0]);
		case 2 : return Class.forName(typename).getConstructor(args[0].getClass(), args[1].getClass()).
			newInstance(args[0], args[1]);
		}
		return null;
	}
	public static void main(String[] args)
	{
		ClassTypeCreator22<Building1> ctcb = new ClassTypeCreator22<Building1>(Building1.class);
		ClassTypeCreator22<House1> ctch = new ClassTypeCreator22<House1>(House1.class);
		try {
			Building1 b = (Building1)ctcb.createNew("Building");
			// To show we can access and print House constructors:
			println("House constructors:");
			Constructor[] ctors = House1.class.getConstructors();
			for(Constructor ctor : ctors) println(ctor);
			// create 3 new House objects:
			House1 h = (House1)ctch.createNew("House", "Hawaii");
			House1 h2 = (House1)ctch.createNew("House", 3000);
			House1 h3 = (House1)ctch.createNew("House", "Manila", 5000);
			println("Constructed House objects:");
			println(h);
			println(h2);
			println(h3);
		} catch(IllegalAccessException e) {
			println("IllegalAccessException in main");
		} catch(InstantiationException e) {
			println("InstantiationException in main");
		} catch(ClassNotFoundException e) {
			println("ClassNotFoundException in main");
		} catch(NoSuchMethodException e) {
			println("NoSuchMethodException in main");
		} catch(InvocationTargetException e) {
			println("InvocationTargetException in main");
		}		
	}
}