/**
 * 文件名：Face.java
 * 项目-包：JAVA编程思想 - 第二十二章图形化用户界面
 * 作者：张文迪
 * 创建日期：2014-11-8
 */
package 第二十二章图形化用户界面;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author 张文迪
 * 类名：Face
 * 类说明：这个路径啊，搞不懂，这个例子回头看~~~
 */

public class Face s extends JFrame
{
	private static Icon[] faces;
	private JButton jb,
					jb2 = new JButton("Disable");
	private boolean mad = false;
	public Faces(){
		faces = new Icon[]{   //一个小的固定大小图片，通常用于装饰组件
				new ImageIcon(getClass().getResource("/000.jpg")),
				new ImageIcon(getClass().getResource("/111.gif")),
				new ImageIcon(getClass().getResource("/222.gif")),
				new ImageIcon(getClass().getResource("/333.jpg")),
				new ImageIcon(getClass().getResource("/444.jpg"))
		};
		jb = new JButton("JButton",faces[3]);//创建一个带初始文本和图标的按钮
		setLayout(new FlowLayout());
		jb.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(mad){
					jb.setIcon(faces[3]);
					mad = false;
				}else{
					jb.setIcon(faces[0]);
					mad = true;
				}
				jb.setVerticalAlignment(JButton.TOP);  //设置图标和文本的垂直对齐方式
				jb.setHorizontalAlignment(JButton.LEFT);//设置图标和文本的水平对齐方式
			}
		});
		jb.setRolloverEnabled(true); //设置 rolloverEnabled 属性，若需要翻转效果，该属性必须为 true
		jb.setRolloverIcon(faces[1]);//设置按钮的翻转图标
		jb.setPressedIcon(faces[2]);//设置按钮的按下图标
		jb.setDisabledIcon(faces[4]);
		jb.setToolTipText("Yow");
		add(jb);
		jb2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(jb.isEnabled()){
					//确定此组件是否已启用。已启用的组件可以响应用户输入并生成事件。默认情况下，组件最初是启用的。
					//调用组件的 setEnabled 方法可以启用或禁用组件
					jb.setEnabled(false);
					jb2.setText("Enable");
				}else 
				{
					jb.setEnabled(true);
					jb2.setText("Disable");
				}
			}
		});
		add(jb2);
	}
	public static void main(String args[])
	{
		SwingConsole.run(new Faces(), 800, 600);
	}
}
