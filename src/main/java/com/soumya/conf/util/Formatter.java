package com.soumya.conf.util;

import java.time.LocalTime;

public final class Formatter {

	public static String format(LocalTime time) {		
		StringBuilder timeBuilder = new StringBuilder();
		if (time == LocalTime.NOON) {
			timeBuilder.append(time.toString());
			timeBuilder.append(Time.PM);
		} else if (time.isAfter(LocalTime.NOON)) {
			timeBuilder.append(time.minusHours(12).toString());
			timeBuilder.append(Time.PM);
		} else if (time.isBefore(LocalTime.NOON)) {
			timeBuilder.append(time.toString());
			timeBuilder.append(Time.AM);
		}
		return timeBuilder.toString();
	}

	public static String format(int durationInMins) {
		if( durationInMins == 0){
			return "";
		} else if( durationInMins == 5){
			return "lightning";
		}
		return durationInMins + "min";
	}

}
