package com.study.exception;

public class DaoDuplicatedKeyException extends DaoException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DaoDuplicatedKeyException() {
		super();
	}

	public DaoDuplicatedKeyException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DaoDuplicatedKeyException(String message, Throwable cause) {
		super(message, cause);
	}

	public DaoDuplicatedKeyException(String message) {
		super(message);
	}

	public DaoDuplicatedKeyException(Throwable cause) {
		super(cause);
	}

}
