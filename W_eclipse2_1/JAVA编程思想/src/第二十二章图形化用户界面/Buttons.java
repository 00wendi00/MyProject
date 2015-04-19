/**
 * �ļ�����Buttons.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮ����ͼ�λ��û�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-8
 */
package �ڶ�ʮ����ͼ�λ��û�����;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;

/**
 * @author ���ĵ�
 * ������Buttons
 * ��˵����
 */
public class Buttons extends JFrame
{
	private JButton jb = new JButton("JBUtton");
	private BasicArrowButton
		up = new BasicArrowButton(BasicArrowButton.NORTH),// ��������
		down = new BasicArrowButton(BasicArrowButton.SOUTH),
		right = new BasicArrowButton(BasicArrowButton.EAST),
		left = new BasicArrowButton(BasicArrowButton.WEST);
	public Buttons(){
		setLayout(new FlowLayout());
		add(jb);
		add(new JToggleButton("JToggleButton"));//��ťѡ��
		add(new JCheckBox("JCheckBox"));//��ѡ��
		add(new JRadioButton("JRadioButton"));//Բ��ѡ��
		JPanel jp = new JPanel();
		jp.setBorder(new TitledBorder("directions"));
		jp.add(up);
		jp.add(down);
		jp.add(left);
		jp.add(right);
		add(jp);
	}
	public static void main(String args[]){
		SwingConsole.run(new Buttons(), 350, 200);
	}
}
