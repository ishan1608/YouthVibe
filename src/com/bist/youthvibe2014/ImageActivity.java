package com.bist.youthvibe2014;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class ImageActivity extends  FragmentActivity  {
	SectionsPagerAdapter mSectionsPagerAdapter;
	ViewPager mViewPager;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.activity_image);
		Intent callingIntent = getIntent();
		Bundle sentBundle = callingIntent.getExtras();
		final String rcvstr1=sentBundle.getString("key1");
		Integer number = Integer.parseInt(rcvstr1);

		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		mViewPager.setCurrentItem(number);
	}
}
class SectionsPagerAdapter extends FragmentStatePagerAdapter {

	public SectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	// No results till now using the following two methods
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		// Toast.makeText(getActivity(), "destroyItem called for "+position, Toast.LENGTH_SHORT).show();
		super.destroyItem(container, position, object);
	}

	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		// Toast.makeText(getActivity(), "instantiateItem called for "+position, Toast.LENGTH_SHORT).show();
		return super.instantiateItem(container, position);
	}

	@Override
	public Fragment getItem(int position) {
		// Toast.makeText(getActivity(), "getItem called "+position, Toast.LENGTH_SHORT).show();
		// getItem is called to instantiate the fragment for the given page.
		// Return a PlaceholderFragment (defined as a static inner class below).
		Fragment currentFragment = null;

		currentFragment = PlaceholderFragment.newInstance(position);
		return currentFragment;
	}

	@Override
	public int getCount() {
		// Show 6 total pages.
		return 12;
		//return mainCategories.length;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		// Locale l = Locale.getDefault();
		/*switch (position) {
            case 0:
                // return getString(R.string.title_section1).toUpperCase(l);
            	return "Section 1";
            case 1:
                // return getString(R.string.title_section2).toUpperCase(l);
            	return "Section 2";
            case 2:
                // return getString(R.string.title_section3).toUpperCase(l);
            	return "Section 3";
            default:
            	return "Section " + (position + 1);
        }*/
		return null;
		//return mainCategories[position];
	}
}

class PlaceholderFragment extends Fragment {
	// private static final String ARG_SECTION_NUMBER = "section_number";
	// int id;
	// ImageView imgv;
	// Your Old Code
	// LinearLayout linear1;
	RelativeLayout imageViewRelative;
	// static int section;
	int section;

	private ImageView[] imageHolder = new ImageView[12];
	// private int viewId;
	private int progressId;

	/*public static PlaceholderFragment newInstance(int sectionNumber) {
         PlaceholderFragment fragment = new PlaceholderFragment();
         Bundle args = new Bundle();
         args.putInt(ARG_SECTION_NUMBER, sectionNumber);
         fragment.setArguments(args);

         // section = sectionNumber;

         return fragment;
     }*/

	public static PlaceholderFragment newInstance(int sectionNumber) {
		// PlaceholderFragment fragment = new PlaceholderFragment();
		/*Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);*/

		// section = sectionNumber;

		PlaceholderFragment fragment = new PlaceholderFragment(sectionNumber);

		return fragment;
	}


	@Override
	public void onCreate(Bundle savedInstanceState) {
		// Downloading Library settings
		DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true).build();
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getActivity().getApplicationContext()).defaultDisplayImageOptions(defaultOptions).build();
		ImageLoader.getInstance().init(config);
		super.onCreate(savedInstanceState);
	}


	public PlaceholderFragment(int sectionNumber) {
		section = sectionNumber;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.gallery_inflater_fragment, container, false);
		// Your Old Code
		// linear1=(LinearLayout)rootView.findViewById(R.id.linear1);

		imageViewRelative = (RelativeLayout) rootView.findViewById(R.id.imageViewForFragments);
		String imageItems []= new String [12];
		imageItems[0]="srkdancebig";
		imageItems[1]="classicalbig1";
		imageItems[2]="classicalbig2";
		imageItems[3]="groupfootbaalbig";
		imageItems[4]="fashionshowbig";
		imageItems[5]="showcasebig";
		imageItems[6]="ranbirbig";
		imageItems[7]="girlfootballbig";
		imageItems[8]="roadshowbig";
		imageItems[9]="northeastbig";
		imageItems[10]="roadshow2big";
		imageItems[11]="srkdeepikabig";
		//imageItems[12]="folkclassbig";
		double  height= 600;
		double  width = 400;
		/*Intent callingIntent = getIntent();
 		Bundle sentBundle = callingIntent.getExtras();
 		final String rcvstr1=sentBundle.getString("key1");
 		   Integer i = Integer.parseInt(rcvstr1);*/
		// Toast.makeText(getApplicationContext(), "value"+i, Toast.LENGTH_SHORT).show();
		// id = getResources().getIdentifier(imageItems[section], "drawable", getActivity().getPackageName());
		progressId = getResources().getIdentifier("progress_circle", "drawable", getActivity().getPackageName());
		// imgv = new ImageView(getActivity());
		imageHolder[section] = new ImageView(getActivity());
		// imgv.setMaxHeight((int)height);
		imageHolder[section].setMaxHeight((int)height);
		// imgv.setMaxWidth((int)width);
		imageHolder[section].setMaxWidth((int)width);
		// imgv.setPadding(5,5,5,5);
		imageHolder[section].setPadding(5,5,5,5);

		// imgv.setImageDrawable(getResources().getDrawable(id));
		// Showing the progress_circle
		imageHolder[section].setImageDrawable(getResources().getDrawable(progressId));
		// Downloading the image now
		ImageLoader.getInstance().displayImage("http://youthvibe2014server.herokuapp.com/public/" + imageItems[section] + ".png", imageHolder[section]);
		// Your Old Code
		// linear1.addView(imgv);

		// Have to set image view as horizontal cneter and vertical center
		RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		params1.addRule(RelativeLayout.CENTER_HORIZONTAL);
		params1.addRule(RelativeLayout.CENTER_VERTICAL);
		// imgv.setLayoutParams(params1);
		imageHolder[section].setLayoutParams(params1);
		// imageViewRelative.addView(imgv);
		imageViewRelative.addView(imageHolder[section]);
		// Not invalidating
		// imgv.invalidate();
		// Your Old Code
		// linear1.invalidate();

		imageViewRelative.invalidate();
		// TextView textView = (TextView) rootView.findViewById(R.id.section_label);
		//  textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));

		return rootView;
	}
}
