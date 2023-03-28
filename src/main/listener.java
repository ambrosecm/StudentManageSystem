package main;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;

import java.awt.event.*;
import java.awt.*;

class loginlistener implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		String u=login.username.getText();
		String p=login.password.getText();
		String url = "jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
		String username = "root";
		String password = "root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,username,password);
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from logintable");
			int f=0;
			while(rs.next()) {
				if(u.equals(rs.getString("username"))&&p.equals(rs.getString("password"))&&(rs.getInt("id")==1)){
					JOptionPane.showMessageDialog(null,"登陆成功！");
					login.frame.dispose();
					new studentmain();
					f=1;
					break;
				}else if(u.equals(rs.getString("username"))&&p.equals(rs.getString("password"))){
					JOptionPane.showMessageDialog(null,"登陆成功！");
					login.frame.dispose();
					new selfinformation(u);
					f=1;
					break;
				}
				}
				if(f==0) {
					JOptionPane.showMessageDialog(null,"登陆失败！请检查您的账号密码是否输入正确");
				}
		} catch (Exception ee) {
			ee.printStackTrace();
			System.out.println("getConnection()错误");
		}	
	
	
}
}


