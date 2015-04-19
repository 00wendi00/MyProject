/**
 * 文件名：SwingConsole.java
 * 项目-包：JAVA编程思想 - 第二十二章图形化用户界面
 * 作者：张文迪
 * 创建日期：2014-11-8
 */
package 第二十二章图形化用户界面;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author 张文迪
 * 类名：SwingConsole
 * 类说明：
 */
public class SwingConsole
{
	public static void run(final JFrame f,final int width,final int height){
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				f.setTitle(f.getClass().getSimpleName());
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(width, height);
				f.setVisible(true);
			}
		});
	}
}
