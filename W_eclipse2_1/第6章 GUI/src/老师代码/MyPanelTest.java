/**
 * �ļ�����MyPanelTest.java
 * ��Ŀ-������6�� GUI - ��ʦ����
 * ���ߣ���ף��
 * �������ڣ�2014-4-23
 */
package ��ʦ����;

/**
 * @author ��ף��
 * ������MyPanelTest
 * ��˵����
 */
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * �ļ�����MyPanelTest.java
 * ��Ŀ-����test - 
 * ���ߣ���ף��
 * �������ڣ�2014-4-17
 */

/**
 * @author ��ף��
 * ������MyPanelTest
 * ��˵����
 */
public class MyPanelTest
{

	/**
	 * ����˵����
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		
		frame.setLayout(new FlowLayout());
		
		frame.setSize(500, 500);
		frame.setLocation(200, 300);
		
		JPanel panel = new JPanel();
		panel.setLocation(50, 50);
		panel.setSize(200, 100);
		panel.setBackground(Color.blue);
		
		JButton button = new JButton("ok");
		
		JTextField textField = new JTextField("���ϴ�ѧ",10);
		
		JLabel jLabel = new JLabel("tishi");
		
		panel.add(button);
		panel.add(textField);
		panel.add(jLabel);
		
		frame.add(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		
		

	}

}
