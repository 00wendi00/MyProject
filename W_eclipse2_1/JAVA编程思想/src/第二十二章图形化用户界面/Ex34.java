/**
 * �ļ�����Ex3.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮ����ͼ�λ��û�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-8
 */
package �ڶ�ʮ����ͼ�λ��û�����;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author ���ĵ�
 * ������Ex3
 * ��˵����
 */
@SuppressWarnings("serial")
public class Ex34 extends JFrame
{
	private JButton jButton1 = new JButton("1"),
					jButton2 = new JButton("2");
	public Ex34(){
		setLayout(new FlowLayout());
		add(jButton1);
		add(jButton2);
	}
	public static void main(String args[])
	{
		SwingConsole.run(new Ex34(), 200, 200);
	}
}
