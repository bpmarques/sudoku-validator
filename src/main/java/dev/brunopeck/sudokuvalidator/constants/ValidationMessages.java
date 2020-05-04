package dev.brunopeck.sudokuvalidator.constants;

public class ValidationMessages {
	/**
	 * CSV related validation errors
	 */
	public static final String INVALID_CSV_LINE = "Each CSV file line should contain exactly 9 integer elements between 1-9.";
	public static final String INVALID_CSV_ELEMENT = "CSV elements should be only integers and between 1-9.";
	public static final String INVALID_CSV_PATH = "The path provided for the CSV file is incorrect.";
}
