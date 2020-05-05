package dev.brunopeck.sudokuvalidator.service;

import dev.brunopeck.sudokuvalidator.constants.SudokuStatus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ValidatorServiceTest {

	private ValidatorService validatorService = new ValidatorService();

	@Test
	public void shouldJudgeACorrectSudokuBoard() {
		int result = validatorService.validate("src/test/resources/game-validation-samples/sudoku-valid.txt");
		assertEquals(SudokuStatus.VALID, result);
	}

	@Test
	public void shouldJudgeAnInCorrectSudokuBoardWithWrongLine() {
		int result = validatorService.validate("src/test/resources/game-validation-samples/sudoku-wrong-line.txt");
		assertEquals(SudokuStatus.INVALID, result);
	}

	@Test
	public void shouldJudgeAnInCorrectSudokuBoardWithWrongColumn() {
		int result = validatorService.validate("src/test/resources/game-validation-samples/sudoku-wrong-column.txt");
		assertEquals(SudokuStatus.INVALID, result);
	}

	@Test
	public void shouldJudgeAnInCorrectSudokuBoardWithWrongRegion() {
		int result = validatorService.validate("src/test/resources/game-validation-samples/sudoku-wrong-region.txt");
		assertEquals(SudokuStatus.INVALID, result);
	}
}
