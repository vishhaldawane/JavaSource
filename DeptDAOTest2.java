import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeptDAOTest2 {
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
			Statement st1 = conn.createStatement();
			Statement st2 = conn.createStatement();
			Statement st3 = conn.createStatement();
			
			System.out.println("Statement created.."+st1);
			System.out.println("Statement created.."+st2);
			System.out.println("Statement created.."+st3);
			
			//CRUD
			ResultSet rs1 = st1.executeQuery("select deptno,dname,loc from dept");
			ResultSet rs2 = st2.executeQuery("select empno,ename,job from emp");
			ResultSet rs3 = st3.executeQuery("select custid,name,city from customer");
			
			System.out.println("Got the result : "+rs1);
			System.out.println("Got the result : "+rs2);
			System.out.println("Got the result : "+rs3);
			
			while(rs1.next()) //now rs is pointing to dept
			{
				System.out.println(rs1.getInt(1)); //d.getDeptno();
				System.out.println(rs1.getString(2));//.getDeptName();
				System.out.println(rs1.getString(3)); //d.getDeptLoc();
				System.out.println("------------------");
			}
			System.out.println("================");
			while(rs2.next()) //now rs is pointing to dept
			{
				System.out.println(rs2.getInt(1)); //e.getEmpno();
				System.out.println(rs2.getString(2));
				System.out.println(rs2.getString(3));
				System.out.println("------------------");
			}
			System.out.println("================");
			while(rs3.next()) //now rs is pointing to dept
			{
				System.out.println(rs3.getInt(1)); //c.getCustId();
				System.out.println(rs3.getString(2));
				System.out.println(rs3.getString(3));
				System.out.println("------------------");
			}
			
			//what if u have three tables (dishes ) wada,idli, pizza
			//how u consume...
			//all the 8 wadas in its own dish
			//all the 9 idlis in its own dish
			//all pizza 6 pie in its own dish
			//yes or no????????????
			
			//but in the kitchen someone (chef) has to setIt in the dish
			//only u do one thing.....getIt (You) right????
			
			
			
			rs1.close();
			rs2.close();
			rs3.close();
			
			st1.close();
			st2.close();
			st3.close();
			
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

