package com.ClientRestTemplate.Bean;

public class EmployeeDesignationXref {

	private Long employeeDesignationId;
	private Long empId;
	private Long designationId;
	private Boolean isactive;
	public Long getEmployeeDesignationId() {
		return employeeDesignationId;
	}
	public void setEmployeeDesignationId(Long employeeDesignationId) {
		this.employeeDesignationId = employeeDesignationId;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public Long getDesignationId() {
		return designationId;
	}
	public void setDesignationId(Long designationId) {
		this.designationId = designationId;
	}
	public Boolean getIsactive() {
		return isactive;
	}
	public void setIsactive(Boolean isactive) {
		this.isactive = isactive;
	}
	
}
