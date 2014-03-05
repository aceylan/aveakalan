package com.ceylan.aveakalan;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AyarlarActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ayarlar);
		// Show the Up button in the action bar.
		setupActionBar();
		
		SharedPreferences preferences;
		//preferences için bir nesne tanýmlýyorum.
		final SharedPreferences.Editor editor;
		//preferences içerisine bilgi girmek için tanýmlama
		preferences=PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
		editor = preferences.edit();
		
		//Textview tanýmlamalasý
		final TextView txtgorusmeadres=(TextView)findViewById(R.id.txtKalanGorusmeAdres);
		final TextView txtgorusmemesaj=(TextView)findViewById(R.id.txtKalanGorusmeMesaj);
		final TextView txtinternetadres=(TextView)findViewById(R.id.txtKalanInternetAdres);
		final TextView txtinternetmesaj=(TextView)findViewById(R.id.txtKalanInternetMesaj);
		final TextView txtsmsadres=(TextView)findViewById(R.id.txtKalanSmsAdres);
		final TextView txtsmsicerik=(TextView)findViewById(R.id.txtKalanSmsicerik);
		//Kaydetme butonu tanýmlamasý
		Button btnkaydet=(Button)findViewById(R.id.btnKaydet);
		
		//Görüþme adresi ve mesajýnýn içeriðini doldur. Kayýtlýysa doldur kayýtlý deðilse 6000, SES bilgilerini  yaz...
		txtgorusmeadres.setText(preferences.getString("gorusmeadres", "6000"));
		txtgorusmemesaj.setText(preferences.getString("gorusmemesaj", "SES"));
		
		txtinternetadres.setText(preferences.getString("internetadres", "6000"));
		txtinternetmesaj.setText(preferences.getString("internetmesaj", "internet"));
		
		txtsmsadres.setText(preferences.getString("smsadres", "6000"));
		txtsmsicerik.setText(preferences.getString("smsicerik", "sms"));
		
		//Kaydetme düðmesine týklandýðýnda bilgiler kaydedilecek. 
		btnkaydet.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				editor.putString("gorusmeadres", txtgorusmeadres.getText().toString());
				editor.putString("gorusmemesaj", txtgorusmemesaj.getText().toString());
				editor.putString("internetadres", txtinternetadres.getText().toString());
				editor.putString("internetmesaj", txtinternetmesaj.getText().toString());
				editor.putString("smsadres", txtsmsadres.getText().toString());
				editor.putString("smsicerik", txtsmsicerik.getText().toString());
				editor.commit();
				//Ayarlar Kaydedildi mesajý
				Toast.makeText(getBaseContext(), "Ayarlar Kaydedildi ;)", 2000);
			}
		});
		
		
		
		
		
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ayarlar, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
