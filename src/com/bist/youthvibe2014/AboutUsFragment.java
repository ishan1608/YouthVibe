package com.bist.youthvibe2014;

import android.app.Fragment;
import android.content.Context;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
// import android.widget.Toast;
import android.widget.ViewFlipper;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;




   public class AboutUsFragment extends Fragment {

	   Button btn;
	   View rootView;
	   ViewFlipper vp;
	   
  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
      {
	   rootView  = inflater .inflate(R.layout.aboutus_fragment, container, false);
	   /*ImageView i = (ImageView)rootView.findViewById(R.id.event_image);
		  i.setBackgroundResource(R.drawable.gif);
		  AnimationDrawable pro = (AnimationDrawable)i.getBackground();
		    pro.start();*/
		    
	/*	 // Library settings
			DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
			ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(defaultOptions).build();
	        ImageLoader.getInstance().init(config);
	        
	        // Code to use the library provided here https://github.com/nostra13/Android-Universal-Image-Loader
	     	ImageView permanentImageView = (ImageView) findViewById(R.id.img1);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/collag1.jpg", permanentImageView);
	        
	        ImageView permanentImageView1 = (ImageView) findViewById(R.id.img2);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/collag2.jpg", permanentImageView);
	        
	        ImageView permanentImageView2 = (ImageView) findViewById(R.id.img3);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/collag3.jpg", permanentImageView);
	        */
		    
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