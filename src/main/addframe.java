package main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;

public class addframe {
	public  final JLabel lblNewLabel_4 = new JLabel("New label");
	public void addstudent() {   
		
		JFrame jf =  new  JFrame("添加学生信息");
		jf.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\\\Java\\\\javacode\\\\javafi\\image\\import.png"));
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setSize(400,500);
		Point p=new Point(550,180);
		jf.setLocation(p);
		JTextField sno;
		JTextField sname;
		JTextField sage;
		JTextField sdept;  
        jf.getContentPane().setLayout(null);
         JLabel lblNewLabel = new JLabel("\u5B66\u53F7");
         lblNewLabel.setFont(new Font("等线", Font.PLAIN, 17));
         lblNewLabel.setBounds(75, 50, 67, 26);
         jf.getContentPane().add(lblNewLabel);
         
         sno = new JTextField();
         sno.setFont(new Font("等线", Font.PLAIN, 16));
         sno.setBounds(155, 50, 150, 25);
         jf.getContentPane().add(sno);
         sno.setColumns(10);
         
         JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
         lblNewLabel_1.setFont(new Font("等线", Font.PLAIN, 17));
         lblNewLabel_1.setBounds(75, 110, 67, 26);
         jf.getContentPane().add(lblNewLabel_1);
         
         sname = new JTextField();
         sname.setFont(new Font("等线", Font.PLAIN, 16));
         sname.setColumns(10);
         sname.setBounds(155, 110, 150, 25);
         jf.getContentPane().add(sname);
         
         JLabel lblNewLabel_2 = new JLabel("\u5E74\u9F84");
         lblNewLabel_2.setFont(new Font("等线", Font.PLAIN, 17));
         lblNewLabel_2.setBounds(75, 170, 67, 26);
         jf.getContentPane().add(lblNewLabel_2);
         
         sage = new JTextField();
         sage.setFont(new Font("等线", Font.PLAIN, 16));
         sage.setColumns(10);
         sage.setBounds(155, 172, 150, 25);
         jf.getContentPane().add(sage);
         
         JLabel lblNewLabel_3 = new JLabel("\u4E13\u4E1A");
         lblNewLabel_3.setFont(new Font("等线", Font.PLAIN, 17));
         lblNewLabel_3.setBounds(75, 290, 67, 26);
         jf.getContentPane().add(lblNewLabel_3);
         
         sdept = new JTextField();
         sdept.setFont(new Font("等线", Font.PLAIN, 16));
         sdept.setColumns(10);
         sdept.setBounds(155, 290, 150, 23);
         jf.getContentPane().add(sdept);
         
         JComboBox sexbox = new JComboBox();
         sexbox.setBackground(new Color(255, 255, 255));
         sexbox.setFont(new Font("宋体", Font.PLAIN, 16));
         sexbox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
         sexbox.setBounds(155, 226, 53, 30);
         jf.getContentPane().add(sexbox);
         
         JLabel lblNewLabel_3_1 = new JLabel("\u6027\u522B");
         lblNewLabel_3_1.setFont(new Font("等线", Font.PLAIN, 17));
         lblNewLabel_3_1.setBounds(75, 230, 67, 26);
         jf.getContentPane().add(lblNewLabel_3_1);
         
         JButton btnNewButton = new JButton("确定");
         btnNewButton.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\import.png"));
         btnNewButton.setFont(new Font("等线", Font.PLAIN, 18));
         btnNewButton.setBounds(75, 370, 97, 29);
         jf.getContentPane().add(btnNewButton);
         
         JButton btnNewButton_1 = new JButton("取消");
         btnNewButton_1.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\close.png"));
         btnNewButton_1.setFont(new Font("等线", Font.PLAIN, 18));
         btnNewButton_1.setBounds(208, 370, 97, 29);
         
         jf.getContentPane().add(btnNewButton_1);
         lblNewLabel_4.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\1ff26652f2e12fe76fc23380ade6e0ef.jpg"));
         lblNewLabel_4.setBounds(0, 0, 386, 463);
         jf.getContentPane().add(lblNewLabel_4);
         jf.setVisible( true );
 
	     btnNewButton.addActionListener(new ActionListener() {
	         	public void actionPerformed(ActionEvent e) {
	         		if(sno.getText()==""||sname.getText()==""||sage.getText()==""||sexbox.getSelectedItem().toString()==""||sdept.getText()=="") {
	         			JOptionPane.showMessageDialog(null,"添加失败，请填写完整信息");
	         		}else {
	         			dao.addstudent(sno.getText(),sname.getText(),sage.getText(),sexbox.getSelectedItem().toString(),sdept.getText());
	         			
	         			jf.dispose();
	         		}
	         		
	         	}
	         });
	    btnNewButton_1.addActionListener(new ActionListener() {
	         	public void actionPerformed(ActionEvent e) {
	         		jf.dispose();
	         	}
	         });
	         
	    	
	     }
	public void addcourse() {  
		JFrame jf =  new  JFrame("添加学生选课信息");
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setSize(400,500);
		Point p=new Point(550,180);
		jf.setLocation(p);
		JTextField sno;
		JTextField sname;
		JTextField sdept;  
		JTextField course;
        jf.getContentPane().setLayout(null);
         JLabel lblNewLabel = new JLabel("\u5B66\u53F7");
         lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel.setBounds(84, 60, 76, 29);
         jf.getContentPane().add(lblNewLabel);
         
         sno = new JTextField();
         sno.setBounds(180, 63, 147, 23);
         jf.getContentPane().add(sno);
         sno.setColumns(10);
         
         JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
         lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_1.setBounds(84, 117, 76, 29);
         jf.getContentPane().add(lblNewLabel_1);
         
         sname = new JTextField();
         sname.setColumns(10);
         sname.setBounds(180, 120, 147, 23);
         jf.getContentPane().add(sname);
         
         JLabel lblNewLabel_3 = new JLabel("\u4E13\u4E1A");
         lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3.setBounds(84, 178, 76, 29);
         jf.getContentPane().add(lblNewLabel_3);
         
         sdept = new JTextField();
         sdept.setColumns(10);
         sdept.setBounds(180, 181, 147, 23);
         jf.getContentPane().add(sdept);
         
         JButton btnNewButton = new JButton("确定");
         btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
         btnNewButton.setBounds(64, 346, 97, 29);
         jf.getContentPane().add(btnNewButton);
         
         JButton btnNewButton_1 = new JButton("取消");
         btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
         btnNewButton_1.setBounds(217, 346, 97, 29);
         
         jf.getContentPane().add(btnNewButton_1);
         
         JLabel lblNewLabel_3_1 = new JLabel("\u8BFE\u7A0B");
         lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3_1.setBounds(84, 241, 76, 29);
         jf.getContentPane().add(lblNewLabel_3_1);
         
         course = new JTextField();
         course.setColumns(10);
         course.setBounds(180, 244, 147, 23);
         jf.getContentPane().add(course);
         jf.setVisible( true );
 
	     btnNewButton.addActionListener(new ActionListener() {
	         	public void actionPerformed(ActionEvent e) {
	         		if(sno.getText()==""||sname.getText()==""||sdept.getText()==""||course.getText()=="") {
	         			JOptionPane.showMessageDialog(null,"添加失败，请填写完整信息");
	         		}else {
	         			dao.addcourse(sno.getText(),sname.getText(),sdept.getText(),course.getText());
	         			jf.dispose();
	         			
	         		}
	         		
	         	}
	         });
	    btnNewButton_1.addActionListener(new ActionListener() {
	         	public void actionPerformed(ActionEvent e) {
	         		jf.dispose();
	         	}
	         });	
	 
	}
	public void addscore() {  
		JFrame jf =  new  JFrame("添加学生成绩信息");
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setSize(400,500);
		Point p=new Point(550,180);
		jf.setLocation(p);
		JTextField sno;
		JTextField sname;
		JTextField sdept;  
		JTextField c1,c2,c3,c4,c5,c6;
        jf.getContentPane().setLayout(null);
         JLabel lblNewLabel = new JLabel("\u5B66\u53F7");
         lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel.setBounds(84, 30, 76, 29);
         jf.getContentPane().add(lblNewLabel);
         
         sno = new JTextField();
         sno.setBounds(180, 33, 147, 23);
         jf.getContentPane().add(sno);
         sno.setColumns(10);
         
         JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
         lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_1.setBounds(84, 69, 76, 29);
         jf.getContentPane().add(lblNewLabel_1);
         
         sname = new JTextField();
         sname.setColumns(10);
         sname.setBounds(180, 72, 147, 23);
         jf.getContentPane().add(sname);
         
         JLabel lblNewLabel_3 = new JLabel("\u4E13\u4E1A");
         lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3.setBounds(84, 108, 76, 29);
         jf.getContentPane().add(lblNewLabel_3);
         
         sdept = new JTextField();
         sdept.setColumns(10);
         sdept.setBounds(180, 111, 147, 23);
         jf.getContentPane().add(sdept);
         
         JButton btnNewButton = new JButton("确定");
         btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
         btnNewButton.setBounds(64, 346, 97, 29);
         jf.getContentPane().add(btnNewButton);
         
         JButton btnNewButton_1 = new JButton("取消");
         btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
         btnNewButton_1.setBounds(217, 346, 97, 29);
         
         jf.getContentPane().add(btnNewButton_1);
         
         JLabel lblNewLabel_3_1 = new JLabel("\u9AD8\u7B49\u6570\u5B66");
         lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3_1.setBounds(25, 163, 76, 29);
         jf.getContentPane().add(lblNewLabel_3_1);
         
         c1 = new JTextField();
         c1.setColumns(10);
         c1.setBounds(94, 165, 66, 26);
         jf.getContentPane().add(c1);
         
         JLabel lblNewLabel_3_1_1 = new JLabel("\u79BB\u6563\u6570\u5B66");
         lblNewLabel_3_1_1.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3_1_1.setBounds(180, 163, 76, 29);
         jf.getContentPane().add(lblNewLabel_3_1_1);
         
         c2 = new JTextField();
         c2.setColumns(10);
         c2.setBounds(248, 165, 66, 26);
         jf.getContentPane().add(c2);
         
         JLabel lblNewLabel_3_1_2 = new JLabel("\u5927\u5B66\u7269\u7406");
         lblNewLabel_3_1_2.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3_1_2.setBounds(25, 214, 76, 29);
         jf.getContentPane().add(lblNewLabel_3_1_2);
         
         c3 = new JTextField();
         c3.setColumns(10);
         c3.setBounds(94, 216, 66, 26);
         jf.getContentPane().add(c3);
         
         JLabel lblNewLabel_3_1_3 = new JLabel("Java");
         lblNewLabel_3_1_3.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3_1_3.setBounds(190, 213, 76, 29);
         jf.getContentPane().add(lblNewLabel_3_1_3);
         
         c4 = new JTextField();
         c4.setColumns(10);
         c4.setBounds(248, 216, 66, 26);
         jf.getContentPane().add(c4);
         
         JLabel lblNewLabel_3_1_4 = new JLabel("python");
         lblNewLabel_3_1_4.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3_1_4.setBounds(36, 262, 76, 29);
         jf.getContentPane().add(lblNewLabel_3_1_4);
         
         c5 = new JTextField();
         c5.setColumns(10);
         c5.setBounds(94, 265, 66, 26);
         jf.getContentPane().add(c5);
         
         JLabel lblNewLabel_3_1_5 = new JLabel("c\u8BED\u8A00");
         lblNewLabel_3_1_5.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3_1_5.setBounds(190, 262, 76, 29);
         jf.getContentPane().add(lblNewLabel_3_1_5);
         
         c6 = new JTextField();
         c6.setColumns(10);
         c6.setBounds(248, 265, 66, 26);
         jf.getContentPane().add(c6);
         jf.setVisible( true );
 
	     btnNewButton.addActionListener(new ActionListener() {
	         	public void actionPerformed(ActionEvent e) {
	         		if(sno.getText()==""||sname.getText()==""||sdept.getText()=="") {
	         			JOptionPane.showMessageDialog(null,"添加失败，请填写完整信息");
	         		}else {
	         			dao.addscore(sno.getText(),sname.getText(),sdept.getText(),Integer.parseInt(c1.getText()),Integer.parseInt(c2.getText()),Integer.parseInt(c3.getText()),Integer.parseInt(c4.getText()),Integer.parseInt(c5.getText()),Integer.parseInt(c6.getText()));
	         			
	         			jf.dispose();
	         		}
	         	}
	         });
	    btnNewButton_1.addActionListener(new ActionListener() {
	         	public void actionPerformed(ActionEvent e) {
	         		jf.dispose();
	         	}
	         });	
		
	
	}
	public void selfaddcourse(String sno) {  
		JFrame jf =  new  JFrame("添加选课信息");
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setSize(400,500);
		Point p=new Point(550,180);
		jf.setLocation(p);
        jf.getContentPane().setLayout(null);
         
         JButton btnNewButton = new JButton("\u786E\u5B9A\u6DFB\u52A0");
         btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
         btnNewButton.setBounds(64, 346, 97, 29);
         jf.getContentPane().add(btnNewButton);
         
         JButton btnNewButton_1 = new JButton("取消");
         btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
         btnNewButton_1.setBounds(217, 346, 97, 29);
         
         jf.getContentPane().add(btnNewButton_1);
         
         JLabel lblNewLabel_3_1 = new JLabel("\u672A\u9009\u8BFE\u7A0B");
         lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 17));
         lblNewLabel_3_1.setBounds(76, 111, 76, 29);
         jf.getContentPane().add(lblNewLabel_3_1);
         
         List<Map> list =dao.getselfcourse(sno);
 		 Object[] head = {"已选课程"};
 		 Object[][] data=new Object[list.size()][head.length];
         for(int i=0;i<list.size();i++){
                 data[i][0]=list.get(i).get("course");
         }
         ArrayList<String> course=new ArrayList();
         Object[] c = {"高等数学","离散数学","大学物理","Java","python","c语言"};
         for(int i=0;i<c.length;i++){
        	 int flag=0;
             for(int j=0;j<list.size();j++) {
            	 if(data[j][0].equals(c[i])) {
            		flag=1;
            	 }
             }
             if(flag==0) {course.add(c[i].toString());}
         }
         String[] array = course.toArray(new String[course.size()]);
         JComboBox courses = new JComboBox(array);
         courses.setBounds(189, 115, 97, 25);
         jf.getContentPane().add(courses);
         jf.setVisible( true );
         
         List<Map> list1 =dao.studentscearch(sno,"","","");
		 Object[] head1 = {"学号","姓名","年龄","性别","专业"};
		 Object[][] data1=new Object[list1.size()][head1.length];

	     data1[0][0]=list1.get(0).get("sno");
	     data1[0][1]=list1.get(0).get("sname");
	     data1[0][2]=list1.get(0).get("sage");
	     data1[0][3]=list1.get(0).get("ssex");
	     data1[0][4]=list1.get(0).get("sdept");

   
 		
	     btnNewButton.addActionListener(new ActionListener() {
	         	public void actionPerformed(ActionEvent e) {
	         		if(JOptionPane.OK_OPTION==JOptionPane.showOptionDialog(null, "确认添加？", "友情提示", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{"确定","取消"}, null)){
	         			dao.addcourse(sno,data1[0][1].toString(),data1[0][4].toString(),courses.getSelectedItem().toString());
	         			jf.dispose();
					}else{
					}	
	         	}
	         });
	    btnNewButton_1.addActionListener(new ActionListener() {
	         	public void actionPerformed(ActionEvent e) {
	         		jf.dispose();
	         	}
	         });	
	 
	}

}
