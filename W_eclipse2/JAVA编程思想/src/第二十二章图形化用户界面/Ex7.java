/**
 * �ļ�����Ex7.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮ����ͼ�λ��û�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-8
 */
package �ڶ�ʮ����ͼ�λ��û�����;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author ���ĵ�
 * ������Ex7
 * ��˵����  ��Ҳ������~~~
 */
class AllAction extends JFrame {
	// The JMenuItem's derivatives JCheckBoxMenuItem, JMenu &
	// JRadioButtonMenuItem will not be shown separately:
	JMenuItem mi = new JMenuItem("Menu Item");   //�˵��е����ʵ��
	JTextField txt = new JTextField(30);
	JButton b1 = new JButton("Button 1");
	JComboBox jcb = new JComboBox(new String[]{   //����ť��ɱ༭�ֶ��������б���ϵ����
			"Elements", "To", "Place", "In", "Combobox"
	});
	JFileChooser jfc = new JFileChooser(".");  //JFileChooser Ϊ�û�ѡ���ļ��ṩ��һ�ּ򵥵Ļ�
	public AllAction() {
		setLayout(new FlowLayout());
		add(mi);
		add(txt);
		add(b1);
		add(jcb);
		add(jfc);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt.setText("Button pressed");
			}
		});
	txt.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(
				null,
				"JTexfField ActionListener fired",
				"information",
		JOptionPane.INFORMATION_MESSAGE);
		}
	});
	jcb.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		txt.setText("JComboBox selected: " +
				jcb.getSelectedItem());
		}
	});
	jfc.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			txt.setText(
				"FileChooser ActionListener fired: " +
				jfc.getSelectedFile());
		}
	});
	mi.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			txt.setText("JMenuItem selected");
		}
	});
	}	
}
public class Ex7 
{
	public static void main(String args[]) 
	{
		SwingConsole.run(new AllAction(), 550, 400);
	}
}

