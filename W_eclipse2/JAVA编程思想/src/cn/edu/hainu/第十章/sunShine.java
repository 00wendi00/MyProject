/**
 * �ļ�����Shine.java
 * ��Ŀ-����JAVA���˼�� - cn.edu.hainu.��ʮ��
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-25
 */
package cn.edu.hainu.��ʮ��;


/**
 * @author ���ĵ�
 * ������Shine
 * ��˵������ϰ 15 ~~~~~~~
 */
class Shine
{
	private int i ;
    Shine(int i)
    {
    	this.i = i;
    }
    public int print1230()
    {
    	return i;
    }
}
public class sunShine
{
	
	public Shine ssssShine(int k)
	{
		return new Shine(k)
		{
			
		};
	}
	public static void main(String args[])
	{
		sunShine sunShine = new sunShine();
		System.out.println(sunShine.ssssShine(999).print1230());
	}
}
