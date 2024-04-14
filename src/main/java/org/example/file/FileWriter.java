package org.example.file;

import lombok.extern.slf4j.Slf4j;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

@Slf4j
public class FileWriter {

    public void write(String reversedFileContent, String outputFilePath) {
        log.info("Writing to output file '{}'", outputFilePath);
        try(PrintWriter printWriter = new PrintWriter(outputFilePath)) {
            printWriter.write(reversedFileContent);
            printWriter.flush();
            log.info("Reversed content is written to output file '{}'", outputFilePath);
        } catch (FileNotFoundException e) {
            log.error("The output file '{}' does not exist.", outputFilePath);
            throw new RuntimeException(e);
        }
    }
}
