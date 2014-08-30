package com.bist.youthvibe2014;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class DialogActivity extends Activity {
	ImageView inspirationsLogo;
	Animation rotation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_dialog);

		// Downloading Library settings
		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(defaultOptions).build();
		ImageLoader.getInstance().init(config);

		inspirationsLogo = (ImageView) findViewById(R.id.inspirations_logo);		
		ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/" + "inslogo" + ".png", inspirationsLogo);

		rotation = AnimationUtils.loadAnimation(this, R.anim.rotation);

		inspirationsLogo.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				rotation.setRepeatCount(0);
				inspirationsLogo.startAnimation(rotation);
			}
		});
		inspirationsLogo.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				rotation.setRepeatCount(Animation.INFINITE);
				inspirationsLogo.startAnimation(rotation);
				return true;
			}
		});
	}

	/**
	 * Callback method defined by the View
	 * @param v
	 */
	public void finishDialog(View v) {
		DialogActivity.this.finish();
	}
}
