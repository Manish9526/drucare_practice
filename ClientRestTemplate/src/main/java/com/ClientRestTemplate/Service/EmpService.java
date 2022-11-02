package com.ClientRestTemplate.Service;

import java.util.List;

import com.ClientRestTemplate.Bean.EmployeeDetailRef;
import com.ClientRestTemplate.Bean.FetchEmpDetail;

public interface EmpService {

	Boolean insertEmploye(EmployeeDetailRef employeeDetailRef);

	Boolean updateEmployee(EmployeeDetailRef updateEmp);

	Boolean insertEmpDetailsList(List<EmployeeDetailRef> insertEmpDetailList);

	String fetchEmpDetail(EmployeeDetailRef fetchEmployee);

	EmployeeDetailRef fetchEmpDetailByUsingMap(FetchEmpDetail fetchEmpDetailByMap);

	List<EmployeeDetailRef> fetchEmpUsingdetailList(EmployeeDetailRef fetchEmpById);

	Boolean deleteEmpDetailByEmpID(EmployeeDetailRef deleteEmpDetail);

}
