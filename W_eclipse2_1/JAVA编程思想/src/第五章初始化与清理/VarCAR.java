/**
 * �ļ�����VarCAR.java
 * ��Ŀ-����JAVA���˼�� - �����³�ʼ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-6
 */
package �����³�ʼ��������;


/**
 * @author ���ĵ�
 * ������VarCAR
 * ��˵������ϰ 19,20.�ɱ�����б�
 */	
public class VarCAR
{
    public static void main(String args[])
    {
    	 f("wqeter","qwe tr","weyut");
    	 f(new String[]{"weqwewe","wqewqewq"});
    	 
    	 k(1156151,5456415,541541514,515616);
    	 k('a',213245,"wqewerr",656l,0x21312,3.22d,254l);
    	 k();
    }
    
    public static void f(String...args)
    {
    	for(String s : args)
    		System.out.println(s+" ");
    	System.out.println();
    }
    
    public static void k(Object...args)
    {
    	for(Object obj:args)
    		System.out.println(obj +" ");
    	System.out.println();
    }   
}



