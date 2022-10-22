package com.EmployeeDeatil.empBean;

public class DeptBean {
	
	private  Long deptId;
	private String deptNm;
	private Long empId;
	
	
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public DeptBean(Long deptId, String deptNm) {
		super();
		this.deptId = deptId;
		this.deptNm = deptNm;
	}
	public Long getDeptId() {
		return deptId;
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