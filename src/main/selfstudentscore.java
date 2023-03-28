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


public class selfstudentscore{
	private  DefaultTableModel tableModel;
	private  JTable table;
	private final JLabel lblNewLabel_2 = new JLabel("New label");
	public selfstudentscore(String u) {
        JFrame f=new JFrame("主页");
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
		mntmNewMenuItem.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\setting.png"));
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
		mnNewMenu_1.setFont(new Font("等线", Font.PLAIN, 17));
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
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\1ff26652f2e12fe76fc23380ade6e0ef.jpg"));
		lblNewLabel_1.setBounds(-26, 21, 1191, 114);
		titlePanel.add(lblNewLabel_1);
		
		JPanel menupanel = new JPanel();
		menupanel.setBackground(SystemColor.inactiveCaption);
		menupanel.setBounds(0, 88, 179, 575);
		JButton B1 = new JButton("\u4E2A\u4EBA\u4FE1\u606F");
		B1.setFont(new Font("等线", Font.PLAIN, 13));
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new selfinformation(u);
				f.dispose();
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
				f.dispose();
				new selfstudentscore(u);
				
			}
		});
		menupanel.add(B4);
		f.getContentPane().add(menupanel);
		
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
		lblNewLabel_2.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\1ff26652f2e12fe76fc23380ade6e0ef.jpg"));
		lblNewLabel_2.setBounds(0, 0, 200, 575);
		menupanel.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 78, 986, 10);
		f.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 196));
		panel_1.setBounds(176, 88, 810, 139);
		f.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox coursename = new JComboBox();
		coursename.setBackground(new Color(255, 255, 255));
		coursename.setModel(new DefaultComboBoxModel(new String[] {"\u5168\u90E8\u8BFE\u7A0B", "\u9AD8\u7B49\u6570\u5B66", "\u79BB\u6563\u6570\u5B66", "\u5927\u5B66\u7269\u7406", "Java", "python", "c\u8BED\u8A00"}));
		coursename.setFont(new Font("等线", Font.PLAIN, 15));
		coursename.setBounds(266, 64, 97, 31);
		panel_1.add(coursename);
		
		JLabel lblNewLabel = new JLabel("\u8BFE\u7A0B\u540D\u79F0");
		lblNewLabel.setFont(new Font("等线", Font.PLAIN, 20));
		lblNewLabel.setBounds(140, 57, 103, 43);
		panel_1.add(lblNewLabel);
		

		
		List<Map> list =dao.getselfscore(u);
		Object[] head = {"学号","姓名","专业","高等数学","离散数学","大学物理","Java","python","c语言"};
		Object[][] data=new Object[list.size()][head.length];
        for(int i=0;i<list.size();i++){
                data[i][0]=list.get(i).get("sno");
                data[i][1]=list.get(i).get("sname");
                data[i][2]=list.get(i).get("sdept");
                data[i][3]=list.get(i).get("c1");
                data[i][4]=list.get(i).get("c2");
                data[i][5]=list.get(i).get("c3");
                data[i][6]=list.get(i).get("c4");
                data[i][7]=list.get(i).get("c5");
                data[i][8]=list.get(i).get("c6");
        }
        tableModel = new DefaultTableModel(data, head);
        table = new JTable(tableModel);
        table.setFont(new Font("宋体", Font.PLAIN, 13));
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 226, 806, 437);
		f.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		JButton search = new JButton("\u67E5\u8BE2");
		search.setBackground(new Color(255, 255, 255));
		search.setFont(new Font("等线", Font.PLAIN, 14));
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Map> list =dao.getselfscore(u);
				Object[] head = {"学号","姓名","专业","高等数学","离散数学","大学物理","Java","python","c语言"};
				Object[][] data=new Object[list.size()][head.length];
		        for(int i=0;i<list.size();i++){
		                data[i][0]=list.get(i).get("sno");
		                data[i][1]=list.get(i).get("sname");
		                data[i][2]=list.get(i).get("sdept");
		                data[i][3]=list.get(i).get("c1");
		                data[i][4]=list.get(i).get("c2");
		                data[i][5]=list.get(i).get("c3");
		                data[i][6]=list.get(i).get("c4");
		                data[i][7]=list.get(i).get("c5");
		                data[i][8]=list.get(i).get("c6");
		        }
		        for(int i=0;i<head.length;i++) {
		        	if(coursename.getSelectedItem().equals(head[i])) {
		        		Object[] head1= {head[i]};
		        		Object[][] data1= {{data[0][i]}};
		        		tableModel.getDataVector().clear();
		  
		        		tableModel = new DefaultTableModel(data1,head1);
		        		table = new JTable(tableModel);
		        		scrollPane.setViewportView(table);
			        
		        	}else if(coursename.getSelectedItem().equals("全部课程")){
		        		tableModel.getDataVector().clear();
		        		tableModel = new DefaultTableModel(data,head);
		        		table = new JTable(tableModel);
		        		scrollPane.setViewportView(table);
      
		        	}
		        }
		        
			}
		});
		search.setBounds(455, 65, 97, 31);
		panel_1.add(search);
		
		
		
		f.setVisible(true);
	}
}
