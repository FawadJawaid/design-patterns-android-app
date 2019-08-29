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
 
        View rootView = getrootView(inflater, container, savedInstanceState);
         
        return rootView;
    }
	
	View getrootView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	return inflater.inflate(R.layout.fragment_view_appointmentv, container, false);
    }
}
