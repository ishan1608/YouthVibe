package com.bist.youthvibe2014;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MediaEventsFragment extends Fragment	  
{
	LinearLayout relsec1;
	LinearLayout relsec2;
	int id;
	// ImageView imgv;
	String imgval="";
	View rootView;
	
	// int totalSections = 12;

	// private ImageView[] imageHolder = new ImageView[totalSections];
	private ImageView[] imageHolder;
	// private int viewId;
	private int progressId;
	
	String[] imageItems = {};
	//imageItems[12]="folkclass";

	@Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		rootView  = inflater .inflate(R.layout.media_events_fragment , container, false);
		imageHolder = new ImageView[imageItems.length];

		// Downloading Library settings
		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity().getApplicationContext()).defaultDisplayImageOptions(defaultOptions).build();
		ImageLoader.getInstance().init(config);

		relsec1 = (LinearLayout)rootView.findViewById(R.id.relsec1);
		relsec2 = (LinearLayout)rootView.findViewById(R.id.relsec2);
		
		progressId = getResources().getIdentifier("progress_circle", "drawable", getActivity().getPackageName());
		for(int i=0; i<imageItems.length; i++) {
			// id = getResources().getIdentifier(imageItems[i], "drawable", getActivity().getPackageName());
			// imgv = new ImageView(getActivity());
			imageHolder[i] = new ImageView(getActivity());
			// imgv.setMaxHeight((int)height);
			// imgv.setMaxWidth((int)width);

			// imgv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			lp.setMargins(10, 15, 10, 15);
			imageHolder[i].setLayoutParams(lp);
			// imgv.setImageDrawable(getResources().getDrawable(id));
			// Working but we have to download from the internet
			// imageHolder[i].setImageDrawable(getResources().getDrawable(id));
			// Setting the Loader image
			imageHolder[i].setImageDrawable(getResources().getDrawable(progressId));
			// Downloading the image
			ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/" + imageItems[i] + ".png", imageHolder[i]);
			
			imgval=""+i;
			final String val= imgval.toString();
			imageHolder[i].setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					Bundle categoryBundle = new Bundle();
					categoryBundle.putString("categoryPosition", val);
					
					TechnicalCategoriesFragment nextFragment = new TechnicalCategoriesFragment();
					
					nextFragment.setArguments(categoryBundle);
					
					FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
					transaction.replace(R.id.media_events_fragment_container , nextFragment);
					transaction.addToBackStack(null);
					transaction.commit();
				}
			});

			if(i%2 == 0) {
				relsec1.addView(imageHolder[i]);
			} else {
				relsec2.addView(imageHolder[i]);
			}
		}
		// imgv.invalidate();
		return rootView;
	}
}