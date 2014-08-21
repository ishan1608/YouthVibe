package com.bist.youthvibe2014;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

@SuppressWarnings("deprecation")
public class GalleryFragment extends Fragment	  
{
	LinearLayout relsec1;
	LinearLayout relsec2;
	int id;
	ImageView imgv;
	String imgval="";
	View rootView;
	@Override public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		rootView  = inflater .inflate(R.layout.gallery_fragment, container, false);
		
		relsec1 = (LinearLayout)rootView.findViewById(R.id.relsec1);
		relsec2 = (LinearLayout)rootView.findViewById(R.id.relsec2);
		String imageItems []= new String [12];
		imageItems[0]="srkdance";
		imageItems[1]="classical1";
		imageItems[2]="classical2";
		imageItems[3]="groupfootbaal";
		imageItems[4]="fashionshow";
		imageItems[5]="lpushowcase";
		imageItems[6]="ranbir";
		imageItems[7]="girlfootball";
		imageItems[8]="roadshow";
		imageItems[9]="northeast";
		imageItems[10]="roadshow2";
		imageItems[11]="srkdeepika";
		//imageItems[12]="folkclass";
		double  height= 187 * 0.36;
		double  width = 160;
		for(int i=0; i<imageItems.length; i++) {
			id = getResources().getIdentifier(imageItems[i], "drawable", getActivity().getPackageName());
			imgv = new ImageView(getActivity());	
	        imgv.setMaxHeight((int)height);
	        imgv.setMaxWidth((int)width);
	        imgv.setImageDrawable(getResources().getDrawable(id));
	        if(i%2 == 0) {
	        	relsec1.addView(imgv);
	        	imgval=""+i;
		        final String val= imgval.toString();
	        	imgv.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Toast.makeText(getActivity(), "toast toast toast",Toast.LENGTH_SHORT).show();	
						Bundle toImage=new Bundle();
						toImage.putString("key1",val);
							Intent intent=new Intent(getActivity(),ImageActivity.class);
							intent.putExtras(toImage);
							startActivity(intent);	
					}
				});
	        } else {
	        	relsec2.addView(imgv);
	        	imgval=""+i;
		        final String val= imgval.toString();
	        	imgv.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						Bundle toImage=new Bundle();
						toImage.putString("key1",val);
						Intent intent=new Intent(getActivity(),ImageActivity.class);
						intent.putExtras(toImage);
						startActivity(intent);
						Toast.makeText(getActivity(), "toast toast toast",Toast.LENGTH_SHORT).show();	
					}
				});
	        } }
	    	imgv.invalidate();
		return rootView;
		
	}
		
}