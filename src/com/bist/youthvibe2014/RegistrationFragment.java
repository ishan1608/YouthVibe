package com.bist.youthvibe2014;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class RegistrationFragment extends Fragment{
	View rootView;
	Spinner spinner;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView  = inflater.inflate(R.layout.registration_form, container, false);

		Spinner dropdown = (Spinner)rootView.findViewById(R.id.spinner1);
		String[] items = new String[]{"Folk Dance", "Indian Folk Dance", "Indo Western","Just Duet","Nritya","Yalgaar"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);
		dropdown.setAdapter(adapter);
		return rootView;
	}	
}