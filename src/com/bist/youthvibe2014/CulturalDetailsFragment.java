package com.bist.youthvibe2014;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class CulturalDetailsFragment extends Fragment {

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
						placeHolderEventDetails = cultural_music_folkalley.getInstance();
					break;
					case 1:
						placeHolderEventDetails = cultural_music_folkgeet.getInstance();
					break;
					case 2:
						placeHolderEventDetails = cultural_music_goonj.getInstance();
					break;
					case 3:
						placeHolderEventDetails = cultural_music_armagedon.getInstance();
					break;
					case 4:
						placeHolderEventDetails = cultural_music_legacy.getInstance();
					break;
					case 5:
						placeHolderEventDetails = cultural_music_rapstar.getInstance();
					break;
					case 6:
						placeHolderEventDetails = cultural_music_rythm.getInstance();
					break;
					case 7:
						placeHolderEventDetails = cultural_music_voiceofyv.getInstance();
					break;
					case 8:
						placeHolderEventDetails = cultural_music_yvunplugged.getInstance();
					break;
					default:
						placeHolderEventDetails = event_name.getInstance();
					break;
				}
			break;
			case 1:
				switch(eventPosition) {
				case 0:
					placeHolderEventDetails = cultural_dance_thedancingsoul.getInstance();
				break;
				case 4:
					placeHolderEventDetails = cultural_dance_footloose.getInstance();
				break;
				case 2:
					placeHolderEventDetails = cultural_dance_thedancingmessangers.getInstance();
				break;
				case 3:
					placeHolderEventDetails = cultural_dance_Justduet.getInstance();
				break;
				case 1:
					placeHolderEventDetails = cultural_dance_downthestreet.getInstance();
				break;
				case 5:
					placeHolderEventDetails = cultural_dance_indianfolkdance.getInstance();
				break;
				case 6:
					placeHolderEventDetails = cultural_dance_folkingham.getInstance();
				break;
				case 7:
					placeHolderEventDetails = cultural_dance_nrityanatraj.getInstance();
				break;
				case 8:
					placeHolderEventDetails = cultural_dance_boxoffice.getInstance();
				break;
				default:
					placeHolderEventDetails = event_name.getInstance();
				break;
			}
		break;
				
			case 2:
				switch(eventPosition) {
						case 0:
							placeHolderEventDetails = cultural_theatre_chaupal.getInstance();
						break;
						case 1:
							placeHolderEventDetails = cultural_theatre_kalaajaurkal.getInstance();
						break;
						case 2:
							placeHolderEventDetails = cultural_theatre_atrangi.getInstance();
						break;
						case 3:
							placeHolderEventDetails = cultural_theatre_nakalchee.getInstance();
						break;
						case 4:
							placeHolderEventDetails = cultural_theatre_darbaar.getInstance();
						break;
						default:
							placeHolderEventDetails = event_name.getInstance();
						break;
				}
				break;
			case 3:
				switch(eventPosition) {
					case 0:
						placeHolderEventDetails = cultural_finearts_vibgyor.getInstance();
					break;
					case 1:
						placeHolderEventDetails = cultural_finearts_chalktalk.getInstance();
					break;
					case 2:
						placeHolderEventDetails = cultural_finearts_dawn2dusk.getInstance();
					break;
					case 3:
						placeHolderEventDetails = cultural_finearts_imagination.getInstance();
					break;
					case 4:
						placeHolderEventDetails = cultural_finearts_thepermanentcrayons.getInstance();
					break;
					case 5:
						placeHolderEventDetails = cultural_finearts_heena.getInstance();
					break;
					case 6:
						placeHolderEventDetails = cultural_finearts_gossipogirl.getInstance();
					break;
					case 7:
						placeHolderEventDetails = cultural_finearts_laurel.getInstance();
					break;
					case 8:
						placeHolderEventDetails = cultural_crafting_marathon.getInstance();
					break;
					case 9:
						placeHolderEventDetails = cultural_expedition_marathon.getInstance();
					break;
					case 10:
						placeHolderEventDetails = cultural_quill_arts_marathon.getInstance();
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

class cultural_music_armagedon extends EventDetails {
	
	public cultural_music_armagedon() {
		description = "ARMAGEDDON (BATTLE OF BANDS)"
				+ "\nThe more I compose, the more I know that I don't know it all. I think it's a good way to start. If you think you know it all, the work becomes a repetition of what you've already done. A.R. Rahman"
				+ "\n\nThere are two categories of this competition:-\n(i) RAGA-WARS (Indian Band Competition)-It is an Indian band Competition.\n(ii) SYNCHRONICITY (Western Band Competition )\nIt is a western band competition. "
				+ "\n\nType of event: Group\n\nTeam Size: 4-8"
				+ "\nNOTE: There are two separate competitions & Separate prizes will be given for the winners for Indian & Western Bands.";
		
		rules = "01. Participants will have to perform at least one original composition and up to two cover within the allocated time.\n"
				+ "\n02. For RAGA WARS, at most one of the two cover songs in can be of regional language but the original composition has to be strictly in Hindi."
				+ "\n03. In SYNCHRONICITY, the bands are allowed to perform compositions of any bands of their choice or all original compositions in addition to their own original composition. The language has to be English mandatorily."
				+ "\n04. The bands are required to mention the Band / Album / Film of which the composition they shall be performing, at the beginning of each compositions."
				+ "\n05. The band will be given 30 minutes to perform including setup and clearance. Time starts counting as soon as you step on the stage even if for arranging instrument."
				+ "\n06. A stage will be provided, with electrical connections sufficient to service 5-piece drum with single pedal. Monitors will be provided on the stage, as well as up to 5 microphones. A drum set will be provided .Besides these, any other equipment will be brought by the teams themselves. The same applies to guitar distortion boxes and similar pieces of equipment."
				+ "\n07. No digital sequence can be played on stage."
				+ "\n08. If the Band Pauses or Struck during their performance (Until and unless itâ€™s any Technical Difficulty) the Band will get Penalized."
				+ "\n09. There should be no vulgarity and provocation in lyrics."
				+ "\n10. Any attempt of provoking the masses will not be tolerated and person will be Consider as a defaulter."
				+ "\n11. Specific requirements regarding lights and smoke must be discussed with organizers in advance."
				+ "\n12. The organizers hold the rights to enforce changes in the matter depending upon the suitability to the university without prior notice."
				+ "\n13. All Decisions by the Judges are Final.";
		specification = "";
		criteria = "01. Synchronization of the Band."
				+ "\n02. Vocals."
				+ "\n03. Individual skills of Instrumentalist."
				+ "\nOriginality of Music and Overall performance & Overall impact."
				+ "\nFinal Score= (T1+T2) 02. Judges decision shall be final and binding to the participants at any point of the time. The organizers reserve the right to change a part or whole of the specifications and rules mentioned above.";
		
		contact = "Mr. Rahul Choudhary"
				+ "\n+91 8556901211";
	}
	
	public static cultural_music_armagedon getInstance() {
		return new cultural_music_armagedon();
	}
}

class cultural_music_folkalley extends EventDetails {
	
	public cultural_music_folkalley() {
		description = "Folk Alley - International Folk Singing Competition"
					+ "\nIf I were not a physicist, I would probably be a musician. I often think in music. I live my daydreams in music. I see my life in terms of music. Albert Einstein"
				    + "\nIt is a group singing competition."
					+ "\nThe language of the songs can be any except Indian languages or English."
					+ "\n\nType of event: Group"
					+ "\nTeam Size: 06-12 [+ 5 accompanists if required]";
		
		rules = "01. Team size: Maximum 12 and minimum team size of 6 (3 singers + 3 accompanists). All the team members must be from the same college or university. A minimum of 6 participants should be on stage at any point of time."
					+ "\n02. The participants have to pick any non Indian folk song. More than one song can be sung within the time limit. "
					+ "\n03. Participants shall be given 12 minutes to perform including set up and clearance. Time starts counting as soon as you step on the stage even if for arranging instrument. A warning indication shall be given 11 minutes after the start of your time. "
					+ "\n04. Use of karaoke and music tracks is strictly not permitted. "
					+ "\n05. Any attempt of provoking the masses in any form either through lyrics or singing or action will not be tolerated and team shall be disqualified."
					+ "\n06. The organizers hold the rights to enforce changes in the matter depending upon the suitability to the university without Prior Notice. "
					+ "\n07. All Decisions by the judges would be considered Final."
					+ "\n08. Specific requirements regarding lights and smoke must be discussed with organizers in advance.";
		specification = "";
		
		criteria = "01. Rhythm and Beat."
					+ "\n02. Voice & Voice ModulationsPerformance & Song selection"
					+ "\n03. Harmony & Synchronization with Group and Overall Impact";
		
		contact = "Mr. Rahul Choudhary"
				+ "\n+91 8556901211";
	}
		public static cultural_music_folkalley getInstance() {
			return new cultural_music_folkalley();
		}
	}
			
	class cultural_music_goonj extends EventDetails {
		
		public cultural_music_goonj() {
			description = "GOONJ The Indian Group Singing Competition"
						+ "\nMelody of a group song has a certain way that it projects back to you. It triggers certain nerves in your body and certain instincts that normally wouldn't be triggered by a normal voice."
					    + "\nis Indian group singing competition."
						+ "\nOnly Hindi language is allowed in this competition. (No folk songs allowed)."
						+ "\n\nType of event: Group"
						+ "\nTeam Size: 12 [+ 5 accompanists if required]";
			
			rules = "01. Team size: Maximum 12 and minimum team size of 6 (3 singers + 3 accompanists). All the team members must be from the same college or university. A minimum of 6 participants should be on stage at any point of time."
                    + "\n02. Participants shall be given 12 minutes to perform including set up and clearance. Time starts counting as soon as you step on the stage even if for arranging instrument. A warning indication shall be given 11 minutes after the start of your time." 
                    + "\n03. One person cannot participate in more than one group in the same event."
                    + "\n04. Participants may get their own karaoke track to support their performance. Please carry it in 2 Pen Drives only. The music track/karaoke shall be checked for the suitability as per the rules of the University."
                    + "\n05. There should be no vulgarity and provoke in lyrics."
                    + "\n06. Any attempt of provoking the masses will not be tolerated and the participant shall be considered a defaulter."
                    + "\n07. Specific requirements regarding lights and smoke must be discussed with organizers in advance."
                    + "\n08. The organizers hold the rights to enforce changes in the matter depending upon the suitability to the university without prior Notice.";
			specification = "";
			
			criteria = "01. Rhythm and Beat."
                     + "\n02. Voice & Voice Modulations."
                     + "\n03. Performance & Song selection."
                     + "\n04. Harmony & Synchronization with Group and Overall Impact.";
			
			contact = "Mr. Rahul Choudhary"
					+ "\n+91 8556901211";			
				}
	
	public static cultural_music_goonj getInstance() {
		return new cultural_music_goonj();
	}
}

class cultural_music_folkgeet extends EventDetails {
	
	public cultural_music_folkgeet() {
		description = "FOLK GEET: The Indian Folk Singing Competition"
					+ "\nThere's music in the sighing of a reed; there is music in the gushing of a rill; There's music in all things, if men had ears: Their earth is but an echo of the spheres. -Lord Byron"
				    + "\nIt is a group singing competition. The language of the songs can be any language except Hindi or English."
					+ "\nType of event: Group"
					+ "\nTeam Size: 06-12 [+ 5 accompanists if required]";
		
		rules ="\n01. Team size: Maximum 12 and minimum team size of 6 (3 singers + 3 accompanists). All the team members must be from the same college or university. A minimum of 6 participants should be on stage at any point of time, involved in the song as vocalists or instrumentalists."
					+ "\n02. The participants have to pick any Indian folk song. More than one song can be sung within the time limit."
					+ "\n03. Participants shall be given 12 minutes to perform including set up and clearance. Time starts counting as soon as you step on the stage even if for arranging instrument. A warning indication shall be given 11 minutes after the start of your time. "
					+ "\n04. Use of karaoke and music tracks is strictly not permitted."
					+ "\n05. Any attempt of provoking the masses in any form either through lyrics or singing or action will not be tolerated and team shall be disqualified."
					+ "\n06. The organizers hold the rights to enforce changes in the matter depending upon the suitability to the university without Prior Notice."
					+ "\n07. All Decisions by the judges would be considered Final."
					+ "\n08. Specific requirements regarding lights and smoke must be discussed with organizers in advance.";
		specification = "";
		criteria = "01. Rhythm and Beat. "
				    + "\n02. Voice & Voice Modulations."
				    + "\n03. Performance & Song selection."
				    + "\n04. Harmony & Synchronization with Group and Overall Impact";
		
		contact = "Mr. Rahul Choudhary"
				+ "\n+91 8556901211";
	}
	
	public static cultural_music_folkgeet getInstance() {
		return new cultural_music_folkgeet();
	}
}

class cultural_music_legacy extends EventDetails {
	
	public cultural_music_legacy() {
		description = "Legacy- (Indian/International) Folk Orchestra"
					+ "\nMusic knows no barrier of age or culture. It isn't about being politically correct or even making a statement. Music is what appeals to yours ears and touches your soul. -A.R. Rahman"
				    + "\nIt is a (Indian/International) Folk Orchestra competition."
					+ "\nThe genre of the music should be instrumental.No vocals allowed."
					+ "\nType of event: Group"
					+ "\nTeam Size: 05-16";
					
		rules = "01. Each team will be given 15 minutes for the performance including setup and clearance. A warning indication shall be given 14 minutes after the start of your time. Time starts counting as soon as you step on the stage even if for arranging instrument."
					+ "\n02. The team may perform either original composition or inspirational compositions however the preference will be given to the original compositions. "
					+ "\n03. The performance has to be on live music only and no digital sequence can be played on stage. Various instruments required for the performance have to be arranged on their own. "
					+ "\n04. Specific requirements regarding lights and smoke must be discussed with organizers in advance."
					+ "\n05. Any attempt of provoking the masses will not be tolerated and person will be Consider as a defaulter."
					+ "\n06. The organizers hold the rights to enforce changes in the matter depending upon the suitability to the university without prior notice."
					+ "\n07. All Decisions by the Judges are Final.";
		
		specification = "";
		
		criteria = "01. Creativity on Original Composition"
				+"\n02. Synchronization of the Group"
				+"\n03. Crowd response"
				+"\n04. individual skills of instrumentalists and Overall Impact";
		
		contact = "Mr. Rahul Choudhary"
				+ "\n+91 8556901211";
	}
	
	public static cultural_music_legacy getInstance() {
		return new cultural_music_legacy();
	}
}

class cultural_music_rapstar extends EventDetails {
	
	public cultural_music_rapstar() {
		description = "I'm beginning to feel like a Rap God, Rap God, All my people from the front to the back nod, back nod now who thinks their arms are long enough to slap box, slap box? They said I rap like a robot, so call me rap-bot rap-bot!- EMINEM";
		
		rules = "01. The rap must be in English, Hindi or Punjabi or a mixture of the three."
					+ "\n02. The rap may or may not be original but extra credits shall be given to original compositions."
					+ "\n03. The participant can have one accompanist at the most"
					+ "\n04. A participant will be given 6 minutes to perform since their name is announced. This includes going to the stage, setting an instrument (if needed) and performing a sound check. There will be a warning indication after the completion of 5 minutes of performance. Exceeding time limit will lead to disqualification."
					+ "\n05. 3 printed copies of lyrics must be submitted to the organizers before the performance."
					+ "\n06. Performance without background music or beat boxing shall strictly not be allowed."
                    + "\n07. Participants must get their own karaoke track to support their performance. Please carry it in 2 Pen Drives only. The music track/karaoke shall be checked for the suitability as per the rules of the University."
                    + "\n08. In case the participants have some requirements in particular, those must be specified beforehand."
                    + "\n09. Participants shall bring all the required instruments and costumes by themselves."
                    + "\n10. The lyrics must not be provocative or vulgar and any attempt of provoking the masses will not be tolerated and in this case, the participant shall be disqualified."
                    + "\n11. The organizers hold the rights to enforce changes in the matter depending upon the suitability to the university without prior notice."
                    + "\n12. All Decisions by the Judges are Final";
		
		specification = "";
		criteria = "01. Originality and Lyrics"
                   + "\n02. Word Play"
                   + "\n03. Variations"
                   + "\n04. Performance and Overall Impact ";
		
		contact = "Mr. Rahul Choudhary"
				+ "\n+91 8556901211";
	}
	
	public static cultural_music_rapstar getInstance() {
		return new cultural_music_rapstar();
	}
}

class cultural_music_rythm extends EventDetails {
	
	public cultural_music_rythm() {
		description = "People ask me how I make music. I tell them I just step into it. It's like stepping into a river and joining the flow. Every moment in the river has its song. - Michael Jackson";
		
		rules = "01. The language of the songs must be non-English and non-Indian."
                 + "\n02. A participant will be given 6 minutes to perform since their name is announced. This includes going to the stage, setting an instrument (if needed) and performing a sound check. There will be a warning indication after the completion of 5 minutes of performance." 
                 + "\n03. Exceeding time limit will lead to disqualification."
                 + "\n04. Participants may perform on KARAOKE or LIVE MUSIC. However, they are required to arrange the same on their own. Please carry it in 2 Pen Drives only." 
                 + "\n05. In case the participants have some requirements in particular, those must be specified beforehand."
                 + "\n06. The lyrics must not be provocative or vulgar and any attempt of provoking the masses will not be tolerated and in this case, the participant shall be disqualified."
                 + "\n07. The organizers hold the rights to enforce changes in the matter depending upon the suitability to the university without prior notice."
                 + "\n08. All Decisions by the Judges are Final.";
		
		specification = "";
		
		criteria = "01. Rhythm and Beat."
                   + "\n02. Voice Quality."
                   + "\n03. Song selection & Performance."
                   + "\n04. Voice Modulation and Overall impact.";
		
		contact = "Mr. Rahul Choudhary"
				+ "\n+91 8556901211";

	}
	
	public static cultural_music_rythm getInstance() {
		return new cultural_music_rythm();
	}
}

class cultural_music_voiceofyv extends EventDetails {
	
	public cultural_music_voiceofyv() {
		description = "After silence, that which comes nearest to expressing the inexpressible is music. Music can express that which cannot be said and on which it is impossible to be silent. Because Some people have lives; some people have music."
					+ "\nThere are two categories of this competition"
					+ "\nNOTE: There are two separate competitions & Separate prizes will be given for the winners for Indian & Western singing."
					+ "\n\nType of event: Solo"
					+ "\nTeam Size: 01"
					+ "\n\n(i) Indian Solo Singing"
                    + "\n\nThe event will be held in 3 rounds. There shall be eliminations after every round."
					+ "\nRound 1: participants are free to select a song of the genre of their choice in any Indian Language."
					+ "\nRound 2: In the second round the contestant would be asked to perform a 90s & pre 90s song."
					+ "\nRound 3: Subject to selection in the second round, this rounds song/genre shall be allotted by the organizers and the contestants shall be bound to perform on that particular track/genre."
                    + "\n\n(ii) Western Solo Singing"
                    + "\n\nThe event will be held in 3 rounds. There shall be eliminations after every round."
					+ "\nRound 1: Participants are free to select an English song of the genre of their choice."
					+ "\nRound 2: The participant is required to perform a song of Blues/Rock/Pop genre."
					+ "\nRound 3: Subject to selection in the second round, this rounds song/genre shall be allotted by the organizers and the contestants shall be bound to perform on that particular track/genre.";
		
		rules = "01. A participant will be given 6 minutes to perform since their name is announced. This includes going to the stage, setting an instrument (if needed) and performing a sound check. There will be a warning indication after the completion of 5 minutes of performance."
                + "\n02. Basic orchestra support shall be available. However, the contestants are free to arrange their own karaoke or live music. Please carry it in 2 Pen Drives only. The music track/karaoke shall be checked for the suitability as per the rules of the University."
                + "\n03. In case the participants have some special requirements, those must be specified beforehand to the stage coordinator present at the venue, at least 30 minutes before the start of the event."
                + "\n04. The lyrics must not be provocative or vulgar and any attempt of provoking the masses will not be tolerated and in this case, the participant shall be disqualified."
                + "\n05. The organizers hold the rights to enforce changes in the matter depending upon the suitability to the university without prior notice."
                + "\n06. All Decisions by the Judges are Final.";
		
		specification = "";
		
		criteria = "01. Sur and Taal."
                  + "\n02. Voice Quality."
                  + "\n03. Song Selection and Performance."
                  + "\n04. Voice Modulations and Overall impact.";
		
		contact = "Mr. Rahul Choudhary"
				+ "\n+91 8556901211";
	}
	
	public static cultural_music_voiceofyv getInstance() {
		return new cultural_music_voiceofyv();
	}
}
	class cultural_music_yvunplugged extends EventDetails {
		
		public cultural_music_yvunplugged() {
			description = "Youth Vibe Unplugged -Western Group Song"
						+ "\nIt's not the instrument. It's how it translates from an artiste. I love the voice - it's the most perfect instrument ever heard. It's God given. -A.R. Rahman"
						+ "\nCan you do it fast enough? Then, Circuit Design Challenge is the place for you."
						+ "\n\nType of event: Group"
						+ "\nTeam Size: 06-12 (min 3 singers + 3 accompanists).";
			
			rules = "01. The group will be given 12 minutes to perform including setup and clearance. A warning indication shall be given 11 minutes after the start of your time. Time starts counting as soon as you step on the stage even if for arranging instrument."
                      + "\n02. At least three instruments must be used." 
                      + "\n03. There can be more than one song during performance."
                      + "\n04. One person cannot participate in more than one group in the same event."
                      + "\n05. Participants can perform either on Karaoke or live music. However, the teams have to arrange their own karaoke or instrument for live music. In case of karaoke please carry it in 2 Pen Drives only."
                      + "\n06. There should be no vulgarity and provoke in lyrics, any attempt of provoking the masses will not be tolerated and the participant shall be considered a defaulter."
                      + "\n07. Specific requirements regarding lights and smoke must be discussed with organizers in advance."
                      + "\n08. The organizers hold the rights to enforce changes in the matter depending upon the suitability to the university without prior notice."
                      + "\n09. All Decisions by the judges would be considered Final.";
			
			specification = "";
			
			criteria = "01. Rhythm and Beat."
                        + "\n02. Vocals & harmony."
                        + "\n03. Synchronization of the group."
                        + "\n04. Songs selection and Overall impact.";
			
			contact = "Mr. Rahul Choudhary"
					+ "\n+91 8556901211";
		}
		
		public static cultural_music_yvunplugged getInstance() {
			return new cultural_music_yvunplugged();
		}
	}
class cultural_theatre_atrangi extends EventDetails {
		
		public cultural_theatre_atrangi() {
			description = "ATRANGI The Standup Comedy"
                          + "\ncomedy is much more difficult than tragedy and a much better training, I think. It's much easier to make people cry than to make them laugh.- Vivien Leigh"
                          + "\nIf you think you have the talent to make people laugh, if you are the person who cracks craziest jokes, if you can make a fool of yourself to make others laugh, here is your chance."
                          + "\nType of event: Solo"
                          + "\nTeam Size: 01";
		
		rules = "01. Languages can be Hindi / English or Punjabi."
                + "\n02. A maximum of 6 minutes shall be given including setup and clearance. Teams exceeding time limit shall be penalised. A warning indication shall be given on the completion of 5 minutes. Your time starts counting as soon as you step on the stage, even though for arranging props." 
                + "\n03. The contestants are PROHIBITED to use vulgar words, acts and expressions, within their presentation."
                + "\n04. No external music and props are allowed." 
                + "\n05. Decisions of the judges and the organizers shall be final and binding to all teams.";
		
		specification = "";
		
		criteria = "01. Script"
                   + "\n02. Humour"
                   + "\n03. Delivery"
                   + "\n04. Body Language"
                   + "\n05. variation of voice and Audience Impact";
		
		contact = "Mr. Rahul Choudhary"
				+ "\n+91 8556901211";
		}
		
		public static cultural_theatre_atrangi getInstance() {
			return new cultural_theatre_atrangi();
		}
	}
class cultural_theatre_chaupal extends EventDetails {
	
	public cultural_theatre_chaupal() {
		description = "CHAUPAL The Street Play Competition"
                + "\n\"Theatre has an incredible capacity to move people to social change, to address issues, to inspire social revolution.\" - Eve Ensler"
                + "\nStreet plays or Nukad Nataks are the best theatrical way to bring about the social change as they inspire common people from streets."
                + "\n\"Aao sathiyo aye hum, fir ik natak laye hum,"
                + "\nNatak wahi purana hai, badalna humein zamana hai\""
                + "\nBadalna chahenge zamane ko? Here, we are providing you with the oppurtunity to deliver your message in your way."
                + "\nType of event: Group"
                + "\nTeam Size: 8 - 20 (including 3 accompanists)";
	
	rules = "01. The main language may be either Hindi or English or a combination of the two. Use of regional languages is allowed but must be reduced to a minimum."
          + "\n02. The script can be original or an adaptation."
          + "\n03. A maximum of 15 minutes shall be given including setup and clearance. Teams exceeding time limit shall be penalised. A warning indication shall be given on the completion of 14 minutes. Your time starts counting as soon as you step on the stage, even though for arranging props."
          + "\n04. Performance should be confined within the Nukkad area, as defined by the organizers."
          + "\n05. No technical support will be provided. Teams are allowed to use Dholak, Flute or any other music instrument of their choice, but usage of mikes, lights, or other electrical instruments is not allowed."
          + "\n06. No props will be provided. Teams may use basic props if they want, but excessive usage may lead to penalty at the discretion of Judges."
          + "\n07. Any form of obscenity may result in penalty at the discretion of Judges. It may range from point deduction to disqualification."
          + "\n08. Decisions of the judges and the organizers shall be final and binding to all teams.";
	
	specification = "";
	
	criteria = "01. Script"
             + "\n02. Theme"
             + "\n03. Social message (what you want to convey and how you presented the idea)"
             + "\n04. Team co-ordination"
             + "\n05. Crowd interaction and response"
             + "\n06. Direction and Acting";
	
	contact = "Mr. Rahul Choudhary"
			+ "\n+91 8556901211";
	}
	
	public static cultural_theatre_chaupal getInstance() {
		return new cultural_theatre_chaupal();
	}
}
class cultural_theatre_darbaar extends EventDetails {
	
	public cultural_theatre_darbaar() {
		description = "DARBAAR  The Stage Play Competition"
                      + "\nDepicting a heart touching story on stage is what we call a stage play."
                      + "\nDirk Benedict says, A stage play requires very different craft from a book fiction or otherwise and ditto from a screenplay."
                      + "\nArtists show the things that are already happened or supposed to happen off some day on stage."
                      + "\nIf you are a artist and have a great team of actors, come and participate and give your story a deserving stage."
                      + "\nType of event: Group"
                      + "\nTeam Size: 9 - 15 (including accompanists)";
		
		rules = "01. It can be in English, Hindi or Punjabi or a combination of all the three."
+ "\n02. The script can be original or an adaptation."
+ "\n03. A maximum of 35 minutes shall be given including setup and clearance. Teams exceeding time limit shall be penalised. A warning indication shall be given on the completion of 30 minutes. Your time starts counting as soon as you step on the stage, even though for arranging props."
+ "\n04. Each team can have maximum of 15 members."
+ "\n05. No props will be provided, however teams can use their own props."
+ "\n06. External music is allowed."
+ "\n07. The contestants are PROHIBITED to use vulgar words, acts and expressions, within their presentation.";
		
		specification = "";
		
		criteria = "01. Script"
             + "\n02. Theme"
             + "\n03. Social message (what you want to convey and how you presented the idea)"
             + "\n04. Team co-ordination"
             + "\n05. Crowd interaction and response"
             + "\n06. Direction and Acting";
		
		contact = "Mr. Rahul Choudhary"
				+ "\n+91 8556901211";
	}
	
	public static cultural_theatre_darbaar getInstance() {
		return new cultural_theatre_darbaar();
	}
}
class cultural_theatre_kalaajaurkal extends EventDetails {
	
	public cultural_theatre_kalaajaurkal() {
		description = "Kal, aaj aur kal: The Skit Competition"
                     + "\nA skit is a theatrical sketch, or you can say a comic dramatic performance. Bertolt Brecht Says, From the start it has been the theatre's business to entertain people It needs no other passport than fun."
                     + "\nIf you have a team that can entertain people, here is your chance to participate."
                     + "\nType of event: Group" 
                     + "\nTeam Size: 8- 15 (including accompanists)";
		
		rules = "01. Skit can be in Hindi or English or even a combination of the two. Use of regional languages is allowed but must be reduced to a minimum."
                   + "\n02. The script can be original or an adaptation." 
                   + "\n03. A maximum of 12 minutes shall be given including setup and clearance. Teams exceeding time limit shall be penalised. A warning indication shall be given on the completion of 11 minutes. Your time starts counting as soon as you step on the stage, even though for arranging props." 
                   + "\n04. No props will be provided, however teams can use their own props."
                   + "\n05. External music is allowed."
                   + "\n06. The contestants are PROHIBITED to use vulgar words, acts and expressions, within their presentation."
                   + "\n07. Decisions of the judges and the organizers shall be final and binding to all teams.";
		
		specification = "";
		
		criteria = "01. Script & Theme."
                  + "\n02. Delivery and Body Gestures."
                  + "\n03. Costume and Props."
                  + "\n04. Team co-ordination & Audience Impact."
                  + "\n05. Acting and Direction";
		
		contact = "Mr. Rahul Choudhary"
				+ "\n+91 8556901211";
	}
	
	public static cultural_theatre_kalaajaurkal getInstance() {
		return new cultural_theatre_kalaajaurkal();
	}
}
class cultural_theatre_nakalchee extends EventDetails {
	
	public cultural_theatre_nakalchee() {
		description = "NAKALCHEE  The Mimicry Competition"
                      + "\nMimicry, they argue, is also one of the means by which we infect each other with our emotions." 
                      + "\nIn other words, if I smile and you see me and smile in response even a microsmile that takes no more than several millisecondsâ€”itâ€™s not just you imitating or empathizing with me." 
                      + "\nIt may also be a way that I can pass on my happiness to you. - Malcolm Gladwell"
                      + "\nIf you have the ability to immitate people and bring smies on the faces of people, we are giving you a fair oppurtunity."
                      + "\nType of event: Solo"
                      + "\nTeam Size: 01";
		
		rules = "01. A maximum of 6 minutes shall be given including setup and clearance. Teams exceeding time limit shall be penalised. A warning indication shall be given on the completion of 5 minutes. Your time starts counting as soon as you step on the stage, even though for arranging props." 
               + "\n02. The contestants are PROHIBITED to use vulgar words, acts and expressions, within their presentation."
               + "\n03. No external music and props are allowed." 
               + "\n04. Decisions of the judges and the organizers shall be final and binding to all teams.";
		
		specification = "";
		
		criteria = "01. Script."
                  + "\n02. Theme."
                  + "\n03. Humour."
                  + "\n04. Delivery."
                  + "\n05. Body Language."
                  + "\n06. Voice Modulation and Audience Impact";
		
		contact = "Mr. Rahul Choudhary"
				+ "\n+91 8556901211";
			}
	
	public static cultural_theatre_nakalchee getInstance() {
		return new cultural_theatre_nakalchee();
	}
}
class cultural_litrary_lordofthewords extends EventDetails {
	
	public cultural_litrary_lordofthewords() {
		description = "One day I will find the right words, and they will be simple. Jack Kerouac"
                      + "\nIf you are a grammar Nazi, an ardent spell bee, and dislike your pals for their wrong usage of the language, then this event is for you."
                      + "\nPreserve the You instead of yew. My instead of Ma and Want to instead of Wannaa.";
		
		rules = "Round 1 Spell Bee:"
                + "\n01. The Spell bee will go in a knock-out procedure."
                + "\n02. In first phase, all contestants shall be asked 3 spellings; all contestants who shall answer at least 2 correct answers shall qualify to the next phase."
                + "\n03. In the Second phase, all contestants shall be asked 3 spellings; all contestants who shall answer at least 2 correct answers shall qualify to the next phase."
                + "\n04. The phases shall be over as soon as we get 16 participants for the next round of Lord of the words."
                + "\nRound 2 Vocabulary:"
                + "\n01. Some words will be given to the participant."
                + "\n02. The participant will be asked to give the meaning of word asked."
                + "\n03. If the participant asks for a sentence where the word is used, he can be provided with it (on the discretion of the judges) but he/she will get lesser points on that."
                + "\n04. Two participants with maximum cumulative score will be declared as the winner and runners-up.";
		
		specification = "";
		
		criteria = "";
		
		contact = "";
	}
	
	public static cultural_litrary_lordofthewords getInstance() {
		return new cultural_litrary_lordofthewords();
	}
}
class cultural_litrary_poetryrecitationcumwriting extends EventDetails {
	
	public cultural_litrary_poetryrecitationcumwriting() {
		description = "Poetry is not a turning loose of emotion, but an escape from emotion; it is not the expression of personality, but an escape from personality." 
                      + "\nBut, of course, only those who have personality and emotions know what it means to want to escape from these things.";
		
		rules = "01. It is an individual event."
                + "\n02. There are two rounds in this competition:"
                + "\na. Poetry Writing "
                + "\nb. Poetry Recitation"
                + "\n03. Poem can be presented either in English or in Hindi."
                + "\n04. Poetry Writing:"
                + "\na. In first round participant will be given 45 minutes to write the poem."
                + "\nb. 5 Topics will be given on the spot for poem writing and participant will have to choose one topic from them."
                + "\n05. Second Round:"
                + "\na. In second round each participant will have to recite their own poem which has written on the spot. Time Limit is 5 minutes for each participant. There will be a first warning bell after 3 minutes, second warning bell at 4 minutes 45 seconds, followed by disqualification at the final bell rung after the completion of 5 minutes. However, the participants may be stopped in between by the judges if they find anything which is against the policy."
                + "\n06. There will be different judgment for Hindi & English and different prizes for each language."
                + "\n07. All Decisions by the judges would be considered Final.";
		
		specification = "";
		
		criteria = "01. Delivery of poem."
                   + "\n02. voice-modulations."
                   + "\n03. content & theme."
                   + "\n04. rhymin."
                   + "\n05. expressions and overall impact.";
		
		contact = "";
	}
	
	public static cultural_litrary_poetryrecitationcumwriting getInstance() {
		return new cultural_litrary_poetryrecitationcumwriting();
	}
}
class cultural_litrary_robustspeaker extends EventDetails {
	
	public cultural_litrary_robustspeaker() {
		description = "Let thy speech be better than silence, or be silent. -Dionysius of Halicarnassus" 
                      + "\nSpeaking is an art which is known to all but there are very few people who can capture the real essence of public speaking."
                      + "\nIf you think your persona is enough to create the magic of words which tangles everyone in it, then this is your chance to become the robust speaker.";
		
		rules = "It is a solo event and the competition is divided into 2 rounds."
                 + "\nRound 1 Elocution:"
                 + "\n01. The topic for the speech will be given 48 hours prior to the event."
                 + "\n02. Speech has to be presented in English or in Hindi."
                 + "\n03. Time Limit is 5 minutes for each participant. However, the participants may be stopped in between by the judges if they find anything which is against the policy."
                 + "\n04. The decision of the judging panel will be final and binding by all the contestants."
                 + "\nRound 2 Extempore"
                 + "\n01. Topic shall be given on the spot."
                 + "\n02. Language permitted is either English or Hindi."
                 + "\n03. Participant has to speak on the topic for a minimum of 3 minutes and a maximum of 4 minutes."
                 + "\n04. The winner will be decided by cumulative marks of both the rounds.";
		
		specification = "";
		
		criteria = "01. Content."
                  + "\n02. Delivery."
                  + "\n03. Points Offered."
                  + "\n04. Time Keeping."
                  + "\n05. Overall Impression.";
		
		contact = "";
	}
	
	public static cultural_litrary_robustspeaker getInstance() {
		return new cultural_litrary_robustspeaker();
	}
}
class cultural_litrary_thedebatechampionship extends EventDetails {
	
	public cultural_litrary_thedebatechampionship() {
		description = "Those who cannot understand how to put their thoughts on ice should not enter into the heat of debate. - Friedrich Nietzsche"
                     + "\nDebate Championship gives you the platform to showcase your potential and zeal to drive away the much awaited applaud and appreciation."
                     + "\nIf you think you have the spark to mesmerize everyone with your thoughts then get ready to crack all the rounds and become the ultimate debate champion.";
		
		rules = "01. It is a team event- each team comprising of two speakers."
               + "\n02. The debate can be either in English or in Hindi."
               + "\n03. There will be 3 rounds in the competition and the team qualifying through all rounds and getting maximum points in the final round shall win."
               + "\n\nRound 1"
               + "\n01. Each team will be given 10 minutes to speak - 5 minutes to each speaker."
               + "\n02. First speaker has to speak for the motion and the other against."
               + "\n03. The topic will be given 48 hours prior to the day of competition."
               + "\n\nRound 2" 
               + "\n01. 8 teams will qualify for round 2"
               + "\n02. One member from each team will be chosen and paired up with a member of other team on the spot."
               + "\n03. They will be given a topic on the spot and then toss will decide the one going for the motion and the one going against."
               + "\n04. Total 10 minutes will be given to prepare."
               + "\n05. Speaker 1 will speak for 2 minutes, followed by speaker 2 who will speak for 4 minutes and then the first speaker will speak for 2 minutes."
               + "\nAfter this speaker 2 will ask question to speaker 1 which shall be answered in one minute and vice versa."
               + "\n\nRound 3"
               + "\n01. 4 teams will qualify for round 3."
               + "\n02. 24 hours prior to round 3, two pairs of teams will be made A vs. B and C vs. D."
               + "\n03. Both the pairs will be given a topic and toss will decide the one going for or against." 
               + "\n04. The debate will take place in 2 phases:" 
               + "\na) Team A vs. B,"
               + "\nb) Team C vs. D. "
               + "\n05. Each phase will have the rules as:-"
               + "\na) Both the speakers of each team will either go for the motion or against the motion." 
               + "\nb) Speaker 1 from both the teams will speak first and then speaker 2 from each team will speak for 2 minutes each."
               + "\nc) After both teams have spoken, the house will resort to open debating and a session of question answer will begin."
               + "\nd) A maximum of 3 questions can be asked to team A which can be answered by the team in 2 minutes each. Then"
               + "\ne) 3 questions can be asked to team B."
               + "\n06. The same rules will apply to Team C vs. D debate." 
               + "\nNote: There will be list of 5 topics which will be given 48 hours prior to the day of Concoction and the topics which will be given in round 3 will be from those 5 topics only." 
               + "\nThis is done to make sure that the teams do extensive research on these topics beforehand.";
		
		specification = "";
		
		criteria = "01. Content"
                   + "\n02. Delivery"
                   + "\n03. Points Offered"
                   + "\n04. Teamwork"
                   + "\n05. Time Keeping"
                   + "\n06. Overall Impression";
		
		contact = "";
	}
	
	public static cultural_litrary_thedebatechampionship getInstance() {
		return new cultural_litrary_thedebatechampionship();
	}
}
class cultural_litrary_turncoat extends EventDetails {
	
	public cultural_litrary_turncoat() {
		description = "The smart way to keep people passive and obedient is to strictly limit the spectrum of acceptable opinion, but allow very lively debate within that spectrum....";
		
		rules = "01. Topic shall be given on the spot."
+ "\n02. Language permitted is either English or Hindi." 
+ "\n03. Participant has to speak for the topic for one minute followed by against the motion in the next minute."
+ "\n04. The winner will be decided by cumulative marks of both the rounds." 
+ "\n05. Two participants with maximum cumulative score (of all three rounds) will be declared the winner and runners-up.";
		
		specification = "";
		
		criteria = "01. Two participants with maximum cumulative score (of all three rounds) will be declared the winner and runners-up.";
		contact = "";
	}
	
	public static cultural_litrary_turncoat getInstance() {
		return new cultural_litrary_turncoat();
	}
}
class cultural_quizing_bizwiz extends EventDetails {
	
	public cultural_quizing_bizwiz() {
		description = "Biz Wiz the Business Quiz"
                      + "\n\"As an impeccable Leonardo deCaprio said, No one knows the future of the stock market."
                      + "\nAgreed, master! But you ought to know, we do know the past and the nuances of the world of business."
                      + "\nCome and compete in what promises to be a jargon free, extreme trivia free, Amul ads free and Google Doodle free quiz."
                      + "\nWelcome to the world of pure quizzing.\"";
		
		rules = "01. Teams of three will have to answer the written elimination."
                + "\n02. Any number of teams from a college can participate."
                + "\n03. The top six teams, selected on the basis of their scores in the elimination, will compete in the finals."
                + "\n04. Questions shall be focussed on the fields of business, economics and related areas."
                + "\n05. Details of marking/rounds to be declared at the time of the finals.";
		
		specification = "";
		
		criteria = "";
		
		contact = "";
	}
	
	public static cultural_quizing_bizwiz getInstance() {
		return new cultural_quizing_bizwiz();
	}
}
class cultural_quizing_entertainmentquiz extends EventDetails {
	
	public cultural_quizing_entertainmentquiz() {
		description = "Brief Introduction: Entertainment, Entertainment, Entertainment."
                      + "\nNo no, this ain't a quiz on Silk Smita or even Vidya Balan, this is the Hollywood-Bollywood Quiz."
                      + "\nMovies, sitcoms, music, literature, sports, gaming, cartoons, comics, anime and more! If you're interested in any of this, then you'll enjoy Entertainment Quiz."
                      + "\nWith innovative rounds and crazy questions, this event is not restricted to only those with a penchant for quizzing."
                      + "\nCome and find out how much you really know about the things you enjoy the most.";
		
		rules = "01. Teams of three will have to answer the written elimination." 
               + "\n02. Any number of teams from a college can participate." 
               + "\n03. The top six teams, selected on the basis of their scores in the elimination, will compete in the finals."
               + "\n04. The questions cover fields of interest to general public with a hint of entertainment to it."
               + "\n05. Details of marking/rounds to be declared at the time of the finals.";
		
		specification = "";
		
		criteria = "";
		
		contact = "";
	}
	
	public static cultural_quizing_entertainmentquiz getInstance() {
		return new cultural_quizing_entertainmentquiz();
	}
}
class cultural_quizing_sportica extends EventDetails {
	
	public cultural_quizing_sportica() {
		description = "Sportica the Sports Quiz"
                      + "\nThey call you a nerd, a geek! Time to show them ground in their own sphere of influence." 
                      + "\nThe sports quiz, an open invitation to all sport nicks, for the show of not physical but mental battle (though it could get physical if a tie break persists!).";
		
		rules = "01. Teams of three will have to answer the written elimination."
               + "\n02. Any number of teams from a college can participate."
               + "\n03. The top six teams, selected on the basis of their scores in the elimination, will compete in the finals."
               + "\n04. Questions shall be based on sports and games played in India and abroad and their happenings in recent times and past."
               + "\n05. Details of marking/rounds to be declared at the time of the finals.";
		
		specification = "";
		
		criteria = "";
		
		contact = "";
	}
	
	public static cultural_quizing_sportica getInstance() {
		return new cultural_quizing_sportica();
	}
}
class cultural_quizing_thewoodquiz extends EventDetails {
	
	public cultural_quizing_thewoodquiz() {
		description = "Brief Introduction: Are you a movie buff? Do you think you know all about movies? Then think again! This quiz sets your wheels in motion with our scintillating wood quiz that both entertaining and mind-boggling."
                      + "\nThe Movie Quiz will be a mixed bag of trivia, connects and questions you can work out, covering all genres of the world of cinema.";
		
		rules = "01. Teams of three will have to answer the written elimination."
                  + "\n02. Any number of teams from a college can participate."
                  + "\n03. The top six teams, selected on the basis of their scores in the elimination, will compete in the finals."
                  + "\n04. It will be an audio visual quiz based on movies and critically acclaimed Indian movies (all regional films included)."
                  + "\n05. Details of marking/rounds to be declared at the time of the finals.";
		
		specification = "";
		
		criteria = "";
		
		contact = "";
	}
	
	public static cultural_quizing_thewoodquiz getInstance() {
		return new cultural_quizing_thewoodquiz();
	}
}
class cultural_quizing_yvgenralquiz extends EventDetails {
	
	public cultural_quizing_yvgenralquiz() {
		description = "The biggest quiz in Youth vibe, this is the ultimate battle for quizzing supremacy, the right to be enviously abused for a year and a lot of money."
                      + "\nCharles Darwin got it all wrong in his \"Theory of Evolution\", the Youth vibe quiz is the actual survival of the fittest." 
                      + "\nWe could say this year's Youth vibe promises to be a lot bigger and better and all that drivel, but that's not really what we want to tell you."
                      + "\nWhat we want to tell you is, come for it. If you've been once, you don't need to read this. If you haven't, give it a shot, and you won't forget it.";
		
		rules = "01. Teams of three will have to answer the written elimination."
                      + "\n02. Any number of teams from a college can participate."
                      + "\n03. The top six teams, selected on the basis of their scores in the elimination, will compete in the finals."
                      + "\n04. Any topic, literally any, is a part of the domain for the questions."
                      + "\n05. Details of marking/rounds to be declared at the time of the finals.";
		
		specification = "";
		
		criteria = "";
		
		contact = "";
	}
	
	public static cultural_quizing_yvgenralquiz getInstance() {
		return new cultural_quizing_yvgenralquiz();
	}
}
class cultural_finearts_chalktalk extends EventDetails {
	
	public cultural_finearts_chalktalk() {
		description = "CHALK TALK-The charcoal sketching competition"
                      + "\nEvery portrait that is painted with feeling is a portrait of the artist, not of sitter."
                      + "\nINTRODUCTION:"
                      + "\nA portrait is a painting or any other artistic representation of a person which intends to display the likeness, personality or even mood of the person.";
		
		rules = "01. The participants shall be given 2 hours to complete their painting." 
                + "\n02. Theme of the painting shall be given on the spot."
                + "\n03. The organizers shall provide all the required materials & no use of any other personal materials will be allowed."
                + "\n04. Use of mobile phones or any electrical gadgets is strictly prohibited.";
		
		specification = "";
		
		criteria = "01. Shading," 
                  + "\n02. Clarity of work & line of strokes";
		
		contact = "";
	}
	
	public static cultural_finearts_chalktalk getInstance() {
		return new cultural_finearts_chalktalk();
	}
}
class cultural_finearts_dawn2dusk extends EventDetails {
	
	public cultural_finearts_dawn2dusk() {
		description = "DAWN 2 DUSK-The ABSTRACT PAINTING"
                     + "\nPainting is just another way of keeping a diary."
                     + "\nPaint your heart out as this event lets you pour the creativity you have always wanted to showcase in your paintings." 
                     + "\nINTRODUCTION:"
                     + "\nAbstract art uses a visual language of form, color and line to create a composition which exists with a degree of independence from visual references in the world.";
		
		rules = "01. You shall be given 2 hours to complete your painting." 
                 + "\n02. Theme of the painting shall be given on the spot."
                 + "\n03. The organizers shall provide all the required materials & no use of any other personal materials will be allowed."
                 + "\n04. Use of mobile phones or any electrical gadgets is strictly prohibited.";
		
		specification = "";
		
		criteria = "01. The mixing of colors & impression of work";
					 
		
		contact = "";
	}
	
	public static cultural_finearts_dawn2dusk getInstance() {
		return new cultural_finearts_dawn2dusk();
	}
}
class cultural_finearts_gossipogirl extends EventDetails {
	
	public cultural_finearts_gossipogirl() {
		description = "Gossip-o-Girl"
                      + "\nThe Paper Dress Designing"
                      + "\nA dress should be two things, classy and fashionable."
                      + "\nINTRODUCTION:"
                      + "\nHave you ever dreamt of designing a dress? Here, we are giving you a platform to make your dreams come true, but the twist is, you will be provided paper and not clothes. ";
		
		rules = "01. You shall be given 2 hours to complete your design." 
                 + "\n02. Theme of the design shall be given on the spot."
                 + "\n03. The organizers shall provide all the required materials & no use of any other personal materials will be allowed."
                 + "\n04. Use of mobile phones or any electrical gadgets are strictly prohibited.";
		
		specification = "";
		
		criteria = "01. Efficient usage of paper and overall clarity with the theme";
		
		contact = "";
	}
	
	public static cultural_finearts_gossipogirl getInstance() {
		return new cultural_finearts_gossipogirl();
	}
}
class cultural_finearts_hastkala extends EventDetails {
	
	public cultural_finearts_hastkala() {
		description = "Round 1 : Stick to Stick"
+ "\nINTRODUCTION"
+ "\nPop-Sickle Sticks Model Making Competition; here you need to make a model of ice-cream sticks, which will be given to you on the spot."
+ "\nRound 2 : Clay Modeling"
+ "\nINRTODUCTION:"
+ "\nClay Modeling Competition; here every participant would be given clay/plasticize to make a model on the spot in the given time limit."
+ "\nRound 3 : Mix Media (Creativity)"
+ "\nINTRODUCTION:"
+ "\nThe event is Mix Media Works; A creative drawing competition where you can use a maximum of three to five different mediums/objects to enhance look of your creativity";
		
		rules = "For all Rounds :" 
+ "\n01. Topic: On spot theme based competition."
+ "\n02. The organizers shall provide all the required materials & no use of any other personal materials will be allowed."
+ "\n03. Use of mobile phones or any electrical gadgets are strictly prohibited.";
		
		specification = "";
		
		criteria = "Round 1 :" 
+ "\n01. The judging criteria will be the innovative arrangement of the sticks and overall quality of the presentation."
+ "\nRound 2 & 3 :"
+ "\n01. Creativity of model."
+ "\n02. Relevance to the topic and overall impression";
		
		contact = "";
	}
	
	public static cultural_finearts_hastkala getInstance() {
		return new cultural_finearts_hastkala();
	}
}
class cultural_finearts_heena extends EventDetails {
	
	public cultural_finearts_heena() {
		description = "Heena-The Mehendi Designing Competition"
+ "\nMenhndi adorns our hands and brings colors to our lives."
+ "\nINTRODUCTION:"
+ "\nMehendi design is a very popular hand art. It has been in practice in the Indian subcontinent from a very long time, making it an inseparable part of the rituals & functions.";
		
		rules = "01. You shall be given 2 hours to complete your design." 
+ "\n02. Theme of the design shall be given on the spot."
+ "\n03. The organizers shall provide all the required materials & no use of any other personal materials will be allowed."
+ "\n04. Use of mobile phones or any electrical gadgets are strictly prohibited."
+ "\n05. Two style of Mehandi design is must i.e. Arabic style design on one hand: which uses bigger floral designs and don't cover the entire hand & Traditional design on 2nd hand which is a design covering the whole palm."
+ "\n06. Designing should be done on both the hands.";
		
		specification = "";
		
		criteria = "DescriptionRules & RegulationJudging Criteria"
+ "\n01. Neatness in presentation,"
+ "\n02. Theme relevance and overall impression of the mehendi design";
		
		contact = "";
	}
	
	public static cultural_finearts_heena getInstance() {
		return new cultural_finearts_heena();
	}
}
class cultural_finearts_imagination extends EventDetails {
	
	public cultural_finearts_imagination() {
		description = "IMAGINATION-The Story Telling Painting"
+ "\n The job of the artist is to always deepen the mystry."
+ "\nDo you like to express through paintings rather than words? This competition is all about letting your painting speak for itself."
+ "\nINTRODUCTION:"
+ "\nIn this event the painting/sketching should be in such a way that it should be able to depict a story. For the mode of painting one can use Water/Poster/oil colors and for the second mode coloring sketches/wax color/pencil colors.";
		
		rules = "01. You shall be given 2 hours to complete your painting." 
+ "\n02. Theme of the painting shall be given on the spot."
+ "\n03. The organizers shall provide all the required materials & no use of any other personal materials will be allowed."
+ "\n04. Use of mobile phones or any electrical gadgets are strictly prohibited.";
		
		specification = "";
		
		criteria = "01. Shading," 
+ "\n02. color mixing," 
+ "\n03. clarity,"
+ "\n04. relevance of the topic would matter";
		
		contact = "";
	}
	
	public static cultural_finearts_imagination getInstance() {
		return new cultural_finearts_imagination();
	}
}
class cultural_finearts_kalaamanthan extends EventDetails {
	
	public cultural_finearts_kalaamanthan() {
		description = "Round 1 : Rangoli"
+ "\nHave you always been making Rangoli during the various occasions at home or at your relative? Here is your chance to use that talent for fame and glory."
+ "\nINTRODUCTION:"
+ "\nRANGOLI is a folk art from India. Rangoli is generally practiced as means of decoration. The design varies reflecting the traditions, folklore and practices which are customary to that part of area."
+ "\n\nRound 2 : Cartooning"
+ "\nIt is the very nature of fantasy and fable. Cartoon making provide us with a message whose verbal skill or incongruity has the power to evoke laughter."
+ "\nINTRODUCTION:"
+ "\nIn this event, the participant is required to make cartoons using their creativity and imagination."
+ "\n\nRound 3: On the spot painting"
+ "\nINTRODUCTION:"
+ "\nIt is an On the Spot Painting event, in which a virtual condition will be provided on the spotâ€¦";
		
		rules = "For All Rounds"
+ "\n01. Topic: On spot theme based competition."
+ "\n02. The organizers shall provide all the required materials & no use of any other personal materials will be allowed."
+ "\n03. Use of mobile phones or any electrical gadgets are strictly prohibited.";
		
		specification = "";
		
		criteria = "Round 1" 
+ "\n01. The judging criteria will be the innovative patterns," 
+ "\n02. Compulsory 3D effect along with neatness."
+ "\n\nRound 2"
+ "\n01. The judging criteria will be the creation of the characters and relevance to the theme."
+ "\n\nRound 3" 
+ "\n01. The judgment shall be based on the relevancy of theme and neatness & impression of work.";
		
		contact = "";
	}
	
	public static cultural_finearts_kalaamanthan getInstance() {
		return new cultural_finearts_kalaamanthan();
	}
}
class cultural_finearts_laurel extends EventDetails {
	
	public cultural_finearts_laurel() {
		description = "Laurel-The Face Painting"
+ "\n\nINTRODUCTION:"
+ "\nFace painting is a form of body art. Unlike tattoo and other forms of body art, face painting is temporary, painted onto the human face skin. Face painting is the process of applying a design to the face using brushes and paints suitable for skin.";
		
		rules = "\n01. You shall be given 2 hours to complete your painting." 
+ "\n02. Theme of the painting shall be given on the spot."
+ "\n03. The organizers shall provide all the required materials & no use of any other personal materials will be allowed."
+ "\n04. Use of mobile phones or any electrical gadgets are strictly prohibited.";
		
		specification = "";
		
		criteria = "01. Uniqueness," 
+ "\n02. effective coloring,"
+ "\n03. overall impact and neatness";
		contact = "";
	}
	
	public static cultural_finearts_laurel getInstance() {
		return new cultural_finearts_laurel();
	}
}
class cultural_finearts_thedaffodils extends EventDetails {
	
	public cultural_finearts_thedaffodils() {
		description = "\"Round 1 : \"Quell(Quelling art)"
+ "\nINTRODUCTION:"
+ "\nThe wonder of paper craft quelling paper art lets you make designs by using quelling paper."
+ "\n\nRound 2 : Greetings"
+ "\nINTRODUCTION:"
+ "\nIt's a greeting card making competition in which one can use his/her WINGS of talent/skills and using that wings can fly high in the sky, to GREET his/her dear and near ones."
+ "\n\nRound 3 : Ornamentation"
+ "\nINTRODUCTION:"
+ "\nPaper Ornament Making Competition: The event is all about paper crafting in which you need to design jewellery using the stuffs providedâ€¦";
		
		rules = "For all Rounds :"
+ "\n01. Topic: On spot theme based competition."
+ "\n02. The organizers shall provide all the required materials & no use of any other personal materials will be allowed."
+ "\n03. Use of mobile phones or any electrical gadgets are strictly prohibited.";
		
		specification = "";
		
		criteria = "Round 1 :"
+ "\n01. Complexity." 
+ "\n02. clarity and overall impression of the quelling art"
+ "\n\nRound 2 :"
+ "\n01. Clarity of expression."
+ "\n02. overall neatness and relevance to the theme will be considered."
+ "\n\nRound 3 :" 
+ "\n01. The work will be appreciable if the jewellery made seems to be real doing focus on clarity and neatness of your work.";
		contact = "";
	}
	
	public static cultural_finearts_thedaffodils getInstance() {
		return new cultural_finearts_thedaffodils();
	}
}
class cultural_finearts_thepermanentcrayons extends EventDetails {
	
	public cultural_finearts_thepermanentcrayons() {
		description = "The Permanent Crayons Tattoo making competition"
+ "\n \"The body is a journal and the tattoo it's story\""
+ "\n\nTattoos always tell a story either of the one who gets it made or the one who makes it."
+ "\nINTRODUCTION:"
+ "\nTattoo making is an art form on the skin to make it more alluring and attractive. So if you have the talent of this art, then this is your chance to be the trendsetter. ";
		
		rules = "01. You shall be given 2 hours to complete your work." 
+ "\n02. Theme of the tattoo shall be given on the spot."
+ "\n03. The organizers shall provide all the required materials & no use of any other personal materials will be allowed."
+ "\n04. Use of mobile phones or any electrical gadgets are strictly prohibited."
+ "\n05. Avoid making any banned symbols or mark along with the tattoo otherwise it shall lead to disqualification";
		
		specification = "";
		
		criteria = "01. Complexity of the tattoo and clarity of expression and theme relevance";
		contact = "";
	}
	
	public static cultural_finearts_thepermanentcrayons getInstance() {
		return new cultural_finearts_thepermanentcrayons();
	}
}
class cultural_finearts_vibgyor extends EventDetails {
	
	public cultural_finearts_vibgyor() {
		description = "VIBGYOR-The color mixing competition"
+ "\n Painting is a self-discovery every artist paint who he is."
+ "\nDo you think you can use the seven colors of the rainbow to your advantage and create a master-piece? If yes, then this competition is for you."
+ "\n\nINTRODUCTION:"
+ "\nThis event is basically based on 7 colors. Using the 7 basic colors you are required to make a painting based on a theme that shall be given on the spot.";
		
		rules = "01. You shall be given 2 hours to complete your painting."
+ "\n02. Theme of the painting shall be given on the spot."
+ "\n03. The organizers shall provide all the required materials & no use of any other personal materials will be allowed."
+ "\n04. Use of mobile phones or any electrical gadgets are strictly prohibited.";
		
		specification = "";
		
		criteria = "01. Uniqueness," 
+ "\n02. effective coloring," 
+ "\n03. overall impact," 
+ "\n04. neatness & mixing of colors";
		contact = "";
	}
	
	public static cultural_finearts_vibgyor getInstance() {
		return new cultural_finearts_vibgyor();
	}
}
class cultural_lifestyle_fashionshow extends EventDetails {
	
	public cultural_lifestyle_fashionshow() {
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
	
	public static cultural_lifestyle_fashionshow getInstance() {
		return new cultural_lifestyle_fashionshow();
	}
}
class cultural_lifestyle_yvmodelhunt extends EventDetails {
	
	public cultural_lifestyle_yvmodelhunt() {
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
	
	public static cultural_lifestyle_yvmodelhunt getInstance() {
		return new cultural_lifestyle_yvmodelhunt();
	}
}
class cultural_photographyandfilmproduction_directorscut extends EventDetails {
	
	public cultural_photographyandfilmproduction_directorscut() {
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
	
	public static cultural_photographyandfilmproduction_directorscut getInstance() {
		return new cultural_photographyandfilmproduction_directorscut();
	}
}
class cultural_photographyandfilmproduction_perfectpicture extends EventDetails {
	
	public cultural_photographyandfilmproduction_perfectpicture() {
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
	
	public static cultural_photographyandfilmproduction_perfectpicture getInstance() {
		return new cultural_photographyandfilmproduction_perfectpicture();
	}
}
class cultural_photographyandfilmproduction_realtoreel extends EventDetails {
	
	public cultural_photographyandfilmproduction_realtoreel() {
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
	
	public static cultural_photographyandfilmproduction_realtoreel getInstance() {
		return new cultural_photographyandfilmproduction_realtoreel();
	}
}
class cultural_dance_thedancingsoul extends EventDetails {
	
	public cultural_dance_thedancingsoul() {
		description = "The Dancing Soul The Western/ free style Solo Dance competition"
+ "\nMost people can dance, or at least crack a move or two at parties. But being a dancer and making up your own moves is truly a skill."
+ "\nParticipants need to display their dancing soul which touches every soul watching them! Participants can perform any western dance form such as hip-hop, break dance, jump style, jazz or contemporary."
+ "\nType of event: Solo"
+ "\nTeam Size: 1";	
		
		specification = "";
		rules ="01. A maximum of 6 minutes performance time is provided including setup and clearance. A warning indication shall be given on the completion of 5 minutes. Your time starts counting as soon as you step on the stage, even though for arranging props."
+ "\n02. An audition shall be conducted. The mode of audition is mentioned in the general guidelines."
+ "\n03. Participants are required to get their tracks in 2 pen drives (carrying tracks in mobile phones, laptops and any other electronic gadgets shall not be permitted). The track should be named by the name of the contestant."
+ "\n04. Vulgarity or provocative acts will not be tolerated."
+ "\n05. Participants have to bring their props and are responsible for arrangement and clearance of props within the given time. The organizers must not be asked for any help for the same."
+ "\n06. The organizers hold the right to interrupt or drop the performance any time regardless of the time limit on the basis of indecent track, dance steps, costumes, misuse of props, etc."
+ "\n07. In any case, decision of the judges will be considered final and binding.";
		
		criteria = "01. Theme & Presentation"
+ "\n02. Versatility"
+ "\n03. Stage utilization and Costume";
		
		contact = "Mr. Lalit Sehgal"
                   + "\n+91 9041340412";
	}
	
	public static cultural_dance_thedancingsoul getInstance() {
		return new cultural_dance_thedancingsoul();
	}
}
class cultural_dance_footloose extends EventDetails {
	
	public cultural_dance_footloose() {
		description = "Nobody cares if you dance oddly, just get up and dance. Great dancers are great because of their passion."
+ "\nIf you have that perfect team embedded with this passion, then the much anticipated chance of your lifetime is here. Participants may perform any western dance forms such as B-boying, hiphop, break dance, jump style, jazz, ballet etc."
+ "\nType of event: Group"
+ "\nTeam Size: 08-16";	
		
		specification = "";
		rules ="01. A maximum of 9 minutes performance time is provided including setup and clearance. A warning indication shall be given on the completion of 8 minutes. Your time starts counting as soon as you step on the stage, even though for arranging props."
+ "\n02. An audition shall be conducted. The mode of audition is mentioned in the general guidelines."
+ "\n03. Participants are required to get their tracks in 2 pen drives (carrying tracks in mobile phones, laptops and any other electronic gadgets shall not be permitted). The track should be named by the name of the contestant."
+ "\n04. Vulgarity or provocative acts will not be tolerated."
+ "\n05. Participants have to bring their props and are responsible for arrangement and clearance of props within the given time. The organizers must not be asked for any help for the same."
+ "\n06. The organizers hold the right to interrupt or drop your performance any time regardless of the time limit on the basis of indecent track, dance steps, costumes, misuse of props, etc. "
+ "\n07. In any case, decision of the judges will be considered final and binding.";
		
		criteria = "01. Choreography"
+ "\n02. Expressions"
+ "\n03. Coordination"
+ "\n04. Costumes"
+ "\n05. Song Selection"
+ "\n06. Stage Utilization"
+ "\n08. Overall Impact";
		
		contact = "Mr. Lalit Sehgal"
                   + "\n+91 9041340412";
	}
	
	public static cultural_dance_footloose getInstance() {
		return new cultural_dance_footloose();
	}
}
class cultural_dance_thedancingmessangers extends EventDetails {
	
	public cultural_dance_thedancingmessangers() {
		description = "THE DANCING MESSANGERS Choreography Competition"
+ "\nWhat do you do, when you know words will never be enough to express the emotions or the message you want to convey?"
+ "\nDance, yes dance and only dance!"
+ "\nDance has a way of speaking through moments of bringing up emotions and eventually pouring it out in the open. Here we need teams that can express the entire message through their expressions, gestures, hand movements and footwork, in short, through choreography. Each team has to present a theme/story through dance. "
+ "\nAny dance form is permitted. "
+ "\nType of event: Group"
+ "\nTeam Size: 12-24";		
		
		specification = "";
		
		rules ="01. It is a group event and each team can consist of minimum 12 and maximum 24 members."
+ "\n02. A maximum of 14 minutes performance time is provided including setup and clearance. A warning indication shall be given on the completion of 13 minutes. Your time starts counting as soon as you step on the stage, even though for arranging props."
+ "\n03. Auditions: An audition shall be conducted. The mode of audition is mentioned in the general guidelines. "
+ "\n04. Participants are required to get their tracks in 2 pen drives (carrying tracks in mobile phones, laptops and any other electronic gadgets shall not be permitted). The track should be named by the name of the contestant."
+ "\n05. Vulgarity or provocative acts will not be tolerated."
+ "\n06. Participants have to bring their props and are responsible for arrangement and clearance of props within the given time. The organizers must not be asked for any help for the same."
+ "\n07. The organizers hold the right to interrupt or drop your performance any time, regardless of the time limit, on the basis of indecent track, dance steps, costumes, misuse of props, etc. "
+ "\n08. In any case, decision of the judges will be considered final and binding.";
		
		criteria = "01. Choreography"
+ "\n02. Energy"
+ "\n03. Synchronization"
+ "\n04. Stage utilization"
+ "\n05. Costumes"
+ "\n06. Overall impact"
+ "\n07. Song selection";
		
		contact = "Mr. Lalit Sehgal"
                   + "\n+91 9041340412";
	}
	
	public static cultural_dance_thedancingmessangers getInstance() {
		return new cultural_dance_thedancingmessangers();
	}
}
class cultural_dance_Justduet extends EventDetails {
	
	public cultural_dance_Justduet() {
		description = "JUST DU-ET: The Duet Dance"
+ "\nDancing is just a conversation between two people"
+ "\nIf you think you are a duet dancing team, who can entice the onlookers with their co-ordination and compatibility while dancing, then hang on to your chemistry because it could lead you to this grand title. Participants can perform any dance form of their choice."
+ "\nType of event: Group"
+ "\nTeam Size: 2 (Both Male, both Female, Male (Female) ";	
		
		specification = "";
		
		rules ="01. A maximum of 6 minutes performance time is provided including setup and clearance. A warning indication shall be given on the completion of 5 minutes. Your time starts counting as soon as you step on the stage, even though for arranging props."
+ "\n02. Auditions: An audition shall be conducted. The mode of audition is mentioned in the general guidelines."
+ "\n03. Participants are required to get their tracks in 2 pen drives (carrying tracks in mobile phones, laptops and any other electronic gadgets shall not be permitted). The track should be named by the name of the contestant."
+ "\n04. Vulgarity or provocative acts will not be tolerated."
+ "\n05. Participants have to bring their props and are responsible for arrangement and clearance of props within the given time. The organizers must not be asked for any help for the same."
+ "\n06. The organizers hold the right to interrupt or drop your performance any time, regardless of the time limit, on the basis of indecent track, dance steps, costumes, misuse of props, etc."
+ "\n07. In any case, decision of the judges will be considered final and binding.";
		
		criteria = "01. Choreography"
+ "\n02. Concept"
+ "\n03. Synchronization"
+ "\n04. Stage utilization"
+ "\n05. Costumes"
+ "\n06. Song selection and Overall impact";
		
		contact = "Mr. Lalit Sehgal"
                   + "\n+91 9041340412";
	}
	
	public static cultural_dance_Justduet getInstance() {
		return new cultural_dance_Justduet();
	}
}
class cultural_dance_downthestreet extends EventDetails {
	
	public cultural_dance_downthestreet() {
		description = "DOWN THE STREET The Street Dance"
+ "\nIf you are bored, or you are feelings weighed down by the pressure of life, just DANCE with passion and watch everything fall in place."
+ "\nStreet dance is a blend of that passion which is interesting and refreshing. Street dancers are proactive and best at engrossing the crowd. Street dance should be a mix of styles Hip Hop, Popping, Locking, Breaking etc and routines should not be dominated by any one of these styles."
+ "\nDancers are not restricted from performing any move or style but they must be aware that it is their own responsibility to ensure that they do not perform dangerous moves that could injure themselves or others."
+ "\n\nType of event: Group"
+ "\nTeam Size: 05 - 08";
		
		specification = "";
		
		rules ="01. There shall be three rounds in the competition:"
+ "\na. Performance"
+ "\nb. Battle it out ( One team v/s another)"
+ "\nc. The final battle"
+ "\n02. "
+ "\na.Round 1: A maximum of 5 minutes group performance are required."
+ "\nb.Round 2: In this round, one team shall battle with another team in a random sequence. The battle shall be of 6 minutes."
+ "\nc.Round 3: In this top 3-4 best teams shall battle for the title. The battle shall be of 10 minutes. "
+ "\n03. Auditions: An audition shall be conducted. The mode of audition is mentioned in the general guidelines. "
+ "\n04. Participants are required to get their tracks in 2 pen drives (carrying tracks in mobile phones, laptops and any other electronic gadgets shall not be permitted). The track should be named by the name of the contestant."
+ "\n05. Vulgarity or provocative acts will not be tolerated."
+ "\n06. Participants have to bring their props and are responsible for arrangement and clearance of props within the given time. The organizers must not be asked for any help for the same."
+ "\n07. The organizers hold the right to interrupt or drop your performance any time, regardless of the time limit, on the basis of indecent track, dance steps, costumes, misuse of props, etc. "
+ "\n08. In any case, decision of the judges will be considered final and binding.";
		
		criteria = "01. Choreography"
+ "\n02. Energy"
+ "\n03. Synchronization"
+ "\n04. Stage utilization"
+ "\n05. Costumes"
+ "\n06. Versatility and Overall impact ";
		
		contact = "Mr. Lalit Sehgal"
                   + "\n+91 9041340412";
	}
	
	public static cultural_dance_downthestreet getInstance() {
		return new cultural_dance_downthestreet();
	}
}
class cultural_dance_mashitup extends EventDetails {
	
	public cultural_dance_mashitup() {
		description = "MASH IT UP: The Indo-Western Dance Competition"
+ "\nSome people learn to dance, others are born to!"
+ "\nIt’s time to set your soul free to the music in you? Get onto the stage with the mash up performance that is a fusion of Indian and Western dance forms."
+ "\nIn this, one of the two dancers is required to perform any Indian dance form (Classical, Semi Classical and Regional) while the other has to perform any Non-Indian Dance Form including western dance forms (such as Hip Hop, Contemporary, BBoying, etc.)"
+ "\n\nType of event: Group"
+ "\nTeam Size: 02 (Both Male, both Female, Male (Female)";	
		
		specification = "";
		
		rules ="01. A maximum of 6 minutes performance time is provided including setup and clearance. A warning indication shall be given on the completion of 5 minutes. Your time starts counting as soon as you step on the stage, even though for arranging props. "
+ "\n02. Auditions: An audition shall be conducted. The mode of audition is mentioned in the general guidelines. "
+ "\n03. Participants are required to get their tracks in 2 pen drives (carrying tracks in mobile phones, laptops and any other electronic gadgets shall not be permitted). The track should be named by the name of the contestant."
+ "\n04. Vulgarity or provocative acts will not be tolerated."
+ "\n05. Participants have to bring their props and are responsible for arrangement and clearance of props within the given time. The organizers must not be asked for any help for the same."
+ "\n06. The organizers hold the right to interrupt or drop your performance any time, regardless of the time limit, on the basis of indecent track, dance steps, costumes, misuse of props, etc. "
+ "\n07. In any case, decision of the judges will be considered final and binding.";
		
		criteria = "01. Choreography"
+ "\n02. Energy"
+ "\n03. Synchronization"
+ "\n04. Stage utilization"
+ "\n05. Costumes"
+ "\n06. Coordination and Overall impact";
		
		contact = "Mr. Lalit Sehgal"
                   + "\n+91 9041340412";
	}
	
	public static cultural_dance_mashitup getInstance() {
		return new cultural_dance_mashitup();
	}
}
class cultural_dance_indianfolkdance extends EventDetails {
	
	public cultural_dance_indianfolkdance() {
		description = "Indian Folk Dance"
+ "\nIndia, being a country with diverse cultures, has a very rich variety of different dance forms."
+ "\nThis competition gives you the perfect occasion to unveil the different folk cultures of India through Dance."
+ "\nIndia has a very rich tradition of folk dance. The extreme cultural diversity creates endless varieties of folk styles."
+ "\nEach region has its own particular style. Bring your folk style on the stage in Indian folk dance competition."
+ "\nParticipants may perform any Indian (Non Punjabi) folk dance such as Rajasthani, Bihu, Dandia, Ghabha, Raas Leela, Nautanki, Ghumar, Kaal Belia, Kasmeri, etc."
+ "\n\nType of event: Group"
+ "\nTeam Size: 08-16 (+ 3 accompanists)";
		
		specification = "";
		
		rules ="01. A maximum of 8 minutes performance time is provided including setup and clearance. A warning indication shall be given on the completion of 7 minutes. Your time starts counting as soon as you step on the stage, even though for arranging props."
+ "\n02. Auditions: An audition shall be conducted. The mode of audition is mentioned in the general guidelines. "
+ "\n03. Participants are allowed to perform either on pre-recorded music tracks or live music. Participants are required to get their tracks in 2 pen drives (carrying tracks in mobile phones, laptops and any other electronic gadgets shall not be permitted). The track should be named by the name of the contestant. In case of live music, they are required to arrange their own music instrument and accompanist."
+ "\n04. Vulgarity or provocative acts will not be tolerated."
+ "\n05. Participants have to bring their props and are responsible for arrangement and clearance of props within the given time. The organizers must not be asked for any help for the same."
+ "\n06. The organizers hold the right to interrupt or drop your performance any time, regardless of the time limit, on the basis of indecent track, dance steps, costumes, misuse of props, etc. "
+ "\n07. In any case, decision of the judges will be considered final and binding";
		
		criteria = "01. Choreography"
+ "\n02. Energy"
+ "\n03. Synchronization"
+ "\n04. Stage utilization"
+ "\n05. Costumes"
+ "\n06. Overall impact";
		
		contact = "Mr. Lalit Sehgal"
                   + "\n+91 9041340412";
	}
	
	public static cultural_dance_indianfolkdance getInstance() {
		return new cultural_dance_indianfolkdance();
	}
}
class cultural_dance_folkingham extends EventDetails {
	
	public cultural_dance_folkingham() {
		description = "FOLKINGHAM: The International Folk Dance Competition"
+ "\nIt is with your feet that you move, but it is with your heart that you dance, and when it comes to folk, everybody dances by heart."
+ "\nThe competition invites all students to flash different international folk dance forms on stage. Participants may perform any International (non-Indian) folk dance."
+ "\nDance forms like dragon dance, morris dance, Finnish tango, Scottish highland dance, paso doble etc."
+ "\nType of event: Group "
+ "\n\nTeam Size: 08-16"
+ "\n\nNOTE: This event is for international fraternity but Indian Students are also free to be a part of this event by performing International Folk Dances. A group may also be formed in such a way that there are some International students and some Indian students too, with the condition that";	
		
		specification = "";
		
		rules ="01. A maximum of 8 minutes performance time is provided including setup and clearance. A warning indication shall be given on the completion of 7 minutes. Your time starts counting as soon as you step on the stage, even though for arranging props."
+ "\n02. Auditions: An audition shall be conducted. The mode of audition is mentioned in the general guidelines."
+ "\n03. Participants are allowed to perform either on pre-recorded music tracks or live music. Participants are required to get their tracks in 2 pen drives (carrying tracks in mobile phones, laptops and any other electronic gadgets shall not be permitted). The track should be named by the name of the contestant. In case of live music, they are required to arrange their own music instrument."
+ "\n04. Vulgarity or provocative acts will not be tolerated."
+ "\n05. Participants have to bring their props and are responsible for arrangement and clearance of props within the given time. The organizers must not be asked for any help for the same."
+ "\n06. The organizers hold the right to interrupt or drop your performance any time, regardless of the time limit, on the basis of indecent track, dance steps, costumes, misuse of props, etc."
+ "\n07. In any case, decision of the judges will be considered final and binding.";
		
		criteria = "01. Choreography"
+ "\n02. Energy"
+ "\n03. Synchronization"
+ "\n04. Stage utilization"
+ "\n05. Costumes"
+ "\n06. Overall impact";
		
		contact = "Mr. Lalit Sehgal"
                   + "\n+91 9041340412";
	}
	
	public static cultural_dance_folkingham getInstance() {
		return new cultural_dance_folkingham();
	}
}
class cultural_dance_nrityanatraj extends EventDetails {
	
	public cultural_dance_nrityanatraj() {
		description = "NRITYA NATRAJ: The Classical/Semi-Classical Solo Dance Competition"
+ "\n\n\"“We dance for laughter, we dance for tears,"
+ "\nWe dance for madness, we dance for fears,"
+ "\nWe dance for hopes, we dance for screams,"
+ "\nWe dance for chances, we dance for dreams.\""
+ "\n\nIf you think you can create dreams with your talent of Indian classical dance, then this is your chance."
+ "\nParticipant can present any classical/semi-classical dance form such as kathak, bharatnatyam, odissi, manipuri , sattriya etc. & semi classical dance form(mix of Indian classical and Indian folk)."
+ "\n\nType of event: Solo";
		
		specification = "";
		
		rules ="01. A maximum of 8 minutes performance time is provided including setup and clearance. A warning indication shall be given on the completion of 7 minutes. Your time starts counting as soon as you step on the stage, even though for arranging props. "
+ "\n02. Auditions: An audition shall be conducted. The mode of audition is mentioned in the general guidelines."
+ "\n03. Participants are allowed to perform either on pre-recorded music tracks or live music. Participants are required to get their tracks in 2 pen drives (carrying tracks in mobile phones, laptops and any other electronic gadgets shall not be permitted). The track should be named by the name of the contestant. In case of live music, they are required to arrange their own music instrument. "
+ "\n04. Vulgarity or provocative acts will not be tolerated."
+ "\n05. Participants have to bring their props and are responsible for arrangement and clearance of props within the given time. The organizers must not be asked for any help for the same."
+ "\n06. The organizers hold the right to interrupt or drop your performance any time, regardless of the time limit, on the basis of indecent track, dance steps, costumes, misuse of props, etc. "
+ "\n07. In any case, decision of the judges will be considered final and binding.";
		
		criteria = "01. Body language"
+ "\n02. Footwork"
+ "\n03. Hand and eye movements"
+ "\n04. Costume and presentation"
+ "\n05. Choreography (technical nuances)"
+ "\n06. overall clarity and impact";
		
		contact = "Mr. Lalit Sehgal"
                   + "\n+91 9041340412";
	}
	
	public static cultural_dance_nrityanatraj getInstance() {
		return new cultural_dance_nrityanatraj();
	}
}
class cultural_dance_boxoffice extends EventDetails {
	
	public cultural_dance_boxoffice() {
		description = "BOX OFFICE: Indian Contemporary / Bollywood Dancing"
+ "\n\nIt doesn’t matter who’s watching, what matters is your feet are tapping, your heart are racing and your passion is sweating."
+ "\nIt is a fusion dance competition in which either Bollywood dancing or contemporary dance forms is allowed. "
+ "\nType of event: Group"
+ "\nTeam Size: 08-16";	
		
		specification = "";
		
		rules ="01. A maximum of 8 minutes performance time is provided including setup and clearance. A warning indication shall be given on the completion of 7 minutes. Your time starts counting as soon as you step on the stage, even though for arranging props. "
+ "\n02. Auditions: An audition shall be conducted. The mode of audition is mentioned in the general guidelines. "
+ "\n03. Participants are allowed to perform either on pre-recorded music tracks or live music. Participants are required to get their tracks in 2 pen drives (carrying tracks in mobile phones, laptops and any other electronic gadgets shall not be permitted). The track should be named by the name of the contestant. In case of live music, they are required to arrange their own music instrument. "
+ "\n04. Vulgarity or provocative acts will not be tolerated."
+ "\n05. Participants have to bring their props and are responsible for arrangement and clearance of props within the given time. The organizers must not be asked for any help for the same."
+ "\n06. The organizers hold the right to interrupt or drop your performance any time, regardless of the time limit, on the basis of indecent track, dance steps, costumes, misuse of props, etc. "
+ "\n07. In any case, decision of the judges will be considered final and binding";
		
		criteria = "01. Choreography"
+ "\n02. Concept and Depiction"
+ "\n03. Synchronization"
+ "\n04. Stage utilization"
+ "\n05. Costumes"
+ "\n06. Fusion of Songs"
+ "\n07. Overall impact";
		
		contact = "Mr. Lalit Sehgal"
                   + "\n+91 9041340412";
	}
	
	public static cultural_dance_boxoffice getInstance() {
		return new cultural_dance_boxoffice();
	}
}
class cultural_dance_Yalgaar extends EventDetails {
	
	public cultural_dance_Yalgaar() {
		description = "YALGAAR THE PUNJABI FOLK DANCE [Male Oriented]"
+ "\n(BHANGRA / MALWAI GIDDHA / JHOOMER DANCE) COMPETITION"
+ "\n\n\"Taar Toombe di cho yamle di yaad ave,"
+ "\nKite dhol ute nache jo shabaab disda,"
+ "\nLok geeta cho disan sade heer- ranje,"
+ "\nMei jidar dekha, har rang cho mainu Punjab disda.\""
+ "\nThis competition is oriented towards Male Punjabi Folk Dances such as: Bhangra, malwai gidha, jhoomere etc."
+ "\n\nType of event: Group"
+ "\nTeam Size: 08-16 (+ 3 accompanists)"
+ "\n\nNOTE: Team formation can comprise of only boys, only girls or a combination of boys and girls.";
		
		specification = "";
		
		rules ="01. A maximum of 15 minutes performance time is provided including setup and clearance. A warning indication shall be given on the completion of 14 minutes. Your time starts counting as soon as you step on the stage, even though for arranging props."
+ "\n02. Auditions: An audition shall be conducted. The mode of audition is mentioned in the general guidelines."
+ "\n03. Participants are allowed to perform either on pre-recorded Punjabi Folk music tracks or live music. Participants are required to get their tracks in 2 pen drives (carrying tracks in mobile phones, laptops and any other electronic gadgets shall not be permitted). The track should be named by the name of the contestant. In case of live music, they are required to arrange their own music instrument."
+ "\n04. Vulgarity or provocative acts will not be tolerated."
+ "\n05. Participants have to bring their props and are responsible for arrangement and clearance of props within the given time. The organizers must not be asked for any help for the same."
+ "\n06. The organizers hold the right to interrupt or drop your performance any time, regardless of the time limit, on the basis of indecent track, dance steps, costumes, misuse of props, etc. "
+ "\n07. In any case, decision of the judges will be considered final and binding.";
		
		criteria = "01. Expressions"
+ "\n02. Formations"
+ "\n03. Clarity in steps"
+ "\n04. Coordination"
+ "\n05. Costumes and Overall Impact";
		contact = "Mr. Lalit Sehgal"
                   + "\n+91 9041340412";
	}
	
	public static cultural_dance_Yalgaar getInstance() {
		return new cultural_dance_Yalgaar();
	}
}
class cultural_dance_panjeba extends EventDetails {
	
	public cultural_dance_panjeba() {
		description = "PANJEBA THE PUNJABI FOLK DANCE [Female Oriented]"
+ "\n(GIDDHA, JAAGO, KIKLI, LUDDI) COMPETITION"
+ "\n\n\"Vakhra ae shaunk, edi vakhri ae shaan,"
+ "\nDdharti hila den wali punjaban di tor,"
+ "\nJean ch eni jachdi na mutiyaar ae,"
+ "\nJinni sohni lagdi, patiyala shahi wali naar  ea.\""
+ "\nThis competition is oriented towards Female Punjabi Folk Dances such as Giddha, Jaago, Kikli, Luddi etc."
+ "\n\nType of event: Group"
+ "\nTeam Size: 08-16 (+ 3 accompanists)"
+ "\nNOTE: Team formation can comprise of only girls or a combination of boys and girls.";
		
		specification = "";
		
		rules ="01. A maximum of 15 minutes performance time is provided including setup and clearance. A warning indication shall be given on the completion of 14 minutes. Your time starts counting as soon as you step on the stage, even though for arranging props."
+ "\n02. Auditions: An audition shall be conducted. The mode of audition is mentioned in the general guidelines."
+ "\n03. Participants are allowed to perform either on pre-recorded Punjabi Folk music tracks or live music. Participants are required to get their tracks in 2 pen drives (carrying tracks in mobile phones, laptops and any other electronic gadgets shall not be permitted). The track should be named by the name of the contestant. In case of live music, they are required to arrange their own music instrument."
+ "\n04. Vulgarity or provocative acts will not be tolerated."
+ "\n05. Participants have to bring their props and are responsible for arrangement and clearance of props within the given time. The organizers must not be asked for any help for the same."
+ "\n06. The organizers hold the right to interrupt or drop your performance any time, regardless of the time limit, on the basis of indecent track, dance steps, costumes, misuse of props, etc."
+ "\n07. In any case, decision of the judges will be considered final and binding";
		
		criteria = "01. Expressions"
+ "\n02. formations"
+ "\n03. clarity in steps"
+ "\n04. coordination"
+ "\n05. costumes and overall impact";
		
		contact = "Mr. Lalit Sehgal"
                   + "\n+91 9041340412";
	}
	
	public static cultural_dance_panjeba getInstance() {
		return new cultural_dance_panjeba();
	}
}
		
class cultural_crafting_marathon extends EventDetails {
	
	public cultural_crafting_marathon() {
		description = "The Crafting Marathon (Ice-cream Sticks Model Making-Clay Modeling- Mix Media Work)"
					+ "\nYouth Vibe 2014 provides you one of the most unique events under the Fine Arts Category in which a group of 3-5 contestants shall be bound to complete three Model Making works using Ice-cream sticks, clay & mix media in a span of just 3 hours."
					+ "\nType of event: Group"
					+ "\nTeam Size: 3-5 (On the choice of the team)"
					+ "\nWork to be completed: 3"
					+ "\nTime Allotted: 3 Hours"
					+ "\nWorks to be completed:"
					+ "\nSTICK TO STICK: Ice-cream stick model making"
					+ "\nHASTHKALA: the clay art"
					+ "\nIMAGINEER: Mix Media Work";
		
		rules = "STICK TO STICK: Ice-cream stick model making"
				+ "\nIce Cream Stick Design, here you need to make any innovative ice cream stick model using the provided materials."
				+ "\nHASTHKALA: the clay art"
				+ "\nClay Modeling Competition; here every participant would be given clay/plasticize to make a model on the spot in the given time limit."
				+ "\nIMAGINEER: Mix Media Work"
				+ "\nThe event is Mix Media Works; A creative drawing competition where you can use a maximum of three to five different mediums/objects to enhance look of your creativity."
				+ "\nCommon rules for all the three works"
				+ "\n-o-The theme of each of the work shall be given on the spot."
				+ "\n-o-The organizers shall provide all the required materials & no use of any other personal materials will be allowed."
				+ "\n-o-Usage of materials / tools/equipments / accessories, etc. other than those provided by the organizers are not allowed and shall lead to disqualification."
				+ "\n-o-Use of mobile phones or any electrical gadgets are strictly prohibited."
				+ "\n-o-The decision of the judges shall be the final one.";
		
		specification = "";
		
		criteria = "-o-Imagination & Conception"
					+ "\n-o-Presentation & Design"
					+ "\n-o-Efficiently resource utilization Creativity of model"
					+ "\n-o-Detailing & Creativity done on the models"
					+ "\n-o-Relevance to the topic & Overall impression";
		
		contact = "Mr. Irfan Ansari"
				+ "\n+91-7696236116"
				+ "\nMr. Sai Srikanth"
				+ "+91-9780070286";
	}
	
	public static cultural_crafting_marathon getInstance() {
		return new cultural_crafting_marathon();
	}
}

class cultural_expedition_marathon extends EventDetails {
	
	public cultural_expedition_marathon() {
		description = "The Expedition Marathon (3D Rangoli-Cartooning-On the Spot Painting)"
				+ "\nYouth Vibe 2014 provides you one of the most unique events under the Fine Arts Category in which a group of 3-5 contestants shall be bound to complete three works: Rangoli, Cartooning & On the Spot Painting in a span of just 3 hours."
				+ "\nType of event: Group"
				+ "\nTeam Size: 3-5 (On the choice of the team)"
				+ "\nWork to be completed: 3"
				+ "\nTime Allotted: 3 Hours"
				+ "\nWorks to be completed:"
				+ "\nMUGGU: Rangoli art"
				+ "\nMOODY DIVAS: cartooning"
				+ "\nSPONTANEITY: on the spot painting ";
		
		rules = "MUGGU: Rangoli art"
				+ "\nRANGOLI is a folk-art from India. Rangoli is generally practiced by us as means of decoration. The design varies reflecting the traditions, folklore and practices which are customary to that part of area."
				+ "\nMOODY DIVAS: cartooning"
				+ "All cartoon characters and fables must be exaggeration, caricatures. It is the very nature of fantasy and fable.\""
				+ "\nIt is a sketching/drawing symbolizing, satirizing, or caricaturing some action, subject, or person. Cartoon making provide us with a message whose verbal skill or incongruity has the power to evoke laughter."
				+ "\nSPONTANEITY: on the spot painting"
				+ "\nThe name itself depicts the kind of painting it is, where participants are provided with a theme on the spot."
				+ "\nCommon rules for all the three works"
				+ "\n-o-The theme of each of the work shall be given on the spot."
				+ "\n-o-3D Effect in Rangoli is mandatory."
				+ "\n-o-The organizers shall provide all the required materials & no use of any other personal materials will be allowed."
				+ "\n-o-Usage of materials / tools/equipments / accessories, etc. other than those provided by the organizers are not allowed and shall lead to disqualification."
				+ "\n-o-Use of mobile phones or any electrical gadgets are strictly prohibited."
				+ "\n-o-The decision of the judges shall be the final one.";

		specification = "";
		
		criteria = "-o-3D Impression & neatness in Rangoli"
				+ "\n-o-Cartooning Skills"
				+ "\n-o-Message depicted by the cartoons"
				+ "\n-o-Relevance to the theme"
				+ "\n-o-Imagination & Conception"
				+ "\n-o-Presentation & Design";
		
		contact = "Mr. Irfan Ansari"
				+ "\n+91-7696236116"
				+ "\nMr. Sai Srikanth"
				+ "\n+91-9780070286";
	}
	
	public static cultural_expedition_marathon getInstance() {
		return new cultural_expedition_marathon();
	}
}

class cultural_quill_arts_marathon extends EventDetails {
	
	public cultural_quill_arts_marathon() {
		description = "The Quill Arts Marathon (Paper Work: Card Designing –Paper Folding – Paper Ornament Design)"
				+ "\nYouth Vibe 2014 provides you one of the most unique events under the Fine Arts Category in which a group of 3-5 contestants shall be bound to complete three Paper folding/cutting works in a span of just 3 hours."
				+ "\nType of event: Group"
				+ "\nTeam Size: 3-5 (On the choice of the team)"
				+ "\nWork to be completed: 3"
				+ "\nTime Allotted: 3 Hours"
				+ "\nWorks to be completed:"
				+ "\nPAPER FILIGREE: Quill Art (Paper Folding 3D Arts)"
				+ "\nGREET-WINGS: Greeting cards"
				+ "\nORNAMENTATION: Paper ornament ";
		
		rules = "PAPER FILIGREE: Quill Art (Paper Folding 3D Arts)"
				+ "\nQuelling is an art form that involves the use of strips of paper that are rolled, shaped, and glued together to create decorative designs. The coiling and shaping of narrow paper strips to create a design such as holly leaves, and all sorts of beautiful scrolls."
				+ "GREET-WINGS: Greeting cards"
				+ "\nIt's a greeting card making competition in which one can use his/her WINGS(talent/skills)and using that wings can fly high in the sky to GREET(convey his/her message to) dear and near ones."
				+ "\nORNAMENTATION: Paper ornament"
				+ "\nWhy to buy a jewelry/ornament? Just think something which cheap and easily made i.e. think out of the box and design your own masterpiece as per your need/want/color."
				+ "\nCommon rules for all the three works"
				+ "\n-o-The theme of each of the work shall be given on the spot."
				+ "-o-The organizers shall provide all the required materials & no use of any other personal materials will be allowed."
				+ "-o-Usage of materials / tools/equipments / accessories, etc. other than those provided by the organizers are not allowed and shall lead to disqualification."
				+ "-o-Use of mobile phones or any electrical gadgets are strictly prohibited."
				+ "-o-The decision of the judges shall be the final one. ";
		
		specification = "";
		
		criteria = "-o-Design"
				+ "\n-o-Message given"
				+ "\n-o-Way of presentation"
				+ "\n-o-Uniqueness"
				+ "\n-o-Color combination"
				+ "\n-o-Neatness of works";
		
		contact = "Mr. Irfan Ansari"
				+ "\n+91-7696236116"
				+ "\nMr. Sai Srikanth"
				+ "\n+91-9780070286";
	}
	
	public static cultural_quill_arts_marathon getInstance() {
		return new cultural_quill_arts_marathon();
	}
}