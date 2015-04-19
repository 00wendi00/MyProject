/**
 * 文件名：Ex10.java
 * 项目-包：JAVA编程思想 - 第二十二章图形化用户界面
 * 作者：张文迪
 * 创建日期：2014-11-8
 */
package 第二十二章图形化用户界面;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @author 张文迪
 * 类名：Ex10
 * 类说明：~~~
 */
class TypeableButton extends JFrame 
{
	JTextField txt = new JTextField(10);
	JButton b = new JButton("Button 1");
	public TypeableButton() 
	{
		setLayout(new FlowLayout());
		add(txt);
		add(b);
		b.addKeyListener(new KeyAdapter()
		{
			public void keyPressed(KeyEvent e)
			{
				txt.setText("@@@@@@@");
			}
		});
		b.addKeyListener(new KeyListener()
		{
			
			@Override
			public void keyTyped(KeyEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e)
			{
				// TODO Auto-generated method stub
				
			}
		});
	}
}
public class Ex10 
{
	public static void main(String args[]) 
	{
		SwingConsole.run(new TypeableButton(), 200, 100);
	}
}
