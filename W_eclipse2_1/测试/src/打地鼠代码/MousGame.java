/**
 * �ļ�����MousGame.java
 * ��Ŀ-�������� - ��������
 * ���ߣ����ĵ�
 * �������ڣ�2014-5-17
 */
package ��������;

/**
 * @author ���ĵ�
 * ������MousGame
 * ��˵����
 */
/*���������
 * MousGame.java
 *
 * Created on __DATE__, __TIME__
 */

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;




/**
 * 
 * @author __USER__
 */
public class MousGame extends javax.swing.JFrame implements Runnable
{
	private JLabel[] mouse = new JLabel[9];

	/** Creates new form MousGame */
	public MousGame()
	{
		initComponents();
		// ���ô��岻�ܱ��
		setResizable(false);
		// ���ñ���ͼƬ
		JLabel background = new JLabel(Image.background);
		jPanel1.setOpaque(false);
		jPanel1.add(background, new Integer(Integer.MIN_VALUE));
		background.setBounds(0, 0, Image.background.getIconWidth(),
				Image.background.getIconHeight());

		
		
		mouse[0] = jLabel1;
		mouse[0].setBounds(135, 120, 80, 70);
		mouse[0].addMouseListener(new MouseListener());

		mouse[1] = jLabel2;
		mouse[1].setBounds(280, 120, 80, 70);
		mouse[1].addMouseListener(new MouseListener());

		mouse[2] = jLabel3;
		mouse[2].setBounds(414, 120, 80, 70);
		mouse[2].addMouseListener(new MouseListener());

		mouse[3] = jLabel4;
		mouse[3].setBounds(128, 202, 80, 70);
		mouse[3].addMouseListener(new MouseListener());

		mouse[4] = jLabel5;
		mouse[4].setBounds(273, 202, 80, 70);
		mouse[4].addMouseListener(new MouseListener());

		mouse[5] = jLabel6;
		mouse[5].setBounds(430, 202, 80, 70);
		mouse[5].addMouseListener(new MouseListener());

		mouse[6] = jLabel7;
		mouse[6].setBounds(91, 320, 80, 70);
		mouse[6].addMouseListener(new MouseListener());

		mouse[7] = jLabel8;
		mouse[7].setBounds(279, 320, 80, 70);
		mouse[7].addMouseListener(new MouseListener());

		mouse[8] = jLabel9;
		mouse[8].setBounds(461, 320, 80, 70);
		mouse[8].addMouseListener(new MouseListener());

		// ʹ�þ��Զ�λ����label��pane�е�λ�ã���ͼƬ��Ӧ
		jPanel1.setLayout(null);
		// ��������С
		jPanel1.setPreferredSize(new Dimension(Image.background.getIconWidth(),
				Image.background.getIconHeight()));
		// �����ʽ
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Cursor cursor1 = toolkit.createCustomCursor(Image.hammer.getImage(),
				new Point(0, 0), "normal");
		Cursor cursor2 = toolkit.createCustomCursor(
				Image.hammer_down.getImage(), new Point(0, 0), "capture");
		// ��������
		addMouseListener(new MouseCrab(cursor1, cursor2));
		for (int i = 0; i < mouse.length; i++)
		{
			mouse[i].addMouseListener(new MouseCrab(cursor1, cursor2));
		}

	}

	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents()
	{

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jLabel10 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jTextField1.setEditable(false);
		jTextField1.setFont(new java.awt.Font("����", 1, 18));
		jTextField1.setForeground(new java.awt.Color(51, 255, 0));

		jTextField2.setEditable(false);
		jTextField2.setFont(new java.awt.Font("����", 1, 18));
		jTextField2.setForeground(new java.awt.Color(153, 0, 153));

		jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/com/insigma/img/start.png"))); // NOI18N
		jLabel10.addMouseListener(new java.awt.event.MouseAdapter()
		{
			public void mouseClicked(java.awt.event.MouseEvent evt)
			{
				jLabel10MouseClicked(evt);
			}
		});

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(56,
																				56,
																				56)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING,
																																false)
																														.addGroup(
																																jPanel1Layout
																																		.createSequentialGroup()
																																		.addComponent(
																																				jLabel4)
																																		.addPreferredGap(
																																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																																				javax.swing.GroupLayout.DEFAULT_SIZE,
																																				Short.MAX_VALUE)
																																		.addComponent(
																																				jLabel5))
																														.addGroup(
																																jPanel1Layout
																																		.createSequentialGroup()
																																		.addComponent(
																																				jLabel1)
																																		.addGap(39,
																																				39,
																																				39)
																																		.addComponent(
																																				jLabel2)))
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.LEADING)
																														.addComponent(
																																jLabel3)
																														.addGroup(
																																jPanel1Layout
																																		.createSequentialGroup()
																																		.addGap(134,
																																				134,
																																				134)
																																		.addComponent(
																																				jLabel6))))
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel7)
																										.addGap(49,
																												49,
																												49)
																										.addComponent(
																												jLabel8)
																										.addGap(68,
																												68,
																												68)
																										.addComponent(
																												jLabel9)))
																		.addGap(196,
																				196,
																				196))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(265,
																				265,
																				265)
																		.addComponent(
																				jLabel10))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(513,
																				513,
																				513)
																		.addComponent(
																				jTextField2,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				95,
																				Short.MAX_VALUE))
														.addGroup(
																javax.swing.GroupLayout.Alignment.TRAILING,
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(513,
																				513,
																				513)
																		.addComponent(
																				jTextField1,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				95,
																				Short.MAX_VALUE)))
										.addContainerGap()));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGap(93,
																												93,
																												93)
																										.addComponent(
																												jLabel1))
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGap(101,
																												101,
																												101)
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																jLabel2)
																														.addComponent(
																																jLabel3))))
																		.addGap(40,
																				40,
																				40)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel4)
																						.addComponent(
																								jLabel5)
																						.addComponent(
																								jLabel6))
																		.addGap(34,
																				34,
																				34)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel7)
																						.addComponent(
																								jLabel8)
																						.addComponent(
																								jLabel9)))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jTextField1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				21,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(6,
																				6,
																				6)
																		.addComponent(
																				jTextField2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				18,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED,
												275, Short.MAX_VALUE)
										.addComponent(jLabel10)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.Alignment.TRAILING,
				javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addComponent(
				jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
				javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	/**
	 * ��ʼ�¼�
	 * @param evt
	 */
	private void jLabel10MouseClicked(java.awt.event.MouseEvent evt)
	{
		if (!CommUtil.boo)
		{
			CommUtil.boo = true;//�򿪿���
			this.jLabel10.setIcon(new javax.swing.ImageIcon(getClass()
					.getResource("/com/insigma/img/pause.png")));
		} else
		{
			CommUtil.boo = false;
			this.jLabel10.setIcon(new javax.swing.ImageIcon(getClass()
					.getResource("/com/insigma/img/start.png")));
		}
	}

	/**
	 * �����ڲ��࣬�����ʽ����������
	 * 
	 * @author Administrator
	 * 
	 */
	private class MouseCrab implements MouseListener
	{
		private final Cursor cursor1;// ���ͼ��1
		private final Cursor cursor2;// ���ͼ��2

		/**
		 * ���췽��
		 * 
		 * @param cursor1
		 * @param cursor2
		 */
		private MouseCrab(Cursor cursor1, Cursor cursor2)
		{
			this.cursor1 = cursor1;
			this.cursor2 = cursor2;
			setCursor(cursor1);
		}

		public void mouseReleased(MouseEvent e)
		{
			setCursor(cursor1);// ��갴���ͷ�ʱ���ù��Ϊcursor1
		}

		public void mousePressed(MouseEvent e)
		{
			jTextField2.setText(String.valueOf(CommUtil.sorce
					* CommUtil.sorcelint));
			setCursor(cursor2);// ��갴������ʱ���ù��Ϊcursor2
		}

		public void mouseExited(MouseEvent e)
		{
			setCursor(cursor1);// ����뿪�ؼ�����ʱ���ù��Ϊcursor1
		}

		public void mouseEntered(MouseEvent e)
		{
		}

		public void mouseClicked(MouseEvent e)
		{
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[])
	{
		MousGame frame = new MousGame();
		frame.setVisible(true);
		Thread thread = new Thread(frame);
		thread.start();

		// BackGroupAuto backGroupAuto = new BackGroupAuto();
		// backGroupAuto.start();
	}

	/**
	 * run
	 */
	@Override
	public void run()
	{
		while (true)// ʹ������ѭ��
		{
			if (CommUtil.boo)
			{
				try
				{
					if (CommUtil.maxtime <= CommUtil.time)
					{
						JOptionPane.showMessageDialog(this, "����ʱ�䵽��\n����ܷ֣�"
								+ CommUtil.sorce * CommUtil.sorcelint);
						CommUtil.maxtime = 60;//ʱ����0
						CommUtil.sorce = 0;//������0
						CommUtil.boo = false;//�ر�
						this.jTextField1.setText("60");
						this.jTextField2.setText("0");
						this.jLabel10.setIcon(new javax.swing.ImageIcon(
								getClass().getResource(
										"/com/insigma/img/start.png")));
					} else
					{
						this.jTextField1.setText(String
								.valueOf(CommUtil.maxtime--));
					}

					int index = (int) (Math.random() * 9);// ����������з����
					if (mouse[index].getIcon() == null)
					{// ����з��ǩû������ͼƬ
						mouse[index].setIcon(Image.big_mouse);// Ϊ�ñ�ǩ����зͼƬ
						Thread.sleep(1000); // ʹ�߳�����1��
					} else
					{
						JLabel jcarb = (JLabel) mouse[index]; // ǿ��ת��ΪJLabel��ǩ
						jcarb.setIcon(null);// �����ǩ�е��зͼƬ
						Thread.sleep(1000); // ʹ�߳�����1��
					}
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}

	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	// End of variables declaration//GEN-END:variables

}


