package com.ceylan.aveakalan;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
		
		final SharedPreferences preferences;
		//preferences i�in bir nesne tan�ml�yorum.
		SharedPreferences.Editor editor;
		//preferences i�erisine bilgi girmek i�in tan�mlama
		preferences=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		editor = preferences.edit();
		//Shared Prefences ile mesaj adresi ve i�eriklerini tutuyorum ve i�eriklere ula��yorum
		
		Button btnGorusme=(Button)findViewById(R.id.btnGorusme);
		Button btnInternet=(Button)findViewById(R.id.btnInternet);
		Button btnCikis=(Button)findViewById(R.id.btnCikis);
		Button btnSms=(Button)findViewById(R.id.btnKalanSms);
		Button btnAyarlar=(Button)findViewById(R.id.btnAyarlar);
		//Butonlar�n tan�mlamas�...
		
		//BtnAyarlara t�klay�nca Ayarlar activitysi a��l�yor
		btnAyarlar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent(MainActivity.this,AyarlarActivity.class);
				startActivity(intent);
				
			}
		});
		
		//Btngorusme d��mesiyle g�r��me sorgulamas� i�in mesaj g�nderiyor. 
		btnGorusme.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SmsManager smsManager = SmsManager.getDefault();
				smsManager.sendTextMessage(preferences.getString("gorusmeadres", "6000"), null, preferences.getString("gorusmemesaj", "SES"), null, null);
				Toast.makeText(getApplicationContext(), "Sms G�nderildi", 2000);
			}
		});
		
		//internet sorgusu i�in mesaj
		btnInternet.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SmsManager smsManager = SmsManager.getDefault();
				smsManager.sendTextMessage(preferences.getString("internetadres", "6000"), null, preferences.getString("internetmesaj", "internet"), null, null);
				Toast.makeText(getApplicationContext(), "Sms G�nderildi", 2000);
			}
		});
		
		//sms sorgusu i�in mesaj
		btnSms.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SmsManager smsManager = SmsManager.getDefault();
				smsManager.sendTextMessage(preferences.getString("smsadres", "6000"), null, preferences.getString("smsmesaj", "sms"), null, null);
				Toast.makeText(getApplicationContext(), "Sms G�nderildi", 2000);
			}
		});
		
		//��k�� d��mesi
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
