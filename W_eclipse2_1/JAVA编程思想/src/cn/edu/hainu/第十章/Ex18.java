/**
 * �ļ�����Ex18.java
 * ��Ŀ-����JAVA���˼�� - cn.edu.hainu.��ʮ��
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-26
 */
package cn.edu.hainu.��ʮ��;

import cn.edu.hainu.��ʮ��.Ex18.TwoX.AnotherLevel;
import debug.Hahaha123456;



/**
 * @author ���ĵ�
 * ������Ex18
 * ��˵����
 */
public class Ex18
{
    private static class OneX implements One
    {
    	private int i=11;
    	public int value()
    	{
    		System.out.println(i);
    		return i;
    	}
		public void haha1()
		{
			System.out.println("haha1");
		}		
    }
    protected static class TwoX implements Two
    {
    	private String lable;
    	private TwoX(String whereto)
    	{
    		lable = whereto ;
    	}
    	public String readLable()
    	{
    		return lable;
    	}
    	public static void f(){};
    	static int x = 10;
    	static class AnotherLevel
    	{
    		public static void f()
    		{
    			int x = 10;
    			System.out.println(x);
    		}
    	}
    	/*
    	public AnotherLevel returnAnother()
    	{
    		return new AnotherLevel();
    	}
    	*/
		public void haha2()
		{
			System.out.println("haha2");
		}
		
    }
    public static One one()
    {
    	return new OneX(); 
    }
    public static Two two(String s)
    {
    	return new TwoX(s);
    }
    public static void main(String args[])
    {
    	One o = one();
    	Two t = two("�� ������");
    	((OneX) o).value();
    	o.haha1();
    	 
    	t.haha2();
    	//((TwoX) t).returnAnother();
		AnotherLevel.f();
    }
}
interface One
{
	void haha1();
}
interface Two
{
	void haha2();
}
