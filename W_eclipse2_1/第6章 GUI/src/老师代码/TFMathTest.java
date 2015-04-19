/**
 * 文件名：TFMathTest.java
 * 项目-包：第6章 GUI - 老师代码
 * 作者：胡祝华
 * 创建日期：2014-4-23
 */
package 老师代码;

/**
 * @author 胡祝华
 * 类名：TFMathTest
 * 类说明：
 */


/**
 * 持有对方引用 - 比TFMathTest2.java更优雅的方式。
 * TFMathTest类似于一个大管家（协调者）。
 */

import java.awt.*;
import java.awt.event.*;

public class TFMathTest extends Frame{
	TextField num1;
	TextField num2;
	TextField sum;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TFMathTest().launchFrame();
	}
	
	public void launchFrame()
	{
		num1 = new TextField();
		num2 = new TextField();
		sum = new TextField();
		num1.setColumns(10);
		num2.setColumns(10);
		sum.setColumns(15);
		setLayout(new FlowLayout());
		//setSize(500, 30);
		Label lblPlus = new Label("+");
		Button btnEqual = new Button("=");
		btnEqual.addActionListener(new MyListener(this));
		add(num1);
		add(lblPlus);
		add(num2);
		add(btnEqual);
		add(sum);
		pack();
		setVisible(true);
	}
}

class MyListener implements ActionListener
{
	private TFMathTest tfmt;
	
	public MyListener(TFMathTest tfmt) {
		this.tfmt = tfmt;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String s1 = tfmt.num1.getText();
		String s2 = tfmt.num2.getText();
		int i1 = Integer.parseInt(s1);
		int i2 = Integer.parseInt(s2);
		tfmt.sum.setText(String.valueOf(i1 + i2));
	}
}



