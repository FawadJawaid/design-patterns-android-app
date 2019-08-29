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

import com.hci.virtualreceptionist.interfaces.DialogBox;
import com.hci.virtualreceptionist.visitor.controller.VMenuActivity;

@SuppressLint("NewApi")
public class VisitorDialogFragment extends DialogFragment implements DialogBox {
	
	ImageButton crossButton;
	Button visitButton;
	
	boolean mDismissed;
	boolean mShownByMe;
	
	@SuppressLint("NewApi")
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final Dialog dialog = new Dialog(getActivity());
		dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		dialog.setContentView(R.layout.dialogfragment_visitor);
		
		dialog.show();
		
		crossButton = (ImageButton) dialog.findViewById(R.id.crossimgBtn);
		
		crossButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// mListener.setOnSubmitListener(mEditText.getText().toString());
				dismiss();
			}
		});
		
        visitButton = (Button) dialog.findViewById(R.id.visitorbtn);
		
        /**
    	 * 
    	 * Bad Smell: Long Method (Replace Temp with Query)
    	 * We have made getVisitorMenuIntent() method to remove this smell.
    	 * 
    	 */
        
		visitButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
					
						Intent VisitorMenuIntent = new Intent(getActivity(),
								VMenuActivity.class);       //Refactored
						startActivity(VisitorMenuIntent);		
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
