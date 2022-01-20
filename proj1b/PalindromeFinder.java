/**
 * This class outputs all palindromes in the words file in the current directory.
 */
public class PalindromeFinder {

  public static void main(String[] args) {
    int minLength = 4;
    // In in = new In("../library-sp18/data/words.txt");
    Palindrome palindrome = new Palindrome();
    int[] arr = new int[54];

    for (int i = 0; i < 54; i++) {
      In in = new In("../library-sp18/data/words.txt");
      while (!in.isEmpty()) {
        String word = in.readString();
        if (word.length() >= minLength && palindrome.isPalindrome(word, new OffByN(i))) {
          System.out.print(word + " ");
          arr[i] += 1;
        }
      }
      System.out.println(", i = " + i + ", count = " + arr[i]);
    }
  }
}
