package com.Company_Employee.EmpDao;

import java.util.List;

import com.Company_Employee.Bean.EmployeeRefBean;

public interface EmpDao {

	Boolean insertOrUpdateEmpList(List<EmployeeRefBean> insertEmp);

}
