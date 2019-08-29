package com.hci.virtualreceptionist.employee.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hci.virtualreceptionist.R;

public class FragmentSendDoc extends Fragment {

	public FragmentSendDoc() {
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
		
        View rootView = inflater.inflate(R.layout.fragment_send_doc, container, false);
         
        return rootView;
    }


}
