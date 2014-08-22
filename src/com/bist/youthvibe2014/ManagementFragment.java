package com.bist.youthvibe2014;

import android.app.Fragment;
import android.content.Context;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class ManagementFragment  extends Fragment {
	  View rootView;
	   
	  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	      {
		   rootView  = inflater.inflate(R.layout.management_fragment, container, false);
		   /*ImageView i = (ImageView)rootView.findViewById(R.id.event_image);
			  i.setBackgroundResource(R.drawable.gif);
			  AnimationDrawable pro = (AnimationDrawable)i.getBackground();
			    pro.start();*/

				// Library settings
			/*	DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
				ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(defaultOptions).build();
		        ImageLoader.getInstance().init(config);
		        
		        // Code to use the library provided here https://github.com/nostra13/Android-Universal-Image-Loader
		     	ImageView permanentImageView1 = (ImageView) findViewById(R.id.titlepic);
		        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/baselogo.jpg", permanentImageView1);
		    	ImageView permanentImageView2 = (ImageView) findViewById(R.id.imagevcheck);
		        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/strategy1.jpg", permanentImageView2);
		    	ImageView permanentImageView3 = (ImageView) findViewById(R.id.imagev2);
		        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/bplan.jpg", permanentImageView3);
		    	ImageView permanentImageView4 = (ImageView) findViewById(R.id.imagev3);
		        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/victoria.jpg", permanentImageView4);
		    	ImageView permanentImageView5 = (ImageView) findViewById(R.id.imagev4);
		        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/casedevelopment.jpg", permanentImageView5);
		        ImageView permanentImageView6 = (ImageView) findViewById(R.id.imagev5);
		        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/strategy.jpg", permanentImageView6);
		        ImageView permanentImageView7 = (ImageView) findViewById(R.id.imagev6);
		        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/simulationgame.jpg", permanentImageView7);
		  */
		   return rootView;
	      }

	private ImageView findViewById(int titlepic) {
		// TODO Auto-generated method stub
		return null;
	}

	private Context getApplicationContext() {
		// TODO Auto-generated method stub
		return null;
	}


}