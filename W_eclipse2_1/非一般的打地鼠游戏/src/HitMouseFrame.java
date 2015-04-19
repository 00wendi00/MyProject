import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


class HitMouseFrame extends JFrame implements Runnable 
{
	       Mouse[] mouses;               //创建显示地鼠的标签数组    
	       JLabel scorelabel,scorelabe2,classJLabel;             //创建显示分数的标签数组    
	       int score=0; 
	       int guanqiaflage;  //
	       boolean flag = true; 
	       int k=0,n=0,m=0;
	    
  
   
     public HitMouseFrame() 
      {      super();
             this.setResizable(false);                      //禁止调整窗体大小
             this.getContentPane().setLayout(null);         //窗体不使用布局管理器
             this.setTitle("非一般的打地鼠之初战农场");                   //设置窗体标题
             this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
             
     
             mouses=new Mouse[9]; 
             scorelabel=new JLabel("得分"+0);
             scorelabe2=new JLabel("跑掉的老鼠"+0);
             classJLabel=new JLabel("关卡 1：初战农场");
             int i=0;
             int guanqiaflage=1;
             
             
             this.addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{					
					super.windowClosing(e);
					System.exit(0);
				}
				
			});
             
           
   	        for(i=0;i<9;i++)            //遍历数组
   	        {                          
   	            mouses[i]=new Mouse();                    //初始化每一个数组元素
   	       
     	        mouses[i].addMouseListener(new MouseAdapter()  //为标签添加鼠标事件监听适配器
     	    {   
     	        	
     	        public void mouseClicked(MouseEvent e)
   		          {     Object source=e.getSource();        //获取事件源，即地鼠标签
   		       
   		            if(source instanceof JLabel)       //如果事件是标签组件
   		             {   
   		            	JLabel mouse=(JLabel)source;    //强制转换为JLabel标签
   		            	if(mouse.getIcon() == null)
   		      		 {  
   		            		
   		      		 }
   		      		 else 
   		      		 {
   		      			 score+=10;		            	
   		      			 mouse.setIcon(null);            //取消标签图标
   		      			 m++;
   		      			 scorelabel.setText("得分"+score);  
   		      		 }
   		            	
   		            	 		         
   		             }
   		           }         	    
   		   } 	    
     	     );
     	        
     	 
   		   this.getContentPane().add(mouses[i]);       //添加显示地鼠的标签到窗体
   		   
   }
             
      
      	  mouses[0].setLocation(130, 230);                //设置每个标签的位置
   	      mouses[1].setLocation(330,175);
   	      mouses[2].setLocation(300, 295);	      
     	  mouses[3].setLocation(130, 355); 
   	      mouses[4].setLocation(515, 240);     
    	  mouses[5].setLocation(430, 370);    	  
     	  mouses[6].setLocation(680, 175); 
   	      mouses[7].setLocation(785, 265);     
    	  mouses[8].setLocation(650, 330);
    	  
        
    	         
    	  classJLabel.setSize(500,30);
    	  classJLabel.setLocation(100, 30);  	  
    	  classJLabel.setFont(new Font("宋体",Font.BOLD,30));
    	  
    	 
    	  scorelabel.setSize(200,30); 
    	  scorelabel.setLocation(420, 30);
    	  scorelabel.setFont(new Font("宋体",Font.BOLD,30));
    	  
    	 
    	  scorelabe2.setSize(200,30); 
    	  scorelabe2.setLocation(550, 30);
    	  scorelabe2.setFont(new Font("宋体",Font.BOLD,30));

  
          Toolkit tk=Toolkit.getDefaultToolkit();  // 将鼠标变成锤子的形状
          Image chuizi=tk.getImage("./image/锤子.png");  
          Cursor cu=tk.createCustomCursor(chuizi,new Point(10,10),"stick");  
          this.setCursor(cu);
         

          this.getContentPane().add(classJLabel);         
          this.getContentPane().add(scorelabel);  
          this.getContentPane().add(scorelabe2);
          ImageIcon img=new ImageIcon("./image/background1.jpg"); 
          final JLabel backLabel=new JLabel();            //创建显示背景的标签   
          backLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
          this.setBounds(250,100,img.getIconWidth(),img.getIconHeight());
          backLabel.setIcon(img);                         //添加背景到标签
          this.getContentPane().add(backLabel);           //添加背景标签到窗体		
       

            
                 
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
          Thread.sleep(500);                       //使线程休眠0.3秒
          int index=(int)(Math.random()*9);       //生成随机的地鼠索引
          if( mouses[index].getIcon()==null)    //如果地鼠标签没有设置图片
          {    	int indexx=(int)(Math.random()*4); 
				switch (indexx)
				{
					case 1:  { mouses[index].setIcon(new ImageIcon("./image/地鼠1.png"));    //为该标签添加地鼠图片
				                break;  }
				                
					case 2:  { mouses[index].setIcon(new ImageIcon("./image/地鼠2.png"));    //为该标签添加地鼠图片
					             break;  }
					case 3:  { mouses[index].setIcon(new ImageIcon("./image/地鼠3.png"));    //为该标签添加地鼠图片
					              break;  }
					case 0:  { mouses[index].setIcon(new ImageIcon("./image/地鼠4.png"));    //为该标签添加地鼠图片
					              break;  }
					default:
						         break;
		         }
		
		   if(score<100)
				   {
					   Thread.sleep(800);      //使线程休眠 0.8秒  
					   mouses[index].setIcon(null);
					   n++;
					   scorelabe2.setText("跑掉的老鼠"+(n-m));
				   }
		   if (score>=100)	
        	{   
			    JOptionPane.showMessageDialog(null, "恭喜进入下一关");
			    flag=false;			    
    		    dispose();
      		    HitMouseFrame2  frame2=new HitMouseFrame2();		    
      	        frame2.setVisible(true);             //显示窗体	        
      	        new Thread(frame2).start();          //启动线程     
      	        
      	   }

	       
		
		  
		      
	   	
	   
           if(n-m==12)
		   {
        	    
			    JOptionPane.showMessageDialog(null, "很不幸！ 跑掉的老鼠太多！ 你挂彩啦！！！");
			    JOptionPane.showMessageDialog(null, "请重新再来！！！");
			    dispose();
			    HitMouseFrame  frame=new HitMouseFrame();		    
    	        frame.setVisible(true);             //显示窗体	        
    	        new Thread(frame).start();          //启动线程
		   }
             
        }
       }
       
       catch(InterruptedException e)
       {
          e.printStackTrace();
         
        }
   }
 }
 
 
 
}
