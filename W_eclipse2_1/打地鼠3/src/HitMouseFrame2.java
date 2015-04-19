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


class HitMouseFrame2 extends JFrame implements Runnable 
{
	       Mouse[] mouses;               //������ʾ����ı�ǩ����    
	       JLabel scorelabel,scorelabe2,classJLabel;             //������ʾ�����ı�ǩ����    
	       int score=0; 
	       int guanqiaflage;  //
	       boolean flag = true; 
	       int k=0,n=0,m=0;
  
   
     public HitMouseFrame2() 
      {      super();
             this.setResizable(false);                      //��ֹ���������С
             this.getContentPane().setLayout(null);         //���岻ʹ�ò��ֹ�����
             this.setTitle("��һ��Ĵ����֮��սѩԭ");                   //���ô������
             this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
             
     
             mouses=new Mouse[9]; 
             scorelabel=new JLabel("�÷�"+0);
             scorelabe2=new JLabel("�ܵ�������"+0);
             classJLabel=new JLabel("�ؿ� 2����սѩԭ");            
             int i=0;
             
             
             this.addWindowListener(new WindowAdapter()
 			{
 				public void windowClosing(WindowEvent e)
 				{					
 					super.windowClosing(e);
 					System.exit(0);
 				}
 				
 			});
             
          
   	        for(i=0;i<9;i++)            //��������
   	        {                          
   	            mouses[i]=new Mouse();                    //��ʼ��ÿһ������Ԫ��
   	       
     	        mouses[i].addMouseListener(new MouseAdapter()  //Ϊ��ǩ�������¼�����������
     	    {   
     	        	
     	        public void mouseClicked(MouseEvent e)
   		          {     Object source=e.getSource();        //��ȡ�¼�Դ���������ǩ
   		       
   		            if(source instanceof JLabel)       //����¼��Ǳ�ǩ���
   		             {       
   		            	JLabel mouse=(JLabel)source;    //ǿ��ת��ΪJLabel��ǩ
   		            	if(mouse.getIcon() == null)
   		      		 {  
   		            		
   		      		 }
   		      		 else 
   		      		 {
   		      			 score+=10;		            	
   		      			 mouse.setIcon(null);            //ȡ����ǩͼ��
   		      			 m++;
   		      			 scorelabel.setText("�÷�"+score);  
   		      		 }   		         
   		             }
   		           }         	    
   		   } 	    
     	     );
     	        
     	 
   		   this.getContentPane().add(mouses[i]);       //�����ʾ����ı�ǩ������
   		   
   }
             
      
      	  mouses[0].setLocation(55,135);                //����ÿ����ǩ��λ��
   	      mouses[1].setLocation(275,52);
   	      mouses[2].setLocation(230, 220);	      
     	  mouses[3].setLocation(42, 325); 
   	      mouses[4].setLocation(475, 130);     
    	  mouses[5].setLocation(340, 355);    	  
     	  mouses[6].setLocation(765, 90); 
   	      mouses[7].setLocation(542, 233);     
    	  mouses[8].setLocation(680, 350);
    
    	  
    	  classJLabel. setForeground(Color.red);        
    	  classJLabel.setSize(500,30);
    	  classJLabel.setLocation(100, 30);  	  
    	  classJLabel.setFont(new Font("����",Font.BOLD,30));
    	  
    	  scorelabel.setForeground(Color.red  );
    	  scorelabel.setSize(200,30); 
    	  scorelabel.setLocation(420, 30);
    	  scorelabel.setFont(new Font("����",Font.BOLD,30));
    	  
    	  scorelabe2.setForeground(Color.red );
    	  scorelabe2.setSize(200,30); 
    	  scorelabe2.setLocation(550, 30);
    	  scorelabe2.setFont(new Font("����",Font.BOLD,30));

  
          Toolkit tk=Toolkit.getDefaultToolkit();  // ������ɴ��ӵ���״
          Image chuizi=tk.getImage("./image/����.png");  
          Cursor cu=tk.createCustomCursor(chuizi,new Point(10,10),"stick");  
          this.setCursor(cu);
         

         
          
          this.getContentPane().add(classJLabel);         
          this.getContentPane().add(scorelabel);  
          this.getContentPane().add(scorelabe2);
          ImageIcon img=new ImageIcon("./image/background2.jpg"); 
          final JLabel backLabel=new JLabel();            //������ʾ�����ı�ǩ   
          backLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
          this.setBounds(250,100,img.getIconWidth(),img.getIconHeight());
          backLabel.setIcon(img);                         //��ӱ�������ǩ
          this.getContentPane().add(backLabel);           //��ӱ�����ǩ������		

         
        
                 
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
         // Thread.sleep(500);                       //ʹ�߳�����0.5��
          int index=(int)(Math.random()*9);       //��������ĵ�������
          if( mouses[index].getIcon()==null )    //��������ǩû������ͼƬ
          {    	int index1=(int)(Math.random()*4); 
          		int index2=(int)(Math.random()*9);
          		int index3=(int)(Math.random()*9);
          		int index4=(int)(Math.random()*9);
          		int index5=(int)(Math.random()*9);
          		int index6=(int)(Math.random()*9);
          		int index7=(int)(Math.random()*9);
          		int index8=(int)(Math.random()*9);
          		int index9=(int)(Math.random()*9);
				switch (index1)
				{
					case 1:  { mouses[index].setIcon(new ImageIcon("./image/����1.png"));    //Ϊ�ñ�ǩ��ӵ���ͼƬ
				               k++; 
					break;  }
				                
					case 2:  { mouses[index].setIcon(new ImageIcon("./image/����2.png"));    //Ϊ�ñ�ǩ��ӵ���ͼƬ
					           k++;
					break;  }
					case 3:  { mouses[index].setIcon(new ImageIcon("./image/����3.png"));    //Ϊ�ñ�ǩ��ӵ���ͼƬ
					           k++;
					break;  }
					case 4:  { mouses[index].setIcon(new ImageIcon("./image/����4.png"));    //Ϊ�ñ�ǩ��ӵ���ͼƬ
					           k++;
					break;  }
					default:
						         break;
		         }
		
		   
		   if(score<100)
		   {
			    Thread.sleep(1000);      //ʹ�߳�����   
			    mouses[index2].setIcon(null);
		   		mouses[index3].setIcon(null);
		   		mouses[index4].setIcon(null);
		   		mouses[index5].setIcon(null);
		   		mouses[index6].setIcon(null);
		   		mouses[index7].setIcon(null);
		   		mouses[index8].setIcon(null);
		   		mouses[index9].setIcon(null);
		   		n++;
		   		scorelabe2.setText("�ܵ�������"+(n-m));
		   }
		   if (score>=100)	
        	{   
			    flag=false;
			    JOptionPane.showMessageDialog(null, "��ϲ������һ��");
      		    dispose(); 
      		    HitMouseFrame3  frame3=new HitMouseFrame3();		    
      	        frame3.setVisible(true);             //��ʾ����	        
      	        new Thread(frame3).start();          //�����߳�     
      		
      	   }
	   
		   if(n-m==10)
		   {
			   
			    JOptionPane.showMessageDialog(null, "�ܲ��ң� �ܵ�������̫�࣡ ��Ҳ���������");
			    JOptionPane.showMessageDialog(null, "����������������");
			    dispose();
			    m=0;n=0;k=0;
			    HitMouseFrame2  frame=new HitMouseFrame2();		    
     	        frame.setVisible(true);             //��ʾ����	        
     	        new Thread(frame).start();          //�����߳�
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
