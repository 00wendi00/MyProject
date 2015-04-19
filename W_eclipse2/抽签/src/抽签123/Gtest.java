package 抽签123;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class Gtest extends JFrame
{

	Draw d;
	public Gtest()
	{
		this.setSize(300, 500);
		d=new Draw(this.getGraphics(),this);
		this.show();
	}
	public static void main(String[] args)
	{
		new Gtest();

	}

}
class Draw
{
	Toolkit toolkit;
	Image img;
	public Draw(Graphics g,Gtest t)
	{
		toolkit=Toolkit.getDefaultToolkit();
		img=toolkit.getImage("./image/cs.jpg");
		 g.drawImage(img, 0, 0, t);
	}

}
