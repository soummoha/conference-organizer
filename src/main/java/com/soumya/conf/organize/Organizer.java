package com.soumya.conf.organize;

import java.time.LocalTime;
import java.util.List;

import com.soumya.conf.Proposal;
import com.soumya.conf.Talk;
import com.soumya.conf.Track;

/**
 * Interface for <tt>Organizer</tt> API. Provides organize method to be implemented.
 * 
 * @author  Soumyakanta Mohapatra
 * 
 * @see Proposal
 * @see Track
 *
 */
public interface Organizer {	
	
	/**
	 * Organize method organizes list of proposals and return all the possible tracks
	 * 
	 * @param proposals
	 * @return tracks
	 */
	List<Track> organize(List<Proposal> proposals);	

	default void addProposal(Track track, Proposal proposal, LocalTime time){
		track.addTalk(new Talk(time, proposal.getTitle(), proposal.getDurationInMinutes()));
	}

	default LocalTime addProposals(Track track, List<Proposal> proposals, LocalTime time){
		for (Proposal proposal : proposals) {
			track.addTalk(new Talk(time, proposal.getTitle(), proposal.getDurationInMinutes()));
			time = time.plusMinutes(proposal.getDurationInMinutes());
		}
		return time;
	}

}
