/**
 * 文件名：CopyOfTestJpanel.java
 * 项目-包：第6章 GUI - haha
 * 作者：张文迪
 * 创建日期：2014-4-27
 */
package haha;

/**
 * @author 张文迪
 * 类名：CopyOfTestJpanel
 * 类说明：
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
 * 文件名：TestJpanel.java
 * 项目-包：testVehicle - 
 * 作者：胡祝华
 * 创建日期：2014-4-18
 */

/**
 * @author 胡祝华 类名：TestJpanel 类说明：
 */
public class CopyOfTestJpanel implements ActionListener{
	private static CopyOfTestJpanel listener;
	JButton button;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		button.setText("确定");
	}

	public void launchFrame()
	{
		JFrame frame = new JFrame();//顶级容器默认的布局管理器是borderlayout
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setLayout(new FlowLayout());
		
		frame.setBounds(20, 40, 500, 400);
		
		JPanel panel = new JPanel(); //非顶级容器默认布局管理器是flowlayout,流式布局管理器
		panel.setBounds(10, 10, 10, 10);
		panel.setBackground(Color.cyan);
		
		button = new JButton("ok");
		JButton button1 = new JButton("cancel");
		
		JLabel label = new JLabel("海南大学");
		JTextField textField = new JTextField("hello",10);
		JTextArea jTextArea = new JTextArea(10,5);
		
		Object obj[]={textField,jTextArea};
		MyListener myListener = new MyListener(obj);//实例化一个监听器
		button.addActionListener(this); //给按钮添加或注册一个监听器
		button1.addActionListener(this);
		
		panel.add(button);
		panel.add(button1);
		panel.add(label);
		panel.add(textField);
		panel.add(jTextArea);
		frame.addKeyListener(myListener);
		
		
		frame.add(panel);
		
		frame.setFocusable(true);
		frame.pack();//调整组件和窗口大小，使得他们能够刚好显示出来。
		
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
						((JTextArea)obj[i]).setText("海南大学");
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

