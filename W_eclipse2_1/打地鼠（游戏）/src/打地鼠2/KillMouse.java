/**
 * �ļ�����Test.java
 * ��Ŀ-�����������Ϸ�� - �����2
 * ���ߣ����ĵ�
 * �������ڣ�2014-5-21
 */
package �����2;

/**
 * @author ���ĵ�
 * ������Test
 * ��˵����
 */
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 




public class KillMouse 
{ 
     public static void main(String[] args) 
      { 
         new Mouse(); 
      } 
}; 


class Mouse extends JFrame implements MouseListener ,ActionListener 
{ 
          Timer timer; 
          int score; 
          JLabel lb1; 
          JLabel img[] = new JLabel[4]; 
          int m_status[] = new int[4]; 
      public Mouse() 
     { 
        super("���ͨ��-�������Ϸ-�Ǻ�"); 
          Container c = getContentPane(); 
           c.setLayout(null); 
             lb1 = new JLabel("���ͨ�Ź�ϲ���÷�:0"); 
             lb1.setFont(new Font("����",Font.BOLD,16)); 
            lb1.setSize(200,30); 
                lb1.setLocation(5,5); 
               c.add(lb1); 
              ImageIcon icon1 = new ImageIcon("./ͼƬ/����1.png"); //ע��ͼƬҪ��class�ļ���һ��Ŀ¼��
            for(int i=0;i<4;i++) 
            { 
             img[i] = new JLabel(icon1); 
               img[i].setSize(90,90); 
            img[i].setLocation(50+i*100,150); 
               img[i].setVisible(false); 
               img[i].addMouseListener(this); 
                 c.add(img[i]); 
                 m_status[i] = 0; 
      } 
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
             setSize(500,400); 
                setVisible(true); 
                   score = 0; 
                timer = new Timer(2000,this); 
                   timer.start(); 
 } 
              public void actionPerformed(ActionEvent e) 
      { 
                  int i,j,x; 
              int rlist[]={0,1,2,3}; 
                 if(e.getSource()==timer) 
           { 
                 for(i=0;i<4;i++) 
              { 
                  j=(int)(Math.random()*4); 
              x=rlist[i]; 
                      rlist[i]=rlist[j]; 
               rlist[j]=x; 
              } 

             for(i=0;i<4;i++) 
   { 
             if(m_status[rlist[i]]==0) 
       { 
               m_status[rlist[i]]=1; 
             img[rlist[i]].setVisible(true); 
       } 

} 
         img[0].setVisible(true); 
 } 
} 

             public void mousePressed(MouseEvent e) 
     { 
    } 
             public void mouseReleased(MouseEvent e) 
           { 
           } 
               public void mouseEntered(MouseEvent e) 
         { 
            } 
               public void mouseExited(MouseEvent e) 
         { 
         } 
             public void mouseClicked(MouseEvent e) 
            { 
               for (int i=0;i<4 ;i++ ) 
               { 
             if(e.getSource()==img[i]) 
           { 
                score+=10; 
             lb1.setText("���ͨ�Ź�ϲ���÷�:"+score); 
                img[i].setVisible(false); 
                   m_status[i] = 0; 
             } 
                    } 
              } 
         }; 