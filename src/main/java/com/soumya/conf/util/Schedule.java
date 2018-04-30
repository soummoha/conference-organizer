package com.soumya.conf.util;

import java.time.LocalTime;

public enum Schedule {

	FirstSession(LocalTime.of(9, 0)),

	Lunch(LocalTime.NOON),

	SecondSession(LocalTime.of(13, 0));

	public LocalTime startTime;

	Schedule(LocalTime startTime) {
		this.startTime = startTime;

	}
}
