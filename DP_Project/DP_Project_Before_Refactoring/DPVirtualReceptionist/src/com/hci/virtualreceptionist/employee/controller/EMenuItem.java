package com.hci.virtualreceptionist.employee.controller;

/**
 * 
 * Bad Smell = Data Class (Encapsulate Field)
 * There is a public field.
 * We have made it private and provide accessors to it.
 * 
 **/

public class EMenuItem {

	String title;
	int icon;
	String count = "0";
	boolean isCounterVisible = false;
	
	public EMenuItem(){}

	public EMenuItem(String title, int icon){
		this.title = title;
		this.icon = icon;
	}
	
	public EMenuItem(String title, int icon, boolean isCounterVisible, String count){
		this.title = title;
		this.icon = icon;
		this.isCounterVisible = isCounterVisible;
		this.count = count;
	}
	
	public String getTitle(){    //Being Refactored
		return this.title;
	}
	
	public int getIcon(){
		return this.icon;
	}
	
	public String getCount(){
		return this.count;
	}
	
	public boolean getCounterVisibility(){
		return this.isCounterVisible;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setIcon(int icon){
		this.icon = icon;
	}
	
	public void setCount(String count){
		this.count = count;
	}
	
	public void setCounterVisibility(boolean isCounterVisible){
		this.isCounterVisible = isCounterVisible;
	}
}
