package com.hci.virtualreceptionist;

public class Employee {

	 private String designation = null;
	private String name = null;
	 boolean selected = false;
	  
	 public Employee(String designation, String name, boolean selected) {
	  super();
	  this.designation = designation;
	  this.name = name;
	  this.selected = selected;
	 }
	  
	 public String getDesignation() {
	  return designation;
	 }
	 public void setCode(String designation) {
	  this.designation = designation;
	 }
	 public String getName() {
	  return name;
	 }
	 public void setName(String name) {
	  this.name = name;
	 }
	 
	 public boolean isSelected() {
	  return selected;
	 }
	 public void setSelected(boolean selected) {
	  this.selected = selected;
	 }

}
