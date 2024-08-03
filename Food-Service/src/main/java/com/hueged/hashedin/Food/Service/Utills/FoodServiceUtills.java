package com.hueged.hashedin.Food.Service.Utills;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.hueged.hashedin.Food.Service.Entity.ResponseMapper;

@Component
public class FoodServiceUtills {


	
	public static final String  CREATE_USER_SUCCESSFULLY= "USER CREATE  SUCCESSFULLY";
	public static final String RES_CODE_CRE001="SAV001";
	public static final String UNABLE_TO_CREATE_USER ="UNABLE TO CREATE USER";
	public static final String RES_CODE_UNA002 = "SAV002";

	
	public static final String  DATA_SAVED_SUCCESSFULLY= "DATA SAVED SUCCESSFULLY";
	public static final String RES_CODE_SAV001="SAV001";
	public static final String UNABLE_TO_SAVE_DATA ="UNABLE TO SAVE DATA";
	public static final String RES_CODE_SAV002 = "SAV002";
	

	public static final String DATA_UPDATED_SUCCESSFULLY= "DATA TO UPDATE SUCCESSFULLY";
	public static final String RES_CODE_UPD001="UPD001";
	public static final String UNABLE_TO_UPDATE= "UNABLE TO UPDATE";
	public static final String RES_CODE_UPD002="UPD002";
	
	
	public static final String NO_DATA_FOUND ="NO DATE FOUND";
	public static final String RES_CODE_NOD001= "NOD001";
	public static final String DATA_FETCH_SUCCESSFULLY ="DATA FETCH SUCESSFULLY";
	public static final String RES_CODE_FET001= "FET001";
	public static final String UNABLE_TO_FETCH_DATA = "UNABLE TO FETCH DATA";
	public static final String RES_CODE_FET002="FET002";
	
	public static final String RES_CODE_SUCCESS = "E200";
	public static final String RES_CODE_FAILURE = "E400";
	
	public static final String ACTIVATED = "Activated";
	public static final String DEACTIVATED = "Deactivated";
	
	public ResponseEntity<ResponseMapper> responseEntityForUserInsertSuccess(Object object) {
		ResponseMapper responseMapper;
		responseMapper = new ResponseMapper(RES_CODE_CRE001, CREATE_USER_SUCCESSFULLY);
		responseMapper.addValidations(RES_CODE_SAV001, DATA_SAVED_SUCCESSFULLY);
		responseMapper.setData(object);
		return new ResponseEntity<>(responseMapper, HttpStatus.OK);
	}

	
	public ResponseEntity<ResponseMapper> responseEntityForInsertSuccess(Object object) {
		ResponseMapper responseMapper;
		responseMapper = new ResponseMapper(RES_CODE_SUCCESS, DATA_SAVED_SUCCESSFULLY);
		responseMapper.addValidations(RES_CODE_SAV001, DATA_SAVED_SUCCESSFULLY);
		responseMapper.setData(object);
		return new ResponseEntity<>(responseMapper, HttpStatus.OK);
	}

	public ResponseEntity<ResponseMapper> responseEntityForInsertFailWithMsg(Object object, String errorMsg) {
		ResponseMapper responseMapper;
		responseMapper = new ResponseMapper(RES_CODE_SUCCESS, errorMsg);
		responseMapper.addValidations(RES_CODE_SAV001, errorMsg);
		responseMapper.setData(object);
		return new ResponseEntity<>(responseMapper, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<ResponseMapper> responseEntityForInsertFailure(Object object) {
		ResponseMapper responseMapper;
		responseMapper = new ResponseMapper(RES_CODE_FAILURE, UNABLE_TO_SAVE_DATA);
		responseMapper.addValidations(RES_CODE_SAV002, UNABLE_TO_SAVE_DATA);
		responseMapper.setData(object);
		return new ResponseEntity<>(responseMapper, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<ResponseMapper> responseEntityForUpdateSuccess(Object object) {
		ResponseMapper responseMapper;
		responseMapper = new ResponseMapper(RES_CODE_SUCCESS, DATA_UPDATED_SUCCESSFULLY);
		responseMapper.addValidations(RES_CODE_UPD001, DATA_UPDATED_SUCCESSFULLY);
		responseMapper.setData(object);
		return new ResponseEntity<>(responseMapper, HttpStatus.OK);
	}

	public ResponseEntity<ResponseMapper> responseEntityForUpdateFailure(Object object) {
		ResponseMapper responseMapper;
		responseMapper = new ResponseMapper(RES_CODE_FAILURE, UNABLE_TO_UPDATE);
		responseMapper.addValidations(RES_CODE_UPD002, UNABLE_TO_UPDATE);
		responseMapper.setData(object);
		return new ResponseEntity<>(responseMapper, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<ResponseMapper> responseEntityForFetchSuccess(Object object) {
		ResponseMapper responseMapper;
		if (object == null) {
			responseMapper = new ResponseMapper(RES_CODE_FET001, NO_DATA_FOUND);
			responseMapper.addValidations(RES_CODE_FET001, DATA_FETCH_SUCCESSFULLY);
		} else {
			responseMapper = new ResponseMapper(RES_CODE_SUCCESS, DATA_FETCH_SUCCESSFULLY);
			responseMapper.addValidations(RES_CODE_FET001, DATA_FETCH_SUCCESSFULLY);
		}
		responseMapper.setData(object);
		return new ResponseEntity<>(responseMapper, HttpStatus.OK);
	}

	public ResponseEntity<ResponseMapper> responseEntityForFetchFailure(Object object) {
		ResponseMapper responseMapper;
		responseMapper = new ResponseMapper(RES_CODE_FAILURE, UNABLE_TO_FETCH_DATA);
		responseMapper.addValidations(RES_CODE_FET002, UNABLE_TO_FETCH_DATA);
		responseMapper.setData(object);
		return new ResponseEntity<>(responseMapper, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	






}
