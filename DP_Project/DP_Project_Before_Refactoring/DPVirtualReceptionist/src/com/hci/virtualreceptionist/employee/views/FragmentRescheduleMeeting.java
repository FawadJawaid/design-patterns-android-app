package com.hci.virtualreceptionist.employee.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hci.virtualreceptionist.R;

public class FragmentRescheduleMeeting extends Fragment {

	public FragmentRescheduleMeeting() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {


		  /**
		   * 
		   * Bad Smell = Long Method (Temp with Query)
		   * getrootView(inflater, container, savedInstanceState)	 
		   *
		   **/
		
        View rootView = inflater.inflate(R.layout.fragment_reschedule_meeting, container, false);
         
        return rootView;
    }

}
