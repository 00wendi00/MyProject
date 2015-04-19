/**
 * �ļ�����ClientView.java
 * ��Ŀ-���������2 - Test
 * ���ߣ����ĵ�
 * �������ڣ�2014-6-7
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
 * @author ���ĵ�
 * ������ClientView
 * ��˵����
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
    		 panel2 = new ImagePanel(new ImageIcon("./ͼƬ/background1.jpg").getImage());
    	 }
    	 else if(score2 == 2)
    	 {
    		 panel2 = new ImagePanel(new ImageIcon("./ͼƬ/background2.jpg").getImage());
    	 }
    	 else if(score2 ==3)
    	 {
    		 panel2 = new ImagePanel(new ImageIcon("./ͼƬ/background3.jpg").getImage());
    	 }
    	 label1 = new JLabel("�ؿ�"+1);
    	 label2 = new JLabel("��ϲ���÷�:"+0);

    	 mouses = new Mouse[9];
    	 /*for(int i=0;i<9;i++)            //��������
   	     {                          
   	         mouses[i]=new Mouse();
   	         panel2.add(mouses[i]);
   	     }*/
    	 
    	 for(int i=0;i<9;i++)            //��������
   	     {                          
   	         mouses[i]=new Mouse();                    //��ʼ��ÿһ������Ԫ��   	         	         	            	         	         
     	     mouses[i].addMouseListener(new MouseAdapter()  //Ϊ��ǩ�������¼�����������
     	   {  
			
     	    public void mousePressed(MouseEvent e)
			{
				super.mousePressed(e);
				Object source=e.getSource();        //��ȡ�¼�Դ���������ǩ  		     
 		      	if(source instanceof JLabel)        //����¼��Ǳ�ǩ���
 		      	{     
 		      		JLabel mouse=(JLabel)source;    //��ת��ΪJLabel��ǩ	      		 
 		      		if(mouse.getIcon() == null)
 		      		 {  
 		      		
 		      		 }
 		      		 else 
 		      		 {
 		      			 score1+=10;
 		      			 
 		      			 if(score1 == 20)
 	 		      		 {
 	 		      			 JOptionPane.showMessageDialog(null, "��ϲ������һ��");
 		      				 score2+=1;
 	 		      			 label1.setText("�ؿ�"+2);
 	 		      		 }
 		      			 if(score1 == 40)
	 		      		 {
	 		      			 JOptionPane.showMessageDialog(null, "��ϲ������һ��");
 		      				 score2+=1;
	 		      			 label1.setText("�ؿ�"+3);
	 		      		 }
 		      			 
 		      		 }
 		      		  
 		      		label2.setText("��ϲ���÷�:"+score1);
			          mouse.setIcon(null);            //ȡ����ǩͼ��
 		      		      
 		      		 
 		      		 
 		      	} 		      	 		      	 		      			      			      	
			}
			public void mouseEntered(MouseEvent e)
			{			
				super.mouseEntered(e);
				Object source=e.getSource();        //��ȡ�¼�Դ���������ǩ  		     
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
				Object source=e.getSource();        //��ȡ�¼�Դ���������ǩ  		     
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
				Object source=e.getSource();        //��ȡ�¼�Դ���������ǩ  		     
 		      	if(source instanceof JLabel)
 		      	{
 		      		JLabel mouse=(JLabel)source;
 		      		if(mouse.getIcon() == null)
		      		 {  
		      		
		      		 }
		      		 else 
		      		 {
				          score3 = 0;
				          label2.setText("��ϲ���÷�:"+score1);
				          mouse.setIcon(null);            //ȡ����ǩͼ��
		      		 }
 		      	}*/
			}
			public void mouseClicked(MouseEvent e)
   		     {   
   		    	 		      
   		     }						
   		   }
     	  );
     	    panel2.add(mouses[i]);       //�����ʾ����ı�ǩ������  		   
   	     }
    	
    	 if(score2 == 1)
    	 {
     	      mouses[0].setLocation(330 , 175);                //����ÿ����ǩ��λ��
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
    		  mouses[0].setLocation(330 , 175);                //����ÿ����ǩ��λ��
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
    		  mouses[0].setLocation(330 , 175);                //����ÿ����ǩ��λ��
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
    	 this.setTitle("�������Ϸ������");
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
 	   while(true)                           //ʹ������ѭ��
 	   {                              
 		   try
 		   {    
 			   
 			   System.out.println("222222222");
 			   if(score3 == 1)
 		          {
 		          	Toolkit tk=Toolkit.getDefaultToolkit();  // ������ɴ��ӵ���״
 		  	   		Image chuizi=tk.getImage("./ͼƬ/���Ӵ�.png"); /*mouse.gif�����ͼ��*/				          
 		  	   		Cursor cu=tk.createCustomCursor(chuizi,new Point(),"����");  
 		  	   		this.setCursor(cu);	 	     	
 		  	   	    System.out.println(score3+1);
 		          
 		          }
 			   else if(score3 == 0)  
 			   {
 		            Toolkit tk=Toolkit.getDefaultToolkit();  // ������ɴ��ӵ���״
 		  	   		Image chuizi=tk.getImage("./ͼƬ/����.png"); /*mouse.gif�����ͼ��*/				          
 		  	   		Cursor cu=tk.createCustomCursor(chuizi,new Point(),"����");  
 		  	   		this.setCursor(cu);
 		  	   		System.out.println(score3);
 			   }
 			   
 			   
 			   
 			   
 			   
 			   if(score1<20)
 			   {
 				   Thread.sleep(1000);      //ʹ�߳�����    
 			   }
 			   else if(score1>=20&&score1<40)
 			   {
 				   Thread.sleep(1000);      //ʹ�߳�����  
 			   }
 			   else if(score1>=40&&score1<60)
 			   {
 				   Thread.sleep(1000);      //ʹ�߳�����  
 			   }
 			   else if(score1>=60)
 			   {
 				   Thread.sleep(1000);      //ʹ�߳�����  
 			   }
 			                             			           			           			          			   
 			   int index1=(int)(Math.random()*9);       //��������ĵ�������
 			   if( mouses[index1].getIcon()==null)    //��������ǩû������ͼƬ
 			   {    
 				   int index2 = (int)(Math.random()*5);
 				   switch (index2)
					{
					        case 0:  mouses[index1].setIcon(new ImageIcon("./ͼƬ/����1.png"));    //Ϊ�ñ�ǩ��ӵ���ͼƬ
					        
					        
					        break;
					        case 1:  mouses[index1].setIcon(new ImageIcon("./ͼƬ/����2.png"));    //Ϊ�ñ�ǩ��ӵ���ͼƬ
					
					        break;
					        case 2:  mouses[index1].setIcon(new ImageIcon("./ͼƬ/����3.png"));    //Ϊ�ñ�ǩ��ӵ���ͼƬ
					
					        break;
					        case 3:  mouses[index1].setIcon(new ImageIcon("./ͼƬ/����4.png"));    //Ϊ�ñ�ǩ��ӵ���ͼƬ
					
					        break;
					        case 4:  mouses[index1].setIcon(new ImageIcon("./ͼƬ/����5.png"));    //Ϊ�ñ�ǩ��ӵ���ͼƬ
					
					        break;

					        default:
					        break;
						}
 				   
 				   if(score1<20)
     			   {
     				   Thread.sleep(1000);      //ʹ�߳�����    
     			   }
     			   if(score1>=20&&score1<40)
     			   {
     				   Thread.sleep(1000);      //ʹ�߳�����    
     			   }
     			   if(score1>=40&&score1<60)
     			   {
     				   Thread.sleep(1000);      //ʹ�߳�����    
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
