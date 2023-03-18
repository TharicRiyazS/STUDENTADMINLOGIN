package studentlogin;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.Date;
	import java.util.Scanner;
	public class stlogin  {
		private Connection con;
		public stlogin  () {
			//connectivity
		try {
			String dburl="jdbc:mysql://localhost:3306/javademodb";
			String dbusr="root";
			String dbpass="";
					
			con=DriverManager.getConnection(dburl,dbusr,dbpass);
		}catch(SQLException e) {
			System.out.println("error :" + e);
		}
		}
		//login check for admin
		public boolean login(String u,String p) {
			boolean r=false;
			try {
				String query="select * from adlog where username='"+u+"' and password='"+p+"'";
				Statement smt=con.createStatement();
				ResultSet rs=smt.executeQuery(query);
				while(rs.next()) {
					r=true;
				}
			}catch(SQLException e) {
				System.out.println("error :" +e);
			}
			return r;
		}
		//login check for students
			public boolean logins(int p,String u) {
				boolean r=false;
				try {
					String query="select * from stlog where sregno='"+p+"' and sname='"+u+"'";
					Statement smt=con.createStatement();
					ResultSet rs=smt.executeQuery(query);
					while(rs.next()) {
						r=true;
					}
				}catch(SQLException e) {
					System.out.println("error :" +e);
				}
				return r;
			}
		
		//insertion for studentss
			public int insertion(int regno,String name,String dob,String gen,String cse,int fees) {
				int c=0;
				try {
				String query="insert into studentss values(?,?,?,?,?,?)";
				PreparedStatement pst=con.prepareStatement(query);
				pst.setInt(1,regno);
				pst.setString(2,name);
				pst.setString(3,dob);
				pst.setString(4,gen);
				pst.setString(5,cse);
				pst.setInt(6,fees);
				c=pst.executeUpdate();
				}catch(SQLException e) {
					System.out.println("error :" +e);
				}
				return c;
			}
		//selection for admin
		public void select() {
			try {
			String query="select * from studentss";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+"\t"+
				rs.getString(2)+"\t"+
				rs.getString(3)+"\t"+
				rs.getString(4)+"\t"+
				rs.getString(5)+"\t"+
				rs.getInt(6)+"\t");
			}
		}catch(SQLException e) {
			System.out.println("error :" +e);
		}
		}
		//selection for students
		public int selection(int regno) {
			int c=0;
			try {
			String query="select * from studentss where sregno=?";
			PreparedStatement pst=con.prepareStatement(query);
			pst.setInt(1,regno);
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				System.out.println("sregno"+"\t"+
						"name"+"\t"+
						"sdob"+"\t"+
						"sgender"+"\t"+
						"scourse"+"\t"+
						"sfees"+"\t");
					
				System.out.println(rs.getInt(1)+"\t"+
				rs.getString(2)+"\t"+
				rs.getString(3)+"\t"+
				rs.getString(4)+"\t"+
				rs.getString(5)+"\t"+
				rs.getInt(6)+"\t");
			}
		}catch(SQLException e) {
			System.out.println("error :" +e);
		}
			return c;
		}
		
		//updation
		public int update(String sname,int regno) {
			int c=0;
			try {
				String query="update studentss set sname=? where sregno=?";
				PreparedStatement pst=con.prepareStatement(query);
				
				
				pst.setString(1,sname);
				pst.setInt(2,regno);
				c=pst.executeUpdate();
				
			}catch(SQLException e) {
				System.out.println("error :" +e);
			}
		
			return c;
		}
		
			// deletion
			
			public int delete(int regno) {
				int c=0;
				try {
					String query="delete from studentss where sregno=?";
					PreparedStatement pst=con.prepareStatement(query);
					pst.setInt(1,regno);
					c=pst.executeUpdate();
				}catch(SQLException e) {
					System.out.println("error :" +e);
				}
			
				return c;
			}
			
			
			
	}

			
			
		
			
			
			
			
			
			
			
			
			
		
		
		




