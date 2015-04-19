/**
 * �ļ�����HitMouse.java
 * ��Ŀ-�����������Ϸ�� - ����
 * ���ߣ����ĵ�
 * �������ڣ�2014-5-21
 */
package ����;

/**
 * @author ���ĵ�
 * ������HitMouse
 * ��˵����
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
	    Mouse[] mouses;               //������ʾ����ı�ǩ����    
	    
	    
   public static void main(String args[])
   {
      EventQueue.invokeLater(    new Runnable()
      {
        public void run()
        {
         try{                      
          HitMouse frame=new HitMouse();  //��������
          frame.setVisible(true);             //��ʾ����
           new Thread(frame).start();          //�����߳�
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
         this.setResizable(false);                      //��ֹ���������С
         this.getContentPane().setLayout(null);         //���岻ʹ�ò��ֹ�����
         this.setTitle("���׵Ĵ������Ϸ");                   //���ô������
         this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
         ImageIcon img=new ImageIcon("./image/background.jpg"); 
        
       
         mouses=new Mouse[6]; 
          
        
   	  
   	     for(int i=0;i<6;i++)            //��������
   	     {                          
   	         mouses[i]=new Mouse();                    //��ʼ��ÿһ������Ԫ��
   	       
     	     mouses[i].addMouseListener(new MouseAdapter()  //Ϊ��ǩ�������¼�����������
     	   {   		   
   		       public void mouseClicked(MouseEvent e)
   		     {   Object source=e.getSource();        //��ȡ�¼�Դ���������ǩ
   		       
   		      if(source instanceof JLabel)       //����¼��Ǳ�ǩ���
   		       {                                
   		        JLabel mouse=(JLabel)source;    //��ת��ΪJLabel��ǩ
   		        mouse.setIcon(null);            //ȡ����ǩͼ��
   		       }
   		     }
   		   }
     	  );
   		   this.getContentPane().add(mouses[i]);       //�����ʾ����ı�ǩ������
   }
             
   	  
      	  mouses[0].setLocation(70, 210);                //����ÿ����ǩ��λ��
   	      mouses[1].setLocation(160,210);
   	      mouses[2].setLocation(250, 210);
     	  mouses[3].setLocation(70, 310);
   	      mouses[4].setLocation(160, 310);
    	  mouses[5].setLocation(250, 310);
  

  
         Toolkit tk=Toolkit.getDefaultToolkit();  // ������ɴ��ӵ���״
         Image chuizi=tk.getImage("./ͼƬ/����.png"); /*mouse.gif�����ͼ��*/ 
         Cursor cu=tk.createCustomCursor(chuizi,new Point(10,10),"stick");  
         this.setCursor(cu);
  
  
         final JLabel backLabel=new JLabel();            //������ʾ�����ı�ǩ   
         backLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
         this.setBounds(400,10,img.getIconWidth(),img.getIconHeight());
         backLabel.setIcon(img);                         //��ӱ�������ǩ
         this.getContentPane().add(backLabel);           //��ӱ�����ǩ������
  }
 
 
 /**
  * �̵߳ĺ��ķ���
  */
 
 public void run()
 {
    while(true)                           //ʹ������ѭ��
    {                              
       try
       {
          Thread.sleep(400);                       //ʹ�߳�����1��
          int index=(int)(Math.random()*6);       //��������ĵ�������
          if( mouses[index].getIcon()==null)    //��������ǩû������ͼƬ
          {    
              mouses[index].setIcon(new ImageIcon("./ͼƬ/����4.png"));    //Ϊ�ñ�ǩ��ӵ���ͼƬ
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
	              
	private ImageIcon imgMouse;           //����ͼƬ����
	
	public Mouse()
	{
	   imgMouse=new ImageIcon("./ͼƬ/����4.png");    //��ʼ������ͼƬ����
	   setSize(imgMouse.getIconWidth(),imgMouse.getIconHeight());//���ñ�ǩ�����ͼƬ��ͬ��С
	
    }


}


