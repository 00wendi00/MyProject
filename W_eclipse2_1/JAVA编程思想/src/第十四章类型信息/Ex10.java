/**
 * �ļ�����Ex10.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����������Ϣ
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-18
 */
package ��ʮ����������Ϣ;

/**
 * @author ���ĵ�
 * ������Ex10
 * ��˵�����ж�char�����Ƿ�Ϊ�������ͻ����
 * 		1.����isPrimitive()��ʱ�򷵻�ֵΪfalse(���ǻ�����������);��
 *��		2.����isArray()��ʱ�򷵻�ֵ��true��������һ�������Ķ���
 *		3.����ΪʲôҪ�ų����飬��ǣ�ö�٣�ԭʼ���ͣ��д�����
 */
public class Ex10
{
	public static void main(String args[])
	{
		char[] i = new char[10];
		System.out.println(i.getClass().getSuperclass());
		System.out.println(i instanceof Object);
		System.out.println(i.getClass().isArray());
		System.out.println();
		
		System.out.println(i.getClass().isPrimitive()); //�Ƿ�Ϊ������������
		System.out.println(i.getClass().isEnum()); // �Ƿ�Ϊö�ٶ��� 
		System.out.println(i.getClass().isAnnotation());//�Ƿ�Ϊע�� 
	}
}
