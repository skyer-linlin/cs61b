package synthesizer;

import java.util.Iterator;

/**
 * synthesizer
 * <p>
 * 队尾入队,队首出队,固定容量,队列为 null 时不允许入队
 *
 * @author quanlinlin
 * @date 2022/2/13 14:53
 * @since
 */
public interface BoundedQueue<T> extends Iterable<T> {
  int capacity();     // return size of the buffer

  int fillCount();    // return number of items currently in the buffer

  void enqueue(T x);  // add item x to the end

  T dequeue();        // delete and return item from the front

  T peek();           // return (but do not delete) item from the front

  /**
   * is the buffer empty (fillCount equals zero)?
   *
   * @return
   */
  default boolean isEmpty() {
    return fillCount() == 0;
  }

  /**
   * is the buffer full (fillCount is same as capacity)?
   *
   * @return
   */
  default boolean isFull() {
    return fillCount() == capacity();
  }
}
