/**
 * 文件名：Sets17.java
 * 项目-包：JAVA编程思想 - 第十五章泛型
 * 作者：张文迪
 * 创建日期：2014-10-21
 */
package 第十五章泛型;

/**
 * @author 张文迪
 * 类名：Sets17
 * 类说明：联系17~ 接受 EnumSet +  使用clone()
 */
import static net.mindview.util.Print.print;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class Sets17 {	
	public static <T> Set<T> union(Set<T> a, Set<T> b) {		
		try {
			if(a instanceof EnumSet) {
				Set<T> result = ((EnumSet<T>)a).clone();
				result.addAll(b);
    				return result;
				}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
		Set<T> result = new HashSet<T>(a);
    		result.addAll(b);
    		return result;
	}	
  	public static <T> Set<T> intersection(Set<T> a, Set<T> b) {
		try {
			if(a instanceof EnumSet) {
				Set<T> result = ((EnumSet<T>)a).clone();
				result.retainAll(b);
    				return result;
				}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
    		Set<T> result = new HashSet<T>(a);
    		result.retainAll(b);
    		return result;
  	}	
  	// Subtract subset from superset:
  	public static <T> Set<T>  difference(Set<T> superset, Set<T> subset) {
		try {
			if(superset instanceof EnumSet) {
				Set<T> result = ((EnumSet<T>)superset).clone();
				result.removeAll(subset);
    				return result;
				}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
    		Set<T> result = new HashSet<T>(superset);
    		result.removeAll(subset);
    		return result;
  	}
  	// Reflexive--everything not in the intersection:
  	public static <T> Set<T> complement(Set<T> a, Set<T> b) {
    		return difference(union(a, b), intersection(a, b));
  	}
	public static void main(String[] args) {
		Set<Watercolors> set1 =
			EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
		Set<Watercolors> set2 =
			EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
		print("set1: " + set1);
		print("set2: " + set2);
		print("union(set1, set2): " + union(set1, set2));
		Set<Watercolors> subset = intersection(set1, set2);
		print("intersection(set1, set2): " + subset);
		print("difference(set1, set2): " + 
			difference(set1, set2));
		print("difference(set2, subset): " + 
			difference(set2, subset));
		print("complement(set1, set2): " + 
			complement(set1, set2));
	}
} 
