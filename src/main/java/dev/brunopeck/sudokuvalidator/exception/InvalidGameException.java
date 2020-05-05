package dev.brunopeck.sudokuvalidator.exception;

import dev.brunopeck.sudokuvalidator.constants.SudokuStatus;

public class InvalidGameException extends RuntimeException {
	private int gameStatus = SudokuStatus.INVALID;

	public InvalidGameException(String message) {
		super(message);
	}

	public int getGameStatus() {
		return gameStatus;
	}
}
