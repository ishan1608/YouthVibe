package com.bist.youthvibe2014;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapsFrag extends Fragment {
	View rootView;

	@Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		rootView  = inflater.inflate(R.layout.map_fragment, container, false);
		// Get a handle to the Map Fragment
		// GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		GoogleMap map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();

		LatLng lovely = new LatLng(31.2536, 75.7037);

		map.setMyLocationEnabled(true);
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(lovely, 17));

		map.addMarker(new MarkerOptions()
		.title("Lovely Professional University")
		.snippet("The land of unexpected.")
		.position(lovely));
		return rootView;
	}
}
