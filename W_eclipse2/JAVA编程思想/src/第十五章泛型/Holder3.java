/**
 * �ļ�����Holder3.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���·���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-20
 */
package ��ʮ���·���;

/**
 * @author ���ĵ�
 * ������Holder3
 * ��˵������ϰ1~~~
 */
import typeinfo.pets.*;

public class Holder3<T> {
	private T a;
	public Holder3(T a) { this.a = a; }
	public void set(T a) { this.a = a; }
	public T get() { return a; }
	public static void main(String[] args) {
		Holder3<Pet> h3 = 
			new Holder3<Pet>(new Pet());
		Pet a = h3.get(); // No cast needed
		System.out.println(h3.get());
		// can also hold a subclass of Pet:
		h3.set(new Dog());
		System.out.println(h3.get());
		// can also hold a sububclass of Pet:

		
	}
}