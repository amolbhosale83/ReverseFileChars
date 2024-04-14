package org.example.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StringUtil {

    public String reverse(String fileContent) {
        char[] fileCharArr = fileContent.toCharArray();
        for(int start = 0, end = fileContent.length() - 1; start < end; start++, end--) {
            swap(fileCharArr, start, end);
        }
        String reversedContent = new String(fileCharArr);
        log.debug("Reversed file content: {}", reversedContent);
        return reversedContent;
    }

    private void swap(char[] fileCharArr, int start, int end) {
        char temp = fileCharArr[start];
        fileCharArr[start] = fileCharArr[end];
        fileCharArr[end] = temp;
    }
}
