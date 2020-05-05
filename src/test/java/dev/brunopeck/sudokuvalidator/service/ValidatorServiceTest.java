package dev.brunopeck.sudokuvalidator.service;

import dev.brunopeck.sudokuvalidator.constants.SudokuStatus;
import dev.brunopeck.sudokuvalidator.exception.InvalidGameException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ValidatorServiceTest {

	private ValidatorService validatorService = new ValidatorService();

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	@Test
	public void shouldJudgeACorrectSudokuBoard() {
		int result = validatorService.validate("src/test/resources/game-validation-samples/sudoku-valid.txt");
		assertEquals(SudokuStatus.VALID, result);
	}

	@Test
	public void shouldJudgeAnInCorrectSudokuBoardWithWrongLine() {
		expectedException.expect(InvalidGameException.class);
		expectedException.expectMessage("Sudoku is invalid at line 3 and column 6");
		validatorService.validate("src/test/resources/game-validation-samples/sudoku-wrong-line.txt");
	}

	@Test
	public void shouldJudgeAnInCorrectSudokuBoardWithWrongColumn() {
		expectedException.expect(InvalidGameException.class);
		expectedException.expectMessage("Sudoku is invalid at line 9 and column 4");
		validatorService.validate("src/test/resources/game-validation-samples/sudoku-wrong-column.txt");
	}

	@Test
	public void shouldJudgeAnInCorrectSudokuBoardWithWrongRegion() {
		expectedException.expect(InvalidGameException.class);
		expectedException.expectMessage("Sudoku is invalid at line 2 and column 1");
		validatorService.validate("src/test/resources/game-validation-samples/sudoku-wrong-region.txt");
	}
}
