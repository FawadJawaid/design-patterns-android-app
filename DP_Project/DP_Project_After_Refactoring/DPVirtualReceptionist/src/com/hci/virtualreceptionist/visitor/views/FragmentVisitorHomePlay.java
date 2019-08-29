package com.hci.virtualreceptionist.visitor.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.hci.virtualreceptionist.R;

public class FragmentVisitorHomePlay extends Fragment {
	
	public FragmentVisitorHomePlay(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = getrootView(inflater, container, savedInstanceState);
        Button makeapp = (Button) rootView.findViewById(R.id.makeappbtn);
        Button viewapp = (Button) rootView.findViewById(R.id.viewappbtn);
        
        makeapp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fm = FragmentVisitorHomePlay.this.getActivity().getSupportFragmentManager();
				FragmentTransaction ft = fm.beginTransaction();			        
			    Fragment fragment;
			      
				fragment = new FragmentMakeAppointment();
				ft.replace(R.id.activity_main_content_fragment, fragment);
				ft.commit();
			}
		});
        
        viewapp.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fm = FragmentVisitorHomePlay.this.getActivity().getSupportFragmentManager();
				FragmentTransaction ft = fm.beginTransaction();			        
			    Fragment fragment;
			      
				fragment = new FragmentViewAppointment();
				ft.replace(R.id.activity_main_content_fragment, fragment);
				ft.commit();
				
			}
		});
        
        return rootView;
    }
	
	View getrootView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	return inflater.inflate(R.layout.fragment_visitor_home, container, false);
    }
}
