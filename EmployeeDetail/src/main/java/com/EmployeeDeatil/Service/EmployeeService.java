package com.EmployeeDeatil.Service;

import java.util.List;

import com.EmployeeDeatil.empBean.DeptBean;
import com.EmployeeDeatil.empBean.DesignationBean;
import com.EmployeeDeatil.empBean.EmployeeDeatilBean;
import com.EmployeeDeatil.empBean.FetchEmployeeNameByEmpIdRes;
import com.EmployeeDeatil.empBean.InsertAndupdateEmpList;
import com.EmployeeDeatil.empBean.FetchEmpName;

public interface EmployeeService {

	Boolean insertEmpDeatil(EmployeeDeatilBean insertEmployeeDetail);

	Boolean insertEmployeesDetails(List<EmployeeDeatilBean> insertEmplooyeesDetails);

	String fetchEmpNameByUsingQueryforObjectString(FetchEmpName fetchEmpName);

	EmployeeDeatilBean fetchEmployeeNameByEmpIdRes(FetchEmployeeNameByEmpIdRes fetchEmployeeNameByEmpId);

	List<EmployeeDeatilBean> fetchEmpDetailByEmpIdRes(EmployeeDeatilBean fetchEmployeeNameByEmpIdRes);

	List<EmployeeDeatilBean> fetchEmpDetailByUsingDynamicQuery(EmployeeDeatilBean fetchAllEmpDetail);

	List<EmployeeDeatilBean> fetchEmpDetailForUsingQuery(EmployeeDeatilBean fetachEmpDetailQuery);

	List<FetchEmployeeNameByEmpIdRes> fetchEmpDetailDynamicQuery(EmployeeDeatilBean fetchEmpDetail);

	Boolean insertOrUpdateEmpDetail(List<EmployeeDeatilBean> insertEmployeeDetail);

	Boolean updateEmployeeDetail(EmployeeDeatilBean updateEmpDetail);

	Boolean updateDeptarment(DeptBean updateEmpDept);

	Boolean updateDesignation(DesignationBean updateEmpdesigantion);

	Boolean insertAndUpdadteUsingBatchUpdate(List<InsertAndupdateEmpList> insertAndUpdateEmpDetail);

}
