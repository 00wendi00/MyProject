/**
 * �ļ�����GridLayout.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮ����ͼ�λ��û�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-8
 */
package �ڶ�ʮ����ͼ�λ��û�����;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author ���ĵ�
 * ������GridLayout
 * ��˵����
 */ 
public class GridLayout123 extends JFrame
{
	public GridLayout123(){
		setLayout(new GridLayout(7,3));
		for(int i =0;i<19;i++)
			add(new JButton("Button"+i));
	}
	public static void main(String args[])
	{
		SwingConsole.run(new GridLayout123(), 300, 300);
	}
}
