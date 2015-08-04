package com.example.tts_pmm;

import java.util.Locale;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Speech extends ActionBarActivity implements OnInitListener {

	TextToSpeech TTS;
	EditText editText1;
	Button btnPlay;
	
	@Override
    protected void onCreate(Bundle savedInstanceState){
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.speech);
    	
    	TTS = new TextToSpeech(Speech.this, Speech.this);
    	editText1 = (EditText) findViewById(R.id.editText1);
    	btnPlay = (Button) findViewById(R.id.btnPlay);
    	btnPlay.setOnClickListener(new OnClickListener(){
    	
    		@Override
    		public void onClick(View v){
    			TTS.speak(editText1.getText().toString(), TextToSpeech.QUEUE_ADD,null);
    		}
    		
    	});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
    public void onInit(int status){
    	TTS.setLanguage(Locale.ENGLISH);
    }

}
