/**
 * �ļ�����Nimab.java
 * ��Ŀ-�����������Ϸ�� - ����
 * ���ߣ����ĵ�
 * �������ڣ�2014-5-23
 */
package ����;

/**
 * @author ���ĵ�
 * ������Nimab
 * ��˵����
 */
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;





public class Nimab 
{
public static void main(String[] args) 
{
 new MyChessFrame();

}  
}

class MyChessFrame
{
public void paint(Graphics g) {
BufferedImage image=null;
try {
image = ImageIO.read(new File("E:/image/background.jpg"));
} catch (IOException e) {
e.printStackTrace();
}
 
g.drawImage(image,0,0,null);
}
}