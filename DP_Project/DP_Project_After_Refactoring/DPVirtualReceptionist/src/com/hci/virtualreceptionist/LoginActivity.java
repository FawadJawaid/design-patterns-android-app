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

	Button loginBtn, visitorBtn, signupBtn,elogin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initUI();
	}

	private void initUI() {
		setContentView(R.layout.activity_login);
		
		loginBtn = (Button) findViewById(R.id.loginbutton);
		visitorBtn = (Button) findViewById(R.id.visitorbutton);
		signupBtn = (Button) findViewById(R.id.signupbutton);
			
		loginBtn.setOnClickListener(loginBtnListener);
		visitorBtn.setOnClickListener(visitorBtnListener);
		signupBtn.setOnClickListener(signupBtnListener);
	}
	
	OnClickListener loginBtnListener = new OnClickListener() {

		@SuppressLint("NewApi")
		@Override
		public void onClick(View v) {

			    //LoginDialogFragment fragment1 = new LoginDialogFragment();
			    //Strategy Pattern
			    
			    android.app.FragmentManager fm = getFragmentManager();
			    //fragment1.show(fm, ""); 
			    getloginDialogFragment().show(fm, "");

		}
		private DialogBox getloginDialogFragment()
		{
			
			return new LoginDialogFragment();
		}
		
		
	};
	
	OnClickListener visitorBtnListener = new OnClickListener() {

		@SuppressLint("NewApi")
		@Override
		public void onClick(View v) {

			   //startActivity(new Intent(LoginActivity.this, VMenuActivity.class));
			   //Strategy Pattern
			    
			   android.app.FragmentManager fm = getFragmentManager();
			   getFragment().show(fm, "");
			

		}
		
		private DialogBox getFragment()
		{
			
			return new VisitorDialogFragment();
		}
	};
	
	private Intent getSignUpIntent()
	{
		return new Intent(getApplicationContext(),
			    SignupActivity.class);
		
	}
	
	OnClickListener signupBtnListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
        
			startActivity(getSignUpIntent());
		}
	};
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}

}
