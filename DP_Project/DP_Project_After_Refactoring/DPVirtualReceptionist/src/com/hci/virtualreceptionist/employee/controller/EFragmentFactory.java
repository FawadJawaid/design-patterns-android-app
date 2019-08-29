package com.hci.virtualreceptionist.employee.controller;

import android.support.v4.app.Fragment;

import com.hci.virtualreceptionist.employee.views.FragmentCallMeeting;
import com.hci.virtualreceptionist.employee.views.FragmentEmployeeHome;
import com.hci.virtualreceptionist.employee.views.FragmentRescheduleMeeting;
import com.hci.virtualreceptionist.employee.views.FragmentSendDoc;
import com.hci.virtualreceptionist.employee.views.FragmentViewDoc;
import com.hci.virtualreceptionist.employee.views.FragmentViewMeeting;
import com.hci.virtualreceptionist.visitor.views.FragmentAboutUs;
import com.hci.virtualreceptionist.visitor.views.FragmentCredits;

public class EFragmentFactory {
	
	public EFragmentFactory() {
		
	}

	public Fragment createFragment(String selectedItem) {
		
	        return newFragment(selectedItem);
		}
	
	public Fragment newFragment(String selectedItem)
	{
		Fragment fragment = null;
	       
        if(selectedItem.compareTo("Home") == 0) {
            fragment = new FragmentEmployeeHome();
        } else if(selectedItem.compareTo("Call a Meeting") == 0) {
            fragment = new FragmentCallMeeting();
        } else if(selectedItem.compareTo("Reschedule Meeting") == 0) {
            fragment = new FragmentRescheduleMeeting();
        }  else if(selectedItem.compareTo("Send Documents") == 0) {
            fragment = new FragmentSendDoc();
        }  else if(selectedItem.compareTo("View Documents") == 0) {
            fragment = new FragmentViewDoc();
        } else if(selectedItem.compareTo("View Meeting Schedule") == 0) {
           fragment = new FragmentViewMeeting();
        } else if(selectedItem.compareTo("About us") == 0) {
            fragment = new FragmentAboutUs();
        } else if(selectedItem.compareTo("Credits") == 0) {
            fragment = new FragmentCredits();
        } 
        return fragment;
	}
		
}
