import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class StartFrame extends JFrame 
{
     JButton button1,button2,button3,button4,button5;
     
	StartFrame()
	{    

		   button1=new JButton(new ImageIcon("./image/1.jpg"));
	       button2=new JButton(new ImageIcon("./image/2.jpg"));
	       button3=new JButton(new ImageIcon("./image/3.jpg"));
	       button4=new JButton(new ImageIcon("./image/4.jpg"));
	     
	       button1.setBounds(550, 150,198,70);
	       button2.setBounds(550, 237,198,70);
	       button3.setBounds(550, 315,198,70);
	       button4.setBounds(550, 400,198,70);
	       
	       
	       button1.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) 
			{
				
				dispose();
			    HitMouseFrame  frame=new HitMouseFrame();		    
		        frame.setVisible(true);             //显示窗体	        
		        new Thread(frame).start();          //启动线程     
			}
		});
	      
	       button2.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) 
				{
					JOptionPane.showMessageDialog(null, "这是设置设置");
					
				}
			});
	       button3.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) 
				{
					
					JOptionPane.showMessageDialog(null, "这是非一般的打地鼠。总共有4个关卡，最后击败大魔王之后" +
							"会有惊喜哦！！！");
				}
			});
	       button4.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) 
				{
					
					JOptionPane.showConfirmDialog(null, "你确定要离开这好玩的游戏么？慎重~");
				}
			}); 
	       
	       
	     
	       getContentPane().setLayout(null);
	       getContentPane().add(button1);
	       getContentPane().add(button2);
	       getContentPane().add(button3);
	       getContentPane().add(button4);
	      
 	      
             ImageIcon img=new ImageIcon("./image/Start.jpg"); 
             final JLabel backLabel=new JLabel();            //创建显示背景的标签   
             backLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
             this.setBounds(250,100,img.getIconWidth(),img.getIconHeight());
             backLabel.setIcon(img);                         //添加背景到标签
             this.getContentPane().add(backLabel);           //添加背景标签到窗体	
             this.setVisible(true);
             this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
             
             
	}
	

 }
		

