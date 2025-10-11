import org.example.PalindromeChecker;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromeCheckerTest {
    @Test
    public void testIsPalindrome() {
        PalindromeChecker checker = new PalindromeChecker();

        assertTrue(checker.isPalindrome("radar"));

        // Special case: skip whitespace.
        assertTrue(checker.isPalindrome("A man, a plan, a canal, Panama"));

        assertFalse(checker.isPalindrome("hello"));
        assertFalse(checker.isPalindrome("openai"));
    }
}