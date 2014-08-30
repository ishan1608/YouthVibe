package com.bist.youthvibe2014;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class ContactCallFragment extends Fragment {
	View rootView;

	String[] member_names;
	TypedArray profile_pics;
	String[] contactType;

	List<ContactRowItem> rowItems;
	ListView mylistview;



	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		rootView  = inflater .inflate(R.layout.contact_fragment, container, false);


		// Toast.makeText(getActivity(), "conatact inflated", Toast.LENGTH_SHORT).show();
		/*ImageView background = (ImageView)rootView.findViewById(R.id.event_image);
			background.setBackgroundResource(R.drawable.gif);*/

		// Library settings
		/*DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
			ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).defaultDisplayImageOptions(defaultOptions).build();
	        ImageLoader.getInstance().init(config);

	        // Code to use the library provided here https://github.com/nostra13/Android-Universal-Image-Loader
	     	ImageView permanentImageView4 = (ImageView) findViewById(R.id.p);
	        ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/selenaGomez.jpg", permanentImageView);*/

		rowItems = new ArrayList<ContactRowItem>();
		member_names = getResources().getStringArray(R.array.contact_member_names);
		profile_pics = getResources().obtainTypedArray(R.array.contact_profile_pics);
		contactType = getResources().getStringArray(R.array.contact_contact_type);

		for (int i = 0; i < member_names.length; i++) {
			ContactRowItem item = new ContactRowItem(member_names[i],
					profile_pics.getResourceId(i, -1),
					contactType[i]);
			rowItems.add(item);
		}

		mylistview = (ListView) rootView.findViewById(R.id.list);
		ContactCustomAdapter adapter = new ContactCustomAdapter(getActivity(), rowItems);
		mylistview.setAdapter(adapter);
		profile_pics.recycle();
		// mylistview.setOnItemClickListener(this);
		mylistview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// String member_name = rowItems.get(position).getMember_name();
				// Toast.makeText(getActivity(), "" + member_name, Toast.LENGTH_SHORT).show();
				Intent callIntent = new Intent(Intent.ACTION_CALL);
				switch(position){
				case 0:
					callIntent.setData(Uri.parse("tel:+978-016-4766"));	     
					break;
				case 1:
					callIntent.setData(Uri.parse("tel:+91-730-779-5624"));	     
					break;
				case 2:
					callIntent.setData(Uri.parse("tel:+91-964-605-6969"));	     
					break;
				case 3:
					callIntent.setData(Uri.parse("tel:+91-8528314743"));	     
					break;
				case 4:
					callIntent.setData(Uri.parse("tel:+91-7696490368"));	     
					break;
				case 5:
					callIntent.setData(Uri.parse("tel:+91-8437185576"));	     
					break;
				case 6:
					callIntent.setData(Uri.parse("tel:+91-9653909272"));	     
					break;
				default:
					Toast.makeText(getActivity(), "Contact Number not available.\nTry Emailing the person.", Toast.LENGTH_LONG).show();
					break;

				}
				startActivity(callIntent);
			}
		});
		return rootView;
	}
}