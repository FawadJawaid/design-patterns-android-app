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

		View rootView = getrootView(inflater, container, savedInstanceState);
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
	
	View getrootView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	return inflater.inflate(R.layout.fragment_make_appointment, container, false);
    }

}
