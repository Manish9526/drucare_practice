package com.demobatch.service;

import java.util.List;

import com.demobatch.bean.EmployeeDetail;


public interface MyServices {

	Boolean insertEmployee(List<EmployeeDetail> insertdetail);

	Boolean insertEmployeesDetails(List<EmployeeDetail> insertEmpDetails);

}
