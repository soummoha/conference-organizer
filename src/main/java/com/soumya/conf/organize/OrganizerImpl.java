package com.soumya.conf.organize;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.soumya.conf.Proposal;
import com.soumya.conf.Track;
import com.soumya.conf.session.SessionFinder;
import com.soumya.conf.util.LogLevel;
import com.soumya.conf.util.Response;
import com.soumya.conf.util.Schedule;

/**
 * Conference organizer implementation of the <tt>Organizer</tt> interface.  
 * Implements organize proposals operation, and provides all the possible Tracks.
 * It uses <tt>SessionFinder</tt> interface to structure the first and second sessions
 * of the Tracks.
 * 
 * @author  Soumyakanta Mohapatra
 * @see     Organizer
 * @see     Track
 * @see     SessionFinder
 */
public class OrganizerImpl implements Organizer{
	
	private SessionFinder sessionFinder;
	
	public OrganizerImpl(SessionFinder sessionFinder){
		this.sessionFinder = sessionFinder;
	}	
	
	/**
     * Organizes list proposals.
     *
     * @param proposals
     * @return tracks
     */
	@Override
	public List<Track> organize(List<Proposal> proposals) {
		Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": organize start");
		List<Track> trackList = new ArrayList<>();		
		int trackCount = 1;
		
		while (!sessionFinder.isNullOrEmpty(proposals)) {
			
			List<Proposal> proposalsForFirstSession = sessionFinder.findFirstSession(proposals);
			
			if (sessionFinder.isNullOrEmpty(proposalsForFirstSession)) {
				break;
			}
			
			String trackName = "Track " + trackCount;			
			Track track = new Track(trackName);
			
			addProposals(track, proposalsForFirstSession, Schedule.FirstSession.startTime);
			proposals.removeAll(proposalsForFirstSession);
			
			addProposal(track, new Proposal("Lunch", sessionFinder.lunchDuration() ), Schedule.Lunch.startTime);
			
			List<Proposal> proposalsForSecondSession = sessionFinder.findSecondSession(proposals);
			if (sessionFinder.isNullOrEmpty(proposalsForSecondSession)) {
				break;
			}
			
			LocalTime startTime = addProposals(track, proposalsForSecondSession, Schedule.SecondSession.startTime);
			proposals.removeAll(proposalsForSecondSession);
			
			addProposal(track, new Proposal("Networking Event", 0 ), startTime);
			
			trackList.add(track);
			Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": "+ trackName +" added");
			trackCount++;
		}
		Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": organize end");
		
		return trackList;

	}
	
}
