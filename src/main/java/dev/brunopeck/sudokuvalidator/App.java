package dev.brunopeck.sudokuvalidator;

import dev.brunopeck.sudokuvalidator.exception.InvalidGameException;
import dev.brunopeck.sudokuvalidator.service.ValidatorService;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        System.out.print("Type the path for the CSV file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        ValidatorService validatorService = new ValidatorService();
        try {
            int validationStatus = validatorService.validate(path);
            System.out.println("Validation Code: " + validationStatus);
            System.out.print("Message: Sudoku validated is correct!");
        } catch (InvalidGameException e) {
            System.out.println("Validation Code: " + e.getGameStatus());
            System.out.print("Message: " + e.getMessage());
        }
    }
}
