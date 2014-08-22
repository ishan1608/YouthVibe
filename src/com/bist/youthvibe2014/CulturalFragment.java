package com.bist.youthvibe2014;

import android.app.Fragment;


import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class CulturalFragment extends Fragment {
	  View rootView;
	  //ImageButton SecondImb;
	  View relbtn1;
	  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	      {
			  rootView  = inflater .inflate(R.layout.cultural_fragment, container, false);
			  /*ImageView i = (ImageView)rootView.findViewById(R.id.event_image);
			  i.setBackgroundResource(R.drawable.gif);
	
			  AnimationDrawable pro = (AnimationDrawable)i.getBackground();
			  pro.start();*/
			// Library settings
				/*DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
				ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(defaultOptions).build();
		        ImageLoader.getInstance().init(config);
		        
		        // Code to use the library provided here https://github.com/nostra13/Android-Universal-Image-Loader
		     	ImageView permanentImageView4 = (ImageView) findViewById(R.id.titlepic);
		        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/baselogo.png", permanentImageView4);
		        ImageView permanentImageView5 = (ImageView) findViewById(R.id.imagevcheck);
		        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/music.png", permanentImageView5);
		        ImageView permanentImageView6 = (ImageView) findViewById(R.id.imagev2);
		        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/dance.png", permanentImageView6);
		        ImageView permanentImageView7 = (ImageView) findViewById(R.id.imagev3);
		        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/theatre.png", permanentImageView7);
		        ImageView permanentImageView8 = (ImageView) findViewById(R.id.imagev3);
		        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/literary.png", permanentImageView8);
		        ImageView permanentImageView9 = (ImageView) findViewById(R.id.imagev3);
		        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/quiz.png", permanentImageView9);
		        ImageView permanentImageView10 = (ImageView) findViewById(R.id.imagev3);
		        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/lifestyle.png", permanentImageView10);
		        ImageView permanentImageView11 = (ImageView) findViewById(R.id.imagev3);
		        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/finearts.png", permanentImageView11);
		        ImageView permanentImageView12 = (ImageView) findViewById(R.id.imagev3);
		        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/photographyandfilmproduction.png", permanentImageView12);
			 
			 */
		        
			 
		        
		        
		        
		        relbtn1 = rootView.findViewById(R.id.relbtn2);
			
				
			        
			  
			  relbtn1.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					EventsFragment nextFragment = new EventsFragment();
					FragmentTransaction transaction = getFragmentManager().beginTransaction();
					transaction.replace(R.id.categories_fragment, nextFragment);
					transaction.addToBackStack(null);
					transaction.commit();
				}
			});

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
