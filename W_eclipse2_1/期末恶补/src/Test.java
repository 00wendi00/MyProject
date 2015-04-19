/**
 * 文件名：test.java
 * 项目-包：catCatchMouse - 
 * 作者：胡祝华
 * 创建日期：2011-9-18
 */

/**
 * @author 胡祝华
 * 类名：test
 * 类说明：
 */
public class Test
{

	/**
	 * 方法说明：
	 * @param args
	 */
	public static void main(String[] args)
	{
		Cat cat = new Cat();
		cat.furColor = "蓝";
		cat.height = 10;
		cat.weight = 20;
		
		Mouse mouse = new Mouse();
		mouse.furColor = "白色";
		mouse.size = 10;
		mouse.weight = 10;
		
		cat.catchMouse(mouse);
	}

}
