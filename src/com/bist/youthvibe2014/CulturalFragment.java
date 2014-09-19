package com.bist.youthvibe2014;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class CulturalFragment extends Fragment {
	View rootView;
	//ImageButton SecondImb;
	View relbtn1;

	private String images[] = {"music", "dance", "theatre", "literary", "quiz", "lifestyle", "finearts", "photographyandflimproduction"};
	private String imageViews[] = {"imagev1", "imagev2", "imagev3", "imagev4", "imagev5", "imagev6", "imagev7", "imagev8"};
	private ImageView[] imageHolder = new ImageView[images.length];
	private int viewId;


	@Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		rootView  = inflater .inflate(R.layout.cultural_fragment, container, false);

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

		relbtn1 = rootView.findViewById(R.id.relbtn2);
		relbtn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				EventsFragment nextFragment = new EventsFragment();
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.cultural_fragment, nextFragment);
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});

		return rootView;
	}
}
