/**
 * 文件名：TurTle.java
 * 项目-包：JAVA编程思想 - 第十三章字符串
 * 作者：张文迪
 * 创建日期：2014-10-14
 */
package 第十三章字符串;

import java.io.PrintStream;
import java.util.Formatter;

/**
 * @author 张文迪
 * 类名：TurTle
 * 类说明： 练习3~~~ PrintStream，Formatter~
 */
public class TurTle1
{
    private String name;
    private Formatter f;
    public TurTle1(String name,Formatter f)
    {
    	this.name = name ;
    	this.f = f;
    }
    public void move(int x, int y)
    {
    	f.format("%s The Turtle is at (%d,%d)\n", name,x,y);
    }
    public static void main(String[] args)
    {
    	PrintStream outAlias = System.err;
    	TurTle1 tommy = new TurTle1("Tommy", new Formatter(System.err));
    	TurTle1 terry = new TurTle1("terry", new Formatter(outAlias));
    	tommy.move(0, 0);
    	terry.move(4, 8);
    	tommy.move(3, 4);
    }
}
