package org.example.chapter_8_1;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringManipulatorTest {
    @Test
    public void concatenateTest() {
        String string1 = "abc";
        String string2 = "def";
        String result = StringManipulator.concatenate(string1, string2);
        assertEquals(result, "abcdef");
        assertEquals(result, string1 + string2);
    }

    @Test
    public void findLengthTest(){
        String string = "abcdef";
        int length = StringManipulator.findLength(string);
        assertEquals(length, 6);
        assertEquals(length, string.length());
    }

    @Test
    public void convertToUpperCaseTest() {
        String string = "abc";
        String result = StringManipulator.convertToUpperCase(string);
        assertEquals(result, "ABC");
        assertEquals(result, string.toUpperCase());
    }

    @Test
    public void convertToLowerCaseTest() {
        String string = "ABC";
        String result = StringManipulator.convertToLowerCase(string);
        assertEquals(result, "abc");
        assertEquals(result, string.toLowerCase());
    }

    @Test
    public void containsSubstringTest() {
        String string = "abcdef";
        String subString1 = "def";
        String subString2 = "ghi";
        assertTrue(StringManipulator.containsSubstring(string, subString1));
        assertFalse(StringManipulator.containsSubstring(string, subString2));
    }
}
