/**
 * �ļ�����HelloSwing2.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮ����ͼ�λ��û�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-8
 */
package �ڶ�ʮ����ͼ�λ��û�����;

import java.awt.FlowLayout;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

/**
 * @author ���ĵ�
 * ������HelloSwing2
 * ��˵���������  SwingUtilities.invokeLater  ʵ��Swingʱ��ַ��߳�   ~~
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
		//Swingʹ�÷���           //���� doRun.run() �� AWT �¼�ָ���߳����첽ִ�С������й���� AWT �¼��������ŷ���
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
