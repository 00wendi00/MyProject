/**
 *文件名:Test1.java
 *项目-包:数据结构于算法分析,Project1
 *作者:张文迪
 *时间:2015年3月31日
 */
package Project1;

/**
 * @author 张文迪
 * 类名:Test1
 * 类说明: 几个基本类型 计算 所运行的时间.
 */
public class Test1_0 {
	public static void main(String args[]){
		int k = 0;
		long time,end,start;
		start = System.currentTimeMillis();
		for(int i = 0;i<12000;i++){
			k = i/2;
		}
		end = System.nanoTime();
		time = end - start;
		System.out.println(time + " ms");
		System.out.println("~~~~~~");
		
		//int
		int m = 1;
		start = System.nanoTime();
		for(int i = 0;i<10000;i++){
			m = m*i/2;
		}
		end = System.nanoTime();
		time = end -start;
		System.out.println("int:"+time + " ns");
		
		//float
		float f = 1.0f;
		start = System.nanoTime();
		for(int i = 0 ;i<10000;i++){
			f = f*i/2;     //~!~~~~~~~~~
		}
		end = System.nanoTime();
		time = end - start;
		System.out.println("float:"+time+" ns");
		
		//double
		double d = 1.0d;
		start = System.nanoTime();
		for(int i = 0;i<10000;i++){
			d = d*i/2;
		}
		end = System.nanoTime();
		time = end -start;
		System.out.println("double:"+time+" ns");
		
		System.out.println("~~~~~~~");
		System.out.println((char)46);
	}
}












