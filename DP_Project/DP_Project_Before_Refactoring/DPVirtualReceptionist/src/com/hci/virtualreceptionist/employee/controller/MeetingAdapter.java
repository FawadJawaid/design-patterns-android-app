package com.hci.virtualreceptionist.employee.controller;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.hci.virtualreceptionist.R;

public class MeetingAdapter extends ArrayAdapter<Meeting> {

private ArrayList<Meeting> language;
TextView langPopularity;
	
	public MeetingAdapter(Context context, int resourceId,
			ArrayList<Meeting> language) {
		super(context, resourceId, language);
		this.language = language; 
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
	    
		if (v == null) {
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.meeting_listitem, null);
		}
		
		Meeting lang = language.get(position);

		if (lang != null) {

			TextView nameHeading = (TextView) v.findViewById(R.id.txtName);
			//TextView langName = (TextView) v.findViewById(R.id.txtLangName);
			TextView popularityHeading = (TextView) v.findViewById(R.id.txtPopularity);
			//TextView langPopularity = (TextView) v.findViewById(R.id.txtLangPopularity);
			TextView timeHeading = (TextView) v.findViewById(R.id.txtTime);
			
		    langPopularity = (TextView) v.findViewById(R.id.txtAgenda);
		    
			if (nameHeading != null){
				nameHeading.setText(lang.getTitle());
			}
			if (popularityHeading != null){
				popularityHeading.setText(lang.getDate());
			}
			if (timeHeading != null){
				timeHeading.setText(lang.getTime());
			}
			if (langPopularity != null){
				//langPopularity.setImageResource(lang.getPicture());
				langPopularity.setText(lang.getAgenda());
			}
			
		}

		return v;
	}
	
	 
}
