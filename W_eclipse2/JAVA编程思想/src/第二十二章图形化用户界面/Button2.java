/**
 * �ļ�����Button2.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮ����ͼ�λ��û�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-8
 */
package �ڶ�ʮ����ͼ�λ��û�����;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * @author ���ĵ�
 * ������Button2
 * ��˵����
 */
public class Button2 extends JFrame
{
	private JButton b1 = new JButton("11111"),
					b2 = new JButton("22222");
	private JTextField txt = new JTextField(10);
	class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			String name = ((JButton)e.getSource()).getText();
			txt.setText(name);
		}
	}
	private ButtonListener bl = new ButtonListener();
	public Button2(){
		b1.addActionListener(bl);
		b2.addActionListener(bl);
		setLayout(new FlowLayout());
		add(b1);
		add(b2);
		add(txt);
	}
	public static void main(String args[])
	{
		SwingConsole.run(new Button2(), 200, 150);
	}
}
