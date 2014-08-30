package com.bist.youthvibe2014;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.ProfilePictureView;

public class FacebookLoggedInFragment extends Fragment {
	// private static final String TAG = "SelectionFragment";

	private ProfilePictureView profilePictureView;
	// private TextView userNameView;
	private TextView welcomeMessageView;
	private String userName,userId, userEmail, accessToken;

	private Button continueButton;

	private static final int REAUTH_ACTIVITY_CODE = 100;

	private UiLifecycleHelper uiHelper;

	private Session.StatusCallback callback = new Session.StatusCallback() {
		@Override
		public void call(final Session session, final SessionState state, final Exception exception) {
			onSessionStateChange(session, state, exception);
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		uiHelper = new UiLifecycleHelper(getActivity(), callback);
		uiHelper.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View view = inflater.inflate(R.layout.facebook_logged_in_fragment, container, false);

		// The continue button
		continueButton = (Button) view.findViewById(R.id.continueButton);
		// Disabling the button
		continueButton.setEnabled(false);
		continueButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Continuing to activity
				Intent nextScreen = new Intent(getActivity(), MainActivity.class);
				Bundle userInfo = new Bundle();
				userInfo.putString("id", userId);
				userInfo.putString("email",  userEmail);
				userInfo.putString("token", accessToken);
				userInfo.putString("name", userName);
				nextScreen.putExtras(userInfo);
				startActivity(nextScreen);
			}
		});

		// Find the user's profile picture custom view
		profilePictureView = (ProfilePictureView) view.findViewById(R.id.selection_profile_pic);
		profilePictureView.setCropped(true);

		// Find the user's name view
		// userNameView = (TextView) view.findViewById(R.id.selection_user_name);
		welcomeMessageView = (TextView) view.findViewById(R.id.welcomeMessage);

		// Check for an open session
		Session session = Session.getActiveSession();
		if (session != null && session.isOpened()) {
			// Get the user's data
			makeMeRequest(session);
		}

		return view;
	}

	private void onSessionStateChange(final Session session, SessionState state, Exception exception) {
		if (session != null && session.isOpened()) {
			// Get the user's data.
			makeMeRequest(session);
		}
	}

	private void makeMeRequest(final Session session) {
		// Make an API call to get user data and define a 
		// new callback to handle the response.
		Request request = Request.newMeRequest(session, new Request.GraphUserCallback() {
			@Override
			public void onCompleted(GraphUser user, Response response) {
				// If the response is successful
				if (session == Session.getActiveSession()) {
					if (user != null) {
						// Set the id for the ProfilePictureView
						// view that in turn displays the profile picture.
						profilePictureView.setProfileId(user.getId());
						// Set the Textview's text to the user's name.
						// userNameView.setText(user.getName());
						userName = user.getName();
						welcomeMessageView.setText("Welcome " + userName + "\nPlease Conitnue");

						// Working
						userId = user.getId();
						Log.d("ID: ", userId);
						// Log.d("UserData : ", user.toString());
						userEmail = user.asMap().get("email").toString();
						Log.d("email : ", userEmail);
						// Log.d("Session :", session.toString());
						accessToken = session.getAccessToken();
						Log.d("Access Token :", "" + accessToken);

						// Enabling the button
						continueButton.setText("Continue");
						continueButton.setEnabled(true);
					}
				}
				if (response.getError() != null) {
					// Handle errors, will do so later.
				}
			}
		});
		request.executeAsync();
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REAUTH_ACTIVITY_CODE) {
			uiHelper.onActivityResult(requestCode, resultCode, data);
		}
	}

	@Override
	public void onResume() {
		super.onResume();
		uiHelper.onResume();
	}

	@Override
	public void onSaveInstanceState(Bundle bundle) {
		super.onSaveInstanceState(bundle);
		uiHelper.onSaveInstanceState(bundle);
	}

	@Override
	public void onPause() {
		super.onPause();
		uiHelper.onPause();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		uiHelper.onDestroy();
	}

}