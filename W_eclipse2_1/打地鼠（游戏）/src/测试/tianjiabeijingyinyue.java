/**
 * �ļ�����tianjiabeijingyinyue.java
 * ��Ŀ-�����������Ϸ�� - ����
 * ���ߣ����ĵ�
 * �������ڣ�2014-5-21
 */
package ����;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 * @author ���ĵ�
 * ������tianjiabeijingyinyue
 * ��˵����
 */

 
public class tianjiabeijingyinyue extends JFrame implements ActionListener{
    AudioStream as;
    FileInputStream fileau;
    XYLayout xYLayout1 = new XYLayout();
    JButton jButton1 = new JButton();
    //     AudioPlayer.player.stop(as);
    tianjiabeijingyinyue(){
        try {
            jbInit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void main(String[] args) {
    	tianjiabeijingyinyue t = new tianjiabeijingyinyue();
        t.setVisible(true);
        t.setSize(200, 200);

    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(xYLayout1);
        jButton1.setText("jButton1");
        jButton1.addActionListener(this);
        this.getContentPane().add(jButton1, new XYConstraints(175, 46, 151, 113));
    }

    public void actionPerformed(ActionEvent e) {
        try {

            fileau = new FileInputStream("quite.midi");

        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }

        try {
            as = new AudioStream(fileau);
            AudioPlayer.player.start(as);
        } catch (IOException ex1) {
            System.out.println(ex1);
        }

    }
}
