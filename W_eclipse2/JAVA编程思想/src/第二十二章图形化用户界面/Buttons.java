/**
 * 文件名：Buttons.java
 * 项目-包：JAVA编程思想 - 第二十二章图形化用户界面
 * 作者：张文迪
 * 创建日期：2014-11-8
 */
package 第二十二章图形化用户界面;

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
 * @author 张文迪
 * 类名：Buttons
 * 类说明：
 */
public class Buttons extends JFrame
{
	private JButton jb = new JButton("JBUtton");
	private BasicArrowButton
		up = new BasicArrowButton(BasicArrowButton.NORTH),// 上下左右
		down = new BasicArrowButton(BasicArrowButton.SOUTH),
		right = new BasicArrowButton(BasicArrowButton.EAST),
		left = new BasicArrowButton(BasicArrowButton.WEST);
	public Buttons(){
		setLayout(new FlowLayout());
		add(jb);
		add(new JToggleButton("JToggleButton"));//按钮选择
		add(new JCheckBox("JCheckBox"));//打勾选择
		add(new JRadioButton("JRadioButton"));//圆点选择
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
