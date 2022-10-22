	package com.EmployeeDeatil.Service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EmployeeDeatil.empBean.DeptBean;
import com.EmployeeDeatil.empBean.DesignationBean;
import com.EmployeeDeatil.empBean.EmployeeDeatilBean;
import com.EmployeeDeatil.empBean.EmployeeDeptXref;
import com.EmployeeDeatil.empBean.EmployeeDesignationXRef;
import com.EmployeeDeatil.empBean.FetchEmpName;
import com.EmployeeDeatil.empBean.FetchEmployeeNameByEmpIdRes;
import com.EmployeeDeatil.employeeDao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;


	@Override
	public Boolean insertEmpDeatil(EmployeeDeatilBean insertEmployeeDetail) {
		Long empId = employeeDao.insertEmpDeatil(insertEmployeeDetail);
		Boolean flag = false;
		if (CollectionUtils.isNotEmpty(insertEmployeeDetail.getDeptList())) {
			flag = employeeDao.insertEmployeeDepartmentsRef(insertEmployeeDetail.getDeptList(), empId);
		}

		if (CollectionUtils.isNotEmpty(insertEmployeeDetail.getDesignationList())) {

			flag = employeeDao.insertEmployeeDesignationRef(insertEmployeeDetail.getDesignationList(), empId);

		}

		return flag;
	}


	
	@Override
	public Boolean insertEmployeesDetails(List<EmployeeDeatilBean> listInsertEmplooyeesDetails) {

		Boolean flag = false;

		for (EmployeeDeatilBean employeeDeatilObj : listInsertEmplooyeesDetails) {
			Long empId = employeeDao.insertEmployeesDetails(employeeDeatilObj);

			if (CollectionUtils.isNotEmpty(employeeDeatilObj.getDeptList())) {
				flag = employeeDao.insertEmployeesDepartments(employeeDeatilObj.getDeptList(), empId);
			}
			if (CollectionUtils.isNotEmpty(employeeDeatilObj.getDesignationList())) {
				flag = employeeDao.insertEmployeesDesigantions(employeeDeatilObj.getDesignationList(), empId);
			}

		}
		return flag;
	}

	
	
	
	@Override
	public String fetchEmpNameByUsingQueryforObjectString(FetchEmpName fetchEmpName) {
	
		return employeeDao.fetchEmpNameByUsingQueryforObjectString(fetchEmpName);
	}

	@Override
	public EmployeeDeatilBean fetchEmployeeNameByEmpIdRes(
			FetchEmployeeNameByEmpIdRes fetchEmployeeNameByEmpId) {
		
		return employeeDao.fetchEmployeeNameByEmpIdRes(fetchEmployeeNameByEmpId);
	}

	@Override
	public List<EmployeeDeatilBean> fetchEmpDetailByEmpIdRes(EmployeeDeatilBean fetchEmployeeNameByEmpIdRes) {
		return employeeDao.fetchEmpDetailByEmpIdRes(fetchEmployeeNameByEmpIdRes);
	}



	@Override
	public List<EmployeeDeatilBean> fetchEmpDetailByUsingDynamicQuery(EmployeeDeatilBean fetchAllEmpDetail) {
		
		return employeeDao.fetchEmpDetailByUsingDynamicQuery(fetchAllEmpDetail);
	}

	@Override
	public List<EmployeeDeatilBean> fetchEmpDetailForUsingQuery(EmployeeDeatilBean fetachEmpDetailQuery) {
	
		return employeeDao.fetchEmpDetailForUsingQuery(fetachEmpDetailQuery);
	}

	@Override
	public List<FetchEmployeeNameByEmpIdRes> fetchEmpDetailDynamicQuery(EmployeeDeatilBean fetchEmpDetail) {
		
		return employeeDao.fetchEmpDetailDynamicQuery(fetchEmpDetail);
	}	
	@Override
	public Boolean insertOrUpdateEmpDetail(List<EmployeeDeatilBean> insertEmployeeDetail) {
		
		Boolean flag= false;
		for(EmployeeDeatilBean employeeDetailObj:insertEmployeeDetail) {
			if(employeeDetailObj.getEmpId()==null) {
				flag=employeeDao.insertemployeeDetailRef(employeeDetailObj);
			}
			else {
				flag=employeeDao.updateEmployeeDetailRef(employeeDetailObj);
			}
			for(EmployeeDeptXref employeedeptXrefObj:employeeDetailObj.getDeptXrefsList()) {
				if(employeedeptXrefObj.getEmpDeptId()==null) {
					flag=employeeDao.insertDeptXref(employeedeptXrefObj);
				}
				else {
					flag=employeeDao.updateDeptXref(employeedeptXrefObj);
				}
			}
			for(EmployeeDesignationXRef employeeDesignationXRefObj:employeeDetailObj.getDesignationXRefsList()) {
				if(employeeDesignationXRefObj.getEmployeeDesignationId()==null) {
					flag=employeeDao.insertDesignation(employeeDesignationXRefObj);
				}
				else {
					flag=employeeDao.updateDesignationRef(employeeDesignationXRefObj);
				}
			}
		}
		
		return flag;
	}



	@Override
	public Boolean updateEmployeeDetail(EmployeeDeatilBean updateEmpDetail) {

		return employeeDao.updateEmployeeDetail(updateEmpDetail);
	}



	@Override
	public Boolean updateDeptarment(DeptBean updateEmpDept) {

		return employeeDao.updateDeptarment(updateEmpDept);
	}



	@Override
	public Boolean updateDesignation(DesignationBean updateEmpdesigantion) {

		return employeeDao.updateDesignation(updateEmpdesigantion);
	}

	
}
