/**
 * 文件名：ClientView.java
 * 项目-包：打地鼠2 - Test
 * 作者：张文迪
 * 创建日期：2014-6-7
 */
package Test;

import java.awt.BorderLayout;
import java.awt.Cursor;
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

/**
 * @author 张文迪
 * 类名：ClientView
 * 类说明：
 */
public class ClientView extends JFrame implements Runnable
{
    Mouse[] mouses;
	JPanel panel1,panel2,panel3;
    JLabel label1,label2;
    int score1 ,score2 =1,score3 = 0;
    
    boolean boolean1 = false;
 

    public ClientView()
    {
    	 panel1 = new JPanel();
    	 panel3 = new JPanel();
    	 if(score2 == 1)
    	 {
    		 panel2 = new ImagePanel(new ImageIcon("./图片/background1.jpg").getImage());
    	 }
    	 else if(score2 == 2)
    	 {
    		 panel2 = new ImagePanel(new ImageIcon("./图片/background2.jpg").getImage());
    	 }
    	 else if(score2 ==3)
    	 {
    		 panel2 = new ImagePanel(new ImageIcon("./图片/background3.jpg").getImage());
    	 }
    	 label1 = new JLabel("关卡"+1);
    	 label2 = new JLabel("恭喜您得分:"+0);

    	 mouses = new Mouse[9];
    	 /*for(int i=0;i<9;i++)            //遍历数组
   	     {                          
   	         mouses[i]=new Mouse();
   	         panel2.add(mouses[i]);
   	     }*/
    	 
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
 		      			 
 		      			 if(score1 == 20)
 	 		      		 {
 	 		      			 JOptionPane.showMessageDialog(null, "恭喜进入下一关");
 		      				 score2+=1;
 	 		      			 label1.setText("关卡"+2);
 	 		      		 }
 		      			 if(score1 == 40)
	 		      		 {
	 		      			 JOptionPane.showMessageDialog(null, "恭喜进入下一关");
 		      				 score2+=1;
	 		      			 label1.setText("关卡"+3);
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
     	    panel2.add(mouses[i]);       //添加显示地鼠的标签到窗体  		   
   	     }
    	
    	 if(score2 == 1)
    	 {
     	      mouses[0].setLocation(330 , 175);                //设置每个标签的位置
     	      mouses[1].setLocation(300, 295);
     	      mouses[2].setLocation(130, 360);
     	      mouses[3].setLocation(515, 240);
     	      mouses[4].setLocation(430, 370);
     	      mouses[5].setLocation(680, 175);
     	      mouses[6].setLocation(785, 265);
     	      mouses[7].setLocation(650 ,330 );
  	          mouses[8].setLocation(130, 230);
    	 }
    	 else if(score2 == 2)
    	 {
    		  mouses[0].setLocation(330 , 175);                //设置每个标签的位置
     	      mouses[1].setLocation(300, 295);
     	      mouses[2].setLocation(130, 360);
     	      mouses[3].setLocation(515, 240);
     	      mouses[4].setLocation(430, 370);
     	      mouses[5].setLocation(680, 175);
     	      mouses[6].setLocation(785, 265);
     	      mouses[7].setLocation(650 ,330 );
     	      mouses[8].setLocation(130, 230);
    	 }
    	 else if(score2 == 3)
    	 {
    		  mouses[0].setLocation(330 , 175);                //设置每个标签的位置
     	      mouses[1].setLocation(300, 295);
     	      mouses[2].setLocation(130, 360);
     	      mouses[3].setLocation(515, 240);
     	      mouses[4].setLocation(430, 370);
     	      mouses[5].setLocation(680, 175);
     	      mouses[6].setLocation(785, 265);
     	      mouses[7].setLocation(650 ,330 );
     	      mouses[8].setLocation(130, 230);
    	 }
    	 
    	 panel1.add(label1);
    	 panel1.add(label2);
    	 panel3.add(panel2);
    	     	       	 
    	 this.setLayout(new BorderLayout());
    	 
    	 this.add(panel1,BorderLayout.NORTH);
    	 this.add(panel3,BorderLayout.CENTER);
    	 this.setResizable(false);
    	 this.setTitle("打地鼠游戏，哈哈");
      	 this.pack();
   	 
    	 this.setVisible(true);
    	 
    	
    	 
    	 this.addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
    	    
		});
    }
    
    
    
    public void run()
    {       	         	         	   	        	   
 	   while(true)                           //使用无限循环
 	   {                              
 		   try
 		   {    
 			   
 			   System.out.println("222222222");
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
 				   Thread.sleep(1000);      //使线程休眠  
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
