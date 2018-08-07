package com.cg.emp.Employee;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.cg.emp.bean.EmpBean;
import com.cg.emp.exception.EmployeeException;
import com.cg.emp.service.IEmpService;

@RestController
public class EmpController {
	
	@Autowired
	private IEmpService service;
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public EmpBean addEmployee(@RequestBody EmpBean emp) throws EmployeeException {
		
		try {
			service.createEmployee(emp);
		} catch (EmployeeException e) {
			throw new EmployeeException("Employee Details cannot be uploaded");
		}
		return emp;
		
	}
	
	@RequestMapping(value="/update",method=RequestMethod.PUT)
	public EmpBean updateEmployee(@RequestBody EmpBean emp) {
		EmpBean emp1=null;
		try {
			emp1 = service.updateEmployee(emp);
		} catch (EmployeeException e) {
			
		}
		return emp1;
		
	}
	@RequestMapping(value="/delete",method=RequestMethod.DELETE)
	public boolean deleteEmployee(String id) {
	boolean b = false;
	try {
		b = service.deleteEmployee(id);
	} catch (EmployeeException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return b;
		
	}
	@RequestMapping(value="/getEmployee")
	public EmpBean getEmployeeById(String id) {
		EmpBean emp=null;
		try {
			emp = service.getEmployeeById(id);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
		
	}
	@RequestMapping(value="/employee")
	public List<EmpBean> getEmployeeDetails(EmpBean emp) {
		
		List<EmpBean> empList=null;
		try {
			 empList=service.getEmployeeDetails(emp);
		} catch (EmployeeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return empList;
		
	}

}
