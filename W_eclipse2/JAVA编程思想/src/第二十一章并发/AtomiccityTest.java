/**
 * �ļ�����AtomiccityTest.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮһ�²���
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-5
 */
package �ڶ�ʮһ�²���;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ���ĵ�
 * ������AtomiccityTest
 * ��˵������ϰ12 ~~~��֤��synchronized�����˼���������         �� ��ȫ��  �� 
 *     	           ������������ĳ���ض�����~synchronized��������ͬһ����~��ֹ�������ͬʱ���ʱ�����Ϊ�����ڴ�---
 *     	           �����������Զ�λ����++  ÿ���뿪��ʱ�� --   ��������Ϊ0
 *         ����������ֻ��һ��synchronized������ʱ������г���һ�����������ٽ�����~��
 *         ����� ������synchronized���ᱻ������ԣ��ʱ���ͬ�����е���ط������������Ŀ
 */
public class AtomiccityTest implements Runnable
{
	private int i = 0;
	public synchronized int getvalue() {return i ;}
	private synchronized void evenIncrement() {i++;i++;}
	public void run(){
		while(true)
			evenIncrement();
	}
	public static void main(String args[]){
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomiccityTest at = new AtomiccityTest();
		exec.execute(at);
		while(true){
			int val = at.getvalue();
			if(val%2 !=0)
			{
				System.out.println(val);
				System.exit(0);
			}
		}
	}
}
