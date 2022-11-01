package com.EmployeeDeatil.empBean;

public class EmployeeDeptXref {

	private Long empDeptId;
	private Long empId;
	private Boolean isactive;
	private Long deptId;
	
	
	public EmployeeDeptXref(Long empDeptId, Long empId, Boolean isactive, Long deptId) {
		super();
		this.empDeptId = empDeptId;
		this.empId = empId;
		this.isactive = isactive;
		this.deptId = deptId;
	}


	public Long getEmpDeptId() {
		return empDeptId;
	}


	public void setEmpDeptId(Long empDeptId) {
		this.empDeptId = empDeptId;
	}


	public Long getEmpId() {
		return empId;
	}


	public void setEmpId(Long empId) {
		this.empId = empId;
	}


	public Boolean getIsactive() {
		return isactive;
	}


	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}


	public Long getDeptId() {
		return deptId;
	}


	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	
	
}
