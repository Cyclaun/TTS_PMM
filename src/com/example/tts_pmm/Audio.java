 package com.example.tts_pmm;

import java.io.IOException;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;


public class Audio extends Activity  implements OnSeekBarChangeListener{
	
	Button play,stop;
	SeekBar sb;
	MediaPlayer mp;
	AudioManager am;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.audio);
        
        play = (Button) findViewById(R.id.btnPlay);
        stop = (Button) findViewById(R.id.btnStop);
        sb = (SeekBar) findViewById(R.id.seekBarV);
        mp = new MediaPlayer();
        
        am = (AudioManager) getSystemService(this.AUDIO_SERVICE);
        int maxVolume = am.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curVolume = am.getStreamVolume(AudioManager.STREAM_MUSIC);
        sb.setMax(maxVolume);
        sb.setProgress(curVolume);
        sb.setOnSeekBarChangeListener(this);
        
        play.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(!mp.isPlaying()){
					try {
						mp.prepare();
					} catch (IllegalStateException e) {
						e.printStackTrace();
					}catch (IOException e) {
						e.printStackTrace();
					}
					play.setText("Pause");
					mp.start();
				}else if(mp.isPlaying()){
					play.setText("Play");
					mp.pause();
				}
			}
		});
        
        stop.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(mp.isPlaying()){
					mp.stop();
					play.setText("Play");
					onStart();
				}
			}
		});
        
    }
    
    protected void onPause(){
    	super.onPause();
    	mp.release();
    }
    
    protected void onStart() {
		super.onStart();
		mp = MediaPlayer.create(this, R.raw.thebegining);
		try {
			mp.prepare();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		am.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
		
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		// TODO Auto-generated method stub
		
	}
}
