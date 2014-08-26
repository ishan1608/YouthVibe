package com.bist.youthvibe2014;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SportsFragment extends Fragment {
	  View rootView;
	  
	  private String images[] = {"football1", "cricket1", "volleyball", "basketball"};
	  private String imageViews[] = {"imagev1", "imagev2", "imagev3", "imagev4"};
	  private ImageView[] imageHolder = new ImageView[8];
	  private int viewId;
	   
	  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	      {
		  	rootView  = inflater .inflate(R.layout.sports_fragment, container, false);
		  	
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
		  	
		   return rootView;
		   }
}