package com.bist.youthvibe2014;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

// @SuppressWarnings("unchecked")
public class NavigationDrawerAdapter extends BaseExpandableListAdapter {

	public ArrayList<String> groupItem, tempChild;
	public ArrayList<String> ChildItem = new ArrayList<String>();
	public LayoutInflater minflater;
	public Activity activity;
	private final Context context;
	private ArrayList<String> menuItems;
	private ArrayList<String> eventItems;
	
	public NavigationDrawerAdapter(Context context) {
		this.context = context;
		// groupItem = grList;
		// this.Childtem = childItem;
		
		// Initializing Categories
		menuItems = new ArrayList<String>();
		String[] menuList = context.getResources().getStringArray(R.array.menu_items);
		for (int i = 0; i < menuList.length; i++) {
			menuItems.add(menuList[i]);
		}
		this.groupItem = menuItems;
		
		// Initializing Events
		eventItems = new ArrayList<String>();
		String[] eventsCategoryList = context.getResources().getStringArray(R.array.event_categories);
		for (int i = 0; i < eventsCategoryList.length; i++) {
			eventItems.add(eventsCategoryList[i]);
		}
		this.ChildItem = eventItems;
		
	}

	/*public NavigationDrawerAdapter(Context context,ArrayList<String> grList, ArrayList<Object> childItem) {
		this.context = context;
		groupItem = grList;
		this.Childtem = childItem;
	}*/

	public void setInflater(LayoutInflater mInflater, Activity act) {
		this.minflater = mInflater;
		activity = act;
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		return null;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return 0;
	}

	@Override
	public View getChildView(int groupPosition, final int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// tempChild = (ArrayList<String>) ChildItem.get(groupPosition);
		if(menuItems.get(groupPosition).equalsIgnoreCase("Events")) {
			// I don't think there is a need for this
			tempChild = ChildItem;
			
			if (convertView == null)
	        {
	            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            convertView = layoutInflater.inflate(R.layout.navigation_drawer_child_item,parent,false);
	        }
		} else {
			// I don't think there is a need for this
			tempChild = null;
		}
		
		/*TextView text = null;
		if (convertView == null) {
			convertView = new TextView(context);
		}
		text = (TextView) convertView;
		text.setText(">"+tempChild.get(childPosition));
		*/
//		convertView.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				Toast.makeText(activity, tempChild.get(childPosition),
//						Toast.LENGTH_SHORT).show();
//			}
//		});
		// convertView.setTag(tempChild.get(childPosition));
		return convertView;
	}

	

	@Override
	public int getChildrenCount(int groupPosition) {
		/*if(groupPosition == 0) {
			return 0;
		}*/
		if(menuItems.get(groupPosition).equalsIgnoreCase("Events")) {
			return ChildItem.size();
		} else {
			return 0;
		}
		// return ((ArrayList<String>) Childtem.get(groupPosition)).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		return null;
	}

	@Override
	public int getGroupCount() {
		return groupItem.size();
	}

	@Override
	public void onGroupCollapsed(int groupPosition) {
		super.onGroupCollapsed(groupPosition);
	}

	@Override
	public void onGroupExpanded(int groupPosition) {
		super.onGroupExpanded(groupPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		return 0;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		
		if (convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.navigation_drawer_group_item,parent,false);
        }
		
		// ((TextView) convertView).setText(groupItem.get(groupPosition));
        // convertView.setTag(groupItem.get(groupPosition));
		
        return convertView;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}

}
