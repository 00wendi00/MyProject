/**
 * 文件名：ButtonGroups.java
 * 项目-包：JAVA编程思想 - 第二十二章图形化用户界面
 * 作者：张文迪
 * 创建日期：2014-11-8
 */
package 第二十二章图形化用户界面;

import java.awt.FlowLayout;
import java.lang.reflect.Constructor;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.TitledBorder;

/**
 * @author 张文迪
 * 类名：ButtonGroups
 * 类说明：这个例子精髓。
 */
public class ButtonGroups extends JFrame
{
	private static String[] ids = {"June","Ward","Beaver","Wally","Eddie","Lumpy"};
	static JPanel makeBPanel(Class<? extends AbstractButton> kind ,String[] ids)
	{
		ButtonGroup bg = new ButtonGroup(); //将按钮添加到组中
				//此类用于为一组按钮创建一个多斥（multiple-exclusion）作用域
		JPanel jp = new JPanel();
		String title = kind.getName();
		title = title.substring(title.lastIndexOf('.')+1);
					//返回一个新的字符串，它是此字符串的一个子字符串。该子字符串从指定索引处的字符开始，直到此字符串末尾	
		jp.setBorder(new TitledBorder(title));
		for(String id:ids){
			AbstractButton ab = new JButton("failed");
			try{
				Constructor ctor = kind.getConstructor(String.class);
						//返回一个 Constructor 对象，它反映此 Class 对象所表示的类的指定公共构造方法
				ab = (AbstractButton) ctor.newInstance(id);
						//使用此 Constructor 对象表示的构造方法来创建该构造方法的声明类的新实例，并用指定的初始化参数初始化该实例
			}catch (Exception e) {
				System.err.println("Can't creat "+kind);
			}
			bg.add(ab);   // ButtonGroup是排他的(JToggleButton,JCheckBox,JradioButton)都是
			             //若是没有放在把按钮放在    按钮组中，则不排他~~~
			
			jp.add(ab);
		}
		return jp;
	}
	public ButtonGroups(){
		setLayout(new FlowLayout());
		add(makeBPanel(JButton.class, ids));
		add(makeBPanel(JToggleButton.class, ids));
		add(makeBPanel(JCheckBox.class, ids));
		add(makeBPanel(JRadioButton.class, ids));
		
	}
	public static void main(String args[]){
		SwingConsole.run(new ButtonGroups(), 500, 350);
	}
}
