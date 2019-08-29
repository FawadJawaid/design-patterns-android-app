package com.hci.virtualreceptionist;

import com.hci.virtualreceptionist.interfaces.Observer;
import com.hci.virtualreceptionist.interfaces.Subject;

public class Appointment implements Subject{

	Observer obs;
	private String status;
	
	private String subject;
	private String dateTime;
	Employee appointee;
	
	private static Appointment appointment;
	
	private Appointment(String sub, String date, Employee emp) {
		this.subject = sub;
		this.dateTime = date;
		this.appointee = emp;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getDateTime() {
		return dateTime;
	}
	
	public Employee getAppointee() {
		return appointee;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public void setDateTime(String date) {
		this.dateTime = date; 
	}
	
	public void setAppointee(Employee app) {
		this.appointee = app;
	}
	
	
	public static Appointment getInstance(String sub, String date, Employee emp) {
		
		if(appointment == null) {
			appointment =  new Appointment(sub, date, emp);    //Singleton Pattern
		}
		
		return appointment;
	}
	
	
	@Override
	public void registerObserver(Observer o) {          //Observer Pattern
		this.obs = o;
	}

	@Override
	public void removeObserver() {
		this.obs = null;
	}

	@Override
	public void notifyObserver() {
		this.obs.update(this.status);
	}

}
