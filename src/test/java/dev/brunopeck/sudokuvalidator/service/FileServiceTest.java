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
		int[][] sudokuBoard = service.read("src\\test\\resources\\sudoku.csv");
		assertArrayEquals(sudokuBoard[0], fileContent()[0]);
	}

	@Test
	public void shouldThrowAnExceptionIfFilePathIsWrong() throws IOException {
		expectedException.expect(FileNotFoundException.class);
		FileService service = new FileService();
		service.read("wrongPath\\sudoku.csv");
	}

	@Test
	public void shouldThrowAnExceptionIfFileHasAStringElement() throws IOException {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(ValidationMessages.INVALID_CSV_ELEMENT);
		FileService service = new FileService();
		service.read("src\\test\\resources\\sudoku-string-element.csv");
	}

	@Test
	public void shouldThrowAnExceptionIfAnElementIsOutOfValidRange() throws IOException {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(ValidationMessages.INVALID_CSV_ELEMENT);
		FileService service = new FileService();
		service.read("src\\test\\resources\\sudoku-element-out-of-range.csv");
	}

	@Test
	public void shouldThrowAnExceptionIfACSVLineIsShorterThanNine() throws IOException {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(ValidationMessages.INVALID_CSV_LINE);
		FileService service = new FileService();
		service.read("src\\test\\resources\\sudoku-short-line.csv");
	}

	@Test
	public void shouldThrowAnExceptionIfACSVLineIsGreaterThanNine() throws IOException {
		expectedException.expect(IllegalArgumentException.class);
		expectedException.expectMessage(ValidationMessages.INVALID_CSV_LINE);
		FileService service = new FileService();
		service.read("src\\test\\resources\\sudoku-greater-line.csv");
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
