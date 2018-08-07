package com.cg.emp.empRepo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.emp.bean.EmpBean;

@Repository
public interface IEmpRepo extends JpaRepository<EmpBean, Integer>{

	@Query("SELECT e from EmpBean e where e.eId=:id")
	EmpBean EmployeeDetails(@Param("id")String eid);

	@Query("DELETE FROM EmpBean e WHERE e.eId=:id")
	public EmpBean deleteEmployee(@Param(value="id") String id);
	
	/*@Query("UPDATE EmpBean e SET e.eName=:name,e.project=:project,e.salary=:salary WHERE e.eId=:id")
	public EmpBean updateEmployye(@Param(value="name") String name, @Param(value="project") String project, @Param(value="salary") double salary ,@Param(value="id") int id);
	
	
	
	@Query("SELECT * FROM EmpBean WHERE eId=:id")
	public EmpBean getOneById(@Param(value="id") String id);*/

	

	

}
