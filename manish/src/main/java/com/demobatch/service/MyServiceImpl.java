package com.demobatch.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demobatch.MyDao.MyDao;
import com.demobatch.bean.EmployeeDetail;

@Service
public class MyServiceImpl implements MyServices {

	@Autowired
	MyDao mydao;

	@Override
	public Boolean insertEmployee(List<EmployeeDetail> insertdetail) {

		Boolean flag = false;
		for (EmployeeDetail employeeObj : insertdetail) {

			Long empId = mydao.insertEmployeeDetails(employeeObj);

			if (CollectionUtils.isNotEmpty(employeeObj.getDeptList())) {
				flag = mydao.insertDeptList(employeeObj.getDeptList(), empId);
			}
			if (CollectionUtils.isNotEmpty(employeeObj.getDesignationList())) {
				flag = mydao.insertDesignationList(employeeObj.getDesignationList(), empId);
			}
		}

		return flag;
	}

	@Override
	public Boolean insertEmployeesDetails(List<EmployeeDetail> insertEmpDetails) {
		
		Boolean flag=false;
		for (EmployeeDetail employeedetailObj : insertEmpDetails) {
			
			Long empId = mydao.insertEmpDetails(employeedetailObj);

			if (CollectionUtils.isNotEmpty(employeedetailObj.getDeptList())) {
				flag = mydao.insertDepartments(employeedetailObj.getDeptList(), empId);
			}

			if (CollectionUtils.isNotEmpty(employeedetailObj.getDesignationList())) {
				flag = mydao.insertDesignations(employeedetailObj.getDesignationList(), empId);
			}
		}

		return flag;
	}

}

