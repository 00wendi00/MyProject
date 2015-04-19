/**
 * 文件名：MyMouseAdapter.java
 * 项目-包：第6章 GUI - 老师代码
 * 作者：张文迪
 * 创建日期：2014-4-25
 */
package 老师代码;

/**
 * @author 胡祝华
 * 类名：MyMouseAdapter
 * 类说明：
 */


import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyMouseAdapter
{
	public static void main(String args[])
	{
		new MyFrame("drawing...");
	}
}

class MyFrame extends Frame
{
	ArrayList points = null;

	MyFrame(String s)
	{
		super(s);
		points = new ArrayList();
		setLayout(null);
		setBounds(300, 300, 400, 300);
		this.setBackground(new Color(204, 204, 255));
		setVisible(true);
		this.addMouseListener(new MyMonitor());
	}

	public void paint(Graphics g)
	{
		Iterator i = points.iterator();
		while (i.hasNext())
		{
			Point p = (Point) i.next();
			g.setColor(Color.red);
			g.fillOval(p.x, p.y, 10, 10);
		}
	}

	public void addPoint(Point p)
	{
		points.add(p);
	}
}

class MyMonitor extends MouseAdapter
{
	public void mousePressed(MouseEvent e)
	{
		MyFrame f = (MyFrame) e.getSource();
		f.addPoint(new Point(e.getX(), e.getY()));
		f.repaint();
		
	}
}
