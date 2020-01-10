package com.raboapp.inputreaderstreategy;

import java.io.InputStream;
import java.util.List;

import com.raboapp.bean.TransactionDetail;
import com.raboapp.exception.InputParseException;

public interface FileInputReaderStrategy {

	List<TransactionDetail> getTransationsRecords(InputStream transactionInputStream) throws InputParseException;
}
