package com.demobatch.MyDao;

import java.util.List;

import com.demobatch.bean.Departmentlist;
import com.demobatch.bean.DesignationRef;
import com.demobatch.bean.EmployeeDetail;

public interface MyDao {

	Long insertEmployeeDetails(EmployeeDetail employeeObj);

	Boolean insertDeptList(List<Departmentlist> deptlist, Long empId);

	Boolean insertDesignationList(List<DesignationRef> designationList, Long empId);

	Long insertEmpDetails(EmployeeDetail insertEmpDetails);

	Boolean insertDepartments(List<Departmentlist> deptlist, Long empId);

	Boolean insertDesignations(List<DesignationRef> designationList, Long empId);

	
	
	
}
