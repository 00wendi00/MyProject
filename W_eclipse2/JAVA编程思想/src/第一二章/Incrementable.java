/**
 * �ļ�����Incrementable.java
 * ��Ŀ-����JAVA���˼�� - ��һ����
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-2
 */
package ��һ����;

/**
 * @author ���ĵ�
 * ������Incrementable
 * ��˵������ϰ7,8������ĳ���ض��� static��ֻ��һ��ʵ��
 */
 class Incrementable
{
	 
    static void increment()
    {
    	StaticTest.i++;
    }
    
    public static void main(String args[])
    {
    	StaticTest st1 = new StaticTest();
    	StaticTest st2 = new StaticTest(); 	
    	StaticTest st3 = new StaticTest();
    	Incrementable sf1 = new Incrementable();
    	Incrementable sf2 = new Incrementable();
    	Incrementable sf3 = new Incrementable();
    	
        sf1.increment();  //48
        sf2.increment();    //49��      ��ϰ8��sf1 sf2 sf3 ��ʵ��һ��ʵ����
        sf3.increment();    //50�����۴��������Ķ��ٸ������������ĳ���ض��� static��ֻ��һ��ʵ����
        sf1.increment();   //51
        
    	Incrementable.increment();
    	
    	System.out.println(st1.i++);
    	System.out.println(st1.i++);
    	System.out.println(st2.i++);
    	System.out.println(st3.i++);
    	
    }
}
 
 
class StaticTest
{
	static int i = 47;
}
