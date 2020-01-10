package com.raboapp;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.raboapp.bean.TransactionDetail;
import com.raboapp.service.TransactionStatementProcessorService;


import static org.junit.Assert.assertEquals;

@SpringBootTest
public class TransactionStatementProcessorServiceTest {
	@Autowired
	TransactionStatementProcessorService service;

	@Test
	public void finDuplicateRecordsTestCase() {
		TransactionDetail t1 = new TransactionDetail();
		t1.setRefId("112806");
		t1.setIban("NL69ABNA0433647324");
		t1.setDescription("Subscription for Jan Theuß");
		t1.setStartBalance("45.59");
		t1.setMutation("48.18");
		t1.setEndBalance("93.77");
		
		TransactionDetail t2 = new TransactionDetail();
		t2.setRefId("112806");
		t2.setIban("NL90ABNA0585647886");
		t2.setDescription("Clothes from Peter de Vries");
		t2.setStartBalance("32.76");
		t2.setMutation("49.03");
		t2.setEndBalance("81.79");
		
	
		
		List<TransactionDetail> inputList = Arrays.asList(t1,t2);
		TransactionStatementProcessorService service = new TransactionStatementProcessorService();
	
		assertEquals(inputList.size(), service.findInValidRecords(inputList).size());

	}
	
	@Test
	public void finDuplicateAndEnbalnceCheckRecordsTestCase() {
		TransactionDetail t1 = new TransactionDetail();
		t1.setRefId("112806");
		t1.setIban("NL69ABNA0433647324");
		t1.setDescription("Subscription for Jan Theuß");
		t1.setStartBalance("45.59");
		t1.setMutation("48.18");
		t1.setEndBalance("93.77");
		
		TransactionDetail t2 = new TransactionDetail();
		t2.setRefId("112806");
		t2.setIban("NL90ABNA0585647886");
		t2.setDescription("Clothes from Peter de Vries");
		t2.setStartBalance("32.76");
		t2.setMutation("49.03");
		t2.setEndBalance("81.79");
		
		TransactionDetail t3 = new TransactionDetail();
		t3.setRefId("177666");
		t3.setIban("NL93ABNA0585619023");
		t3.setDescription("Flowers for Rik Theuß");
		t3.setStartBalance("44.85");
		t3.setMutation("-22.24");
		t3.setEndBalance("0");
		
		TransactionDetail t4 = new TransactionDetail();
		t4.setRefId("163590");
		t4.setIban("NL27SNSB0917829871");
		t4.setDescription("Tickets from Rik Bakker");
		t4.setStartBalance("105.11");
		t4.setMutation("29.87");
		t4.setEndBalance("134.98");
		
	
		
		List<TransactionDetail> inputList = Arrays.asList(t1,t2,t3,t4);
		TransactionStatementProcessorService service = new TransactionStatementProcessorService();
	
		assertEquals(3, service.findInValidRecords(inputList).size());

	}
}
