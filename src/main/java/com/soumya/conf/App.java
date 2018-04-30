package com.soumya.conf;

import com.soumya.conf.organize.Organizer;
import com.soumya.conf.organize.OrganizerImpl;
import com.soumya.conf.request.RequestProcessor;
import com.soumya.conf.session.SessionFinder;
import com.soumya.conf.session.SessionFinderImpl;
import com.soumya.conf.util.FileName;

public class App {

	public static void main(String[] args) {
		System.out.println("Application execution started");
		SessionFinder sessionFinder = new SessionFinderImpl();
		Organizer organizer = new OrganizerImpl(sessionFinder);
		RequestProcessor requestProcessor = new RequestProcessor(organizer);
		requestProcessor.process();
		System.out.println("Application execution ended");
		System.out.println("Check \""+FileName.OUTPUT_FILE.getFileName()+" and \""+ FileName.LOG_FILE.getFileName()+"\" files.");
	}
}
