package main;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;

public class editpassword {
	private JFrame jf =  new  JFrame();
	private JPasswordField oldp;
	private JPasswordField newp1;
	private JPasswordField newp2;
	private JTextArea username;
	
	public editpassword() {
		initialize();
		jf.setTitle("\u4FEE\u6539\u5BC6\u7801");
		jf.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\\\Java\\\\javacode\\\\javafi\\image\\export.png"));
		jf.setVisible(true);
		
	}
	private void initialize() {
		jf.setSize(400,500);
		Point p=new Point(550,180);
		jf.setLocation(p);
		jf.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u539F\u5BC6\u7801");
		lblNewLabel.setFont(new Font("等线", Font.PLAIN, 17));
		lblNewLabel.setBounds(61, 150, 76, 23);
		jf.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u65B0\u5BC6\u7801");
		lblNewLabel_1.setFont(new Font("等线", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(61, 220, 76, 23);
		jf.getContentPane().add(lblNewLabel_1);
		
		oldp = new JPasswordField();
		oldp.setBounds(153, 150, 168, 26);
		jf.getContentPane().add(oldp);
		
		newp1 = new JPasswordField();
		newp1.setBounds(153, 220, 168, 26);
		jf.getContentPane().add(newp1);
		
		newp2 = new JPasswordField();
		newp2.setBounds(153, 290, 168, 26);
		jf.getContentPane().add(newp2);
		
		JLabel lblNewLabel_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("等线", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(61, 290, 82, 32);
		jf.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.setBackground(new Color(255, 245, 238));
		btnNewButton.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\login.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(newp1.getText().equals(newp2.getText())) {
					dao.editpassword(username.getText(),oldp.getText(),newp1.getText(),jf);
				}else {
					JOptionPane.showMessageDialog(null,"两次密码输入不同");
				}
			}
		});
		btnNewButton.setFont(new Font("等线", Font.PLAIN, 18));
		btnNewButton.setBounds(61, 375, 103, 32);
		jf.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.setBackground(new Color(255, 245, 238));
		btnNewButton_1.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\close.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
			}
		});
		btnNewButton_1.setFont(new Font("等线", Font.PLAIN, 18));
		btnNewButton_1.setBounds(218, 375, 103, 32);
		jf.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u7528\u6237\u540D");
		lblNewLabel_3.setFont(new Font("等线", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(61, 80, 67, 26);
		jf.getContentPane().add(lblNewLabel_3);
		
		username = new JTextArea();
		username.setBounds(153, 80, 168, 23);
		jf.getContentPane().add(username);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\\\Java\\\\javacode\\\\javafi\\image\\1ff26652f2e12fe76fc23380ade6e0ef.jpg"));
		lblNewLabel_4.setBounds(-28, 0, 414, 463);
		jf.getContentPane().add(lblNewLabel_4);
		
	}
}
