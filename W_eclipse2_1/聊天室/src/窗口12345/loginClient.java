package ����12345;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;


public class loginClient {
     public static void main(String args[])
     {
    	new window("��½����");  
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
	
	Panel panel4 = new Panel();//����   �� ���� ������
	
	Label label1 = new Label("�˺�");
	Label label2 = new Label("����");
	TextField textField1 = new TextField(20);
	textField1.requestFocus();
	final TextField textField2 = new TextField(20);
	Button button1 = new Button("��½");
	Button button2 = new Button("ע���˺�");	
	
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
			new frame("���촰��");
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
