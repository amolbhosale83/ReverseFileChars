package org.example.file;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

@Slf4j
public class FileReader {

    public String readFile(String inputFilePath) {
        log.info("Reading input file '{}'", inputFilePath);
        java.io.FileReader fileReader = getFileReader(inputFilePath);
        StringBuilder stringBuilder = new StringBuilder();
        try(BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String fileLine;
            while((fileLine = bufferedReader.readLine()) != null) {
                // TODO: If file is very large, then we need to reverse and write line by line.
                stringBuilder.append(fileLine);
                stringBuilder.append('\n');
            }
        } catch (IOException e) {
            log.error("An exception occurred while reading input file.");
            throw new RuntimeException(e);
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        log.debug("Input file content: {}", stringBuilder.toString());
        return stringBuilder.toString();
    }

    private java.io.FileReader getFileReader(String inputFilePath) {
        java.io.FileReader fileReader = null;
        try {
            fileReader = new java.io.FileReader(inputFilePath);
        } catch (FileNotFoundException e) {
            log.error("The input file '{}' does not exist.", inputFilePath);
            throw new RuntimeException(e);
        }
        return fileReader;
    }
}
