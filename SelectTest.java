import java.sql.Connection; //interface
import java.sql.DriverManager; //class
import java.sql.ResultSet; // interface
import java.sql.SQLException; //exception
import java.sql.Statement; // interface
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import oracle.security.o3logon.a;

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
			
			
			Calendar cal = Calendar.getInstance();
			
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Enter day   : ");
			int day = scan1.nextInt(); //20
			
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Enter month : ");
			int month = scan2.nextInt(); //02 ..becomes 1 for Feb 
	
			
			Scanner scan3 = new Scanner(System.in);
			System.out.println("Enter year  : ");
			int year = scan3.nextInt(); //1981
			
			Scanner scan4 = new Scanner(System.in);
			System.out.println("Enter boarding : ");
			String board= scan4.next(); //Ahmedabad


			Scanner scan5 = new Scanner(System.in);
			System.out.println("Enter dropping : ");
			String drop = scan4.next(); //Mumbai			
			

			
			Scanner scan6 = new Scanner(System.in);
			System.out.println("Enter Route    : ");
			int route = scan6.nextInt(); //1

			cal.set(year, (month-1),day); //jan is 0 ..hence dec 11
			
			Date dt = cal.getTime();
			
		    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		    String strDate= sdf.format(dt);  
		    System.out.println("date1 : "+strDate);

		    
		    String query = "SELECt r.tiCKetno, br.routeno, r.seatNO, r.journeydate, br.boarding, br.dropping from reservation r, bus_route br where br.routeno="+route+" and br.boarding='"+board+"' and br.dropping='"+drop+"' and to_char(r.journeydate,'dd-MM-yyyy')='"+strDate+"'";
		    System.out.println("query : "+query);
   			ResultSet rs = st.executeQuery(query);
   			
			/*
			
			class RouteReservation {
		    	int ticketNumber;
		    	int routeNumber;
		    	int seatNumber;
		    	Date dateJourney;
		    	String boarding;
		    	String dropping;
		    	
		    		//with setter/getter
		    }
	Query query = entityManager.createNativeQuery(query, 
			RouteReservation.class);


			List<RouteReservation> routeResList = query.getResultList();
			for (RouteReservation rr : routeResList )
				System.out.println("ticke nu "+rr.get..);

			
			a pojo to match the result = NativeQuery(pojo.class,query).getResultList();
			*/

			System.out.println("Query fired and got the result...");
			
			System.out.println("\nProcess the result...");
			
			//rs can be a cursor like variable here
			//while means like a cursor looping
			System.out.println("out of while ");
			while(rs.next()) //rs.next() means goto the next record
			{
				System.out.println("inside while..");
				//next() means fetch next row
				int tno = rs.getInt(1); //first column as int
				int rn = rs.getInt(2); //first column as int
				int sn = rs.getInt(3); //first column as int
				Date journey = rs.getDate(4); //first column as int
				String b  = rs.getString(5);
				String d  = rs.getString(6);
				
				System.out.println("TktNo  : "+tno);
				System.out.println("route  : "+rn);
				System.out.println("SeatNo : "+sn);
				System.out.println("Journey: "+journey);
				System.out.println("Board  : "+b);
				System.out.println("Board  : "+d);
				System.out.println("-------------------");
			}
			System.out.println("End of while ");
			
			
			rs.close(); //now close the cursor if not required ahead
			st.close(); // now close the st if dont want ahead
			conn.close(); //close the connection if dont want ahead
			
			System.out.println("Trying to close the connection.");
			conn.close();
			System.out.println("Connection closed...");
			
		}
		catch(SQLException e) {
			System.out.println("Problem1 : "+e);
			e.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("Problem2 : "+e);
			//e.printStackTrace();
		}
		System.out.println("end main");
	}
}
