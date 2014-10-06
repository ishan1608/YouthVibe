package com.bist.youthvibe2014;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class LifeStyleDetailsFragment extends Fragment {

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
						placeHolderEventDetails = lifestyle_paridhaan.getInstance();
					break;
					case 1:
						placeHolderEventDetails = lifestyle_yv_icon_hunt.getInstance();
					break;
					case 2:
						placeHolderEventDetails = lifestyle_mrandmsyouthvibe.getInstance();
					break;
					default:
						placeHolderEventDetails = event_name.getInstance();
					break;
				}
			break;
			default:
				// There is no need for this, but still I am adding it as it makes everything look consistent
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
}
*/
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
}
*/
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
}
*/

class lifestyle_paridhaan extends EventDetails {
	
	public lifestyle_paridhaan() {
		description = "\"Fashion is not something that exists in dresses only. Fashion is in the sky, in the street. Fashion has to do with ideas & the way we live\""
+ "\nIf you are trendy enough to be different from everybody else, don't change. Be the reason of the crowd not part of the crowd. Here is your chance to enchant everyone by your charismatic walk and Rock the stage with your attitude and costumes.";
		
		rules = "01. There should be 8 -24 participants per team exclusive of the designer, choreographer and supporting members." 
+ "\n02. It is a theme based Fashion show where every team has to represent a unique and innovative theme. Some examples of themes are as follows: Bridal,Celebrations and Occasions, Festival, Indo-western, Black and White (retro), Colors, Formals, Diversity in India, Diversity of the world,Eco-oriented, Negative Power, Terrorism, World Peace, Deforestation or any other themes as per your choice. "
+ "\n03. A maximum of 20 minutes including set up and clearance. Your time starts counting as soon as the name of the team is announced. "
+ "\n04. T-shaped extension will be provided on the main stage."
+ "\n05. One person per team must be there to manage sound track and one for the lights."
+ "\n06. Emphasis will be given to themes, waling style, props and originality."
+ "\n07. No props and costumes will be provided by us. Teams have to bring their own costumes and props."
+ "\n08. Use of materials like candles, fire, cigarettes, alcohol and any hazardous materials on stage is prohibited."
+ "\n09. Two copies of soundtrack to be submitted prior to the show in standard audio format- .wav or.mp3 of sound quality 320kbps or above to the organizers (in C.Ds or PD , no laptops). "
+ "\n10. Vulgarity of any kind would lead to disqualification of the team from the event. Hence, if the team feels that any stunt of costume design can be deemed as vulgar, it is strongly advised to consult organizers than performing it directly on stage."
+ "\n11. A green room would be provided for changing purpose separately for boys and girls but the same may be shared by two or more teams."
+ "\n12. The decision of the judges and organizing committee will be final and binding in all respect."
+ "\n13. It is imperative that all team members must possess a valid college id which must be presented at the time of registration.";		
		specification = "";
		
		criteria = "01. Models and Walks "
+ "\n02. Costumes" 
+ "\n03. Justification of theme "
+ "\n04. Choreography and overall impact";
		contact = "Mr. Peeyush Sharma"
+ "\n+91 9501834195";
	}
	
	public static lifestyle_paridhaan getInstance() {
		return new lifestyle_paridhaan();
	}
}
class lifestyle_yv_icon_hunt_reference extends EventDetails {
	
	public lifestyle_yv_icon_hunt_reference() {
		description = "It's time to stop dreaming and start living your dreams. If being a part of the glamorous world of modeling is your dream then here is your chance to live it with Youth Vibe Model Hunt 2014! This gives you the perfect platform to showcase your talent and flaunt your style."
+ "\nAll you have to do is walk and walk with such swag that makes people turn their heads as you pass by. "
+ "\nSo, gather all the confidence and get ready to become not just super model but ROLE MODEL!";
		
		rules = "Day 1 (Audition Round- Theme Free Style) "
+ "\nThe theme is Free Style where the contestants shall wear their own outfits and style their own look. The Round will start with the audition of the participants where they will walk the ramp with their sizzling style amidst high bass music. "
+ "\nDay 2" 
+ "\nRound 1 (Theme Aqua) The contestants will have to walk the ramp carrying the essence of aqua shades in their costumes."
+ "\nRound 2 (Indo Western) It starts with the entry of contestants clad in their colorful and appealing costumes as the theme would be â€œIndo western which would show their creativity and style. The clothes they pick must be a combination of Indian and Western wear which they will showcase in their ramp walk. "
+ "\nDay 3  Grand Finale"
+ "\nRound 1 (Theme- Representing state) Grand finale will start with the ramp walk where the contestants will dress up in the attire that represents their state."
+ "\nRound 2 Formals Students will then have to walk the ramp again, but this time carrying a prop which they would be given on the spot."
+ "\nThey will be judged on the style of flaunting the prop! Then the students will be judged by two major points; Communication Skills & Confidence, so students will have to give their introduction and then answer the questions asked by the eminent jury members";
		
		specification = "";
		
		criteria = "01. Models will be judged based on a host of parameters including poise."
+ "\n02. Confidence."
+ "\n03. Attitude."
+ "\n04. Elegance."
+ "\n05. Costumes and personality by a distinguished panel of judges.";
		
		contact = "Mr. Peeyush Sharma"
				+ "\n+91 9501834195";
			}
	
	public static lifestyle_yv_icon_hunt_reference getInstance() {
		return new lifestyle_yv_icon_hunt_reference();
	}
}

class lifestyle_yv_icon_hunt extends EventDetails {
	
	public lifestyle_yv_icon_hunt() {
		description = "Coming Soon";
		
		rules = "";
		
		specification = "";
		
		criteria = "";
		
		contact = "";
	}
	
	public static lifestyle_yv_icon_hunt getInstance() {
		return new lifestyle_yv_icon_hunt();
	}
}

class lifestyle_mrandmsyouthvibe extends EventDetails {
	
	public lifestyle_mrandmsyouthvibe() {
		description = "Coming Soon";
		
		rules = "";
		
		specification = "";
		
		criteria = "";
		
		contact = "";
	}
	
	public static lifestyle_mrandmsyouthvibe getInstance() {
		return new lifestyle_mrandmsyouthvibe();
	}
}