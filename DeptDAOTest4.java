import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import mypojos.Department;

interface DepartmentDAO // look at the CreateReadUpdateDelete operations below
{
	//READ
	ArrayList<Department>  selectAllDepartments(); //selct * from dept;
	Department 			   selectDepartmentByDeptno(int dno); //select * from dept where depnto=dno
	
	//CREATE
	void insertIntoDepartment(Department ref);
	
	//UPDATE
	void updateDepartmentName(int dno, String newDeptName);
	void updateDepartmentLocation(int dno, String newDeptLocation);
	void updateDepartmentNameAndLocation(int dno, String newDeptName, String newDeptLocation);
	
	//DELETE
	void deleteDepartmentByPrimaryKey(int dno);
	void deleteDepartmentByDepartmentName(String deptName);
	void deleteDepartmentByDepartmentLocation(String deptLoc);

}

class DepartmentDAOImpl implements DepartmentDAO
{
	Connection conn;
	
	DepartmentDAOImpl()
	{
		
		try {
			//1st step
			System.out.println("Registering Driver ....");
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			System.out.println("Driver registered....");
			
			//2nd step
			System.out.println("Trying to connect...");
			this.conn = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-EPTT35F:1521:xe","scott","tiger");
			System.out.println("Connected to the DB..."+conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public ArrayList<Department> selectAllDepartments() {
		//here the promise is to return arraylist of departments		
		//make a blank array list here now
		ArrayList<Department> allDepts = new ArrayList<Department>();
		
		try {
			//3rd step is what ???
			Statement st = conn.createStatement();
			
			System.out.println("Statement created.."+st);
			
			//CRUD
			ResultSet rs = st.executeQuery("select deptno,dname,loc from dept");
			
			System.out.println("Got the result : "+rs);
			
			while(rs.next()) //now rs is pointing to dept
			{
				//single blank object
				Department deptRef = new Department();

				//now fill up this deptRef object with DB value
				deptRef.setDepartmentNumber(  rs.getInt(1)  );
				deptRef.setDepartmentName (rs.getString(2));
				deptRef.setDepartmentLocation( rs.getString(3) );
				
				//this filled object to be added in the linked list
				allDepts.add(deptRef);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return allDepts;//as per the promise return this arraylist
	}
	public Department selectDepartmentByDeptno(int dno) {
		
		Department deptRef = null;
		
				try {
					//3rd step is what ???
					Statement st = conn.createStatement();
					
					System.out.println("Statement created.."+st);
					
					//CRUD
					ResultSet rs = st.executeQuery("select deptno,dname,loc from dept where deptno="+dno);
					
					System.out.println("Got the result : "+rs);
					
					if(rs.next()) //now rs is pointing to dept
					{
						//single blank object
						deptRef = new Department();

						//now fill up this deptRef object with DB value
						deptRef.setDepartmentNumber(  rs.getInt(1)  );
						deptRef.setDepartmentName (rs.getString(2));
						deptRef.setDepartmentLocation( rs.getString(3) );
					}
					else {
						System.out.println("Record NOT found");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
		return deptRef;
	}

	@Override
	public void insertIntoDepartment(Department ref) {
		try {
			PreparedStatement pst = conn.prepareStatement("insert into dept values (?,?,?)");
			System.out.println("PreparedStatement created.."+pst);
			pst.setInt(1, ref.getDepartmentNumber());
			pst.setString(2, ref.getDepartmentName());
			pst.setString(3, ref.getDepartmentLocation());
			int rows = pst.executeUpdate(); //fire the insert query via this line
			System.out.println("Number of rows inserted : "+rows);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateDepartmentName(int dno, String newDeptName) {
		try {
			PreparedStatement pst = conn.prepareStatement("update dept set dname=? where deptno=?");
			System.out.println("PreparedStatement created.."+pst);
			
			pst.setString(1, newDeptName);
			pst.setInt(2, dno);
			
			int rows = pst.executeUpdate(); //fire the update query via this line
			System.out.println("Number of rows updated : "+rows);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateDepartmentLocation(int dno, String newDeptLocation) {
		try {
			PreparedStatement pst = conn.prepareStatement("update dept set loc=? where deptno=?");
			System.out.println("PreparedStatement created.."+pst);
			
			pst.setString(1, newDeptLocation);
			pst.setInt(2, dno);
			
			int rows = pst.executeUpdate(); //fire the update query via this line
			System.out.println("Number of rows updated : "+rows);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateDepartmentNameAndLocation(int dno, String newDeptName, String newDeptLocation) {
		try {
			PreparedStatement pst = conn.prepareStatement("update dept set dname=?, loc=? where deptno=?");
			System.out.println("PreparedStatement created.."+pst);
			
			pst.setString(1, newDeptName);
			pst.setString(2, newDeptLocation);
			pst.setInt(3, dno);
			
			int rows = pst.executeUpdate(); //fire the update query via this line
			System.out.println("Number of rows updated : "+rows);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteDepartmentByPrimaryKey(int dno) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = conn.prepareStatement("delete from dept where deptno=?");
			System.out.println("PreparedStatement created.."+pst);
			
			pst.setInt(1, dno);
			
			int rows = pst.executeUpdate(); //fire the delete query via this line
			System.out.println("Number of rows deleted (based on deptno[pk]) : "+rows);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteDepartmentByDepartmentName(String deptName) {
		// TODO Auto-generated method stub
				try {
					PreparedStatement pst = conn.prepareStatement("delete from dept where dname=?");
					System.out.println("PreparedStatement created.."+pst);
					
					pst.setString(1, deptName);
					
					int rows = pst.executeUpdate(); //fire the delete query via this line
					System.out.println("Number of rows deleted (based on dname) : "+rows);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
	}

	@Override
	public void deleteDepartmentByDepartmentLocation(String deptLoc) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pst = conn.prepareStatement("delete from dept where loc=?");
			System.out.println("PreparedStatement created.."+pst);
			
			pst.setString(1, deptLoc);
			
			int rows = pst.executeUpdate(); //fire the delete query via this line
			System.out.println("Number of rows deleted (based on location)  : "+rows);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


public class DeptDAOTest4 {
	public static void main(String[] args) {
		
			DepartmentDAOImpl ddi = new DepartmentDAOImpl();
			
			/*
			ArrayList<Department> myList = ddi.selectAllDepartments();
			
			Iterator<Department> iter = myList.iterator();
			while(iter.hasNext())
			{
				Department ref = iter.next();
				System.out.println(ref.getDepartmentNumber());
				System.out.println(ref.getDepartmentName());
				System.out.println(ref.getDepartmentLocation());
			}
			*/
			
			/*
			//now lets see how to get a  single dept record
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter dept no to search : ");
			int num = scan.nextInt();
			Department x = ddi.selectDepartmentByDeptno(num);
			System.out.println("Dept Number : "+x.getDepartmentNumber());
			System.out.println("Dept Name   : "+x.getDepartmentName());
			System.out.println("Dept Loc    : "+x.getDepartmentLocation());
			*/
			
			// lets see how to insert values
		/*
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Enter New dept no   : ");
			int newDeptno = scan1.nextInt();
			
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Enter New dept name : ");
			String newDeptName = scan2.nextLine();
			
			Scanner scan3 = new Scanner(System.in);
			System.out.println("Enter New dept loc  : ");
			String newDeptLoc = scan3.nextLine();
			
			Department deptObj = new Department(); //blank object
			deptObj.setDepartmentNumber(newDeptno);
			deptObj.setDepartmentName(newDeptName);
			deptObj.setDepartmentLocation(newDeptLoc);
			ddi.insertIntoDepartment(deptObj);
		*/
			
			/*
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Enter existing dept no   : ");
			int currentDeptno = scan1.nextInt();
			
			Scanner scan2 = new Scanner(System.in);
			System.out.println("Enter modified dept name : ");
			String newDeptName = scan2.nextLine();
			
			Scanner scan3 = new Scanner(System.in);
			System.out.println("Enter modified dept loc  : ");
			String newDeptLoc = scan3.nextLine();
			
			ddi.updateDepartmentNameAndLocation(currentDeptno, newDeptName, newDeptLoc);
			*/
			
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Enter existing dept no delete : ");
			int deptNoToDelete = scan1.nextInt();
			
			ddi.deleteDepartmentByPrimaryKey(deptNoToDelete);
			
	}
}

