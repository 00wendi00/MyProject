/**
 *�ļ���:Test1.java
 *��Ŀ-��:���ݽṹ���㷨����,Project1
 *����:���ĵ�
 *ʱ��:2015��3��31��
 */
package Project1;

/**
 * @author ���ĵ�
 * ����:Test1
 * ��˵��: ������������ ���� �����е�ʱ��.
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












