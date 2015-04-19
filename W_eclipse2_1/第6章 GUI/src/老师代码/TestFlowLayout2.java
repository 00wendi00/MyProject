/**
 * 文件名：TestFlowLayout2.java
 * 项目-包：第6章 GUI - 老师代码
 * 作者：张文迪
 * 创建日期：2014-4-27
 */
package 老师代码;

/**
 * @author 张文迪
 * 类名：TestFlowLayout2
 * 类说明：
 */


import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestFlowLayout2
{
	public static void main(String args[])
	{
		JFrame f = new JFrame("Java Frame");
		FlowLayout l = new FlowLayout(FlowLayout.CENTER, 20, 40);
		f.setLayout(l);
		f.setLocation(300, 400);
		f.setSize(300, 200);
		f.setBackground(new Color(204, 204, 255));
		for (int i = 1; i <= 7; i++)
		{
			f.add(new JButton("BUTTON"));
		}
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
