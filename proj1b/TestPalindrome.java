import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
  // You must use this palindrome, and not instantiate
  // new Palindromes, or the autograder might be upset.
  static Palindrome palindrome = new Palindrome();

  @Test
  public void testWordToDeque() {
    Deque d = palindrome.wordToDeque("persiflage");
    String actual = "";
    for (int i = 0; i < "persiflage".length(); i++) {
      actual += d.removeFirst();
    }
    assertEquals("persiflage", actual);
  }

  @Test
  public void testWordToDequeLong() {
    Deque d = palindrome.wordToDeque("pneumonoultramicroscopicsilicovolcanoconiosis");
    String actual = "";
    for (int i = 0; i < "pneumonoultramicroscopicsilicovolcanoconiosis".length(); i++) {
      actual += d.removeFirst();
    }
    assertEquals("pneumonoultramicroscopicsilicovolcanoconiosis", actual);
  }

  @Test
  public void testIsPalindrome() {
    assertTrue(palindrome.isPalindrome("noon"));
    assertTrue(palindrome.isPalindrome("racecar"));
    assertTrue(palindrome.isPalindrome("a"));
    assertTrue(palindrome.isPalindrome(""));
    assertFalse(palindrome.isPalindrome("horse"));
    assertTrue(palindrome.isPalindrome(null));

    final CharacterComparator cc = new OffByOne();
    assertTrue(palindrome.isPalindrome("flake", cc));
    assertFalse(palindrome.isPalindrome("horse", cc));

  }


}
