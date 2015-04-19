/**
 * 文件名：Test.java
 * 项目-包：打地鼠2 - 测试
 * 作者：张文迪
 * 创建日期：2014-6-7
 */
package 测试;




/**
 * @author 张文迪
 * 类名：HitMouse
 * 类说明：
 */

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
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
import javax.swing.JPanel;




public class HitMouse extends JFrame implements Runnable
{
	
	
	    Mouse[] mouses;               //创建显示地鼠的标签数组    
	    JPanel panel1,panel2;
	    JLabel label1,label2;
	    int score1,score2,score3 = 0;
	    boolean boolean1 = false;
	    
	    
	    
   public static void main(String args[])
   {
      EventQueue.invokeLater(    new Runnable()
      {
        public void run()
        {
         try{                      
          HitMouse frame=new HitMouse();     //创建窗体
          frame.setVisible(true);             //显示窗体
           new Thread(frame).start();          //启动线程
            }
          catch(Exception e)
          {
          e.printStackTrace();
           }
       }
      }
                            );
      
   }
   
    public HitMouse()
    {
   	     super();
   	     panel1 = new JPanel();
   	     panel2 = new JPanel();
   	     label1 = new JLabel("关卡"+1);
   	     label2 = new JLabel("恭喜您得分:"+0);
   	     
   	     panel1.add(label1);
   	     panel1.add(label2);
   	     this.setLayout(new BorderLayout());
   	     this.add(panel1,BorderLayout.NORTH);
   	     this.add(panel2,BorderLayout.CENTER);    
   	     
   	     this.setResizable(false); //禁止调整窗体大小
   	     
   	     
         panel2.setLayout(null);         //窗体不使用布局管理器
         this.setTitle("简易的打地鼠游戏");                   //设置窗体标题
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
          
        
       
         mouses=new Mouse[9]; 

         
            
         
         
          
          	  
   	     for(int i=0;i<9;i++)            //遍历数组
   	     {                          
   	         mouses[i]=new Mouse();                    //初始化每一个数组元素   	         	         	            	         	         
     	     mouses[i].addMouseListener(new MouseAdapter()  //为标签添加鼠标事件监听适配器
     	   {  
			
     	    public void mousePressed(MouseEvent e)
			{
				super.mousePressed(e);
				Object source=e.getSource();        //获取事件源，即地鼠标签  		     
 		      	if(source instanceof JLabel)        //如果事件是标签组件
 		      	{     
 		      		JLabel mouse=(JLabel)source;    //制转换为JLabel标签	      		 
 		      		if(mouse.getIcon() == null)
 		      		 {  
 		      		
 		      		 }
 		      		 else 
 		      		 {
 		      			 score1+=10;
 		      			 score3 = 1;
 		      			 if(score1 == 20)
 	 		      		 {
 	 		      			 //JOptionPane.showMessageDialog(null, "恭喜进入下一关");
 	 		      			 label1.setText("关卡"+2);
 	 		      		 }
 		      			 if(score1 == 40)
	 		      		 {
	 		      			 //JOptionPane.showMessageDialog(null, "恭喜进入下一关");
	 		      			 label1.setText("关卡"+3);
	 		      		 }
 		      			 if(score1 == 60)
	 		      		 {
	 		      			 //JOptionPane.showMessageDialog(null, "恭喜进入下一关");
	 		      			 label1.setText("关卡"+4);
	 		      		 }
 		      		 }
 		      		  
 		      		label2.setText("恭喜您得分:"+score1);
			          mouse.setIcon(null);            //取消标签图标
 		      		      
 		      		 
 		      		 
 		      	} 		      	 		      	 		      			      			      	
			}
			public void mouseEntered(MouseEvent e)
			{			
				super.mouseEntered(e);
				Object source=e.getSource();        //获取事件源，即地鼠标签  		     
 		      	if(source instanceof JLabel)
 		      	{
 		      		JLabel mouse=(JLabel)source;
 		      		if(mouse.getIcon() == null)
		      		 {  
		      		
		      		 }
		      		 else 
		      		 {
				          score3 = 1;
		      		 }
 		      	}
			}

			public void mouseExited(MouseEvent e)
			{				
				super.mouseExited(e);
				Object source=e.getSource();        //获取事件源，即地鼠标签  		     
 		      	if(source instanceof JLabel)
 		      	{
 		      		JLabel mouse=(JLabel)source;
 		      		if(mouse.getIcon() == null)
		      		 {  
 		      		     score3 = 0;
		      		 }
		      		 else 
		      		 {
				      
		      		 }
 		      	}
			}
           
			public void mouseReleased(MouseEvent e)
			{
				/*super.mouseReleased(e);
				Object source=e.getSource();        //获取事件源，即地鼠标签  		     
 		      	if(source instanceof JLabel)
 		      	{
 		      		JLabel mouse=(JLabel)source;
 		      		if(mouse.getIcon() == null)
		      		 {  
		      		
		      		 }
		      		 else 
		      		 {
				          score3 = 0;
				          label2.setText("恭喜您得分:"+score1);
				          mouse.setIcon(null);            //取消标签图标
		      		 }
 		      	}*/
			}
			public void mouseClicked(MouseEvent e)
   		     {   
   		    	 		      
   		     }						
   		   }
     	  );
   		   this.getContentPane().add(mouses[i]);       //添加显示地鼠的标签到窗体  		   
   	     }
             
   	  
          ImageIcon img=new ImageIcon("./图片/background1.jpg");
      	  mouses[0].setLocation(330 , 175);                //设置每个标签的位置
   	      mouses[1].setLocation(300, 295);
   	      mouses[2].setLocation(130, 360);
     	  mouses[3].setLocation(515, 240);
   	      mouses[4].setLocation(430, 370);
    	  mouses[5].setLocation(680, 175);
    	  mouses[6].setLocation(785, 265);
   	      mouses[7].setLocation(650 ,330 );
    	  mouses[8].setLocation(130, 230);
  

    	 
    	  
  
  
         final JLabel backLabel=new JLabel();            //创建显示背景的标签   
         backLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
         this.setBounds(400,10,img.getIconWidth(),img.getIconHeight());
         backLabel.setIcon(img);                         //添加背景到标签
         this.getContentPane().add(backLabel);           //添加背景标签到窗体
         this.addWindowListener(new WindowAdapter()       //关闭程序
		{
			public void windowClosing(WindowEvent e)
			{			
				System.exit(0);
			}
        	 
		});
          
        
         
         

		   
         
         
         
         
        
         
         
         
    }
 
 
 /**
  * 线程的核心方法
  */
 
