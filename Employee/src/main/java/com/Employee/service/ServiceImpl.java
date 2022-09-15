package com.Employee.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.Employee.Model.EmployeeDetail;

@Service
public class ServiceImpl {
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public Boolean insertEmployeeMap(EmployeeDetail insertEmployeeDetail) {
		// TODO Auto-generated method stub
		boolean rs = false;
		String query = "insert into public.employee_detail (first_name,middle_name,last_name,salary,address,phone_number)values(:firstName,:middleName,:lastName,:salary,:address,:phoneNumber)";
		Map<String, Object> map = new HashMap<>();
		map.put("firstName", insertEmployeeDetail.getFirstName());
		map.put("lastName", insertEmployeeDetail.getLastName());
		map.put("middleName", insertEmployeeDetail.getMiddleName());
		map.put("salary", insertEmployeeDetail.getSalary());
		map.put("address", insertEmployeeDetail.getAddress());
		map.put("phoneNumber", insertEmployeeDetail.getPhoneNumber());
		rs = namedParameterJdbcTemplate.update(query, map) > 0;
		return rs;
	}

	public Boolean insertEmployeeMapSqlParameter(EmployeeDetail insertEmployeeDetail) {
		// TODO Auto-generated method stub
		boolean rs = false;
		String query = "insert into public.employee_detail (first_name,middle_name,last_name,salary,address,phone_number)values(:firstName,:middleName,:lastName,:salary,:address,:phoneNumber)";
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("firstName", insertEmployeeDetail.getFirstName())
				.addValue("middleName", insertEmployeeDetail.getMiddleName())
				.addValue("lastName", insertEmployeeDetail.getLastName())
				.addValue("salary", insertEmployeeDetail.getSalary())
				.addValue("address", insertEmployeeDetail.getAddress())
				.addValue("phoneNumber", insertEmployeeDetail.getPhoneNumber());

		rs = namedParameterJdbcTemplate.update(query, mapSqlParameterSource) > 0;
		return rs;
	}

	public Boolean insertEmployeeBeanPropertySource(EmployeeDetail insertEmployeeDetail) {
		// TODO Auto-generated method stub
		boolean flag = false;
		String insertEmployeeDetails = "insert into public.employee_detail (first_name,middle_name,last_name,salary,address,phone_number)values(:firstName,:middleName,:lastName,:salary,:address,:phoneNumber)";
		flag = namedParameterJdbcTemplate.update(insertEmployeeDetails,
				new BeanPropertySqlParameterSource(insertEmployeeDetail)) > 0;

		return flag;
	}

	public Boolean updateEmployeeDetail(EmployeeDetail updatEmployeeDetail) {
		// TODO Auto-generated method stub
		boolean result = false;
		String updateEmployeeQuery = "update public.employee_detail set middle_name=:middleName where employee_id=:employeeId";
		Map<String, Object> map = new HashMap<>();
		map.put("employeeId", updatEmployeeDetail.getEmployeeId());
		map.put("middleName", updatEmployeeDetail.getMiddleName());
		result = namedParameterJdbcTemplate.update(updateEmployeeQuery, map) > 0;
		return result;
	}

	public Boolean updateEmployeeDetailMapSqlParameter(EmployeeDetail updateEmployeeDetail) {
		// TODO Auto-generated method stub
		boolean result = false;
		String updateEmployeeQuery = "update public.employee_detail set middle_name=:middleName where employee_id=:employeeId";
		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("employeeId", updateEmployeeDetail.getEmployeeId()).addValue("middleName",
				updateEmployeeDetail.getMiddleName());
		result = namedParameterJdbcTemplate.update(updateEmployeeQuery, mapSqlParameterSource) > 0;
		return result;
	}

	public Boolean updateEmployeeBeanPropertySource(EmployeeDetail updateEmployeeDetail) {
		// TODO Auto-generated method stub
		boolean result = false;
		String updateEmployeeQuery = "update public.employee_detail set middle_name=:middleName where employee_id=:employeeId";
		result = namedParameterJdbcTemplate.update(updateEmployeeQuery,
				new BeanPropertySqlParameterSource(updateEmployeeDetail)) > 0;
		return result;
	}

	public Boolean deteleEmployeeDetail(EmployeeDetail deleteemployeeDetail) {
		// TODO Auto-generated method stub
		boolean result=false;
		String deleteEmployeeQuery="delete from employee_detail where employee_id=:employeeId";
		result=namedParameterJdbcTemplate.update(deleteEmployeeQuery, );
		return null;
	

}
