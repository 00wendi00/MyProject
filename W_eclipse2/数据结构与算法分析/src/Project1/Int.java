/**
 *�ļ���:Int.java
 *��Ŀ-��:���ݽṹ���㷨����,Project1
 *����:���ĵ�
 *ʱ��:2015��4��17��
 */
package Project1;

/**
 * @author ���ĵ�
 * ����:Int
 * ��˵��:	int������~~  ����̫����!!!
 */
public class Int {
	public static void main(String args[]){
		for(int i = 0;i<32769;i++){
			System.out.print(i+" ");
			if(i%100==0){
				System.out.println();
			}
		}
	}
}
