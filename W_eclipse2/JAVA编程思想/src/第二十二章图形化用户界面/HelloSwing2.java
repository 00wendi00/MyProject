/**
 * 文件名：HelloSwing2.java
 * 项目-包：JAVA编程思想 - 第二十二章图形化用户界面
 * 作者：张文迪
 * 创建日期：2014-11-8
 */
package 第二十二章图形化用户界面;

import java.awt.FlowLayout;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * @author 张文迪
 * 类名：HelloSwing2
 * 类说明：用这个  SwingUtilities.invokeLater  实现Swing时间分发线程   ~~
 */
public class HelloSwing2 extends JFrame
{
	JLabel jLabel;
	public HelloSwing2(){
		super("hellow Swing~");
		setLayout(new FlowLayout());
		jLabel = new JLabel("My lable");
		add(jLabel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setVisible(true);
	}
	static HelloSwing2 hs2 ;
	public static void main(String args[]) throws InterruptedException
	{
		SwingUtilities.invokeLater(new Runnable()
		//Swing使用方法           //导致 doRun.run() 在 AWT 事件指派线程上异步执行。在所有挂起的 AWT 事件被处理后才发生
		{	
			public void run()
			{
				hs2 = new HelloSwing2();
			}
		});
		TimeUnit.SECONDS.sleep(2);
		hs2.jLabel.setText("Hey! this is different");
		
		for(int i = 0;i<5;i++){
			TimeUnit.MILLISECONDS.sleep(600);
			JLabel jLabel1 = new JLabel("~~~~~~~~~~~~~~~~~~~~~~~~"+i);
			hs2.add(jLabel1);
			hs2.add(jLabel1);
			hs2.add(jLabel1);
			hs2.setVisible(true);
		}
	}
}
