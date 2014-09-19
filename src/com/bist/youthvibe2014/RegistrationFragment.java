package com.bist.youthvibe2014;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class RegistrationFragment extends Fragment{
	View rootView;
	// Spinner spinner;
	WebView wv;
	@SuppressLint("SetJavaScriptEnabled")
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		/*rootView  = inflater.inflate(R.layout.registration_form, container, false);

		Spinner dropdown = (Spinner)rootView.findViewById(R.id.spinner1);
		String[] items = new String[]{"Folk Dance", "Indian Folk Dance", "Indo Western","Just Duet","Nritya","Yalgaar"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, items);
		dropdown.setAdapter(adapter);*/
		rootView  = inflater .inflate(R.layout.registration_fragment, container, false);
		wv=(WebView)rootView.findViewById(R.id.registrations_web_view);

		try
		{
			wv.getSettings().setJavaScriptEnabled(true);//XSS
			wv.getSettings().setLoadWithOverviewMode(true);
			wv.getSettings().setUseWideViewPort(true);
			wv.setWebViewClient(new ourWebViewClient());
			wv.loadUrl("http://www.youthvibe.in/Register/");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rootView;
	}	
}