package com.bist.youthvibe2014;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


@SuppressLint("SetJavaScriptEnabled")
public class LikeFragment extends Fragment
{
	View rootView;
	WebView wv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		rootView  = inflater .inflate(R.layout.like_fragment, container, false);
		wv=(WebView)rootView.findViewById(R.id.webView1);

		try
		{
			wv.getSettings().setJavaScriptEnabled(true);//XSS
			wv.getSettings().setLoadWithOverviewMode(true);
			wv.getSettings().setUseWideViewPort(true);
			wv.setWebViewClient(new ourWebViewClient());
			wv.loadUrl("https://m.facebook.com/YouthVibe");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rootView; 		
	}
}