package synthesizer;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
  /* Index for the next dequeue or peek. */
  private int first;            // index for the next dequeue or peek
  /* Index for the next enqueue. */
  private int last;
  /* Array for storing the buffer data. */
  private T[] rb;

  /**
   * Create a new ArrayRingBuffer with the given capacity.
   */
  public ArrayRingBuffer(int capacity) {
    // TODO: Create new array with capacity elements.
    //       first, last, and fillCount should all be set to 0.
    //       this.capacity should be set appropriately. Note that the local variable
    //       here shadows the field we inherit from AbstractBoundedQueue, so
    //       you'll need to use this.capacity to set the capacity.

    this.rb = (T[]) new Object[capacity];

    this.first = 0;
    this.last = 0;
    this.fillCount = 0;

    super.capacity = capacity;
  }

  /**
   * Adds x to the end of the ring buffer. If there is no room, then
   * throw new RuntimeException("Ring buffer overflow"). Exceptions
   * covered Monday.
   */
  public void enqueue(T x) {
    // TODO: Enqueue the item. Don't forget to increase fillCount and update last.

    if (isFull()) {
      throw new RuntimeException("Ring buffer overflow");
    }
    rb[last] = x;
    fillCount++;
    increaseLast();
  }

  private void increaseLast() {
    if (last + 1 >= capacity) {
      last = 0;
    } else {
      last++;
    }
  }

  /**
   * Dequeue oldest item in the ring buffer. If the buffer is empty, then
   * throw new RuntimeException("Ring buffer underflow"). Exceptions
   * covered Monday.
   */
  public T dequeue() {
    // TODO: Dequeue the first item. Don't forget to decrease fillCount and update
    if (isEmpty()) {
      throw new RuntimeException("Ring buffer underflow");
    }
    T res = rb[first];
    rb[first] = null;
    fillCount--;
    increaseFirst();
    return res;
  }

  private void increaseFirst() {
    if (first + 1 >= capacity) {
      first = 0;
    } else {
      first++;
    }
  }

  /**
   * Return oldest item, but don't remove it.
   */
  public T peek() {
    // TODO: Return the first item. None of your instance variables should change.
    if (isEmpty()) {
      throw new RuntimeException("Ring buffer underflow");
    }
    return rb[first];
  }

  @Override
  public Iterator<T> iterator() {
    return new Itr();
  }

  private class Itr implements Iterator<T> {
    private int ptr;

    public Itr() {
      this.ptr = 0;
    }

    @Override
    public boolean hasNext() {
      return ptr != fillCount();
    }

    @Override
    public T next() {
      if (ptr >= capacity()) {
        throw new NoSuchElementException();
      }
      final T val = rb[ptr];
      ptr++;
      return val;
    }
  }

  // TODO: When you get to part 5, implement the needed code to support iteration.
}
