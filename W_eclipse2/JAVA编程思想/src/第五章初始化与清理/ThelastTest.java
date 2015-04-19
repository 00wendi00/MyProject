/**
 * 文件名：ThelastTest.java
 * 项目-包：JAVA编程思想 - 第五章初始化与清理
 * 作者：张文迪
 * 创建日期：2014-9-6
 */
package 第五章初始化与清理;

import 第四章.Switch;

/**
 * @author 张文迪
 * 类名：ThelastTest
 * 类说明：练习21，22。  枚举类型  enum  ++ values(),ordinal()和  switch语句！！！！！！！！
 */

public class ThelastTest
{
    public static void main(String args[])
    {
    	for(Spiciness123 s : Spiciness123.values())   		
    		System.out.println(s+", ordinal " + s.ordinal());
    	System.out.println();
    	
        ThelastTest oooo1 = new ThelastTest(Spiciness123.Yimao);
        oooo1.describe();
        ThelastTest oooo2 = new ThelastTest(Spiciness123.Liangmao);
        oooo2.describe();
        ThelastTest oooo3 = new ThelastTest(Spiciness123.Wumao);
        oooo3.describe();
        ThelastTest oooo4 = new ThelastTest(Spiciness123.Yikuai);
        oooo4.describe();
        ThelastTest oooo5 = new ThelastTest(Spiciness123.Liangkuai);
        oooo5.describe();
        ThelastTest oooo6 = new ThelastTest(Spiciness123.Wukuai);
        oooo6.describe();
   
    }
    
    public enum Spiciness123
    {
    	Yimao,Liangmao,Wumao,Yikuai,Liangkuai,Wukuai
    }
    
    Spiciness123 daxiao;
    public ThelastTest(Spiciness123 daxiao)
    {
    	this.daxiao = daxiao;
    }
    public void describe()
    {
    	switch(daxiao)
    	{
    	    case Yimao : System.out.println("一毛");
    	    break;
    	    case Liangmao : System.out.println("两毛");
    	    break;
    	    case Wumao : System.out.println("五毛");
    	    break;
    	    case Yikuai : System.out.println("一块");
    	    break;
    	    case Liangkuai : System.out.println("两块");
    	    break;
    	    case Wukuai : System.out.println("五块");
    	    break;
    	    default : System.out.println("不对啊！");
    	}
    	
    }
    
}

