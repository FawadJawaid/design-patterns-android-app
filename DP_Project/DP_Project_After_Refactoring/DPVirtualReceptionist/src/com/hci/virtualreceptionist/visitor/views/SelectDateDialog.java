package com.hci.virtualreceptionist.visitor.views;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.hci.virtualreceptionist.R;

public class SelectDateDialog extends DialogFragment{

	public SelectDateDialog() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		final Dialog dialog = new Dialog(getActivity());
		dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		dialog.setContentView(R.layout.dialogfragment_selectdate);
		
		dialog.show();
		

		
		Button done = (Button) dialog.findViewById(R.id.datedone);
		done.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Bundle args = getArguments();
				DatePicker dp = (DatePicker) dialog.findViewById(R.id.appdate);
				args.putInt("day", dp.getDayOfMonth());
				args.putInt("month", dp.getMonth());
				args.putInt("year", dp.getYear());
				
				Toast.makeText(getActivity(), args.getInt("hour"), Toast.LENGTH_LONG).show();
				
				dismiss();
			}
		});
		return dialog;
	}

}
