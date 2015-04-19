package 抽签123;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public   class   ImagePane   extends   JPanel  
{  
JLabel   jl   =   null;  
ImageIcon   img   =   null;  

public   ImagePane()  
{  
img   =   new   ImageIcon( "./image/cs.jpg");  
jl   =   new   JLabel(img);  
this.setLayout(new   BorderLayout());  
this.add(jl,   BorderLayout.CENTER);  
}  
public   static   void   main(String[]   args)  
{  
JFrame   test   =   new   JFrame( "Image   Pane ");  
test.getContentPane().add(new   ImagePane());  
test.pack();  
test.setVisible(true);  
test.addWindowListener(new   WindowAdapter()  
{  
public   void   windowClosing(WindowEvent   e)  
{  
System.exit(0);  
}  
});  
}  
}
