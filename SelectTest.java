import java.sql.Connection; //interface
import java.sql.DriverManager; //class
import java.sql.ResultSet; // interface
import java.sql.SQLException; //exception
import java.sql.Statement; // interface

public class SelectTest {
	public static void main(String[] args) {
		System.out.println("begin main");
		try
		{
			//how to add the jar file
			//right click on project ->properties
			//-> java build path -> Libraries
			//-> Add External Jars..button
			//>-click the jar file ojdbc6_g/ojdbc14_g.jar  
			System.out.println("Loading the driver...");
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			System.out.println("Driver loaded...");
			
			//DESKTOP-EPTT35F
			System.out.println("\nTrying to connect to the db");
									//http://www.google.com:9900/index.jsp
									//mainpro:organ:thin:@  ip : dbport : instancename
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-EPTT35F:1521:XE", "scott", "tiger");
			System.out.println("Connected to the db : "+conn);
			
			System.out.println("\nTrying to create statement");
			//java.sql.Statement
			Statement st = conn.createStatement();
			System.out.println("Statement created...");
			
			System.out.println("\nTrying to fire the query....");
			ResultSet rs = st.executeQuery("select * from department");
			System.out.println("Query fired and got the result...");
			
			System.out.println("\nProcess the result...");
			
			//rs can be a cursor like variable here
			//while means like a cursor looping 
			while(rs.next()) //rs.next() means goto the next record
			{
				//next() means fetch next row
				int dno = rs.getInt(1); //first column as int
				String dnm = rs.getString(2); //first column as int
				String dlc = rs.getString(3); //first column as int
				
				System.out.println("DEPTNO : "+dno);
				System.out.println("DNAME  : "+dnm);
				System.out.println("LOC    : "+dlc);
				System.out.println("-------------------");
			}
			
			
			rs.close(); //now close the cursor if not required ahead
			st.close(); // now close the st if dont want ahead
			conn.close(); //close the connection if dont want ahead
			
			System.out.println("Trying to close the connection.");
			conn.close();
			System.out.println("Connection closed...");
			
		}
		catch(SQLException e) {
			System.out.println("Problem : "+e);
		}
		System.out.println("end main");
	}
}
