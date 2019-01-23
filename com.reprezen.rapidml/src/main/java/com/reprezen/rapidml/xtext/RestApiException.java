/*******************************************************************************
 * Copyright © 2013, 2016 Modelsolv, Inc.
 * All Rights Reserved.
 *
 * NOTICE: All information contained herein is, and remains the property
 * of ModelSolv, Inc. See the file license.html in the root directory of
 * this project for further information.
 *******************************************************************************/
package com.reprezen.rapidml.xtext;

/**
 * Base exception for the restapi package related classes.
 * 
 * @author jimleroyer
 * @since 2013/04/25
 */
public class RestApiException extends RuntimeException {

	private static final long serialVersionUID = -4226926738348366162L;

	/**
	 * Constructs a new runtime exception with <code>null</code> as its detail
	 * message. The cause is not initialized, and may subsequently be initialized by
	 * a call to {@link #initCause}.
	 */
	public RestApiException() {
		super(); // To change body of overridden methods use File | Settings | File Templates.
	}

	/**
	 * Constructs a new runtime exception with the specified detail message. The
	 * cause is not initialized, and may subsequently be initialized by a call to
	 * {@link #initCause}.
	 * 
	 * @param message
	 *            the detail message. The detail message is saved for later
	 *            retrieval by the {@link #getMessage()} method.
	 */
	public RestApiException(String message) {
		super(message); // To change body of overridden methods use File | Settings | File Templates.
	}

	/**
	 * Constructs a new runtime exception with the specified detail message and
	 * cause.
	 * <p>
	 * Note that the detail message associated with <code>cause</code> is <i>not</i>
	 * automatically incorporated in this runtime exception's detail message.
	 * 
	 * @param message
	 *            the detail message (which is saved for later retrieval by the
	 *            {@link #getMessage()} method).
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            {@link #getCause()} method). (A <tt>null</tt> value is permitted,
	 *            and indicates that the cause is nonexistent or unknown.)
	 * @since 1.4
	 */
	public RestApiException(String message, Throwable cause) {
		super(message, cause); // To change body of overridden methods use File | Settings | File Templates.
	}

	/**
	 * Constructs a new runtime exception with the specified cause and a detail
	 * message of <tt>(cause==null ? null : cause.toString())</tt> (which typically
	 * contains the class and detail message of <tt>cause</tt>). This constructor is
	 * useful for runtime exceptions that are little more than wrappers for other
	 * throwables.
	 * 
	 * @param cause
	 *            the cause (which is saved for later retrieval by the
	 *            {@link #getCause()} method). (A <tt>null</tt> value is permitted,
	 *            and indicates that the cause is nonexistent or unknown.)
	 * @since 1.4
	 */
	public RestApiException(Throwable cause) {
		super(cause); // To change body of overridden methods use File | Settings | File Templates.
	}
}
