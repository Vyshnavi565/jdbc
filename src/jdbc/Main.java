package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		// 1. load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");		
		// 2. establish connection
		Connection con = null;		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Sample","CHALASANI","YshnaV@23");		
		// 3. creating statements(statement- general purpose(execute(),executeQuery(),executeUpdate(); preparedStatemnt- input parameters(execute(),executeQuery(),executeUpdate()); callable statements- stored procedures(execute(),executeQuery(),executeUpdate() )
		//execute()- DDL(create, alter or drop)
		//executeUpdate()-DML(insert,update,delete)
		//executeQuery()-select
//		PreparedStatement ps = con.prepareStatement("insert into sample.Student values(?,?,?,?)");
//		ps.setInt(1,10);
//		ps.setString(2,"test");
//		ps.setInt(3,56);
//		ps.setString(4,"TN");
//		ps.executeUpdate();
		PreparedStatement ps=con.prepareStatement("update Sample.Student set name=? where id=?");
		ps.setString(1, "name");
		ps.setInt(2,  11);
		ps.executeUpdate();
		
		// 4. resultset
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from sample.Student");
		while(rs.next()) {
			int id=rs.getInt("ID");
			String name=rs.getString("NAME");
			int age=rs.getInt("AGE");
			String address=rs.getString("ADDRESS");			
			System.out.println("ID: "+id+" Name: "+name+" Age: "+age+" Address: "+address);	
		}
		// 5. closing the connection 
		con.close();	
		/*if(con!=null) {
			System.out.println("Connection Established");
		}
		else {
			System.out.println("Connection not Established");
		}*/
	}
}
// SIGNUP ID INT, FIRSTNAME VARCHAR(20), LASTNAME(20), AGE INT, CITY VARCHAR(20)
// INSERT 1 RECORD
// DISPLAY IT IN OUTPUT 
// UPDATE THAT RECORD
// DISPLAY IT
