import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

  @Test
  public void testEqualChars() {
    assertFalse(offByOne.equalChars('a', 'e'));
    assertFalse(offByOne.equalChars('a', 'A'));
    assertTrue(offByOne.equalChars('z', 'y'));
    assertTrue(offByOne.equalChars('a', 'b'));
    assertTrue(offByOne.equalChars('&', '%'));
  }
}
