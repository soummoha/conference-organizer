package com.soumya.conf.session;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import com.soumya.conf.Proposal;
import com.soumya.conf.organize.Organizer;
import com.soumya.conf.util.LogLevel;
import com.soumya.conf.util.Response;

/**
 * <tt>SessionFinderImpl</tt> implements <tt>SessionFinder</tt> interface. It
 * provides implementation to find First Sessions and Second Sessions
 * 
 * @author Soumyakanta Mohapatra
 * 
 * @see Organizer
 * @see Proposal
 * @see SessionFinder
 *
 */
public class SessionFinderImpl implements SessionFinder {

	/**
	 * Provides implementation to find suitable proposals for first session from
	 * a list of available proposals.
	 * 
	 * @param proposals
	 *            available
	 * @return proposals for first session
	 */
	@Override
	public List<Proposal> findFirstSession(List<Proposal> proposals) {
		Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": findFirstSession start");
		if (isNullOrEmpty(proposals)) {
			Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": findFirstSession end");
			return null;
		}
		int index = 0;
		while (index < proposals.size()) {
			List<Proposal> selectedProposals = new ArrayList<>();
			for (int i = index; i < proposals.size(); i++) {
				selectedProposals.add(proposals.get(i));
				int selectedProposalDuration = proposalDuration(selectedProposals);
				if (FIRST_SESSION_DURATION == selectedProposalDuration) {
					Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": findFirstSession end");
					return selectedProposals;
				}
			}
			index++;
		}
		Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": findFirstSession end");
		return null;
	}

	/**
	 * Provides implementation to find suitable proposals for second session
	 * from a list of available proposals.
	 * 
	 * @param proposals
	 *            available
	 * @return proposals for second session
	 */
	@Override
	public List<Proposal> findSecondSession(List<Proposal> proposals) {
		Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": findSecondSession start");
		if (isNullOrEmpty(proposals)) {
			Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": findSecondSession end");
			return null;
		}
		int index = 0;
		List<List<Proposal>> acceptedListOfProposals = new ArrayList<>();
		while (index < proposals.size()) {
			List<Proposal> selectedProposals = new ArrayList<>();
			for (int i = index; i < proposals.size(); i++) {
				selectedProposals.add(proposals.get(i));
				int selectedProposalsDuration = proposalDuration(selectedProposals);
				if( selectedProposalsDuration > SECOND_SESSION_DURATION_MAX ){
					break;
				}
				if (selectedProposalsDuration >= SECOND_SESSION_DURATION_MIN) {
					List<Proposal> acceptedProposals = selectedProposals.stream().collect(toList());
					acceptedListOfProposals.add(acceptedProposals);
				}
			}
			index++;
		}

		if (acceptedListOfProposals.isEmpty()) {
			Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": findSecondSession end");
			return null;
		}
		List<Proposal> response = findOptimalProposals(acceptedListOfProposals);
		Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": findSecondSession end");
		return response;
	}

}
