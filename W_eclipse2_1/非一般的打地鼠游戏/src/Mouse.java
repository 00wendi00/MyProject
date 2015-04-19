import javax.swing.ImageIcon;
import javax.swing.JLabel;


class Mouse extends JLabel 
{    
	              
	private ImageIcon imgMouse;           //地鼠图片对象
	
	public Mouse()
	{    
		
		 imgMouse=new ImageIcon("./image/地鼠1.png");    //初始化地鼠图片对象
		 setSize(imgMouse.getIconWidth(),imgMouse.getIconHeight());//设置标签与地鼠图片相同大小
	
    }


}