/**
 * �ļ�����Ligth000.java
 * ��Ŀ-����JAVA���˼�� - �ڰ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-10
 */
package �ڰ���;

/**
 * @author ���ĵ�
 * ������Ligth000
 * ��˵������ϰ10 ��//���� ����ָ��������� ������������  �Ѿ������˵� ������
 */
public class Ligth000
{
    public static void main(String args[])
    {
    	Ligth000 ligth000 = new GoodLigth000();
    	ligth000.Method1();//���� ����ָ��������� ������������  �Ѿ������˵� ������
    }
    public void Method1()
    {
    	Method2();
    }
    public void Method2()
    {
    	System.out.println("�����");
    }
}
class GoodLigth000 extends Ligth000
{
	public void Method2()
    {
    	System.out.println("����������");
    }
}
