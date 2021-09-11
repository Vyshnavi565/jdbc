package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignUp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");	
		Connection con = null;		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample","CHALASANI","YshnaV@23");
		
		if(con!=null) {
			System.out.println("Connection Established");
		}
		else {
			System.out.println("Connection not Established");
		}
		PreparedStatement ps = con.prepareStatement("insert into sample.SIGNUP values(?,?,?,?,?)");
		ps.setInt(1, 1);
		ps.setString(2,"VYSHNAVI");
		ps.setString(3, "CHALASANI");
		ps.setInt(4, 22);
		ps.setString(5,"NELLORE");
		ps.execute();
		
		ResultSet rs = ps.executeQuery("select * from sample.SIGNUP");
		while(rs.next()) {
			int id=rs.getInt("ID");
			String firstname=rs.getString("FIRSTNAME");
			String lastname=rs.getString("LASTNAME");
			int age=rs.getInt("AGE");
			String address=rs.getString("CITY");			
			System.out.println("ID: "+id+" Name: "+firstname+" "+lastname+" Age: "+age+" Address: "+address);	
		}
//		ResultSet rs = ps.executeQuery("select * from sample.SAMPLE");
//		while(rs.next()) {
//			int id=rs.getInt("ID");
//			String name=rs.getString("FIRSTNAME");
//			int age=rs.getInt("AGE");
//			String city=rs.getString("CITY");			
//			System.out.println("ID: "+id+" FirstName: "+name+" Age: "+age+" City: "+city);	
//		}
		
		//con.close();

	}

}
