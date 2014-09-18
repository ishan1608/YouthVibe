package com.bist.youthvibe2014;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class TechnicalDetailsFragment extends Fragment {

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
		switch(categoryPosition) {
			case 0:
				switch(eventPosition) {
					case 0:
						placeHolderEventDetails = techincal_mechatronix_the_battle_ship.getInstance();
					break;
					default:
					break;
				}
			break;
			default:
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

class contentToggler implements View.OnClickListener {
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
}

class EventDetails {
	String description, rules, specification, criteria, contact;
	public EventDetails() {
		description = "Event description";
		rules = "Event rules";
		specification = "Event specification";
		criteria = "Event criteria";
		contact = "Event contact";
	}
}

class techincal_mechatronix_the_battle_ship extends EventDetails {
	
	public techincal_mechatronix_the_battle_ship() {
		description = "\"Safari So Good!!!!\""
				+ "\nAn event where you would be able to encounter the remote controlled robotic boat with weapons of destruction."
				+ "\n\nType of event: Team\n\nTeam Size: 4";
		
		rules = "01. A team must contain a total of FOUR (4) members.\n"
				+ "\n02. The boat must maneuvered by a wireless remote control, if any controls are used."
				+ "\n03. The event would be conducted in TWO ROUNDS described as below:"
				+ "\n\nROUND 01: a. Test your Propellers. The boat has to reach the finish line in the least possible time."
				+ "\"BEST OF TWO TRIALS\" would be taken."
				+ "\nb. This round is basically used for \"TESTING THE SPEED and TIME\" of the Boats."
				+ "\nc. The arena would be FREE of OBSTACLES."
				+ "\nd. The number of teams qualifying for the second round will depend upon the number of participants."
				+ "\n\nROUND 02: (Speed and Manoeuver)"
				+ "\na. This round would test the speed, steering and accuracy of your boat."
				+ "\nb. There would be obstacles and a well-defined maze for your boat to follow without hitting the boundaries of the maze."
				+ "\nNOTE: TWO SECONDS PENALTY FOR HITTING THE BOUNDARY.";
		
		specification = "Boat specifications:"
				+ "\n01. At any point of time the boat dimensions should not exceed the following :"
				+ "\nLength- 100cms"
				+ "\nBreadth- 40cms"
				+ "\nHeight- No Constraints"
				+ "\n02. Boat can be powered by either :"
				+ "\nA DC Electric Motor(brush or brushless),or"
				+ "\nBy other setups which include Hydro drives/Jet drives."
				+ "\n03. The Potential Difference across the Motors should not be more than 24V DC."
				+ "\n04. Readymade Components for the HULL are not entertained at any cost, if found guilty would be disqualified."
				+ "\n05. However, rudders, propellers and other electric motors (SERVOS) could be taken directly from other model/toy RC boats."
				+ "\n06. Necessary steps and precautions should be taken to so that the electric components are properly insulated so as to keep them safe and off from damage by water."
				+ "\nPOOL DIMENSIONS : The event would be conducted in the assigned pool of dimensions of (4mx3mx0.5m).";
		
		criteria = "01. SCORING PATTERN:"
				+ "\nROUND1: T1=Time taken to finish the Course."
				+ "\nROUND2: T2= (Time taken to finish the course) + (2*Number of times the boat collides with the walls of the maze)"
				+ "\n[Seconds penalty for hitting the walls of the maze]."
				+ "\nFinal Score= (T1+T2) 02. Judges decision shall be final and binding to the participants at any point of the time. The organizers reserve the right to change a part or whole of the specifications and rules mentioned above.";
		
		contact = "Mr. Bikram Sarmah"
				+ "\n+91 9646056969";
	}
	
	public static techincal_mechatronix_the_battle_ship getInstance() {
		return new techincal_mechatronix_the_battle_ship();
	}
}