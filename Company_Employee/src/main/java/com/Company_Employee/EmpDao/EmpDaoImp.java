package com.Company_Employee.EmpDao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.Company_Employee.Bean.EmployeeRefBean;

@Repository
public class EmpDaoImp implements EmpDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Boolean insertOrUpdateEmpList(List<EmployeeRefBean> insertEmp) {
		boolean flag = false;
		long empId = 0;
		for (EmployeeRefBean employeeObj : insertEmp) {

			//insert Employee Detail 
			if (employeeObj.getEmpId() == null) {

				String queryForinsertEmployee = "insert into employee_detail_ref(first_nm,middle_nm,last_nm,emp_email,phone_no,mobile_no,address,address_line1,org_id,city_nm,district_nm,country_nm,pin_code,salary,experience,qualification)"
						+ " values(:firstNm,:middleNm,:lastNm,:empEmail,:phoneNo,:mobileNo,:address,:addressLine1,:orgId,:cityNm,:districtNm,:countryNm,:pinCode,:salary,:experience,:qualification)";
				KeyHolder keyHolder = new GeneratedKeyHolder();
				empId = namedParameterJdbcTemplate.update(queryForinsertEmployee,
						new BeanPropertySqlParameterSource(employeeObj), keyHolder, new String[] { "emp_id" });
				employeeObj.setEmpId(empId);

			} else {//update employee detail

				String queryForupdateEmp = "update employee_detail_ref set first_nm = :firstNm,middle_nm = :middleNm,last_nm = :lastNm,emp_email =:empEmail,phone_no=:phoneNo,mobile_no=:mobileNo,address=:address,address_line1=:addressLine1,org_id=:orgId,city_nm=:cityNm,district_nm=:districtNm,country_nm=:countryNm,pin_code=:pinCode,salary=:salary,experience =:experience,qualification=:qualification where emp_id = :empId";
				flag = namedParameterJdbcTemplate.update(queryForupdateEmp,
						new BeanPropertySqlParameterSource(employeeObj)) > 0;
			}

//			for (DeparmentRefBean departmentBeanObj : employeeObj.getDeptList()) {
//				departmentBeanObj.setEmpId(employeeObj.getEmpId());
//				
//				//insert Department if deptId is null
//				if (departmentBeanObj.getDeptId() == null) {
//
//					String queryForinsertDepartment = "insert into department_ref(dept_nm,emp_id) values (:deptNm,:empId)";
//					flag = namedParameterJdbcTemplate.update(queryForinsertDepartment,
//							new BeanPropertySqlParameterSource(departmentBeanObj)) > 0;
//
//				} else {//update department
//
//					String queryForUpdateDepartment = "update department_ref set dept_nm=:deptNm,emp_id =:empId where dept_id =:deptId";
//					flag = namedParameterJdbcTemplate.update(queryForUpdateDepartment,
//							new BeanPropertySqlParameterSource(departmentBeanObj)) > 0;
//
//				}
//				
//////				employee Department Xref Class object
////				EmployeeDeptXRefBean employeeDeptXRefObj = new EmployeeDeptXRefBean();
////				
//////				insert employeedepartmentXref
////				if (employeeDeptXRefObj.getEmpDeptId() == null) {
////					employeeDeptXRefObj.setDeptId(departmentBeanObj.getDeptId());
////					
////					String queryForinsertDepartmentXref = "insert into employee_dept_xref (emp_id,dept_id) values(:empId,:deptId)";
////					namedParameterJdbcTemplate.update(queryForinsertDepartmentXref,
////							new BeanPropertySqlParameterSource(departmentBeanObj));
////
////				} else {//update employeedepartmentXref table
////
////					String queryForUpdateDepartmentXref = "update employee_dept_xref emp_id=:empId,dept_id =:deptId where emp_dept_id=:empDeptId";
////					namedParameterJdbcTemplate.update(queryForUpdateDepartmentXref,
////							new BeanPropertySqlParameterSource(departmentBeanObj));
//
//				}
//			}
//
//			for (DesignationRef designationRefObj : employeeObj.getDesignationList()) {
//				designationRefObj.setEmpId(employeeObj.getEmpId());
////				insert designation if designation id is null
//				if (designationRefObj.getDesignationId() == null) {
//
//					String queryForinsertDesignation = "insert into designations_ref (designation_nm,emp_id)values(:designationNm,:empId)";
//					flag = namedParameterJdbcTemplate.update(queryForinsertDesignation,
//							new BeanPropertySqlParameterSource(designationRefObj)) > 0;
//
//				} else {
//					//update Designation table
//					String queryForUpdateDesignation = "update designations_ref set designation_nm=:designationNm,emp_id=:empId where designation_id =:designationId";
//					flag = namedParameterJdbcTemplate.update(queryForUpdateDesignation,
//							new BeanPropertySqlParameterSource(designationRefObj)) > 0;
//				}
//
//				EmployeeDesignationXRef employeeDesignationXRefObj = new EmployeeDesignationXRef();
////				insert employeeDesignationXref table
//				if (employeeDesignationXRefObj.getEmployeeDesignationId() == null) {
//					
//					employeeDesignationXRefObj.setDesignationId(designationRefObj.getDesignationId());
//					
//					String queryForinsertdesignationXref = "insert into employee_designations_xref (designation_id,emp_id)values(:designationId,:empId)";
//					namedParameterJdbcTemplate.update(queryForinsertdesignationXref,
//							new BeanPropertySqlParameterSource(designationRefObj));
//
//				} else {// update employeeDesignationxref table
//					String queryForUpdateDesignationXref = "update employee_designations_xref set designation_id=:designationId,emp_id=:empId where employee_designation_id=:employeeDesignationId";
//					namedParameterJdbcTemplate.update(queryForUpdateDesignationXref,
//							new BeanPropertySqlParameterSource(designationRefObj));
//
//				}
//
//			}
//		}

		
	}
		return flag;
	}
}
