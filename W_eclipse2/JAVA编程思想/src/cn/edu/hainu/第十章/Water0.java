/**
 * �ļ�����Water0.java
 * ��Ŀ-����JAVA���˼�� - cn.edu.hainu.��ʮ��
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-25
 */
package cn.edu.hainu.��ʮ��;

/**
 * @author ���ĵ�
 * ������Water0
 * ��˵����   ��ϰ 7��12 �������д������ڲ������    ��ϰ8�� ��Χ���ܷ��ʵ��ڲ����private ��  ������+�����ڲ���
 */
public class Water0
{
     private int i = 0;
     class Water1
     {
    	 private int  k = 4;
    	 public int hahaWater1()
    	 {   		 
    		 i+=3;
    		 hahaWater0();
    		 return i;
    	 }
    	 public void Show1()
    	 {
    		 System.out.println(k);
    	 }
     }
     int k = new Water1().k ;//!!!!!!!!!!!!!!!!!!!!!!
     private void hahaWater0()
     {
    	 System.out.println(i);
    	 System.out.println(k);
     }
     public void haha0000()
     {
    	 Water1 water1 = new Water1();
    	 water1.hahaWater1();
    	 water1.Show1();
     }
     
     //�����ڲ���
     public Water2 water2(final int i)
     {
    	 return new Water2(){
    		 private int nima;
    		 {
    			 nima = i;
    			 System.out.println(nima);
    		 }
			public void See()
			{
				System.out.println("See   @#$%^&*(");
			}
    	 };
     }
   
     public static void main(String args[])
     {
    	 Water0 water0 = new Water0();
    	 water0.haha0000();
    	 
    	 Water2 water2 = water0.water2(9);
     }
}
interface Water2
{
	public void See();
}
