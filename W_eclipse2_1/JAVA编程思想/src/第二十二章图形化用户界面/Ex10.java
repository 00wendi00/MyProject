/**
 * �ļ�����Ex10.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮ����ͼ�λ��û�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-8
 */
package �ڶ�ʮ����ͼ�λ��û�����;

import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @author ���ĵ�
 * ������Ex10
 * ��˵����~~~
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
