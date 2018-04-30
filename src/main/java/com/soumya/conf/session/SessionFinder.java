package com.soumya.conf.session;

import static java.time.temporal.ChronoUnit.MINUTES;

import java.util.List;

import com.soumya.conf.Proposal;
import com.soumya.conf.organize.Organizer;
import com.soumya.conf.util.Schedule;

/**
 * <tt>SessionFinder</tt> is an interface. It provides APIs to find sessions. 
 * 
 * @author Soumyakanta Mohapatra
 * 
 * @see Organizer
 * @see Proposal
 *
 */
public interface SessionFinder {

	int FIRST_SESSION_DURATION = 180;
	
	int SECOND_SESSION_DURATION_MIN = 180;
	
	int SECOND_SESSION_DURATION_MAX = 240;

	List<Proposal> findFirstSession(List<Proposal> proposals);

	List<Proposal> findSecondSession(List<Proposal> proposals);

	default boolean isNullOrEmpty(List<Proposal> proposals) {
		return proposals == null || proposals.isEmpty();
	}

	default int lunchDuration() {
		return (int)Schedule.Lunch.startTime.until(Schedule.SecondSession.startTime, MINUTES);
	}

	default int proposalDuration(List<Proposal> proposals){
		return proposals.stream().mapToInt(Proposal::getDurationInMinutes).sum();
	}

	default int maxProposalDuration(List<List<Proposal>> proposalsList) {
		return proposalsList.stream().mapToInt(p -> proposalDuration(p)).max().getAsInt();
	}

	default List<Proposal> findOptimalProposals(List<List<Proposal>> proposalsList) {
		return proposalsList.stream().filter(p -> proposalDuration(p) == maxProposalDuration(proposalsList)).findAny().get();
	}
}
