/**
 * �ļ�����Ex12.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ���·���
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-21
 */
package ��ʮ���·���;


/**
 * @author ���ĵ�
 * ������Ex12
 * ��˵����
 */
import typeinfo.pets.*;
import java.util.*;
import net.mindview.util.*;

public class LimitsOfInference12 {
	static void f(Map<Person, List<? extends Pet>> petPeople) {}
	public static void main(String[] args) {
		f(New.<Person, List<? extends Pet>>map()); 
	}
}
