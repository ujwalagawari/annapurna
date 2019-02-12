/**
 * 
 */
package com.capgemini.annapurna.restaurant.Exception;

/**
 * @author ugawari
 * 
 * To handle incoming wrong or unwanted input.
 */
public class InvalidIncommingInputException extends RuntimeException {

	public InvalidIncommingInputException(String msg) {
		super(msg);
	}

}
