package com.bist.youthvibe2014;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;

import com.slidinglayer.SlidingLayer;


public class MainActivity extends Activity {

 String[] menutitles;
 TypedArray menuIcons;

 // nav drawer title
 private CharSequence mDrawerTitle;
 private CharSequence mTitle;

 private DrawerLayout mDrawerLayout;
 private ListView mDrawerList;
 private ActionBarDrawerToggle mDrawerToggle;

 private List<RowItem> rowItems;
 private CustomAdapter adapter;
 
 // Notification Layer part
 SlidingLayer notificationLayer;
 Menu menu;
 MenuItem notificationMenu;
 List<RowItem> notificationItems;
 CustomAdapter notificationAdapter;


@Override
 protected void onCreate(Bundle savedInstanceState) {
	
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  
  		//Notification Layer Part
		notificationLayer = (SlidingLayer) findViewById(R.id.notification_sliding_layer);
		notificationLayer.setShadowWidth(8);
		notificationLayer.setOffsetWidth(25);
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
				notificationMenu = menu.findItem(R.id.notification_action_icon);
				if(notificationLayer.isOpened()) {
					// notification_icon.setIcon(R.drawable.withnotification);
            		// item.setIcon(getResources().getDrawable(R.drawable.withnotification));
					notificationMenu.setIcon(R.drawable.withnotification);
	        		notificationLayer.closeLayer(true);
	        	} else {
	        		// notification_icon.setIcon(R.drawable.nonotifacation);
	        		// item.setIcon(getResources().getDrawable(R.drawable.nonotifacation));
	        		notificationMenu.setIcon(R.drawable.nonotifacation);
	        		notificationLayer.openLayer(true);
	        	}
			}
		});
		
		// List inside the Notification Panel
		ListView notificationPanelList = (ListView) findViewById(R.id.notification_list);
		String notificationList[] = {"Notification 1", "Notification 2", "Notification 3", "Notification 4", "Notification 5", "Notification 6"};

		// An adapter for simple text List
		// notificationPanelList.setAdapter(new ArrayAdapter<String>(this, R.layout.notification_layer_list_item, notificationList));
		notificationItems = new ArrayList<RowItem>();
		for(int i=0; i < notificationList.length; i++) {
			RowItem item = new RowItem(notificationList[i], R.drawable.notification);
			notificationItems.add(item);
		}
		notificationAdapter = new CustomAdapter(getApplicationContext(), notificationItems);
		notificationPanelList.setAdapter(notificationAdapter);
  
  // DrawerLayout part

  mTitle = mDrawerTitle = getTitle();

  menutitles = getResources().getStringArray(R.array.titles);
  menuIcons = getResources().obtainTypedArray(R.array.icons);

  mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
  mDrawerList = (ListView) findViewById(R.id.slider_list);

  rowItems = new ArrayList<RowItem>();

  for (int i = 0; i < menutitles.length; i++) {
   RowItem items = new RowItem(menutitles[i], menuIcons.getResourceId(i, -1));
   rowItems.add(items);
  }

  menuIcons.recycle();

  adapter = new CustomAdapter(getApplicationContext(), rowItems);

  mDrawerList.setAdapter(adapter);
  mDrawerList.setOnItemClickListener(new SlideitemListener());

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
       updateDisplay(0);
     }
 }


 class SlideitemListener implements ListView.OnItemClickListener {
       @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
    	   		// Toast.makeText(getApplicationContext(), "The value of position is "+position, Toast.LENGTH_SHORT).show();
                 updateDisplay(position);
            }

      }


private void updateDisplay(int position) {
      Fragment fragment = null;
         switch (position) {
               case 0:
            	   fragment = new HomeFragment();
            	   break;
               case 1:
                   fragment = new AboutUsFragment();
                   // Toast.makeText(getApplicationContext(), "About us toast from main", Toast.LENGTH_SHORT).show();
                    break;               
               case 2:
                   fragment = new GalleryFragment();
                   break;
               case 3:
                   fragment = new EventsHomeFragment();
                  break;
               case 4:
            	   // Toast.makeText(getApplicationContext(), "Contact called", Toast.LENGTH_SHORT).show();
                   fragment = new ContactCallFragment();
                   break;
               case 5:
                   fragment = new GoogleMapsFrag();
                   break;
               case 6:
                   fragment = new LikeFragment();
                   break;
               case 7:
                   fragment = new Sponsors_Fragment();
                   break;
                  default:
                    break;
    }

  if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
             fragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit();
            // update selected item and title, then close the drawer
            setTitle(menutitles[position]);
             mDrawerLayout.closeDrawer(mDrawerList);
  } else {
              // error in creating fragment
              Log.e("MainActivity", "Error in creating fragment");
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
           this.menu = menu;
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
                    case R.id.action_settings:
                    	   // Toast.makeText(MainActivity.this, "This application has been developed by\nThe Inspirations\nAndroid Developers Lab.", Toast.LENGTH_LONG).show();
                    	Intent intent = new Intent(MainActivity.this, DialogActivity.class);
                        startActivity(intent);
                          return true;
                    /*case R.id.mute_button:
                    	// Need a reference to the music player
                    	return true;*/
                    case R.id.notification_action_icon:
                    	if(notificationLayer.isOpened()) {
                    		item.setIcon(getResources().getDrawable(R.drawable.withnotification));
        	        		notificationLayer.closeLayer(true);
        	        	} else {
        	        		item.setIcon(getResources().getDrawable(R.drawable.nonotifacation));
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
                menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
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
