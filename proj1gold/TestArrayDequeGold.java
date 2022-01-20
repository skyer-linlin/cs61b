import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * PACKAGE_NAME
 *
 * @author quanlinlin
 * @date 2022/1/20 14:20
 * @since
 */
public class TestArrayDequeGold {

  private final StudentArrayDeque<Integer> sad = new StudentArrayDeque<>();

  private final ArrayDequeSolution<Integer> ads = new ArrayDequeSolution<>();

  @Test
  public void test() {
    for (int i = 0; i < 10; i++) {
      final double d = StdRandom.uniform();
      if (d > 0.5) {
        sad.addFirst(i);
        ads.addFirst(i);
      } else {
        sad.addLast(i);
        ads.addLast(i);
      }
    }

    sad.printDeque();
    ads.printDeque();

    for (int i = 0; i < 10; i++) {
      final double d = StdRandom.uniform();
      if (d > 0.5) {
        assertEquals(ads.removeFirst(), sad.removeFirst());
      } else {
        assertEquals(ads.removeLast(), sad.removeLast());
      }
    }
  }

}
