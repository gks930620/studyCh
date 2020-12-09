package com.study.exception;

public class BizDuplicatedKeyException extends BizException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BizDuplicatedKeyException() {
	}

	public BizDuplicatedKeyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public BizDuplicatedKeyException(String message, Throwable cause) {
		super(message, cause);
	}

	public BizDuplicatedKeyException(String message) {
		super(message);
	}

	public BizDuplicatedKeyException(Throwable cause) {
		super(cause);
	}

}
