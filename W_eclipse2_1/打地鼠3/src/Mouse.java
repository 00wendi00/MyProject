import javax.swing.ImageIcon;
import javax.swing.JLabel;


class Mouse extends JLabel 
{    
	              
	private ImageIcon imgMouse;           //����ͼƬ����
	
	public Mouse()
	{    
		
		 imgMouse=new ImageIcon("./image/����1.png");    //��ʼ������ͼƬ����
		 setSize(imgMouse.getIconWidth(),imgMouse.getIconHeight());//���ñ�ǩ�����ͼƬ��ͬ��С
	
    }


}