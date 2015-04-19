/**
 * �ļ�����Ex22.java
 * ��Ŀ-����JAVA���˼�� - ��ʮ����IOϵͳ
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-2
 */
package ��ʮ����IOϵͳ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import net.mindview.util.OSExecuteException;

/**
 * @author ���ĵ�
 * ������Ex22
 * ��˵�������Ƴ����  ���������~~ �� throws ��ͬ��  exception
 */
class OSExecute2 
{
	public static List<String> command(String command) 
	{
		boolean err = false;
		List<String> output = new LinkedList<String>();
		try 
		{
			Process process = new ProcessBuilder(command.split(" ")).start();
			BufferedReader results = new BufferedReader(
						new InputStreamReader(process.getInputStream()));
			String s;
			while((s = results.readLine()) != null)
				output.add(s);
			BufferedReader errors = new BufferedReader(
					new InputStreamReader(process.getErrorStream()));
			// Report errors and return nonzero value
			// to calling process if there are problems:
			while((s = errors.readLine()) != null) {
				System.err.println(s);
				err = true;
			}
		}
		catch(IOException e)
		{
			if(!command.startsWith("CMD /C"))
				return command("CMD /C " + command);
			throw new RuntimeException(e);
		} 
		catch(Exception e) 
		{
			throw new RuntimeException(e);
		}
		if(err)
			throw new OSExecuteException("Errors executing " + command);
		return output;
		}
}
public class Ex22
{
	public static void main(String[] args) 
	{
		List<String> result = OSExecute2.command("C:/Users/���ĵ�/Desktop/�½��ļ���1/2.txt");
		for(String s : result)
			System.out.println(s+"@@@@@@@");
	}
}
