package com.hci.virtualreceptionist;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Application;

import com.hci.virtualreceptionist.employee.controller.Document;
import com.hci.virtualreceptionist.employee.controller.Meeting;

public class GlobalVariables extends Application{
	public static ArrayList<Meeting> meetings = new ArrayList<Meeting>();
	public static ArrayList<Document> documents = new ArrayList<Document>();

	public static Iterator createIterator(String iteratortype) {
		if(iteratortype.equals("meeting"))
			return meetings.iterator();
		else
			return documents.iterator();
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		GlobalVariables.documents.add(new Document("Document1", "blob"));
		GlobalVariables.documents.add(new Document("Document2", "blob2"));
	    
		GlobalVariables.meetings.add(new Meeting("Meeting1", "FYP", "18 November 2014", "2:30 PM"));
		GlobalVariables.meetings.add(new Meeting("Meeting2", "FYP1", "20 November 2014", "11:30 AM"));
		GlobalVariables.meetings.add(new Meeting("Meeting3", "FYP2", "23 November 2014", "12:30 PM"));
	}
	
}
