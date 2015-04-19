/**
 * �ļ�����MyTest.java
 * ��Ŀ-�������� - ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-20
 */
package ��������;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import ���԰�.A;
import ���԰�.HiddenMyclass;

/**
 * @author ���ĵ�
 * ������MyTest
 * ��˵������14 �£���ϰ25���ӿ���������Ϣ //final���ε����ܸ�д~~
 */
public class MyTest
{
	public static void main(String args[]) throws Exception
	{
		A a = HiddenMyclass.makeA();
		a.f1();
		System.out.println(a.getClass().getName());
	
		Method g = a.getClass().getDeclaredMethod("f2");
		g.setAccessible(true);
		g.invoke(a);
		System.out.println();
		
		Field f = a.getClass().getDeclaredField("i");
		f.setAccessible(true);
		f.getInt(a);
		f.setInt(a, 50);
		System.out.println("i = "+f.getInt(a));
				
		f = a.getClass().getDeclaredField("k");
		f.setAccessible(true);
		f.getInt(a);
		f.setInt(a, 555);
		System.out.println("k = "+f.getInt(a));
		
		f = a.getClass().getDeclaredField("s");		
		f.setAccessible(true);
		System.out.println("s = "+f.get(a));
		f.get(a);
		f.set(a ,"!!!!!!!!!!!");
		System.out.println("s = "+f.get(a));
		System.out.println(a);//final���ε����ܸ�д~~
	}
}
