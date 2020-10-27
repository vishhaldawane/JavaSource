package mypojos; //plain old java object

//this "class Department" is a proxy of your "Dept Table"
public class Department {
	//DEPTNO DNAME          LOC
	private int departmentNumber ; //proxy of deptno column
	private String departmentName; //proxy of dname column
	private String departmentLocation; //proxy of loc column
		
		
	public Department() {
		super();
		System.out.println("Department ctor...");
		
	}
	public int getDepartmentNumber() {
		return departmentNumber;
	}
	public void setDepartmentNumber(int departmentNumber) {
		this.departmentNumber = departmentNumber;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getDepartmentLocation() {
		return departmentLocation;
	}
	public void setDepartmentLocation(String departmentLocation) {
		this.departmentLocation = departmentLocation;
	}
	
	
}
