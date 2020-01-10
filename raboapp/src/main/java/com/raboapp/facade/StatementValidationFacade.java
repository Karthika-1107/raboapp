package com.raboapp.facade;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.raboapp.bean.TransactionDetail;
import com.raboapp.bean.Transactions;
import com.raboapp.constants.MimeTypes;
import com.raboapp.exception.ExceptionCodes;
import com.raboapp.exception.InputParseException;
import com.raboapp.inputreaderstreategy.FileInputReaderStrategy;
import com.raboapp.service.TransactionStatementProcessorService;


@Component
public class StatementValidationFacade {
	@Autowired
	private TransactionStatementProcessorService validateService;

	public Transactions findInValidTransactions(MultipartFile report){
		Transactions inValidTransactions = new Transactions();
		List<TransactionDetail> inputRecords = getInputRecords(report);
		
		inValidTransactions.setTransactions(validateService.findInValidRecords(inputRecords));
		return inValidTransactions;
	}
	
	
	private List<TransactionDetail> getInputRecords(MultipartFile report) {
		try {
		List<TransactionDetail> records =  new ArrayList<TransactionDetail>();
	    InputStream transactionInputStream =report.getInputStream();
	
	    String strategyClassName = MimeTypes.valueOf(report.getContentType().replace("/", "_").toUpperCase()).getClassName();
		Class<FileInputReaderStrategy> inputReader = (Class<FileInputReaderStrategy>) Class.forName(strategyClassName);
		
		FileInputReaderStrategy strategy = inputReader.newInstance();
		records = strategy.getTransationsRecords(transactionInputStream);
		return records;
		} catch (ClassNotFoundException | IOException | InstantiationException | IllegalAccessException e) {
			throw new InputParseException(ExceptionCodes.FORMAT_UNSUPPOFTED_ERROR, e);
		}
		
	}
	
	
}
