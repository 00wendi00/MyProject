/**
 * �ļ�����bpp6_5.java
 * ��Ŀ-�������� - ���԰�
 * ���ߣ����ĵ�
 * �������ڣ�2014-5-17
 */
package ���԰�;

/**
 * @author ���ĵ�
 * ������bpp6_5
 * ��˵����
 */
public class bpp6_5            //��������
{
     public static void main(String args[])
     {
          int a[]={8,23,7,88,9,23};           //����һά����
          leastnumb Min=new leastnumb();      //��������
          Min.least(a);             //��һά����a����least()����
     }
}
class leastnumb           //������һ����
{
     public void least(int array[])      //����array[]����һά��������
     {
          int temp=array[0];
          for(int i=0;i<array.length;i++)
          if(temp>array[i])
          temp=array[i];
          System.out.println("��С����Ϊ��"+temp);
     }
}