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
						placeHolderEventDetails = sports_chess.getInstance();
					break;
					case 3:
						placeHolderEventDetails = sports_volleyball.getInstance();
					break;
					case 4:
						placeHolderEventDetails = sports_table_tennis.getInstance();
					break;
					case 5:
						placeHolderEventDetails = sports_cricket.getInstance();
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

class sports_chess extends EventDetails {
	
	public sports_chess() {
		description = "CHESS "
					+ "\nChess as a sport requires a lot of mental stamina, and this is what that makes it different from a physical sport. Chess players have a unique ability of taking in a lot of information and remembering relevant bits. So, memory and mental stamina are the key attributes."
					+ "\nViswanathan Anand"
					+ "\nEvent Type: Group"
					+ "\nTeam Size: 4"
					+ "\nOpen for: Both (Male + Female)"
					+ "\nStages of Tournament:"
					+ "\n-o-Qualifiers for Host University"
					+ "\n-o-	League (For all teams)"
					+ "\n-o-	Semi-final"
					+ "\n-o-	Final"
					+ "\nTiming of the matches: 6.30 am – 9.00 pm (any time in between)"
					+ "\nImportant Instructions:"
					+ "\n-o-	All matches shall be governed by norms of FIDE"
					+ "\n-o-	More than one match can be scheduled for a team on a particular day."
					+ "\n-o-	All teams must bring their own Chess Clock."
					+ "\n-o-	Teams are requested to report to the venue ground 15 minutes before the scheduled start time."
					+ "\n-o-	Walkover will be given to a team if the opponent team is not able to reach the ground within 15 minutes of the scheduled time."
					+ "\n-o-	No team shall argue with Referee/ umpires in any case as it would lead to cancellation of team registration and no refunds will be given. It could also attract proper disciplinary actions against the team."
					+ "\n-o-	No extra labor will be provided for any team help."
					+ "\n** RULES & SCHEDULE ARE SUBJECT TO CHANGE IN THE SPIRIT OF THE GAME & FESTIVAL AND THE FINAL DECISION RESTS WITH THE HOST UNIVERSITY.";
		
		
		rules = "-o-The game is going to be played between 2 players from different teams. "
				+ "\n-o-The sequence of the matches and which team shall play against which team shall be decided by random lucky draw at the discretion of the organizing University."
				+ "\n-o-Each team consists of 4 players."
				+ "\n-o-All the team members must belong to the same Institute."
				+ "\n-o-If a player from Team A wins against a player from Team B, then he gets 10 point for his team and if they end in a draw, both the players get 5 points for their team, to be added into the round points of the team."
				+ "\n** RULES & SCHEDULE ARE SUBJECT TO CHANGE IN THE SPIRIT OF THE GAME & FESTIVAL AND THE FINAL DECISION RESTS WITH THE HOST UNIVERSITY.";
		
		specification = "";
		
		criteria = "";
		
		contact = "Mr. Ajay"
				+ "\n+91-7837360375"
				+ "\nMr. Alok Pratap Singh"
				+ "\n+91-9041592540";
	}
	
