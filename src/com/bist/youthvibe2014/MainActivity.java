package com.bist.youthvibe2014;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
// import android.widget.Toast;


import com.google.android.gms.drive.query.internal.NotFilter;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.slidinglayer.SlidingLayer;


public class MainActivity extends Activity {

	String[] menutitles;
	TypedArray menuIcons;

	// nav drawer title
	private CharSequence mDrawerTitle;
	private CharSequence mTitle;

	private DrawerLayout mDrawerLayout;
	// private ListView mDrawerList;
	private ExpandableListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private List<RowItem> rowItems;
	// private NotificationsAdapter adapter;
	private NavigationDrawerAdapter adapter;

	// Notification Layer part
	private SlidingLayer notificationLayer;
	// private Menu menu;
	private MenuItem notificationMenu;
	private List<RowItem> notificationItems;
	private NotificationsAdapter notificationAdapter;
	
	// Notifications New
	SharedPreferences settings;
	int totalNotifications;
	String notificationList[];
	private String newNotices;
	
	ListView notificationPanelList;

	// User Info
	private String userName, userId, userEmail, accessToken;
	private Bundle userInfo;
	private Intent callingIntent;
	private TextView userNameView, userEmailView;
	private String userFacebookGraphUrl;
	private ImageView coverImageView;
	private Drawable coverImage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*// Will need this when I shift the notification intent to Main Activity
		// Clearing the notification if any
		String notManagerName = Context.NOTIFICATION_SERVICE;
        NotificationManager notificationManager = (NotificationManager) getSystemService(notManagerName);
        notificationManager.cancel(GcmIntentService.NOTIFICATION_ID);*/
		
		getNotifications();

        try{
            // newNotices Info from previous Activity
            Intent callingIntent = getIntent();
            Bundle noticeInfo = callingIntent.getExtras();
            newNotices = noticeInfo.getString("newNotices");
            // mDisplay.append("Value : " + newNotices + "\n");
            // Toast.makeText(getApplicationContext(), "Value : " + newNotices + "\n", Toast.LENGTH_SHORT).show();
            /*if(newNotices.equalsIgnoreCase("YES")) {
                // mDisplay.append("New notices available\n");
            	Toast.makeText(getApplicationContext(), "New notices available\n", Toast.LENGTH_SHORT).show();
            } else {
                // mDisplay.append("No new notices available\n");
            	Toast.makeText(getApplicationContext(), "No new notices available\n", Toast.LENGTH_SHORT).show();
            }*/
        } catch(Exception e) {
            // mDisplay.append("Calling intent doesn't have information about newNotices.\n");
            // Toast.makeText(getApplicationContext(), "Calling intent doesn't have information about newNotices.\n", Toast.LENGTH_SHORT).show();
            Log.e("noticesMainIntent", "Error getting the info from previous Activity.");
        }

        /*// This will be used for notifications list
        // mDisplay.append("Total messages : " + notifications.length + "\n");
        Toast.makeText(getApplicationContext(), "Total messages : " + notificationList.length + "\n", Toast.LENGTH_SHORT).show();
        for(int i=0; i<notificationList.length; i++) {
            // mDisplay.append(notifications[i] + "\n");
            Toast.makeText(getApplicationContext(), notificationList[i] + "\n", Toast.LENGTH_SHORT).show();
        }
        if(notificationList.length == 0) {
            // mDisplay.append("No Notifications till yet");
            Toast.makeText(getApplicationContext(), "No Notifications till yet", Toast.LENGTH_SHORT).show();
        }*/

		try{
			// User Info from previous Activity
			callingIntent = getIntent();
			userInfo = callingIntent.getExtras();
			userName = userInfo.getString("name");
			userId = userInfo.getString("id");
			userEmail = userInfo.getString("email");
			accessToken = userInfo.getString("token");
		} catch(Exception e) {
			// Toast.makeText(getApplicationContext(), "Error getting the info from the previous activity.", Toast.LENGTH_SHORT).show();
			Log.e("IntentInfo", "Error getting the info from previous Activity.");
		}
		
