/**
 * �ļ�����Test.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���������о�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-30
 */
package ��ʮ���������о�����;

/**
 * @author ���ĵ�
 * ������Test
 * ��˵����
 */
public abstract class Test<C> 
{
	  String name;
	  public Test(String name) { this.name = name; }
	  // Override this method for different tests.
	  // Returns actual number of repetitions of test.
	  abstract int test(C container, TestParam tp);
}
