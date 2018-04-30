package com.soumya.conf;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

import com.soumya.conf.Talk;

public class TalkTest {

	@Test
	public void testGetStartTime() {
		Talk talk = new Talk(LocalTime.of(10,0), "Overdoing it in Python", 45);
		assertEquals(LocalTime.of(10,0), talk.getStartTime());
	}

	@Test
	public void testGetTitle() {
		Talk talk = new Talk(LocalTime.of(10,45), "Lua for the Masses", 30);
		assertEquals("Lua for the Masses", talk.getTitle());
	}

	@Test
	public void testGetDurationInMins() {
		Talk talk = new Talk(LocalTime.of(11,15), "Ruby Errors from Mismatched Gem Versions", 45);
		assertEquals(45, talk.getDurationInMins());
	}
	
	@Test
	public void testSessionToStringBeforeLunch() {
		Talk talk = new Talk(LocalTime.of(11,40), "Ruby Errors from Mismatched Gem Versions", 45);
		assertEquals("11:40AM Ruby Errors from Mismatched Gem Versions 45min", talk.toString());
	}
	
	@Test
	public void testSessionToStringAfterLunch() {
		Talk talk = new Talk(LocalTime.of(13,0), "Ruby on Rails: Why We Should Move On", 45);
		assertEquals("01:00PM Ruby on Rails: Why We Should Move On 45min", talk.toString());
	}

}
