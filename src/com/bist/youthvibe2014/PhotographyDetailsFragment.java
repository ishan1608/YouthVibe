package com.bist.youthvibe2014;



import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class PhotographyDetailsFragment extends Fragment {

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
						placeHolderEventDetails = photography_perfect_picture.getInstance();
					break;
					case 1:
						placeHolderEventDetails = photography_directors_cut.getInstance();
					break;
					case 2:
						placeHolderEventDetails = photography_real_to_reel.getInstance();
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

class photography_perfect_picture extends EventDetails {
	
	public photography_perfect_picture() {
		description = "PICTURE PERFECT: The Photography Championship"
+"\n Photography is the only language that can be understood all aroun the world"
+ "\nThis year we are introducing a very exciting event called \"PHOTOGRAPHY CHAMPIONSHIP\"." 
+ "\nTo participate in this championship the student should inbox three (3) photographs (one each on the theme: macro Photography, fashion Photography and Catch the moment photography) to the official Youth Vibe Page (www.facebook.com/youthvibe). "
+ "\nThese photographs can be taken from any part of the world but in the year 2014. "
+ "\nWe shall post the photos on our page and in case the number of likes on the three photos combined is above 300, you shall be shortlisted for the main competition."
+ "\nThe three photographs must have the logo of Youth Vibe on it and a message for the aspirants/participants and organizers of the festival. "
+ "\n\nThere shall be further three rounds in the competition:"
+ "\nRound 1 - Macro Photography"
+ "\nRound 2 - Fashion Photography"
+ "\nRound 3 - Catch the moment!";
		
		rules = "01. The photographs for all the 3 rounds should be captured only from Lovely Professional University and during the youth vibe 2014."
+ "\n02. Each round will be in different days and participants should submit 5 best photos on each day to the venue which will be intimated later."
+ "\n03. Results or the list of qualified students for the next round will be declared on the very next day morning or before."
+ "\n04. The entry must be the original work of the student."
+ "\n05. Photographs must be in digital format."
+ "\n06. No print or film submissions will be accepted for entry into this Contest." 
+ "\n07. All digital files must be in JPEG or .jpg format, and must be at least 1,600 pixels wide (if a horizontal image) or 1,600 pixels tall (if a vertical image)."
+ "\n08. Only minor burning, dodging and/or colour correction is acceptable, as is cropping."
+ "\n09. High dynamic range images (HDR) and stitched panoramas are NOT acceptable."
+ "\n10. Any changes to the original Photograph not itemized here are unacceptable and will render the Photograph ineligible for a prize."
+ "\n11. The photograph must not, in the sole and unfettered discretion of the Sponsor, contain obscene, provocative, defamatory, sexually explicit, or otherwise objectionable or inappropriate content.";
		
		specification = "";
		
		criteria = "01. Photo is a fit and relevance to the category."
+ "\n02. Composition/Frame"
+ "\n03. Creativity"
+ "\n04. Technical quality(Exposure, Focus, depth of field)"
+ "\n05. Overall Impression";		
		contact = "";
	}
	
	public static photography_perfect_picture getInstance() {
		return new photography_perfect_picture();
	}
}

class photography_directors_cut extends EventDetails {
	
	public photography_directors_cut() {
		description = "DIRECTOR's CUT  The Short Film making competition (Entertainment/Fiction)"
+ "\nEver thought of making a movie on your own? Here is your chance to produce a completely entertainment/fiction based short film.";
		
		rules = "01. Your short film should not be longer than 12 minutes and not shorter than 8 minutes."
+ "\n02. The entry must be the original work of the student(s)."
+ "\n03. The production team size should not exceed 15 including all actors and actress (scenes where the crowd is involved is acceptable without being counted in the production team). "
+ "\n04. Limited use of copyrighted material will be permitted in the entry so long as it is a lawful or \"fair\" use, and so long as such use does not overwhelm the contribution of the student(s). "
+ "\n05. You may submit your film in either of the three methods:"
+ "\n5.1. Upload it on you Tube or other sharing sites and email us the link"
+ "\n5.2. Send us a CD/DVD of the same"
+ "\n5.3. Submit it to us personally with the help of HDD"
+ "\n06. Please make sure that your finished short film is under 1.5 GB in size and that it is in one of the following video formats: .AVI .MOV .MPG .MPG2 .MPEG2 .MPEG4 .MP4 .WMV"
+ "\n07. By submitting an entry, entrants represent that their entries constitute original works of creativity that do not violate the property rights of any other person, and grant YOUTH VIBE '14 the right to exhibit, distribute, televise and otherwise use the entries in various media."
+ "\n08. Once the movie is shortlisted, at least one of the members of the production team must be physically present at the showcase in order to answer the questions of the judging panel";
		
		specification = "";
		
		criteria = "1. Story/Script"
+ "\n2. Direction"
+ "\n3. Cinematography"
+ "\n4. Creativity"
+ "\n5. Technical quality and Overall impression";		
		contact = "";
	}
	
	public static photography_directors_cut getInstance() {
		return new photography_directors_cut();
	}
}

class photography_real_to_reel extends EventDetails {
	
	public photography_real_to_reel() {
		description = "REAL TO REEL: The Documentary";
		
		rules = "01. The film has to be non fictional and must have a message to give."
+ "\n02. Your short film should not be longer than 15 minutes and not shorter than 9 minutes."
+ "\n03. The entry must be the original work of the student(s)."
+ "\n04. The production team size should not exceed 15 including all actors and actress (scenes where the crowd is involved is acceptable without being counted in the production team)."
+ "\n05. Limited use of copyrighted material will be permitted in the entry so long as it is a lawful or \"fair\" use, and so long as such use does not overwhelm the contribution of the student(s)."
+ "\n06. You may submit your film in either of the three methods:"
+ "\no Upload it on you Tube or other sharing sites and email us the link."
+ "\no Send us a CD/DVD of the same"
+ "\no Submit is to us personally with the help of HDD"
+ "\n07. Please make sure that your finished short film is under 1.5 GB in size and that it is in one of the following video formats: .AVI .MOV .MPG .MPG2 .MPEG2 .MPEG4 .MP4 .WMV"
+ "\n08. By submitting an entry, entrants represent that their entries constitute original works of creativity that do not violate the property rights of any other person, and grant YOUTH VIBE '14 the right to exhibit, distribute, televise and otherwise use the entries in various media."
+ "\n09. Once the movie is shortlisted, at least one of the members of the production team must be ";		
		specification = "";
		
		criteria = "01. Story/Script,"
+ "\n02. Direction,"
+ "\n03. Cinematography,"
+ "\n04. Creativity,"
+ "\n05. Technical quality and Overall impression";
		contact = "";
	}
	
	public static photography_real_to_reel getInstance() {
		return new photography_real_to_reel();
	}
}