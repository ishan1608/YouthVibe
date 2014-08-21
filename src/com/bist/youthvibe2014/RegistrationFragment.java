package com.bist.youthvibe2014;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RegistrationFragment extends Fragment{
	View rootView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView  = inflater.inflate(R.layout.registration_form, container, false);
		return rootView;
	}	
}