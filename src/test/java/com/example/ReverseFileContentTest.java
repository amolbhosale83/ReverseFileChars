package com.example;

import org.example.ReverseFileContent;
import org.example.file.FileReader;
import org.example.file.FileWriter;
import org.example.util.StringUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Matchers;

import static org.mockito.Mockito.*;

/* While running this test class with Java 9+ version, please add following VM option.
        --add-opens=java.base/java.lang=ALL-UNNAMED
*/
public class ReverseFileContentTest {

    private static FileReader fileReader;
    private static FileWriter fileWriter;
    private static StringUtil stringUtil;
    private static ReverseFileContent reverseFileContent;
    private String inputFilePath = "dummy/input/path";
    private String outputFilePath = "dummy/output/path";

    @BeforeClass
    public static void setUp() {
        fileReader = mock(FileReader.class);
        fileWriter = mock(FileWriter.class);
        stringUtil = new StringUtil();
        reverseFileContent = new ReverseFileContent(fileReader, fileWriter, stringUtil);
    }

    @Test
    public void testReverseFileContent() {

        String inputFileContent = "ABC";
        String expectedReversedContent = "CBA";
        when(fileReader.readFile(Matchers.anyString())).thenReturn(inputFileContent);

        reverseFileContent.reverse(inputFilePath, outputFilePath);

        verify(fileReader, times(1)).readFile(inputFilePath);
        verify(fileWriter, times(1)).write(expectedReversedContent, outputFilePath);

    }
}
