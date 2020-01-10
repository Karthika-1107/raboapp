package com.raboapp.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.raboapp.bean.TransactionDetail;

@Service
public class TransactionStatementProcessorService {
	private Logger logger = LogManager.getLogger(this.getClass());

	public List<TransactionDetail> findInValidRecords(List<TransactionDetail> statements){
		
		List<TransactionDetail> inValidRecords = new ArrayList<>();
		List<TransactionDetail> uniqueRecords = new ArrayList<>();
		
		//Find duplicate and unique records
		Map<String, List<TransactionDetail>> traansGroup = statements.stream().collect(Collectors.groupingBy(TransactionDetail::getRefId));
		traansGroup.entrySet().stream().map(t->t.getValue()).forEach(t-> {
			if(t.size()>1) {
				inValidRecords.addAll(t);
				} else {
					uniqueRecords.addAll(t);
				}
			}
		);
		
		//check end balance
		inValidRecords.addAll(uniqueRecords.stream().filter(validateEndBalPredicate()).collect(Collectors.toList()));
		
		logger.info("Valid Records :  " + statements.size()+ "; Invalid Records : " + inValidRecords.size());
		return inValidRecords;
	}
	
	private Predicate<TransactionDetail> validateEndBalPredicate(){
		Predicate<TransactionDetail> validateEndBalance = (transaction)->{
			BigDecimal startBalance = new BigDecimal(transaction.getStartBalance());
			BigDecimal mutation = new BigDecimal(transaction.getMutation());
			BigDecimal endBalance = new BigDecimal(transaction.getEndBalance());
			
			return startBalance.add(mutation).compareTo(endBalance) != 0;
		};
		return validateEndBalance;
	}
	
}
