import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mypojos.Department;

public class DeptDAOTest3 {
	public static void main(String[] args) {


		try {
			//1st step
			System.out.println("Registering Driver ....");
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			System.out.println("Driver registered....");
			
			//2nd step
			System.out.println("Trying to connect...");
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-EPTT35F:1521:xe","scott","tiger");
			System.out.println("Connected to the DB..."+conn);
			
			//3rd step is what ???
			Statement st = conn.createStatement();
			
			System.out.println("Statement created.."+st);
			
			//CRUD
			ResultSet rs = st.executeQuery("select deptno,dname,loc from dept");
			
			System.out.println("Got the result : "+rs);
			
			while(rs.next()) //now rs is pointing to dept
			{
				Department deptRef = new Department();//blank object
				
				int tempDeptno = rs.getInt(1); //extract column value 
				String tempDname = rs.getString(2); //extract column  value
				String tempLoc = rs.getString(3); //extract column value
				
				
				//THEN now fill it up
				deptRef.setDepartmentNumber(  tempDeptno  );
				deptRef.setDepartmentName (tempDname );
				deptRef.setDepartmentLocation( tempLoc );
				
				System.out.println(deptRef.getDepartmentNumber());
				System.out.println(deptRef.getDepartmentName());
				System.out.println(deptRef.getDepartmentLocation());
				
			}
			
			rs.close();
			st.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

