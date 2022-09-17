package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class DBConn {
	public DBConn() {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	
	public boolean checkUser(String uname,String upass) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/webpro","root","root");
			PreparedStatement ps = con.prepareStatement("select * from users where uname=? and upass=?");
			ps.setString(1, uname);
			ps.setString(2, upass);
			 ResultSet rs =  ps.executeQuery();
			 if(rs.next()) {
				 return true;
			 }else {
				 return false;
			 }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public int register(int uid,String uname,String upass,String city,String phone) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/webpro","root","root");
			PreparedStatement ps= con.prepareStatement("insert into users values(?,?,?,?,?,?)");
			ps.setInt(1,uid);
			ps.setString(2,uname);
			ps.setString(3, upass);
			ps.setString(4, city);
			ps.setString(5, phone);
			ps.setInt(6,0);
			
			int i = ps.executeUpdate();
			return i;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
		
		
	}
	
	public int checkFlag(String uname,String upass) {
		try {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/webpro","root","root");
		PreparedStatement ps = con.prepareStatement("select flag from users where uname=? and upass=?");
		ps.setString(1, uname);
		ps.setString(2, upass);
		 ResultSet rs =  ps.executeQuery();
		 if(rs.next()) {
			 int flag = rs.getInt(1);
		 System.out.println(flag +"from check flag");
		 	if(flag==0) {
		 		ps = con.prepareStatement("update users set flag=1 where uname=? and upass=?");
		 		ps.setString(1, uname);
		 		ps.setString(2, upass);
		 		int n = ps.executeUpdate();
		 		return 1;
		 		
		 	}
		 	if(flag==1) {
		 		return 2;
		 		
		 	}
		 }
		 
		 
		}catch(Exception e) {
			e.printStackTrace();
		}
		 
		return 0;
	}
	
	public boolean resetFlag(String uname,String upass) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/webpro","root","root");
			PreparedStatement ps = con.prepareStatement("select flag from users where uname=? and upass=?");
			ps.setString(1,uname);
			ps.setString(2, upass);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int rflag = rs.getInt(1);
				if(rflag==1) {
					ps = con.prepareStatement("update users set flag=0 where uname=? and upass=?");
					ps.setString(1,uname);
					ps.setString(2, upass);
					int lognum =ps.executeUpdate();
					System.out.println(lognum+"from reset..");
					return true;
				}
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		DBConn dbcon = new DBConn();
		//int n = dbcon.register(2,"ram","spider","mumbai", "9087484586");
		//System.out.println(n+" users are added..");
		//System.out.println(dbcon.checkUser("ram","spider"));
		//System.out.println(dbcon.resetFlag(1));
		
		
	}
}
