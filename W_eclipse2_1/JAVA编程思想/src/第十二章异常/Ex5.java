/**
 * �ļ�����Ex5.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ�����쳣
 * ���ߣ����ĵ�
 * �������ڣ�2014-10-11
 */
package ��ʮ�����쳣;

/**
 * @author ���ĵ�
 * ������Ex5
 * ��˵����
 */
public class Ex5 {
	private static int[] ia = new int[2];
	static int x = 5;	
	public static void main(String[] args) {
		while(true) 
		{
			try {
				ia[x] = 1;
				System.out.println(ia[x]);
				break;	//����
			} catch(ArrayIndexOutOfBoundsException e) {
				System.err.println(
					"Caught ArrayIndexOutOfBoundsException");
					e.printStackTrace();
				x--;
			} finally {
				System.out.println("Are we done yet?");		
			}
		}
		System.out.println("Now, we're done.");
	}	
}
