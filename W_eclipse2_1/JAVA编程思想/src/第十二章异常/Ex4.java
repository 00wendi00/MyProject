/**
 * �ļ�����Ex4.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����쳣
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-11
 */
package ��ʮ�����쳣;

import cn.edu.hainu.��ʮ��.sunShine;

/**
 * @author ���ĵ�
 * ������Ex4
 * ��˵������ϰ4��28~~~����RuntimeException�������࣬����ֱ���׳��������ý����쳣������try,catch����throws��
 */
public class Ex4 
{
	public static void f() throws My1Exception 
	{
		System.out.println("f()");
		throw new My1Exception("Ouch from f()");// �������~   s  
	}
	public static void main(String[] args) 
	{
		f();
		/*try 
		{
			f();	
		} 
		catch(My1Exception e) 
		{
			System.err.println("Caught Exception4");
			e.printStackTrace();
			e.showS();
		} 
		*/
	}	
}
class My1Exception extends RuntimeException
{
	private String s ;
	My1Exception() {}
	My1Exception(String s)
	{
		super(s);
		System.out.println("Exception4~~~~~~~~");
		this.s = s;
	}
	protected void showS() { 
		System.out.println("Message from Exception4: " + s);
	}
}