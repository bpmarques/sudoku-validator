package dev.brunopeck.sudokuvalidator.service;

import dev.brunopeck.sudokuvalidator.constants.ValidationMessages;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertArrayEquals;

public class FileServiceTest {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void shouldReadAValidCSVFile() throws IOException {
		FileService service = new FileService();
		int[][] sudokuBoard = service.read("src/test/resources/file-validation-samples/sudoku.txt");
		assertArrayEquals(sudokuBoard[0], fileContent()[0]);
	}

	@Test
	public void shouldThrowAnExceptionIfFilePathIsWrong() throws IOException {
		expectedException.expect(FileNotFoundException.class);
		FileService service = new FileService();
		service.read("wrongPath/sudoku.txt");
	}

	@Test
	public void shouldThrowAnExceptionIfFileHasAStringElement() throws IOException {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(ValidationMessages.INVALID_CSV_ELEMENT);
		FileService service = new FileService();
		service.read("src/test/resources/file-validation-samples/sudoku-string-element.txt");
	}

	@Test
	public void shouldThrowAnExceptionIfAnElementIsOutOfValidRange() throws IOException {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(ValidationMessages.INVALID_CSV_ELEMENT);
		FileService service = new FileService();
		service.read("src/test/resources/file-validation-samples/sudoku-element-out-of-range.txt");
	}

	@Test
	public void shouldThrowAnExceptionIfACSVLineIsShorterThanNine() throws IOException {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(ValidationMessages.INVALID_CSV_LINE);
		FileService service = new FileService();
		service.read("src/test/resources/file-validation-samples/sudoku-short-line.txt");
	}

	@Test
	public void shouldThrowAnExceptionIfACSVLineIsGreaterThanNine() throws IOException {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(ValidationMessages.INVALID_CSV_LINE);
		FileService service = new FileService();
		service.read("src/test/resources/file-validation-samples/sudoku-greater-line.txt");
	}

	private int[][] fileContent() {
		int[][] matrix = new int[9][9];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = j + 1;
			}
		}

		return matrix;
	}

}
