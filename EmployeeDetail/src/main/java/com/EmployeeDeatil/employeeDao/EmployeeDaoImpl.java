package com.EmployeeDeatil.employeeDao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.EmployeeDeatil.empBean.DeptBean;
import com.EmployeeDeatil.empBean.DesignationBean;
import com.EmployeeDeatil.empBean.EmployeeDeatilBean;
import com.EmployeeDeatil.empBean.EmployeeDeptXref;
import com.EmployeeDeatil.empBean.EmployeeDesignationXRef;
import com.EmployeeDeatil.empBean.FetchEmpName;
import com.EmployeeDeatil.empBean.FetchEmployeeNameByEmpIdRes;
import com.EmployeeDeatil.empBean.InsertAndupdateEmpList;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

					////////////////////////////////////////////////
				    //                                            //
				    // insert EmployeeDetail using the list       //
					//     using in jdbc                          //
					////////////////////////////////////////////////	
	@Override
	public Long insertEmployeesDetails(EmployeeDeatilBean insertEmployeeDetails) {
		// insert EmployeeDetail using the list.(data is inserted )

		long empId = 0;

		String queryForInsertEmployeesDetails = "insert into employee_detail_ref(first_nm,middle_nm,last_nm,emp_email,phone_no,mobile_no,address,address_line1,org_id,city_nm,district_nm,country_nm,pin_code,salary,experience,qualification)"
				+ " values(:firstNm,:middleNm,:lastNm,:empEmail,:phoneNo,:mobileNo,:address,:addressLine1,:orgId,:cityNm,:districtNm,:countryNm,:pinCode,:salary,:experience,:qualification)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		try {
			namedParameterJdbcTemplate.update(queryForInsertEmployeesDetails,
					new BeanPropertySqlParameterSource(insertEmployeeDetails), keyHolder, new String[] { "emp_id" });

			empId = keyHolder.getKey().longValue();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empId;
	}

						////////////////////////////////////////////////
					    //                                            //
					    // insert department using the batchupdate      //
						//     using in jdbc                          //
						////////////////////////////////////////////////

	@Override
	public Boolean insertEmployeesDepartments(List<DeptBean> deptList, Long empId) {

		String queryForInsertEmpDepartments = "insert into employee_dept_xref (emp_id,dept_id) values (?,?)";

		int[] count = jdbcTemplate.batchUpdate(queryForInsertEmpDepartments, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				DeptBean deptBeanObj = deptList.get(i);
				ps.setLong(1, empId);
				ps.setLong(2, deptBeanObj.getDeptId());
			}

			@Override
			public int getBatchSize() {
				return deptList.size();
			}
		});
		return count.length == deptList.size();

	}

						////////////////////////////////////////////////
					    //                                            //
					    // insert designation using the batchupdate   //
						//     using in jdbc                          //
						////////////////////////////////////////////////

	@Override
	public Boolean insertEmployeesDesigantions(List<DesignationBean> designationList, Long empId) {
		
		String queryForInsertEmpDesignations = "insert into employee_designations_xref (emp_id,designation_id)values(?,?)";

		int[] count = jdbcTemplate.batchUpdate(queryForInsertEmpDesignations, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				DesignationBean designationBeanObj = designationList.get(i);
				ps.setLong(1, empId);
				ps.setLong(2, designationBeanObj.getDesignationId());
			}

			@Override
			public int getBatchSize() {

				return designationList.size();
			}
		});
		return count.length == designationList.size();
	}

				   ////////////////////////////////////////////////
			       //                                            //
			       // fetch the data Using Query for Object      //
				   //                                            //
				   ////////////////////////////////////////////////

	@Override
	public String fetchEmpNameByUsingQueryforObjectString(FetchEmpName fetchEmpName) {

		String empNm = null;
		try {
			String queryForFetchEmpNameByUsingEmpId = "select concat(first_nm,' ',middle_nm,' ',last_nm)from public.employee_detail_ref where emp_id = :empId ";

			empNm = namedParameterJdbcTemplate.queryForObject(queryForFetchEmpNameByUsingEmpId,
					new BeanPropertySqlParameterSource(fetchEmpName), String.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return empNm;
	}
          
				   ////////////////////////////////////////////////
			       //                                            //
			       // Fetch the data Using the Query for Map     //
				   //                                            //
				   ////////////////////////////////////////////////
	
	@Override
	public EmployeeDeatilBean fetchEmployeeNameByEmpIdRes(FetchEmployeeNameByEmpIdRes fetchEmployeeNameByEmpId) {

		EmployeeDeatilBean fetchEmployeeNameByEmpIdRes = new EmployeeDeatilBean();

		String queryFroEmpNameByEmpIDUsingMap = "select first_nm,middle_nm,last_nm from employee_detail_ref where emp_id = :empId";
		Map<String, Object> map = namedParameterJdbcTemplate.queryForMap(queryFroEmpNameByEmpIDUsingMap,
				new BeanPropertySqlParameterSource(fetchEmployeeNameByEmpId));
		fetchEmployeeNameByEmpIdRes.setFirstNm((String) map.get("first_nm"));
		fetchEmployeeNameByEmpIdRes.setFirstNm((String) map.get("middle_nm"));
		fetchEmployeeNameByEmpIdRes.setFirstNm((String) map.get("last_nm"));
		return fetchEmployeeNameByEmpIdRes;
	}
	
				     ///////////////////////////////////////////////
					 //                                           //
					 // fetch the data Using the Query for list   //
					 //                                           //
					 ///////////////////////////////////////////////
	@Override
	public List<EmployeeDeatilBean> fetchEmpDetailByEmpIdRes(EmployeeDeatilBean fetchEmployeeNameByEmpIdRes) {
		String queryForListUsingEmpId = "select emp_id,first_nm,middle_nm,last_nm,phone_no,emp_email,phone_no,mobile_no,address,address_line1,city_nm,district_nm,country_nm,pin_code,salary,experience,qualification,emp_age,org_id from employee_detail_ref where org_id = :orgId";

		List<EmployeeDeatilBean> employeeDetailList = new ArrayList<>();
		List<Map<String, Object>> rows = namedParameterJdbcTemplate.queryForList(queryForListUsingEmpId,
				new BeanPropertySqlParameterSource(fetchEmployeeNameByEmpIdRes));

		if (CollectionUtils.isNotEmpty(rows)) {

			for (Map<String, Object> row : rows) {
				fetchEmployeeNameByEmpIdRes.setEmpId((Long) row.get("emp_id"));
				fetchEmployeeNameByEmpIdRes.setFirstNm((String) row.get("first_nm"));
				fetchEmployeeNameByEmpIdRes.setMiddleNm((String) row.get("middle_nm"));
				fetchEmployeeNameByEmpIdRes.setLastNm((String) row.get("last_nm"));
				fetchEmployeeNameByEmpIdRes.setEmpEmail((String) row.get("emp_email"));
				fetchEmployeeNameByEmpIdRes.setPhoneNo((String) row.get("phone_no"));
				fetchEmployeeNameByEmpIdRes.setMobileNo((String) row.get("mobile_no"));
				fetchEmployeeNameByEmpIdRes.setAddress((String) row.get("address"));
				fetchEmployeeNameByEmpIdRes.setAddressLine1((String) row.get("address_line1"));
				fetchEmployeeNameByEmpIdRes.setCityNm((String) row.get("city_nm"));
				fetchEmployeeNameByEmpIdRes.setDistrictNm((String) row.get("district_nm"));
				fetchEmployeeNameByEmpIdRes.setCountryNm((String) row.get("country_nm"));
				fetchEmployeeNameByEmpIdRes.setPinCode((Integer) row.get("pin_code"));
				fetchEmployeeNameByEmpIdRes.setSalary((Double) row.get("salary"));
				fetchEmployeeNameByEmpIdRes.setExperience((String) row.get("experience"));
				fetchEmployeeNameByEmpIdRes.setQualification((String) row.get("qualification"));
				fetchEmployeeNameByEmpIdRes.setEmpAge((Integer) row.get("emp_age"));
				fetchEmployeeNameByEmpIdRes.setOrgId((Long) row.get("org_id"));

				employeeDetailList.add(fetchEmployeeNameByEmpIdRes);
			}
			
		}
		return employeeDetailList.stream().filter(f-> f.getFirstNm().equals("manish")).collect(Collectors.toList());
	}

				///////////////////////////////////////////////
				//                                           //
				//	fetch Employee detail by dynamic query   //
				//                                           //	
				///////////////////////////////////////////////

	@Override
	public List<EmployeeDeatilBean> fetchEmpDetailByUsingDynamicQuery(EmployeeDeatilBean fetchAllEmpDetail) {
		// normal query
		// String queryForAllEmpDetail = "select
		// first_nm,middle_nm,last_nm,phone_no,emp_email,mobile_no,address,address_line1,city_nm,district_nm,country_nm,pin_code,salary,experience,qualification,emp_age,org_id
		// from employee_detail_ref where emp_id = :empId ";

		// query for limit and offset
		String queryForAllEmpDetail = "select first_nm,middle_nm,last_nm,phone_no,emp_email,mobile_no,address,address_line1,city_nm,district_nm,country_nm,pin_code,salary,experience,qualification,emp_age,org_id from employee_detail_ref where phone_no = :phoneNo"; //limit 3  offset 5";

		StringBuilder query = new StringBuilder(queryForAllEmpDetail);

		List<EmployeeDeatilBean> employeeDetailList = new ArrayList<>();

		if (StringUtils.isNotBlank(fetchAllEmpDetail.getFirstNm())) {
			query.append(" AND first_nm ilike '%'||:firstNm ||'%' ");
		}
		if (StringUtils.isNotBlank(fetchAllEmpDetail.getCityNm())) {
			query.append(" AND city_nm ilike '%'||:cityNm ||'%' ");
		}
		if (StringUtils.isNotBlank(fetchAllEmpDetail.getPhoneNo())) {
			query.append(" AND  phone_no = :phoneNo  ");
		}
		if (StringUtils.isNotBlank(fetchAllEmpDetail.getDistrictNm())) {
			query.append(" AND district_nm ilike '%' || :districtNm || '%'");
		}
		if (StringUtils.isNotBlank(fetchAllEmpDetail.getEmpEmail())) {
			query.append(" AND emp_eamil ilike '%' || :empEmail ||'%'");
		}

		List<Map<String, Object>> rows = namedParameterJdbcTemplate.queryForList(query.toString(),
				new BeanPropertySqlParameterSource(fetchAllEmpDetail));

		if (CollectionUtils.isNotEmpty(rows)) {

			for (Map<String, Object> row : rows) {
				fetchAllEmpDetail.setFirstNm((String) row.get("first_nm"));
				fetchAllEmpDetail.setMiddleNm((String) row.get("middle_nm"));
				fetchAllEmpDetail.setLastNm((String) row.get("last_nm"));
				fetchAllEmpDetail.setEmpEmail((String) row.get("emp_email"));
				fetchAllEmpDetail.setPhoneNo((String) row.get("phone_no"));
				fetchAllEmpDetail.setMobileNo((String) row.get("mobile_no"));
				fetchAllEmpDetail.setAddress((String) row.get("address"));
				fetchAllEmpDetail.setAddressLine1((String) row.get("address_line1"));
				fetchAllEmpDetail.setCityNm((String) row.get("city_nm"));
				fetchAllEmpDetail.setDistrictNm((String) row.get("district_nm"));
				fetchAllEmpDetail.setCountryNm((String) row.get("country_nm"));
				fetchAllEmpDetail.setPinCode((Integer) row.get("pin_code"));
				fetchAllEmpDetail.setSalary((Double) row.get("salary"));
				fetchAllEmpDetail.setExperience((String) row.get("experience"));
				fetchAllEmpDetail.setQualification((String) row.get("qualification"));
				fetchAllEmpDetail.setEmpAge((Integer) row.get("emp_age"));
				fetchAllEmpDetail.setOrgId((Long) row.get("org_id"));

				employeeDetailList.add(fetchAllEmpDetail);
			}
		}
		return employeeDetailList;
	}
							////////////////////////////////////////////
							//                                        //
							//	fetch Employee detail by using Query  //
							//                                        //	
							////////////////////////////////////////////
	@Override
	public List<EmployeeDeatilBean> fetchEmpDetailForUsingQuery(EmployeeDeatilBean fetachEmpDetailQuery) {
		String queryfetchEmpDetailforUsingQuery = "select  e.emp_id,e.first_nm,e.middle_nm,e.last_nm,e.phone_no,e.emp_email,e.mobile_no,e.address,e.address_line1,e.city_nm,e.district_nm,e.country_nm,e.pin_code,e.salary,e.experience,e.qualification,e.emp_age,e.org_id,d.designation_nm  from employee_detail_ref e left join designations_ref d on e.emp_id=d.emp_id where country_nm = :countryNm";

		return  namedParameterJdbcTemplate.query(queryfetchEmpDetailforUsingQuery,
				new BeanPropertySqlParameterSource(fetachEmpDetailQuery),                 
				new BeanPropertyRowMapper<EmployeeDeatilBean>(EmployeeDeatilBean.class));
/*					
#   .stream().map(m->{
					m.setFirstNm(m.getFirstNm().toUpperCase()+" "+m.getMiddleNm().toUpperCase()+" "+m.getLastNm().toUpperCase());
					return m;
				}).collect(Collectors.toList()); // create map and concat the name with	upper case.				
#   .stream().filter(s->s.getSalary()!=35000).distinct().collect(Collectors.toList());
#	.stream().filter(s->s.getSalary()!=35000).collect(Collectors.toList());
#	.stream().filter(o->o.getFirstNm().length()<7 && o.getFirstNm().length()>5).collect(Collectors.toList());//use multiple condition
					
#	.stream().filter(f->f.getFirstNm().equals("nitin")).map(m-> {
		m.setAddress(m.getAddress()+" "+m.getCityNm()+" "+m.getDistrictNm());
		return m;
	}).collect(Collectors.toList());//using map
		
#	.stream().sorted((x,y)->x.getEmpId().compareTo(y.getEmpId())).toList();//compare the data to order/or short data		
#	.stream().distinct().toList();  // use to avoid duplicate value.
#	.stream().limit(5).toList();//pass limited number of data		
#	.stream().filter(f->f.getFirstNm().equals("nitin")).collect(Collectors.toList());// filter the data
*/
	}
						///////////////////////////////////////////////////////////////
						//                                                           //
						//  fetch employee employee detail using dynamic query       //
						//                                                           //
						///////////////////////////////////////////////////////////////
	@Override
	public List<FetchEmployeeNameByEmpIdRes> fetchEmpDetailDynamicQuery(EmployeeDeatilBean fetchEmpDetail) {

		String queryForFetchEmpDetailList = "select first_nm,count(emp_id) as EmployeeDeatil from employee_detail_ref group by (first_nm,city_nm)";
//				"select first_nm,city_nm,sum(salary) from employee_detail_ref group by (first_nm,city_nm)";
//				"select first_nm,middle_nm,last_nm,phone_no,emp_email,mobile_no,address,address_line1,city_nm,district_nm,country_nm,pin_code,experience,qualification,emp_age,org_id,sum(salary) from employee_detail_ref  group by (first_nm,middle_nm,last_nm,phone_no,emp_email,mobile_no,address,address_line1,city_nm,district_nm,country_nm,pin_code,salary,experience,qualification,emp_age,org_id)";
//				"select first_nm,city_nm,max(salary) from employee_detail_ref where city_nm=:cityNm  group by (first_nm,city_nm)";
//				"select first_nm,middle_nm,last_nm,phone_no,emp_email,mobile_no,address,address_line1,city_nm,district_nm,country_nm,pin_code,experience,qualification,emp_age,org_id,min(salary) from employee_detail_ref  group by (first_nm,middle_nm,last_nm,phone_no,emp_email,mobile_no,address,address_line1,city_nm,district_nm,country_nm,pin_code,salary,experience,qualification,emp_age,org_id)";
//				"select first_nm,middle_nm,last_nm,phone_no,emp_email,mobile_no,address,address_line1,city_nm,district_nm,country_nm,pin_code,salary,experience,qualification,emp_age,org_id from employee_detail_ref where  phone_no = :phoneNo ";

		return namedParameterJdbcTemplate.query(queryForFetchEmpDetailList,
				new BeanPropertySqlParameterSource(fetchEmpDetail),
				new BeanPropertyRowMapper<FetchEmployeeNameByEmpIdRes>(FetchEmployeeNameByEmpIdRes.class));

	}
					////////////////////////////////////////////
					//                                        //
					//  insert single employee Detail list    //
					//                                        //
					////////////////////////////////////////////
	@Override
	public Long insertEmpDeatil(EmployeeDeatilBean insertEmployeeDetail) {

		String queryForInsertEmployeeDetail = "insert into employee_detail_ref(first_nm,middle_nm,last_nm,emp_email,phone_no,mobile_no,address,address_line1,city_nm,district_nm,country_nm,pin_code,salary,experience,qualification,org_id)"
				+ " values(:firstNm,:middleNm,:lastNm,:empEmail,:phoneNo,:mobileNo,:address,:addressLine1,:cityNm,:districtNm,:countryNm,:pinCode,:salary,:experience,:qualification,:orgId)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(queryForInsertEmployeeDetail,
				new BeanPropertySqlParameterSource(insertEmployeeDetail), keyHolder, new String[] { "emp_id" });
		return keyHolder.getKey().longValue();
	}
						////////////////////////////////////////////
						//                                        //
						//  insert employee department list       //
						//                                        //
						////////////////////////////////////////////
	
	@Override
	public Boolean insertEmployeeDepartmentsRef(List<DeptBean> deptList, Long empId) {
		boolean flag = false;
		String queryForInsertEmpDepartment = "insert into employee_dept_xref (emp_id,dept_id) values (:empId,:deptId)";

		for (DeptBean deptObj : deptList) {
			MapSqlParameterSource parameters = new MapSqlParameterSource().addValue("empId", empId).addValue("deptId",
					deptObj.getDeptId());
			flag = namedParameterJdbcTemplate.update(queryForInsertEmpDepartment, parameters) > 0;
		}

		return flag;
	}

						////////////////////////////////////////////
						//                                        //
						//  insert employee Designation list      //
						//                                        //
						////////////////////////////////////////////
	@Override
	public Boolean insertEmployeeDesignationRef(List<DesignationBean> designationList, Long empId) {
		boolean flag = false;
		String queryForInsertEmpDesignation = "insert into employee_designations_xref (emp_id,designation_id,isactive)values(:empId,:designationId,true)";

		for (DesignationBean designationObj : designationList) {
			MapSqlParameterSource parameter = new MapSqlParameterSource().addValue("empId", empId)
					.addValue("designationId", designationObj.getDesignationId());
			flag = namedParameterJdbcTemplate.update(queryForInsertEmpDesignation, parameter) > 0;

		}

		return flag;
	}				
							////////////////////////////////
							//                            //
							//  update employee Detail    //
							//                            //
							////////////////////////////////

	@Override
	public Boolean updateEmployeeDetail(EmployeeDeatilBean updateEmpDetail) {
		boolean result = false;

		String queryForUpdateEmpDetail = "update employee_detail_ref set first_nm = :firstNm,middle_nm = :middleNm,last_nm = :lastNm,emp_email =:empEmail,phone_no=:phoneNo,mobile_no=:mobileNo,address=:address,address_line1=:addressLine1,org_id=:orgId,city_nm=:cityNm,district_nm=:districtNm,country_nm=:countryNm,pin_code=:pinCode,salary=:salary,experience =:experience,qualification=:qualification where emp_id = :empId";

		result = namedParameterJdbcTemplate.update(queryForUpdateEmpDetail,
				new BeanPropertySqlParameterSource(updateEmpDetail)) > 0;
		return result;
	}
							////////////////////////////////
							//                            //
							//  update department         //
							//                            //
							////////////////////////////////	 
	@Override
	public Boolean updateDeptarment(DeptBean updateEmpDept) {
		String queryForUpdateEmpDepartment = "update department_ref set dept_nm= :deptNm where dept_id = :deptId";

		return namedParameterJdbcTemplate.update(queryForUpdateEmpDepartment,
				new BeanPropertySqlParameterSource(updateEmpDept)) > 0;
	}
							////////////////////////////////
							//                            //
							//  update designation        //
							//                            //
							////////////////////////////////	 
	@Override
	public Boolean updateDesignation(DesignationBean updateEmpdesigantion) {
		String queryForUpdateEmpDesignation = "update designation_ref set designation_nm = :designationNm where designation_id =:designationId ";
		return namedParameterJdbcTemplate.update(queryForUpdateEmpDesignation,
				new BeanPropertySqlParameterSource(updateEmpdesigantion)) > 0;
	}
							//////////////////////////////////////////
							//                                      //
							//  insert or update Employee detail    //
							//                                      //
							//////////////////////////////////////////	 

	@Override
	public Boolean insertOrUpdateEmpDetail(List<EmployeeDeatilBean> insertEmployeeDetail) {
		Long employeeId = null;
		boolean result = false;
		List<DeptBean> saveDeptList = null;
		List<DeptBean> updateDeptList = null;
		List<DesignationBean> saveDesigantionList = null;
		List<DesignationBean> updateDesignartionList = null;

		for (EmployeeDeatilBean employeeDetailObj : insertEmployeeDetail) {

			if (employeeDetailObj.getEmpId() == null) {
				String queryForInsertEmpDetail = "insert into employee_detail_ref(first_nm,middle_nm,last_nm,emp_email,phone_no,mobile_no,address,address_line1,org_id,city_nm,district_nm,country_nm,pin_code,salary,experience,emp_age,qualification)"
						+ " values(:firstNm,:middleNm,:lastNm,:empEmail,:phoneNo,:mobileNo,:address,:addressLine1,:orgId,:cityNm,:districtNm,:countryNm,:pinCode,:salary,:experience,:empAge,:qualification)";

				KeyHolder keyHolder = new GeneratedKeyHolder();
				namedParameterJdbcTemplate.update(queryForInsertEmpDetail,
						new BeanPropertySqlParameterSource(employeeDetailObj), keyHolder, new String[] { "emp_id" });
				employeeId = keyHolder.getKey().longValue();
				employeeDetailObj.setEmpId(employeeId);

			} else {

				String queryForUpdateEmpDetail = "update employee_detail_ref set first_nm = :firstNm,middle_nm = :middleNm,last_nm = :lastNm,emp_email =:empEmail,phone_no=:phoneNo,mobile_no=:mobileNo,address=:address,address_line1=:addressLine1,org_id=:orgId,city_nm=:cityNm,district_nm=:districtNm,country_nm=:countryNm,pin_code=:pinCode,salary=:salary,experience =:experience,qualification=:qualification where emp_id = :empId";
				namedParameterJdbcTemplate.update(queryForUpdateEmpDetail,
						new BeanPropertySqlParameterSource(employeeDetailObj));
			}

			if (CollectionUtils.isNotEmpty(employeeDetailObj.getDeptList())) {
				saveDeptList = new ArrayList<>();
				updateDeptList = new ArrayList<>();

				for (DeptBean deptObj : employeeDetailObj.getDeptList()) {
					deptObj.setEmpId(employeeDetailObj.getEmpId());

					if (deptObj.getDeptId() == null) {
						saveDeptList.add(deptObj);
					} else {
						updateDeptList.add(deptObj);
					}
				}
			}
			if (CollectionUtils.isNotEmpty(saveDeptList)) {
				String quiry = "insert into  department_ref (dept_nm,emp_id) values(:deptNm,:empId)";
				result = namedParameterJdbcTemplate.update(quiry, new BeanPropertySqlParameterSource(saveDeptList)) > 0;
			}
			// we can write the logic of department_xref table;

			if (CollectionUtils.isNotEmpty(updateDeptList)) {
				for (DeptBean deptobj : updateDeptList) {
					String updateDept = "update department_ref set dept_nm =:deptNm where dept_id=:deptId";
					result = namedParameterJdbcTemplate.update(updateDept,
							new BeanPropertySqlParameterSource(deptobj)) > 0;
				}
			}

			if (CollectionUtils.isNotEmpty(employeeDetailObj.getDesignationList())) {
				saveDesigantionList = new ArrayList<>();
				updateDesignartionList = new ArrayList<>();

				for (DesignationBean designationObj : employeeDetailObj.getDesignationList()) {

					designationObj.setEmpId(employeeDetailObj.getEmpId());

					if (designationObj.getDesignationId() == null) {
						saveDesigantionList.add(designationObj);

					} else {
						updateDesignartionList.add(designationObj);
					}
				}
				if (CollectionUtils.isNotEmpty(saveDesigantionList)) {
					String queryFroinsertDesig = "insert into designations_ref (designation_nm,emp_id)values(:designationNm,:empId)";
					result = namedParameterJdbcTemplate.update(queryFroinsertDesig,
							new BeanPropertySqlParameterSource(saveDesigantionList)) > 0;
				}

				if (CollectionUtils.isNotEmpty(updateDesignartionList)) {

					String queryForUpdateDesignation = "update designations_ref set designation_nm=:designationNm where designation_id=designationId";
					result = namedParameterJdbcTemplate.update(queryForUpdateDesignation,
							new BeanPropertySqlParameterSource(updateDesignartionList)) > 0;
				}
			}
		}
		return result;
	}
							////////////////////////////////
							//                            //
							//  insert employeeDetail     //
							//                            //
							////////////////////////////////	 

	@Override
	public Boolean insertemployeeDetailRef(EmployeeDeatilBean employeeDetailObj) {
		boolean flag = false;
		
		String queryForinsertEmployee = "insert into employee_detail_ref(first_nm,middle_nm,last_nm,emp_email,phone_no,mobile_no,address,address_line1,org_id,city_nm,district_nm,country_nm,pin_code,salary,experience,qualification)"
				+ " values(:firstNm,:middleNm,:lastNm,:empEmail,:phoneNo,:mobileNo,:address,:addressLine1,:orgId,:cityNm,:districtNm,:countryNm,:pinCode,:salary,:experience,:qualification)";
		
		 flag=namedParameterJdbcTemplate.update(queryForinsertEmployee,
				new BeanPropertySqlParameterSource(employeeDetailObj))>0;
		
		return flag;
	}
							////////////////////////////////
							//                            //
							//  update employee detail    //
							//                            //
							////////////////////////////////	 
	@Override
	public Boolean updateEmployeeDetailRef(EmployeeDeatilBean employeeDetailObj) {
		boolean flag=false;
		String queryForupdateEmp = "update employee_detail_ref set first_nm = :firstNm,middle_nm = :middleNm,last_nm = :lastNm,emp_email =:empEmail,phone_no=:phoneNo,mobile_no=:mobileNo,address=:address,address_line1=:addressLine1,org_id=:orgId,city_nm=:cityNm,district_nm=:districtNm,country_nm=:countryNm,pin_code=:pinCode,salary=:salary,experience =:experience,qualification=:qualification where emp_id = :empId";
		flag = namedParameterJdbcTemplate.update(queryForupdateEmp,
				new BeanPropertySqlParameterSource(employeeDetailObj)) > 0;

		return flag;
	}
							/////////////////////////////////////
							//                                 //
							// insert the dept meta data table //
							//                                 //
							/////////////////////////////////////	 

	@Override
	public Boolean insertDeptXref(EmployeeDeptXref employeedeptXrefObj) {
		boolean flag= false;
		String queryForinsertDepartmentXref = "insert into employee_dept_xref (emp_id,dept_id) values(:empId,:deptId)";
		flag=namedParameterJdbcTemplate.update(queryForinsertDepartmentXref,
				new BeanPropertySqlParameterSource(employeedeptXrefObj))>0;

		return flag;
	}
							////////////////////////////////////////
							//                                    //
							//  update designation meta data      //
							//                                    //
							////////////////////////////////////////	 

	@Override
	public Boolean updateDeptXref(EmployeeDeptXref employeedeptXrefObj) {
		boolean flag=false;
		
		String queryForUpdateDepartmentXref = "update employee_dept_xref emp_id=:empId,dept_id =:deptId where emp_dept_id=:empDeptId";
		flag=namedParameterJdbcTemplate.update(queryForUpdateDepartmentXref,
				new BeanPropertySqlParameterSource(employeedeptXrefObj))>0;

		return flag;
	}
							///////////////////////////////////
							//                               //
							//  insert designation meta data //
							//                               //
							///////////////////////////////////	 
	@Override
	public Boolean insertDesignation(EmployeeDesignationXRef employeeDesignationXRefObj) {
		boolean flag=false;
		
		String queryForinsertdesignationXref = "insert into employee_designations_xref (designation_id,emp_id)values(:designationId,:empId)";
		flag=namedParameterJdbcTemplate.update(queryForinsertdesignationXref,
				new BeanPropertySqlParameterSource(employeeDesignationXRefObj))>0;

		return flag;
	}
							/////////////////////////////////////
							//                                 //
							//  update designation meta data   //
							//                                 //
							/////////////////////////////////////	 

	@Override
	public Boolean updateDesignationRef(EmployeeDesignationXRef employeeDesignationXRefObj) {
		boolean flag=false;
		
		String queryForUpdateDesignationXref = "update employee_designations_xref set designation_id=:designationId,emp_id=:empId where employee_designation_id=:employeeDesignationId";
		flag=namedParameterJdbcTemplate.update(queryForUpdateDesignationXref,
				new BeanPropertySqlParameterSource(employeeDesignationXRefObj))>0;

		return flag;
	}

	@Override
	public boolean insertAndUpdadteUsingBatchUpdate(InsertAndupdateEmpList empObj) {
		boolean falg=false; 
		String queryForInsertEmployeeDetail = "insert into employee_detail_ref(first_nm,middle_nm,last_nm,emp_email,phone_no,mobile_no,address,address_line1,city_nm,district_nm,country_nm,pin_code,salary,experience,qualification,org_id)"
				+ " values(:firstNm,:middleNm,:lastNm,:empEmail,:phoneNo,:mobileNo,:address,:addressLine1,:cityNm,:districtNm,:countryNm,:pinCode,:salary,:experience,:qualification,:orgId)";
		
		SqlParameterSource[] parameter = SqlParameterSourceUtils.createBatch(empObj.getEmpList().toArray());
		falg= namedParameterJdbcTemplate.batchUpdate(queryForInsertEmployeeDetail, parameter).length>0;
		return falg;

	}

	

	
}
