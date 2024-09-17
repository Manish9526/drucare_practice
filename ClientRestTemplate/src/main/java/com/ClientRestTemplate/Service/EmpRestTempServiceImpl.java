package com.ClientRestTemplate.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ClientRestTemplate.Bean.EmployeeDetailRef;
import com.ClientRestTemplate.Bean.FetchEmpDetail;

@Service
public class EmpRestTempServiceImpl implements EmpService {

	@Autowired
	private RestTemplate restTemplate;

	private static final String INSERT_EMPLOYEE_URL = "http://localhost:8080/insertEmp";
	private static final String INSERT_EMPLOYEE_DETAIL_LIST_URL = "http://localhost:8080/insertEmpList";
	private static final String UPDATE_EPLOYEE_DETAIL_URL = "http://localhost:8080/updateEmp";

	@Override
	public Boolean insertEmploye(EmployeeDetailRef employeeDetailRef) {

		return restTemplate.postForObject(INSERT_EMPLOYEE_URL, employeeDetailRef, Boolean.class);
	}

	@Override
	public Boolean insertEmpDetailsList(List<EmployeeDetailRef> insertEmpDetailList) {

		return restTemplate.postForObject(INSERT_EMPLOYEE_DETAIL_LIST_URL, insertEmpDetailList, Boolean.class);
	}

	@Override
	public Boolean updateEmployee(EmployeeDetailRef updateEmp) {
		restTemplate.put(UPDATE_EPLOYEE_DETAIL_URL, updateEmp, boolean.class);
		return true;
	}

	
	@Override
	public EmployeeDetailRef fetchEmpDetailByUsingMap(FetchEmpDetail fetchEmpDetailByMap) {
		
		return restTemplate.postForObject("http://localhost:8080/fetchempNamebyempIdUsingMap", fetchEmpDetailByMap,
				EmployeeDetailRef.class);
	}

	@Override
	public List<EmployeeDetailRef> fetchEmpUsingdetailList(EmployeeDetailRef fetchEmpById) {
		EmployeeDetailRef[] empArray = restTemplate.postForObject("http://localhost:8080/fetchEmpList", fetchEmpById,
				EmployeeDetailRef[].class);
		List<EmployeeDetailRef> employees = Arrays.asList(empArray);
		return employees;
	}
	
	@Override
	public String fetchEmpDetail(EmployeeDetailRef fetchEmployee) {

		return restTemplate.postForObject("http://localhost:8080/FetchEmpDetilByUsingObject", fetchEmployee, String.class);
	}

	@Override
	public Boolean deleteEmpDetailByEmpID(EmployeeDetailRef deleteEmpDetail) {
		
		return restTemplate.postForObject("http://localhost:8080/deleteEmpDetil", deleteEmpDetail, Boolean.class);
	}


}
