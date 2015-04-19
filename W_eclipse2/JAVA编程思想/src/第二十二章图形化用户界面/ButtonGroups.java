/**
 * �ļ�����ButtonGroups.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮ����ͼ�λ��û�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-8
 */
package �ڶ�ʮ����ͼ�λ��û�����;

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
 * @author ���ĵ�
 * ������ButtonGroups
 * ��˵����������Ӿ��衣
 */
public class ButtonGroups extends JFrame
{
	private static String[] ids = {"June","Ward","Beaver","Wally","Eddie","Lumpy"};
	static JPanel makeBPanel(Class<? extends AbstractButton> kind ,String[] ids)
	{
		ButtonGroup bg = new ButtonGroup(); //����ť��ӵ�����
				//��������Ϊһ�鰴ť����һ����⣨multiple-exclusion��������
		JPanel jp = new JPanel();
		String title = kind.getName();
		title = title.substring(title.lastIndexOf('.')+1);
					//����һ���µ��ַ��������Ǵ��ַ�����һ�����ַ����������ַ�����ָ�����������ַ���ʼ��ֱ�����ַ���ĩβ	
		jp.setBorder(new TitledBorder(title));
		for(String id:ids){
			AbstractButton ab = new JButton("failed");
			try{
				Constructor ctor = kind.getConstructor(String.class);
						//����һ�� Constructor ��������ӳ�� Class ��������ʾ�����ָ���������췽��
				ab = (AbstractButton) ctor.newInstance(id);
						//ʹ�ô� Constructor �����ʾ�Ĺ��췽���������ù��췽�������������ʵ��������ָ���ĳ�ʼ��������ʼ����ʵ��
			}catch (Exception e) {
				System.err.println("Can't creat "+kind);
			}
			bg.add(ab);   // ButtonGroup��������(JToggleButton,JCheckBox,JradioButton)����
			             //����û�з��ڰѰ�ť����    ��ť���У�������~~~
			
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
