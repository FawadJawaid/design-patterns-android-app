package com.hci.virtualreceptionist;

import com.hci.virtualreceptionist.interfaces.Observer;
import com.hci.virtualreceptionist.interfaces.Subject;

/**
 * 
 * Bad Smell = Data Class (Encapsulate Field)
 * There is a public field.
 * We have made it private and provide accessors to it.
 * 
 **/

 
 /**
  * 
  * Bad Smell = Primitive Obsession (Replace Data Value with Object)
  * You have a data item that needs additional data or behavior.
  * We have turned the data item into an object.
  * 
  **/

public class Appointment implements Subject{

	Observer obs;
	String status;
	
	String subject;
	String dateTime;
	Employee appointee;            //refactored, using Replace Data Value with Object
	
	private static Appointment appointment;
	
	private Appointment(String sub, String date, Employee emp) {
		this.subject = sub;
		this.dateTime = date;
		this.appointee = emp;
	}
	
	public String getSubject() {           //Being Refactored
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
