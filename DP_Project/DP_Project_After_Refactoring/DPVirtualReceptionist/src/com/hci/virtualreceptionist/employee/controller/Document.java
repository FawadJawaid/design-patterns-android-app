package com.hci.virtualreceptionist.employee.controller;


public class Document {

	private String name;
	private String filepath;

	public Document(String etitle, String efile){
		this.name = etitle;
		this.filepath = efile;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getFile() {
		return filepath;
	}

	public void setFile(String file) {
		this.filepath = file;
	}
}