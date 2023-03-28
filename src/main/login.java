package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

public class login {

	private JFrame frame = new JFrame("登录");
	private Container c = frame.getContentPane();
	private JTextField username = new JTextField();
	private JPasswordField password = new JPasswordField();
	private JButton ok = new JButton("确定");
	private JButton cancel = new JButton("取消");
	public login(){
		frame.setLocation(550,300);
		frame.setSize(388,274);
		c.setLayout(new BorderLayout());
		initFrame();
		ok.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\login.png"));
		ok.setForeground(new Color(0, 0, 0));
		ok.setFont(new Font("黑体", Font.PLAIN, 13));
		ok.setBackground(new Color(255, 245, 238));
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ee) {
				String u=username.getText();
				String p=password.getText();
				String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
				String username = "root";
				String password = "";
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection(url,username,password);
					Statement stmt=conn.createStatement();
					ResultSet rs=stmt.executeQuery("select * from logintable");
					int f=0;
					while(rs.next()) {
						if(u.equals(rs.getString("username"))&&p.equals(rs.getString("password"))&&(rs.getInt("id")==1)){
							JOptionPane.showMessageDialog(null,"登陆成功！");
							frame.dispose();
							new studentmain();
							f=1;
							break;
						}else if(u.equals(rs.getString("username"))&&p.equals(rs.getString("password"))){
							JOptionPane.showMessageDialog(null,"登陆成功！");
							frame.dispose();
							new selfinformation(u);
							f=1;
							break;
						}
						}
						if(f==0) {
							JOptionPane.showMessageDialog(null,"登陆失败！请检查您的账号密码是否输入正确");
						}
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("getConnection()错误");
				}	
			}
		});
		cancel.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\clearIpt.png"));
		cancel.setForeground(new Color(0, 0, 0));
		cancel.setFont(new Font("黑体", Font.PLAIN, 13));
		cancel.setBackground(new Color(255, 245, 238));
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ee) {
				username.setText("");
				password.setText("");
			}
		});
		frame.setVisible(true);
	}

	private void initFrame() {
		
		//顶部
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(new Color(255, 240, 245));
		titlePanel.setLayout(new FlowLayout());
		JLabel label = new JLabel("学生成绩管理系统");
		label.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\console.png"));
		label.setFont(new Font("黑体", Font.PLAIN, 16));
		titlePanel.add(label);
		c.add(titlePanel,"North");
		
		//中部表单
		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(null);
		JLabel l1 = new JLabel("用户名:");
		l1.setFont(new Font("黑体", Font.PLAIN, 14));
		l1.setBounds(95, 43, 50, 20);
		JLabel l2 = new JLabel("密  码:");
		l2.setFont(new Font("黑体", Font.PLAIN, 14));
		l2.setBounds(95, 92, 50, 20);
		fieldPanel.add(l1);
		fieldPanel.add(l2);
		username.setBounds(155,43,120,20);
		password.setBounds(155,92,120,20);
		fieldPanel.add(username);
		fieldPanel.add(password);
		c.add(fieldPanel,"Center");
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\1ff26652f2e12fe76fc23380ade6e0ef.jpg"));
		lblNewLabel.setBounds(-28, 0, 402, 179);
		fieldPanel.add(lblNewLabel);
		
		//底部按钮
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(255, 240, 245));
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(ok);
		buttonPanel.add(cancel);
		c.add(buttonPanel,"South");
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args){
		new login();
	}
}