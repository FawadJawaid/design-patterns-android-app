package com.hci.virtualreceptionist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SignupActivity extends Activity {

	Button signBtn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initUI();
	}
	
	public void initUI() {
		setContentView(R.layout.activity_signup);
		
		signBtn = (Button) findViewById(R.id.createacc_button);
		signBtn.setOnClickListener(createaccBtnListener);
	}

	OnClickListener createaccBtnListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
        
			
			startActivity(getLoginIntent());
		}
		private Intent getLoginIntent()
		{
			
			return new Intent(getApplicationContext(),
					LoginActivity.class);			
		}
	};
	
}
