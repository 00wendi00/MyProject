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
		        frame.setVisible(true);             //��ʾ����	        
		        new Thread(frame).start();          //�����߳�     
			}
		});
	      
	       button2.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) 
				{
					JOptionPane.showMessageDialog(null, "������������");
					
				}
			});
	       button3.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) 
				{
					
					JOptionPane.showMessageDialog(null, "���Ƿ�һ��Ĵ�����ܹ���4���ؿ��������ܴ�ħ��֮��" +
							"���о�ϲŶ������");
				}
			});
	       button4.addActionListener(new ActionListener() {
				
				
				public void actionPerformed(ActionEvent e) 
				{
					
					JOptionPane.showConfirmDialog(null, "��ȷ��Ҫ�뿪��������Ϸô������~");
				}
			}); 
	       
	       
	     
	       getContentPane().setLayout(null);
	       getContentPane().add(button1);
	       getContentPane().add(button2);
	       getContentPane().add(button3);
	       getContentPane().add(button4);
	      
 	      
             ImageIcon img=new ImageIcon("./image/Start.jpg"); 
             final JLabel backLabel=new JLabel();            //������ʾ�����ı�ǩ   
             backLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
             this.setBounds(250,100,img.getIconWidth(),img.getIconHeight());
             backLabel.setIcon(img);                         //��ӱ�������ǩ
             this.getContentPane().add(backLabel);           //��ӱ�����ǩ������	
             this.setVisible(true);
             this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
             
             
	}
	

 }
		

