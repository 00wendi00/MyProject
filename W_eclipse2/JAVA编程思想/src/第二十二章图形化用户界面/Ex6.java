/**
 * �ļ�����Ex6.java
 * ��Ŀ-����JAVA���˼�� - �ڶ�ʮ����ͼ�λ��û�����
 * ���ߣ����ĵ�
 * �������ڣ�2014-11-8
 */
package �ڶ�ʮ����ͼ�λ��û�����;

import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import net.mindview.util.Countries;

/**
 * @author ���ĵ�
 * ������Ex6
 * ��˵����
 */
public class Ex6 extends JFrame
{
	private JButton b1 = new JButton("���ȥ��"),
					b2 = new JButton("ɸѡ");
	private JTextArea a1 = new JTextArea(8 ,40),
					  a2 = new JTextArea(8,40);
	private Map<String, String> m = new HashMap<String, String>();
	public Ex6(){
		m.putAll(Countries.capitals());
		b1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				for(Map.Entry me : m.entrySet())
					a1.append(me.getKey()+": "+me.getValue()+"\n");
			}
		});
		b2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String s1 = a1.getText();	
				Collection<String> c = new ArrayList<String>();
											
					Pattern p = Pattern.compile("[aeiou]");
					Matcher m  = p.matcher(s1);
					//while(m.find())
						//s2 += "Match \"" + m.group() + "\" at positions " + m.start() + "-" +
									//	(m.end() - 1) + '\n';
			}
		});
		setLayout(new FlowLayout());
		add(new JScrollPane(a1));
		add(new JScrollPane(a2));
		add(b1);
		add(b2);
	}
	public static void main(String args[])
	{
		SwingConsole.run(new Ex6()	,475, 425);
	}
}	
