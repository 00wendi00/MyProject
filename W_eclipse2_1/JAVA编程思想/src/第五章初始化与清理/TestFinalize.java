/**
 * �ļ�����TestFinalize.java
 * ��Ŀ-����JAVA���˼�� - �����³�ʼ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-5
 */
package �����³�ʼ��������;

import ������.Break;

/**
 * @author ���ĵ�
 * ������TestFinalize
 * ��˵���� ��ϰ 10,11.
 */
public class TestFinalize
{
    public static void main(String args[])
    {
    	Tfinalize finalize = new Tfinalize(true);
    	finalize.checked(); 
    	new Tfinalize(true);
    	//finalize.finalize();//���ò�����
    }
}

class Tfinalize
{
	boolean check =false;
	Tfinalize(boolean k)
	{   
		check = k;		
		System.out.println("����һ�£���");		
	}
	void checked()
	{
		check = true;
	}
    protected void finalize()
    {
    	if(check)
    	{
    		System.out.println(" ������ ��");
    		return;
    	}
    }
}
