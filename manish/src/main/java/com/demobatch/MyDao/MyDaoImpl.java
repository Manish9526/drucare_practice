package com.demobatch.MyDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.demobatch.bean.Departmentlist;
import com.demobatch.bean.DesignationRef;
import com.demobatch.bean.EmployeeDetail;

@Repository
public class MyDaoImpl implements MyDao {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public Long insertEmployeeDetails(EmployeeDetail employeeObj) {

		long empId = 0;
		String queryForInsertEmployeeDetails = "insert into employee_detail_ref(first_nm,middle_nm,last_nm,emp_email,phone_no,mobile_no,address,address_line1,city_nm,district_nm,country_nm,pin_code,salary,experience,qualification)"
				+ " values(:firstNm,:middleNm,:lastNm,:empEmail,:phoneNo,:mobileNo,:address,:addressLine1,:cityNm,:districtNm,:countryNm,:pinCode,:salary,:experience,:qualification)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(queryForInsertEmployeeDetails,
				new BeanPropertySqlParameterSource(employeeObj), keyHolder, new String[] { "emp_id" });

		empId = keyHolder.getKey().longValue();
		return empId;
	}

	@Override
	public Boolean insertDeptList(List<Departmentlist> deptlist, Long empId) {
		boolean flag = false;
		String queryForInsertDept = "insert into employee_dept_xref (emp_id,dept_id) values (:empId,:deptId)";

		for (Departmentlist deptObj : deptlist) {
			MapSqlParameterSource parameters = new MapSqlParameterSource().addValue("empId", empId).addValue("deptId",
					deptObj.getDeptId());
			flag = namedParameterJdbcTemplate.update(queryForInsertDept, parameters) > 0;
		}
		return flag;
	}

	@Override
	public Boolean insertDesignationList(List<DesignationRef> designationList, Long empId) {
		boolean flag = false;

		String queryForInsertDesignation = "insert into employee_designations_xref (emp_id,designation_id,isactive)values(:empId,:designationId,true)";

		for (DesignationRef designationObj : designationList) {
		MapSqlParameterSource parameter	  =new MapSqlParameterSource().addValue("empId", empId).addValue("designationId",
					designationObj.getDesignationId());
			flag = namedParameterJdbcTemplate.update(queryForInsertDesignation, parameter) > 0;
		}
		return flag;
	}

	// ###################################################################################################################//
	// BATCH UPDATE USING JDBC
	@Override
	public Long insertEmpDetails(EmployeeDetail insertEmpDetails) {
		
//		long empId=0;
		String queryForInsertEmployeeDetails = "insert into employee_detail_ref(first_nm,middle_nm) values(:firstNm,:middleNm)";
		
		KeyHolder keyHolder=new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(queryForInsertEmployeeDetails, new BeanPropertySqlParameterSource(insertEmpDetails),keyHolder,new String[] { "emp_id"});
		return keyHolder.getKey().longValue();
		
	}

	@Override
	public Boolean insertDepartments(List<Departmentlist> deptlist, Long empId) {
		 boolean flag=false;
		 String queryForInsertDepartment="insert into employee_dept_xref (emp_id,dept_id) values (?,?)";
		  int[] Count = jdbcTemplate.batchUpdate(queryForInsertDepartment, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				Departmentlist deptObj= deptlist.get(i);
				ps.setLong(1,empId);
				ps.setLong(2,deptObj.getDeptId());
				
			}
			
			@Override
			public int getBatchSize() {
				
				return deptlist.size();
			}
		});
		  
		  flag=Count.length==deptlist.size();
		return flag;
	}

	@Override
	public Boolean insertDesignations(List<DesignationRef> designationList, Long empId) {
		
		String queryForinsertDesignation="insert into employee_designations_xref (emp_id,designation_id)values(?,?)";
		int[] Count = jdbcTemplate.batchUpdate(queryForinsertDesignation, new BatchPreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				DesignationRef designationObj=designationList.get(i);
				ps.setLong(1, empId);
				ps.setLong(2, designationObj.getDesignationId());
			}
			
			@Override
			public int getBatchSize() {
				
				return designationList.size();
			}
		});
		return Count.length==designationList.size();
	}

}
