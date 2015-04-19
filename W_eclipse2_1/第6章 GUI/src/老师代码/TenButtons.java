/**
 * 文件名：TenButtons.java
 * 项目-包：第6章 GUI - 老师代码
 * 作者：张文迪
 * 创建日期：2014-4-25
 */
package 老师代码;

/**
 * @author 胡祝华
 * 类名：TenButtons
 * 类说明：
 */


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TenButtons
{
	public static void main(String args[])
	{
		JFrame f = new JFrame("Java Frame");
		f.setLayout(new GridLayout(2, 1));
		f.setLocation(300, 400);
		f.setSize(300, 200);
		f.setBackground(new Color(204, 204, 255));
		JPanel p1 = new JPanel(new BorderLayout());
		JPanel p2 = new JPanel(new BorderLayout());
		JPanel p11 = new JPanel(new GridLayout(2, 1));
		JPanel p21 = new JPanel(new GridLayout(2, 2));
		p1.add(new Button("BUTTON"), BorderLayout.WEST);
		p1.add(new Button("BUTTON"), BorderLayout.EAST);
		p11.add(new Button("BUTTON"));
		p11.add(new Button("BUTTON"));
		p1.add(p11, BorderLayout.CENTER);
		p2.add(new Button("BUTTON"), BorderLayout.WEST);
		p2.add(new Button("BUTTON"), BorderLayout.EAST);
		for (int i = 1; i <= 4; i++)
		{
			p21.add(new Button("BUTTON"));
		}
		p2.add(p21, BorderLayout.CENTER);
		f.add(p1);
		f.add(p2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}
