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

public class TechnicalCategoriesFragment extends Fragment	  
{
	LinearLayout relsec1;
	LinearLayout relsec2;
	int id;
	// ImageView imgv;
	// String imgval="";
	View rootView;
	
	// int totalSections = 12;

	// private ImageView[] imageHolder = new ImageView[totalSections];
	private ImageView[] imageHolder;
	// private int viewId;
	private int progressId;
	
	private String[] imageItems;
	private String[] mechatronixImages = {"techincal_mechatronix_the_battle_ship", "techincal_mechatronix_robo_wrestle_mania", 
			"techincal_mechatronix_dark_horse", "techincal_mechatronix_gear_up", "techincal_mechatronix_aviator", 
			"techincal_mechatronix_aqua_jet", "techincal_mechatronix_circuitiry"};
	private String[] abacusImages = {"techincal_abacus_master_o_codes", "techincal_abacus_app_builder", "techincal_abacus_web_builder", 
			"techincal_abacus_image_masher", "techincal_abacus_algo_designer", "techincal_abacus_tic_tac_toe", "techincal_abacus_just_in_a_sec"};
	private String[] exhibitorImages = {"techincal_exhibitor_the_architect", "techincal_exhibitor_the_scientist", "techincal_exhibitor_the_stylish"};
	private String[] presentorImages = {"techincal_presentor_paper_presentation", "techincal_presentor_project_presentation"};
	
	private int categoryPosition, eventPosition;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		rootView  = inflater.inflate(R.layout.main_category_fragment, container, false);
		
		Bundle categoryBundle = getArguments();
		final String catPos=categoryBundle.getString("categoryPosition");
		categoryPosition = Integer.parseInt(catPos);
		
		switch(categoryPosition) {
			case 0:
				imageItems = mechatronixImages;
			break;
			case 1:
				imageItems = abacusImages;
			break;
			case 2:
				imageItems = exhibitorImages;
			break;
			case 3:
				imageItems = presentorImages;
			break;
			default:
				imageItems = null;
			break;
		}
		
		
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
			
			// Creating eventPos, catPos is already available 
			eventPosition = i;
			final String eventPos= "" + eventPosition;
			imageHolder[i].setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// We are going to use this
					Bundle categoryBundle = new Bundle();
					categoryBundle.putString("categoryPosition", catPos);
					categoryBundle.putString("eventPosition", eventPos);
					TechnicalDetailsFragment nextFragment = new TechnicalDetailsFragment();
					
					nextFragment.setArguments(categoryBundle);
					
					FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
					transaction.replace(R.id.main_categories_fragment_container, nextFragment);
					transaction.addToBackStack(null);
					// Toast.makeText(getActivity().getApplicationContext(), "onClickCalled", Toast.LENGTH_SHORT).show();
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