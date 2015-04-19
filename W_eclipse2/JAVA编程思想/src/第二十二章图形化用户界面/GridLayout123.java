/**
 * 文件名：GridLayout.java
 * 项目-包：JAVA编程思想 - 第二十二章图形化用户界面
 * 作者：张文迪
 * 创建日期：2014-11-8
 */
package 第二十二章图形化用户界面;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author 张文迪
 * 类名：GridLayout
 * 类说明：
 */ 
public class GridLayout123 extends JFrame
{
	public GridLayout123(){
		setLayout(new GridLayout(7,3));
		for(int i =0;i<19;i++)
			add(new JButton("Button"+i));
	}
	public static void main(String args[])
	{
		SwingConsole.run(new GridLayout123(), 300, 300);
	}
}
