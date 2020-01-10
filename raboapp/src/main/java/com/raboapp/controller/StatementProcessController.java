package com.raboapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.raboapp.bean.Transactions;
import com.raboapp.exception.UnSupportedMediaTypeException;
import com.raboapp.facade.StatementValidationFacade;

@RestController
public class StatementProcessController {
	@Value("${statment.valid.mimetypes}")
	private String validMediaTypes;
	@Autowired
	private StatementValidationFacade valdaitionFacade;
	
	@PostMapping(value="/raboapp/stmtprocessor/validateStatement")
	public ResponseEntity<Transactions> validateStatement(@RequestParam("report") MultipartFile report){
		if(!validMediaTypes.contains(report.getContentType().toUpperCase())){
			throw new UnSupportedMediaTypeException();
		}
		
		Transactions inValidRecords =  getValdaitionFacade().findInValidTransactions(report);
		return new ResponseEntity<Transactions>(inValidRecords, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	protected StatementValidationFacade getValdaitionFacade() {
		return valdaitionFacade;
	}

}
