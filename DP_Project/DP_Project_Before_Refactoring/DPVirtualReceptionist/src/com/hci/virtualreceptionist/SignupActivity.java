package com.hci.virtualreceptionist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SignupActivity extends Activity {

	Button signBtn;
	
	/**
	 * Bad Smell = Long Method (Extract Method)
	 * initUI();
	 */
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
        setContentView(R.layout.activity_signup);                //Refactored
		signBtn = (Button) findViewById(R.id.createacc_button);
		signBtn.setOnClickListener(createaccBtnListener);        //Refactored
	}
	
	/**
	 * 
	 * Bad Smell: Long Method (Replace Temp with Query)
	 * getLoginIntent();
	 * 
	 */
	
	OnClickListener createaccBtnListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
        
			Intent loginIntent = new Intent(getApplicationContext(),
					LoginActivity.class);        //Refactored
			startActivity(loginIntent);
		}
	};
	
}

