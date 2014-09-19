package com.bist.youthvibe2014;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.widget.LoginButton;

public class FacebookLogInFragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.facebook_log_in_fragment, container, false);
		// Reference to the Login Button
		LoginButton authButton = (LoginButton) view.findViewById(R.id.login_button);
		// Aetting the extra permission
		// authButton.setPublishPermissions("publish_actions");
		authButton.setReadPermissions("email");
		
		
		/*// Reference to the Login Button
		Button authButton = (Button) view.findViewById(R.id.login_button);
		// Aetting the extra permission
		String permissionString[] = {"email"};
		permissions = Arrays.asList(permissionString);
		authButton.setPermissions(permissions);*/
		
		return view;
	}
}