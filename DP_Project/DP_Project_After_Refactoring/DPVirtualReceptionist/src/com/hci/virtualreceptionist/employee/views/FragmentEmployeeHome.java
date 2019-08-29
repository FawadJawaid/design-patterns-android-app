package com.hci.virtualreceptionist.employee.views;

import java.util.Iterator;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hci.virtualreceptionist.GlobalVariables;
import com.hci.virtualreceptionist.R;
import com.hci.virtualreceptionist.employee.controller.Document;
import com.hci.virtualreceptionist.employee.controller.Meeting;

public class FragmentEmployeeHome extends Fragment {

	Iterator meetingIterator = GlobalVariables.createIterator("meeting");   //Iterator Pattern
	Iterator documentIterator = GlobalVariables.createIterator("");         //Iterator Pattern


	
	
	public FragmentEmployeeHome() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        View rootView = getrootView(inflater, container, savedInstanceState);
        
        TextView feeds = (TextView) rootView.findViewById(R.id.employeeHomeview);
		
        feeds.setText("Your Scheduled Meetings are: ");
		while (meetingIterator.hasNext()) {
			Meeting meet = (Meeting)meetingIterator.next();
			feeds.append(meet.getTitle() + "\n");
		}
        
		feeds.append("The Documents needing your approval are: ");
		while (documentIterator.hasNext()) {
			Document doc = (Document)documentIterator.next();
			feeds.append(doc.getName() + "\n");
		}
        
        
        return rootView;
    }
	
	View getrootView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	return inflater.inflate(R.layout.fragment_employee_home, container, false);
    }
}
