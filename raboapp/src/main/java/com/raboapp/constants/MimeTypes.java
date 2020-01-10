package com.raboapp.constants;

public enum MimeTypes {
	TEXT_CSV("com.raboapp.inputreaderstreategy.ReadTransactionFromCSV"),
	APPLICATION_XML("com.raboapp.inputreaderstreategy.ReadTransactionsFromXML");

	
	private String className;
	private MimeTypes(String className){
		this.className = className;
	}
	public String getClassName() {
		return className;
	}
	
	
}
