package com.Company_Employee.EmpService;

import java.util.List;

import com.Company_Employee.Bean.EmployeeRefBean;


public interface EmployeeService {


	Boolean insertOrUpdateEmpList(List<EmployeeRefBean> insertEmp);

}
