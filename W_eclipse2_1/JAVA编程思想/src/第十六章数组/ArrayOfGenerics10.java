/**
 * �ļ�����Ex10.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-26
 */
package ��ʮ��������;
import java.util.*;

/**
 * @author ���ĵ�
 * ������Ex10
 * ��˵���� ��ϰ10   ʹ��2������   List<List<A>> llb = new ArrayList<List<A>>();
 */
public class ArrayOfGenerics10 {
	@SuppressWarnings("unchecked") //����Ҫ��~~  �����˱����ڵľ�����Ϣ!
	public static void main(String[] args) {
		List<List<String>> lls = new ArrayList<List<String>>();
		List<List> l = new ArrayList<List>();	
		// lls = (List<List<String>>)l; // error: inconvertible types
		lls.add(new ArrayList<String>());
		List<Object> lo = new ArrayList<Object>();
		// lo = lls; // error: incompatible types
		// Compile-time warning eliminated:
		List<List<A>> llb = new ArrayList<List<A>>();
		for(int i = 0; i < 3; i++) 
		{
			llb.add(new ArrayList<A>());
			for(int j = 0; j < 2; j++)
				llb.get(i).add(new A());
		}
		System.out.println(llb);	
	}
}
