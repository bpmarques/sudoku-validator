package dev.brunopeck.sudokuvalidator;

import dev.brunopeck.sudokuvalidator.service.FileService;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main( String[] args ) {
        FileService fileService = new FileService();
        try {
            System.out.print("Type the path for the CSV file: ");
            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();
            int[][] matrix = fileService.read(path);
            printMatrix(matrix);
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
        }

    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
