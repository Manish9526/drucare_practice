package com.Company_Employee.EmpService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Company_Employee.Bean.EmployeeRefBean;
import com.Company_Employee.EmpDao.EmpDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	@Autowired
	private EmpDao empDao;



	@Override
	public Boolean insertOrUpdateEmpList(List<EmployeeRefBean> insertEmp) {
		
		return empDao.insertOrUpdateEmpList(insertEmp);
	}
	
}
