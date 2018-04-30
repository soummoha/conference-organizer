package com.soumya.conf;

import static org.junit.Assert.*;

import org.junit.Test;

import com.soumya.conf.Proposal;

public class ProposalTest {

	@Test
	public void testGetTitle() {
		Proposal p = new Proposal("Writing Fast Tests Against Enterprise Rails", 60);
		assertEquals("Writing Fast Tests Against Enterprise Rails", p.getTitle());
	}

	@Test
	public void testGetDurationInMinutes() {
		Proposal p = new Proposal("Writing Fast Tests Against Enterprise Rails", 60);
		assertEquals(60, p.getDurationInMinutes());
	}

	@Test
	public void testEqualsObject() {
		Proposal p1 = new Proposal("Writing Fast Tests Against Enterprise Rails", 60);
		Proposal p2 = new Proposal("Writing Fast Tests Against Enterprise Rails", 45);
		Proposal p3 = new Proposal("Ruby on Rails: Why We Should Move On", 60);
		assertTrue(p1.equals(p2));
		assertFalse(p2.equals(p3));
		assertFalse(p1.equals(p3));
	}

}
