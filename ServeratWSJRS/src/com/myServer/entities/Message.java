package com.myServer.entities;

import java.io.Serializable;
import java.util.Arrays;

public class Message implements Serializable {
	
	
	private boolean errors ;
	
	private String[] errorList ;

	public Message() {
		super();
	}

	public Message(boolean errors, String[] errorList) {
		super();
		this.errors = errors;
		this.errorList = errorList;
	}

	public Message(boolean errors) {
		super();
		this.errors = errors;
		this.errorList = null;
	}

	public boolean isErrors() {
		return errors;
	}
	
	public boolean hasErrors() {
		return errors;
	}

	public void setErrors(boolean errors) {
		this.errors = errors;
	}

	public String[] getErrorList() {
		return errorList;
	}

	public void setErrorList(String[] errorList) {
		this.errorList = errorList;
	}

	@Override
	public String toString() {
		return "has errors = " + errors + ", /n errorList = "
				+ Arrays.toString(errorList) + "]";
	}
	
	

}
