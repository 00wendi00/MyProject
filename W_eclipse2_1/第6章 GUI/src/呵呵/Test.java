/**
 * �ļ�����Test.java
 * ��Ŀ-������6�� GUI - �Ǻ�
 * ���ߣ���ף��
 * �������ڣ�2014-4-23
 */
package �Ǻ�;


import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author ���ĵ�	
 * ������Test
 * ��˵����
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
		JButton button1 = new JButton("��ť");
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
				textField.setText("���ϴ�ѧ");
			}
		});
		
	}
}

