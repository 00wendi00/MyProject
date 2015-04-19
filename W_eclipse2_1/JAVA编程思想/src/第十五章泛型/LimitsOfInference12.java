/**
 * 文件名：Ex12.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-21
 */
package 第十五章泛型;


/**
 * @author 张文迪
 * 类名：Ex12
 * 类说明：
 */
import typeinfo.pets.*;
import java.util.*;
import net.mindview.util.*;

public class LimitsOfInference12 {
	static void f(Map<Person, List<? extends Pet>> petPeople) {}
	public static void main(String[] args) {
		f(New.<Person, List<? extends Pet>>map()); 
	}
}
