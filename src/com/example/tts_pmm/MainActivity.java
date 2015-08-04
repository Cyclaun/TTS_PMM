package com.example.tts_pmm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener{

	
	Button btn1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btn1 = (Button) findViewById(R.id.btnAudio);
		btn1.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				
			Intent audio = new Intent(MainActivity.this,Audio.class);
			startActivity(audio);	
			}
		});
		
		((Button) findViewById(R.id.btnVideo))
		.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				finish();
				MainActivity.this.startActivity(new Intent(
						MainActivity.this, Video.class));
			}
		});
		
		((Button) findViewById(R.id.btnSpeech))
		.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				finish();
				MainActivity.this.startActivity(new Intent(
						MainActivity.this, Speech.class));
			}
		});
    }

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}

}
