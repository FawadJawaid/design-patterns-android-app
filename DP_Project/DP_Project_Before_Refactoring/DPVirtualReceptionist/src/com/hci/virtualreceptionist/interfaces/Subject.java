package com.hci.virtualreceptionist.interfaces;

public interface Subject {
	
	public void registerObserver(Observer ob);
	public void removeObserver();
	public void notifyObserver();
	
}
