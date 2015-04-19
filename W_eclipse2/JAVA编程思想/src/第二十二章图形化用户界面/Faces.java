/**
 * �ļ�����Face.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮ����ͼ�λ��û�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-8
 */
package �ڶ�ʮ����ͼ�λ��û�����;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * @author ���ĵ�
 * ������Face
 * ��˵�������·�������㲻����������ӻ�ͷ��~~~
 */

public class Face s extends JFrame
{
	private static Icon[] faces;
	private JButton jb,
					jb2 = new JButton("Disable");
	private boolean mad = false;
	public Faces(){
		faces = new Icon[]{   //һ��С�Ĺ̶���СͼƬ��ͨ������װ�����
				new ImageIcon(getClass().getResource("/000.jpg")),
				new ImageIcon(getClass().getResource("/111.gif")),
				new ImageIcon(getClass().getResource("/222.gif")),
				new ImageIcon(getClass().getResource("/333.jpg")),
				new ImageIcon(getClass().getResource("/444.jpg"))
		};
		jb = new JButton("JButton",faces[3]);//����һ������ʼ�ı���ͼ��İ�ť
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
				jb.setVerticalAlignment(JButton.TOP);  //����ͼ����ı��Ĵ�ֱ���뷽ʽ
				jb.setHorizontalAlignment(JButton.LEFT);//����ͼ����ı���ˮƽ���뷽ʽ
			}
		});
		jb.setRolloverEnabled(true); //���� rolloverEnabled ���ԣ�����Ҫ��תЧ���������Ա���Ϊ true
		jb.setRolloverIcon(faces[1]);//���ð�ť�ķ�תͼ��
		jb.setPressedIcon(faces[2]);//���ð�ť�İ���ͼ��
		jb.setDisabledIcon(faces[4]);
		jb.setToolTipText("Yow");
		add(jb);
		jb2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(jb.isEnabled()){
					//ȷ��������Ƿ������á������õ����������Ӧ�û����벢�����¼���Ĭ������£������������õġ�
					//��������� setEnabled �����������û�������
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
