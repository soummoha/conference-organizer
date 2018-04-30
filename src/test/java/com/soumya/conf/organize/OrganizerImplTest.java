package com.soumya.conf.organize;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.soumya.conf.Proposal;
import com.soumya.conf.TestUtility;
import com.soumya.conf.Track;
import com.soumya.conf.organize.Organizer;
import com.soumya.conf.organize.OrganizerImpl;
import com.soumya.conf.session.SessionFinderImpl;

public class OrganizerImplTest {
	
	@Test
	public void testOrganize() {
		Organizer organizer = new OrganizerImpl(new SessionFinderImpl());
		List<Track> trackList = organizer.organize(TestUtility.proposals());
		StringBuilder builder = new StringBuilder();
		trackList.forEach(t -> builder.append(t.toString()));		
		assertEquals(TestUtility.ORGANIZER_TEST_RESULT, builder.toString());
	}
	
	@Test
	public void testOrganizeWithNullProposal() {
		Organizer organizer = new OrganizerImpl(new SessionFinderImpl());
		List<Track> trackList = organizer.organize(null);				
		assertTrue(trackList.isEmpty());
	}
	
	@Test
	public void testOrganizeWithEmptyProposal() {
		Organizer organizer = new OrganizerImpl(new SessionFinderImpl());
		List<Proposal> proposals = new LinkedList<>();
		List<Track> trackList = organizer.organize(proposals);				
		assertTrue(trackList.isEmpty());
	}
	
	@Test
	public void testOrganizeWithInsufficientFirstSessionProposal() {
		Organizer organizer = new OrganizerImpl(new SessionFinderImpl());
		List<Track> trackList = organizer.organize(TestUtility.proposalsForInsufficientSession());				
		assertTrue(trackList.isEmpty());
	}
	
	@Test
	public void testOrganizeWithInsufficientSecondSessionProposal() {
		Organizer organizer = new OrganizerImpl(new SessionFinderImpl());
		List<Proposal> proposals = new LinkedList<>();
		List<Track> trackList = organizer.organize(proposals);				
		assertTrue(trackList.isEmpty());
	}

}
