/**
 * �ļ�����TwoFlower.java
 * ��Ŀ-����JAVA���˼�� - �����³�ʼ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-5
 */
package �����³�ʼ��������;

/**
 * @author ���ĵ�
 * ������TwoFlower
 * ��˵������ϰ9. this�������á�
 */
public class TwoFlower
{
   public static void main(String args[])
   {
	   new Flower();
   }
}

class Flower
{
    Flower()
    {
    	this(5, "��ã�������");
    	System.out.println("ok1");
    }
    Flower(int i,String s)
    {
    	this("���,","�õ�");
    	System.out.println("ok2"+i+s);
    }
    Flower(String a, String b)
    {
    	System.out.println("ok3"+a+b);
    }
}
