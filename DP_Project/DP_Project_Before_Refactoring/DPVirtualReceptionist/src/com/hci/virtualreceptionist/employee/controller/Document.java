package com.hci.virtualreceptionist.employee.controller;

/**
 * 
 * Bad Smell = Data Class (Encapsulate Field)
 * There is a public field.
 * We have made it private and provide accessors to it.
 * 
 **/

public class Document {

	String name;
	String filepath;

	public Document(String etitle, String efile){
		this.name = etitle;
		this.filepath = efile;

	}

	public String getName() {        //Being Refactored
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