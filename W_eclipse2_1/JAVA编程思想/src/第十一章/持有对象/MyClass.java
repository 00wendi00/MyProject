/**
 * �ļ�����MyClass.java
 * ��Ŀ-����JAVA���˼�� - ��ʮһ��.���ж���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-29
 */
package ��ʮһ��.���ж���;

import java.util.*;;

/**
 * @author ���ĵ�
 * ������MyClass
 * ��˵����  ��ϰ7.�Ƴ� �Ӽ�~~~     �쳣  java.util.ConcurrentModificationException
 * 	���������˵,�㲻���ڶ�һ��List���б�����ʱ�����е�Ԫ��ɾ����
             ����취��,������Ƚ�Ҫɾ����Ԫ������һ��listװ����,�ȱ���������remove��
	��������д
	List delList = new ArrayList();//����װ��Ҫɾ����Ԫ��
	for(Information ia:list)
		if(ia.getId()==k){
			n++;
		delList.add(ia);
	}
	list.removeAll(delList);//������ɺ�ִ��ɾ��
 */
public class MyClass
{
    public static void main(String args[])
    {
    	List<Object> obj = new ArrayList<Object>();
    	obj.add("222222");
    	obj.add("~~~~~");
    	obj.add("�õ�");
    	obj.add("����");
    	
    	System.out.println(obj);
    	List<Object> obj2 = obj.subList(0,2);
    	System.out.println(obj2);
    	obj2.remove(0);
    	System.out.println(obj2);
    	System.out.println(obj);
    	obj.remove(obj2); // һ���Ӽ��������������Ƴ�~
    	System.out.println(obj);
    	System.out.println(obj2);
    	
    	//obj.removeAll(obj2);  �쳣  java.util.ConcurrentModificationException
    	
    	System.out.println();
    	List<Object> copy = new ArrayList<Object>(obj);
    	System.out.println(copy);
    	copy.removeAll(obj2);
    	System.out.println(obj);
    	System.out.println(copy);// ���������Ƴ��Ӽ�������
    	System.out.println(obj2);
    }
}
