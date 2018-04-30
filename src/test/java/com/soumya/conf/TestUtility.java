package com.soumya.conf;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class TestUtility {

	public static List<Proposal> proposals() {
		List<Proposal> proposals = new LinkedList<>();
		proposals.add(new Proposal("Writing Fast Tests Against Enterprise Rails", 60));
		proposals.add(new Proposal("Overdoing it in Python", 45));
		proposals.add(new Proposal("Lua for the Masses", 30));
		proposals.add(new Proposal("Ruby Errors from Mismatched Gem Versions", 45));
		proposals.add(new Proposal("Common Ruby Errors", 45));
		proposals.add(new Proposal("Rails for Python Developers", 5));
		proposals.add(new Proposal("Communicating Over Distance", 60));
		proposals.add(new Proposal("Accounting-Driven Development", 45));
		proposals.add(new Proposal("Woah", 30));
		proposals.add(new Proposal("Sit Down and Write", 30));
		proposals.add(new Proposal("Pair Programming vs Noise", 45));
		proposals.add(new Proposal("Rails Magic", 60));
		proposals.add(new Proposal("Ruby on Rails: Why We Should Move On", 60));
		proposals.add(new Proposal("Clojure Ate Scala (on my project)", 45));
		proposals.add(new Proposal("Programming in the Boondocks of Seattle", 30));
		proposals.add(new Proposal("Ruby vs. Clojure for Back-End Development", 30));
		proposals.add(new Proposal("Ruby on Rails Legacy App Maintenance", 60));
		proposals.add(new Proposal("A World Without HackerNews", 30));
		proposals.add(new Proposal("User Interface CSS in Rails Apps", 30));
		
		return proposals;
	}

	public static List<Proposal> proposalsForInsufficientSession() {
		List<Proposal> proposals = new ArrayList<>();
		proposals.add(new Proposal("Writing Fast Tests Against Enterprise Rails", 60));
		proposals.add(new Proposal("Overdoing it in Python", 45));
		proposals.add(new Proposal("Lua for the Masses", 30));
		
		return proposals;
	}

	public static List<Proposal> proposalsForInsufficientSecondSession() {
		List<Proposal> proposals = new ArrayList<>();
		proposals.add(new Proposal("Ruby on Rails: Why We Should Move On", 60));
		proposals.add(new Proposal("Common Ruby Errors", 45));
		proposals.add(new Proposal("Pair Programming vs Noise", 45));
		proposals.add(new Proposal("Programming in the Boondocks of Seattle", 30));
		proposals.add(new Proposal("Ruby vs. Clojure for Back-End Development", 30));
		proposals.add(new Proposal("User Interface CSS in Rails Apps", 30));
		return proposals;
	}

	public static final String ORGANIZER_TEST_RESULT = "\nTrack 1:\n" + 
														"09:00AM Writing Fast Tests Against Enterprise Rails 60min\n" + 
														"10:00AM Overdoing it in Python 45min\n" + 
														"10:45AM Lua for the Masses 30min\n" + 
														"11:15AM Ruby Errors from Mismatched Gem Versions 45min\n" + 
														"12:00PM Lunch 60min\n" + 
														"01:00PM Sit Down and Write 30min\n" + 
														"01:30PM Pair Programming vs Noise 45min\n" + 
														"02:15PM Rails Magic 60min\n" + 
														"03:15PM Ruby on Rails: Why We Should Move On 60min\n" + 
														"04:15PM Clojure Ate Scala (on my project) 45min\n" + 
														"05:00PM Networking Event " + 
														"\nTrack 2:\n" + 
														"09:00AM Woah 30min\n" + 
														"09:30AM Programming in the Boondocks of Seattle 30min\n" + 
														"10:00AM Ruby vs. Clojure for Back-End Development 30min\n" + 
														"10:30AM Ruby on Rails Legacy App Maintenance 60min\n" + 
														"11:30AM A World Without HackerNews 30min\n" + 
														"12:00PM Lunch 60min\n" + 
														"01:00PM Common Ruby Errors 45min\n" + 
														"01:45PM Rails for Python Developers lightning\n" + 
														"01:50PM Communicating Over Distance 60min\n" + 
														"02:50PM Accounting-Driven Development 45min\n" + 
														"03:35PM User Interface CSS in Rails Apps 30min\n" + 
														"04:05PM Networking Event ";
	
	public static final String TRACK_TEST_RESULT = "\nTrack 1:\n" + 
													"10:00AM Overdoing it in Python 45min\n"+ 
													"10:45AM Lua for the Masses 30min\n" + 
													"11:15AM Ruby Errors from Mismatched Gem Versions 45min";
	
	public static final String SESSION_FINDER_FIRST_SESSION_TEST_RESULT = 	"Writing Fast Tests Against Enterprise Rails 60\n"+
																			"Overdoing it in Python 45\n"+
																			"Lua for the Masses 30\n"+
																			"Ruby Errors from Mismatched Gem Versions 45";
	
	public static final String SESSION_FINDER_SECOND_SESSION_TEST_RESULT = 	"Sit Down and Write 30\n"+
																			"Pair Programming vs Noise 45\n"+
																			"Rails Magic 60\n"+
																			"Ruby on Rails: Why We Should Move On 60\n"+
																			"Clojure Ate Scala (on my project) 45";

}
