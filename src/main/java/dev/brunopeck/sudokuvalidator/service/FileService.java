package dev.brunopeck.sudokuvalidator.service;

import dev.brunopeck.sudokuvalidator.constants.ValidationMessages;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileService {

	private static final String COMMA_SEPARATOR = ",";

	public int[][] read(String path) throws IOException {
		int[][] content = new int[9][9];
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			String line;
			int lineNumber = 0;

			while ((line = reader.readLine()) != null) {
				String[] stringElements = line.split(COMMA_SEPARATOR);
				fillLine(content, lineNumber, stringElements);
				lineNumber++;
			}
		}
		return content;
	}

	private void fillLine(int[][] content, int lineNumber, String[] arr) {
		if (!isLineValid(arr)) {
			throw new IllegalArgumentException(ValidationMessages.INVALID_CSV_LINE);
		}
		for (int i = 0; i < arr.length; i++) {
			int elementParsed = isElementValid(arr[i]);
			if(elementParsed != -1) {
				content[lineNumber][i] = elementParsed;
			} else {
				throw new IllegalArgumentException(ValidationMessages.INVALID_CSV_ELEMENT);
			}
		}
	}

	private boolean isLineValid(String[] line) {
		return line.length == 9;
	}

	private int isElementValid(String element) {
		int result = -1;
		try {
			int elementParsed = Integer.parseInt(element);
			if (elementParsed >= 1 && elementParsed <= 9) {
				result = elementParsed;
			}
			return result;
		} catch (NumberFormatException e) {
			return result;
		}
	}

}
