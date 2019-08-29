package com.hci.virtualreceptionist.visitor.views;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TimePicker;

import com.hci.virtualreceptionist.R;

public class SelectTimeDialog extends DialogFragment{

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		final Dialog dialog = new Dialog(getActivity());
		dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		dialog.setContentView(R.layout.dialogfragment_selecttime);
		
		dialog.show();
		
		Button next = (Button) dialog.findViewById(R.id.timeneext);
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				TimePicker tp = (TimePicker) dialog.findViewById(R.id.apptime);
				Bundle args = getArguments();
				args.putInt("hour", tp.getCurrentHour());
				args.putInt("minute", tp.getCurrentMinute());
				SelectDateDialog sdd = new SelectDateDialog();
				sdd.setArguments(args);
				sdd.show(getFragmentManager(), "");
				dismiss();
			}
		});
		return dialog;
	}

}
