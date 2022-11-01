package com.demobatch.bean;

public class Departmentlist {

	private Long deptId;
	private String deptNm;
	private Long empId;
	
	public Long getDeptId() {
		return deptId;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public String getDeptNm() {
		return deptNm;
	}
	public void setDeptNm(String deptNm) {
		this.deptNm = deptNm;
	}
}
