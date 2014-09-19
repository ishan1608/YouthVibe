package com.bist.youthvibe2014;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.Request;
import com.facebook.RequestAsyncTask;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;
import com.facebook.model.GraphUser;
import com.facebook.widget.ProfilePictureView;
import com.google.android.gms.gcm.GoogleCloudMessaging;

public class FacebookLoggedInFragment extends Fragment {
	// private static final String TAG = "SelectionFragment";

	private ProfilePictureView profilePictureView;
	// private TextView userNameView;
	private TextView welcomeMessageView;
	private String userName,userId, userEmail, accessToken;

	private Button continueButton;
	private Button logoutButton;
	private Button shareButton;

	private static final int REAUTH_ACTIVITY_CODE = 100;

	private UiLifecycleHelper uiHelper;

	private Session.StatusCallback callback = new Session.StatusCallback() {
		@Override
		public void call(final Session session, final SessionState state, final Exception exception) {
			onSessionStateChange(session, state, exception);
		}
	};

	// GCM Notifications
	private Context context;
	GoogleCloudMessaging gcm;
	String GCMRegistrationID;
	/**
     * Tag used on log messages.
     */
    static final String TAG = "FacebookGCM";
    public static final String PROPERTY_REG_ID = "registration_id";
    private static final String PROPERTY_APP_VERSION = "appVersion";
    
    /**
     * Substitute you own sender ID here. This is the project number you got
     * from the API Console, as described in "Getting Started."
     */
    String SENDER_ID = "831370205433";
    
    // Facebook publish_actions requirements
    private static final List<String> PERMISSIONS = Arrays.asList("publish_actions");
    private static final String PENDING_PUBLISH_KEY = "pendingPublishReauthorization";
    private boolean pendingPublishReauthorization = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		uiHelper = new UiLifecycleHelper(getActivity(), callback);
		uiHelper.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		View rootView = inflater.inflate(R.layout.facebook_logged_in_fragment, container, false);

