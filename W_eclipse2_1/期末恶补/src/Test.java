/**
 * �ļ�����test.java
 * ��Ŀ-����catCatchMouse - 
 * ���ߣ���ף��
 * �������ڣ�2011-9-18
 */

/**
 * @author ��ף��
 * ������test
 * ��˵����
 */
public class Test
{

	/**
	 * ����˵����
	 * @param args
	 */
	public static void main(String[] args)
	{
		Cat cat = new Cat();
		cat.furColor = "��";
		cat.height = 10;
		cat.weight = 20;
		
		Mouse mouse = new Mouse();
		mouse.furColor = "��ɫ";
		mouse.size = 10;
		mouse.weight = 10;
		
		cat.catchMouse(mouse);
	}

}
