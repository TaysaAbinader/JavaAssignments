package org.example;

import java.util.ArrayList;

public class PalindromeChecker {
    public boolean isPalindrome(String str) {
        // Error checks: string is null or empty.
        if (str == null || str.isEmpty()) {
            return false;
        }

        int length = str.length();

        // A single character is always a palindrome.
        if (length == 1) {
            return true;
        }

        ArrayList<Character> ignoredChars = new ArrayList<>();
        ignoredChars.add(' '); // whitespace
        ignoredChars.add(','); // comma

        int left = 0;
        int right = length - 1;
        while (left < right) {
            // Skip ignored characters to the left.
            if (ignoredChars.contains(str.charAt(left))) {
                left++;
                continue;
            }
            // Skip ignored characters to the right.
            if (ignoredChars.contains(str.charAt(right))) {
                right--;
                continue;
            }
            // Convert all characters to lowercase when comparing.
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase((str.charAt(right)))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}