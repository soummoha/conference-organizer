package com.soumya.conf.session;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import org.junit.Test;

import com.soumya.conf.Proposal;
import com.soumya.conf.TestUtility;
import com.soumya.conf.session.SessionFinder;
import com.soumya.conf.session.SessionFinderImpl;

public class SessionFinderImplTest {

	@Test
	public void testFindFirstSession() {
		SessionFinder sessionFinderImpl = new SessionFinderImpl();
		List<Proposal> firstSession = sessionFinderImpl.findFirstSession(TestUtility.proposals());
		StringJoiner sj = new StringJoiner("\n");
		firstSession.forEach(p -> sj.add(p.toString()));
		assertEquals(TestUtility.SESSION_FINDER_FIRST_SESSION_TEST_RESULT, sj.toString());
	}
	
	@Test
	public void testFindFirstSessionWithInsufficientProposals() {
		SessionFinder sessionFinderImpl = new SessionFinderImpl();
		List<Proposal> firstSession = sessionFinderImpl.findFirstSession(TestUtility.proposalsForInsufficientSession());		
		assertNull(firstSession);
	}
	
	@Test
	public void testFindFirstSessionWithNullProposals() {
		SessionFinder sessionFinderImpl = new SessionFinderImpl();
		List<Proposal> firstSession = sessionFinderImpl.findFirstSession(null);		
		assertNull(firstSession);
	}
	
	@Test
	public void testFindFirstSessionWithEmptyProposals() {
		SessionFinder sessionFinderImpl = new SessionFinderImpl();
		List<Proposal> proposals = new ArrayList<>();
		List<Proposal> firstSession = sessionFinderImpl.findFirstSession(proposals);		
		assertNull(firstSession);
	}

	@Test
	public void testFindSecondSession() {
		SessionFinder sessionFinderImpl = new SessionFinderImpl();
		List<Proposal> secondSession = sessionFinderImpl.findSecondSession(TestUtility.proposals());
		StringJoiner sj = new StringJoiner("\n");
		secondSession.forEach(p -> sj.add(p.toString()));
		assertEquals(TestUtility.SESSION_FINDER_SECOND_SESSION_TEST_RESULT, sj.toString());
	}
	
	@Test
	public void testFindSecondSessionWithInsufficientProposals() {
		SessionFinder sessionFinderImpl = new SessionFinderImpl();
		List<Proposal> secondSession = sessionFinderImpl.findSecondSession(TestUtility.proposalsForInsufficientSession());
		assertNull(secondSession);
	}
	
	@Test
	public void testFindSecondSessionWithNullProposals() {
		SessionFinder sessionFinderImpl = new SessionFinderImpl();
		List<Proposal> secondSession = sessionFinderImpl.findSecondSession(null);		
		assertNull(secondSession);
	}
	
	@Test
	public void testFindSecondSessionWithEmptyProposals() {
		SessionFinder sessionFinderImpl = new SessionFinderImpl();
		List<Proposal> proposals = new ArrayList<>();
		List<Proposal> secondSession = sessionFinderImpl.findSecondSession(proposals);		
		assertNull(secondSession);
	}

}
