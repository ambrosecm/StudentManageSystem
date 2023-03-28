package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

class dao {
	static String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8";
	static String username = "root";
	static String password = "";
	static List<Map> getstudent() {
		Connection conn = null;
		PreparedStatement ps = null;
		List<Map> list =new ArrayList<Map>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "select * from students";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				Integer sage= rs.getInt("sage");
				String ssex = rs.getString("ssex");
				String sdept = rs.getString("sdept");
				Map map = new HashMap(); 	
				map.put("sno", sno);
				map.put("sname", sname);			
				map.put("sage",sage);		
				map.put("ssex", ssex);
				map.put("sdept",sdept);
				list.add(map);	
			}
			} catch (Exception ee) {
				ee.printStackTrace();
				System.out.println("连接数据库失败");
			}finally {
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return list;
	
	}
	static List<Map> getcourse(){
		Connection conn = null;
		PreparedStatement ps = null;
		List<Map> list =new ArrayList<Map>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "select * from studentcourse";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String sdept = rs.getString("sdept");
				String course = rs.getString("course");
				Map map = new HashMap(); 	
				map.put("sno", sno);
				map.put("sname", sname);			
				map.put("sdept",sdept);
				map.put("course",course);
				list.add(map);	
			}
			} catch (Exception ee) {
				ee.printStackTrace();
				System.out.println("连接数据库失败");
			}finally {
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return list;
	}
	static List<Map> getscore(){
		Connection conn = null;
		PreparedStatement ps = null;
		List<Map> list =new ArrayList<Map>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "select * from studentgrade";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String sdept = rs.getString("sdept");
				Integer c1= rs.getInt("高等数学");
				Integer c2= rs.getInt("离散数学");
				Integer c3= rs.getInt("大学物理");
				Integer c4= rs.getInt("Java");
				Integer c5= rs.getInt("python");
				Integer c6= rs.getInt("c语言");
				Map map = new HashMap(); 
					map.put("sno", sno);
					map.put("sname", sname);			
					map.put("sdept",sdept);
					map.put("c1",c1);		
					map.put("c2", c2);
					map.put("c3",c3);		
					map.put("c4", c4);
					map.put("c5",c5);		
					map.put("c6", c6);
					list.add(map);
			}
			} catch (Exception ee) {
				ee.printStackTrace();
				System.out.println("连接数据库失败");
			}finally {
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return list;
	
	}
	static List<Map> studentscearch(String sno1,String sname1,String sdept1,String ssex2){
		String ssex1;
		if(ssex2.equals("请输入")) {ssex1=new String("");}else {ssex1=new String(ssex2);}
		Connection conn = null;
		PreparedStatement ps = null;
		List<Map> list =new ArrayList<Map>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "select * from students where sno LIKE '%"+sno1+"%' and sname LIKE '%"+sname1+"%' and ssex LIKE '%"+ssex1+"%' and sdept LIKE '%"+sdept1+"%'";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				Integer sage= rs.getInt("sage");
				String ssex = rs.getString("ssex");
				String sdept = rs.getString("sdept");
				Map map = new HashMap(); 	
				map.put("sno", sno);
				map.put("sname", sname);			
				map.put("sage",sage);		
				map.put("ssex", ssex);
				map.put("sdept",sdept);
				list.add(map);	
			}
			} catch (Exception ee) {
				ee.printStackTrace();
				System.out.println("连接数据库失败");
			}finally {
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		return list;
	}
	
	static List<Map> coursescearch(String sno1,String sname1,String sdept1,String course1){
		Connection conn = null;
		PreparedStatement ps = null;
		List<Map> list =new ArrayList<Map>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "select * from studentcourse where sno LIKE '%"+sno1+"%' and sname LIKE '%"+sname1+"%' and sdept LIKE '%"+sdept1+"%' and course like '%"+course1+"%' ";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String sdept = rs.getString("sdept");
				String course = rs.getString("course");
				Map map = new HashMap(); 	
				map.put("sno", sno);
				map.put("sname", sname);			
				map.put("sdept",sdept);
				map.put("course",course);
				list.add(map);	
			}
			} catch (Exception ee) {
				ee.printStackTrace();
				System.out.println("连接数据库失败");
			}finally {
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return list;
	}
	static List<Map> scoresearch(String sno1,String sname1,String sdept1,String course1){
		Connection conn = null;
		PreparedStatement ps = null;
		List<Map> list =new ArrayList<Map>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "select * from studentgrade where sno LIKE '%"+sno1+"%' and sname LIKE '%"+sname1+"%'  and sdept LIKE '%"+sdept1+"%'";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String sdept = rs.getString("sdept");
				Integer c1= rs.getInt("高等数学");
				Integer c2= rs.getInt("离散数学");
				Integer c3= rs.getInt("大学物理");
				Integer c4= rs.getInt("Java");
				Integer c5= rs.getInt("python");
				Integer c6= rs.getInt("c语言");
				Map map = new HashMap(); 
				if(course1.equals("")) {
					map.put("sno", sno);
					map.put("sname", sname);			
					map.put("sdept",sdept);
					map.put("c1",c1);		
					map.put("c2", c2);
					map.put("c3",c3);		
					map.put("c4", c4);
					map.put("c5",c5);		
					map.put("c6", c6);
					list.add(map);
				}else if(course1.indexOf("高等数学")>=0) {
					if((c1+"")=="") {}else {
					map.put("sno", sno);
					map.put("sname", sname);			
					map.put("sdept",sdept);
					map.put("c1",c1);		
					map.put("c2", c2);
					map.put("c3",c3);		
					map.put("c4", c4);
					map.put("c5",c5);		
					map.put("c6", c6);
					list.add(map);
					}
				
				}else if(course1.indexOf("离散数学")>=0) {
					if((c2+"")=="") {}else {
						map.put("sno", sno);
						map.put("sname", sname);			
						map.put("sdept",sdept);
						map.put("c1",c1);		
						map.put("c2", c2);
						map.put("c3",c3);		
						map.put("c4", c4);
						map.put("c5",c5);		
						map.put("c6", c6);
						list.add(map);
						}
					
				}else if(course1.indexOf("大学物理")>=0) {
					if((c3+"")=="") {}else {
						map.put("sno", sno);
						map.put("sname", sname);			
						map.put("sdept",sdept);
						map.put("c1",c1);		
						map.put("c2", c2);
						map.put("c3",c3);		
						map.put("c4", c4);
						map.put("c5",c5);		
						map.put("c6", c6);
						list.add(map);
						}
						
				}else if(course1.indexOf("java")>=0) {
					if((c4+"")=="") {}else {
						map.put("sno", sno);
						map.put("sname", sname);			
						map.put("sdept",sdept);
						map.put("c1",c1);		
						map.put("c2", c2);
						map.put("c3",c3);		
						map.put("c4", c4);
						map.put("c5",c5);		
						map.put("c6", c6);
						list.add(map);
						}
						
				}else if(course1.indexOf("python")>=0) {
					if((c5+"")=="") {}else {
						map.put("sno", sno);
						map.put("sname", sname);			
						map.put("sdept",sdept);
						map.put("c1",c1);		
						map.put("c2", c2);
						map.put("c3",c3);		
						map.put("c4", c4);
						map.put("c5",c5);		
						map.put("c6", c6);
						list.add(map);
						}
						
				}else if(course1.indexOf("c语言")>=0) {
					if((c6+"")=="") {}else {
						map.put("sno", sno);
						map.put("sname", sname);			
						map.put("sdept",sdept);
						map.put("c1",c1);		
						map.put("c2", c2);
						map.put("c3",c3);		
						map.put("c4", c4);
						map.put("c5",c5);		
						map.put("c6", c6);
						list.add(map);
					}
				}
			}
			} catch (Exception ee) {
				ee.printStackTrace();
				System.out.println("连接数据库失败");
			}finally {
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return list;
	}
	static void addstudent(String sno,String sname,String sage1,String ssex,String sdept) {
		int sage=Integer.parseInt(sage1);
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "INSERT INTO students (sno,sname,sage,ssex,sdept) VALUES(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setString(2, sname);
			ps.setInt(3, sage);
			ps.setString(4, ssex);
			ps.setString(5, sdept);
			ps.executeUpdate();
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("getConnection()错误");
			}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
		JOptionPane.showMessageDialog(null,"添加成功！");
	
	}
	static void editstudent(String sno,String sname,String sage1,String ssex,String sdept,String oldsno) {
		int sage=Integer.parseInt(sage1);
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "UPDATE students SET sno=?, sname=?, sage=?, ssex=?,sdept=? where sno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setString(2, sname);
			ps.setInt(3, sage);
			ps.setString(4, ssex);
			ps.setString(5, sdept);
			ps.setString(6, oldsno);
			ps.executeUpdate();
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("getConnection()错误");
			}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		JOptionPane.showMessageDialog(null,"修改成功！");
		
	}
	static void deletestudent(String sno) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "DELETE FROM students WHERE sno =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		JOptionPane.showMessageDialog(null,"删除成功");
	
	}
	static void addcourse(String sno,String sname,String sdept,String course) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "INSERT INTO studentcourse (sno,sname,sdept,course) VALUES(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setString(2, sname);
			ps.setString(3, sdept);
			ps.setString(4, course);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getConnection()错误");
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}	
	}
	static void editcourse(String sno,String sname,String sdept,String course,String oldsno,String oldcourse) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "UPDATE studentcourse SET sno=?, sname=?,sdept=?,course=? where sno=? and course=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setString(2, sname);
			ps.setString(3, sdept);	
			ps.setString(4, course);
			ps.setString(5,oldsno);
			ps.setString(6,oldcourse);	
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}
	static void deletecourse(String sno,String course) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "DELETE FROM studentcourse WHERE sno =? and course=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setString(2, course);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
	}
	static void addscore(String sno,String sname,String sdept,int c1,int c2,int c3,int c4,int c5,int c6) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "INSERT INTO studentgrade (sno,sname,sdept,高等数学,离散数学,大学物理,Java,python,c语言) VALUES(?,?,?,?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setString(2, sname);
			ps.setString(3, sdept);
			ps.setInt(4, c1);
			ps.setInt(5, c2);
			ps.setInt(6, c3);
			ps.setInt(7, c4);
			ps.setInt(8, c5);
			ps.setInt(9, c6);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("getConnection()错误");
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	static void editscore(String sno,String sname,String sdept,int c1,int c2,int c3,int c4,int c5,int c6,String oldsno) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "UPDATE studentgrade SET sno=?, sname=?,sdept=?,高等数学=?,离散数学=?,大学物理=?,Java=?,python=?,c语言=? where sno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			ps.setString(2, sname);
			ps.setString(3, sdept);	
			ps.setInt(4, c1);
			ps.setInt(5, c2);
			ps.setInt(6, c3);
			ps.setInt(7, c4);
			ps.setInt(8, c5);
			ps.setInt(9, c6);
			ps.setString(10, oldsno);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	static void deletescore(String sno) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "DELETE FROM studentgrade WHERE sno =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sno);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	
	}
	static void editpassword(String username,String oldp,String newp,JFrame jf) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "UPDATE logintable SET password=? where username=?";
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from logintable where username="+username);
			
			if(rs.next()) {
					if(rs.getString("password").equals(oldp)) {
						ps = conn.prepareStatement(sql);
						ps.setString(1, newp);
						ps.setString(2, username);
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null,"密码修改成功！");
						jf.dispose();
					}else {
					JOptionPane.showMessageDialog(null,"原密码输入错误！");
					}
			}else {
			JOptionPane.showMessageDialog(null,"该用户不存在！");
		}
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	static List<Map> studentinformation(String u) {
		Connection conn = null;
		PreparedStatement ps = null;
		List<Map> list =new ArrayList<Map>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "select * from students where sno="+u;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				Integer sage= rs.getInt("sage");
				String ssex = rs.getString("ssex");
				String sdept = rs.getString("sdept");
				Map map = new HashMap(); 	
				map.put("sno", sno);
				map.put("sname", sname);			
				map.put("sage",sage);		
				map.put("ssex", ssex);
				map.put("sdept",sdept);
				list.add(map);	
			}
			} catch (Exception ee) {
				ee.printStackTrace();
				System.out.println("连接数据库失败");
			}finally {
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return list;
	
	}
	static List<Map> getselfscore(String u){
		Connection conn = null;
		PreparedStatement ps = null;
		List<Map> list =new ArrayList<Map>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "select * from studentgrade where sno="+u;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String sdept = rs.getString("sdept");
				Integer c1= rs.getInt("高等数学");
				Integer c2= rs.getInt("离散数学");
				Integer c3= rs.getInt("大学物理");
				Integer c4= rs.getInt("Java");
				Integer c5= rs.getInt("python");
				Integer c6= rs.getInt("c语言");
				Map map = new HashMap(); 
					map.put("sno", sno);
					map.put("sname", sname);			
					map.put("sdept",sdept);
					map.put("c1",c1);		
					map.put("c2", c2);
					map.put("c3",c3);		
					map.put("c4", c4);
					map.put("c5",c5);		
					map.put("c6", c6);
					list.add(map);
			}
			} catch (Exception ee) {
				ee.printStackTrace();
				System.out.println("连接数据库失败");
			}finally {
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return list;
	
	}
	static List<Map> getselfcourse(String u){
		Connection conn = null;
		PreparedStatement ps = null;
		List<Map> list =new ArrayList<Map>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,username,password);
			String sql = "select * from studentcourse where sno ="+u;
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				String sdept = rs.getString("sdept");
				String course = rs.getString("course");
				Map map = new HashMap(); 	
				map.put("sno", sno);
				map.put("sname", sname);			
				map.put("sdept",sdept);
				map.put("course",course);
				list.add(map);	
			}
			} catch (Exception ee) {
				ee.printStackTrace();
				System.out.println("连接数据库失败");
			}finally {
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(conn != null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return list;
	}
	
		
	
	
}
