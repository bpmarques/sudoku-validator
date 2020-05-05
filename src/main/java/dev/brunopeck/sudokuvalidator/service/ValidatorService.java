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
			boolean isRegionsValid = validateRegions(sudokuBoard);
			if (isLinesValid && isColumnsValid && isRegionsValid) {
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
			for (int j = 0; j < sudokuBoard.length; j++) {
				if (!set.add(sudokuBoard[j][i])) {
					return false;
				}
			}
			set.clear();
		}
		return true;
	}

	private boolean validateRegions(int[][] sudokuBoard) {
		Set<Integer> set = new HashSet<>();
		int region = 0;
		while(region < 6) {
			for (int i = (region * 3); i < (region + 3); i++) {
				for (int j = (region * 3); j < (region + 3); j++) {
					if (!set.add(sudokuBoard[i][j])) {
						return false;
					}
				}
			}
			set.clear();
			region++;
		}

		return true;
	}
}
