/**
 * �ļ�����Good.java
 * ��Ŀ-����JAVA���˼�� - cn.edu.hainu.�ھ���
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-15
 */
package cn.edu.hainu.�ھ���;



/**
 * @author ���ĵ�
 * ������Good
 * ��˵������ϰ 3 
 */
public class Good
{
   public static void main(String args[])
   {
	   GoodMorning goodMorning = new GoodMorning();
	   goodMorning.print();
	   
	   
	   
   }
}

abstract class GoodDay
{
    abstract void print(); 	
}

class GoodMorning extends GoodDay
{
	int k = 5;
	void print()
	{
		System.out.println(k);		
	}
    
}

