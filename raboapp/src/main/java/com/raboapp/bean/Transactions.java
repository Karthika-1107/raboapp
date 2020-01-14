package com.raboapp.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="records")
public class Transactions {
	List<TransactionDetail> transactions;

	@XmlElement(name="record")
	public List<TransactionDetail> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionDetail> transactions) {
		this.transactions = transactions;
	}
}
