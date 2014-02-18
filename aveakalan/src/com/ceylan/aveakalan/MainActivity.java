package com.ceylan.aveakalan;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button btnGorusme=(Button)findViewById(R.id.btnGorusme);
		Button btnInternet=(Button)findViewById(R.id.btnInternet);
		Button btnCikis=(Button)findViewById(R.id.btnCikis);
		
		btnGorusme.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SmsManager smsManager = SmsManager.getDefault();
				smsManager.sendTextMessage("6000", null, "SES", null, null);
				Toast.makeText(getApplicationContext(), "Sms Gönderildi bebeðim", 2000);
			}
		});
		
		btnInternet.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SmsManager smsManager = SmsManager.getDefault();
				smsManager.sendTextMessage("6000", null, "internet", null, null);
				Toast.makeText(getApplicationContext(), "Sms Gönderildi", 2000);
			}
		});
		
		btnCikis.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 finish();
				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
