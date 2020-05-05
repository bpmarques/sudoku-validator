package dev.brunopeck.sudokuvalidator;

import dev.brunopeck.sudokuvalidator.service.ValidatorService;

import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        System.out.print("Type the path for the CSV file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        ValidatorService validatorService = new ValidatorService();
        validatorService.validate(path);
    }
}
