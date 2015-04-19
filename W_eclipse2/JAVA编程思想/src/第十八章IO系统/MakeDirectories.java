/**
 * 文件名：MakeDirectories.java
 * 项目-包：JAVA编程思想 - 第十八章IO系统
 * 作者：张文迪
 * 创建日期：2014-11-1
 */
package 第十八章IO系统;

import java.io.File;

/**
 * @author 张文迪
 * 类名：MakeDirectories
 * 类说明：
 */
public class MakeDirectories
{	
	public static void usage()
	{
		System.err.println("~~~");
		System.exit(1);
	}
	private static void fileData(File f)
	{
		System.out.println(
			"AbsolutePath"+f.getAbsolutePath()+
			"\n canRead "+f.canRead()+
			"\n canWrite "+f.canWrite()+
			"\n getName "+f.getName()+
			"\n getPath "+f.getPath()+
			"\n length "+f.length()+
			"\n lastModified "+f.lastModified()
		);
		if(f.isFile())
			System.out.println("It's a  file~~~~~~~~~~");
		else if(f.isDirectory())
			System.out.println("It's a directory~~~~~~~~~~");
	}
	public static void main(String args[])
	{
		if(args.length<1) usage();
		if(args[0].equals("-r"))
		{
			if(args.length != 3) 
				usage();
			File old = new File(args[1]),
				 rname = new File(args[2]);
			old.renameTo(rname);
			fileData(old);
			fileData(rname);
			
			return ;
		}
		int count = 0;
		boolean del = false;
		if(args[0].equals("-d"))
		{
			count++;
			del = true;
			System.out.println("~~~~~~~~~~~~"+count);
		}
		count--;
		while(++count<args.length)
		{
			//System.out.println(count);
			File f = new File(args[count]);
			if(f.exists())
			{
				System.out.println(f+ " exists");
				if(del)
				{
					System.out.println("deleting..."+f);
					f.delete();
				}
				else
				{
					if(!del)
					{
						f.mkdirs();
						System.out.println("created "+f);
					}
				}
				fileData(f);
			}
		}
	}
}

