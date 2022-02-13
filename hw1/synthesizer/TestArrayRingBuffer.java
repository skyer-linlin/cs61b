package synthesizer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests the ArrayRingBuffer class.
 *
 * @author Josh Hug
 */

public class TestArrayRingBuffer {
  ArrayRingBuffer<Double> arb;

  /**
   * Calls tests for ArrayRingBuffer.
   */
  public static void main(String[] args) {
    jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
  }

  @Before
  public void initialize() {
    arb = new ArrayRingBuffer<>(5);

  }


  @Test
  public void someTest() {
    arb.enqueue(5.5);


  }

  @Test
  public void enqueue() {
    arb.enqueue(1.1);
    arb.enqueue(2.2);
    arb.enqueue(3.3);
    arb.enqueue(4.4);
    assertEquals(4, arb.fillCount());
  }

  @Test(expected = RuntimeException.class)
  public void enqueue_fullfilled_exception() {
    arb.enqueue(1.1);
    arb.enqueue(2.2);
    arb.enqueue(3.3);
    arb.enqueue(4.4);
    arb.enqueue(5.5);
    assertTrue(arb.isFull());

    arb.enqueue(6.6);
  }

  @Test
  public void enqueue_arrayLoop() {
    arb.enqueue(1.1);
    arb.enqueue(2.2);
    arb.enqueue(3.3);
    arb.enqueue(4.4);
    arb.enqueue(5.5);

    arb.dequeue();
    arb.enqueue(6.6);
    arb.dequeue();
    arb.enqueue(7.7);

    arb.dequeue();
    arb.dequeue();
    arb.dequeue();
    assertEquals(6.6, arb.dequeue(), .001);
    assertEquals(7.7, arb.dequeue(), .001);
    assertTrue(arb.isEmpty());
  }

  @Test
  public void dequeue() {
    arb.enqueue(1.1);
    arb.enqueue(2.2);
    arb.enqueue(3.3);
    arb.enqueue(4.4);
    assertEquals(1.1, arb.dequeue(), .001);
  }

  @Test(expected = RuntimeException.class)
  public void dequeue_empty_exception() {
    assertTrue(arb.isEmpty());
    arb.dequeue();
  }

  @Test
  public void peek() {
    arb.enqueue(2.2);
    assertEquals(2.2, arb.peek(), .001);
  }
}
