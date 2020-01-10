package com.raboapp.inputreaderstreategy;

import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.raboapp.bean.TransactionDetail;
import com.raboapp.bean.Transactions;
import com.raboapp.exception.ExceptionCodes;
import com.raboapp.exception.InputParseException;

public class ReadTransactionsFromXML implements FileInputReaderStrategy {

	public List<TransactionDetail> getTransationsRecords(InputStream transactionInputStream) throws InputParseException{
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Transactions.class);
			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			
			Transactions transactions = (Transactions) unMarshaller.unmarshal(transactionInputStream);
			return transactions.getTransactions();
		} catch(Exception ex){
			throw new InputParseException(ExceptionCodes.XML_INPUT_FORMAT_ERROR, ex);
		}
	}

}
