package com.soumya.conf;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Track {
	private List<Talk> talkList;
	private String trackName;
	
	public Track(String trackName) {
		this.trackName = trackName;
		this.talkList = new ArrayList<>();
	}
	
	public void addTalk(Talk talk){
		talkList.add(talk);
	}

	@Override
	public String toString() {
		StringJoiner trackDisplay = new StringJoiner("\n");
		trackDisplay.add("\n"+trackName+":");
		talkList.forEach(t -> trackDisplay.add(t.toString()));	
		return trackDisplay.toString();
	}
}
