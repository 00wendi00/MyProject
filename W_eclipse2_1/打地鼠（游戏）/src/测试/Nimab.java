/**
 * 文件名：Nimab.java
 * 项目-包：打地鼠（游戏） - 测试
 * 作者：张文迪
 * 创建日期：2014-5-23
 */
package 测试;

/**
 * @author 张文迪
 * 类名：Nimab
 * 类说明：
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