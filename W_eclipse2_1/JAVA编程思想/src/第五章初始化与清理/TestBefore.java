/**
 * �ļ�����TestBefore.java
 * ��Ŀ-����JAVA���˼�� - �����³�ʼ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-6
 */
package �����³�ʼ��������;

/**
 * @author ���ĵ�
 * ������TestBefore
 * ��˵������ϰ14.  ��̬������ʹ��֮ǰ������˳�ʼ����
 */
public class TestBefore
{
     public static void main(String args[])
     {
    	 YunYan yunYan = new YunYan();
    	 yunYan.Haha();
     }
     
}

class YunYan
{
	 static String nimabi = "nimabi000000000000";
     static  
     {
    	 String nima = "14111111111";
    	 System.out.println(nima);
     }
     static void Haha()
     {
    	 System.out.println(nimabi);
    	 
     }
}
