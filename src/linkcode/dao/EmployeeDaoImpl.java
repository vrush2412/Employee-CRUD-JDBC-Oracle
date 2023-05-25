package linkcode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import linkcode.DataSource.DBConnection;
import linkcode.entity.Employee;

public class EmployeeDaoImpl {
	
	Connection con=DBConnection.getConnection();
	
	int i=0;
  public int createRecord(List<Employee> lst) {
	  
	  
	  
	  try {
		PreparedStatement pstate=con.prepareStatement("insert into employeedb values(?,?,?)");
		  Employee eobj=lst.get(0);
		  pstate.setInt(1, eobj.getEmpid());
		  pstate.setString(2,eobj.getEmpname());
		  pstate.setDouble(3,eobj.getSalary());
		  i=pstate.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return i;
  }
  
  public int updateRecord(List<Employee>lst) {
	  int i=0;
	  Connection con=DBConnection.getConnection();
	       try {
			PreparedStatement pstate=con.prepareStatement("update employeedb set salary=? where empid=?");
			   Employee etemp=lst.get(0);
			   pstate.setDouble(1,etemp.getSalary());
			   pstate.setInt(2,etemp.getEmpid());
			   
			   i=pstate.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 return i;
  }
  
  public int DeleteRecord(int empid) {
       int i=0;
        Connection con=DBConnection.getConnection();
	  try {
		PreparedStatement pstate=con.prepareStatement("delete from employeedb where empid=?");
		  pstate.setInt(1,empid);
		  i=pstate.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return i;
  }
  
  public List<Employee> searchRecord(int eid){
	  int i=0;
	  //Connection con=DBConnection.getConnection();
	  List<Employee> lst=null;
	  
	  try {
	  PreparedStatement pstate=con.prepareStatement("select * from employeedb where empid=?");
	  pstate.setInt(1,eid);
	  ResultSet rs=pstate.executeQuery();
	 
	  if(rs.next()) {
		 lst=new ArrayList<Employee>();
		 eid=rs.getInt(1);
		 String emn =rs.getString(2);
		 double sal=rs.getDouble(3);
		 Employee etemp=new Employee(eid,emn,sal);
		lst.add(etemp); 
	     }
	  }
	  catch (Exception e) {
			// TODO Auto-generated catch block
		  System.out.println(e);
			e.printStackTrace();
		
	  }
	  return lst;
  }
  public List<Employee> DisplayAllRecords()
  {
	  
  
	  int i=0;
	 // Connection con=DBConnection.getConnection();
	  List<Employee> lst=new ArrayList();
	  try {
	  	  String str="select * from employeedb";
	  Statement state=con.createStatement();
	  ResultSet rs=state.executeQuery(str);
	  ResultSetMetaData rsmd=rs.getMetaData();
	  int j=rsmd.getColumnCount();
	  while(rs.next()){
	  
		  Employee elst=new Employee(rs.getInt(1),rs.getString(2),rs.getDouble(3));
		  lst.add(elst);
		  
  }
	  }
	  catch (Exception e) {
		  
			// TODO Auto-generated catch block
		  System.out.println(e);
			e.printStackTrace();
	}
	  return lst;
  }

}

//	  public int UpdateRecord(int empid,double salary) {
//	  
//	  try {
//		PreparedStatement pstate=con.prepareStatement("update employeedb set salary=? where empid=?");
//		  //Employee emobj=lst.get(0);
//		  pstate.setDouble(1,salary);
//		  pstate.setInt(2,empid);
//		  i=pstate.executeUpdate();
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	  
//	  
//	  return i;
//	  }
  

