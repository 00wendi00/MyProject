/**
 * �ļ�����Overloading.java
 * ��Ŀ-����JAVA���˼�� - �����¸�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-8
 */
package �����¸�����;

/**
 * @author ���ĵ�
 * ������Overloading
 * ��˵����
 */
public class Overloading extends BigRain123
{
    public static void main(String args[])
    {
    	Overloading overloading = new Overloading();
    	overloading.overloadingMethod();
    	overloading.sterilize();
    }
    public void overloadingMethod()
    {
    	super.overloadingMethod(); // output: ����д�ķ���
    	System.out.println("�õģ�������");
    }
    public void sterilize()
    {
    	System.out.println("���������");
    }
}
