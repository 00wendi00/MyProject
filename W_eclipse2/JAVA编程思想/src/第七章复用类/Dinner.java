/**
 * �ļ�����Dinner.java
 * ��Ŀ-����JAVA���˼�� - �����¸�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-9
 */
package �����¸�����;

/**
 * @author ���ĵ�
 * ������Dinner
 * ��˵������ϰ 21 ��final �������ܱ�����
 */

public class Dinner extends Meals0
{
    public static void main(String args[])
    {
    	Dinner dinner = new Dinner();
    	dinner.Eat();
    	dinner.Eat(0);
    }
    public void Eat(int i)
    {
    	System.out.println("��"+i);
    }
}

class Meals0
{
    public final void Eat()
    {
        System.out.println("�Է�");
    }
}