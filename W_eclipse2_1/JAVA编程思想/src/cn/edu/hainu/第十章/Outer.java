/**
 * �ļ�����Outer.java
 * ��Ŀ-����JAVA���˼�� - cn.edu.hainu.�ھ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-25
 */
package cn.edu.hainu.��ʮ��;
/**
 * @author ���ĵ�
 * ������Outer
 * ��˵������ϰ 1 , 3
 */
public class Outer
{
	private  String s = "!!!!!!";	
    class Inner
    {
    	public void ha1112()
    	{
    		System.out.println("~~~~~~~~");
    	}
    	public String toString()
    	{
    		System.out.println(s);
    		return s;
    	}
    }
    public Inner ha111111()
    {
    	return new Inner();
    }
    public static void main(String args[])
    {
    	Outer outer = new Outer();
    	Inner inner = outer.ha111111();
    	inner.ha1112();
    	inner.toString();
    }
}
