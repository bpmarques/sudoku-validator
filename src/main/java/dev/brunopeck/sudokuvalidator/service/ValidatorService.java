package dev.brunopeck.sudokuvalidator.service;

import dev.brunopeck.sudokuvalidator.constants.SudokuStatus;
import dev.brunopeck.sudokuvalidator.exception.InvalidGameException;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ValidatorService {

	private FileService fileService = new FileService();

	public int validate(String filePath) throws InvalidGameException {
		try {
			int[][] sudokuBoard = fileService.read(filePath);
			validateLines(sudokuBoard);
			validateColumns(sudokuBoard);
			validateRegions(sudokuBoard);

			return SudokuStatus.VALID;
		} catch (IOException | IllegalArgumentException e) {
			throw new InvalidGameException(e.getMessage());
		}
	}

	private void validateLines(int[][] sudokuBoard) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < sudokuBoard.length; i++) {
			for (int j = 0; j < sudokuBoard.length; j++) {
				if (!set.add(sudokuBoard[i][j])) {
					throw new InvalidGameException("Sudoku have an invalid element at line " + (i + 1));
				}
			}
			set.clear();
		}
	}

	private void validateColumns(int[][] sudokuBoard) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < sudokuBoard.length; i++) {
			for (int j = 0; j < sudokuBoard.length; j++) {
				if (!set.add(sudokuBoard[j][i])) {
					throw new InvalidGameException("Sudoku have an invalid element at column " + (i + 1));
				}
			}
			set.clear();
		}
	}

	private void validateRegions(int[][] sudokuBoard) {
		Set<Integer> set = new HashSet<>();
		int region = 0;
		while(region < 6) {
			for (int i = (region * 3); i < (region + 3); i++) {
				for (int j = (region * 3); j < (region + 3); j++) {
					if (!set.add(sudokuBoard[i][j])) {
						throw new InvalidGameException("The element at line " + (i + 1) + " and column " + (j + 1) + " is duplicated in its region");
					}
				}
			}
			set.clear();
			region++;
		}
	}
}
