package com.bank;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DepartmentSelectAllTest {
	public static void main(String[] args) {
		
		Configuration config = new Configuration();
		System.out.println("=> Configuration created..."+config);
		
		SessionFactory factory = config.configure("hibernate.cfg.xml").buildSessionFactory();
		System.out.println("=> Factory created : "+factory);
		
		Session mySession = factory.getCurrentSession();
		System.out.println("=> Got the session : "+mySession);
		
		Transaction myTransaction = mySession.beginTransaction();
		System.out.println("=> Started the transaction : "+myTransaction);
		
		List<Department> deptList = new ArrayList<Department>();
		
		//HQL
		String myQueryString = "from Employee";//select * from dept20;
		
      //  String myQueryString = "select d.departmentName, d.departmentLocation, e.employeename, e.employeeJob  from Department d,Employee e  where d.departmentNumber=e.employeNumber"; 
	                          //select  dname,              loc               from  dept20      where    deptno = 10;
		
		//cursor c1 as select * from dept20;
		
		//import org.hibernate.query.Query;
		Query<Department> theHqlQuery = mySession.createQuery(myQueryString);
		System.out.println("theHqlQuery : "+theHqlQuery);
		
		deptList =	theHqlQuery.getResultList();
		
		Iterator<Department>	deptIter = deptList.iterator();
		
		while(deptIter.hasNext()) {

				Department ref = deptIter.next();
				System.out.println("Dept Number  : "+ref.getDepartmentNumber());
				System.out.println("Dept Name    : "+ref.getDepartmentName());
				System.out.println("Dept Loc     : "+ref.getDeparmentLocation());
				System.out.println("-----------------------");
		}
		
		System.out.println("=> committed the session...");
		//Where is UserNotFoundException
		
		// java.lang.Exception
		//		IOExceotion		SQLException
		//
		
		myTransaction.commit();
		System.out.println("=> Transaction committed...");
		
		factory.close();
		System.out.println("=> Session factory closed....");

		
		
	}
}
