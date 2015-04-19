/**
 * 文件名：Ex11.java
 * 项目-包：JAVA编程思想 - 第二十二章图形化用户界面
 * 作者：张文迪
 * 创建日期：2014-11-8
 */
package 第二十二章图形化用户界面;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import 第十八章IO系统.Reddirecting;

/**
 * @author 张文迪
 * 类名：Ex11
 * 类说明： 实现随机颜色 ~~~~~~~ 
 */
public class Ex11 extends JFrame
{
	int i1 = 250;
	int i2 = 50;
	int i3 = 100;
	class MyButton extends JButton{
		Random random = new Random(47);
		MouseListener mlListener = new MouseAdapter()	
		{
			
			public void mouseClicked(MouseEvent e)	
			{
				i1 = new Double(Math.random() * 128).intValue() + 128;
				i1 = new Double(Math.random() * 128).intValue() + 128;
				i3 = new Double(Math.random() * 128).intValue() + 128;
				Color color = new Color(i1,i2,i3);				 
				setBackground(color);					
				System.out.println("~~~~~~~~~~");
			}
		};
		public MyButton(){
			setText("*-*");
			addMouseListener(mlListener);
		}
	}
	MyButton button = new MyButton();
	Ex11(){
		setSize(200,200);
		setLayout(new FlowLayout());
		getContentPane().setBackground(new Color(i1,i2,i3));   // 没有注册监听器！！！　自然不能改变颜色＃＃
		//button.setEnabled(false);
		setResizable(false);
		add(button);
		setVisible(true);
	}
	public static void main(String arhs[])
	{
		new Ex11();
	}
}
