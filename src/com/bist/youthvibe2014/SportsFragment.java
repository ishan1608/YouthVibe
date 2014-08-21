package com.bist.youthvibe2014;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class SportsFragment extends Fragment {
	  View rootView;
	   
	  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	      {
			    rootView  = inflater .inflate(R.layout.activity_sports_fragment, container, false);
				  ImageView i = (ImageView)rootView.findViewById(R.id.event_image);
				  i.setBackgroundResource(R.drawable.gif);
		
				  AnimationDrawable pro = (AnimationDrawable)i.getBackground();
				  pro.start();
			    
		   return rootView;
}}