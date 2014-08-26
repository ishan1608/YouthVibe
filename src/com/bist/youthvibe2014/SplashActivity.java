package com.bist.youthvibe2014;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class SplashActivity extends Activity {
	private final int SPLASH_DISPLAY_LENGTH=5000;
	//ViewFlipper vp;//
	
	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_splash);
		
		        
		//vp=(ViewFlipper)findViewById(R.id.viewFlipper1);
		final MediaPlayer media=MediaPlayer.create(SplashActivity.this, R.raw.y);
		
		media.start();
		
        new Handler().postDelayed(new Runnable() {
        	
			@Override
			public void run() {
			Intent sid=new Intent(SplashActivity.this, FacebookLoginActivity.class);
			SplashActivity.this.startActivity(sid);
			SplashActivity.this.finish();	
			}
		}, SPLASH_DISPLAY_LENGTH);
      
      //  vp.setFlipInterval(1500);
    //    vp.setInAnimation(SplashActivity.this, android.R.anim.fade_in);
     //   vp.startFlipping();
	}
}