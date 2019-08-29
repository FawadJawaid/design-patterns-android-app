package com.hci.virtualreceptionist.employee.controller;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.hci.virtualreceptionist.R;

public class DocumentAdapter extends ArrayAdapter<Document> {

private ArrayList<Document> language;
TextView langPopularity;
	
	public DocumentAdapter(Context context, int resourceId,
			ArrayList<Document> language) {
		super(context, resourceId, language);
		this.language = language; 
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
	    
		if (v == null) {
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.document_listitem, null);
		}
		
		Document lang = language.get(position);
		
		  /**
         * 
         * Bad Smell = Temporary Field (Introduce Null Object)
         * You have repeated checks for a null value.
         * Replace the null value with a null object.
         * 
         **/

		if (lang != null) {         //Refactored

			TextView nameHeading = (TextView) v.findViewById(R.id.txtName);
		
			ImageButton fileBtn = (ImageButton) v.findViewById(R.id.fileButton);
			
		    langPopularity = (TextView) v.findViewById(R.id.txtAgenda);
		    
			if (nameHeading != null){
				nameHeading.setText(lang.getName());
			}
			
			fileBtn.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			});
		}

		return v;
	}
	
	 
}

