package com.soumya.conf;

import com.soumya.conf.organize.Organizer;
import com.soumya.conf.organize.OrganizerImpl;
import com.soumya.conf.request.RequestProcessor;
import com.soumya.conf.session.SessionFinder;
import com.soumya.conf.session.SessionFinderImpl;

public class App {

	public static void main(String[] args) {
		SessionFinder sessionFinder = new SessionFinderImpl();
		Organizer organizer = new OrganizerImpl(sessionFinder);
		RequestProcessor requestProcessor = new RequestProcessor(organizer);
		requestProcessor.process();
	}
}
