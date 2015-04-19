/**
 * 文件名：Ex18.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-2
 */
package 第十八章IO系统;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author 张文迪
 * 类名：Ex18
 * 类说明：   和TextFile相比较~~Throws IOException
 */

class TextFile2{
public TextFile2(String fileName, String splitter)throws IOException 
{
	super(Arrays.asList(read(fileName).split(splitter)));
	// Regular expression split() often leaves an empty
	// String at the first position:
	if(get(0).equals("")) remove(0);
}
// Normally read by lines:
public TextFile2(String fileName) throws IOException 
{
	this(fileName, "\n");
}
public void write(String fileName) throws IOException 
{
	PrintWriter out = new PrintWriter(
				new BufferedWriter(new FileWriter(new File(fileName).getAbsoluteFile())));
	try {
		for(String item : this)
			out.println(item);
} finally 
{
	out.close();
}
}