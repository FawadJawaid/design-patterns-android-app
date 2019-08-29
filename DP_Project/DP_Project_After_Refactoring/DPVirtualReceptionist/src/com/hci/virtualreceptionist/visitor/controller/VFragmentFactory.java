package com.hci.virtualreceptionist.visitor.controller;

import com.hci.virtualreceptionist.visitor.views.FragmentAboutUs;
import com.hci.virtualreceptionist.visitor.views.FragmentCredits;
import com.hci.virtualreceptionist.visitor.views.FragmentMakeAppointment;
import com.hci.virtualreceptionist.visitor.views.FragmentViewAppointment;
import com.hci.virtualreceptionist.visitor.views.FragmentVisitorHomePlay;

import android.support.v4.app.Fragment;

public class VFragmentFactory {

public VFragmentFactory() {
		
	}
	
	public Fragment createFragment(String selectedItem) {
		

	        return newFragment(selectedItem);	
	}
	private Fragment newFragment(String selectedItem)
	{ 
		Fragment fragment = null;

    
    if(selectedItem.compareTo("Home") == 0) {
         fragment= new FragmentVisitorHomePlay();
    } else if(selectedItem.compareTo("Make Appointment") == 0) {
    	 fragment=new FragmentMakeAppointment();
    } else if(selectedItem.compareTo("View Apppointment") == 0) {
    	 fragment=new FragmentViewAppointment();
    }  else if(selectedItem.compareTo("About us") == 0) {
    	fragment=new FragmentAboutUs();
    }  else if(selectedItem.compareTo("Credits") == 0) {
    	//ft.addToBackStack(null);
    	 fragment=new FragmentCredits();
    }
    return fragment;
	}
	
}
