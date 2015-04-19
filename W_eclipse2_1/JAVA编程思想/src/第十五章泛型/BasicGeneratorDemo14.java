/**
 * �ļ�����BasicGeneratorDemo.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���·���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-21
 */
package ��ʮ���·���;

import net.mindview.util.BasicGenerator;
import net.mindview.util.Generator;

/**
 * @author ���ĵ�
 * ������BasicGeneratorDemo
 * ��˵������ϵ14~~~~
 */
public class BasicGeneratorDemo14
{
	public static void main(String args[])
	{
		Generator<CountedObject> gen = new BasicGenerator<CountedObject>(CountedObject.class);
		for(int i = 0; i < 4; i++)
			System.out.println(gen.next());
	}
}
class CountedObject
{
	private static long counter = 0;
	private final long id = counter++;
	public long id() {return id;}
	public String toString() {return "Countedobject "+id;} 
}
