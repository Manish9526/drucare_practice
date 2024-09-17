package com.ClientRestTemplate.Bean;

import java.util.List;

public class EmployeeList {

	private List<EmployeeDetailRef> empList;
	private List<DepartmentRef> deptList;
	private List<DesignationRef> designationList;
	public List<EmployeeDetailRef> getEmpList() {
		return empList;
	}
	public void setEmpList(List<EmployeeDetailRef> empList) {
		this.empList = empList;
	}
	public List<DepartmentRef> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<DepartmentRef> deptList) {
		this.deptList = deptList;
	}
	public List<DesignationRef> getDesignationList() {
		return designationList;
	}
	public void setDesignationList(List<DesignationRef> designationList) {
		this.designationList = designationList;
	}
	
	
	
}
