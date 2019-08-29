package com.hci.virtualreceptionist.visitor.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import com.hci.virtualreceptionist.R;

public class FragmentMakeAppointment extends Fragment {

	public FragmentMakeAppointment() {
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
		
		View rootView = inflater.inflate(R.layout.fragment_make_appointment,
				container, false);
		rootView.findViewById(R.id.vselectdt).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Bundle result = new Bundle();
						SelectTimeDialog sd = new SelectTimeDialog();
						sd.setArguments(result);
						sd.show(getActivity().getFragmentManager(), "");
						
					}
				});

		return rootView;
	}

}