           public void run()
           {       	         	         	   	        	   
        	   while(true)                           //使用无限循环
        	   {                              
        		   try
        		   {    
        			   
        			   
        			   if(score3 == 1)
        		          {
        		          	Toolkit tk=Toolkit.getDefaultToolkit();  // 将鼠标变成锤子的形状
        		  	   		Image chuizi=tk.getImage("./图片/锤子打.png"); /*mouse.gif是你的图标*/				          
        		  	   		Cursor cu=tk.createCustomCursor(chuizi,new Point(),"锤子");  
        		  	   		this.setCursor(cu);	 	     	
        		  	   	    System.out.println(score3+1);
        		          
        		          }
        			   else if(score3 == 0)  
        			   {
        		            Toolkit tk=Toolkit.getDefaultToolkit();  // 将鼠标变成锤子的形状
        		  	   		Image chuizi=tk.getImage("./图片/锤子.png"); /*mouse.gif是你的图标*/				          
        		  	   		Cursor cu=tk.createCustomCursor(chuizi,new Point(),"锤子");  
        		  	   		this.setCursor(cu);
        		  	   		System.out.println(score3);
        			   }
        			   
        			   
        			   
        			   
        			   
        			   if(score1<20)
        			   {
        				   Thread.sleep(1000);      //使线程休眠    
        			   }
        			   else if(score1>=20&&score1<40)
        			   {
        				   Thread.sleep(1000);      //使线程休眠  
        			   }
        			   else if(score1>=40&&score1<60)
        			   {
        				   Thread.sleep(1000);      //使线程休眠  
        			   }
        			   else if(score1>=60)
        			   {
        				   Thread.sleep(50);      //使线程休眠  
        			   }
        			                             			           			           			          			   
        			   int index1=(int)(Math.random()*9);       //生成随机的地鼠索引
        			   if( mouses[index1].getIcon()==null)    //如果地鼠标签没有设置图片
        			   {    
        				   int index2 = (int)(Math.random()*5);
        				   switch (index2)
						{
						        case 0:  mouses[index1].setIcon(new ImageIcon("./图片/地鼠1.png"));    //为该标签添加地鼠图片
						        
						        
						        break;
						        case 1:  mouses[index1].setIcon(new ImageIcon("./图片/地鼠2.png"));    //为该标签添加地鼠图片
						
						        break;
						        case 2:  mouses[index1].setIcon(new ImageIcon("./图片/地鼠3.png"));    //为该标签添加地鼠图片
						
						        break;
						        case 3:  mouses[index1].setIcon(new ImageIcon("./图片/地鼠4.png"));    //为该标签添加地鼠图片
						
						        break;
						        case 4:  mouses[index1].setIcon(new ImageIcon("./图片/地鼠5.png"));    //为该标签添加地鼠图片
						
						        break;

						        default:
						        break;
							}
        				   
        				   if(score1<20)
            			   {
            				   Thread.sleep(1000);      //使线程休眠    
            			   }
            			   if(score1>=20&&score1<40)
            			   {
            				   Thread.sleep(1000);      //使线程休眠    
            			   }
            			   if(score1>=40&&score1<60)
            			   {
            				   Thread.sleep(1000);      //使线程休眠    
            			   }
            			   if(score1>=60)
            			   {
            				   Thread.sleep(50);      //使线程休眠    
            			   }
           			       mouses[index1].setIcon(null);
        			   	}
        			   
        			   
         // System.out.println("1");
        			   
        		   }
        		   catch(InterruptedException e)
        		   {
        			   e.printStackTrace();
        		   }
        	   }
           }
   
 
}


class Mouse extends JLabel
{    
	              
	private ImageIcon imgMouse;           //地鼠图片对象
	
	public Mouse()
	{
	   imgMouse=new ImageIcon("./图片/地鼠4.png");    //初始化地鼠图片对象
	   setSize(imgMouse.getIconWidth(),imgMouse.getIconHeight());//设置标签与地鼠图片相同大小
	
    }


}


