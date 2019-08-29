package com.hci.virtualreceptionist;

/**
 * 
 * Bad Smell = Data Class (Encapsulate Field)
 * There is a public field.
 * We have made it private and provide accessors to it.
 * 
 **/

public class Employee {

	 String designation = null;
	 String name = null;
	 boolean selected = false;
	  
	 public Employee(String designation, String name, boolean selected) {
	  super();
	  this.designation = designation;
	  this.name = name;
	  this.selected = selected;
	 }
	  
	 public String getDesignation() {        //Being Refactored
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
