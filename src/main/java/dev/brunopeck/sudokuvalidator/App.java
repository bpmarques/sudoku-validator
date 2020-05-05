package dev.brunopeck.sudokuvalidator;

import dev.brunopeck.sudokuvalidator.constants.SudokuStatus;
import dev.brunopeck.sudokuvalidator.exception.InvalidGameException;
import dev.brunopeck.sudokuvalidator.service.ValidatorService;

public class App {
    public static void main( String[] args ) {
        try {
            if (args.length == 0) {
                printResult("Path for the file is mandatory", SudokuStatus.INVALID);
                System.exit(-1);
            }
            ValidatorService validatorService = new ValidatorService();
            int validationStatus = validatorService.validate(args[0]);
            printResult("Sudoku validated is correct!", validationStatus);
        } catch (InvalidGameException e) {
            printResult(e.getMessage(), e.getGameStatus());
        }
    }

    private static void printResult(String message, int statusCode) {
        System.out.println("Validation Code: " + statusCode);
        System.out.println("Message: " + message);
    }
}
