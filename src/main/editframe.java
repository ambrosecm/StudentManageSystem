package main;

import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class editframe {
	/**
	 * @wbp.parser.entryPoint
	 */
	public void editstudent(String oldsno,String oldsname,Integer oldsage,String oldssex,String oldsdept) {   
		JFrame jf =  new  JFrame("修改学生信息");
		jf.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\\\Java\\\\javacode\\\\javafi\\image\\add.png"));
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
         sno = new JTextField(oldsno);
         sno.setFont(new Font("等线", Font.PLAIN, 16));
         sno.setBounds(155, 50, 150, 25);
         jf.getContentPane().add(sno);
         sno.setColumns(10);
         
         JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
         lblNewLabel_1.setFont(new Font("等线", Font.PLAIN, 17));
         lblNewLabel_1.setBounds(75, 110, 67, 26);
         jf.getContentPane().add(lblNewLabel_1);
         sname = new JTextField(oldsname);
         sname.setFont(new Font("等线", Font.PLAIN, 16));
         sname.setColumns(10);
         sname.setBounds(155, 110, 150, 25);
         jf.getContentPane().add(sname);
         
         JLabel lblNewLabel_2 = new JLabel("\u5E74\u9F84");
         lblNewLabel_2.setFont(new Font("等线", Font.PLAIN, 17));
         lblNewLabel_2.setBounds(75, 170, 150, 26);
         jf.getContentPane().add(lblNewLabel_2);
         sage = new JTextField((oldsage+""));
         sage.setFont(new Font("等线", Font.PLAIN, 16));
         sage.setColumns(10);
         sage.setBounds(155, 172, 150, 25);
         jf.getContentPane().add(sage);
         
         JLabel lblNewLabel_3 = new JLabel("\u4E13\u4E1A");
         lblNewLabel_3.setFont(new Font("等线", Font.PLAIN, 17));
         lblNewLabel_3.setBounds(75, 290, 67, 26);
         jf.getContentPane().add(lblNewLabel_3);
         sdept = new JTextField(oldsdept);
         sdept.setFont(new Font("等线", Font.PLAIN, 16));
         sdept.setColumns(10);
         sdept.setBounds(155, 290, 150, 23);
         jf.getContentPane().add(sdept);
         
         JComboBox sexbox = new JComboBox();
         sexbox.setFont(new Font("等线", Font.PLAIN, 16));
         sexbox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
         if(oldssex.equals("男")) { sexbox.setSelectedIndex(0);}else { sexbox.setSelectedIndex(1);}
         sexbox.setBounds(155, 226, 53, 30);
         jf.getContentPane().add(sexbox);
         
         JLabel lblNewLabel_3_1 = new JLabel("\u6027\u522B");
         lblNewLabel_3_1.setFont(new Font("等线", Font.PLAIN, 17));
         lblNewLabel_3_1.setBounds(75, 230, 67, 26);
         jf.getContentPane().add(lblNewLabel_3_1);
         
         JButton btnNewButton = new JButton("确定");
         btnNewButton.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\import.png"));
         btnNewButton.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         	}
         });
         btnNewButton.setFont(new Font("等线", Font.PLAIN, 18));
         btnNewButton.setBounds(75, 370, 97, 29);
         jf.getContentPane().add(btnNewButton);
         
         JButton btnNewButton_1 = new JButton("取消");
         btnNewButton_1.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\close.png"));
         btnNewButton_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         	}
         });
         btnNewButton_1.setFont(new Font("等线", Font.PLAIN, 18));
         btnNewButton_1.setBounds(208, 370, 97, 29);
         jf.getContentPane().add(btnNewButton_1);
         
         JLabel lblNewLabel_4 = new JLabel("New label");
         lblNewLabel_4.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\1ff26652f2e12fe76fc23380ade6e0ef.jpg"));
         lblNewLabel_4.setBounds(-11, 0, 413, 463);
         jf.getContentPane().add(lblNewLabel_4);
         jf.setVisible( true );
 
         btnNewButton.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		if(sno.getText()==""||sname.getText()==""||(sage+"")==""||sexbox.getSelectedItem().toString()==""||sdept.getText()=="") {
         			JOptionPane.showMessageDialog(null,"修改失败，请填写完整信息");
         		}else {
         			dao.editstudent(sno.getText(),sname.getText(),sage.getText(),sexbox.getSelectedItem().toString(),sdept.getText(),oldsno);
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
	public  void editcourse(String oldsno,String oldsname,String oldsdept,String oldcourse) {
		JFrame jf =  new  JFrame("修改学生选课信息");
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
         
         sno = new JTextField(oldsno);
         sno.setBounds(180, 63, 147, 23);
         jf.getContentPane().add(sno);
         sno.setColumns(10);
         
         JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
         lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_1.setBounds(84, 117, 76, 29);
         jf.getContentPane().add(lblNewLabel_1);
         
         sname = new JTextField(oldsname);
         sname.setColumns(10);
         sname.setBounds(180, 120, 147, 23);
         jf.getContentPane().add(sname);
         
         JLabel lblNewLabel_3 = new JLabel("\u4E13\u4E1A");
         lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3.setBounds(84, 178, 76, 29);
         jf.getContentPane().add(lblNewLabel_3);
         
         sdept = new JTextField(oldsdept);
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
         
         course = new JTextField(oldcourse);
         course.setColumns(10);
         course.setBounds(180, 244, 147, 23);
         jf.getContentPane().add(course);
         jf.setVisible( true );
 
	     btnNewButton.addActionListener(new ActionListener() {
	         	public void actionPerformed(ActionEvent e) {
	         		if(sno.getText()==""||sname.getText()==""||sdept.getText()==""||course.getText()=="") {
	         			JOptionPane.showMessageDialog(null,"修改失败，请填写完整信息");
	         		}else {
	         			dao.editcourse(sno.getText(),sname.getText(),sdept.getText(),course.getText(),oldsno,oldcourse);
	         			
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
	public  void editscore(String oldsno,String oldsname,String oldsdept,Integer oldc1,Integer oldc2,Integer oldc3,Integer oldc4,Integer oldc5,Integer oldc6) {
		JFrame jf =  new  JFrame("修改学生成绩信息");
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
         
         sno = new JTextField(oldsno);
         sno.setBounds(180, 33, 147, 23);
         jf.getContentPane().add(sno);
         sno.setColumns(10);
         
         JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
         lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_1.setBounds(84, 69, 76, 29);
         jf.getContentPane().add(lblNewLabel_1);
         
         sname = new JTextField(oldsname);
         sname.setColumns(10);
         sname.setBounds(180, 72, 147, 23);
         jf.getContentPane().add(sname);
         
         JLabel lblNewLabel_3 = new JLabel("\u4E13\u4E1A");
         lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3.setBounds(84, 108, 76, 29);
         jf.getContentPane().add(lblNewLabel_3);
         
         sdept = new JTextField(oldsdept);
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
         
         c1 = new JTextField(oldc1+"");
         c1.setColumns(10);
         c1.setBounds(94, 165, 66, 26);
         jf.getContentPane().add(c1);
         
         JLabel lblNewLabel_3_1_1 = new JLabel("\u79BB\u6563\u6570\u5B66");
         lblNewLabel_3_1_1.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3_1_1.setBounds(180, 163, 76, 29);
         jf.getContentPane().add(lblNewLabel_3_1_1);
         
         c2 = new JTextField(oldc2+"");
         c2.setColumns(10);
         c2.setBounds(248, 165, 66, 26);
         jf.getContentPane().add(c2);
         
         JLabel lblNewLabel_3_1_2 = new JLabel("\u5927\u5B66\u7269\u7406");
         lblNewLabel_3_1_2.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3_1_2.setBounds(25, 214, 76, 29);
         jf.getContentPane().add(lblNewLabel_3_1_2);
         
         c3 = new JTextField(oldc3+"");
         c3.setColumns(10);
         c3.setBounds(94, 216, 66, 26);
         jf.getContentPane().add(c3);
         
         JLabel lblNewLabel_3_1_3 = new JLabel("Java");
         lblNewLabel_3_1_3.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3_1_3.setBounds(190, 213, 76, 29);
         jf.getContentPane().add(lblNewLabel_3_1_3);
         
         c4 = new JTextField(oldc4+"");
         c4.setColumns(10);
         c4.setBounds(248, 216, 66, 26);
         jf.getContentPane().add(c4);
         
         JLabel lblNewLabel_3_1_4 = new JLabel("python");
         lblNewLabel_3_1_4.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3_1_4.setBounds(36, 262, 76, 29);
         jf.getContentPane().add(lblNewLabel_3_1_4);
         
         c5 = new JTextField(oldc5+"");
         c5.setColumns(10);
         c5.setBounds(94, 265, 66, 26);
         jf.getContentPane().add(c5);
         
         JLabel lblNewLabel_3_1_5 = new JLabel("c\u8BED\u8A00");
         lblNewLabel_3_1_5.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3_1_5.setBounds(190, 262, 76, 29);
         jf.getContentPane().add(lblNewLabel_3_1_5);
         
         c6 = new JTextField(oldc6+"");
         c6.setColumns(10);
         c6.setBounds(248, 265, 66, 26);
         jf.getContentPane().add(c6);
         jf.setVisible( true );
 
	     btnNewButton.addActionListener(new ActionListener() {
	         	public void actionPerformed(ActionEvent e) {
	         		if(sno.getText()==""||sname.getText()==""||sdept.getText()=="") {
	         			JOptionPane.showMessageDialog(null,"修改失败，请填写完整信息");
	         		}else {
	         			dao.editscore(sno.getText(),sname.getText(),sdept.getText(),Integer.parseInt(c1.getText()),Integer.parseInt(c2.getText()),Integer.parseInt(c3.getText()),Integer.parseInt(c4.getText()),Integer.parseInt(c5.getText()),Integer.parseInt(c6.getText()),oldsno);
	         			
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
	public  void selfeditstudent(String oldsno,String oldsname,Integer oldsage,String oldssex,String oldsdept) {   
		JFrame jf =  new  JFrame("修改学生信息");
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setSize(400,500);
		Point p=new Point(550,180);
		jf.setLocation(p);
		JTextField sname;
		JTextField sage;
		JTextField sdept;  
        jf.getContentPane().setLayout(null);
         JLabel lblNewLabel = new JLabel("\u5B66\u53F7");
         lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel.setBounds(84, 60, 76, 29);
         jf.getContentPane().add(lblNewLabel);
         
         JLabel lblNewLabel_1 = new JLabel("\u59D3\u540D");
         lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_1.setBounds(84, 117, 76, 29);
         jf.getContentPane().add(lblNewLabel_1);
         sname = new JTextField(oldsname);
         sname.setColumns(10);
         sname.setBounds(180, 120, 147, 23);
         jf.getContentPane().add(sname);
         
         JLabel lblNewLabel_2 = new JLabel("\u5E74\u9F84");
         lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_2.setBounds(84, 169, 76, 29);
         jf.getContentPane().add(lblNewLabel_2);
         sage = new JTextField((oldsage+""));
         sage.setColumns(10);
         sage.setBounds(180, 172, 147, 23);
         jf.getContentPane().add(sage);
         
         JLabel lblNewLabel_3 = new JLabel("\u4E13\u4E1A");
         lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3.setBounds(84, 279, 76, 29);
         jf.getContentPane().add(lblNewLabel_3);
         sdept = new JTextField(oldsdept);
         sdept.setColumns(10);
         sdept.setBounds(180, 282, 147, 23);
         jf.getContentPane().add(sdept);
         
         JComboBox sexbox = new JComboBox();
         sexbox.setFont(new Font("宋体", Font.PLAIN, 16));
         sexbox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
         if(oldssex.equals("男")) { sexbox.setSelectedIndex(0);}else { sexbox.setSelectedIndex(1);}
         sexbox.setBounds(187, 221, 53, 33);
         jf.getContentPane().add(sexbox);
         
         JLabel lblNewLabel_3_1 = new JLabel("\u6027\u522B");
         lblNewLabel_3_1.setFont(new Font("宋体", Font.PLAIN, 15));
         lblNewLabel_3_1.setBounds(84, 224, 76, 29);
         jf.getContentPane().add(lblNewLabel_3_1);
         
         JButton btnNewButton = new JButton("确定");
         btnNewButton.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         	}
         });
         btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
         btnNewButton.setBounds(64, 346, 97, 29);
         jf.getContentPane().add(btnNewButton);
         
         JButton btnNewButton_1 = new JButton("取消");
         btnNewButton_1.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		
         	}
         });
         btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
         btnNewButton_1.setBounds(217, 346, 97, 29);
         jf.getContentPane().add(btnNewButton_1);
         
         JLabel sno = new JLabel(oldsno);
         sno.setFont(new Font("宋体", Font.PLAIN, 15));
         sno.setBounds(180, 60, 147, 29);
         jf.getContentPane().add(sno);
         jf.setVisible( true );
 
         btnNewButton.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
         		if(sno.getText()==""||sname.getText()==""||(sage+"")==""||sexbox.getSelectedItem().toString()==""||sdept.getText()=="") {
         			JOptionPane.showMessageDialog(null,"修改失败，请填写完整信息");
         		}else {
         			dao.editstudent(oldsno,sname.getText(),sage.getText(),sexbox.getSelectedItem().toString(),sdept.getText(),oldsno);
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

}
