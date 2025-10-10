package org.example.chapter_8_1;

public class StringManipulator {

    public StringManipulator() {}

    //Concatenates two input strings and returns the result.
    public static String concatenate(String string1, String string2) {
        return string1 + string2;
    }

    //Returns the length of the input string.
    public static int findLength(String string) {
        return string.length();
    }

    //Converts the input string to uppercase and returns the result.
    public static String convertToUpperCase(String string) {
        return string.toUpperCase();
    }

    //Converts the input string to lowercase and returns the result.
    public static String convertToLowerCase(String string) {
        return string.toLowerCase();
    }

    //Checks if the input string contains the given substring and returns true if it does, otherwise returns false.
    public static boolean containsSubstring(String string, String subString) {
        return string.contains(subString);
    }
}
