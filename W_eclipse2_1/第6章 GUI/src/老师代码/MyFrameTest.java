/**
 * �ļ�����MyFrameTest.java
 * ��Ŀ-������6�� GUI - ��ʦ����
 * ���ߣ���ף��
 * �������ڣ�2014-4-23
 */
package ��ʦ����;

/**
 * @author ��ף��
 * ������MyFrameTest
 * ��˵����
 */
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.omg.CORBA.IMP_LIMIT;

/**
 * �ļ�����MyFrameTest.java
 * ��Ŀ-����Test - 
 * ���ߣ���ף��
 * �������ڣ�2014-4-23
 */

/**
 * @author ��ף�� ������MyFrameTest ��˵����
 */
public class MyFrameTest
{
	/**
	 * ����˵����
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();

		frame.setBounds(10, 10, 500, 500);
		frame.getContentPane().setBackground(Color.blue);
		frame.setLayout(null);

		MyPanel myPanel = new MyPanel();
		myPanel.setBackground(Color.gray);
		myPanel.setBounds(20, 20, 200, 400);
		frame.getContentPane().add(myPanel);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class MyPanel extends JPanel
{
	JButton button1, button2, button3;
	JTextField textField;

	public MyPanel()
	{
		this.button1 = new JButton("��ť1");
		this.button2 = new JButton("��ť2");
		this.button3 = new JButton("��ť3");
		
		textField = new JTextField(10);
		
		//MyListener litListener = new MyListener();
		
		ActionListener listener = new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				JButton button = (JButton) e.getSource();

				JOptionPane.showMessageDialog(null, button.getText());
				textField.setText("���ϴ�ѧ");
			}
		};
		
		button2.addActionListener(listener);
		
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
		//button2.addActionListener();
		//button3.addActionListener();

		this.add(button1);
		this.add(button2);
		this.add(button3);
		this.add(textField);
	}

/*	private class MyListener implements ActionListener
	{
		
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JButton button = (JButton) e.getSource();

			JOptionPane.showMessageDialog(null, button.getText());
			textField.setText("���ϴ�ѧ");
		}
	}*/
}
