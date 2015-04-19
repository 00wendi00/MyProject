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
import javax.swing.text.html.HTMLDocument.BlockElement;


class HitMouseFrame3 extends JFrame implements Runnable 
{
	       Mouse[] mouses;               //������ʾ����ı�ǩ����    
	       JLabel scorelabel,scorelabe2,classJLabel;             //������ʾ�����ı�ǩ����    
	       int score=0; 
	       int guanqiaflage;  //
	       boolean flag = true; 
	       int k=0,n=0,m=0;
  
   
     public HitMouseFrame3() 
      {      super();
             this.setResizable(false);                      //��ֹ���������С
             this.getContentPane().setLayout(null);         //���岻ʹ�ò��ֹ�����
             this.setTitle("��һ��Ĵ����֮��ս��ʬ");                   //���ô������
             this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
             
     
             mouses=new Mouse[9]; 
             scorelabel=new JLabel("�÷�"+0);
             scorelabe2=new JLabel("�ܵ�������"+0);
             classJLabel=new JLabel("�ؿ� 3:��ս��ʬ��");
             int i=0;
            
           
           
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
             
  
		
        
      	  mouses[0].setLocation(210, 75);                //����ÿ����ǩ��λ��
   	      mouses[1].setLocation(210,190);
   	      mouses[2].setLocation(360, 370);	      
     	  mouses[3].setLocation(92, 365); 
   	      mouses[4].setLocation(426, 195);     
    	  mouses[5].setLocation(440, 45);    	  
     	  mouses[6].setLocation(660, 85); 
   	      mouses[7].setLocation(655, 220);     
    	  mouses[8].setLocation(525, 320);
   
          
    	  classJLabel.setSize(500,30);
    	  classJLabel.setLocation(100, 30);
    	  classJLabel.setFont(new Font("����",Font.BOLD,30));
    	  classJLabel. setForeground(Color.YELLOW);   
    	  
    	  scorelabel.setSize(200,30); 
    	  scorelabel.setLocation(420, 30);
    	  scorelabel.setFont(new Font("����",Font.BOLD,30));
    	  scorelabel. setForeground(Color.YELLOW);
    	  
    	  scorelabe2.setSize(200,30); 
    	  scorelabe2.setLocation(550, 30);
    	  scorelabe2.setFont(new Font("����",Font.BOLD,30));
    	  scorelabe2. setForeground(Color.YELLOW);

  
          Toolkit tk=Toolkit.getDefaultToolkit();  // ������ɴ��ӵ���״
          Image chuizi=tk.getImage("./image/����.png");  
          Cursor cu=tk.createCustomCursor(chuizi,new Point(10,10),"stick");  
          this.setCursor(cu);
        
          this.getContentPane().add(classJLabel);         
          this.getContentPane().add(scorelabel);  
          this.getContentPane().add(scorelabe2);
          ImageIcon img=new ImageIcon("./image/background3.jpg"); 
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
          Thread.sleep(300);                       //ʹ�߳�����0.3��
          int index=(int)(Math.random()*9);       //��������ĵ�������
          if( mouses[index].getIcon()==null)    //��������ǩû������ͼƬ
          {    	int indexx=(int)(Math.random()*4); 
          		int index2=(int)(Math.random()*9);
          		int index3=(int)(Math.random()*9);
          		int index4=(int)(Math.random()*9);
          		
          		
				switch (indexx)
				{
					case 0:  { mouses[index].setIcon(new ImageIcon("./image/����1.png"));    //Ϊ�ñ�ǩ��ӵ���ͼƬ
				               k++;
					break;  }
				                
					case 1:  { mouses[index].setIcon(new ImageIcon("./image/����2.png"));    //Ϊ�ñ�ǩ��ӵ���ͼƬ
								k++;
					break;  }
					
					case 2:  { mouses[index].setIcon(new ImageIcon("./image/����3.png"));    //Ϊ�ñ�ǩ��ӵ���ͼƬ
					            k++; 
					break;  }
					
					case 3:  { mouses[index].setIcon(new ImageIcon("./image/����4.png"));    //Ϊ�ñ�ǩ��ӵ���ͼƬ
					            k++;
					break;  }
					
					default:
						         break;
		         }
		

				   if(score<100)
				   {
					    Thread.sleep(300);      //ʹ�߳�����   
					    mouses[index2].setIcon(null);
				   		mouses[index3].setIcon(null);
				   		mouses[index4].setIcon(null);
				   		
				   		
				   		
				   		n++;
				   		scorelabe2.setText("�ܵ�������"+(n-m));
				   }
		   if (score>=100)
	     	{    
			   flag=false;
  		       			  
		       JOptionPane.showMessageDialog(null, "��ϲ������һ��:��ս��ħ����");
		       JOptionPane.showMessageDialog(null, "���������ٶȿ���ħ��~ע�⣬��ֻ��10���ʱ��~����������~");
		       dispose();
		       HitMouseFrame4  frame=new HitMouseFrame4();		    
   	           frame.setVisible(true);             //��ʾ����	        
   	           new Thread(frame).start();          //�����߳�
   	         
		       
		    }
		
		   
		   
		   if(n-m==20)
		   {
			    
			    JOptionPane.showMessageDialog(null, "�ܲ��ң� �ܵ�������̫�࣡ ��Ҳ���������");
			    JOptionPane.showMessageDialog(null, "����������������");
			    dispose();
			    m=0;n=0;k=0;
			    HitMouseFrame3  frame=new HitMouseFrame3();		    
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
