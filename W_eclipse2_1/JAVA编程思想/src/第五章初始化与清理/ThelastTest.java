/**
 * �ļ�����ThelastTest.java
 * ��Ŀ-����JAVA���˼�� - �����³�ʼ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-6
 */
package �����³�ʼ��������;

import ������.Switch;

/**
 * @author ���ĵ�
 * ������ThelastTest
 * ��˵������ϰ21��22��  ö������  enum  ++ values(),ordinal()��  switch��䣡��������������
 */

public class ThelastTest
{
    public static void main(String args[])
    {
    	for(Spiciness123 s : Spiciness123.values())   		
    		System.out.println(s+", ordinal " + s.ordinal());
    	System.out.println();
    	
        ThelastTest oooo1 = new ThelastTest(Spiciness123.Yimao);
        oooo1.describe();
        ThelastTest oooo2 = new ThelastTest(Spiciness123.Liangmao);
        oooo2.describe();
        ThelastTest oooo3 = new ThelastTest(Spiciness123.Wumao);
        oooo3.describe();
        ThelastTest oooo4 = new ThelastTest(Spiciness123.Yikuai);
        oooo4.describe();
        ThelastTest oooo5 = new ThelastTest(Spiciness123.Liangkuai);
        oooo5.describe();
        ThelastTest oooo6 = new ThelastTest(Spiciness123.Wukuai);
        oooo6.describe();
   
    }
    
    public enum Spiciness123
    {
    	Yimao,Liangmao,Wumao,Yikuai,Liangkuai,Wukuai
    }
    
    Spiciness123 daxiao;
    public ThelastTest(Spiciness123 daxiao)
    {
    	this.daxiao = daxiao;
    }
    public void describe()
    {
    	switch(daxiao)
    	{
    	    case Yimao : System.out.println("һë");
    	    break;
    	    case Liangmao : System.out.println("��ë");
    	    break;
    	    case Wumao : System.out.println("��ë");
    	    break;
    	    case Yikuai : System.out.println("һ��");
    	    break;
    	    case Liangkuai : System.out.println("����");
    	    break;
    	    case Wukuai : System.out.println("���");
    	    break;
    	    default : System.out.println("���԰���");
    	}
    	
    }
    
}

