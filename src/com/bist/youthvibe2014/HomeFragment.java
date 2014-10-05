package com.bist.youthvibe2014;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class HomeFragment extends Fragment {
	View rootView;
	WebView homeWebView;
	@Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		rootView  = inflater .inflate(R.layout.home_fragment, container, false);
		homeWebView = (WebView) rootView.findViewById(R.id.homeWebview);
		try
		{
			homeWebView.getSettings().setJavaScriptEnabled(true);//XSS
			homeWebView.getSettings().setLoadWithOverviewMode(true);
			homeWebView.getSettings().setUseWideViewPort(true);
			homeWebView.setWebViewClient(new ourWebViewClient());
			homeWebView.loadUrl("file:///android_asset/home.html");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rootView;
	}

	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getActivity().getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}