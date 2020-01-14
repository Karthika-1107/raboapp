package com.raboapp.bean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="record")
public class TransactionDetail {
	private String refId;
	private String iban;
	private String description;
	private String startBalance;
	private String endBalance;
	private String mutation;
	
	@XmlAttribute(name="reference")
	public String getRefId() {
		return refId;
	}
	public void setRefId(String refId) {
		this.refId = refId;
	}
	@XmlElement(name="accountNumber")
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	@XmlElement(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlElement(name="startBalance")
	public String getStartBalance() {
		return startBalance;
	}
	public void setStartBalance(String startBalance) {
		this.startBalance = startBalance;
	}
	@XmlElement(name="endBalance")
	public String getEndBalance() {
		return endBalance;
	}
	public void setEndBalance(String endBalance) {
		this.endBalance = endBalance;
	}
	@XmlElement(name="mutation")
	public String getMutation() {
		return mutation;
	}
	public void setMutation(String mutation) {
		this.mutation = mutation;
	}
}