	public static sports_chess getInstance() {
		return new sports_chess();
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

class sports_table_tennis extends EventDetails {
	
	public sports_table_tennis() {
		description = "TABLE TENNIS "
				+ "\nTennis is a perfect combination of violent action taking place in an atmosphere of total tranquility."
				+ "\nEvent Type: Group"
				+ "\nTeam Size: 3"
				+ "\nOpen for: Male & Female"
				+ "\nStages of Tournament: "
				+ "\n-o-Qualifiers for Host University"
				+ "\n-o-League (For all teams)"
				+ "\n-o-	Semi-final"
				+ "\n-o-	Final"
				+ "\nTiming of the matches: 6.30 am – 9.00 pm (any time in between)"
				+ "\nImportant Points: "
				+ "\n-o-	All matches shall be governed by norms of Table Tennis Federation of India "
				+ "\n-o-	More than one match can be scheduled for a team on a particular day. "
				+ "\n-o-	All teams must bring their own kits. No Kits shall be provided by the organizers. "
				+ "\n-o-	In case of heavy rain, decision taken by umpires will be considered as final."
				+ "\n-o-	In case of any discrepancy/natural problems during finals or semi-finals, winner will be decided on the basis of point tally of league matches STRICTLY."
				+ "\n-o-	Teams are requested to report the ground 15 minutes before the scheduled start time."
				+ "\n-o-	Walkover will be given to a team if the opponent team is not able to reach the ground within 15 minutes of the scheduled time."
				+ "\n-o-	No team shall argue with Referee/ umpires in any case as it would lead to cancellation of team registration and no refunds will be given. It could also attract proper disciplinary actions against the team."
				+ "\n-o-	No extra labor will be provided for any team help."
				+ "\n** RULES & SCHEDULE ARE SUBJECT TO CHANGE IN THE SPIRIT OF THE GAME & FESTIVAL AND THE FINAL DECISION RESTS WITH THE HOST UNIVERSITY.";
		
		rules = "-o-A maximum of three players can register for the men's and women's teams respectively."
				+ "\n-o-Each team match consists of five individual matches: 3 singles & two doubles and shall end when one team has won a majority of the possible individual matches. "
				+ "\n-o-Firstly, three single matches shall be played followed by double matches. "
				+ "\n-o-Each of the team captains shall nominate their players as 1, 2 & 3. "
				+ "\n-o-Players nominated as 1 shall play against each other and so on for 2 & 3. "
				+ "\n-o-The captain of the teams shall decide the team combination, however all three players must be involved in either of two matches. "
				+ "\n-o-The referee shall have power to disqualify a player from a match, a team match, an event or a competition for seriously unfair or offensive behavior."
				+ "\n-o-If a player is disqualified from 2 matches of the team event, he or she shall automatically be disqualified from that team event."
				+ "\n-o-The team will lose that match by forfeit (the team match by 2-0, each match by 2-0 and each game by 11-0). The opposing team will advance to the next round."
				+ "\n-o-Any markings or trimming on the front or side of a playing garment and any objects such as jewelry worn by a player shall not be so conspicuous or brightly reflecting as to unsighted an opponent."
				+ "\n** RULES & SCHEDULE ARE SUBJECT TO CHANGE IN THE SPIRIT OF THE GAME & FESTIVAL AND THE FINAL DECISION RESTS WITH THE HOST UNIVERSITY.";
		
		specification = "";
		
		criteria = "";
		
		contact = "Mr. Ajay"
				+ "\n+91-7837360375"
				+ "\nMr. Alok Pratap Singh"
				+ "\n+91-9041592540";
	}
	
	public static sports_table_tennis getInstance() {
		return new sports_table_tennis();
	}
}

class sports_cricket extends EventDetails {
	
	public sports_cricket() {
		description = "Cricket"
				+ "\nAny active sportsman has to be very focused; you've got to be in the right frame of mind. If your energy is diverted in various directions, you do not achieve the results. I need to know when to switch on and switch off: and the rest of the things happen around that. Cricket is in the foreground, the rest is in the background."
				+ "\nSachin Tendulkar"
				+ "\nEvent Type: Group"
				+ "\nTeam Size: 14-16 [+ Coaching Staff]"
				+ "\nOpen For: Male Only"
				+ "\nStages of Tournament:"
				+ "\n-o-Qualifiers for Host University: 12-12 Overs a side"
				+ "\n-o-	League (For all teams): 15-15 Overs a side"
				+ "\n-o-	Semi-final: 20-20 Overs a Side"
				+ "\n-o-	Final: 20-20 Overs a Side"
				+ "\nTiming of the matches: 6.30 am – 5.30 pm (any time in between)"
				+ "\nImportant Points:"
				+ "\n-o-	More than one match can be scheduled for a team on a particular day."
				+ "\n-o-	All matches shall be conducted with red balls."
				+ "\n-o-	All teams must bring their own kits. No Kits shall be provided by the organizers."
				+ "\n-o-	New Ball shall be used in each innings."
				+ "\n-o-	In case of heavy rain, decision taken by umpires will be considered as final."
				+ "\n-o-	In case of any discrepancy/natural problems during finals or semi-finals, winner will be decided on the basis of point tally of league matches STRICTLY."
				+ "\n-o-Teams are requested to report the ground 15 minutes before the scheduled start time."
				+ "\n-o-	Walkover will be given to a team if the opponent team is not able to reach the ground within 15 minutes of the scheduled time."
				+ "\n-o-If there would be need of applying D/L rules, Umpire's decision will be final."
				+ "\n-o-	No team shall argue with umpires in any case as it would lead to cancellation of team registration and no refunds will be given. It could also attract proper disciplinary actions against the team."
				+ "\n-o-	All the matches are to be played on turf or mat wicket. The organizers reserve the right for the same. It is possible that some matches / some team may be played/play on turf pitches while some others on mat wicket."
				+ "\n-o-	No extra labor will be provided for any team help."
				+ "\n** RULES & SCHEDULE ARE SUBJECT TO CHANGE IN THE SPIRIT OF THE GAME & FESTIVAL AND THE FINAL DECISION RESTS WITH THE ORGANIZING UNIVERSITY ";
		
		rules = "-o-All rules & regulation as governed by ICC including LBW, Free Hit, Field Restrictions. Exceptions if any are mentioned below."
				+ "\n-o-	If either of the umpires believes that a team is wasting time/using foul language for the opponent team or even in their own team or over sledging, he can award a five-run penalty, at his own discretion. However, if it happens, thrice in the same match by a team, the opponent shall be declared winner. "
				+ "\n-o-	The interval lasts for 10 minutes & 5 minutes drinks break shall be granted in each innings between 8-10 Overs deepening on the request of either of the team or the decision of the umpires. "
				+ "\n-o-A match shall be deemed to have been played if and only if, each of the two teams has faced (or had the opportunity to face) five Overs."
				+ "\n-o-	Each match shall have two points. "
				+ "\n-o-	In case of tie in points at the league stage, the team having the best run rate shall qualify to the semi-finals. To calculate a team's net run rate, the average runs per over scored by that team is deducted from the average runs per over scored against it."
				+ "\n-o-	Only short-pitched ball is allowed per over."
				+ "\nField Restrictions"
				+ "\n-o-At the most, five fielders can be on the leg side, at any given point of time."
				+ "\n-o-For 20-20 Overs matches, the following field restriction shall applu"
				+ "\n-o-In the first 6 Overs, there cannot be more than two fielders outside the 30-Yard Circle "
				+ "\n-o-There can be a maximum of five fielders outside the fielding circle, after the first six overs end."
				+ "\n-o-For 15-15 Overs matches, the following field restriction shall applu"
				+ "\n-o-In the first 4 Overs, there cannot be more than two fielders outside the 30-Yard Circle "
				+ "\n-o-There can be a maximum of five fielders outside the fielding circle, after the first four overs end."
				+ "\n-o-For 12-12 Overs, the following field restriction shall apply "
				+ "\n-o-In the first 3 Overs, there cannot be more than two fielders outside the 30-Yard Circle "
				+ "\n-o-There can be a maximum of five fielders outside the fielding circle, after the first three overs end."
				+ "\n-o-The following shall be the time limit for completion of innings:"
				+ "\n-o-20 overs: 85 Minutes (+5 Minutes extra time) "
				+ "\n-o-15 Overs: 60 minutes (+5 Minutes extra time) "
				+ "\n-o-12 Overs: 50 minutes (+5 Minutes extra time) "
				+ "\n-o-If it fails to do so, extra six runs will be added to the batting team's score, for every whole over bowled after the expected minute-mark. In case the umpire believes that the batting team or some situational issue is wasting time, he may, 5 minutes extra as stated above."
				+ "\nTie Deciders"
				+ "\nTie is broken with a one over per side – Eliminator or Super Over. Each of the two teams nominates three batsmen and one bowler, to play a one-over per side, which can be termed as mini-match. If a team loses two wickets before the over is complete, it loses the game. If this does not happen, the team with the higher score from its over wins it. In case there is a tie after the mini-match as well, the team that has higher number of sixes in its full innings, or in the One1, will be declared the winner. If, by any chance, there is still a tie, the winning team is the one with the higher number of fours in both innings. "
				+ "\n** RULES & SCHEDULE ARE SUBJECT TO CHANGE IN THE SPIRIT OF THE GAME & FESTIVAL AND THE FINAL DECISION RESTS WITH THE HOST UNIVERSITY.";
		
		specification = "";
		
		criteria = "";
		
		contact = "Mr. Ajay"
				+ "\n+91-7837360375"
				+ "\nMr. Alok Pratap Singh"
				+ "\n+91-9041592540";
	}
	
	public static sports_cricket getInstance() {
		return new sports_cricket();
	}
}