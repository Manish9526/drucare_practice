package com.ClientRestTemplate.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ClientRestTemplate.Bean.EmployeeDetailRef;
import com.ClientRestTemplate.Bean.FetchEmpDetail;
import com.ClientRestTemplate.Service.EmpService;

@RestController
public class RestTemplateController {

	@Autowired
	private EmpService Service;

	@PostMapping("/insertEmpDetail")
	public Boolean insertEmployee(@RequestBody EmployeeDetailRef employeeDetailRef) {

		return Service.insertEmploye(employeeDetailRef);
	}

	@PostMapping("insertEmployeeDetailList")
	public Boolean insertEmpDetailsList(@RequestBody List<EmployeeDetailRef> insertEmpDetailList) {
		return Service.insertEmpDetailsList(insertEmpDetailList);
	}

	@PostMapping("/updateEmpById")
	public Boolean updateEmployee(@RequestBody EmployeeDetailRef updateEmp) {
		return Service.updateEmployee(updateEmp);
	}

	@PostMapping("/fetchEmpDetailByUsingMap")
	public EmployeeDetailRef fetchEmpDetailByUsingMap(@RequestBody FetchEmpDetail fetchEmpDetailByMap) {
		return Service.fetchEmpDetailByUsingMap(fetchEmpDetailByMap);
	}

	@PostMapping("/fetchEmpByquery")
	public String fetchEmpDetail(@RequestBody EmployeeDetailRef fetchEmployee) {
		return Service.fetchEmpDetail(fetchEmployee);
	}
	
	@PostMapping("/fetchEmployeesByUsingList")
	public List<EmployeeDetailRef> fetchEmpUsingdetailList(@RequestBody EmployeeDetailRef fetchEmpById) {
		return Service.fetchEmpUsingdetailList(fetchEmpById);
	}
	
	@PostMapping("/deleteEmployeeByEmpID")
	public Boolean deleteEmpDetailByEmpID(@RequestBody EmployeeDetailRef deleteEmpDetail) {
		return Service.deleteEmpDetailByEmpID(deleteEmpDetail);
	}
}
