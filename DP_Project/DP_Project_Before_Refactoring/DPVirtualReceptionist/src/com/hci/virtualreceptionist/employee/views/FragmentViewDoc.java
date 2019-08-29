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
 
		  /**
		   * 
		   * Bad Smell = Long Method (Temp with Query)
		   * getrootView(inflater, container, savedInstanceState)	 
		   *
		   **/
		
        View rootView = inflater.inflate(R.layout.fragment_view_doc, container, false);
        setAdapters();
        
        return rootView;
    }

	private void setAdapters() {

		lang_adapter = new DocumentAdapter(getActivity(),
				R.layout.document_listitem, GlobalVariables.documents);
		setListAdapter(lang_adapter);
	}

}
