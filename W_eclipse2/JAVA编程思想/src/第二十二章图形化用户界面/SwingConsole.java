/**
 * �ļ�����SwingConsole.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮ����ͼ�λ��û�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-8
 */
package �ڶ�ʮ����ͼ�λ��û�����;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * @author ���ĵ�
 * ������SwingConsole
 * ��˵����
 */
public class SwingConsole
{
	public static void run(final JFrame f,final int width,final int height){
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				f.setTitle(f.getClass().getSimpleName());
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				f.setSize(width, height);
				f.setVisible(true);
			}
		});
	}
}
