package com.hci.virtualreceptionist;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import com.hci.virtualreceptionist.employee.views.EMenuActivity;
import com.hci.virtualreceptionist.interfaces.DialogBox;

@SuppressLint("NewApi")
public class LoginDialogFragment extends DialogFragment implements DialogBox{
	
	ImageButton crossButton;
	Button login;
	
	boolean mDismissed;
	boolean mShownByMe;
	
	@SuppressLint("NewApi")
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final Dialog dialog = new Dialog(getActivity());
		dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		dialog.setContentView(R.layout.dialogfragment_login);
		
		dialog.show();
		
		crossButton = (ImageButton) dialog.findViewById(R.id.crossimgBtn);
		
		crossButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// mListener.setOnSubmitListener(mEditText.getText().toString());
				dismiss();
			}
		});
		
		
         /**
    	 * 
    	 * Bad Smell: Long Method (Replace Temp with Query)
    	 * We have made getEmployeeMenuIntent(); method to remove this smell.
    	 * 
    	 */
		
		login = (Button) dialog.findViewById(R.id.logbtn);
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent EmployeeMenuIntent = new Intent(getActivity(),
						EMenuActivity.class);  //Refactored
				startActivity(EmployeeMenuIntent);
			}
		});
		return dialog;
	}
	
	public void show(FragmentManager manager, String tag) {
        mDismissed = false;
        mShownByMe = true;
        FragmentTransaction ft = manager.beginTransaction();
        ft.add(this, tag);
        ft.commit();
    }

}
