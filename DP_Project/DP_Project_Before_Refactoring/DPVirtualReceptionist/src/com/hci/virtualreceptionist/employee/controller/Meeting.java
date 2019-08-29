package com.hci.virtualreceptionist.employee.controller;

/**
 * 
 * Bad Smell = Data Class (Encapsulate Field)
 * There is a public field.
 * We have made it private and provide accessors to it.
 * 
 **/

public class Meeting {

	String title;
	String agenda;
	String date;
	String time;
	
	public Meeting(String etitle, String eagenda, String edate, String etime){
		this.title = etitle;
		this.agenda = eagenda;
		this.date = edate;
		this.time = etime;
	}

	public String getTitle() {          //Being Refactored
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAgenda() {
		return agenda;
	}

	public void setAgenda(String agenda) {
		this.agenda = agenda;
	}
		
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}