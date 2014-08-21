package com.bist.youthvibe2014;

import java.util.Locale;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class MapFragment extends Fragment {
	 View rootView;
	   
	  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	      {
		   rootView  = inflater.inflate(R.layout.map_fragment, container, false);
		   Double latitude = 31.2536, longitude = 75.7037;
		   
		   String uri = String.format(Locale.ENGLISH, "geo:%f,%f", latitude, longitude);
		   final Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
		   Button googleMapsButton = (Button) rootView.findViewById(R.id.google_maps_button);
		   googleMapsButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View arg0) {
					getActivity().startActivity(intent);
				}
			});
		   return rootView;
	      }
}
