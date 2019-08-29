package com.hci.virtualreceptionist.employee.controller;

public class Meeting {

	private String title;
	private String agenda;
	private String date;
	private String time;
	
	public Meeting(String etitle, String eagenda, String edate, String etime){
		this.title = etitle;
		this.agenda = eagenda;
		this.date = edate;
		this.time = etime;
	}

	public String getTitle() {
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