		// The continue button
		continueButton = (Button) rootView.findViewById(R.id.continueButton);
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
				userInfo.putString("newNotices", ((FacebookLoginActivity) getActivity()).getNewNotices());
				nextScreen.putExtras(userInfo);
				startActivity(nextScreen);
			}
		});
		
		// The logout button
		logoutButton = (Button) rootView.findViewById(R.id.logOutButton);
		logoutButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// ((FacebookLoginActivity)getActivity()).showFragment(((FacebookLoginActivity)getActivity()).SETTINGS, true);
				((FacebookLoginActivity)getActivity()).showFragment(FacebookLoginActivity.SETTINGS, true);
			}
		});

		// Find the user's profile picture custom view
		profilePictureView = (ProfilePictureView) rootView.findViewById(R.id.selection_profile_pic);
		profilePictureView.setCropped(true);

		// Find the user's name view
		// userNameView = (TextView) view.findViewById(R.id.selection_user_name);
		welcomeMessageView = (TextView) rootView.findViewById(R.id.welcomeMessage);

		// Check for an open session
		Session session = Session.getActiveSession();
		if (session != null && session.isOpened()) {
			// First try to get the userData from the preferences if there is no internet
			// Get the user's data
			makeMeRequest(session);
		}
		
		// Facebook sharing saved instance test
		if (savedInstanceState != null) {
		    pendingPublishReauthorization = 
		        savedInstanceState.getBoolean(PENDING_PUBLISH_KEY, false);
		}
		
		// Share Button
		shareButton = (Button) rootView.findViewById(R.id.shareButton);
		shareButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				publishStory();
			}
		});
		
		return rootView;
	}

	private void onSessionStateChange(final Session session, SessionState state, Exception exception) {
		if (session != null && session.isOpened()) {
			// Get the user's data.
			makeMeRequest(session);
		}
		if (pendingPublishReauthorization && 
		        state.equals(SessionState.OPENED_TOKEN_UPDATED)) {
		    pendingPublishReauthorization = false;
		    publishStory();
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
						try {
							// Working
							userId = user.getId();
							Log.d("ID: ", userId);
							// Log.d("UserData : ", user.toString());
							userEmail = user.asMap().get("email").toString();
							Log.d("email : ", userEmail);
							
							// Log.d("Session :", session.toString());
							accessToken = session.getAccessToken();
							Log.d("Access Token :", "" + accessToken);
						} catch(Exception e) {
							Log.d("Facebook Graph", "Email : " + userEmail + "\nID : " + userId + "\nToken : " + accessToken);
						}

						// Sending the GCM Registration and Facebook data to our server for registration
						// GCM Notifications
						context = getActivity().getApplicationContext();
						// gcm = GoogleCloudMessaging.getInstance(this);
						gcm = GoogleCloudMessaging.getInstance(context);
				        GCMRegistrationID = getRegistrationId(context);

				        if (GCMRegistrationID.isEmpty()) {
				            // Toast.makeText(context, "GCMRegistrationID isn't already available, have to register.", Toast.LENGTH_SHORT).show();
				        	Log.i(TAG, "GCMRegistrationID isn't already available, have to register.");
				            registerInBackground();
				        } else {
				            // Toast.makeText(context, "\nGCMRegistrationID is already available : " + GCMRegistrationID, Toast.LENGTH_SHORT).show();
				        	Log.i(TAG, "GCMRegistrationID is already available : " + GCMRegistrationID);
				        }

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
		bundle.putBoolean(PENDING_PUBLISH_KEY, pendingPublishReauthorization);
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

	/**
     * Gets the current registration ID for application on GCM service.
     * <p>
     * If result is empty, the app needs to register.
     *
     * @return registration ID, or empty string if there is no existing
     *         registration ID.
     */
    private String getRegistrationId(Context context) {
        final SharedPreferences prefs;
        prefs = getGCMPreferences();
        String registrationId = prefs.getString(PROPERTY_REG_ID, "");
        if (registrationId.isEmpty()) {
            Log.i(TAG, "Registration not found.");
            return "";
        }
        // Check if app was updated; if so, it must clear the registration ID
        // since the existing regID is not guaranteed to work with the new
        // app version.
        int registeredVersion = prefs.getInt(PROPERTY_APP_VERSION, Integer.MIN_VALUE);
        int currentVersion = getAppVersion(context);
        if (registeredVersion != currentVersion) {
            Log.i(TAG, "App version changed.");
            return "";
        }
        return registrationId;
    }

    /**
     * @return Application's {@code SharedPreferences}.
     */
    // Original signature uses Context context as it's argument
    protected SharedPreferences getGCMPreferences() {
        // This sample app persists the registration ID in shared preferences, but
        // how you store the regID in your app is up to you.
        // return getSharedPreferences(DemoActivity.class.getSimpleName(), Context.MODE_PRIVATE);
    	// The line below worked in the GCMTest app
    	// return getSharedPreferences(FacebookLoginActivity.class.getSimpleName(), Context.MODE_PRIVATE);
    	return getActivity().getSharedPreferences(FacebookLoginActivity.class.getSimpleName(), Context.MODE_PRIVATE);
    }
    
    /**
     * @return Application's version code from the {@code PackageManager}.
     */
    private static int getAppVersion(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (NameNotFoundException e) {
            // should never happen
            throw new RuntimeException("Could not get package name: " + e);
        }
    }

	/**
     * Registers the application with GCM servers asynchronously.
     * <p>
     * Stores the registration ID and app versionCode in the application's
     * shared preferences.
     */
    private void registerInBackground() {
        // Toast.makeText(context, "Registering the device", Toast.LENGTH_SHORT).show();
    	Log.i(TAG, "Registering the device");

        new Thread(new Runnable() {
            @Override
            public void run() {
                String msg;
                try {
                    if (gcm == null) {
                        gcm = GoogleCloudMessaging.getInstance(context);
                    }
                    GCMRegistrationID = gcm.register(SENDER_ID);
                    msg = "Device registered, registration ID=" + GCMRegistrationID;

                    // runOnUiThread(new Runnable() {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // Toast.makeText(context, "Registration Successful\nSending to Backend", Toast.LENGTH_SHORT).show();
                        	Log.i(TAG, "Registration Successful. Sending to Backend");
                        }
                    });
                    // You should send the registration ID to your server over HTTP,
                    // so it can use GCM/HTTP or CCS to send messages to your app.
                    // The request to your server should be authenticated if your app
                    // is using accounts.
                    sendRegistrationIdToBackend();

                    // For this demo: we don't need to send it because the device
                    // will send upstream messages to a server that echo back the
                    // message using the 'from' address in the message.

                    // Persist the GCMRegistrationID - no need to register again.
                    storeRegistrationId(context, GCMRegistrationID);
                } catch (IOException ex) {
                    msg = "Error :" + ex.getMessage();
                    // If there is an error, don't just keep trying to register.
                    // Require the user to click a button again, or perform
                    // exponential back-off.
                }
                final String finalMsg = msg;
                // runOnUiThread(new Runnable() {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        // mDisplay.append(finalMsg + "\n");
                    	// Toast.makeText(context, finalMsg + "\n", Toast.LENGTH_SHORT).show();
                    	Log.d(TAG, finalMsg);
                    }
                });
            }
        }).start();
    }

    /**
     * Sends the registration ID to your server over HTTP, so it can use GCM/HTTP
     * or CCS to send messages to your app. Not needed for this demo since the
     * device sends upstream messages to a server that echoes back the message
     * using the 'from' address in the message.
     */
    private void sendRegistrationIdToBackend() {
        // Your implementation here.
        // Have to send the registration ID to store on my youthvibe server
        final Runnable serverPOSTRunnable = new Runnable() {
            @Override
            public void run() {
                // Create the POST request
                HttpClient httpClient = new DefaultHttpClient();
                HttpPost httpPost = new HttpPost("http://youthvibe2014server.herokuapp.com/register");

                // Request parameters and other properties.
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                // params.add(new BasicNameValuePair("username", "ishanatmuz"));
                // params.add(new BasicNameValuePair("password", "m7382in"));
                params.add(new BasicNameValuePair("RegistrationID", GCMRegistrationID));
                params.add(new BasicNameValuePair("FacebookID", userId));
                params.add(new BasicNameValuePair("Name", userName));
                params.add(new BasicNameValuePair("Email", userEmail));
                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    // writing error to Log
                    e.printStackTrace();
                }

                // Execute the HTTP Request
                try {
                    HttpResponse response = httpClient.execute(httpPost);
                    HttpEntity respEntity = response.getEntity();

                    if (respEntity != null) {
                        // EntityUtils to get the response content
                        final String content = EntityUtils.toString(respEntity);
                        // runOnUiThread(new Runnable() {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                // mDisplay.append(content);
                            	// Toast.makeText(context, content, Toast.LENGTH_SHORT).show();
                            	Log.d(TAG, content);
                            }
                        });
                    }
                } catch (ClientProtocolException e) {
                    // writing exception to log
                    e.printStackTrace();
                    // runOnUiThread(new Runnable() {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // mDisplay.append("ClientProtocolException occurred.");
                        	// Toast.makeText(context, "ClientProtocolException occurred.", Toast.LENGTH_SHORT).show();
                        	Log.e(TAG, "ClientProtocolException occurred.");
                        }
                    });
                } catch (IOException e) {
                    // writing exception to log
                    e.printStackTrace();
                    // runOnUiThread(new Runnable() {
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            // mDisplay.append("IOException occurred.");
                        	// Toast.makeText(context, "IOException occurred.", Toast.LENGTH_SHORT).show();
                        	Log.e(TAG, "IOException occurred.");
                        }
                    });
                }
            }
        };
        final Thread sendingDataToServerThread = new Thread(serverPOSTRunnable);
        sendingDataToServerThread.start();

    }

    /**
     * Stores the registration ID and app versionCode in the application's
     * {@code SharedPreferences}.
     *
     * @param context application's context.
     * @param regId registration ID
     */
    // @SuppressLint("CommitPrefEdits")
    private void storeRegistrationId(Context context, String regId) {
        final SharedPreferences prefs;
        prefs = getGCMPreferences();
        int appVersion = getAppVersion(context);
        Log.i(TAG, "Saving regId on app version " + appVersion);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PROPERTY_REG_ID, regId);
        editor.putInt(PROPERTY_APP_VERSION, appVersion);
        editor.commit();
    }
    
    /*
     * Method to post on facebook
     */
    private void publishStory() {
        Session session = Session.getActiveSession();

        if (session != null){
        	
        	// Check for publish permissions    
            List<String> permissions = session.getPermissions();
            if (!isSubsetOf(PERMISSIONS, permissions)) {
                pendingPublishReauthorization = true;
                Session.NewPermissionsRequest newPermissionsRequest = new Session
                        .NewPermissionsRequest(this, PERMISSIONS);
            session.requestNewPublishPermissions(newPermissionsRequest);
                return;
            }

            Bundle postParams = new Bundle();
            postParams.putString("name", "Facebook SDK for Android");
            postParams.putString("caption", "Build great social apps and get more installs.");
            postParams.putString("description", "The Facebook SDK for Android makes it easier and faster to develop Facebook integrated Android apps.");
            postParams.putString("link", "https://developers.facebook.com/android");
            postParams.putString("picture", "https://raw.github.com/fbsamples/ios-3.x-howtos/master/Images/iossdk_logo.png");

            Request.Callback callback= new Request.Callback() {
                public void onCompleted(Response response) {
                    JSONObject graphResponse = response
                                               .getGraphObject()
                                               .getInnerJSONObject();
                    String postId = null;
                    try {
                        postId = graphResponse.getString("id");
                    } catch (JSONException e) {
                        Log.i(TAG,
                            "JSON error "+ e.getMessage());
                    }
                    FacebookRequestError error = response.getError();
                    if (error != null) {
                        Toast.makeText(getActivity()
                             .getApplicationContext(),
                             error.getErrorMessage(),
                             Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity()
                                 .getApplicationContext(), 
                                 postId,
                                 Toast.LENGTH_LONG).show();
                    }
                }
            };

            Request request = new Request(session, "me/feed", postParams, 
                                  HttpMethod.POST, callback);

            RequestAsyncTask task = new RequestAsyncTask(request);
            task.execute();
        }

    }
    
    private boolean isSubsetOf(Collection<String> subset, Collection<String> superset) {
        for (String string : subset) {
            if (!superset.contains(string)) {
                return false;
            }
        }
        return true;
    }

}