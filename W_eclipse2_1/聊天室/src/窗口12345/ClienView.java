package 窗口12345;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import org.omg.CORBA.PUBLIC_MEMBER;



/**
 * @author 胡祝华
 * 类名：Test
 * 类说明：
 */


class frame extends JFrame
{
     private JButton bSent;
     private JButton bConnect;
     private JButton bDisConnect;
     
     private JTextArea talkArea;
     private JTextField tMessage;
     JList myList;
     
     private JPanel panel,panel1,panel2;
     private JScrollPane userRollPane,talkRoomRollPane;
     private JSplitPane splitPane;
	
	 private Border border = new EtchedBorder(Color.green,Color.yellow);
	
	public  frame(String a)
     {
    	
		setTitle("聊天室");
		
    	Panel panel = new Panel();
    	Panel panel1 = new Panel();
    	Panel panel2 = new Panel();
    	   	
    	talkArea = new JTextArea();
    	tMessage = new JTextField(40);   	
    	bSent = new JButton("输入信息");
    	bConnect = new JButton("连接");
    	bDisConnect = new JButton("断开连接");
    	
    	String[] data = {"大舅子", "宿长", "哈哈", "呵呵"};
    	myList = new JList(data);
    	myList.setBackground(Color.green);
    	myList.setFixedCellWidth(50);
    	
    	userRollPane = new JScrollPane(myList);
    	talkRoomRollPane = new JScrollPane(talkArea);
    	talkArea.setEditable(false);//不能编辑
    	talkArea.setLineWrap(true);//自动换行
    	talkRoomRollPane.setBorder(border);
    	
    	panel1.add(tMessage);
    	panel1.add(bSent);
    	panel2.add(bConnect);
    	panel2.add(bDisConnect);
    	
    	panel.add(panel1);
    	panel.add(panel2);
    	panel.setLayout(new GridLayout(2,1));
    	    	
    	splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT , userRollPane, talkRoomRollPane);
        splitPane.setOneTouchExpandable(true);
    	    	    	    	
    	setLayout(new BorderLayout());
    	
    	add(splitPane,BorderLayout.CENTER);
    	add(panel,BorderLayout.SOUTH);
    	   	
    	setBounds(0, 0, 600, 600);
    	setVisible(true);
    	
    	//注册监听器
    	bSent.addActionListener(new Controller());
    	bConnect.addActionListener(new Controller());
    	bDisConnect.addActionListener(new Controller());
    	tMessage.addActionListener(new Controller());
    	
    	this.addWindowListener(new WindowAdapter()
		{
    		public void windowClosing(WindowEvent arg0)
			{
				
				System.exit(0);
			}
		});
    	
     }
	public class Controller implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if((e.getSource())instanceof JButton)	
			{
				JButton jButton = (JButton)e.getSource();
				if(jButton == bSent)
				{
					talkArea.setText(tMessage.getText());
				}
				else if(jButton == bConnect)
				{
					
				}
				else if(jButton == bDisConnect)
				{
					System.out.println(1);
				}
			}
			else 
			{
				
			}
		}
		
	}
}



