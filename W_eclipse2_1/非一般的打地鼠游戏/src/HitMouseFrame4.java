import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.omg.CORBA.PUBLIC_MEMBER;


class HitMouseFrame4 extends JFrame implements Runnable 
{
	     boolean flag = true; 
	     JLabel label1,label2,labelMaster;
	     int time=10;
	     int blood=30;
	    
     
    public HitMouseFrame4() 
      {      super();
             this.setResizable(false);                      //��ֹ���������С
             this.getContentPane().setLayout(null);         //���岻ʹ�ò��ֹ�����
             this.setTitle("��һ��Ĵ����֮��ս��ħ��");                   //���ô������
             this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
             label1=new JLabel("��ս��ħ����Ӫ�ȹ���");
             label2=new JLabel("��ʣ"+"10"+"��");
             labelMaster=new JLabel();
             
             
             
             
           

             ImageIcon imgMaster=new ImageIcon("./image/master.png");    //��ʼ������ͼƬ����
             labelMaster.setSize(imgMaster.getIconWidth(),imgMaster.getIconHeight());//���ñ�ǩ�����ͼƬ��ͬ��С
             
           
             
     
             Toolkit tk=Toolkit.getDefaultToolkit();  // ������ɴ��ӵ���״
             Image chuizi=tk.getImage("./image/����.png");  
             Cursor cu=tk.createCustomCursor(chuizi,new Point(10,10),"stick");  
             this.setCursor(cu);
             
             
             
             label1.setSize(400,40); 
       	     label1.setLocation(70, 30);
        	 label1.setFont(new Font("����",Font.BOLD,32));
         	 label1. setForeground(Color.YELLOW);
       	     label2.setSize(200,40); 
    	     label2.setLocation(500, 30);
    	     label2.setFont(new Font("����",Font.BOLD,40));
    	     label2. setForeground(Color.YELLOW);
    	     labelMaster.setLocation(300, 100);
    	     this.getContentPane().add(label1);  
             this.getContentPane().add(label1);  
             this.getContentPane().add(label2);  
             this.getContentPane().add(labelMaster);
       
             ImageIcon img=new ImageIcon("./image/background3.jpg"); 
             final JLabel backLabel=new JLabel();            //������ʾ�����ı�ǩ   
             backLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
             this.setBounds(250,100,img.getIconWidth(),img.getIconHeight());
             backLabel.setIcon(img);                         //��ӱ�������ǩ
             this.getContentPane().add(backLabel);           //��ӱ�����ǩ������		

               
             
             
             
             labelMaster.addMouseListener(new MouseAdapter()
             {
            	 public void mouseClicked(MouseEvent e)
            	 {     Object source=e.getSource();  
            	       if(source instanceof JLabel)    //����¼��Ǳ�ǩ���
            	       {
            	    	   JLabel label=(JLabel)source;
            	    	   if(label.getIcon() == null)
         		      		 {  
         		            		
         		      		 }
         		      	 else 
         		      		 { 
         		      		
         		      		    blood--; 
            	              }
            	 }
            	 
             }
             }
             
             );
             
             
             
                 
  }
     

    

 
 /**
  * �̵߳ĺ��ķ���
  */
 
 public void run()
 {
    while(flag)                           //ʹ������ѭ��
    {                              
       try
       {
    	   
    	    if(labelMaster.getIcon()==null)
    	    {
    	    	Thread.sleep(1000);
               labelMaster.setIcon(new ImageIcon("./image/master.png")); 
    	    }
    	   
             if(time>0)
             {  
            	 Thread.sleep(1000);	
		         time--;
      	         label2.setText("��ʣ"+time+"��");
             }
             
             if(time==0)
             {   flag=false;
            	 JOptionPane.showMessageDialog(null, "��~~~��ħ�������˹���������");
            	 JOptionPane.showMessageDialog(null, "����������������");
            	 dispose();
            	 time=10;
            	 HitMouseFrame4  frame=new HitMouseFrame4();		    
       	         frame.setVisible(true);             //��ʾ����	        
       	         new Thread(frame).start();          //�����߳�          	 
             }
             
             if (blood>0)
			 {
				
			 }
			else
			{   flag=false;
				JOptionPane.showMessageDialog(null, "���ɹ���ɱ�˴�ħ�����ȳ��˹���~");
           	    JOptionPane.showMessageDialog(null, "����Ҫ����������");
                dispose();
                EndFrame endFrame =new EndFrame();
                
			}

             
           }
         
       
       catch(Exception e)
       {
          e.printStackTrace();
        }
   }
 }
 
 
 
}
