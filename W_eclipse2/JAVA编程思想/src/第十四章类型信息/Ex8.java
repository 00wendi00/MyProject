/**
 * �ļ�����Ex8.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����������Ϣ
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-18
 */
package ��ʮ����������Ϣ;

/**
 * @author ���ĵ�
 * ������Ex8��9
 * ��˵���� �ݹ�  Hierarchy(Object o) + ��ϰ9 Class.getDeclaredFields()�������Ϣ��
 */
class A {int i = 0;float  f;}

class B extends A {int a = 0;}

class C extends B {int b = 0;}

public class Ex8 
{
	public static void Hierarchy(Object o) 
	{
		if(o.getClass().getSuperclass() != null) 
		{		
			System.out.println(o.getClass() + " is a subclass of " + 
				o.getClass().getSuperclass()); 
			Object[] fields = o.getClass().getDeclaredFields();
			for(Object obj : fields)
				System.out.println(obj+" ");
			try {
				Hierarchy(o.getClass().getSuperclass().newInstance());
			} catch(InstantiationException e) {
				System.out.println("Unable to instantiate obj");
			} catch(IllegalAccessException e) {
				System.out.println("Unable to access");
			}
		} 
	}		
	public static void main(String[] args) 
	{
		Hierarchy(new C());
	}
}
