/**
 * �ļ�����Test.java
 * ��Ŀ-�����������Ϸ�� - �����1
 * ���ߣ����ĵ�
 * �������ڣ�2014-5-21
 */
package �����2;

/**
 * @author ���ĵ�
 * ������Test
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


public class Test implements Runnable 
{
	 private JLabel[] mouses;              //�����ʾ�����ı�ǩ����
     private ImageIcon imgMouse;
	 public void run()
     {
       while(true)
       {                                    //ʹ������ѭ��
         try
         {
            Thread.sleep(1000);                     //ʹ�߳�����1��
            int index=(int)(Math.random()*6);       //��������ĵ�������
            if(mouses[index].getIcon()==null)
            {      //��������ǩû������ͼƬ
             mouses[index].setIcon(imgMouse);    //Ϊ�ñ�ǩ��ӵ���ͼƬ
            }
         }catch(InterruptedException e)
           {
              e.printStackTrace();
           }
       }
     }
	
	public static void main(String args[])
	{
		
		new ClientView();
		
		
		
		EventQueue.invokeLater(      new Runnable()
        {
                   public void run()
                     {
                	   try{                      
                		   ClientView frame=new ClientView();  //��������  
                		   frame.setVisible(true);             //��ʾ����
                		   new Thread(frame).start();          //�����߳�
                	   }catch(Exception e)
                	   {
                		   e.printStackTrace();
                	   }
                     }	
        }
		   );
				
	}
}




class ClientView  extends JFrame implements Runnable 
{
      private JLabel jbJLabel1;
      private JLabel[] mouses;              //�����ʾ�����ı�ǩ����
      private ImageIcon imgMouse;          //����ͼƬ����
   
    
      
      
      
 	 
    	  
      
     public ClientView()
     {
       
    	 super();
    	 EventQueue.invokeLater(new Runnable()
         {
       	  public void run()
       	  {
                 try{                      
               	  ClientView frame=new ClientView();  //��������  
               	  frame.setVisible(true);             //��ʾ����
               	  new Thread(frame).start();          //�����߳�
                 	 }catch(Exception e)
                 	  {
                 		 e.printStackTrace();
                 	  }
       	  }
          });
         
         
    	 
    	 
    	 
    	 
    	
        this.setResizable(false);                      //��ֹ���������С
        this.getContentPane().setLayout(null);         //���岻ʹ�ò��ֹ�����
        this.setTitle("���׵Ĵ������Ϸ");                //���ô������    
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);       
        ImageIcon img=new ImageIcon("./ͼƬ/background.jpg");
        //��ʼ������ͼƬ
  
        new mouses();
        
        mouses=new JLabel[9];                          //������ʾ����ı�ǩ����                        
        for(int i=0;i<9;i++)
        {                          //��������
        	mouses[i]=new JLabel();                    //��ʼ��ÿһ������Ԫ��
        	mouses[i].setSize(imgMouse.getIconWidth(),imgMouse.getIconHeight());
        	//���ñ�ǩ�����ͼƬ��ͬ��С
        	mouses[i].addMouseListener(new MouseAdapter()
        	{//Ϊ��ǩ�������¼�����������
    /**
     * ������굥���¼��ķ���
     */
    @Override
    		public void mouseClicked(MouseEvent e)
    		{
    	          Object source=e.getSource();        //��ȡ�¼�Դ���������ǩ
    	          if(source instanceof JLabel)
    	          {       //����¼��Ǳ�ǩ���
    	        	  JLabel mouse=(JLabel)source;    //ǿ��ת��ΪJLabel��ǩ
    	        	  mouse.setIcon(null);            //ȡ����ǩͼ��
    	          }
    		}
        });
        this.getContentPane().add(mouses[i]);       //�����ʾ����ı�ǩ������
        }
  
        mouses[0].setLocation(65	, 210);                //����ÿ����ǩ��λ��
        mouses[1].setLocation(170 , 210);
        mouses[2].setLocation(280 , 210);
        mouses[3].setLocation(65  , 310);
        mouses[4].setLocation(170 , 310);
        mouses[5].setLocation(280 , 310);
        mouses[6].setLocation(65  , 409);
        mouses[7].setLocation(170 , 409);
        mouses[8].setLocation(280 , 409);
        
        Toolkit tk=Toolkit.getDefaultToolkit();  
        Image chuizi=tk.getImage("./ͼƬ/����.png"); /*mouse.gif�����ͼ��*/ 
        Cursor cu=tk.createCustomCursor(chuizi,new Point(10,10),"stick");  
        this.setCursor(cu);

  
        jbJLabel1 = new JLabel("��ϲ���÷�:0");
        this.add(jbJLabel1);
        
        JLabel backLabel=new JLabel();            //������ʾ�����ı�ǩ   
        backLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        this.setBounds(100,100,img.getIconWidth(),img.getIconHeight());
        backLabel.setIcon(img);                         //��ӱ�������ǩ
        this.getContentPane().add(backLabel);           //��ӱ�����ǩ������
     }     
 /**
  * �̵߳ĺ��ķ���
  */



	public void run()
	{

		
	}
 
              
               
     


}


class mouses 
{

	ImageIcon imgMouse;
	public mouses()
	{
		imgMouse = new ImageIcon("./ͼƬ/����1.png");
        //��ʼ������ͼƬ����
        
    }	
	
}