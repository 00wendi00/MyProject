/**
 * 文件名：Cat.java
 * 项目-包：catCatchMouse - 
 * 作者：胡祝华
 * 创建日期：2011-9-18
 */

/**
 * @author 胡祝华
 * 类名：Cat
 * 类说明：猫
 */
public class Cat
{
    String furColor;
    int height;
    int weight;
    
    public void catchMouse(Mouse m)
    {
    	m.run();
    	m.scream();
    }
}
