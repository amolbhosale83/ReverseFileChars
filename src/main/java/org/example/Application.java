package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.file.FileReader;
import org.example.file.FileWriter;
import org.example.util.StringUtil;

@Slf4j
public class Application {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.txt";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.txt";

    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        FileWriter fileWriter = new FileWriter();
        StringUtil stringUtil = new StringUtil();
        ReverseFileContent reverseFileContent = new ReverseFileContent(fileReader, fileWriter, stringUtil);
        reverseFileContent.reverse(INPUT_FILE_PATH, OUTPUT_FILE_PATH);
    }
}