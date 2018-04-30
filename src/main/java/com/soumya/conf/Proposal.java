package com.soumya.conf;

/**
 * <tt>Proposal</tt> is a model class  which holds the title and duration property for the Proposal.
 * 
 * @author Soumyakanta Mohapatra
 *
 */
public class Proposal {

	private String title;
	private int durationInMinutes;

	public Proposal(String title, int durationInMinutes) {
		this.title = title;
		this.durationInMinutes = durationInMinutes;
	}

	public String getTitle() {
		return title;
	}

	public int getDurationInMinutes() {
		return durationInMinutes;
	}
	

	@Override
	public String toString() {
		return String.format("%s %s", title, durationInMinutes);
	}

	@Override
	public boolean equals(Object other) {
		return this.title.equals(((Proposal) other).title);
	}

}
