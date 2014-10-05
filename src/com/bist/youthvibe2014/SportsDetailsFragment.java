package com.bist.youthvibe2014;



import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SportsDetailsFragment extends Fragment {

	View rootView;
	private TextView descriptionView, rulesView, specificationView, criteriaView, contactView;
	private View descriptionHeadingView, rulesHeadingView, specificationHeadingView, criteriaHeadingView, contactHeadingView;
	private Button registrationButton;
	private int categoryPosition, eventPosition;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView  = inflater.inflate(R.layout.event_details_fragment, container, false);
		
		Bundle callingBundle = getArguments();
		final String catPos = callingBundle.getString("categoryPosition");
		categoryPosition = Integer.parseInt(catPos);
		final String eventPos = callingBundle.getString("eventPosition");
		eventPosition = Integer.parseInt(eventPos);
		
		// Getting the handle for headings
		descriptionHeadingView = rootView.findViewById(R.id.description_heading);
		rulesHeadingView = rootView.findViewById(R.id.rules_heading);
		specificationHeadingView = rootView.findViewById(R.id.specifications_heading);
		criteriaHeadingView = rootView.findViewById(R.id.judging_criteria_heading);
		contactHeadingView = rootView.findViewById(R.id.contact_heading);
		
		// Getting the handle for content panes
		descriptionView = (TextView) rootView.findViewById(R.id.description_content);
		rulesView = (TextView) rootView.findViewById(R.id.rules_content);
		specificationView = (TextView) rootView.findViewById(R.id.specifications_content);
		criteriaView = (TextView) rootView.findViewById(R.id.judging_criteria_content);
		contactView = (TextView) rootView.findViewById(R.id.contact_content);
		
		// Setting the hide and display
		descriptionHeadingView.setOnClickListener(new contentToggler());
		rulesHeadingView.setOnClickListener(new contentToggler());
		specificationHeadingView.setOnClickListener(new contentToggler());
		criteriaHeadingView.setOnClickListener(new contentToggler());
		contactHeadingView.setOnClickListener(new contentToggler());
		
		// Not Working yet
		EventDetails placeHolderEventDetails = null;
		
		// Choosing the details
		
				switch(eventPosition) {
					case 0:
						placeHolderEventDetails = sports_football.getInstance();
					break;
					case 1:
						placeHolderEventDetails = sports_basketball.getInstance();
					break;
					case 2:
						placeHolderEventDetails = sports_cricket.getInstance();
					break;
					case 3:
						placeHolderEventDetails = sports_volleyball.getInstance();
					break;
					default:
						placeHolderEventDetails = event_name.getInstance();
					break;
				}
			
		
		// Filling the details
		descriptionView.setText(placeHolderEventDetails.description);
		rulesView.setText(placeHolderEventDetails.rules);
		specificationView.setText(placeHolderEventDetails.specification);
		criteriaView.setText(placeHolderEventDetails.criteria);
		contactView.setText(placeHolderEventDetails.contact);
		
		// Setting the register button
		registrationButton = (Button) rootView.findViewById(R.id.event_registration_button);
		registrationButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				RegistrationFragment regisFrag = new RegistrationFragment();
				FragmentTransaction transaction = getFragmentManager().beginTransaction();
				transaction.replace(R.id.event_details_fragment_container, regisFrag);
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
		
		return rootView;
	}
}

/*class contentToggler implements View.OnClickListener {
	@Override
	public void onClick(View v) {
		ViewGroup parent = (ViewGroup) v.getParent();
		View childView = parent.getChildAt(parent.indexOfChild(v) + 1);
		this.viewToggler(childView);
    }
	
	private void viewToggler(View view) {
		if(view.getVisibility() == View.VISIBLE) {
			view.setVisibility(View.GONE);
		} else {
			view.setVisibility(View.VISIBLE);
		}
	}
}*/

/*
 * A class to contain the details of events.
 * This must be extended before used.
 */
/*class EventDetails {
	String description, rules, specification, criteria, contact;
	public EventDetails() {
		description = "Event description";
		rules = "Event rules";
		specification = "Event specification";
		criteria = "Event criteria";
		contact = "Event contact";
	}
}*/

