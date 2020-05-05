package dev.brunopeck.sudokuvalidator.service;

import dev.brunopeck.sudokuvalidator.constants.SudokuStatus;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ValidatorService {

	private FileService fileService = new FileService();

	public int validate(String filePath) {
		int result = SudokuStatus.INVALID;
		try {
			int[][] sudokuBoard = fileService.read(filePath);
			boolean isLinesValid = validateLines(sudokuBoard);
			boolean isColumnsValid = validateColumns(sudokuBoard);
			if (isLinesValid && isColumnsValid) {
				result = SudokuStatus.VALID;
			}

			return result;
		} catch (IOException | IllegalArgumentException e) {
			e.printStackTrace();
			return result;
		}
	}

	private boolean validateLines(int[][] sudokuBoard) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < sudokuBoard.length; i++) {
			for (int j = 0; j < sudokuBoard.length; j++) {
				if (!set.add(sudokuBoard[i][j])) {
					return false;
				}
			}
			set.clear();
		}
		return true;
	}

	private boolean validateColumns(int[][] sudokuBoard) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < sudokuBoard.length; i++) {
			for (int j = 1; j < sudokuBoard.length; j++) {
				if (!set.add(sudokuBoard[j][i])) {
					return false;
				}
			}
			set.clear();
		}
		return true;
	}

	private boolean validateRegions(int[][] sudokuBoard) {
		return false;
	}
}
