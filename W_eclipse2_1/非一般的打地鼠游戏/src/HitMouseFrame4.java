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
             this.setResizable(false);                      //禁止调整窗体大小
             this.getContentPane().setLayout(null);         //窗体不使用布局管理器
             this.setTitle("非一般的打地鼠之决战大魔王");                   //设置窗体标题
             this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
             label1=new JLabel("决战大魔王，营救公主");
             label2=new JLabel("还剩"+"10"+"秒");
             labelMaster=new JLabel();
             
             
             
             
           

             ImageIcon imgMaster=new ImageIcon("./image/master.png");    //初始化地鼠图片对象
             labelMaster.setSize(imgMaster.getIconWidth(),imgMaster.getIconHeight());//设置标签与地鼠图片相同大小
             
           
             
     
             Toolkit tk=Toolkit.getDefaultToolkit();  // 将鼠标变成锤子的形状
             Image chuizi=tk.getImage("./image/锤子.png");  
             Cursor cu=tk.createCustomCursor(chuizi,new Point(10,10),"stick");  
             this.setCursor(cu);
             
             
             
             label1.setSize(400,40); 
       	     label1.setLocation(70, 30);
        	 label1.setFont(new Font("宋体",Font.BOLD,32));
         	 label1. setForeground(Color.YELLOW);
       	     label2.setSize(200,40); 
    	     label2.setLocation(500, 30);
    	     label2.setFont(new Font("宋体",Font.BOLD,40));
    	     label2. setForeground(Color.YELLOW);
    	     labelMaster.setLocation(300, 100);
    	     this.getContentPane().add(label1);  
             this.getContentPane().add(label1);  
             this.getContentPane().add(label2);  
             this.getContentPane().add(labelMaster);
       
             ImageIcon img=new ImageIcon("./image/background3.jpg"); 
             final JLabel backLabel=new JLabel();            //创建显示背景的标签   
             backLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
             this.setBounds(250,100,img.getIconWidth(),img.getIconHeight());
             backLabel.setIcon(img);                         //添加背景到标签
             this.getContentPane().add(backLabel);           //添加背景标签到窗体		

               
             
             
             
             labelMaster.addMouseListener(new MouseAdapter()
             {
            	 public void mouseClicked(MouseEvent e)
            	 {     Object source=e.getSource();  
            	       if(source instanceof JLabel)    //如果事件是标签组件
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
  * 线程的核心方法
  */
 
 public void run()
 {
    while(flag)                           //使用无限循环
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
      	         label2.setText("还剩"+time+"秒");
             }
             
             if(time==0)
             {   flag=false;
            	 JOptionPane.showMessageDialog(null, "啊~~~大魔王玷污了公主！！！");
            	 JOptionPane.showMessageDialog(null, "请重新再来！！！");
            	 dispose();
            	 time=10;
            	 HitMouseFrame4  frame=new HitMouseFrame4();		    
       	         frame.setVisible(true);             //显示窗体	        
       	         new Thread(frame).start();          //启动线程          	 
             }
             
             if (blood>0)
			 {
				
			 }
			else
			{   flag=false;
				JOptionPane.showMessageDialog(null, "您成功击杀了大魔王，救出了公主~");
           	    JOptionPane.showMessageDialog(null, "公主要以身相许！！");
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
