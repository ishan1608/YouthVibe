package com.bist.youthvibe2014;

import android.app.Fragment;
import android.content.Context;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;


import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
// import android.widget.Toast;




   public class EventsFragment extends Fragment {

	   View rootView;
	   // ImageButton imb1;
	   ImageButton imb2;
	   View relbtn1;
	   View relbtn2;
	   
  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
      {
	   rootView  = inflater .inflate(R.layout.event_fragment, container, false);
	   
	// Library settings
		/*	DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
			ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(defaultOptions).build();
	        ImageLoader.getInstance().init(config);
	        
	        // Code to use the library provided here https://github.com/nostra13/Android-Universal-Image-Loader
	     	ImageView permanentImageView8 = (ImageView) findViewById(R.id.titlepic);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/baselogo.jpg", permanentImageView8);
	        ImageView permanentImageView9 = (ImageView) findViewById(R.id.imagevcheck);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/folkdance.jpg", permanentImageView9);
	        ImageView permanentImageView10 = (ImageView) findViewById(R.id.imagev2);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/indiafolkdance.jpg", permanentImageView10);
	        ImageView permanentImageView11 = (ImageView) findViewById(R.id.titlepic);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/indowesterm.jpg", permanentImageView11);
	        ImageView permanentImageView12 = (ImageView) findViewById(R.id.titlepic);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/justduet2.jpg", permanentImageView12);
	        ImageView permanentImageView13 = (ImageView) findViewById(R.id.titlepic);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/justduet.jpg", permanentImageView13);
	        ImageView permanentImageView14 = (ImageView) findViewById(R.id.titlepic);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/nritya.jpg", permanentImageView14);
	        ImageView permanentImageView15 = (ImageView) findViewById(R.id.titlepic);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/yalgar.jpg", permanentImageView15);
	        */
	   
	   // imb1=(ImageButton)rootView.findViewById(R.id.imageButton1);
	   
	  // imb2=(ImageButton)rootView.findViewById(R.id.imageButton2);
	   relbtn1 = rootView.findViewById(R.id.relcheck1);
	   relbtn2 = rootView.findViewById(R.id.relbtn2);
	    // i.setImageResource(R.drawable.gif);
	  
	    /*imb1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub	
				// Toast.makeText(getActivity(), "toast toast toast",Toast.LENGTH_SHORT).show();
				
				
				CategoriesFragment nextFraagment = new CategoriesFragment();
				android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.events_fragment, nextFraagment);
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
		*/
	   
	    relbtn2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EventsDetails2 nextFraagment = new EventsDetails2();
				android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.events_fragment, nextFraagment);
				transaction.addToBackStack(null);
				transaction.commit();	
				
			}
		});
	    
	    relbtn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// Toast.makeText(getActivity(), "toast toast toast",Toast.LENGTH_SHORT).show();
				
				/*Event_fragment2 newFragment = new Event_fragment2();
				android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.events_fragment, newFragment);
				transaction.addToBackStack(null);
				transaction.commit();
				*/	
				CulturalFragment nextFraagment = new CulturalFragment();
				android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.events_fragment, nextFraagment);
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
	    
	
	   return rootView;
	   
      }

private Context getApplicationContext() {
	// TODO Auto-generated method stub
	return null;
}

private ImageView findViewById(int titlepic) {
	// TODO Auto-generated method stub
	return null;
}

 }