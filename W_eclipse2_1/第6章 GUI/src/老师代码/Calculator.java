/**
 * 文件名：Calculator.java
 * 项目-包：第6章 GUI - 老师代码
 * 作者：张文迪
 * 创建日期：2014-4-27
 */
package 老师代码;

/**
 * @author 张文迪
 * 类名：Calculator
 * 类说明：
 */


/*	范例名称：GridLayout应用举例
 * 	源文件名称：TestGridLayout
 *	要  点：GridLayout布局管理器的性质及用法
 */

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator
{
	public static void main(String args[])
	{
		JFrame f = new JFrame("GridLayout Example");
		f.setSize(300, 260);
		f.setLocation(100, 100);
		
		JTextField textField = new JTextField(20);
		textField.setHorizontalAlignment(JTextField.RIGHT);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();

		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(4, 5,5,8));
		JPanel panel5 = new JPanel();
		panel5.setLayout(new GridLayout(4,1,0,8));

		Button button[]=new Button[20];
		Button bt[]=new Button[4];

		String str1[]=new String[]{"7","8","9","/","sqrt",
								  "4","5","6","*","%",
								  "1","2","3","-","1/x",
								  "0","+/-",".","+","="
								  };
		for (int i = 0; i < 20; i++)
		{
			button[i] = new Button(str1[i]);
			panel4.add(button[i]);
		}
		
		String str[]=new String[]{"MC","MR","MS","M+"};
		
		for (int i = 0; i < 4; i++)
		{
			bt[i] = new Button(str[i]);
			panel5.add(bt[i]);
		}
		
		panel3.setLayout(new BorderLayout(10,0));
		panel3.add(panel4,BorderLayout.CENTER);
		panel3.add(panel5,BorderLayout.WEST);
		
		Button button1 = new Button("C");
		Button button2 = new Button("CE");
		Button button3 = new Button("BackSpace");
		
		
		panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		panel2.add(button3);
		panel2.add(button2);
		panel2.add(button1);
		
		panel.setLayout(new BorderLayout());
		panel.add(panel2,BorderLayout.NORTH);
		panel.add(panel3,BorderLayout.CENTER);
		
		f.getContentPane().add(textField,BorderLayout.NORTH);
		f.getContentPane().add(panel,BorderLayout.CENTER);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		f.setVisible(true);
	}
}
