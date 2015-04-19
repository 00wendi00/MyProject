package 抽签123;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Hahahaha extends JFrame
{
	String s = null;
	int c1 = 1,c2 = 1,c3 = 1;
	ImageIcon img;
	
	public Hahahaha() 
	{					
		JFrame jFrame = new JFrame("抽签");
		final JLabel label = new JLabel(img);
		JButton button = new JButton("抽~~~");
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel1.add(button);
		panel2.add(label);
		jFrame.add(BorderLayout.NORTH,panel1);
		jFrame.add(BorderLayout.CENTER,panel2);		
		jFrame.setBounds(100, 100,300, 540);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);				
		button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{
				s = chouqian();
				label.setText(s);
				img = img = new ImageIcon("./image/sm.jpg");
			}
		});		
	}

	public String chouqian()
	{
		int i = (int)(Math.random()*100);
		if(i>=0&&i<33)
			return "大队.."+c1++;
		else if(i>=33&&i<66)
			return "大舅子.."+c2++;
		else if(i>=66&&i<99)
			return "文迪.."+c3++;
		else {
			return "再抽";
		}
	}
	public static void main(String args[])
	{
		new Hahahaha();
	}
}
