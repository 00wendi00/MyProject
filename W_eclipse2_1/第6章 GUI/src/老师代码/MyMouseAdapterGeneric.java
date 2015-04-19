/**
 * 文件名：MyMouseAdapterGeneric.java
 * 项目-包：第6章 GUI - 老师代码
 * 作者：张文迪
 * 创建日期：2014-4-25
 */
package 老师代码;

/**
 * @author 胡祝华
 * 类名：MyMouseAdapterGeneric
 * 类说明：
 */


import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyMouseAdapterGeneric
{
	public static void main(String args[])
	{
		new MyFrame99("drawing...");
	}
}

class MyFrame99 extends Frame
{
	ArrayList<Point> points = null;

	MyFrame99(String s)
	{
		super(s);
		points = new ArrayList<Point>();
		setLayout(null);
		setBounds(300, 300, 400, 300);
		this.setBackground(new Color(204, 204, 255));
		setVisible(true);
		this.addMouseListener(new Monitor1());
	}

	public void paint(Graphics g)
	{
		Iterator<Point> i = points.iterator();
		while (i.hasNext())
		{
			Point p = i.next();
			g.setColor(Color.BLUE);
			g.fillOval(p.x, p.y, 10, 10);
		}
	}

	public void addPoint(Point p)
	{
		points.add(p);
	}
}

class Monitor1 extends MouseAdapter
{
	public void mousePressed(MouseEvent e)
	{
		MyFrame99 f = (MyFrame99) e.getSource();
		f.addPoint(new Point(e.getX(), e.getY()));
		f.repaint();
	}
}
