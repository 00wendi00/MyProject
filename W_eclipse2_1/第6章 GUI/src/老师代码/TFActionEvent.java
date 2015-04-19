/**
 * 文件名：TFActionEvent.java
 * 项目-包：第6章 GUI - 老师代码
 * 作者：张文迪
 * 创建日期：2014-4-27
 */
package 老师代码;

/**
 * @author 张文迪
 * 类名：TFActionEvent
 * 类说明：
 */

import java.awt.*;
import java.awt.event.*;

public class TFActionEvent
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new TFFrame();
	}

}

class TFFrame extends Frame
{
	TFFrame()
	{
		TextField tf = new TextField();
		add(tf);
		tf.addActionListener(new TFActionListener());
		pack();
		setVisible(true);
	}
}

class TFActionListener implements ActionListener
{
	public void actionPerformed(ActionEvent e)
	{
		TextField tf = (TextField) e.getSource();
		System.out.println(tf.getText());
		tf.setText("");
	}
}
