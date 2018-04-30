package com.soumya.conf.util;

public enum FileName {

	INPUT_FILE("input.txt"), OUTPUT_FILE("output.txt"), LOG_FILE("log.txt");

	private String fileName;

	FileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

}
