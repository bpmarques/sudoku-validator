@ECHO OFF
ECHO Packing the project...
CALL mvn -q clean package
ECHO JAR file created successfully, starting the validator...
CALL java -jar ./target/sudoku-validator-1.0-SNAPSHOT.jar %1
PAUSE