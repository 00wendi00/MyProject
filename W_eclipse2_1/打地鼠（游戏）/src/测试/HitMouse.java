/**
 * 文件名：HitMouse.java
 * 项目-包：打地鼠（游戏） - 测试
 * 作者：张文迪
 * 创建日期：2014-5-21
 */
package 测试;

/**
 * @author 张文迪
 * 类名：HitMouse
 * 类说明：
 */
import java.awt.Cursor;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class HitMouse extends JFrame implements Runnable 
{
	    Mouse[] mouses;               //创建显示地鼠的标签数组    
	    
	    
   public static void main(String args[])
   {
      EventQueue.invokeLater(    new Runnable()
      {
        public void run()
        {
         try{                      
          HitMouse frame=new HitMouse();  //创建窗体
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
         this.setResizable(false);                      //禁止调整窗体大小
         this.getContentPane().setLayout(null);         //窗体不使用布局管理器
         this.setTitle("简易的打地鼠游戏");                   //设置窗体标题
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
         ImageIcon img=new ImageIcon("./image/background.jpg"); 
        
       
         mouses=new Mouse[6]; 
          
        
   	  
   	     for(int i=0;i<6;i++)            //遍历数组
   	     {                          
   	         mouses[i]=new Mouse();                    //初始化每一个数组元素
   	       
     	     mouses[i].addMouseListener(new MouseAdapter()  //为标签添加鼠标事件监听适配器
     	   {   		   
   		       public void mouseClicked(MouseEvent e)
   		     {   Object source=e.getSource();        //获取事件源，即地鼠标签
   		       
   		      if(source instanceof JLabel)       //如果事件是标签组件
   		       {                                
   		        JLabel mouse=(JLabel)source;    //制转换为JLabel标签
   		        mouse.setIcon(null);            //取消标签图标
   		       }
   		     }
   		   }
     	  );
   		   this.getContentPane().add(mouses[i]);       //添加显示地鼠的标签到窗体
   }
             
   	  
      	  mouses[0].setLocation(70, 210);                //设置每个标签的位置
   	      mouses[1].setLocation(160,210);
   	      mouses[2].setLocation(250, 210);
     	  mouses[3].setLocation(70, 310);
   	      mouses[4].setLocation(160, 310);
    	  mouses[5].setLocation(250, 310);
  

  
         Toolkit tk=Toolkit.getDefaultToolkit();  // 将鼠标变成锤子的形状
         Image chuizi=tk.getImage("./图片/锤子.png"); /*mouse.gif是你的图标*/ 
         Cursor cu=tk.createCustomCursor(chuizi,new Point(10,10),"stick");  
         this.setCursor(cu);
  
  
         final JLabel backLabel=new JLabel();            //创建显示背景的标签   
         backLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
         this.setBounds(400,10,img.getIconWidth(),img.getIconHeight());
         backLabel.setIcon(img);                         //添加背景到标签
         this.getContentPane().add(backLabel);           //添加背景标签到窗体
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
          Thread.sleep(400);                       //使线程休眠1秒
          int index=(int)(Math.random()*6);       //生成随机的地鼠索引
          if( mouses[index].getIcon()==null)    //如果地鼠标签没有设置图片
          {    
              mouses[index].setIcon(new ImageIcon("./图片/地鼠4.png"));    //为该标签添加地鼠图片
           }
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


