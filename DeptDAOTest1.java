import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeptDAOTest1 {
	public static void main(String[] args) {

		//how we use jdbc code?
		
		//1st load the driver
		//2nd connect to DB
		//3rd make statement (for select/insert/update/delete)
		//4th execute statement
		//5th process the statement
		
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
				System.out.println(rs.getInt(1)); //d.getDeptno();
				System.out.println(rs.getString(2));//.getDeptName();
				System.out.println(rs.getString(3)); //d.getDeptLoc();
				System.out.println("------------------");
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

