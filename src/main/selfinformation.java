package main;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;


public class selfinformation{
	private DefaultTableModel tableModel;
	private JFrame f;
	public selfinformation(String u){
		List<Map> list =dao.studentinformation(u);
		Object[] data=new Object[5];
        data[0]=list.get(0).get("sno");
        data[1]=list.get(0).get("sname");
        data[2]=list.get(0).get("sage");
        data[3]=list.get(0).get("ssex");
        data[4]=list.get(0).get("sdept");
        f=new JFrame("主页");
        f.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\\\Java\\\\javacode\\\\javafi\\image\\home.png"));
        f.getContentPane().setBackground(Color.WHITE);
        Container c = f.getContentPane();
		f.setSize(1000,700);
		Point p=new Point(250,80);
		f.setLocation(p);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.getContentPane().setLayout(null);
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(SystemColor.activeCaption);
		titlePanel.setBounds(0, -1, 986, 79);
		c.add(titlePanel);
		titlePanel.setLayout(null);
		JLabel j=new JLabel("欢迎登录学生成绩管理系统");
		j.setBackground(Color.WHITE);
		j.setBounds(365, 35, 317, 45);
		titlePanel.add(j);
		j.setFont(new Font("等线", Font.BOLD, 25));
		JLabel lblNewLabel1 = new JLabel("\u5B66\u751F\u7AEF");
		lblNewLabel1.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\log.png"));
		lblNewLabel1.setFont(new Font("等线", Font.BOLD, 20));
		lblNewLabel1.setBounds(876, 48, 100, 22);
		titlePanel.add(lblNewLabel1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 986, 29);
		titlePanel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u83DC\u5355");
		mnNewMenu.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\menu.png"));
		mnNewMenu.setFont(new Font("等线", Font.PLAIN, 17));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u5E2E\u52A9");
		mntmNewMenuItem.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\help.png"));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(java.awt.Desktop.isDesktopSupported()){
					try {
					java.net.URI uri = java.net.URI.create("https://blog.csdn.net/Ambrosecm/article/details/110495061");
					java.awt.Desktop dp = java.awt.Desktop.getDesktop();
					if(dp.isSupported(java.awt.Desktop.Action.BROWSE)){
					dp.browse(uri);
					}
					} catch (java.io.IOException a) {
					}
				}
			}
		});
		mntmNewMenuItem.setFont(new Font("等线", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u8FD4\u56DE\u767B\u9646\u9875\u9762");
		mntmNewMenuItem_1.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\pre.png"));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new login();
				f.dispose();
			}
		});
		mntmNewMenuItem_1.setFont(new Font("等线", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem_2.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\unlogin.png"));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		mntmNewMenuItem_2.setFont(new Font("等线", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_1 = new JMenu("\u8BBE\u7F6E");
		mnNewMenu_1.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\setting.png"));
		mnNewMenu_1.setFont(new Font("等线", Font.PLAIN, 16));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem_3.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\clearIpt.png"));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new editpassword();
			}
		});
		mntmNewMenuItem_3.setFont(new Font("等线", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\1ff26652f2e12fe76fc23380ade6e0ef.jpg"));
		lblNewLabel_7.setBounds(0, 26, 1035, 327);
		titlePanel.add(lblNewLabel_7);
		
		JPanel menupanel = new JPanel();
		menupanel.setBackground(SystemColor.inactiveCaption);
		menupanel.setBounds(0, 88, 179, 575);
		JButton B1 = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		B1.setFont(new Font("等线", Font.PLAIN, 13));
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new selfinformation(u);
				
			}
		});
		B1.setBounds(39, 41, 109, 59);
		B1.setBackground(new Color(255, 255, 255));
		menupanel.setLayout(null);
		menupanel.add(B1);
		
		JButton B4 = new JButton("\u6210\u7EE9\u67E5\u8BE2");
		B4.setFont(new Font("等线", Font.PLAIN, 13));
		B4.setBounds(39, 159, 109, 59);
		B4.setBackground(new Color(255, 255, 255));
		B4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new selfstudentscore(u);
				f.dispose();
			}
		});
		menupanel.add(B4);
		
		
		JButton B3 = new JButton("\u9009\u8BFE\u7BA1\u7406");
		B3.setFont(new Font("等线", Font.PLAIN, 13));
		B3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new selfstudentcourse(u);
				f.dispose();
			}
		});
		B3.setBackground(new Color(255, 255, 255));
		B3.setBounds(39, 284, 109, 59);
		menupanel.add(B3);
		
		f.getContentPane().add(menupanel);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\1ff26652f2e12fe76fc23380ade6e0ef.jpg"));
		lblNewLabel_8.setBounds(0, 0, 179, 575);
		menupanel.add(lblNewLabel_8);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 78, 986, 10);
		f.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 239, 213));
		panel_1.setBounds(176, 88, 810, 575);
		f.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5B66\u53F7\uFF1A");
		lblNewLabel.setFont(new Font("等线", Font.PLAIN, 18));
		lblNewLabel.setBounds(140, 60, 103, 43);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D\uFF1A");
		lblNewLabel_2.setFont(new Font("等线", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(140, 135, 103, 43);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel(data[1].toString());
		lblNewLabel_1_1.setFont(new Font("等线", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(253, 140, 139, 31);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u5E74\u9F84\uFF1A");
		lblNewLabel_3.setFont(new Font("等线", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(140, 210, 103, 43);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_2 = new JLabel(data[2].toString());
		lblNewLabel_1_2.setFont(new Font("等线", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(253, 215, 139, 31);
		panel_1.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_4 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_4.setFont(new Font("等线", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(140, 285, 103, 43);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_3 = new JLabel(data[3].toString());
		lblNewLabel_1_3.setFont(new Font("等线", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(253, 290, 139, 31);
		panel_1.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_5 = new JLabel("\u4E13\u4E1A\uFF1A");
		lblNewLabel_5.setFont(new Font("等线", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(140, 360, 103, 43);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_4 = new JLabel(data[4].toString());
		lblNewLabel_1_4.setFont(new Font("等线", Font.PLAIN, 18));
		lblNewLabel_1_4.setBounds(253, 365, 139, 31);
		panel_1.add(lblNewLabel_1_4);
		
		JButton btnNewButton = new JButton("\u4FEE\u6539\u4FE1\u606F");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\export.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editframe f2 =new editframe();
				f2.selfeditstudent(data[0].toString(),data[1].toString(),Integer.parseInt( data[2].toString()),data[3].toString(),data[4].toString());	
				
			}
		});
		btnNewButton.setFont(new Font("等线", Font.PLAIN, 15));
		btnNewButton.setBounds(140, 452, 120, 37);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5237\u65B0");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\clearIpt.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new selfinformation(u);
			}
		});
		btnNewButton_1.setFont(new Font("等线", Font.PLAIN, 15));
		btnNewButton_1.setBounds(301, 452, 120, 37);
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel(data[0].toString());
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(253, 65, 139, 31);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("等线", Font.PLAIN, 18));

		f.setVisible(true);
	}
	private void refresh(String u) {
		 f.dispose();
		new selfinformation(u);
	 }
}
