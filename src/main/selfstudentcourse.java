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


public class selfstudentcourse{
	private DefaultTableModel tableModel;
	private JTable table;
	private JPanel panel_1;
	private JScrollPane scrollPane;
	private final JLabel lblNewLabel_1 = new JLabel("New label");
	public selfstudentcourse(String u){
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
		
		JLabel lblNewLabel = new JLabel("\u5B66\u751F\u7AEF");
		lblNewLabel.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\log.png"));
		lblNewLabel.setFont(new Font("等线", Font.BOLD, 20));
		lblNewLabel.setBounds(876, 48, 100, 22);
		titlePanel.add(lblNewLabel);
		lblNewLabel_1.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\1ff26652f2e12fe76fc23380ade6e0ef.jpg"));
		lblNewLabel_1.setBounds(0, 28, 1050, 57);
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
				new selfstudentscore(u);
				f.dispose();
			}
		});
		menupanel.add(B4);
		f.getContentPane().add(menupanel);
		
		JButton B3 = new JButton("\u9009\u8BFE\u7BA1\u7406");
		B3.setFont(new Font("等线", Font.PLAIN, 13));
		B3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new selfstudentcourse(u);
				
			}
		});
		B3.setBackground(new Color(255, 255, 255));
		B3.setBounds(39, 284, 109, 59);
		menupanel.add(B3);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\1ff26652f2e12fe76fc23380ade6e0ef.jpg"));
		lblNewLabel_2.setBounds(-21, -22, 243, 617);
		menupanel.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 78, 986, 10);
		f.getContentPane().add(panel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(119, 136, 153));
		panel_1.setBounds(176, 88, 810, 575);
		f.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		List<Map> list =dao.getselfcourse(u);
		Object[] head = {"已选课程"};
		Object[][] data=new Object[list.size()][head.length];
        for(int i=0;i<list.size();i++){
                data[i][0]=list.get(i).get("course");
        }
        tableModel = new DefaultTableModel(data, head);
		
		JButton btnNewButton = new JButton("\u589E\u52A0\u9009\u8BFE");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\import.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addframe f1=new addframe();
				f1.selfaddcourse(u);
				refresh(u);
			}
		});
		btnNewButton.setFont(new Font("等线", Font.PLAIN, 15));
		btnNewButton.setBounds(100, 347, 120, 37);
		panel_1.add(btnNewButton);
		
		JButton delete = new JButton("\u5220\u9664\u8BFE\u7A0B");
		delete.setBackground(new Color(255, 255, 255));
		delete.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\delete.png"));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x= table.getSelectedRow();
				if(x==-1) {JOptionPane.showMessageDialog(null,"请选择一条信息");}else {
				String oldcourse = (String) table.getValueAt(x, 0);
				if(JOptionPane.OK_OPTION==JOptionPane.showOptionDialog(null, "确认删除？", "友情提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{"确定","取消"}, null)){
					dao.deletecourse(u,oldcourse);
					refresh(u);
				}else{
				}
				
				}
			}
		});
		delete.setFont(new Font("等线", Font.PLAIN, 15));
		delete.setBounds(270, 347, 120, 37);
		panel_1.add(delete);
		
		JButton btnNewButton_1 = new JButton("\u5237\u65B0");
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\clearIpt.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refresh(u);
			}
		});
		btnNewButton_1.setFont(new Font("等线", Font.PLAIN, 14));
		btnNewButton_1.setBounds(440, 347, 120, 37);
		panel_1.add(btnNewButton_1);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 100, 460, 193);
		panel_1.add(scrollPane);
		table = new JTable(tableModel);
		scrollPane.setViewportView(table);
		table.setFont(new Font("宋体", Font.PLAIN, 13));

		f.setVisible(true);
	}
	private void refresh(String u) {
		List<Map> list =dao.getselfcourse(u);
		Object[] head = {"已选课程"};
		Object[][] data=new Object[list.size()][head.length];
        for(int i=0;i<list.size();i++){
                data[i][0]=list.get(i).get("course");
        }
        tableModel.getDataVector().clear();
        tableModel = new DefaultTableModel(data, head);
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);
		
	}
}
