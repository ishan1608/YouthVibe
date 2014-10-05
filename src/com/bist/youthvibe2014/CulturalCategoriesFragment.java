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

public class CulturalCategoriesFragment extends Fragment	  
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
	private String[] musicImages = {"cultural_music_folkalley", "cultural_music_folkgeet","cultural_music_goonj", "cultural_music_armagedon", "cultural_music_legacy", "cultural_music_rapstar", "cultural_music_voiceofyv", "cultural_music_rythm", "cultural_music_yvunplugged"};
	private String[] danceImages = {"cultural_dance_thedancingsoul", "cultural_dance_downthestreet", "cultural_dance_thedancingmessangers", "cultural_dance_Justduet", "cultural_dance_footloose", "cultural_dance_indianfolkdance", "cultural_dance_folkingham","cultural_dance_nrityanatraj","cultural_dance_boxoffice"};
	private String[] theatreImages = {"cultural_theatre_chaupal", "cultural_theatre_kalaajaurkal", "cultural_theatre_atrangi", "cultural_theatre_nakalchee","cultural_theatre_darbaar"};
	private String[] quizingImages = {"cultural_quizing_yvgenralquiz", "cultural_quizing_bizwiz", "cultural_quizing_sportica","cultural_quizing_thewoodquiz","cultural_quizing_entertainmentquiz"};
	private String[] litraryImages = {"cultural_litrary_thedebatechampionship", "cultural_litrary_robustspeaker", "cultural_litrary_lordofthewords", "cultural_litrary_turncoat", "cultural_litrary_poetryrecitationcumwriting"};
	private String[] lifestyleImages = {"cultural_lifestyle_fashionshow", "cultural_lifestyle_yvmodelhunt"};
	private String[] fineartsImages = {"cultural_finearts_vibgyor", "cultural_finearts_chalktalk", "cultural_finearts_dawn2dusk","cultural_finearts_imagination","cultural_finearts_thepermanentcrayons","cultural_finearts_heena","cultural_finearts_gossipogirl","cultural_finearts_laurel", "cultural_crafting_marathon", "cultural_expedition_marathon", "cultural_quill_arts_marathon"};
	private String[] photographyandfilmproductionImages = {"cultural_photographyandfilmproduction_perfectpicture", "cultural_photographyandfilmproduction_directorscut", "cultural_photographyandfilmproduction_realtoreel"};
	
	private int categoryPosition, eventPosition;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		rootView  = inflater.inflate(R.layout.cultural_fragment, container, false);
		
		Bundle categoryBundle = getArguments();
		final String catPos=categoryBundle.getString("categoryPosition");
		categoryPosition = Integer.parseInt(catPos);
		
		switch(categoryPosition) {
			case 0:
				imageItems = musicImages;
			break;
			case 1:
				imageItems = danceImages;
			break;
			case 2:
				imageItems = theatreImages;
			break;
			case 3:
				imageItems = fineartsImages;
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
					CulturalDetailsFragment nextFragment = new CulturalDetailsFragment();
					
					nextFragment.setArguments(categoryBundle);
					
					FragmentTransaction transaction = getActivity().getFragmentManager().beginTransaction();
					transaction.replace(R.id.cultural_categories_fragment_container, nextFragment);
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