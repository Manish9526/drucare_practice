package com.EmployeeDeatil.employeeDao;

import java.util.List;

import com.EmployeeDeatil.empBean.DeptBean;
import com.EmployeeDeatil.empBean.DesignationBean;
import com.EmployeeDeatil.empBean.EmployeeDeatilBean;
import com.EmployeeDeatil.empBean.EmployeeDeptXref;
import com.EmployeeDeatil.empBean.EmployeeDesignationXRef;
import com.EmployeeDeatil.empBean.FetchEmployeeNameByEmpIdRes;
import com.EmployeeDeatil.empBean.FetchEmpName;

public interface EmployeeDao {

	Long insertEmpDeatil(EmployeeDeatilBean insertEmployeeDetail);

	Boolean insertEmployeeDepartmentsRef(List<DeptBean> deptList, Long empId);

	Boolean insertEmployeeDesignationRef(List<DesignationBean> designationList, Long empId);

	Long insertEmployeesDetails(EmployeeDeatilBean employeeDeatilObj);

	Boolean insertEmployeesDepartments(List<DeptBean> deptList, Long empId);

	Boolean insertEmployeesDesigantions(List<DesignationBean> designationList, Long empId);

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

	Boolean insertemployeeDetailRef(EmployeeDeatilBean employeeDetailObj);

	Boolean updateEmployeeDetailRef(EmployeeDeatilBean employeeDetailObj);

	Boolean insertDeptXref(EmployeeDeptXref employeedeptXrefObj);

	Boolean updateDeptXref(EmployeeDeptXref employeedeptXrefObj);

	Boolean insertDesignation(EmployeeDesignationXRef employeeDesignationXRefObj);

	Boolean updateDesignationRef(EmployeeDesignationXRef employeeDesignationXRefObj);



}
