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
				JOptionPane.showMessageDialog(null, "还想看啊？洗洗睡吧~");				
				System.exit(0);				
			}
		});
		
        ImageIcon img=new ImageIcon("./image/end.jpg"); 
        final JLabel backLabel=new JLabel();            //创建显示背景的标签   
        backLabel.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());
        this.setBounds(250,100,img.getIconWidth(),img.getIconHeight());
        backLabel.setIcon(img);                         //添加背景到标签
        this.getContentPane().add(backLabel);           //添加背景标签到窗体	
        this.setVisible(true);
	}


}
