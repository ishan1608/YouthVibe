package com.bist.youthvibe2014;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

   public class EventsFragment extends Fragment {
	   

	   View rootView;
	   // ImageButton imb1;
	   ImageButton imb2;
	   View relbtn1;
	   View relbtn2;
	   
	   private String images[] = {"folkdance", "indianfolkdance", "indowesterm", "justduet2", "justduet", "nrithya", "yalgar"};
	   private String imageViews[] = {"imagev1", "imagev2", "imagev3", "imagev4", "imagev5", "imagev6", "imagev7"};
	   private ImageView[] imageHolder = new ImageView[8];
	   private int viewId;
	   
  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
      {
	   rootView  = inflater .inflate(R.layout.event_fragment, container, false);
	   
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
 }