package com.soumya.conf.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.soumya.conf.Track;

public final class Response {	

	public static void writeOutput(List<Track> tracks) {
		try (FileWriter writer = new FileWriter(FileName.OUTPUT_FILE.getFileName(), false)) {
			tracks.stream().forEach(t -> {
				try {
					writer.write(t.toString());
				} catch (IOException e) {
					Response.writeLog(LogLevel.ERROR, e.getMessage());
				}
			});
		} catch (Exception e) {
			Response.writeLog(LogLevel.ERROR, e.getMessage());
		}
	}

	public static void writeLog(LogLevel logLevel, String logMessage) {
		try (FileWriter writer = new FileWriter(FileName.LOG_FILE.getFileName(), true)) {
			try {
				writer.write(logLevel + ":\t" + logMessage + "\n");
			} catch (IOException e) {
			}
		} catch (Exception e) {
		}
	}

}
