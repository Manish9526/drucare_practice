package com.EmployeeDeatil.empBean;

import java.util.List;

import io.swagger.annotations.ApiModelProperty;

//import io.swagger.annotations.ApiModelProperty;

public class EmployeeDeatilBean {
	
	@ApiModelProperty(value = "It is db genarated id for the perticular employee id ", required = false)
	private Long empId;
	private String firstNm;
	private String middleNm;
	private String lastNm;
	private String empEmail;
	private String phoneNo;
	private String mobileNo;
	private String address;
	private String addressLine1;
	private String cityNm;
	private String districtNm;
	private String countryNm;
	private Integer pinCode;
	private Double salary;
	private String experience;
	private String qualification;
	private Integer empAge;
	@ApiModelProperty(value = "It is the db genarated id for perticular Orgnization id", required = true)
	private Long orgId;
	
	

	private List<DeptBean> deptList;
	private List<DesignationBean> designationList;
	private List<EmployeeDeptXref> deptXrefsList;
	private List<EmployeeDesignationXRef> designationXRefsList;
	
	
	public Long getOrgId() {
		return orgId;
	}

	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}

	public EmployeeDeatilBean() {
		
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getFirstNm() {
		return firstNm;
	}

	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}

	public String getMiddleNm() {
		return middleNm;
	}

	public void setMiddleNm(String middleNm) {
		this.middleNm = middleNm;
	}

	public String getLastNm() {
		return lastNm;
	}

	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	public String getCityNm() {
		return cityNm;
	}

	public void setCityNm(String cityNm) {
		this.cityNm = cityNm;
	}

	public String getDistrictNm() {
		return districtNm;
	}

	public void setDistrictNm(String districtNm) {
		this.districtNm = districtNm;
	}

	public String getCountryNm() {
		return countryNm;
	}

	public void setCountryNm(String countryNm) {
		this.countryNm = countryNm;
	}

	public Integer getPinCode() {
		return pinCode;
	}

	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public Integer getEmpAge() {
		return empAge;
	}

	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}


	public List<DeptBean> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<DeptBean> deptList) {
		this.deptList = deptList;
	}

	public List<DesignationBean> getDesignationList() {
		return designationList;
	}

	public void setDesignationList(List<DesignationBean> designationList) {
		this.designationList = designationList;
	}

	public List<EmployeeDeptXref> getDeptXrefsList() {
		return deptXrefsList;
	}

	public void setDeptXrefsList(List<EmployeeDeptXref> deptXrefsList) {
		this.deptXrefsList = deptXrefsList;
	}

	public List<EmployeeDesignationXRef> getDesignationXRefsList() {
		return designationXRefsList;
	}

	public void setDesignationXRefsList(List<EmployeeDesignationXRef> designationXRefsList) {
		this.designationXRefsList = designationXRefsList;
	}
	
	
	
	
	
 	
}
