package linkcode.entity;

public class Employee {
  private int empid;
  private String empname;
  private Double salary;
  


public Employee(int empid, String empname, Double salary) {
	super();
	this.empid = empid;
	this.empname = empname;
	this.salary = salary;
}
public Employee() {
	// TODO Auto-generated constructor stub
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public Double getSalary() {
	return salary;
}
public void setSalary(Double salary) {
	this.salary = salary;
}
  
  
}
