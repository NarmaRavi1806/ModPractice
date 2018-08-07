package com.cg.emp.service;

import java.util.List;

import com.cg.emp.bean.EmpBean;
import com.cg.emp.exception.EmployeeException;

public interface IEmpService {
	
	EmpBean createEmployee(EmpBean emp) throws EmployeeException;
	EmpBean updateEmployee(EmpBean emp) throws EmployeeException;
	boolean deleteEmployee(String id) throws EmployeeException;
	List<EmpBean> getEmployeeDetails(EmpBean emp) throws EmployeeException;
	EmpBean getEmployeeById(String id) throws EmployeeException;
	
	

}
