package com.soumya.conf.request;

import com.soumya.conf.Proposal;

/**
 * <tt>RequestValidator</tt> is a final class which validates all the proposals 
 * 
 * @author Soumyakanta Mohapatra
 * 
 * @see RequestProcessor
 * @see ValidationException
 * @see Proposal
 *
 */
public final class RequestValidator {

	/**
	 * This <tt>validateAndGet</tt> method validated the proposal input.
	 * 
	 * @param input
	 * @return Proposal
	 * @throws ValidationException
	 */
	public static Proposal validateAndGet(String input) throws ValidationException{
		String title;
		int durationInMin;
		Proposal proposal;
		try {
			if( input.trim().isEmpty()){
				throw new ValidationException("input cann't be empty");
			}
			String[] words = input.split("\\s+");
			String duration = words[words.length - 1];
			String[] splitTitle = input.split(duration);
			if( splitTitle.length == 0 ){
				throw new ValidationException("title cann't be empty");
			}
			title = splitTitle[0].trim();
			if( duration.equals("lightning") ){
				duration = "5min";
			}			
			if( !duration.contains("min")){
				throw new ValidationException("duration is missing");
			}
			durationInMin = Integer.valueOf(duration.split("min")[0]);			
			validate(title, durationInMin);
			proposal = new Proposal(title, durationInMin);
		} catch (Exception e) {
			throw new ValidationException("Invalid Input: " + e.getMessage());
		}		
		return proposal;
	}

	private static void validate(String title, int durationInMin) throws ValidationException {
		if( title.isEmpty()){
			throw new ValidationException("title cann't be empty");
		}					
		if(title.length() > 500){
			throw new ValidationException("max title lenght should be 500");
		}
		if( durationInMin > 180){
			throw new ValidationException("max duration should be 180min");
		}					
		if(durationInMin < 5){
			throw new ValidationException("min duration should be 5min");
		}
	}

}
