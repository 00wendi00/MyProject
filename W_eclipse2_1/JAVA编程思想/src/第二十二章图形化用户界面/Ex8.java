/**
 * �ļ�����Ex8.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮ����ͼ�λ��û�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-8
 */
package �ڶ�ʮ����ͼ�λ��û�����;

import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * @author ���ĵ�
 * ������Ex8
 * ��˵�������ù��setCursor(new Cursor(CROSSHAIR_CURSOR));
 */
class MyClass8 extends JFrame
{
	JFileChooser jc = new JFileChooser(".");
	JButton jb = new JButton("����~~~");
	MyClass8(){
		setLayout(new FlowLayout());
		add(jb);
		add(jc);
		setVisible(true);
		setCursor(new Cursor(CROSSHAIR_CURSOR));  // �����꣬ ��Ҳ�����ˣ�����
	}
}
public class Ex8
{
	public static void main(String args[]){
		SwingConsole.run(new MyClass8(), 500, 500);
	}
}
