/**
 * PACKAGE_NAME
 *
 * @author quanlinlin
 * @date 2022/1/19 23:26
 * @since
 */
public class Palindrome {
  public Deque<Character> wordToDeque(String word) {
    final Deque<Character> deque = new LinkedListDeque<>();
    if (word == null) {
      return deque;
    }
    final char[] chars = word.toCharArray();
    for (char ch : chars) {
      deque.addLast(ch);
    }
    return deque;
  }

  public boolean isPalindrome(String word) {
    final Deque<Character> deque = wordToDeque(word);
    return check(deque);
  }

  private boolean check(Deque<Character> deque) {
    if (deque.size() == 1 || deque.isEmpty()) {
      return true;
    }
    if (deque.removeFirst() != deque.removeLast()) {
      return false;
    }
    return check(deque);
  }

  public boolean isPalindrome(String word, CharacterComparator cc) {
    final Deque<Character> deque = wordToDeque(word);
    return check(deque, cc);
  }

  private boolean check(Deque<Character> deque, CharacterComparator cc) {
    if (deque.size() == 1 || deque.isEmpty()) {
      return true;
    }
    if (!cc.equalChars(deque.removeFirst(), deque.removeLast())) {
      return false;
    }
    return check(deque, cc);
  }
}
