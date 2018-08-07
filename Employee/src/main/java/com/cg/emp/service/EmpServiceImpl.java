package com.cg.emp.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.emp.bean.EmpBean;
import com.cg.emp.empRepo.IEmpRepo;
import com.cg.emp.exception.EmployeeException;

@Service
public class EmpServiceImpl implements IEmpService {
	
	@Autowired
	private IEmpRepo repo;

	@Override
	@Transactional
	public EmpBean createEmployee(EmpBean emp) throws EmployeeException{
		repo.save(emp);
		return emp;
	}

	@Override
	@Transactional
	public EmpBean updateEmployee(EmpBean emp) throws EmployeeException{
		EmpBean employee= repo.EmployeeDetails(emp.geteId());
		employee.seteName(emp.geteName());
		employee.setProject(emp.getProject());
		employee.setSalary(emp.getSalary());
		repo.save(employee);
		return employee;
	}

	@Override
	  @Transactional
	public boolean deleteEmployee(String id) throws EmployeeException{
		EmpBean e=repo.EmployeeDetails(id);
		if(e!=null) {
			//repo.deleteEmployee(id);
			repo.delete(e);
		return true;
		}
		else {
		return false;
	}
	}

	@Override
	
	public List<EmpBean> getEmployeeDetails(EmpBean emp) throws EmployeeException{
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public EmpBean getEmployeeById(String id) {
		// TODO Auto-generated method stub
		return repo.EmployeeDetails(id);
	}

	
}
