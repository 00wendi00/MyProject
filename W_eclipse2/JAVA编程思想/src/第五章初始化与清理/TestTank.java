/**
 * �ļ�����TestTank.java
 * ��Ŀ-����JAVA���˼�� - �����³�ʼ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-5
 */
package �����³�ʼ��������;

/**
 * @author ���ĵ�
 * ������TestTank
 * ��˵������״̬�Ϳ�״̬�������������ڴ棿   ��ϰ12.
 */
public class TestTank
{
   public static void main(String args[])
   {
	   for(int k=0;k>=0;k++)
	   {
	   Tank tank = new Tank();
	   }
   }
}


class Tank
{
	 Tank()
	{
		System.out.println("tank");
	}
	protected void finalize()
	{
		System.out.println("������");
	}
}
