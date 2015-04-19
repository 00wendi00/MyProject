/**
 * �ļ�����Ex18.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-2
 */
package ��ʮ����IOϵͳ;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * @author ���ĵ�
 * ������Ex18
 * ��˵����   ��TextFile��Ƚ�~~Throws IOException
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