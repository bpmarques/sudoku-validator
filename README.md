# Sudoku Validator
Project created as a solution for a code challenge, it should validate a txt file with the content as a valid CSV format like:

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

## Requirements
Before run the project, make sure you have the `JRE` and `Maven` in your computer.

## Run The Validator
For windows users, there is a `validate.bat` file in the project root folder, just double click it or run on CMD or PowerShell. It will pack the project into a JAR file and excecute it.

## Tests
There are also some unit tests, in order ou run them, execute the following command.

    mvn test

## Test Reports
The command above to run the unit tests will generate txt and xml test reports,
they will be within the folder `target/surefire-reports`.
It is possible to generate a HTML test report by running the command:

    mvn surefire-report:report-only

It will generate a HTML file within the folder `target/site`