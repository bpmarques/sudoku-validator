package dev.brunopeck.sudokuvalidator.service;

import dev.brunopeck.sudokuvalidator.constants.SudokuStatus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidatorServiceTest {

	private ValidatorService validatorService = new ValidatorService();

	@Test
	public void shouldJudgeACorrectSudokuBoard() {
		int result = validatorService.validate("src/test/resources/game-validation-samples/sudoku-valid.txt");
		assertEquals(result, SudokuStatus.VALID);
	}

	@Test
	public void shouldJudgeAnInCorrectSudokuBoardWithWrongLine() {
		int result = validatorService.validate("src/test/resources/game-validation-samples/sudoku-wrong-line.txt");
		assertEquals(result, SudokuStatus.INVALID);
	}

	@Test
	public void shouldJudgeAnInCorrectSudokuBoardWithWrongColumn() {
		int result = validatorService.validate("src/test/resources/game-validation-samples/sudoku-wrong-column.txt");
		assertEquals(result, SudokuStatus.INVALID);
	}
}
