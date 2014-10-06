package com.bist.youthvibe2014;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MediaEventsDetailsFragment extends Fragment {

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
						placeHolderEventDetails = media_events_scribble_pad.getInstance();
					break;
					case 1:
						placeHolderEventDetails = media_events_decibel.getInstance();
					break;
					case 2:
						placeHolderEventDetails = media_events_walking_camera.getInstance();
					break;
					case 3:
						placeHolderEventDetails = event_name.getInstance();
					break;
					case 4:
						placeHolderEventDetails = media_events_additivity.getInstance();
					break;
					case 5:
						placeHolderEventDetails = media_events_tag_it.getInstance();
					break;
					case 6:
						placeHolderEventDetails = media_events_frame_box.getInstance();
					break;
					case 7:
						placeHolderEventDetails = media_events_face_to_face.getInstance();
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

class media_events_scribble_pad extends EventDetails {
	
	public media_events_scribble_pad() {
		description = "SCRIBBLE PAD: The Story Writing Competition "
				+ "\nIntroduction:"
				+ "\nThe event is about developing story by using 5 to 7 words. "
				+ "\nEvent Type: Solo"
				+ "\nTeam Size: 1 ";
		
		rules = "Rules & Regulation:"
				+ "\n-o-The participants will be given 5 to 7 words( English and its Hindi meaning) on the spot"
				+ "\n-o-Participants can write either in English or Hindi"
				+ "\n-o-Each of the words is to be used at least 3 times in the story"
				+ "\n-o-The time limit is 45 minutes"
				+ "\n-o-Word limit: 500 to 1000 words";
		
		specification = "";
		
		criteria = "-o-Creativity"
				+ "\n-o-Appropriate utility of given words"
				+ "\n-o-Story idea ";
		
		contact = "Mr. Neeraj Verma"
				+ "\n+91-9592414848";
	}
	
	public static media_events_scribble_pad getInstance() {
		return new media_events_scribble_pad();
	}
}

class media_events_decibel extends EventDetails {
	
	public media_events_decibel() {
		description = "Decibel: The RJ Hunt"
				+ "\nIntroduction"
				+ "\nIt's an event of RJying. Participants have to act as a Radio Jockey."
				+ "\nEvent Type: Solo"
				+ "\nTeam Size: 1";
		
		rules = "Rules & Regulation of the Event:"
				+ "\n-o-It is a solo event."
				+ "\n-o-There will be 2 rounds:"
				+ "\n-o-The preliminary Round "
				+ "\n-o-The grand finale:"
				+ "\n-o-Topic will be given on the spot"
				+ "\n-o-The participant can speak in either Hindi or English or both. The participant will be given 5 min for scripting before each round (If at all is required).";
		
		specification = "";
		
		criteria = "-o-Spontaneity"
				+ "\n-o-Command over language"
				+ "\n-o-Confidence"
				+ "\n-o-Body language"
				+ "\n-o-Interaction with crowd.";
		
		contact = "Mr. Neeraj Verma"
				+ "\n+91-9592414848";
	}
	
	public static media_events_decibel getInstance() {
		return new media_events_decibel();
	}
}

class media_events_walking_camera extends EventDetails {
	
	public media_events_walking_camera() {
		description = "WALKING CAMERA: Mobile movie making competition "
				+ "\nIntroduction"
				+ "\nParticipants have to shoot a meaningful short film on his mobile on the basis of various activities performed in the festival. "
				+ "\nEvent Type: Group"
				+ "\nTeam Size: 1-3";
		
		rules = "Rules & Regulation of the Event"
				+ "\n-o-Theme will be given on the spot"
				+ "\n-o-Duration of the movie will be 2-3 minutes"
				+ "\n-o-Editing will be done by the student on his own personal computer."
				+ "\n-o-No labs or computers systems shall be facilitated. ";
		
		specification = "";
		
		criteria = "-o-Content of the message"
				+ "\n-o-Shot composition.";
		
		contact = "Mr. Neeraj Verma"
				+ "\n+91-9592414848";
	}
	
	public static media_events_walking_camera getInstance() {
		return new media_events_walking_camera();
	}
}

class media_events_taza_khabar extends EventDetails {
	
	public media_events_taza_khabar() {
		description = "TAZA KHABAR (TV Studio) "
				+ "\nIntroduction"
				+ "\nParticipant will shoot a news package consisting of a reporter, script writer and camera-man. Every participant must perform their task to the best of their ability."
				+ "\nEvent Type: Group"
				+ "\nTeam Size: 3-5";
		
		rules = "Rules & Regulation of the Event:"
				+ "\n-o-The equipment's i.e. TV Camera and mike will be installed by organizer."
				+ "\n-o-The participants must be efficient in handling the camera"
				+ "\n-o-Topic will be given on the spot"
				+ "\n-o-5 minutes for scripting and 3 minutes for reporting will be given to the participants"
				+ "\n-o-The language can be Hindi or English";
		
		specification = "";
		
		criteria = "";
		
		contact = "";
	}
	
	public static media_events_taza_khabar getInstance() {
		return new media_events_taza_khabar();
	}
}

class media_events_additivity extends EventDetails {
	
	public media_events_additivity() {
		description = "ADITIVITY-Quick ad/ Spot moment"
				+ "\nIntroduction"
				+ "\nParticipant will prepare a quick add on the basis of theme allotted to him on the spot. Participant will themselves shoot and edit the advertisement with their own equipment."
				+ "\nEvent Type: Group"
				+ "\nTeam Size: 3"
				+ "\nRules & Regulation of the Event"
				+ "\n-o-A team of total 3 members i.e. copywriter/visualizer/director, cameramen, video editor "
				+ "\n-o-Advertisement can be on any product /service/idea."
				+ "\n-o-Duration of the ad should be between 30 sec to 1min"
				+ "\n-o-Format of the ad should be any DVD/CD or in Pen drive and must be submitted prior to starting of screening to the organisers / coordinators of the event."
				+ "\n-o-The ad can be in English or Hindi or with voice /music or without it.";
		
		rules = "";
		
		specification = "-o-Creative concept"
				+ "\n-o-Technical quality";
		
		criteria = "";
		
		contact = "Mr. Neeraj Verma"
				+ "\n+91-9592414848";
	}
	
	public static media_events_additivity getInstance() {
		return new media_events_additivity();
	}
}

class media_events_tag_it extends EventDetails {
	
	public media_events_tag_it() {
		description = "TAG IT: Caption Writing Competition"
				+ "\nIntroduction: "
				+ "\nParticipant will be shown one picture and they have to write appropriate caption for it. "
				+ "\nEvent Type: Solo "
				+ "\nTeam Size: 1 ";
		
		rules = "Rules & Regulation: "
				+ "\n-o-A set of 5 photos shall be given on the spot. "
				+ "\n-o-The contestants shall be required to tag each one of them. "
				+ "\n-o-The captions should not be more than 8 words. "
				+ "\n-o-The caption can be in English or Hindi or a mixture of the two.";
		
		specification = "";
		
		criteria = "-o-Appropriateness of the caption"
				+ "\n-o-The use of creativity.";
		
		contact = "Mr. Neeraj Verma"
				+ "\n+91-9592414848";
	}
	
	public static media_events_tag_it getInstance() {
		return new media_events_tag_it();
	}
}

class media_events_frame_box extends EventDetails {
	
	public media_events_frame_box() {
		description = "Frame box: the Editing Lab "
				+ "\nIntroduction"
				+ "\nStudents will be given video clips on the spot and they have to edit them as per their ability."
				+ "\nEvent Type: Group "
				+ "\nTeam Size: 1-3";
		
		rules = "Rules & Regulation of the Event"
				+ "\n-o-The software to be used is FCP."
				+ "\n-o-System/computer will be provided by the organizing team"
				+ "\n-o-Video clips will be given on the spot."
				+ "\n-o-Participants will have to edit visuals and audio as per instructions to be given on the spot.";
		
		specification = "";
		
		criteria = "-o-Grammar of video editing applied"
				+ "\n-o-Continuity"
				+ "\n-o-Consistency ";
		
		contact = "Mr. Neeraj Verma"
				+ "\n+91-9592414848";
	}
	
	public static media_events_frame_box getInstance() {
		return new media_events_frame_box();
	}
}

class media_events_face_to_face extends EventDetails {
	
	public media_events_face_to_face() {
		description = "FACE TO FACE: The Mock Press Conference "
				+ "\nIntroduction"
				+ "\nIt is a Mock Press Conference "
				+ "\nEvent Type: Duet"
				+ "\nTeam Size: 2";
		
		rules = "Rules & Regulation of the Event"
				+ "\n-o-Student in group will organise a mock press conference. "
				+ "\n-o-One participant will assume the identity of a well-known personality from any field and the other will act as a reporter for asking questions to the participants from other teams";
		
		specification = "";
		
		criteria = "-o-Communication skills"
				+ "\n-o-Role modelling "
				+ "\n-o-Aptness of handling questions"
				+ "\n-o-Skills of Journalism ";
		
		contact = "Mr. Neeraj Verma"
				+ "\n+91-9592414848";
	}
	
	public static media_events_face_to_face getInstance() {
		return new media_events_face_to_face();
	}
}