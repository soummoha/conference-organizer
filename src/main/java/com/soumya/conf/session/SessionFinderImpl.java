package com.soumya.conf.session;

import java.util.ArrayList;
import java.util.List;

import com.soumya.conf.Proposal;
import com.soumya.conf.organize.Organizer;
import com.soumya.conf.util.LogLevel;
import com.soumya.conf.util.Response;

/**
 * <tt>SessionFinderImpl</tt> implements <tt>SessionFinder</tt> interface. 
 * It provides implementation to find First Sessions and Second Sessions
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
	 * Provides implementation to find suitable proposals for first session
	 * from a list of available proposals.
	 * 
	 * @param proposals available
	 * @return proposals for first session
	 */
	@Override
	public List<Proposal> findFirstSession(List<Proposal> proposals) {
		Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": findFirstSession start");
		if (isNullOrEmpty(proposals)) {
			return null;
		}
		int index = 0;
		List<Proposal> result = null;
		while (index < proposals.size()) {
			result = new ArrayList<>();
			result.add(proposals.get(index));
			if (FIRST_SESSION_DURATION == proposalDuration(result)) {
				Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": findFirstSession end");
				return result;
			}
			for (int i = index + 1; i < proposals.size(); i++) {
				result.add(proposals.get(i));
				if (FIRST_SESSION_DURATION == proposalDuration(result)) {
					Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": findFirstSession end");
					return result;
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
	 * @param proposals available
	 * @return proposals for second session
	 */
	@Override
	public List<Proposal> findSecondSession(List<Proposal> proposals) {
		Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": findSecondSession start");
		if (isNullOrEmpty(proposals)) {
			return null;
		}
		int index = 0;
		List<Proposal> result = null;
		List<List<Proposal>> probableResults = new ArrayList<>();
		while (index < proposals.size()) {
			result = new ArrayList<>();
			result.add(proposals.get(index));
			int sumDuration = proposalDuration(result);
			if (sumDuration >= SECOND_SESSION_DURATION_MIN && sumDuration <= SECOND_SESSION_DURATION_MAX) {
				probableResults.add(result);
			}
			for (int i = index + 1; i < proposals.size(); i++) {
				result.add(proposals.get(i));
				sumDuration = proposalDuration(result);
				if (sumDuration >= SECOND_SESSION_DURATION_MIN && sumDuration <= SECOND_SESSION_DURATION_MAX) {
					List<Proposal> probableProposal = new ArrayList<>();
					probableProposal.addAll(result);
					probableResults.add(probableProposal);
				}
			}
			index++;
		}

		if (probableResults.isEmpty()) {
			return null;
		}
		List<Proposal> response = findOptimalProposals(probableResults);
		Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": findSecondSession end");
		return response;
	}

}
