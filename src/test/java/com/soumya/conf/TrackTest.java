package com.soumya.conf;

import static org.junit.Assert.*;

import java.time.LocalTime;

import org.junit.Test;

import com.soumya.conf.Talk;
import com.soumya.conf.Track;

public class TrackTest {

	@Test
	public void testTrack() {
		Track track = new Track("Track 1");
		track.addTalk(new Talk(LocalTime.of(10, 0), "Overdoing it in Python", 45));
		track.addTalk(new Talk(LocalTime.of(10, 45), "Lua for the Masses", 30));
		track.addTalk(new Talk(LocalTime.of(11, 15), "Ruby Errors from Mismatched Gem Versions", 45));

		assertEquals(TestUtility.TRACK_TEST_RESULT, track.toString());
	}

}
