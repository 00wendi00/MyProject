/**
 * 文件名：Ex3.java
 * 项目-包：JAVA编程思想 - 第二十二章图形化用户界面
 * 作者：张文迪
 * 创建日期：2014-11-8
 */
package 第二十二章图形化用户界面;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author 张文迪
 * 类名：Ex3
 * 类说明：
 */
@SuppressWarnings("serial")
public class Ex34 extends JFrame
{
	private JButton jButton1 = new JButton("1"),
					jButton2 = new JButton("2");
	public Ex34(){
		setLayout(new FlowLayout());
		add(jButton1);
		add(jButton2);
	}
	public static void main(String args[])
	{
		SwingConsole.run(new Ex34(), 200, 200);
	}
}
