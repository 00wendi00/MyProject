/**
 * �ļ�����Ex25.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����쳣
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-12
 */
package ��ʮ�����쳣;

/**
 * @author ���ĵ�
 * ������Ex25
 * ��˵����
 */
public class Ex25
{
	public static void main(String args[]) 
	{		
		A a = new C();
		try 
		{
			a.f();
		}	
		catch(LevelThreeException e3)
		{
			System.out.println("Caught e3");			
		}	
		catch(LevelTwoException e2) 
		{
			System.out.println("Caught e2");
		}	
		catch(LevelOneException e1) 
		{
			System.out.println("Caught e1");
		}
	}
}
class A 
{
	void f() throws LevelOneException
	{
		throw new LevelOneException();
	}
}
class B extends A
{
	void f() throws LevelTwoException
	{
		throw new LevelTwoException();
	}
}
class C extends B
{
	void f() throws LevelThreeException
	{
		throw new LevelThreeException();
	}
}
class LevelOneException extends Exception {}
class LevelTwoException extends LevelOneException {}
class LevelThreeException extends LevelTwoException {} 