package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.file.FileReader;
import org.example.file.FileWriter;
import org.example.util.StringUtil;

@Slf4j
public class ReverseFileContent {

    private FileReader fileReader;
    private FileWriter fileWriter;
    private StringUtil stringUtil;

    public ReverseFileContent(FileReader fileReader, FileWriter fileWriter, StringUtil stringUtil) {
        this.fileReader = fileReader;
        this.fileWriter = fileWriter;
        this.stringUtil = stringUtil;
    }

    public void reverse(String inputFilePath, String outputFilePath) {
        String fileContent = fileReader.readFile(inputFilePath);
        // We can also use StringBuilder.reverse() API instead.
        String reversedFileContent = stringUtil.reverse(fileContent);
        fileWriter.write(reversedFileContent, outputFilePath);
    }

}
