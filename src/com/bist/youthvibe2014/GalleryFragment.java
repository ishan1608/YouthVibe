package com.bist.youthvibe2014;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

@SuppressWarnings("deprecation")
public class GalleryFragment extends Fragment	  
{
	private Integer[] galleryImageIds = {
            R.drawable.uvg1,
            R.drawable.uv2,
            R.drawable.uv3,
            R.drawable.uv4,
            R.drawable.uv5,
            R.drawable.uv6,
            R.drawable.uv7,
            R.drawable.uv8,
            R.drawable.uv9,
            R.drawable.uv10,
            R.drawable.uv11,
            R.drawable.uv12,
            R.drawable.uv13,
            R.drawable.uv14,
            R.drawable.uv15,
            R.drawable.uv16,
            R.drawable.uv17,
            R.drawable.uv18,
            R.drawable.uv19
            };
	View rootView;
	@Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		rootView  = inflater .inflate(R.layout.gallery_fragment, container, false);
		
		Gallery galleryView;
    	final ImageView galleryImageHolder;
    		
		galleryView = (Gallery) rootView.findViewById(R.id.gallery_scroll_view);
		galleryView.setSpacing(1);
		galleryImageHolder = (ImageView) rootView.findViewById(R.id.gallery_image_holder);
		galleryView.setAdapter(new galleryAdapter(getActivity()));
		
		galleryView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parentView, View view, int position, long id) {
				galleryImageHolder.setImageResource(galleryImageIds[position]);
			}
		});
		
		return rootView;
	}
	
	private class galleryAdapter extends BaseAdapter
	{
		 Context context;
		 
		 galleryAdapter(Context thisContext) {
			 context = thisContext;
		 }

		@Override
		public int getCount() {
			return 19;
		}

		@Override
		public Object getItem(int position) {
			return position;
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public View getView(int index, View view, ViewGroup viewGroup) {
			ImageView newView = new ImageView(context);
			newView.setImageResource(galleryImageIds[index]);
			newView.setLayoutParams(new Gallery.LayoutParams(150,150));
			newView.setScaleType(ImageView.ScaleType.FIT_XY);
			return newView;
		}
	}	
}