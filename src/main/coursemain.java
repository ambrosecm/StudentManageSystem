package main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

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


public class coursemain{
	private JFrame f=new JFrame("主页");
	private JPanel mainpanel;
	private JTextField sno;
	private JTextField sname;
	private JTextField sdept;
	private JTextField course;
	private JButton students;
	private JButton studentcourse;
	private JButton studentscore;
	private JButton searchbutton;
	private JButton addbutton;
	private JButton editbutton;
	private JButton deletebutton;
	private JTable table;
	private DefaultTableModel tableModel;
	private JScrollPane scrollPane;
	private final JLabel lblNewLabel_7 = new JLabel("New label");
	
	private void setcoursemain(){
        f.getContentPane().setBackground(Color.WHITE);
        Container c = f.getContentPane();
		f.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\\\Java\\\\javacode\\\\javafi\\image\\home.png"));
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
		JLabel j=new JLabel("\u6B22\u8FCE\u767B\u5F55\u5B66\u751F\u4FE1\u606F\u7BA1\u7406\u7CFB\u7EDF");
		j.setBackground(Color.WHITE);
		j.setBounds(365, 35, 317, 45);
		titlePanel.add(j);
		j.setFont(new Font("等线", Font.BOLD, 25));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 986, 31);
		titlePanel.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u83DC\u5355");
		mnNewMenu.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\menu.png"));
		mnNewMenu.setFont(new Font("等线", Font.PLAIN, 17));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u5E2E\u52A9");
		mntmNewMenuItem_3.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\help.png"));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
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
		mntmNewMenuItem_3.setFont(new Font("等线", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("\u8FD4\u56DE\u767B\u9646\u9875\u9762");
		mntmNewMenuItem_2.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\pre.png"));
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new login();
				f.dispose();
			}
		});
		mntmNewMenuItem_2.setFont(new Font("等线", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		mntmNewMenuItem.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\unlogin.png"));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
			}
		});
		mntmNewMenuItem.setFont(new Font("等线", Font.PLAIN, 16));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("\u8BBE\u7F6E");
		mnNewMenu_1.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\setting.png"));
		mnNewMenu_1.setFont(new Font("等线", Font.PLAIN, 17));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem_1.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\clearIpt.png"));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new editpassword();
			}
		});
		mntmNewMenuItem_1.setFont(new Font("等线", Font.PLAIN, 16));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		JLabel lblNewLabel1 = new JLabel("管理员端");
		lblNewLabel1.setBounds(876, 48, 100, 22);
		titlePanel.add(lblNewLabel1);
		lblNewLabel1.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\console.png"));
		lblNewLabel1.setFont(new Font("等线", Font.BOLD, 20));
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(0, -87, 999, 478);
		titlePanel.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\1ff26652f2e12fe76fc23380ade6e0ef.jpg"));
		JMenu menu1=new JMenu("菜单");
		
		JPanel menupanel = new JPanel();
		menupanel.setBackground(SystemColor.inactiveCaption);
		menupanel.setBounds(0, 88, 179, 575);
		students = new JButton("学生管理");
		students.setFont(new Font("等线", Font.PLAIN, 12));
		students.setBounds(35, 40, 110, 60);
		students.setBackground(new Color(255, 250, 250));
		menupanel.setLayout(null);
		menupanel.add(students);
		
		studentcourse = new JButton("学生选课管理");
		studentcourse.setFont(new Font("等线", Font.PLAIN, 12));
		studentcourse.setBackground(new Color(255, 250, 250));
		studentcourse.setBounds(35, 150, 110, 60);
		menupanel.add(studentcourse);
		
		studentscore = new JButton("学生成绩管理");
		studentscore.setFont(new Font("等线", Font.PLAIN, 12));
		studentscore.setBounds(35, 260, 110, 60);
		studentscore.setBackground(Color.WHITE);
		menupanel.add(studentscore);
		f.getContentPane().add(menupanel);
		lblNewLabel_7.setIcon(new ImageIcon("D:\\Java\\javacode\\javafi\\image\\1ff26652f2e12fe76fc23380ade6e0ef.jpg"));
		lblNewLabel_7.setBounds(-28, 0, 207, 575);
		menupanel.add(lblNewLabel_7);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 78, 986, 10);
		f.getContentPane().add(panel);
		
		mainpanel = new JPanel();
		mainpanel.setBackground(new Color(255, 228, 225));
		mainpanel.setBounds(180, 88, 806, 115);
		f.getContentPane().add(mainpanel);
		mainpanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("学号");
		lblNewLabel.setFont(new Font("等线", Font.PLAIN, 16));
		lblNewLabel.setBounds(25, 10, 72, 43);
		mainpanel.add(lblNewLabel);
		sno = new JTextField();
		sno.setFont(new Font("等线", Font.PLAIN, 14));
		sno.setBounds(68, 22, 124, 21);
		mainpanel.add(sno);
		sno.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setFont(new Font("等线", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(210, 10, 72, 43);
		mainpanel.add(lblNewLabel_1);
		sname = new JTextField();
		sname.setFont(new Font("等线", Font.PLAIN, 14));
		sname.setColumns(10);
		sname.setBounds(252, 22, 124, 21);
		mainpanel.add(sname);
		
		JLabel lblNewLabel_2 = new JLabel("专业");
		lblNewLabel_2.setFont(new Font("等线", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(405, 10, 72, 43);
		mainpanel.add(lblNewLabel_2);
		sdept = new JTextField();
		sdept.setFont(new Font("等线", Font.PLAIN, 14));
		sdept.setColumns(10);
		sdept.setBounds(447, 22, 124, 21);
		mainpanel.add(sdept);
		
		JLabel lblNewLabel_3 = new JLabel("课程");
		lblNewLabel_3.setFont(new Font("等线", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(600, 10, 72, 43);
		mainpanel.add(lblNewLabel_3);
		course = new JTextField();
		course.setFont(new Font("等线", Font.PLAIN, 14));
		course.setBounds(642, 22, 124, 21);
		mainpanel.add(course);
		course.setColumns(10);
		
		searchbutton = new JButton("查询");
		searchbutton.setForeground(new Color(0, 0, 0));
		searchbutton.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\search.png"));
		searchbutton.setFont(new Font("等线", Font.PLAIN, 14));
		searchbutton.setBackground(new Color(244, 164, 96));
		searchbutton.setBounds(550, 69, 85, 35);
		mainpanel.add(searchbutton);
		
		addbutton = new JButton("增加");
		addbutton.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\import.png"));
		addbutton.setFont(new Font("等线", Font.PLAIN, 14));
		addbutton.setBackground(new Color(244, 164, 96));
		addbutton.setBounds(25, 70, 85, 32);
		mainpanel.add(addbutton);
		
		editbutton = new JButton("修改");
		editbutton.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\result.png"));
		editbutton.setFont(new Font("等线", Font.PLAIN, 14));
		editbutton.setBackground(new Color(244, 164, 96));
		editbutton.setBounds(150, 70, 85, 32);
		mainpanel.add(editbutton);
		
		deletebutton = new JButton("删除");
		deletebutton.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\delete.png"));
		deletebutton.setFont(new Font("等线", Font.PLAIN, 14));
		deletebutton.setBackground(new Color(244, 164, 96));
		deletebutton.setBounds(275, 70, 85, 32);
		mainpanel.add(deletebutton);
		
		JButton refreshbutton = new JButton("\u5237\u65B0");
		refreshbutton.setForeground(new Color(0, 0, 0));
		refreshbutton.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\clearIpt.png"));
		refreshbutton.setFont(new Font("等线", Font.PLAIN, 14));
		refreshbutton.setBackground(new Color(244, 164, 96));
		refreshbutton.setBounds(682, 69, 85, 35);
		mainpanel.add(refreshbutton);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(-27, 104, 833, 473);
		mainpanel.add(lblNewLabel_6);
		
	
		List<Map> list =dao.getcourse();
		Object[] head = {"学号","姓名","专业","已选课程"};
		Object[][] data=new Object[list.size()][head.length];
        for(int i=0;i<list.size();i++){
                data[i][0]=list.get(i).get("sno");
                data[i][1]=list.get(i).get("sname");
                data[i][2]=list.get(i).get("sdept");
                data[i][3]=list.get(i).get("course");
        }
        tableModel = new DefaultTableModel(data, head);
        table = new JTable(tableModel);
        table.setForeground(Color.BLACK);
        table.setBackground(Color.WHITE);
        table.setFont(new Font("宋体", Font.PLAIN, 13));
		scrollPane = new JScrollPane();
		scrollPane.setBounds(180, 201, 806, 462);
		f.getContentPane().add(scrollPane);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		scrollPane.setColumnHeaderView(lblNewLabel_5);
		lblNewLabel_5.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\1ff26652f2e12fe76fc23380ade6e0ef.jpg"));
	
		f.setVisible(true);
	}
	coursemain() {
		setcoursemain();
		students.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new studentmain();	
		        
			}
		});
		
		studentcourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new coursemain();	
			}
		});
		studentscore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				new scoremain();	
			}
		});
		searchbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				List<Map> list =dao.coursescearch(sno.getText(),sname.getText(),sdept.getText(),course.getText());
				Object[] head = {"学号","姓名","专业","已选课程"};
				Object[][] data=new Object[list.size()][head.length];
		        for(int i=0;i<list.size();i++){
		                data[i][0]=list.get(i).get("sno");
		                data[i][1]=list.get(i).get("sname");
		                data[i][2]=list.get(i).get("sdept");
		                data[i][3]=list.get(i).get("course");
		        }
				tableModel.getDataVector().clear();
		        tableModel = new DefaultTableModel(data, head);
		        table = new JTable(tableModel);
		        scrollPane.setViewportView(table);
			}
		});
		addbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addframe f1=new addframe();
				f1.addcourse();
				refresh();
			}
		});
		editbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x= table.getSelectedRow();
				if(x==-1) {JOptionPane.showMessageDialog(null,"请选择一条信息");}else {
				String oldsno = (String) table.getValueAt(x, 0);
				String oldsname = (String) table.getValueAt(x, 1);
				String oldsdept = (String) table.getValueAt(x, 2);
				String oldcourse = (String) table.getValueAt(x, 3);
				editframe f2 =new editframe();
				f2.editcourse(oldsno,oldsname,oldsdept,oldcourse);
			}
			}
		});
		deletebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x= table.getSelectedRow();
				if(x==-1) {JOptionPane.showMessageDialog(null,"请选择一条信息");}else {
				String oldsno = (String) table.getValueAt(x, 0);
				String oldcourse = (String) table.getValueAt(x, 3);
				if(JOptionPane.OK_OPTION==JOptionPane.showOptionDialog(null, "确认删除？", "友情提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{"确定","取消"}, null)){
					dao.deletecourse(oldsno,oldcourse);
				}else{
					
				}
				refresh();
				}
			}
		});
		
	}
	private void refresh() {
		List<Map> list =dao.getcourse();
		Object[] head = {"学号","姓名","专业","已选课程"};
		Object[][] data=new Object[list.size()][head.length];
        for(int i=0;i<list.size();i++){
                data[i][0]=list.get(i).get("sno");
                data[i][1]=list.get(i).get("sname");
                data[i][2]=list.get(i).get("sdept");
                data[i][3]=list.get(i).get("course");
        }
        tableModel.getDataVector().clear();
        tableModel = new DefaultTableModel(data, head);
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);
	}
}

