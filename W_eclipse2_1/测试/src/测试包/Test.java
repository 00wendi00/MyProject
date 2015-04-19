/**
 * 文件名：Test.java
 * 项目-包：测试 - 测试包
 * 作者：张文迪
 * 创建日期：2014-5-22
 */
package 测试包;

/**
 * @author 张文迪
 * 类名：Test
 * 类说明：
 */
/*public String[] sj()
{
JProgressBar jProgressBar0;
JProgressBar jProgressBar1;
JProgressBar jProgressBar2;
JProgressBar jProgressBar3;
JProgressBar jProgressBar4;
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
            long dayNumber = 0;
            long SECOND = 1000L;
            long MINUTE = 60L * 1000L;
            long HOUR = 60L * 60L * 1000L;
            long DAY = 24L * 60L * 60L * 1000L;
            long MONTH = 30L * 24L * 60L * 60L * 1000L;
            long sy = 0, qq = 0;
            int ss = 0, mm = 0, hh = 0, dd = 0, MM = 0;



            try {
                Date date1 = new Date();
                Date date0 = sdf.parse("2008-08-08-08-00-00");
                qq = (date0.getTime() - date1.getTime());
                MM = (int) (qq / MONTH);
                sy = (date0.getTime() - date1.getTime()) % MONTH;
                dd = (int) (sy / DAY);
                sy = sy % DAY;
                hh = (int) (sy / HOUR);
                sy = sy % HOUR;
                mm = (int) (sy / MINUTE);
                sy = sy % MINUTE;
                ss = (int) (sy / SECOND);
            } catch (ParseException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                 String sj[]={"MM","dd","hh","mm","ss"};
                 return sj;

}*/













import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
*
* @author Administrator
*/



public class Test
{
	public static void main(String args[])
	{
		new Test();
	} 	
}



class JD extends Thread 
{

	JProgressBar jProgressBar0;
	JProgressBar jProgressBar1;
	JProgressBar jProgressBar2;
	JProgressBar jProgressBar3;
	JProgressBar jProgressBar4;
	JLabel jLabel1;


	public JD(JProgressBar jProgressBar0, JProgressBar jProgressBar1, JProgressBar jProgressBar2, JProgressBar jProgressBar3, JProgressBar jProgressBar4,JLabel jLabel1) {
		this.jProgressBar0 = jProgressBar0;
		this.jProgressBar1 = jProgressBar1;
		this.jProgressBar2 = jProgressBar2;
		this.jProgressBar3 = jProgressBar3;
		this.jProgressBar4 = jProgressBar4;
		this.jLabel1= jLabel1;
    
}

@Override
public void run() {                                                                       //用线程实现进度条的更新
    while (true) {
        if (true) {
           

             int sj[]= sj();
            this.jProgressBar0.setValue(sj[4] * (jProgressBar0.getMaximum()) / 60);
            this.jProgressBar1.setValue(sj[3] * (jProgressBar1.getMaximum()) / 60);
            this.jProgressBar2.setValue(sj[2] * (jProgressBar2.getMaximum()) / 24);
            this.jProgressBar3.setValue(sj[1] * (jProgressBar3.getMaximum()) / 30);
            this.jProgressBar4.setValue(sj[0] * (jProgressBar4.getMaximum()) / 12);
            jLabel1.setText("距北京奥运会有"+sj[0]+"月\n"+""+sj[1]+"天"+sj[2]+"时"+sj[3]+"分"+sj[4]+"秒");

            try {
                Thread.sleep(1000);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

        }

    }
}

public int[] sj()
{
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");
            long dayNumber = 0;
            long SECOND = 1000L;
            long MINUTE = 60L * 1000L;
            long HOUR = 60L * 60L * 1000L;
            long DAY = 24L * 60L * 60L * 1000L;
            long MONTH = 30L * 24L * 60L * 60L * 1000L;
            long sy = 0, qq = 0;
            int ss = 0, mm = 0, hh = 0, dd = 0, MM = 0;



            try {                                                                                                   //得到月日小时分秒值
                Date date1 = new Date();
                Date date0 = sdf.parse("2008-08-08-08-00-00");
                qq = (date0.getTime() - date1.getTime());
                MM = (int) (qq / MONTH);
                sy = (date0.getTime() - date1.getTime()) % MONTH;
                dd = (int) (sy / DAY);
                sy = sy % DAY;
                hh = (int) (sy / HOUR);
                sy = sy % HOUR;
                mm = (int) (sy / MINUTE);
                sy = sy % MINUTE;
                ss = (int) (sy / SECOND);
            } catch (ParseException ex) {
                Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                 int sj[]={MM,dd,hh,mm,ss};
                 return sj;

	}    





}