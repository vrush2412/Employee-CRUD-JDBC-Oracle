package linkcode.ui;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import linkcode.dao.EmployeeDaoImpl;
import linkcode.entity.Employee;

public class EmployeeMainUI{
         public static void main(String args[]) {
        Scanner sc= new Scanner(System.in);
        	
        	
        	 int i=0;
        	 Employee etemp=null;
        	 EmployeeDaoImpl edao=new EmployeeDaoImpl();
        	 List<Employee> lst=new ArrayList<Employee>();
        	 do {
        	 System.out.println("1- Create\n 2-Update\n 3-Delete\n 4-Search\n 5-Display All");
        	 System.out.println("Enter your Choice....");
        	 int ch=sc.nextInt();
        	 
        	 switch(ch) {
        	 case 1:
        		 System.out.println(" Enter your empid,name,salary");
        		Employee eobj=new Employee(sc.nextInt(),sc.next(),sc.nextDouble());
        		 lst.add(eobj);
        		 i=edao.createRecord(lst);
        		 if(i>0) {
        			 
        			 System.out.println("Record Saved");
        		 }
        		 else {
        			 System.out.println("Record not saved");
        		 }
        		 break;
        	 
        		 
        	 case 2:
        		 
        		 System.out.println(" Enter your empid and  new salary to be changed:");
        		 int eid=sc.nextInt();
        		 double salary=sc.nextDouble();
        		 etemp=new Employee();
        		 etemp.setEmpid(eid);
        		 etemp.setSalary(salary);
        		 lst.add(etemp);
        		 i=edao.updateRecord(lst);
        		 if(i>0) {
        			 System.out.println("Record updated");
        		 }
        		 else {
        			 System.out.println("Record not updated");
        		 }
        		 break;
//        		 System.out.println("Enter employee id and salary of data to be changed");
//        		   //Employee emobj=new Employee(sc.nextInt(),null,sc.nextDouble());
//        		   //lst.add(emobj);
//        		int  empid=sc.nextInt();
//        		double salary=sc.nextDouble();
//        		   i=edao.UpdateRecord(empid,salary);
//        		 if(i>0) {
//        			 System.out.println("record updated");
//        		 }
//        		 else {
//        			 System.out.println("could not update record");
//        		 }
        	 case 3:
        		 System.out.println("Enter the empid to be deleted");
        		int  empid=sc.nextInt();
        		 i=edao.DeleteRecord(empid);
        		 if(i>0) {
        			 System.out.println("Record Deleted..");
        		 }
        		 else {
        			 System.out.println("Could not Delete Record...");
        		 }
        		 break;
        		 
        	 case 4:
        		 System.out.println("Enter the empid to be searched");
        		 eid=sc.nextInt();
        		 lst=edao.searchRecord(eid);
        		 if(lst!=null) {
        			 etemp=lst.get(0);
        			 System.out.println(etemp.getEmpid()+"\t"+etemp.getEmpname()+"\t"+etemp.getSalary()+"\t");
        		 }
        		 else {
        			 System.out.println("Invalid Employee id....");
        		 }
        		 break;
        	 case 5:
        		 lst=edao.DisplayAllRecords();
        		 System.out.println("--------------------your Data Is Displayed here---------------------");
        		 
        		 for(int j=0;j<lst.size();j++) {
        			 etemp=lst.get(j);
        			 System.out.println(etemp.getEmpid()+"\t"+etemp.getEmpname()+"\t"+etemp.getSalary());
        		 }
        		 System.out.println("----------------------------------------------------------------------");
        		 break;
        	 
        	 }
        	 System.out.println("Do you want to continue pree yes or no");
        	 }
        	 while(sc.next().equals("yes"));
        	 System.out.println("--------------------------THANK YOU-------------------");
        	 
        	 
        	 
        	 }
        	 
         }
