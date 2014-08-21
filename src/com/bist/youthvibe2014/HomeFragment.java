package com.bist.youthvibe2014;

import android.app.Fragment;

import android.content.Context;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewFlipper;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;




	public class HomeFragment extends Fragment {
		View rootView;
		ViewFlipper vp,vp2;
		
		@Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
		{
		  	rootView  = inflater .inflate(R.layout.home_fragment, container, false);
		  	

			// Library settings
		/*	DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
			ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(defaultOptions).build();
	        ImageLoader.getInstance().init(config);
	        
	        // Code to use the library provided here https://github.com/nostra13/Android-Universal-Image-Loader
	     	ImageView permanentImageViews1 = (ImageView) findViewById(R.id.imageView1);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/z.jpg", permanentImageViews1);
         // Code to use the library provided here https://github.com/nostra13/Android-Universal-Image-Loader
	     	ImageView permanentImageView2 = (ImageView) findViewById(R.id.imageView3);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/y.jpg", permanentImageView2);
	      	ImageView permanentImageView3 = (ImageView) findViewById(R.id.imageView2);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/x.jpg", permanentImageView3);
	      	ImageView permanentImageView4 = (ImageView) findViewById(R.id.imageView4);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/w.jpg", permanentImageView4);
	        */
		  	
		  	
		  	vp = (ViewFlipper) rootView.findViewById(R.id.viewFlipper1);
		  	vp.setFlipInterval(2000);
		  	vp.setInAnimation(getActivity(), android.R.anim.fade_in);
		  	vp.startFlipping();
		  	vp2 = (ViewFlipper) rootView.findViewById(R.id.viewFlipper2);
		  	vp2.setFlipInterval(2000);
		  	vp2.setInAnimation(getActivity(), android.R.anim.fade_in);
		  	vp2.startFlipping();
		 
		  	return rootView;
	  	}
		private ImageView findViewById(int imageview1) {
			// TODO Auto-generated method stub
			return null;
		}
		private Context getApplicationContext() {
			// TODO Auto-generated method stub
			return null;
		}
		public boolean onCreateOptionsMenu(Menu menu)
		{
			// Inflate the menu; this adds items to the action bar if it is present.
			getActivity().getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}
}