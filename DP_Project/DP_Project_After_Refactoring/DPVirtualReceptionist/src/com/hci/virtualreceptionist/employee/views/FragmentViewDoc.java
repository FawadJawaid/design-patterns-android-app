package com.hci.virtualreceptionist.employee.views;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hci.virtualreceptionist.GlobalVariables;
import com.hci.virtualreceptionist.R;
import com.hci.virtualreceptionist.employee.controller.DocumentAdapter;

public class FragmentViewDoc extends ListFragment {

	private DocumentAdapter lang_adapter;     //Adapter Pattern
	
	public FragmentViewDoc() {
	}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = getrootView(inflater, container, savedInstanceState);
        setAdapters();
        
        return rootView;
    }

	private void setAdapters() {

		lang_adapter = new DocumentAdapter(getActivity(),
				R.layout.document_listitem, GlobalVariables.documents);
		setListAdapter(lang_adapter);
	}

	View getrootView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	return inflater.inflate(R.layout.fragment_view_doc, container, false);
    }
}
