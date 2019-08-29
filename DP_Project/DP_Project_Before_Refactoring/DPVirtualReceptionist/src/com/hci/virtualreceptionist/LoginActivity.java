package com.hci.virtualreceptionist;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.hci.virtualreceptionist.interfaces.DialogBox;

public class LoginActivity extends Activity {

	Button loginBtn, visitorBtn, signupBtn, elogin;
	
	/**
	 * 
	 * Bad Smell = Long Method (Extract Method)
	 * We have made initUI(); method to remove this smell.
	 * 
	 **/
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
  	    setContentView(R.layout.activity_login);                 //Refactored
		
		loginBtn = (Button) findViewById(R.id.loginbutton);
		visitorBtn = (Button) findViewById(R.id.visitorbutton);
		signupBtn = (Button) findViewById(R.id.signupbutton);
			
		loginBtn.setOnClickListener(loginBtnListener);
		visitorBtn.setOnClickListener(visitorBtnListener);
		signupBtn.setOnClickListener(signupBtnListener);          //Refactored
	}


	/**
	 * 
	 * Bad Smell: Long Method (Replace Temp with Query)
	 * We have made getSignUpIntent(); method to remove this smell.
	 * 
	 */
	
	OnClickListener loginBtnListener = new OnClickListener() {

		@SuppressLint("NewApi")
		@Override
		public void onClick(View v) {

			    //LoginDialogFragment fragment1 = new LoginDialogFragment();
			    DialogBox frg1 = new LoginDialogFragment();       //Strategy Pattern
			                                                      //Refactored
			    
			    android.app.FragmentManager fm = getFragmentManager();
			    //fragment1.show(fm, ""); 
			    frg1.show(fm, "");

		}
	};
	
	/**
	 * 
	 * Bad Smell: Long Method (Replace Temp with Query)
	 * We have made getSignUpIntent(); method to remove this smell.
	 * 
	 */
	
	OnClickListener visitorBtnListener = new OnClickListener() {

		@SuppressLint("NewApi")
		@Override
		public void onClick(View v) {

			   DialogBox fragment1 = new VisitorDialogFragment();    //Strategy Pattern
			                                                         //Refactored
			   
			   android.app.FragmentManager fm = getFragmentManager();
			   fragment1.show(fm, "");
			

		}
	};
	
	/**
	 * 
	 * Bad Smell: Long Method (Replace Temp with Query)
	 * We have made getSignUpIntent(); method to remove this smell.
	 * 
	 */
	
	OnClickListener signupBtnListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
        
			Intent signupIntent = new Intent(getApplicationContext(),
					SignupActivity.class);                 //Refactored
			startActivity(signupIntent);
		}
	};
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
