package com.bist.youthvibe2014;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;




   public class AboutUsFragment extends Fragment {

	   Button btn;
	   View rootView;
	   ViewFlipper vp;
	   
	   private String images[] = {"collag2", "collag1", "collag3"};
		private String imageViews[] = {"img1", "img2", "img3"};
		private ImageView[] imageHolder = new ImageView[8];
		private int viewId;
	   
  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
      {
	   rootView  = inflater .inflate(R.layout.aboutus_fragment, container, false);
	   
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
		        
		 vp= (ViewFlipper) rootView.findViewById(R.id.viewFlipper21);
	  	vp.setFlipInterval(2000);
	  	vp.setInAnimation(getActivity(), android.R.anim.fade_in);
	  	vp.startFlipping();
	   

	   
	   
	   // Toast.makeText(getActivity(), "about us toast from fragment", Toast.LENGTH_SHORT).show();
	   return rootView;
      }

/*private ImageView findViewById(int img1) {
	// TODO Auto-generated method stub
	return null;
}

private Context getApplicationContext() {
	// TODO Auto-generated method stub
	return null;
}*/

 }