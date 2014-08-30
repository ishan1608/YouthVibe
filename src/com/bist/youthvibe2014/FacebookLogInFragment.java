package com.bist.youthvibe2014;

import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.widget.LoginButton;

public class FacebookLogInFragment extends Fragment {
	List<String> permissions;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.facebook_log_in_fragment, container, false);
		// Reference to the Login Button
		LoginButton authButton = (LoginButton) view.findViewById(R.id.login_button);
		// Aetting the extra permission
		permissions = Arrays.asList("email");
		authButton.setReadPermissions(permissions);
		return view;
	}
}