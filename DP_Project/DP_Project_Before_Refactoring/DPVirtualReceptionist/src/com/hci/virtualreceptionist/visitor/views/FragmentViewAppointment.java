package com.hci.virtualreceptionist.visitor.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hci.virtualreceptionist.R;

public class FragmentViewAppointment extends Fragment {

    public FragmentViewAppointment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
		  /**
		   * 
		   * Bad Smell = Long Method (Temp with Query)
		   * getrootView(inflater, container, savedInstanceState)	 
		   *
		   **/
		
        View rootView = inflater.inflate(R.layout.fragment_view_appointmentv, container, false);
         
        return rootView;
    }
	
}
