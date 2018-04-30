package com.soumya.conf.request;

import com.soumya.conf.Proposal;

/**
 * <tt>ValidationException</tt> is a exception class. It is used for proposal validation failure. 
 * 
 * @author Soumyakanta Mohapatra
 * 
 * @see RequestValidator
 * @see Proposal
 *
 */
public class ValidationException extends Exception {

	private static final long serialVersionUID = -7186292713721725880L;

	public ValidationException() {
		super();
	}

	public ValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(Throwable cause) {
		super(cause);
	}

}
