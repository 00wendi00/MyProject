/**
 * 文件名：TestParam.java
 * 项目-包：JAVA编程思想 - 第十七章深入研究容器
 * 作者：张文迪
 * 创建日期：2014-10-30
 */
package 第十七章深入研究容器;

/**
 * @author 张文迪
 * 类名：TestParam
 * 类说明：
 */
public class TestParam {
	  public final int size;
	  public final int loops;
	  public TestParam(int size, int loops) {
	    this.size = size;
	    this.loops = loops;
	  }
	  // Create an array of TestParam from a varargs sequence:
	  public static TestParam[] array(int... values) {
	    int size = values.length/2;
	    TestParam[] result = new TestParam[size];
	    int n = 0;
	    for(int i = 0; i < size; i++)
	      result[i] = new TestParam(values[n++], values[n++]);
	    return result;
	  }
	  // Convert a String array to a TestParam array:
	  public static TestParam[] array(String[] values) {
	    int[] vals = new int[values.length];
	    for(int i = 0; i < vals.length; i++)
	      vals[i] = Integer.decode(values[i]);
	    return array(vals);
	  }
	}
