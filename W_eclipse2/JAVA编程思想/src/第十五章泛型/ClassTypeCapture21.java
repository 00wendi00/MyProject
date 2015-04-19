/**
 * 文件名：ClassTypeCapture.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-21
 */
package 第十五章泛型;


import java.util.HashMap;
import java.util.Map;
import static org.greggordon.tools.Print.*;

/**
 * @author 张文迪
 * 类名：ClassTypeCapture
 * 类说明：
 */
class Building {}
class House extends Building {}
public class ClassTypeCapture21<T>
{
	Class<?> kind;
	Map<String, Class<?>> map ;
	public ClassTypeCapture21(Class<?> kind) {this.kind = kind;}
	public ClassTypeCapture21(Class<?> kind, Map<String,Class<?>> map) {
		this.kind = kind;
		this.map = map;
	}
	public boolean f(Object arg)
	{
		return kind.isInstance(arg);
	}
	void addType(String typename,Class<?> kind)
	{
		map.put(typename, kind);
	}
	public Object creatNew(String typename)
	throws IllegalAccessException, InstantiationException {
		if(map.containsKey(typename))
			return map.get(typename).newInstance();			
		System.out.println(typename + " class not available");
		return null;
	}
	
	public static void main(String[] args) {
		ClassTypeCapture21<Building> ctt1 = new ClassTypeCapture21<Building>(Building.class);
		println(ctt1.f(new Building()));
		println(ctt1.f(new House()));
		ClassTypeCapture21<House> ctt2 = new ClassTypeCapture21<House>(House.class);
		println(ctt2.f(new Building()));
		println(ctt2.f(new House()));
		ClassTypeCapture21<Building> ct = 
		new ClassTypeCapture21<Building>(Building.class, new HashMap<String, Class<?>>());
		ct.addType("House", House.class);
		ct.addType("Building", Building.class);
		println("ct.map = " + ct.map);
		try {
			Building b = (Building)ct.creatNew("Building");
			House h = (House)ct.creatNew("House");
			print("b.getClass().getName(): ");
			println(b.getClass().getName());
			print("h.getClass().getName(): ");
			println(h.getClass().getName());
			print("House h is instance House: ");
			println(h instanceof House);
			print("House h is instance of Building: ");
			println(h instanceof Building);
			print("Building b is instance of House: ");
			println(b instanceof House);
			ct.creatNew("String");  // String class not available
		} catch(IllegalAccessException e) {
			println("IllegalAccessException in main");
		} catch(InstantiationException e) {
			println("InstantiationException in main");
		}		
	}
}
