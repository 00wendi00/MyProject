/**
 * 文件名：Test.java
 * 项目-包：第6章 GUI - 呵呵
 * 作者：胡祝华
 * 创建日期：2014-4-23
 */
package 呵呵;


import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author 张文迪	
 * 类名：Test
 * 类说明：
 */
public class Test
{
   public static void main(String args[])
   {
	   new myFrame();
   }
}

class myFrame extends JFrame
{
	
	public myFrame()
	{	
		Panel panel = new Panel();
		JButton button1 = new JButton("按钮");
		final TextField textField = new TextField();
		panel.add(button1);
		panel.add(textField);
		add(panel);		
		setVisible(true);
		setBounds(10, 10, 200, 200);
	
		
		button1.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
			    JButton button = (JButton) e.getSource();
				JOptionPane.showMessageDialog(null, button.getText());
				textField.setText("海南大学");
			}
		});
		
	}
}

