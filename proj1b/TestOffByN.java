import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * PACKAGE_NAME
 *
 * @author quanlinlin
 * @date 2022/1/20 01:26
 * @since
 */
public class TestOffByN {
  @Test
  public void testEqualChars() {
    final CharacterComparator offBy5 = new OffByN(5);
    assertTrue(offBy5.equalChars('a', 'f'));  // true
    assertTrue(offBy5.equalChars('f', 'a'));  // true
    assertFalse(offBy5.equalChars('f', 'h'));
  }
}
