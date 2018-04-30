package com.soumya.conf;

import java.time.LocalTime;

import com.soumya.conf.util.Formatter;

public class Talk {
	
	private LocalTime startTime;
	private String title;
	private int durationInMins;

	public Talk(LocalTime startTime, String title, int durationInMins) {
		this.startTime = startTime;
		this.title = title;
		this.durationInMins = durationInMins;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public String getTitle() {
		return title;
	}

	public int getDurationInMins() {
		return durationInMins;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", Formatter.format(this.startTime), this.title, Formatter.format(this.durationInMins));
	}

}
