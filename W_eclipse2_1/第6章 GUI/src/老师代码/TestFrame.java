/**
 * �ļ�����TestFrame.java
 * ��Ŀ-������6�� GUI - ��ʦ����
 * ���ߣ����ĵ�
 * �������ڣ�2014-4-27
 */
package ��ʦ����;

/**
 * @author ���ĵ�
 * ������TestFrame
 * ��˵����
 */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * �ļ�����TestFrame.java
 * ��Ŀ-����testVehicle - 
 * ���ߣ���ף��
 * �������ڣ�2014-4-20
 */

/**
 * @author ��ף��
 * ������TestFrame
 * ��˵����
 */
public class TestFrame implements ActionListener{

	private JTextField textField;
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton)
		{
			JButton button = (JButton)e.getSource();
			System.out.println(button.getText());
			if(button.getText().equals("ok"))
			{
				textField.setText("how are you");
			}
			else if(button.getText().equals("cancel"))
			{
				textField.setText("hello java");
			}
		}
	}

	/**
	 * ����˵����
	 * @param args
	 */
	/**
	 * ����˵����
	 * @param args
	 */
	public static void main(String[] args) {
         TestFrame frame = new TestFrame();
         frame.launchFrame();
	}
	
	public void launchFrame()
	{
		JFrame  frame = new JFrame();
		
		frame.setLayout(new FlowLayout());
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		
		JButton button = new JButton();
		JButton button1 = new JButton();
		
		button.setText("ok");
		button1.setText("cancel");
		
		textField = new JTextField(10);
		textField.setText("hello java");
		
		JLabel label = new JLabel("���ϴ�ѧ");
		JTextArea textArea = new JTextArea(10,10);
		
		//Object object[]={textField,textArea,label};

		//MyListener1 myListener1 = new MyListener1(object);
		button.addActionListener(this); //�������İ�
		button1.addActionListener(this);
		
		panel.add(button);
		panel.add(button1);
		panel.add(textField);
		panel.add(label);
		panel.add(textArea);
		
		frame.add(panel);
		
		frame.setTitle("hello");
		frame.setBounds(20, 20, 300, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.pack();//�ô��������ܹ���ʾ�����������Ϣ��
		frame.setVisible(true);		
	}
}

/*class MyListener1 implements ActionListener
{
    private Object object[];
    private boolean flag;
	
	public MyListener1(Object object[]) 
	{
		this.object = object;
		flag = false;
	}
	 (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(!flag)
			flag = true;
		else {
			flag = false;
		}
		
		for (int i = 0; i < object.length; i++) {
			if(object[i] instanceof JTextField)
			{
				JTextField textField = (JTextField)object[i];
				if(flag)
				{
				   textField.setText("how are you!");
				}
				else {
					textField.setText("hello java");
				}
			}
			else if(object[i] instanceof JTextArea)
			{
				JTextArea textArea = (JTextArea)object[i];
				textArea.setText("���߲�����");
			}
			else if(object[i] instanceof JLabel)
			{
				JLabel label = (JLabel)object[i];
				label.setText("�廪��ѧ");			
			}
		}
	}
	
}*/
