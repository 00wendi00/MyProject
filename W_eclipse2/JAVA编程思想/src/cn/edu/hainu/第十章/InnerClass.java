/**
 * �ļ�����InnerClass.java
 * ��Ŀ-����JAVA���˼�� - cn.edu.hainu.��ʮ��
 * ���ߣ����ĵ�
 * �������ڣ�2014-9-25
 */
package cn.edu.hainu.��ʮ��;
/**
 * @author ���ĵ�
 * ������InnerClass
 * ��˵������ϰ9,10,11  �ڲ��ඨ���ڲ�ͬ�� �ط�~~~private���ι����ڲ��౻��ȫ�����ˣ�
 */
public class InnerClass
{ 
    public Class11 haha0(boolean b)
    {
    	if(b)
    	{
    		class HaoDe123 implements Class11
    		{
				public void heihei(String s)
				{
					System.out.println(s+"~~~~~~~~~~~");
				}   			
    		}
    		return new HaoDe123();
    	}
    	class HaoDe implements Class11
    	{
			public void heihei(String s)
			{
				System.out.println(s);
			}  		
    	}
		return new HaoDe();
    }
    private class HaoDe12345 implements Class11
    {
		public void heihei(String s)
		{
			System.out.println("private ��"+s);
		}    	
    }
    public Class11 haha12345()
    {
    	return new HaoDe12345();
    }
    public static void main(String args[])
    {
    	InnerClass innerClass = new InnerClass();
    	innerClass.haha0(false).heihei("�������������");
    	innerClass.haha0(true).heihei("��000000");
    	
    	Class11 class11 = innerClass.haha12345();
    	//((haha12345)class11).heihei(" 1");   //��ϰ11��private���ι����ڲ��౻��ȫ�����ˣ�   	
    }
}
interface Class11
{
	public void heihei(String s);
}
