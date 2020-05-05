# Sudoku Validator
Project created as a solution for a code challange, it should validate a txt file with the content as a valid CSV format like:

    // valid-file-example.txt
    1,2,3,4,5,6,7,8,9
    1,2,3,4,5,6,7,8,9
    1,2,3,4,5,6,7,8,9
    1,2,3,4,5,6,7,8,9
    1,2,3,4,5,6,7,8,9
    1,2,3,4,5,6,7,8,9
    1,2,3,4,5,6,7,8,9
    1,2,3,4,5,6,7,8,9
    1,2,3,4,5,6,7,8,9

## Run The Validator
For windows users, there is a `validate.bat` file in the project root folder, just double click it or run on CMD or PowerShell. It will pack the project into a JAR file and excecute it.

## Tests
There are also some unit tests, in order ou run them, execute the following command.

    mvn test

