/**
 * �ļ�����SpaceShip.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����ö������
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-3
 */
package ��ʮ����ö������;

/**
 * @author ���ĵ�
 * ������SpaceShip
 * ��˵����  ��дtoString() ��һ����ĸ��д~~~~~~~~~~~~~~ values()����ö�ٶ���~ 
 */
public enum SpaceShip
{
	SCOUT,HAHA,HAODE,NIMA,CAONIMA;
	public String toString()
	{
		String id = name();
		String lower = id.substring(1).toLowerCase();
		return id.charAt(0) +lower;
	}
	public static void main(String args[])
	{
		for(SpaceShip s:values())
			System.out.println(s);
	}
}
