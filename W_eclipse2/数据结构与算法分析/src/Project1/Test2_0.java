/**
 *�ļ���:Test2_0.java
 *��Ŀ-��:���ݽṹ���㷨����,Project1
 *����:���ĵ�
 *ʱ��:2015��4��5��
 */
package Project1;

/**
 * @author ���ĵ�
 * ����:Test2_0
 * ��˵��:		���    ASCII��     ,0~27Ϊ�����ַ�
 * 							32��126(��95��)���ַ�(32�ǿո񣩣�����48��57Ϊ0��9ʮ�����������֡�
								65��90Ϊ26����дӢ����ĸ��97��122��Ϊ26��СдӢ����ĸ������ΪһЩ�����š�������ŵ�
 */
public class Test2_0
{
	public static void main(String args[])
	{
		for(int i = 0 ;i <10;i++){
			System.out.print(i+"	    ");
		}
		System.out.println();
		for(int i = 0;i<255;i++){
			System.out.print((char)i+"	  ");
			if((i+1)%10==0)
				System.out.println("");
		}
	}
}
