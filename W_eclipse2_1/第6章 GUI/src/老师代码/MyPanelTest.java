/**
 * 文件名：MyPanelTest.java
 * 项目-包：第6章 GUI - 老师代码
 * 作者：胡祝华
 * 创建日期：2014-4-23
 */
package 老师代码;

/**
 * @author 胡祝华
 * 类名：MyPanelTest
 * 类说明：
 */
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 文件名：MyPanelTest.java
 * 项目-包：test - 
 * 作者：胡祝华
 * 创建日期：2014-4-17
 */

/**
 * @author 胡祝华
 * 类名：MyPanelTest
 * 类说明：
 */
public class MyPanelTest
{

	/**
	 * 方法说明：
	 * @param args
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		
		frame.setLayout(new FlowLayout());
		
		frame.setSize(500, 500);
		frame.setLocation(200, 300);
		
		JPanel panel = new JPanel();
		panel.setLocation(50, 50);
		panel.setSize(200, 100);
		panel.setBackground(Color.blue);
		
		JButton button = new JButton("ok");
		
		JTextField textField = new JTextField("海南大学",10);
		
		JLabel jLabel = new JLabel("tishi");
		
		panel.add(button);
		panel.add(textField);
		panel.add(jLabel);
		
		frame.add(panel);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		
		

	}

}
