package com.hci.virtualreceptionist;

import com.hci.virtualreceptionist.interfaces.Observer;

public class Visitor implements Observer{
	
	 private String name = null;
	 private String cnic = null;
	 private String appointmentStatus = "Pending";
	 
	 boolean selected = false;
	  
	 public Visitor(String name, String cnic) {
	  super();
	  this.name = name;
	  this.cnic = cnic;
	 }
	  
	 public String getName() {
	  return name;
	 }
	 
	 public void setName(String name) {
	  this.name = name;
	 }
	
	 public String getCnic() {
		  return cnic;
     }
	 
	 public void setCnic(String nic) {
	  this.cnic = nic;
	 }
	 
	 public boolean isSelected() {
	  return selected;
	 }
	 
	 public void setSelected(boolean selected) {
	  this.selected = selected;
	 }
	 
	 public void update(String status) {
		 appointmentStatus = status;
	 }
	
}
