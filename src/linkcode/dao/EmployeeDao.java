package linkcode.dao;

import java.util.List;

import linkcode.entity.Employee;

public interface EmployeeDao
{
	 public int createRecord(List<Employee>lst);
   public int updateRecord(List<Employee>lst);
    public int DeleteRecord(int n);
    public List<Employee> searchRecord(int n);
	 public List<Employee> DisplayAllRecords();
}
