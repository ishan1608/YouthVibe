package com.bist.youthvibe2014;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

public class Sponsors_Fragment extends Fragment {
	View rootView;
	ViewFlipper  vp;
	   
	  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
      {
	  	rootView  =  inflater.inflate(R.layout.sponsors_fragment, container, false);
	  	
	  	
	  	
	  	vp = (ViewFlipper) rootView.findViewById(R.id.flip1);
	  	vp.setFlipInterval(2000);
	  	vp.setInAnimation(getActivity(), android.R.anim.fade_in);
	  	vp.startFlipping();
	   return rootView;
      }
}