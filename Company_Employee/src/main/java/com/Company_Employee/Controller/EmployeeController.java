package com.Company_Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Company_Employee.Bean.EmployeeRefBean;
import com.Company_Employee.EmpService.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	
	@PostMapping("/insertEmployeelist")
	public Boolean insertOrUpdateEmpList(@RequestBody List<EmployeeRefBean> insertEmp) {
		return service.insertOrUpdateEmpList(insertEmp);
	}
}
