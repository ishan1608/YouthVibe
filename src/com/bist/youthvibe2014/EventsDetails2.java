package com.bist.youthvibe2014;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class EventsDetails2 extends Fragment {
	View rootView;

	private String images[] = {"indianfolk"};
	private String imageViews[] = {"imageView1"};
	private ImageView[] imageHolder = new ImageView[8];
	private int viewId;

	@Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		rootView  = inflater.inflate(R.layout.events_details3, container, false);

		// Downloading Library settings
		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity().getApplicationContext()).defaultDisplayImageOptions(defaultOptions).build();
		ImageLoader.getInstance().init(config);

		// Code to use the library provided here https://github.com/nostra13/Android-Universal-Image-Loader
		for(int i=0; i<images.length; i++) {
			viewId = getResources().getIdentifier(imageViews[i], "id", getActivity().getPackageName());
			// Log.d("ViewId : ", ""+id);
			imageHolder[i] = (ImageView) rootView.findViewById(viewId);
			ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/" + images[i] + ".png", imageHolder[i]);
		}

		//ImageView i = (ImageView)rootView.findViewById(R.id.event_image);
		// i.setImageResource(R.drawable.gif);
		//i.setBackgroundResource(R.drawable.gif);

		//AnimationDrawable pro = (AnimationDrawable)i.getBackground();
		//pro.start();

		Button registrationButton;

		registrationButton = (Button) rootView.findViewById(R.id.registrationButton);


		// Library settings
		/*	DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
			ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(defaultOptions).build();
	        ImageLoader.getInstance().init(config);

	        // Code to use the library provided here https://github.com/nostra13/Android-Universal-Image-Loader
	     	ImageView permanentImageView10 = (ImageView) findViewById(R.id.titlepic);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/baselogo.jpg", permanentImageView10);
	        ImageView permanentImageView11 = (ImageView) findViewById(R.id.imageView1);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/indianfolk.jpg", permanentImageView11);
		 */


		registrationButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				/*Events_Details2 nextFraagment = new Events_Details2();
				android.app.FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.events_fragment, nextFraagment);
				transaction.addToBackStack(null);
				transaction.commit();*/
				RegistrationFragment regisFrag = new RegistrationFragment();
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.Relbase, regisFrag);
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});

		return rootView;
	}
}