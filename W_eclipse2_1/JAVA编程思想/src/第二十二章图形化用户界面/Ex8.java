/**
 * 文件名：Ex8.java
 * 项目-包：JAVA编程思想 - 第二十二章图形化用户界面
 * 作者：张文迪
 * 创建日期：2014-11-8
 */
package 第二十二章图形化用户界面;

import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * @author 张文迪
 * 类名：Ex8
 * 类说明：设置光标setCursor(new Cursor(CROSSHAIR_CURSOR));
 */
class MyClass8 extends JFrame
{
	JFileChooser jc = new JFileChooser(".");
	JButton jb = new JButton("哈哈~~~");
	MyClass8(){
		setLayout(new FlowLayout());
		add(jb);
		add(jc);
		setVisible(true);
		setCursor(new Cursor(CROSSHAIR_CURSOR));  // 这个光标， 我也是醉了！！！
	}
}
public class Ex8
{
	public static void main(String args[]){
		SwingConsole.run(new MyClass8(), 500, 500);
	}
}
