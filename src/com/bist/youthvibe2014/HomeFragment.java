package com.bist.youthvibe2014;

import android.app.Fragment;
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

	private String images[] = {"z", "y", "x", "w"};
	private String imageViews[] = {"imageView1", "imageView3", "imageView2", "imageView4"};
	private ImageView[] imageHolder = new ImageView[8];
	private int viewId;

	@Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		rootView  = inflater .inflate(R.layout.home_fragment, container, false);

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

	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getActivity().getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}