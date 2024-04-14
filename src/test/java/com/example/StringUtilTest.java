package com.example;

import org.example.util.StringUtil;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilTest {

    private static StringUtil stringUtil;

    @BeforeClass
    public static void setUp() {
        stringUtil = new StringUtil();
    }

    @Test
    public void testSimpleReverse() {
        String inputStr = "ABC";
        String reversedStr = stringUtil.reverse(inputStr);
        assertEquals("CBA", reversedStr);
    }

    @Test
    public void testReverseWithSpace() {
        String inputStr = "ABC DEF GHI";
        String reversedStr = stringUtil.reverse(inputStr);
        assertEquals("IHG FED CBA", reversedStr);
    }

    @Test
    public void testMultilineReverse() {
        String inputStr = "ABC\nDEF\nGHI";
        String reversedStr = stringUtil.reverse(inputStr);
        assertEquals("IHG\nFED\nCBA", reversedStr);
    }
}
