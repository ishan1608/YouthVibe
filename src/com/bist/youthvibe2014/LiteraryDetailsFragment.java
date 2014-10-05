package com.bist.youthvibe2014;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class LiteraryDetailsFragment extends Fragment {

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
						placeHolderEventDetails = literary_yv_maha_quiz.getInstance();
					break;
					case 1:
						placeHolderEventDetails = literary_bizwiz.getInstance();
					break;
					case 2:
						placeHolderEventDetails = literary_sportsvilla.getInstance();
					break;
					case 3:
						placeHolderEventDetails = literary_3e_quiz.getInstance();
					break;
					case 4:
						placeHolderEventDetails = literary_thedebatechampionship.getInstance();
					break;
					case 5:
						placeHolderEventDetails = literary_the_perspective.getInstance();
					break;
					case 6:
						placeHolderEventDetails = literary_lordofthewords.getInstance();
					break;
					case 7:
						placeHolderEventDetails = literary_turncoat.getInstance();
					break;
					case 8:
						placeHolderEventDetails = literary_sansad_pratiyogita.getInstance();
					break;
					default:
						placeHolderEventDetails = literary_race_of_rhyme.getInstance();
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

class literary_yv_maha_quiz extends EventDetails {
	
	public literary_yv_maha_quiz() {
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
	
	public static literary_yv_maha_quiz getInstance() {
		return new literary_yv_maha_quiz();
	}
}

class literary_bizwiz extends EventDetails {
	
	public literary_bizwiz() {
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
	
	public static literary_bizwiz getInstance() {
		return new literary_bizwiz();
	}
}

class literary_sportsvilla extends EventDetails {
	
	public literary_sportsvilla() {
		description = "Sportica the Sports Quiz"
                      + "\nThey call you a nerd, a geek! Time to show them ground in their own sphere of influence." 
                      + "\nThe sports quiz, an open invitation to all sport nicks, for the show of not physical but mental battle (though it could get physical if a tie break persists!).";
		
		specification = "";
		
		rules = "01. Teams of three will have to answer the written elimination."
				+ "\n02. Any number of teams from a college can participate."
	               + "\n03. The top six teams, selected on the basis of their scores in the elimination, will compete in the finals."
	               + "\n04. Questions shall be based on sports and games played in India and abroad and their happenings in recent times and past."
	               + "\n05. Details of marking/rounds to be declared at the time of the finals.";
		criteria = "";
		
		contact = "";
	}
	
	public static literary_sportsvilla getInstance() {
		return new literary_sportsvilla();
	}
}

class literary_3e_quiz extends EventDetails {
	
	public literary_3e_quiz() {
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
	
	public static literary_3e_quiz getInstance() {
		return new literary_3e_quiz();
	}
}

class literary_thedebatechampionship extends EventDetails {
	
	public literary_thedebatechampionship() {
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
	
	public static literary_thedebatechampionship getInstance() {
		return new literary_thedebatechampionship();
	}
}

class literary_the_perspective extends EventDetails {
	
	public literary_the_perspective() {
		description = "“Let thy speech be better than silence, or be silent.” -Dionysius of Halicarnassus"
						+ "\n\nSpeaking is an art which is known to all but there are very few people who can capture the real essence of public speaking."
						+ "\n\nIf you think your persona is enough to create the magic of words which tangles everyone in it, then this is your chance to become the robust speaker."
						+ "\n\nType of event: Solo"
						+ "\nTeam Size: 1"
						+ "\n\nThe Perspective shall be conducted in two different categories, each having separate evaluation, separate winners and separate prizes."
						+ "\n\nThe following are the categories of the competition:"
						+ "\n\n-o- English"
						+ "\n\n-o- Hindi ";
		
		rules = "It is a solo event and the competition is divided into 2 rounds. Round 1 shall be the eliminator while Round 2 shall be the finale. Winner shall be decided on the cumulative score of Round 1 and Round 2."
				+ "\n\nRound 1 : Elocution"
				+ "\n\n-o- The topic for the speech will be given 7 days prior to the event."
				+ "\n\n-o- Speech has to be presented in English or in Hindi."
				+ "\n\n-o-Time Limit is 5 minutes for each participant. However, the participants may be stopped in between by the judges if they find anything which is against the policy."
				+ "\n\n-o- The first bell for each speaker shall ring at 4 minutes followed by a warning bell at 4.45 minutes after which the speaker shall have 15 secs to wind up.Individuals exceeding the permissible time limit of 5 minutes shall be disqualified."
				+ "\n\n-o- A maximum of 8-10 contestants shall qualify to the next round."
				+ "\n\n-o-The decision of the judging panel will be final and binding."
				+ "\n\n-o-Reading from paper/other resources such as mobile phone/ tabs etc. is not permissible any shall ;ead to immediate disqualification"
				+ "\n\nRound 2 : Extempore"
				+ "\n\n-o- Topic shall be given on the spot.However, A preparation time of 10 minutes shall be given to each contestants."
				+ "\n\n-o- Language permitted is either English or Hindi."
				+ "\n\n-o-Participant has to speak on the topic for a minimum of 3 minutes and a maximum of 4 minutes."
				+ "\n\n-o-The winner will be decided by cumulative marks of both the rounds."
				+ "\n\n-o- The first bell for each speaker shall ring at 3 minutes followed by a warning bell at 3.45 minutes after which the speaker shall have 15 secs to wind up.Individuals exceeding the permissible time limit of 4 minutes shall be disqualified."
				+ "\n\n-o-Reading from paper/other resources such as mobile phone/ tabs etc. is not permissible any shall ;ead to immediate disqualification";
		
		specification = "";
		
		criteria = "-o- Content"
					+ "\n\n-o- Delivery"
					+ "\n\n-o- Points Offered"
					+ "\n\n-o- Command on Language"
					+ "\n\n-o- Overall Impression";
		
		contact = "Mr. Fahad Ahmad Khan"
					+ "\n+91-8194867721";
	}
	
	public static literary_the_perspective getInstance() {
		return new literary_the_perspective();
	}
}

class literary_lordofthewords extends EventDetails {
	
	public literary_lordofthewords() {
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
	
	public static literary_lordofthewords getInstance() {
		return new literary_lordofthewords();
	}
}

class literary_turncoat extends EventDetails {
	
	public literary_turncoat() {
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
	
	public static literary_turncoat getInstance() {
		return new literary_turncoat();
	}
}

class literary_sansad_pratiyogita extends EventDetails {
	
	public literary_sansad_pratiyogita() {
		description = "";
		
		rules = "";
		
		specification = "";
		
		criteria = "";
		
		contact = "Mr. Fahad Ahmad Khan"
				+ "\n+91-8194867721";
	}
	
	public static literary_sansad_pratiyogita getInstance() {
		return new literary_sansad_pratiyogita();
	}
}

class literary_race_of_rhyme extends EventDetails {
	
	public literary_race_of_rhyme() {
		description = "Poetry is not a turning loose of emotion, but an escape from emotion; it is not the expression of personality, but an escape from personality."
						+"\nBut, of course, only those who have personality and emotions know what it means to want to escape from these things."
						+"\nType of event: Solo"
						+"\nTeam Size: 1"
						+"\nRace of Rhyme is a Poetry Composition cum Recitation competition in which the poet gives vent to their feelings by writing a poem on a given theme and then recites it in a way that is simply enthralling and beautifully expressed."
						+"\nRace of Rhyme shall be conducted in two different categories, each having separate evaluation, separate winners and separate prizes."
						+"\nThe following are the categories of the competition:"
						+"\n-o- English"
						+"\n-o- Hindi ";
		
		rules = "-o-It is an individual event."
				+ "\nThere are two rounds in this competition:"
				+ "\n-o-Poetry Writing"
				+ "\n-o- Poetry Recitation"
				+ "\n-o- Poem can be presented either in English or in Hindi."
				+ "\nPoetry Writing:"
				+ "\n-o- In first round participant will be given 45 minutes to write the poem."
				+ "\n-o- 5 Topics will be given on the spot for poem writing and participant will have to choose one topic from them."
				+ "\nPoetry Recitation:"
				+ "\n-o- In second round each participant will have to recite their own poem which has written on the spot. Time Limit is 5 minutes for each participant. There will be a first warning bell after 3 minutes, second warning bell at 4 minutes 45 seconds, followed by disqualification at the final bell rung after the completion of 5 minutes. However, the participants may be stopped in between by the judges if they find anything which is against the policy."
				+ "\n-o- There will be different judgment for Hindi & English and different prizes for each language."
				+ "\n-o- All Decisions by the judges would be considered Final."
				+ "\n-o- There should be no vulgarity in the performance of any type verbal or action.";
		
		specification = "";
		
		criteria = "-o-Delivery of poem"
					+ "\n-o- Voice-modulations"
					+ "\n-o- Content & theme"
					+ "\n-o- Rhyme"
					+ "\n-o- Expressions and overall impact";
		
		contact = "Mr. Fahad Ahmad Khan"
					+"\n+91-8194867721";
	}
	
	public static literary_race_of_rhyme getInstance() {
		return new literary_race_of_rhyme();
	}
}