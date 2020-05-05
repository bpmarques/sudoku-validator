package dev.brunopeck.sudokuvalidator.exception;

import dev.brunopeck.sudokuvalidator.constants.SudokuStatus;

public class InvalidGameException extends RuntimeException {
	private int gameStatus = SudokuStatus.INVALID;

	public InvalidGameException(int line, int column) {
		super("Sudoku is invalid at line " + line + " and column " + column);
	}
	public InvalidGameException(String message) {
		super(message);
	}

	public int getGameStatus() {
		return gameStatus;
	}
}
