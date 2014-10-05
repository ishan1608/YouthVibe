package com.bist.youthvibe2014;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v13.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.common.view.SlidingTabLayout;


public class EventsHomeFragment extends Fragment implements ActionBar.TabListener{

	SectionsPagerAdapter mSectionsPagerAdapter;

	ViewPager mViewPager;
	View rootView;

	// ActionBar actionBar;
	private SlidingTabLayout mSlidingTabLayout;

	// String mainCategories[] = {"Cultural", "Concerts", "Technical", "Sports", "Management", "Social" };
	String mainCategories[] = {"Cultural", "Media Events", "Technical", "Life Style", "Literary", "Sports", "Management", "Photography", "Social"};
	// String mainCategories[] = getActivity().getResources().getStringArray(R.array.event_categories);
	// String mainCategories[] = getActivity().getApplicationContext().getResources().getStringArray(R.array.event_categories);
	// Have to make use of the below line instead of the above line.
	// String[] mainCategories = getResources().getStringArray(R.array.event_categories);

	@Override
	public void onResume() {
		// Toast.makeText(getActivity(), "Events onresume called", Toast.LENGTH_SHORT).show();
		super.onResume();
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		rootView  = inflater.inflate(R.layout.events_home_fragment, container, false);

		// Toast.makeText(getActivity(), "Events onCreateView", Toast.LENGTH_SHORT).show();

		super.onCreate(savedInstanceState);

		/* Old Code
		// Set up the action bar.
        // final ActionBar actionBar = getActivity().getActionBar();
		actionBar = getActivity().getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		 */

		// Create the adapter that will return a fragment for each of the three
		// primary sections of the activity.
		mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) rootView.findViewById(R.id.events_home_pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		
		
		// Shifting to a specific tab on starting
		Bundle sentBundle = getArguments();
		final String catPos = sentBundle.getString("category_position");
		Integer categoryPosition = Integer.parseInt(catPos);
		
		mViewPager.setCurrentItem(categoryPosition);
		

		// New Additions
		// Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
		// it's PagerAdapter set.
		mSlidingTabLayout = (SlidingTabLayout) rootView.findViewById(R.id.sliding_tabs);
		mSlidingTabLayout.setViewPager(mViewPager);

		/*
        // Old Code
        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }
        });
		 */

		/*
        // Old Code
        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            actionBar.addTab(
                    actionBar.newTab()
                            .setText(mSectionsPagerAdapter.getPageTitle(i))
                            .setTabListener(this));
        }
		 */
		return rootView;
	}

	/*
	// New Code
	@Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SamplePagerAdapter());

        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
        // it's PagerAdapter set.
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);
    }
	 */

	@Override
	public void onDestroyView() {
		// Toast.makeText(getActivity(), "EventsHomeFragment destroy called.", Toast.LENGTH_SHORT).show();
		// actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		// actionBar.removeAllTabs();
		super.onDestroyView();
	}

	@Override
	public void onTabReselected(Tab tab, FragmentTransaction fragmentTransaction) {
	}

	@Override
	public void onTabSelected(Tab tab, FragmentTransaction fragmentTransaction) {
		// When the given tab is selected, switch to the corresponding page in
		// the ViewPager.
		mViewPager.setCurrentItem(tab.getPosition());
	}

	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction fragmentTransaction) {
	}

	// My SectionsPagerAdapter which destroys my fragment objects which it shouldn't
	public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

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
			switch(position) {
			case 0:
				currentFragment = new CulturalFragment();
				break;
			case 1:
				currentFragment = new MediaEventsFragment();
				break;
			case 2:
				currentFragment = new TechnicalFragment();
				break;
			case 3:
				currentFragment = new LifeStyleFragment();
				break;
			case 4:
				currentFragment = new LiteraryFragment();
				break;
			case 5:
				currentFragment = new SportsFragment();
				break;
			case 6:
				currentFragment = new ManagementFragment();
				break;
			case 7:
				currentFragment = new PhotographyFragment();
				break;
			case 8:
				// Social Fragment needs to be here
				currentFragment = PlaceholderFragment.newInstance(position + 1);
				break;
			default:
				currentFragment = PlaceholderFragment.newInstance(position + 1);
				break;
			}
			return currentFragment;
		}

		@Override
		public int getCount() {
			// Show 6 total pages.
			// return 6;
			return mainCategories.length;
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
			// return null;
			return mainCategories[position];
		}
	}

	public static class PlaceholderFragment extends Fragment {
		private static final String ARG_SECTION_NUMBER = "section_number";
		public static PlaceholderFragment newInstance(int sectionNumber) {
			PlaceholderFragment fragment = new PlaceholderFragment();
			Bundle args = new Bundle();
			args.putInt(ARG_SECTION_NUMBER, sectionNumber);
			fragment.setArguments(args);
			return fragment;
		}

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.events_home_fragment_frag, container, false);
			TextView textView = (TextView) rootView.findViewById(R.id.section_label);
			textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));

			return rootView;
		}
	}
}