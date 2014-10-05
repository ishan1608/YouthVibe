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
					case 1:
						placeHolderEventDetails = techincal_mechatronix_robo_wrestle_mania.getInstance();
					break;
					case 2:
						placeHolderEventDetails = techincal_mechatronix_dark_horse.getInstance();
					break;
					case 3:
						placeHolderEventDetails = techincal_mechatronix_gear_up.getInstance();
					break;
					case 4:
						placeHolderEventDetails = techincal_mechatronix_aviator.getInstance();
					break;
					case 5:
						placeHolderEventDetails = techincal_mechatronix_aqua_jet.getInstance();
					break;
					case 6:
						placeHolderEventDetails = techincal_mechatronix_circuitiry.getInstance();
					break;
					default:
						placeHolderEventDetails = event_name.getInstance();
					break;
				}
			break;
			case 1:
				switch(eventPosition) {
					case 0:
						placeHolderEventDetails = techincal_abacus_web_builder.getInstance();
					break;
					case 1:
						placeHolderEventDetails = techincal_abacus_image_masher.getInstance();
					break;
					case 2:
						placeHolderEventDetails = techincal_abacus_make_ur_own_network.getInstance();
					break;
					case 3:
						placeHolderEventDetails = techincal_abacus_algo_designer.getInstance();
					break;
					case 4:
						placeHolderEventDetails = techincal_abacus_master_o_codes.getInstance();
					break;
					case 5:
						placeHolderEventDetails = techincal_abacus_just_in_a_sec.getInstance();
					break;
					case 6:
						placeHolderEventDetails = techincal_abacus_tic_tac_toe.getInstance();
					break;
					default:
						placeHolderEventDetails = event_name.getInstance();
					break;
				}
			break;
			case 2:
				switch(eventPosition) {
					case 0:
						placeHolderEventDetails = techincal_presentor_paper_presentation.getInstance();
					break;
					case 1:
						placeHolderEventDetails = techincal_presentor_project_presentation.getInstance();
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

/*
 * A class to contain the details of events.
 * This must be extended before used.
 */
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

/*
 * PlaceHolder for the eventDetails sub object, works also as a Sample
 */
class event_name extends EventDetails {
	
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

class techincal_mechatronix_robo_wrestle_mania extends EventDetails {
	
	public techincal_mechatronix_robo_wrestle_mania() {
		description = "Be a WARRIOR....not a WORRIER"
					+ "\nWarrior do not win victories by beating their heads against walls,but by overtaking the walls. Warrior jump over walls ....they don’t demolish them."
					+ "\nType of event: Team"
					+ "\nTeam Size: 4";
		
		rules = "01. The competition will be played on a knock-out basis."
					+ "\n02. In no case, arena should be damaged by the bot."
					+ "\n03. The team may consist a maximum of 3 members only"
					+ "\n04. One individual cannot be a member of more than one team for the event."
					+ "\n05. Use of IC ENGINE is not allowed."
					+ "\n06. On board batteries must be sealed, immobilized-electrolyte types (such as gels, lithium, NiCad, NiMH, or dry cells).";
		
		specification = "Bot Specification:"
					+ "\n01. The machine should fit in a box of dimension 750mm x 750mm x 1000 mm (l x b x h) at any given point during the match. The external device used to control the machine or any external tank is not included in the size constraint."
					+ "\n02. The machine should not exceed 40 kg of weight including the weight of pneumatic source/tank. All pneumatic tanks/source and batteries should be onboard. Weight of remote controller will not be counted."
					+ "\nArena Specifications:"
					+ "\n01. The arena would be rectangular in shape measuring 24ftx24ft, however the fighting zone will 20ftx20ft."
					+ "\n02. The arena might be on hard and uneven ground and would be enclosed by wire meshes all around."
					+ "\nPower Supply & Robot control: 01. The machine can be powered electrically only. The electric voltage between 2 points anywhere in the machine should not be more than 36V DC at any point of time. If a team is using AC voltage in any of its parts then the voltage should not exceed 36V AC at any point of time as well."
					+ "\n02. The machine could be controlled using a wired or wireless device throughout the fight. In case of wireless control, the robot must be installed with a dual frequency radio to prevent interference with the opponent’s robot. In case of any interference in the wireless systems, no possibility of rematch exists."
					+ "\n03. Readily available remote controlled systems with dual frequency from the markets may be used."
					+ "\n04. Before the event, each robot will be inspected by the judges and if robot is declared as dangerous either to the spectators or the course of the event, it may be disqualified on the spot."
					+ "\nWeapon Systems:"
					+ "\n01. Robots can have any kind of magnetic weapons, cutters, flippers, saws, lifting devices, spinning hammers etc. as weapons with following exceptions and limitations:"
					+ "\nLiquid projectiles."
					+ "\nAny kind of inflammable liquid."
					+ "\nFlame-based weapons."
					+ "\nAny kind of explosive or intentionally ignited solid or potentially ignitable solid."
					+ "\nNets, tape, glue, or any other entanglement device."
					+ "\nHigh power magnets or electromagnets."
					+ "\nRadio jamming, Lasers, tesla coils, or any other high-voltage device."
					+ "\nTethered or un-tethered projectiles."
					+ "\nSpinning weapons which do not come in contact with the arena at any point of time are allowed.";
		
		criteria = "01. A robot is declared victorious if its opponent is immobilized."
					+ "\n02. A robot will be declared immobile if it cannot display linear motion of at least one inch in a timed period of 30 seconds. A bot with one side of its drive train disabled will not be counted out if it can demonstrate some degree of controlled movement. In case both the robots remain mobile after the end of the round then the winner will be decided subjectively."
					+ "\n03. A robot that is deemed unsafe by the judges after the match has begun will be disqualified and therefore declared the loser. The match will be immediately halted and the opponent will be awarded a win."
					+ "\n04. Robots cannot win by pinning or lifting their opponents. Organizers will allow pinning or lifting for a maximum of 20 seconds per pin/lift then the attacker robot will be instructed to release the opponent. If, after being instructed to do so, the attacker is able to release but does not, their robot may be disqualified. If two or more robots become entangled or a crushing or gripping weapon is employed and becomes trapped within another robot, then the competitors should make the timekeeper aware, the fight should be stopped and the robots should be separated by the safest means."
					+ "\n05. If a robot is thrown out of the arena the match will stop immediately, and the robot still inside the arena will automatically be declared as the winner.";
		
		contact = "Mr. Bikram Sarmah"
					+ "\n+91 9646056969";
	}
	
	public static techincal_mechatronix_robo_wrestle_mania getInstance() {
		return new techincal_mechatronix_robo_wrestle_mania();
	}
}

class techincal_mechatronix_dark_horse extends EventDetails {
	
	public techincal_mechatronix_dark_horse() {
		description = "Be an AWESOME CONTROLLER...!!!"
					+ "\nSensing a line and maneuvering the robot to stay on course, while constantly correcting wrong moves using feedback mechanism forms a simple yet effective closed loop system. As a programmer you get an opportunity to ‘teach’ the robot how to follow the line thus giving it a human-like property of responding to stimuli."
					+ "\nType of event: Team"
					+ "\nTeam Size: 4";
		
		rules = "01. Course Time: time is measured from the time the robot crosses the starting line until the time it crosses the finish line. A robot is deemed to have crossed the line when the forward most wheel, track, or leg of the robot contacts or crosses over the line."
					+ "\n02. Time Limit: a maximum of 3 minutes is allowed for a robot to complete the course. A robot that cannot complete the course in the allotted time shall be disqualified."
					+ "\n03. Timekeeping: time shall be measured by an electronic gate system or by a judge with a stopwatch, based on the availability of equipment. In either case the recorded time shall be final."
					+ "\n04. Autonomous Control: once a robot has crossed the starting line it must remain fully autonomous, or it will be disqualified."
					+ "\n05. Arena Edges: a robot that wanders off of the arena surface will be disqualified. A robot shall be deemed to have left the arena when any wheel, leg, or track has moved completely off the arena surface."
					+ "\n06. Losing the Line: any robot that loses the line course must reacquire the line at the point where it was lost, or at any earlier (e.g. already traversed) point."
					+ "\n07. Second Attempt: any robot that loses the line course and fails to reacquire it will be allowed a single reattempt. The robot must start the course again from the beginning, and if it loses the line course on its second attempt it will be disqualified."
					+ "\n08. Power of Officials: the decisions of all officials regarding these rules and the conduct of the event shall be final."
					+ "\nb. There would be obstacles and a well-defined maze for your boat to follow without hitting the boundaries of the maze.";
		
		specification = "Team specifications:"
					+ "\n01. A Team must contain only 4 members."
					+ "\nBot Specifications:"
					+ "\n02. Size and Weight Limits: The maximum size of a robot is 30 x 30 cm, the maximum weight is 3 kg.Dimensional and weight limits for robots shall be strictly enforced. Robots must have passed inspection prior to competing."
					+ "\nCourse Specifications:"
					+ "\n03. The line following course shall traverse a white paper rectangle, 44\" wide and 96\" long. The line shall be a black, 1/2\" wide line traversing the arena from end to end. There shall be no crossovers (e.g. places where the line crosses itself). Switchbacks and hairpins are possible, but the adjacent sections of the line shall be no closer together than 15cm when measured from the center of each line. The line course shall have 1 or more sharp right-angle, but no angle will be greater than 90 degrees.";
		
		criteria = "01. The robot to complete the course in the shortest period of time while accurately tracking the course line from start to finish wins.";
		
		contact = "Mr. Bikram Sarmah"
					+ "\n+91 9646056969";
	}
	
	public static techincal_mechatronix_dark_horse getInstance() {
		return new techincal_mechatronix_dark_horse();
	}
}

class techincal_mechatronix_gear_up extends EventDetails {
	
	public techincal_mechatronix_gear_up() {
		description = "Nitro Truggy....Ready to Run"
					+ "\nEver wanted to feel the power of the driving force of the F1 cars and the monster trucks? Does your adrenaline level rush up after hearing the voice of an IC engine? Come and build your own beast machine at Full Throttle. There is a great opportunity to build your own IC car and prove your mettle against other racers on the track at Full Throttle: The chase."
					+ "\nType of event: Team"
					+ "\nTeam Size: 4";
		
		rules = "01. A Team must contain only FOUR (4) members"
					+ "\n02. Use of any other sources such as chemicals, compressed gas, rockets etc. for propulsion is not allowed."
					+ "\n03. If you are making your car then other functional parts like motors and servos, gears, springs, engine, remote control systems, batteries, wheels, braking mechanisms are allowed to be used as directly available from the market."
					+ "\na. Verify with the organizers if you have the slightest doubt whether component can be used or not."
					+ "\nb. The electric voltage anywhere in the machine should not exceed 12V at any point of time."
					+ "\nc. If a machine tumbles or halts or goes off the arena at any point in the track, only one of the participants is allowed to lift it up and placed it at the nearest checkpoint behind that point.(Previous two rules are for non-racing rounds. The rules for racing round will be told on the spot.)"
					+ "\nd. The vehicles have to be fully controlled using only the remote control unless there is need to touch the vehicle as stated above."
					+ "\na. There will be a time penalty every time the machine requires lifting by the team member."
					+ "\nb. The teams are also not allowed to damage the opponents vehicle deliberately. If found guilty, the accused team would be disqualified"
					+ "\n10. Depending upon the number of teams participating and other time constraints, the arena will be given to the participants for practicing. The time slots will be given on the basis of first come first serve basis, but little duration for practicing is assured to everyone."
					+ "\n11. Organizers reserve the right to change any of the above rules. The same would be highlighted in the LPU website or youth vibe page."
					+ "\n12. Organizers and judge’s decision shall be considered as final and binding on all.";
		
		specification = "01. Vehicle Specifications: Machine should fit in a box of dimensions 700mm x 500mm x 600mm at any moment of time during the race. The external device which is used to control the machine is not included in the size constraint."
					+ "\n02. The machine should use DC Motor for propulsion. DC Motors and servos could be used for steering mechanisms or any other control mechanisms apart from propulsion."
					+ "\n03. The machine should be controlled by a wireless remote control mechanism throughout the race."
					+ "\n04. The vehicle must have two remote control of different frequencies or an alternate frequency remote control which can be switched to either frequency before the start of the game. This is done to avoid frequency interference between the two competing vehicles. Remote control systems from toys can also be used."
					+ "\n05. The vehicles can be ready made (car should be self-assembled).But there will be extra points if you make chassis and steering mechanisms by yourself (see judging criteria for more detail)."
					+ "\n06. The machine must have an on-board power supply to run any mechanism requiring electric power."
					+ "\nTrack Specifications:"
					+ "\n01. The minimum width of the track will be 1m."
					+ "\n02. The track will have check points at regular intervals.";
		
		criteria = "01. SCORING PATTERN:";
		
		contact = "Mr. Bikram Sarmah"
					+ "\n+91 9646056969";
	}
	
	public static techincal_mechatronix_gear_up getInstance() {
		return new techincal_mechatronix_gear_up();
	}
}

class techincal_mechatronix_aviator extends EventDetails {
	
	public techincal_mechatronix_aviator() {
		description = "\"OVERVIEW:\""
					+ "\nHide me in the shadow of your wings"
					+ "\nCall it what you like it's not a defense."
					+ "\n\nType of event: Team"
					+ "\nTeam Size: 4";
		
		rules = "01. Team may have a maximum of 3 members only."
					+ "\n02. A stopwatch will be used to measure the time of flight."
					+ "\n03. The duration shall include the time when the glider is launched and until it touches the ground in the first instance."
					+ "\04. The time for the motion of the glider after the touching the ground once is not included.";
		
		specification = "";
		criteria = "01. Distance travelled"
					+ "\n5 point per meter (0-20meters)"
					+ "\n7 point per meter (after 20 meters)"
					+ "\nDistance points (P1) = x * 5 (if x <= 20)"
					+ "\nDistance points (P1) = (20 * 5) +((x -20) *7) (if x>=20)"
					+ "\n\n02. Time of Flight:"
					+ "\n10 per seconds."
					+ "\nTime points (P2) = 10 * (no of seconds of time of flight)"
					+ "\n03. Vertical Loops"
					+ "\n30 for first."
					+ "\n40 for second, third, . . . etc."
					+ "\nP3 = 30 + (40 * (no of vertical loops - 1)) [more than 1 vertical loop]"
					+ "\nP3 = 30 [for only one vertical loop]"
					+ "\nP3 = 0 [for zero vertical loops]"
					+ "\n04. Side Loop:"
					+ "\n10 point per loop."
					+ "\nP4 = 10 * (no of side loops)"
					+ "\n05. COMBO(Vertical + Side Loop):"
					+ "\n30+15 points per loop"
					+ "\nP5 = 45 * (no of combo loops)"
					+ "\n06. Smooth Landing:"
					+ "\n5 points."
					+ "\nP6 = 5 (maximum points)"
					+ "\n07. Flying between the poles(in arena):"
					+ "\n10 points."
					+ "\nP7 = 10"
					+ "\n08. A team with maximum points will be declared as winner."
					+ "\nTotal points = P1 + P2 + P3 + P4 + P5 + P6 + P7"
					+ "\n09. Organizers reserve the right to change any of the above rules. The same would be highlighted in the LPU website or youth vibe page."
					+ "\n09. Organizers and judge’s decision shall be considered as final and binding on all. ";
		
		contact = "Mr. Bikram Sarmah"
					+ "\n+91 9646056969";
	}
	
	public static techincal_mechatronix_aviator getInstance() {
		return new techincal_mechatronix_aviator();
	}
}

class techincal_mechatronix_aqua_jet extends EventDetails {
	
	public techincal_mechatronix_aqua_jet() {
		description = "\"Be a Rocket Surgeon....!!!\""
					+ "\nA rocket is an experiment; a star is an observation. LPU presents to you a platform to make your own rocket. Larger the distance the rocket covers, the better it is. This event will not only focus on the maximum range but accuracy as well."
					+ "\n\nType of event: Team"
					+ "\nTeam Size: 4";
		
		rules = "1. The event will be held in a total of THREE ROUNDS:"
					+ "\nROUND 01: a. Longest range possible for the rocket is tested in this round."
					+ "\nb. Each team will be given 3 Trials. Best of the three is taken into consideration."
					+ "\nc. Teams should not change/make modifications to their rocket in this round (i.e. same rocket should be used for 3 trails)."
					+ "\nd. Maximum Pressure Should is 70psi. "
					+ "\ne Teams can use other means like ball, flaps, wings etc.., to maintain gravity but they"
					+ "\nshould not get detached from the rocket during the flight."
					+ "\nThe team will be disqualified if something happens like that. "
					+ "\nROUND 2:(BULL'S EYE)"
					+ "\na. Participating teams are asked to show their rocket's accuracy if the target is fixed."
					+ "\nb. One can make modifications to his/her water rocket or use other rocket."
					+ "\nc. Each participating team will be given 2 Trials. Best of the two is taken into consideration."
					+ "\nd. There are 5 concentric circles .The center of the circles is 100 feet away from the point of launching."
					+ "\ne. The Angle of Inclination of the Launcher with the ground should be 45 degrees."
					+ "\nf. Maximum Pressure should be 70psi."
					+ "\ng. Radii of the circles are 3 feet, 5 feet, 7 feet, 10feet and 15 feet respectively. Points will be given correspondingly. "
					+ "\nROUND 3: a. In case of tie, this round will be conducted. This round is a test for the aerodynamics of the water rocket. With specified pressure (very less and optimum which is decided by the judges), they should achieve maximum range.";
		
		specification = "01. A Team may contain maximum of 3 members."
					+ "\n02. One should bring his/her own launching Platform (that can be fitted to foot pump with pressure gauge)."
					+ "\n03. There should me angle measurements on the launching platform."
					+ "\n04. Soft drinks /Aerated water are not allowed."
					+ "\n05. Chemical propellants are strictly prohibited."
					+ "\n06. Boosters are not allowed."
					+ "\n07. Water for the event will be supplied.";
		
		criteria = "01. SCORING PATTERN:"
					+ "\nROUND1:Range (FEET): Points"
					+ "\nX>400:100"
					+ "\n400>X>=350:80"
					+ "\n350>X>=300:70"
					+ "\n300>X>=250:50"
					+ "\n250>X>=200:30"
					+ "\n200>X>=150:20"
					+ "\nX<150:10"
					+ "\nROUND2: Distance from the center (FEET): Points"
					+ "\nR<1:100"
					+ "\n1<=R < 3: 70"
					+ "\n3 < =R < 5: 50"
					+ "\n5 <= R < 7: 30"
					+ "\n7 < =R < 10: 20"
					+ "\n10 < R < 15: 10"
					+ "\nTotal points = (points in round 1) + (points in round 2)"
					+ "\nTeam with highest points would be declared as the winner.";
		
		contact = "Mr. Bikram Sarmah"
					+ "\n+91 9646056969";
	}
	
	public static techincal_mechatronix_aqua_jet getInstance() {
		return new techincal_mechatronix_aqua_jet();
	}
}

class techincal_mechatronix_circuitiry extends EventDetails {
	
	public techincal_mechatronix_circuitiry() {
		description = "Is their a Digital Circuit inside you...???"
					+ "\nAre you an electronics buff? Do you want to concert theoretical knowledge into a practical application?"
					+ "\nCan you do it fast enough? Then, Circuit Design Challenge is the place for you."
					+ "\n\nType of event: Team"
					+ "\nTeam Size: 3";
		
		rules = "01. The rounds are open in nature, you will be provided question sheets/components on the registration desk and you need to submit them back within the specified time limit"
					+ "\n02. Power supply and other testing deices like multimeter, CRO (if needed) and other tools will be made available in a specified laboratory."
					+ "\n03. You must design the circuit by using the components proided by us. You may not use any other component/material however in case something got damaged you may request the organizer to replace the components/parts."
					+ "\n04. Please take note, all necessary inventory will be provided by us. Any additional unnecessary inventory requirements will not be entertained."
					+ "\n05. Teams should draw circuit diagram of the application depicting all the principles and theories involved in circuit as well as the working of the Application on a Chart Sheet."
					+ "\n06. The decision of the judges will be final and binding.";
		
		specification = "";
		
		criteria = "01. Design of circuit"
					+ "\n02. Compactness of design"
					+ "\n03. Efficiency of the application"
					+ "\n04. Desired output"
					+ "\n05. Exploration of concepts/theories"
					+ "\n06. Breadboarding skills/neatness of the implemented circuit"
					+ "\n07. In case of incomplete solution, it shall be judged on the method of approach and closeness to the real solution.";
		
		contact = "Mr. Bikram Sarmah"
					+ "\n+91 9646056969";
	}
	
	public static techincal_mechatronix_circuitiry getInstance() {
		return new techincal_mechatronix_circuitiry();
	}
}

class techincal_abacus_web_builder extends EventDetails {
	
	public techincal_abacus_web_builder() {
		description = "Participants have to develop a dynamic website using any of the below technologies:"
						+ "\n1. PHP"
						+ "\n2. JSP"
						+ "\n3. ASP or ASP.Net"
						+ "\n4. HTML5"
						+ "\nTopic of the website will be given on the day of the event only."
						+ "\n\nType of event: Team"
						+ "\n\nTeam Size: 2";
		
		rules = "01. 1. Each team will comprise of 2 members."
				+ "\n02. 2. The time for the development of application will be 3 hours only."
				+ "\n03. 3. Computer Labs will be provided to the participants for the development."
				+ "\n04. 4. Topic will be given on the day of event."
				+ "\n\n** Note : Participants registering for this event must bring their own laptop with the required software (in case of any problem with computer labs).";
		
		specification = "";
		
		criteria = "01. Design of the webpage and also the concept used in building the webpage."
					+ "\n02. In case of a tie, the teams that tie will be given a problem and the winner will be declared on the basis of time taken to solve that problem."
					+ "\n03. Line of Codes in the program."
					+ "\n04. Time complexity of the code i.e. execution time.";
		
		contact = "Mr. Bikram Sarmah"
					+ "\n+91 9646056969";
	}
	
	public static techincal_abacus_web_builder getInstance() {
		return new techincal_abacus_web_builder();
	}
}

class techincal_abacus_image_masher extends EventDetails {
	
	public techincal_abacus_image_masher() {
		description = "It takes time,training and talent to learn...and to use properly..!!\" Participants have to use their creativity skills using Adobe Photoshop to improve an image."
						+ "\n\nType of event: Individual";
		
		rules = "01. Participants have to bring their own laptop with Adobe Photoshop software preinstalled."
				+ "\n02. It is an individual event."
				+ "\n\n03. Image will be given on the spot only."
				+ "\n04. This event will be of 60 minutes."
				+ "\n05. Internet access is strictly restricted.";
		
		specification = "01. Innovation, creativity and design should be attractive."
						+ "\n02. Use of all the methods and functions of the software."
						+ "\n03. Image should resemble a message."
						+ "\n04. Color combination should not be loud.";
		
		criteria = "";
		
		contact = "Mr. Bikram Sarmah"
					+ "\n+91 9646056969";
	}
	
	public static techincal_abacus_image_masher getInstance() {
		return new techincal_abacus_image_masher();
	}
}

class techincal_abacus_make_ur_own_network extends EventDetails {
	
	public techincal_abacus_make_ur_own_network() {
		description = "Using Cisco Packet Tracer software design an effective working network and stimulate the network. By sending a message through different nodes and routers."
						+ "\n\nType of event: Individual";
		
		rules = "01. Participants have to bring their own laptop with Cisco Packet Tracer software preinstalled."
				+ "\n02. It is an individual event."
				+ "\n03. Scenario will be given on the spot only."
				+ "\n04. This event will be of 60 minutes."
				+ "\n05. Internet access is strictly restricted."
				+ "\n06. Use of Correct devices. ";
		
		specification = "01. Efficient used of devices."
						+ "\n02. Number of devices used."
						+ "\n03. Minimum time taken in completion of the given scenario."
						+ "\n04. Types of wire and devices used according to the scenario.";
		
		criteria = "";
		
		contact = "Mr. Bikram Sarmah"
					+ "\n+91 9646056969";
	}
	
	public static techincal_abacus_make_ur_own_network getInstance() {
		return new techincal_abacus_make_ur_own_network();
	}
}

class techincal_abacus_algo_designer extends EventDetails {
	
	public techincal_abacus_algo_designer() {
		description = "\"Experiment...Design....Analyze..and Implement..!!!\""
					+ "\n\nType of event: Team"
					+ "\n\nTeam Size: 2";
		
		rules = "01. Allocated Time for different Rounds are:"
				+ "\n>> Round 1 - 20 Minutes"
				+ "\n>> Round 2 - 30 Minutes"
				+ "\n>> Round 3 - 90 Minutes"
				+ "\n\n02. Participants have to bring their own laptop for level 3."
				+ "\n03. Topic will be given on the day event.";
		
		specification = "";
		
		criteria = "01. Number of lines of algorithm"
					+ "\n02. Complexity of the algorithm."
					+ "\n03. Execution of the algorithm.";
		
		contact = "Mr. Bikram Sarmah"
				+ "\n+91 9646056969";
	}
	
	public static techincal_abacus_algo_designer getInstance() {
		return new techincal_abacus_algo_designer();
	}
}

class techincal_abacus_master_o_codes extends EventDetails {
	
	public techincal_abacus_master_o_codes() {
		description = "It is a 3 hour coding contest. The teams will write codes for solving some of the trickiest numerical problems which can't usually be solved by using a calculator. Problems based on mathematical intricacies, statistical inferences, physics, seepage, real-life situations and other related stuff will be given on the day of the competition and the participants have to solve them and give the final answer (Participants will be asked for the codes used to solve the problem)."
						+ "\n\nType of event: Team"
						+ "\n\nTeam Size: 2";
		
		rules = "01. A team may contain 2 Members."
				+ "\n02. 2. The allowed programming languages are:"
				+ "\n\t1. C"
				+ "\n\t2. C++"
				+ "\n\t3. Java"
				+ "\n\t4. Python"
				+ "\n\t5. Perl"
				+ "\n\n03. 3. Note that at any point of time, the latest information will be that which is on the site. The information provided in the pdf downloaded earlier may not be the latest. However, registered participants will be informed through mail about any such changes."
				+ "\n04. 4. Participants have to bring their own laptops during the competition. ";
		
		specification = "";
		
		criteria = "01. The exact marking scheme will be disclosed later."
					+ "\n02. 2. In case of a tie, the teams that tie will be given a problem and the winner will be declared on the basis of time taken to solve that problem."
					+ "\n03. Line of Codes in the program."
					+ "\n04. Time complexity of the code i.e. execution time.";
		
		contact = "Mr. Bikram Sarmah"
				+ "\n+91 9646056969";
	}
	
	public static techincal_abacus_master_o_codes getInstance() {
		return new techincal_abacus_master_o_codes();
	}
}

class techincal_abacus_just_in_a_sec extends EventDetails {
	
	public techincal_abacus_just_in_a_sec() {
		description = "Do you feel your brain/'s rusty and needs a quick workout? Is your sharp brain the metaphorical equivalent of a six pack? Put it to the test. Fast and curious is the perfect battling ground for speed and skill. Solve problems as fast as you can. The fittest survives."
						+ "\n\nType of event: Individual";
		
		rules = "01. This is an individual quizzing event."
				+ "\n02. Engineering concepts are the domain of the questions."
				+ "\n03. There will be 30 questions in each round."
				+ "\nRound 1:"
				+ "\nDifficulty level: Easy."
				+ "\nTime limit is 45 minutes."
				+ "\nEvery correctly answered question will be awarded 2 points."
				+ "\nEvery wrong answered question will be awarded -1 point."
				+ "\nRound 2: Difficulty level: Medium."
				+ "\nTime limit is 40 minutes."
				+ "\nEvery correctly answered question will be awarded 5 points."
				+ "\nEvery wrong answered question will be awarded -3 points."
				+ "\nRound 3:"
				+ "\nDifficulty level: Hard."
				+ "\nTime limit is 30 minutes."
				+ "\nEvery correct answered question will be awarded 10 points."
				+ "\nEvery wrong answered question will be awarded -5 points.";
		
		specification = "";
		
		criteria = "01. The participant with more points will be declared as the winner."
					+ "\n02. Judges decision will be abiding and final.";
		
		contact = "Mr. Bikram Sarmah"
				+ "\n+91 9646056969";
	}
	
	public static techincal_abacus_just_in_a_sec getInstance() {
		return new techincal_abacus_just_in_a_sec();
	}
}

class techincal_abacus_tic_tac_toe extends EventDetails {
	
	public techincal_abacus_tic_tac_toe() {
		description = "PROBLEM STATEMENT: "
						+ "\nThink you are a professional at beating your friends at Tic-Tac-Toe? Think again! Because this time circles and crosses come to you only if you overcome the hurdles."
						+ "\n\nType of event: Individual";
		
		rules = "01. This is an individual event."
				+ "\n02. Traditional Tic-Tac-Toe rules apply."
				+ "\n03. Every player will be asked a question before he fills the grid. If the answer to question is right participant gets to fill the selected grid with his symbol and if he answers wrong, no change in the 3x3 grid, and turn passes over to the other participant. Physics is the domain of the questions."
				+ "\n04. If both the participants fail to end the game(ie.,win or tie) before the time limit, both of them will be declared DISQUALIFIED."
				+ "\n05. Only Even Number of participants will qualify to the next round. In case of odd number of participants remaining after a round, the participant with the maximum time to finish the round, will be eliminated. In case of maximum time being same, for two qualifying participants in the Xth round, maximum time of the (X-1)th round will be taken into consideration, for elimination. If in case there is tie in the maximum time, in the first round, the number of questions attempted will be taken into consideration. The winner will qualify to the next round and a FINAL WINNER will be chosen after successive rounds."
				+ "\n06. Time limit for each round is 7min. ";
		
		specification = "";
		
		criteria = "01. The winner of the round will be decided upon normal tic tac toe rules. "
					+ "\nIterating this procedure through consecutive rounds will zero down to the winner."
					+ "\n02. Judges decision will be final and abiding to all";
		
		contact = "Mr. Shahbaz Khan"
					+ "\nPhone no: 7814380230";
	}
	
	public static techincal_abacus_tic_tac_toe getInstance() {
		return new techincal_abacus_tic_tac_toe();
	}
}

class techincal_presentor_paper_presentation extends EventDetails {
	
	public techincal_presentor_paper_presentation() {
		description = "\"Be So Good....They can't ignore you!!!!\""
						+ "\n\nLPU welcomes presentations in various fields of Science and Engineering for youth vibe, it is sure to provide you unparalleled an academic experience. The presentation competition at LPU features projects from a variety of scientific research areas. With categories dedicated to both evergreen fields like infrastructure and also new frontiers of technology as simulations, we assure you a platform beyond compare."
						+ "\n\nType of event: Team"
						+ "\n\nTeam Size: 3"
						+ "\n\n\nCategories"
						+ "The following are descriptions of the 15 categories under which projects can be presented: "
						+ "\n01.	Automation"
						+ "\n02.	Communication and Network systems"
						+ "\n03.	Design appliances"
						+ "\n04.	Economic modeling and finance"
						+ "\n05.	Health and Nutrition"
						+ "\n06.	Energy and environment"
						+ "\n07.	Infrastructure"
						+ "\n08.	Industrial processes and applications"
						+ "\n09.	Material sciences"
						+ "\n10.	Pure sciences"
						+ "\n11.	Software design(application development)"
						+ "\n12.	Software design(adaptive technology)"
						+ "\n13.	Signal processing"
						+ "\n14.	Transportation"
						+ "\n15.	Simulation and mathematical modeling";
		
		rules = "01. A team must contain only 3 members."
				+ "\n02. A team shall be clear in their ideas while presenting."
				+ "\n03. The presentation should be of 10 minutes and no extra time would be provided."
				+ "\n04. Abstract must be submitted before the specified date.(date will be published on the website)."
				+ "\n05. Topic chosen should me mentioned in the abstract as well as at the starting of presentation. ";
		
		specification = "";
		
		criteria = "01. Marks will be given on the basis of your presentation skills, communication skills, confidence, creativity, display of content, future applications, feasibility, reliability, effect on environment, cost effectiveness etc."
					+ "\n02. Judges decision shall be abiding and final.";
		
		contact = "Mr. Shahbaz Khan"
					+ "\nPhone no: 7814380230";
	}
	
	public static techincal_presentor_paper_presentation getInstance() {
		return new techincal_presentor_paper_presentation();
	}
}

class techincal_presentor_project_presentation extends EventDetails {
	
	public techincal_presentor_project_presentation() {
		description = "Coming Soon";
		
		rules = "";
		
		specification = "";
		
		criteria = "";
		
		contact = "";
	}
	
	public static techincal_presentor_project_presentation getInstance() {
		return new techincal_presentor_project_presentation();
	}
}