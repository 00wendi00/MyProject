/**
 * �ļ�����Rodent.java
 * ��Ŀ-����JAVA���˼�� - �ڰ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-10
 */
package �ڰ���;

/**
 * @author ���ĵ�
 * ������Rodent
 * ��˵������ϰ 9,12,14   ����~������飬Ȼ���ٵ��ã�������չ����+  �ھ��� ��ϰ 1,2
 */
abstract public class Rodent
{
    protected static long m = 0;
   public static void main(String args[])
   {
	   Rodent[] allRodents = 
		{
			//new Rodent(),  //�ھ��� ��ϰ 1,2
			new Mouse(),
	        new Gerbil(),
	        new Hamster()
		};
	   System.out.println(m);
	   tuneAll(allRodents);
	   System.out.println(m+"  ���ü�����  �������");
   }
   public void Howl()
   {
	   System.out.println("֨֨֨֨������");
   }
   public static void tuneAll(Rodent[] i)
   {
	   for(Rodent e:i)
		   tune(e);
   }
   public static void tune(Rodent k)
   {
	   m++;
	   k.Howl();  
	   System.out.println(m);// m = 6;
   }
   public Rodent()
   {
	   m++;
	   System.out.println("���౻��ʼ��");
	   System.out.println(m);
   }
}
class Mouse extends Rodent
{
	public void Howl()
	{
		m++;
		System.out.println("��������������");
	}
	public Mouse()
	{
		m++;
		System.out.println("���౻��ʼ��");
	}
}
class Gerbil extends Rodent
{
	public void Howl()
	{
		m++;
		System.out.println("�������룡����");
	}
}
class Hamster extends Rodent
{
	public void Howl()
	{
		m++;
		System.out.println("�ǺǺǺǣ�����");
	}
}