		// Download Library settings
		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(defaultOptions).build();
		ImageLoader.getInstance().init(config);

		
		//Notification Layer Part
		notificationLayer = (SlidingLayer) findViewById(R.id.notification_sliding_layer);
		notificationLayer.setShadowWidth(8);
		notificationLayer.setOffsetWidth(8);
		notificationLayer.setShadowDrawable(R.drawable.sidebar_shadow);
		notificationLayer.setStickTo(SlidingLayer.STICK_TO_RIGHT);
		notificationLayer.setCloseOnTapEnabled(true);

		// Setting the max-width of Notification Layer
		LayoutParams notificationSliderPanel = (LayoutParams) notificationLayer.getLayoutParams();
		notificationSliderPanel.width = 400;

		// Button to test Notification Layer
		/*Button notificationButton = (Button) findViewById(R.id.sliding_layer_button);
		notificationButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				if(notificationLayer.isOpened()) {
	        		notificationLayer.closeLayer(true);
	        	} else {
	        		notificationLayer.openLayer(true);
	        	}
			}
		});*/

		// Making it close by clicking on it and toggling icon accordingly
		View notificationScroll = findViewById(R.id.notification_panel_contents);

		notificationScroll.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// notificationMenu = menu.findItem(R.id.notification_action_icon);
				if(notificationLayer.isOpened()) {
					// notification_icon.setIcon(R.drawable.withnotification);
					// item.setIcon(getResources().getDrawable(R.drawable.withnotification));
					// notificationMenu.setIcon(R.drawable.withnotification);
					notificationLayer.closeLayer(true);
				} else {
					// notification_icon.setIcon(R.drawable.nonotifacation);
					// item.setIcon(getResources().getDrawable(R.drawable.nonotifacation));
					notificationMenu.setIcon(R.drawable.nonotifacation);
					notificationLayer.openLayer(true);
				}
			}
		});

		fillNotifications();

		// Listener for changing Icon
		notificationLayer.setOnInteractListener(new SlidingLayer.OnInteractListener() {

			@Override
			public void onOpened() {
				notificationMenu.setIcon(getResources().getDrawable(R.drawable.nonotifacation));
			}

			@Override
			public void onClosed() {
				// notificationMenu.setIcon(getResources().getDrawable(R.drawable.withnotification));
			}

			@Override
			public void onOpen() {
			}

			@Override
			public void onClose() {
			}

		});
		
		
		
		// DrawerLayout part
		mTitle = mDrawerTitle = getTitle();

		menutitles = getResources().getStringArray(R.array.menu_items);
		menuIcons = getResources().obtainTypedArray(R.array.icons);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		// mDrawerList = (ListView) findViewById(R.id.slider_list);
		mDrawerList = (ExpandableListView) findViewById(R.id.slider_list);

		// Navigation Header Part
		LayoutInflater inflater = getLayoutInflater();

		// Add header title
		ViewGroup nav_header = (ViewGroup)inflater.inflate(R.layout.navigation_header, mDrawerList, false);
		mDrawerList.addHeaderView(nav_header, null, false);

		// userInfoView = (TextView) findViewById(R.id.user_info_view);
		userNameView = (TextView) nav_header.findViewById(R.id.user_name_view);
		userNameView.setText(userName);

		userEmailView = (TextView) nav_header.findViewById(R.id.user_email_view);
		userEmailView.setText(userEmail);

		// Code to use the library provided here https://github.com/nostra13/Android-Universal-Image-Loader
		ImageView userImageView = (ImageView) nav_header.findViewById(R.id.userImage);
		String userPictureUrl = "https://graph.facebook.com/" + userId + "/picture?type=small";
		ImageLoader.getInstance().displayImage(userPictureUrl, userImageView);

		coverImageView = (ImageView) nav_header.findViewById(R.id.coverImage);
		// Setting the image as ScaleType.CENTER_CROP so that it takes up all the space assigned to it and not more.
		coverImageView.setScaleType(ScaleType.CENTER_CROP);
		userFacebookGraphUrl = "https://graph.facebook.com/" + userId + "?fields=cover&access_token=" + accessToken;

		Thread t = new Thread(){
			public void run()
			{
				/*runOnUiThread(new Runnable() {
				public void run() {
				}*/
				try {
					// Downloading the Cover's URL
					HttpClient client = new DefaultHttpClient();
					HttpGet get = new HttpGet(userFacebookGraphUrl);
					HttpResponse response = client.execute(get);
					if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
						String result = EntityUtils.toString(response.getEntity());
						JSONObject userGraphJSON = new JSONObject(result);
						String userCoverUrl = userGraphJSON.getJSONObject("cover").getString("source");
						Log.d("Cover", userCoverUrl);
						// Downloading the image
						coverImage = Drawable.createFromStream(((java.io.InputStream) new java.net.URL(userCoverUrl).getContent()), "cover");
					} else {
						coverImage = null;
					}
					runOnUiThread(new Runnable() {
						public void run() {
							coverImageView.setImageDrawable(coverImage);
						}
					});
				} catch (ClientProtocolException e) {
					Log.e("Cover", "ClientProtocolException");
					e.printStackTrace();
				} catch (IOException e) {
					Log.e("Cover", "IOException");
					e.printStackTrace();
				} catch (JSONException e) {
					Log.e("Cover", "JSONException");
					e.printStackTrace();
				}
			}
		};
		t.start();

		// ImageLoader.getInstance().displayImage(coverPictureUrl, coverImageView);

		rowItems = new ArrayList<RowItem>();

		for (int i = 0; i < menutitles.length; i++) {
			RowItem items = new RowItem(menutitles[i], menuIcons.getResourceId(i, -1));
			rowItems.add(items);
		}

		menuIcons.recycle();

		// adapter = new NotificationsAdapter(getApplicationContext(), rowItems);
		adapter = new NavigationDrawerAdapter(getApplicationContext());

		mDrawerList.setAdapter(adapter);
		// mDrawerList.setOnItemClickListener(new SlideitemListener());
		
		// Setting the Group Listener for Application Menu
		mDrawerList.setOnGroupClickListener(new GroupItemListener());
		
		//Setting the Child Listener for Events
		mDrawerList.setOnChildClickListener(new ChildItemListener());

		// enabling action bar app icon and behaving it as toggle button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		//  getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.app_name,R.string.app_name) {

			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			// on first time display view for first nav item
			updateDisplay(1);
		}
	}

	@Override
	protected void onResume() {
		getNotifications();
		super.onResume();
	}
	
	void getNotifications() {
		// Get messages
	    // Get the current list.
	    settings = this.getSharedPreferences(MainActivity.class.getSimpleName(), Context.MODE_PRIVATE);
	    // SharedPreferences.Editor editor = settings.edit();
	    totalNotifications = settings.getInt("totalNotifications", 0);
	    notificationList = new String[totalNotifications];
	    for(int i=0; i< totalNotifications; i++) {
	    	notificationList[i] = settings.getString("Notification_" + i, "Notice");
	    }
	    /*// Old method
	    Set<String> notificationsSet = settings.getStringSet("Notifications", new HashSet<String>());
	    String[] notificationList = notificationsSet.toArray(new String[notificationsSet.size()]);*/
	}
	
	void fillNotifications() {
		// List inside the Notification Panel
		notificationPanelList = (ListView) findViewById(R.id.notification_list);
		// Have to create this list dynamically
		// String notificationList[] = {"Notification 1", "Notification 2", "Notification 3", "Notification 4", "Notification 5", "Notification 6"};
		// An adapter for simple text List
		// notificationPanelList.setAdapter(new ArrayAdapter<String>(this, R.layout.notification_layer_list_item, notificationList));
		// Reversing the array I got from the storage.
		// I don't know why but I have to reverse device
		int notificationListLength = notificationList.length;
		String reversedNotificationList[] = new String[notificationListLength];
		for(int i=0; i<notificationListLength; i++) {
			reversedNotificationList[i] = notificationList[notificationListLength - 1 - i];
		}
		// Old method was reversing twice without any effect, new method requires reversing only once
		notificationList = reversedNotificationList;
		/*for(int i=0; i<notificationListLength; i++) {
			notificationList[i] = reversedNotificationList[notificationListLength - 1 - i];
		}*/
		notificationItems = new ArrayList<RowItem>();
		for(int i=0; i < notificationList.length; i++) {
			RowItem item = new RowItem(notificationList[i], R.drawable.notification);
			notificationItems.add(item);
		}
		notificationAdapter = new NotificationsAdapter(getApplicationContext(), notificationItems);
		notificationPanelList.setAdapter(notificationAdapter);
	}
    
	/*class SlideitemListener implements ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id)
		{
			// Toast.makeText(getApplicationContext(), "The value of position is "+position, Toast.LENGTH_SHORT).show();
			updateDisplay(position);
		}

	}*/
	
	class GroupItemListener implements ExpandableListView.OnGroupClickListener {
		@Override
		public boolean onGroupClick(ExpandableListView parent, View v,
				int groupPosition, long id) {
			updateDisplay(groupPosition + 1);
			return false;
		}
	}
	
	class ChildItemListener implements ExpandableListView.OnChildClickListener {
		@Override
		public boolean onChildClick(ExpandableListView parent, View v,
				int groupPosition, int childPosition, long id) {
			// Toast.makeText(getApplicationContext(), groupPosition + " > " + childPosition, Toast.LENGTH_SHORT).show();
			updateEventsDisplay(childPosition);
			return false;
		}
	}


	private void updateDisplay(int position) {
		Fragment fragment = null;
		switch (position) {
		case 1:
			fragment = new HomeFragment();
			break;
		case 2:
			fragment = new AboutUsFragment();
			// Toast.makeText(getApplicationContext(), "About us toast from main", Toast.LENGTH_SHORT).show();
			break;               
		case 3:
			fragment = new GalleryFragment();
			break;
			/*case 4:
			fragment = new EventsHomeFragment();
			break;
			 */
		case 5:
			// Toast.makeText(getApplicationContext(), "Contact called", Toast.LENGTH_SHORT).show();
			fragment = new ContactCallFragment();
			break;
		case 6:
			fragment = new GoogleMapsFrag();
			break;
		case 7:
			// fragment = new LikeFragment();
			try {
			      //try to open page in facebook native app.
			      String faceboobCustomUri = "fb://page/216517068538564";    //Facebook Id for youthvibe page 216517068538564
			      Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(faceboobCustomUri));
			      startActivity(intent);
			}catch (ActivityNotFoundException ex){
				//facebook native app isn't available, use fragment
				fragment = new LikeFragment();
			}
			break;
		case 8:
			fragment = new Sponsors_Fragment();
			break;
		default:
			break;
		}

		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
			// update selected item and title, then close the drawer
			setTitle(menutitles[position - 1]);
			mDrawerLayout.closeDrawer(mDrawerList);
		} else {
			// error in creating fragment
			Log.e("MainActivity", "Error in creating fragment\nPosition : " + position);
		}

	}
	
	private void updateEventsDisplay(int position) {
		Fragment fragment = new EventsHomeFragment();
		Bundle eventsBundle = new Bundle();
		eventsBundle.putString("category_position", "" + position);
		fragment.setArguments(eventsBundle);
		
		if (fragment != null) {
			FragmentManager fragmentManager = getFragmentManager();
			fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
			// Display the title for events, then close the drawer
			setTitle(menutitles[2]);
			mDrawerLayout.closeDrawer(mDrawerList);
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		// this.menu = menu;
		// settingsMenu = menu.add(R.string.action_settings);
		notificationMenu = menu.findItem(R.id.notification_action_icon);
		if(this.newNotices != null) {
			// Toast.makeText(getApplicationContext(), "newNotices is not null : " + newNotices, Toast.LENGTH_SHORT).show();
			notificationMenu.setIcon(getResources().getDrawable(R.drawable.withnotification));
		} else {
			notificationMenu.setIcon(getResources().getDrawable(R.drawable.nonotifacation));
		}
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// toggle nav drawer on selecting action bar app icon/title
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_developer:
			// Toast.makeText(MainActivity.this, "This application has been developed by\nThe Inspirations\nAndroid Developers Lab.", Toast.LENGTH_LONG).show();
			Intent developerIntent = new Intent(MainActivity.this, DialogActivity.class);
			startActivity(developerIntent);
			return true;
			/*case R.id.mute_button:
                    	// Need a reference to the music player
                    	return true;*/
		case R.id.notification_action_icon:
			if(notificationLayer.isOpened()) {
				// item.setIcon(getResources().getDrawable(R.drawable.withnotification));
				notificationLayer.closeLayer(true);
			} else {
				// item.setIcon(getResources().getDrawable(R.drawable.nonotifacation));
				notificationLayer.openLayer(true);
			}
			return true;
		default :
			return super.onOptionsItemSelected(item);
		}
	}

	/***
	 * Called when invalidateOptionsMenu() is triggered
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_developer).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggles
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

} 
