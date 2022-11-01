package com.demobatch.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demobatch.bean.EmployeeDetail;
import com.demobatch.service.MyServices;

@Configuration
@RestController
public class myController {

	@Autowired
	MyServices EmployeeDetail;
	
	//Batch update use nameparameter 
	@PostMapping ("/insertEmployee")
	public Boolean insertEmployee(@RequestBody List<EmployeeDetail> insertdetail) {
		return EmployeeDetail.insertEmployee(insertdetail);
	}
	
	//Batch update the useing jdbc template.
	@PostMapping ("/insertEmployeeUsingBatchUpdate")
	public Boolean insertEmployeesDetails(@RequestBody List<EmployeeDetail> insertEmpDetails ) {
		return EmployeeDetail.insertEmployeesDetails(insertEmpDetails);
	}
	
	
	
}
