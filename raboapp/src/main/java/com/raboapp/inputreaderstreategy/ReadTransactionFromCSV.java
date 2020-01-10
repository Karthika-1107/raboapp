package com.raboapp.inputreaderstreategy;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import com.raboapp.bean.TransactionDetail;
import com.raboapp.exception.ExceptionCodes;
import com.raboapp.exception.InputParseException;

public class ReadTransactionFromCSV implements FileInputReaderStrategy{

	public List<TransactionDetail> getTransationsRecords(InputStream transactionInputStream) throws InputParseException{
		try{
			Map<String, String> dataMappingStgy = new HashMap<String, String>();
			dataMappingStgy.put("Reference", "refId");
			dataMappingStgy.put("Account Number", "iban");
			dataMappingStgy.put("Description", "description");
			dataMappingStgy.put("Start Balance", "startBalance");
			dataMappingStgy.put("Mutation", "mutation");
			dataMappingStgy.put("End Balance", "endBalance");
	
			HeaderColumnNameTranslateMappingStrategy<TransactionDetail> beanStrategy = new HeaderColumnNameTranslateMappingStrategy<TransactionDetail>();
			beanStrategy.setType(TransactionDetail.class); 
			beanStrategy.setColumnMapping(dataMappingStgy);
			
		
			InputStreamReader inputReader = new InputStreamReader(transactionInputStream);
			CSVReader reader = new CSVReader(inputReader);
			CsvToBean<TransactionDetail> csvToRecordBean=new CsvToBean<TransactionDetail>();
			csvToRecordBean.setCsvReader(reader);
			csvToRecordBean.setMappingStrategy(beanStrategy);	
			
			return csvToRecordBean.parse();
		} catch(Exception ex){
			throw new InputParseException(ExceptionCodes.CSV_INPUT_FORNAT_ERROR, ex);
		}
	}

}
