package com.soumya.conf.request;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import com.soumya.conf.Proposal;
import com.soumya.conf.Track;
import com.soumya.conf.organize.Organizer;
import com.soumya.conf.util.FileName;
import com.soumya.conf.util.LogLevel;
import com.soumya.conf.util.Response;

import static java.util.stream.Collectors.toList;

/**
 * <tt>RequestProcessor</tt> process all the proposals from input text file
 * 
 * @author Soumyakanta Mohapatra
 * 
 * @see RequestValidator
 * @see Organizer
 *
 */
public class RequestProcessor {

	private Organizer organizer;

	public RequestProcessor(Organizer organizer) {
		this.organizer = organizer;
	}

	/**
	 * This process method reads all the proposals from the input text file and
	 * passes the proposals to the validator to validate. After successful
	 * validation it sends the proposals to the organizer.
	 * 
	 */
	public void process() {
		Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": process start");
		long processStartTime = System.currentTimeMillis();
		String userDir = System.getProperty("user.dir");
		String inputPath = userDir + File.separatorChar + FileName.INPUT_FILE.getFileName();
		List<Proposal> proposals = new LinkedList<>();
		List<String> inputs = readInputs(inputPath);
		long validateStartTime = System.currentTimeMillis();
		inputs.forEach(input -> {
			try {
				proposals.add(RequestValidator.validateAndGet(input));
			} catch (ValidationException e) {
				Response.writeLog(LogLevel.ERROR, e.getMessage());
			}
		});
		long validateEndTime = System.currentTimeMillis();
		Response.writeLog(LogLevel.INFO, "Validation Time :" + (validateEndTime - validateStartTime) + " millis");
		if( proposals.size() != inputs.size()){
			Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": input validation failed");
			return;
		}
		Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": input validation succeed");
		long organizeStartTime = System.currentTimeMillis();
		List<Track> tracks = organizer.organize(proposals);
		long organizeEndTime = System.currentTimeMillis();
		Response.writeLog(LogLevel.INFO, "Organize Time :" + (organizeEndTime - organizeStartTime) + " millis");
		Response.writeOutput(tracks);
		long processEndTime = System.currentTimeMillis();
		Response.writeLog(LogLevel.INFO, "Process Time :" + (processEndTime - processStartTime) + " millis");
		Response.writeLog(LogLevel.DEBUG, this.getClass().getSimpleName() + ": process end");
	}

	private List<String> readInputs(String inputPath) {
		List<String> inputs = null;
		try (Stream<String> inputStream = Files.lines(Paths.get(inputPath))) {
			inputs = inputStream.collect(toList());
		} catch (Exception e) {
			Response.writeLog(LogLevel.ERROR, e.getMessage());
		}
		return inputs;
	}

}
