import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class EndFrame extends JFrame 
{
          JButton jButton;
          
	EndFrame()
	{
		jButton =new JButton(new ImageIcon("./image/next.jpg"));
		jButton.setBounds(320, 350, 240, 65);

	    getContentPane().setLayout(null);
	    getContentPane().add(jButton);
	    
	    
       jButton.addActionListener(new ActionListener() {						
			public void actionPerformed(ActionEvent e) 
			{
				JOptionPane.showMessageDialog(null, "���뿴����ϴϴ˯��~");				
				System.exit(0);				
			}
		});
		
        ImageIcon img=new ImageIcon("./image/end.jpg"); 
        final JLabel backLabel=new JLabel();            //������ʾ�����ı�ǩ   
        backLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        this.setBounds(250,100,img.getIconWidth(),img.getIconHeight());
        backLabel.setIcon(img);                         //��ӱ�������ǩ
        this.getContentPane().add(backLabel);           //��ӱ�����ǩ������	
        this.setVisible(true);
	}


}
