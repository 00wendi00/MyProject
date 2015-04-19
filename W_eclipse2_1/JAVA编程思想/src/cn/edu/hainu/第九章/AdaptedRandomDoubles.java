/**
 * 文件名：AdaptedRandomDoubles.java
 * 项目-包：JAVA编程思想 - cn.edu.hainu.第九章
 * 作者：张文迪
 * 创建日期：2014-9-24
 */
package cn.edu.hainu.第九章;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;


/**
 * @author 张文迪
 * 类名：AdaptedRandomDoubles
 * 类说明：append将指定字符添加到此缓冲区
 */
public class AdaptedRandomDoubles extends RandomDoubles implements Readable
{
    private int count;
    public AdaptedRandomDoubles(int count)
    {
    	this.count = count ;
    }
    public int read(CharBuffer cb)
    {
    	if(count-- == 0)
    		return -1;
    	String result = Double.toString(next())+" "; 
    	cb.append(result);
    	return result.length();
    }
    public static void main(String args[])
    {
    	Scanner s = new Scanner(new AdaptedRandomDoubles(7));
    	while(s.hasNextDouble())
    		System.out.println(s.nextDouble()+" ");
    }
}
