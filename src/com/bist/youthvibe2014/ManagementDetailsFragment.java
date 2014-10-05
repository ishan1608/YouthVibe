package com.bist.youthvibe2014;


import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class ManagementDetailsFragment extends Fragment {

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
						placeHolderEventDetails = management_business_stratergy.getInstance();
					break;
					case 1:
						placeHolderEventDetails = management_bplan.getInstance();
					break;
					case 2:
						placeHolderEventDetails =  management_bizvictoria.getInstance();
					break;
					case 3:
						placeHolderEventDetails = management_casedevelopment.getInstance();
					break;
					case 4:
						placeHolderEventDetails = management_stategic_evaluation.getInstance();
					break;
					case 5:
						placeHolderEventDetails = management_simulation_game.getInstance();
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

class management_business_stratergy extends EventDetails {
	
	public management_business_stratergy() {
description = "There's no luck in business. There's only drive, determination, and more drive."
+ "\nA strategy, resource planning and creativity is all you need to impress everyone out there. This event will test your capability to get your company out of the loss and solve the problems that a business usually faces."
+ "\nHere, you get to showcase the quality of leadership in you along with your ability to plan and perform under pressure. So be the front liner, come up with a strategy and help your company in the comeback";
		
		rules = "01. It is a team event and each team can have a maximum of 4 and a minimum of 2 participants."
+ "\n02. Each team will be given a case 5 days before the date of the competition."
+ "\n03. The teams have to make a power point presentation to give a solution for the problem given in the case."
+ "\b04. The time given to each team will be as following: (this is the maximum time limit)"
+ "\n\n4.1. 2 minutes for setup and preparation."
+ "\n4.2. 6 minutes for uninterrupted presentation."
+ "\n4.3. 5 minutes for intensive question and answer from judges."
+ "\n4.4. 2 minutes for uninterrupted conclusion."
+ "\n\n05. Teams need to bring their power point presentations in pen drives/CDs and they should also carry a backup of the same. It should be kept in mind that the organizers will not be responsible for any problem arising at the last moment."
+ "\n06. The decision of the judges will be final and binding.";
		
		specification = "";
		
		criteria = "";
		contact = "";
	}
	
	public static management_business_stratergy getInstance() {
		return new management_business_stratergy();
	}
}

class management_bplan extends EventDetails {
	
	public management_bplan() {
description ="B-PLAN COMPETITION - PLAN YOUR BUSINESS"
+ "\nBusiness is a game, played for fantastic stakes, and you're in a competition with experts. If you want to win, you have to learn to be the master of the game."
+ "\nThis is for those who have a plan to sell their ideas, their practical, rational, viable and master ideas."
+ "\nCreate a business plan and make a presentation based on it, showing its purpose, need, stats and usability. "
+ "\nCome up with your aspirations to impress the jury and convince them that the society needs what you have thought of.";
		
rules = "01. It is a team event and each team should have two members."
+ "\n02. The team needs to formulate a business plan."
+ "\n03. The team has to make a presentation of that plan stating its need, features, future, viability and necessity."
+ "\n04. The presentation can be no longer than 10 minutes."
+ "\n05. After your presentation, the judges can ask you questions based on your plan."
+ "\n06. The questions can be related to the content, information sources or any relevant issue in context of your presentation."
+ "\n07. A satisfactory question handling will fetch you points and not answering (or irrelevant/non-satisfactory response) can fetch you negatives also.";
		
		specification = "";
		
		criteria = "";
		contact = "";

	}
	
	public static management_bplan getInstance() {
		return new management_bplan();
	}
}

class management_bizvictoria extends EventDetails {
	
	public management_bizvictoria() {
description = "BIZ VICTORINA - THE BUSINESS QUIZ"
+ "\nThe business quiz competition is tough, and it requires you to be tougher - tough-minded, never hard hearted."
+ "\nAre you a genius in terms of taglines, economic affairs, logos and companies?"
+ "\nIf you nodded your head to that question, here is the chance for you- A business quiz.";
		
		rules = "01. It is a team event and each team should consist of two members each."
+ "\n02. Questions shall be based on business, economics and finance related fields."
+ "\n03. The prelims will be of duration not more than 20 minutes. All members of the team must be present at the screening."
+ "\n04. Only 6 short listed teams will participate in finals."
+ "\n05. Detailed rules and regulations shall be announced in the finals."
+ "\n06. Decision of the quiz master shall be final and binding."
+ "\n07. If the teams do not report at the prelims, they shall be disqualified."
+ "\n08. Only first and second place winners shall be awarded and as a team, not individuals.";
		
		specification = "";
		
		criteria = "";
		contact = "";

	}
	
	public static management_bizvictoria getInstance() {
		return new management_bizvictoria();
	}
}

class management_casedevelopment extends EventDetails {
	
	public management_casedevelopment() {
description = "Objectives of Case development"
+ "\n01. Increase the understanding of what managers should and should not do in guiding a business to success"
+ "\n02. To enhance the analytical skills, integrative thinking and decision making skills of the students"
+ "\n03. Gaining in-depth exposure to different industries and companies, thereby acquiring something close to actual business experience"
+ "\nGroup size 2-4 students (preferably from different domains)"
+ "\nAn industry/organizational problem would be given to the group one week advance to the event. "
+ "\nThe problem shall include some facts and concern areas regarding various functions of the organization/ industry.";
		
		rules = "At a minimum, the business case shall include the following sections:"
+ "\n01. Executive Summary"
+ "\n02. Introduction & Background"
+ "\n03. Problem Definition & Desired Business Goal(s) and Objectives"
+ "\n04. Alternatives"
+ "\n05. Assumptions"
+ "\n06. Benefits Estimates, and Benefit Metrics"
+ "\n07. Cost Estimates"
+ "\n08. Risk Assessment"
+ "\n09. Financial Analysis"
+ "\n10. Recommendation"
+ "\n11. Implementation Approach/Timeline"
+ "\n12. Appendices"
+ "\n\nLength of the case - 2000 words (maximum)"
+ "\nPresentation Time 30 minutes (20 minutes presentation followed by 10 minutes question handling)"
+ "\nContents of the presentation:"
+ "\n01. Problem Articulation"
+ "\n02. Organization and Industry Analysis"
+ "\n03. Concepts to be discussed with the help of the case study";
		
		specification = "";
		
		criteria = "";
		contact = "";

	}
	
	public static management_casedevelopment getInstance() {
		return new management_casedevelopment();
	}
}

class management_stategic_evaluation extends EventDetails {
	
	public management_stategic_evaluation() {
description = "Introduction:"
+ "\nParticipants will be given a case study of a business situation. It may be based on real or assumed situation. Participants will suggest the best possible solution for the problem. Participant should be in a position to fully justify their solution to the case.";
		
		rules = "01. Entry will be taken as a team. No individual participant allowed."
+ "\n02. Maximum number of participant per team is 4. Minimum number is 2."
+ "\n03. Case study will be given 7 days in advance."
+ "\n04. Team has to present a solution which can be implied in real life."
+ "\n05. Team has to refrain from legally wrong suggestions."
+ "\n06. All team has to abide by the final decision of the evaluators.";
		
		specification = "";
		
		criteria = "Participants should be judged on following two parameters which will have sub-parameters as follows:"
+ "\n01. Presentation skills -"
+ "\na. Giving a well-structured, cohesive and clear presentation"
+ "\nb. Being innovative and dynamic in delivering the material"
+ "\nc. Demonstrating contribution of all team members"
+ "\n02. Content of the solution"
+ "\na. Using appropriate concepts, frameworks and tools in the analysis"
+ "\nb. Feasibility of strategy suggested"
+ "\nc. Comprehensiveness of strategy proposed"
+ "\nd. Creative/innovativeness"
+ "\ne. Dealing effectively with questions from judges";
		contact = "";
	}
	
	public static management_stategic_evaluation getInstance() {
		return new management_stategic_evaluation();
	}
}

class management_simulation_game extends EventDetails {
	
	public management_simulation_game() {
description = "INTRODUCTION"
+ "\n\"Tell me, I'll forget; show me, I may remember and involve me and I'll understand.\""
+ "\nA simulation game attempts to replicate various activities from \"real life\" in the form of a game for various purposes such as training, analysis, or prediction. "
+ "\nA simulation stimulates active engagement of students. They are playing a role, not just reading and analyzing. They make decisions and see the results of their decisions in the response of other players and the outcome of the simulation. "
+ "\nSimulations generate much more energy among students than traditional lectures or case discussions. Simulation challenges students to make realistic marketing and business decisions in a competitive, fast-paced market. "
+ "\nThey develop and execute complete business strategies and play against peers to make the mark in the marketplace on real time software. "
+ "\nThis enables the students to think critically and make tradeoffs in their business decisions to impact and understand business from a whole new perspective. "
+ "\nThey are involved in no case studies, no real life examples but just pure live business.";
		
		rules = "01. The competition is based on Simulation Game."
+ "\n02. Participants have to play an online simulation game for predefined rollovers. "
+ "\n03. Study material on the simulation will be provided in advance to the participants."
+ "\n04. Attending a debriefing session of 15 minutes before the start of the simulation game is mandatory."
+ "\n05. Participants have to reach the venue before 15min to the scheduled time of the event."
+ "\n06. There can be a team of 2-4 participants. (Minimum 2 & Maximum 4)"
+ "\n07. Discussion with peers is not encouraged and may lead to disqualification of participant."
+ "\n08. Anyone found playing the game after prescribed time limits would be disqualified from the competition."
+ "\n09. Decision of Judges would be final.";
		
		specification = "";
		
		criteria = "01. Winner will be selected as per Share Holder Value at the end of the game.";
		contact = "";
	}
	
	public static management_simulation_game getInstance() {
		return new management_simulation_game();
	}
}

