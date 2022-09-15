package com.Employee.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Model.EmployeeDetail;
import com.Employee.service.ServiceImpl;

@RestController
public class EmployeeController {

	@Autowired
	private ServiceImpl serviceImpl;

	@PostMapping("/insert")
	public Boolean insertEmployeeMap(@RequestBody EmployeeDetail insertEmployeeDetail) {
		return serviceImpl.insertEmployeeMap(insertEmployeeDetail);
	}

	@PostMapping("/insertByUsingMapSql")
	public Boolean inserEmployeeMapSqlParameter(@RequestBody EmployeeDetail insertEmployeeDetail) {
		return serviceImpl.insertEmployeeMapSqlParameter(insertEmployeeDetail);
	}

	@PostMapping("/insertBeanPropertySource")
	public Boolean insertEmployeeBeanPropertySource(@RequestBody EmployeeDetail insertEmployeeDetail) {
		return serviceImpl.insertEmployeeBeanPropertySource(insertEmployeeDetail);
	}

	@PutMapping("/update")
	public Boolean updateEmployeeDetail(@RequestBody EmployeeDetail updatEmployeeDetail) {
		return serviceImpl.updateEmployeeDetail(updatEmployeeDetail);
	}

	@PutMapping("/updateByusingMapSql")
	public Boolean updateEmployeeDetailMapSqlParameter(@RequestBody EmployeeDetail updateEmployeeDetail) {
		return serviceImpl.updateEmployeeDetailMapSqlParameter(updateEmployeeDetail);
	}
	
	@PutMapping("/updateBeanPropertySource")
	public Boolean updateEmployeeBeanPropertySource(@RequestBody EmployeeDetail updateEmployeeDetail) {
		return serviceImpl.updateEmployeeBeanPropertySource(updateEmployeeDetail);
	}
	
	@DeleteMapping("/delete")
	public Boolean deleteEmployeeDetail(@RequestBody EmployeeDetail deleteemployeeDetail) {
		return serviceImpl.deteleEmployeeDetail(deleteemployeeDetail);
	}
}
