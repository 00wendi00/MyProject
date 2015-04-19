package 窗口12345;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;


public class loginClient {
     public static void main(String args[])
     {
    	new window("登陆窗口");  
     }
}

class window extends JFrame
{
	public window(String a)
	{		
	 super(a);
	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();
	
	Panel panel4 = new Panel();//上面   的 区域， 美化。
	
	Label label1 = new Label("账号");
	Label label2 = new Label("密码");
	TextField textField1 = new TextField(20);
	textField1.requestFocus();
	final TextField textField2 = new TextField(20);
	Button button1 = new Button("登陆");
	Button button2 = new Button("注册账号");	
	
	textField2.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			TextField textField = new TextField();
			textField.setEchoChar('*');
			
		}
	});
	textField2.setEchoChar('*');
	
	panel1.add(label1);
	panel1.add(textField1);
	panel2.add(label2);
	panel2.add(textField2);
	panel3.add(button1);
	panel3.add(button2);
	
	setBounds(100, 100, 300, 250);
	add(panel4);
	add(panel1);
	add(panel2);

	add(panel3);    
	setLayout(new GridLayout(5,1));
	
	button1.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{			
			new frame("聊天窗口");
		}
	});
	
	this.addWindowListener(new WindowAdapter()
	{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);			
		}
	});
	
	setVisible(true);
	}

	
}