/*
 * PlaceHolder for the eventDetails sub object, works also as a Sample
 */
/*class event_name extends EventDetails {
	
	public event_name() {
		description = "";
		
		rules = "";
		
		specification = "";
		
		criteria = "";
		
		contact = "";
	}
	
	public static event_name getInstance() {
		return new event_name();
	}
}*/

class sports_football extends EventDetails {
	
	public sports_football() {
		description = "";
		
		rules = "01. Each team consists of 15 members."
+ "\n02. Total substitution of 3 players in a match."
+ "\n03. One player cannot play with two teams."
+ "\n04. Qualifiers will be of 60 minutes, divided into two halves of 30 minutes."
+ "\n05. Matches will be played on knockout basis."
+ "\n06. Team should report 20 minute before start of play."
+ "\n07. Team should give name of playing eleven 10 minutes before start of play."
+ "\n08. Walkover will be given to the opposition in case of not reporting on time."
+ "\n09. Winner will be decided by the penalty shootout in case of draw."
+ "\n10. Yellow and red card will be shown as per FIFA rules."
+ "\n11. Decision of organizing committee will be final."
+ "\n12. Players should maintain the decorum of the game."
+ "\n13. Winner and runner up will be awarded with cash prize, trophy and certificates.";
		
		specification = "";
		
		criteria = "";
		contact = "";
	}
	
	public static sports_football getInstance() {
		return new sports_football();
	}
}

class sports_basketball extends EventDetails {
	
	public sports_basketball() {
description = "";
		
		rules = "01. Each team consists of 12 members."
+ "\n02. Match will be of 40 minutes divided into 4 quarters of 10 min each."
+ "\n03. Team should report 20 min before start of play."
+ "\n04. Walkover will be given to the opposition in case of not reporting on time."
+ "\n05. All matches shall be played on knockout basis."
+ "\n06. Winner and runner up will be awarded with trophy, cash prizes and certificates."
+ "\n07. Decision of officials will be final."
+ "\n08. Matches will be played as per new rules of NBA."
+ "\n09. Players should maintain the decorum of the game."
+ "\n10. Winner and runner up will be awarded with cash prize, trophy and certificates.";
		
		specification = "";
		
		criteria = "";
		contact = "";
	}
	
	public static sports_basketball getInstance() {
		return new sports_basketball();
	}
}

class sports_cricket extends EventDetails {
	
	public sports_cricket() {
description = "";
		
		rules = "01. Each team consists of 15 members."
+ "\n02. Matches will be played at knock out basis."
+ "\n03. All matches shall be 15-15 and 20-20 from Semi Final Stages."
+ "\n04. Walkover will be given to other team in case of not reporting on time."
+ "\n05. Team should report 30 min before the start of play."
+ "\n06. Matches will be played by leather ball."
+ "\n07. Teams should have their own cricketing kit."
+ "\n08. Organizing committee will not providing any kit to the teams."
+ "\n09. Decision of ground umpires will be final."
+ "\n10. Matches will be played as per new cricketing rules of ICC."
+ "\n11. Decision of organizing committee will be final."
+ "\n12. Winner and runner up will be awarded with cash prize, trophy and certificates.";
		
		specification = "";
		
		criteria = "";
		contact = "";

	}
	
	public static sports_cricket getInstance() {
		return new sports_cricket();
	}
}

class sports_volleyball extends EventDetails {
	
	public sports_volleyball() {
description = "";
		
		rules = "01. Each team consists of 12 players."
+ "\n02. There will be no rotation of players."
+ "\n03. Matches will be played on knockout basis."
+ "\n04. Matches will be of 3 sets of 20 minutes each."
+ "\n05. Semi and final will be of 5 sets of 20 min of each."
+ "\n06. Walkover will be given to opposition in case of not reporting on time."
+ "\n07. Team will report 20 minutes before start of play."
+ "\n08. Winner and runner up will be awarded with cash prize, trophy and certificates."
+ "\n09. Decision of officials will be final."
+ "\n10. Matches will be played as per new rules of FIVB.";
		
		specification = "";
		
		criteria = "";
		contact = "";
	}
	
	public static sports_volleyball getInstance() {
		return new sports_volleyball();
	}
}

