/**
 * 文件名：Ex7.java
 * 项目-包：JAVA编程思想 - 第二十二章图形化用户界面
 * 作者：张文迪
 * 创建日期：2014-11-8
 */
package 第二十二章图形化用户界面;

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
 * @author 张文迪
 * 类名：Ex7
 * 类说明：  我也是醉了~~~
 */
class AllAction extends JFrame {
	// The JMenuItem's derivatives JCheckBoxMenuItem, JMenu &
	// JRadioButtonMenuItem will not be shown separately:
	JMenuItem mi = new JMenuItem("Menu Item");   //菜单中的项的实现
	JTextField txt = new JTextField(30);
	JButton b1 = new JButton("Button 1");
	JComboBox jcb = new JComboBox(new String[]{   //将按钮或可编辑字段与下拉列表组合的组件
			"Elements", "To", "Place", "In", "Combobox"
	});
	JFileChooser jfc = new JFileChooser(".");  //JFileChooser 为用户选择文件提供了一种简单的机
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

