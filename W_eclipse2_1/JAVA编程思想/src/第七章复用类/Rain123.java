/**
 * �ļ�����Rain123.java
 * ��Ŀ-����JAVA���˼�� - �����¸�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-8
 */
package �����¸�����;

/**
 * @author ���ĵ�
 * ������Rain123
 * ��˵������ϰ1  �� ���Գ�ʼ��
 */
public class Rain123
{
	 private static BigRain123 bigRain;
	 public Rain123()
	 {
		 bigRain = new BigRain123();   //ʵ����ʼ��   ~~�Ͷ��Գ�ʼ����������������������
	 }
	 public String toString()
	 {
		 return
		    "bigRain="+bigRain;  //�� BigRain ����ת��ΪString����
	 }
     public static void main(String args[])
     {
    	 Rain123 rain = new Rain123();
    	 System.out.println(rain);
    	 
     }
}

class BigRain123    // Overloading �ĸ��ࡣ
{
	private String s;
    BigRain123()
    {
    	System.out.println("BigRain123()"+"  �������Ҳ�������� ");
    	s = "���꣬�õ���";
    }
    public String toString()
    {
    	return s;
    }
    public void overloadingMethod()
    {
    	System.out.println("������д");
    }
}
