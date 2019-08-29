package com.hci.virtualreceptionist.employee.views;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hci.virtualreceptionist.GlobalVariables;
import com.hci.virtualreceptionist.R;
import com.hci.virtualreceptionist.employee.controller.MeetingAdapter;

public class FragmentViewMeeting extends ListFragment{

	private MeetingAdapter lang_adapter;       //Adapter Pattern
	
	public FragmentViewMeeting() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = getrootView(inflater, container, savedInstanceState);   
        setListAdapters();
        
        return rootView;
    }
	
	private void setListAdapters() {

		lang_adapter = new MeetingAdapter(getActivity(),
				R.layout.meeting_listitem, GlobalVariables.meetings);
		setListAdapter(lang_adapter);
	}

	View getrootView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	return inflater.inflate(R.layout.fragment_view_meeting, container, false);
    }
}
