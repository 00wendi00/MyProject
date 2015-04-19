/**
 * �ļ�����CopyOfTestJpanel.java
 * ��Ŀ-������6�� GUI - haha
 * ���ߣ����ĵ�
 * �������ڣ�2014-4-27
 */
package haha;

/**
 * @author ���ĵ�
 * ������CopyOfTestJpanel
 * ��˵����
 */
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * �ļ�����TestJpanel.java
 * ��Ŀ-����testVehicle - 
 * ���ߣ���ף��
 * �������ڣ�2014-4-18
 */

/**
 * @author ��ף�� ������TestJpanel ��˵����
 */
public class CopyOfTestJpanel implements ActionListener{
	private static CopyOfTestJpanel listener;
	JButton button;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		button.setText("ȷ��");
	}

	public void launchFrame()
	{
		JFrame frame = new JFrame();//��������Ĭ�ϵĲ��ֹ�������borderlayout
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setLayout(new FlowLayout());
		
		frame.setBounds(20, 40, 500, 400);
		
		JPanel panel = new JPanel(); //�Ƕ�������Ĭ�ϲ��ֹ�������flowlayout,��ʽ���ֹ�����
		panel.setBounds(10, 10, 10, 10);
		panel.setBackground(Color.cyan);
		
		button = new JButton("ok");
		JButton button1 = new JButton("cancel");
		
		JLabel label = new JLabel("���ϴ�ѧ");
		JTextField textField = new JTextField("hello",10);
		JTextArea jTextArea = new JTextArea(10,5);
		
		Object obj[]={textField,jTextArea};
		MyListener myListener = new MyListener(obj);//ʵ����һ��������
		button.addActionListener(this); //����ť��ӻ�ע��һ��������
		button1.addActionListener(this);
		
		panel.add(button);
		panel.add(button1);
		panel.add(label);
		panel.add(textField);
		panel.add(jTextArea);
		frame.addKeyListener(myListener);
		
		
		frame.add(panel);
		
		frame.setFocusable(true);
		frame.pack();//��������ʹ��ڴ�С��ʹ�������ܹ��պ���ʾ������
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);		
	}
	
	public static void main(String[] args) {
		//new CopyOfTestJpanel().launchFrame();
		MyFrame myFrame = new MyFrame();
		myFrame.setBounds(10, 10, 200, 200);
		
		//myFrame.pack();
		
		myFrame.setVisible(true);
		
		
	}
}

class MyFrame extends JFrame
{

	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		g.setColor(Color.blue);
		g.fill3DRect(40, 40, 20, 20, true);
	}
	
}

class MyListener1 implements ActionListener,KeyListener
{
	Object obj[];
	
     public MyListener1(Object obj[])
     {
    	 this.obj = obj;
     }
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object object = e.getSource();
		
		if(object instanceof JButton)
		{
			JButton button = (JButton)object;
			
			if(button.getText().equals("ok"))
			{
				for (int i = 0; i < obj.length; i++) {
					if(obj[i] instanceof JTextField)
					{
						((JTextField)obj[i]).setText("java");
					}
					else if(obj[i] instanceof JTextArea)
					{
						((JTextArea)obj[i]).setText("���ϴ�ѧ");
					}	
				}		
			}
			else if(button.getText().equals("cancel"))
			{
				for (int i = 0; i < obj.length; i++) {
					if(obj[i] instanceof JTextField)
					{
						((JTextField)obj[i]).setText("");
					}
					else if(obj[i] instanceof JTextArea)
					{
						((JTextArea)obj[i]).setText("");
					}	
				}					
			}
		}
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("hello");
		
		for (int i = 0; i < obj.length; i++) {
			if(obj[i] instanceof JTextField)
			{
				JTextField textField = (JTextField)((JTextField)obj[i]);
				textField.setText("hello");
				textField.repaint();
				
			}
			else if(obj[i] instanceof JTextArea)
			{
				JTextArea textArea = ((JTextArea)obj[i]);
				textArea.setText("");
				textArea.repaint();
			}
		}
	    
	}
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

