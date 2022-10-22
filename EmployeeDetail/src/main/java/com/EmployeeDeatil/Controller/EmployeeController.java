package com.EmployeeDeatil.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.EmployeeDeatil.Service.EmployeeService;
import com.EmployeeDeatil.empBean.DeptBean;
import com.EmployeeDeatil.empBean.DesignationBean;
import com.EmployeeDeatil.empBean.EmployeeDeatilBean;
import com.EmployeeDeatil.empBean.FetchEmpName;
import com.EmployeeDeatil.empBean.FetchEmployeeNameByEmpIdRes;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;



	@RequestMapping(value = "/insertEmployeeDetail", method = RequestMethod.POST)
	public Boolean insertEmpDeatil(@RequestBody EmployeeDeatilBean insertEmployeeDetail) {
		return service.insertEmpDeatil(insertEmployeeDetail);
	}

//	@PutMapping("/updatEmployeeDetail")

	@RequestMapping(value = "/updatEmployeeDetail", method = RequestMethod.PUT)
	public Boolean updateEmployeeDetail(@RequestBody EmployeeDeatilBean updateEmpDetail) {
		return service.updateEmployeeDetail(updateEmpDetail);
	}

//	@PutMapping("/updateDeparment")
	@RequestMapping(value = "/updateDeparment", method = RequestMethod.PUT)
	public Boolean updateDeptarment(@RequestBody DeptBean updateEmpDept) {
		return service.updateDeptarment(updateEmpDept);
	}

//	@PutMapping("/updateDesignation")

	@RequestMapping(value = "/updateDesignation", method = RequestMethod.PUT)
	public Boolean updateDesignation(@RequestBody DesignationBean updateEmpdesigantion) {
		return service.updateDesignation(updateEmpdesigantion);
	}

//	insert multiple Employee Detail (list of employee) 
//	@PostMapping("/insertEmplist")

	@RequestMapping(value = "/insertEmplist", method = RequestMethod.POST)
	public Boolean insertEmployeesDetails(@RequestBody List<EmployeeDeatilBean> insertEmplooyeesDetails) {
		return service.insertEmployeesDetails(insertEmplooyeesDetails);
	}

//	fetch Employee Detail by using query for object


	@RequestMapping(value = "/fetchEmpNameByUsingQueryForObject", method = RequestMethod.GET)
	public String fetchEmpNameByUsingQueryforObjectString(@RequestBody FetchEmpName fetchEmpName) {
		return service.fetchEmpNameByUsingQueryforObjectString(fetchEmpName);
	}

//	fetch employeeDetail By using Query for Map

	
	@RequestMapping(value = "/fetchEmpDetailByUsingQueryForMap", method = RequestMethod.GET)
	public EmployeeDeatilBean fetchEmployeeNameByEmpIdRes(
			@RequestBody FetchEmployeeNameByEmpIdRes fetchEmployeeNameByEmpId) {
		return service.fetchEmployeeNameByEmpIdRes(fetchEmployeeNameByEmpId);
	}

//	Fetch Employee detail BY using Query for List

	@RequestMapping(value = "/fetchEmpDetailByUsingQueryForList", method = RequestMethod.GET)
	public List<EmployeeDeatilBean> fetchEmpDetailByEmpIdRes(
			@RequestBody EmployeeDeatilBean fetchEmployeeNameByEmpIdRes) {
		return service.fetchEmpDetailByEmpIdRes(fetchEmployeeNameByEmpIdRes);
	}

//	Fetch Employee Detail using Dynamic Query 
//	@GetMapping("/DyanamicQueryForFetch")

	@RequestMapping(value = "/DyanamicQueryForFetch", method = RequestMethod.GET)
	public List<EmployeeDeatilBean> fetchEmpDetailByUsingDynamicQuery(
			@RequestBody EmployeeDeatilBean fetchAllEmpDetail) {
		return service.fetchEmpDetailByUsingDynamicQuery(fetchAllEmpDetail);
	}

//	Fetch employee detail by using Query(jdbc template)
//	@GetMapping ("/fetchEmpDetailForUsingQuery")

	@RequestMapping(value = "/fetchEmpDetailForUsingQuery", method = RequestMethod.GET)
	public List<EmployeeDeatilBean> fetchEmpDetailForUsingQuery(@RequestBody EmployeeDeatilBean fetachEmpDetailQuery) {
		return service.fetchEmpDetailForUsingQuery(fetachEmpDetailQuery);
	}

//	Fetch Employee Detail by using SQL parameter Source Properties
//	@GetMapping("/fetchEmpDynamicQuery")

	@RequestMapping(value = "/fetchEmpDynamicQuery", method = RequestMethod.GET)
	public List<FetchEmployeeNameByEmpIdRes> fetchEmpDetailDynamicQuery(
			@RequestBody EmployeeDeatilBean fetchEmpDetail) {
		return service.fetchEmpDetailDynamicQuery(fetchEmpDetail);
	}

//	Insert and update Employee detail in one Api
//	@PostMapping("/insertAndUpdate")

	@RequestMapping(value = "/insertAndUpdate", method = RequestMethod.POST)
	public Boolean insertOrUpdateEmpDetail(@RequestBody List<EmployeeDeatilBean> insertEmployeeDetail) {
		return service.insertOrUpdateEmpDetail(insertEmployeeDetail);
	}
}

