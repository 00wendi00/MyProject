/**
 * �ļ������׿ǳ�.java
 * ��Ŀ-����JAVA���˼�� - �����¸�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-9
 */
package �����¸�����;

/**
 * @author ���ĵ�
 * �������׿ǳ�
 * ��˵������ϰ23,24.  �̳��е�      ����˳�� ��  
 */
class Insect
{
    private int i = 9;
    protected int j;
    Insect()
    {
    	System.out.println("i="+i+",j="+j);
    	j = 39;
    }                                  //55   ��˳���Ȼ���Ĺ��췽��
    private static int x1 = printInit("static Insect.x1 initialized");//111
    static int printInit(String s)
    {
    	System.out.println(s);
    	return 47;
    }
}

class Beetle extends Insect
{
    private int k = printInit("Beetle.k initialized");//66���췽��֮ǰ����   �Ǿ�̬��Ա����
    Beetle()
    {
    	System.out.println("K="+k);
    	System.out.println("j="+j);
    	
    }                         //777
    private static int x2 =printInit("static Beetle.x2 initialized");//222
}

public class �׿ǳ�  extends Beetle
{
	private int h = printInit("Beetle.h initialized");//8888
	�׿ǳ�()
	{
		System.out.println("h="+h);   //999
	}
	private static int x3 =printInit("static Beetle.x3 initialized");//333
	public static void main(String args[])
	{
		System.out.println("�׿ǳ� constructor");//444       ����    ��̬�� ��Ա���� ֮��
		�׿ǳ�  jkc = new �׿ǳ�();
	}
}

