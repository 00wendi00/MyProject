/**
 * �ļ�����Amphibian.java
 * ��Ŀ-����JAVA���˼�� - �����¸�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-9
 */
package �����¸�����;

/**
 * @author ���ĵ�
 * ������Amphibian
 * ��˵������ϰ 16,17.   Upcasting
 */
public class Frog extends Amphibian
{
	
     public static void main(String args[])
     {
    	 Frog frog = new Frog();
    	 //Frog amphibian = new Frog();
    	 Amphibian.caoanimabi(frog);   	
     }
     static void caoanimabi(Frog a)
     {
    	 a.HaoDe0();
     }
     protected void HaoDe0()
 	{
 		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
 	}
}
class Amphibian 
{
	static void caoanimabi(Frog a)
	{
		System.out.println(" �õ� �� ��");
		a.HaoDe0();
		
	}
	Amphibian()
	{
		System.out.println("��");
	}
	protected void HaoDe0()
	{
		System.out.println("~~~~~~");
	}
}