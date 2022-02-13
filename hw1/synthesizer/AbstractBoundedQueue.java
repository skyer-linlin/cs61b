package synthesizer;

/**
 * synthesizer
 *
 * @author quanlinlin
 * @date 2022/2/13 15:07
 * @since
 */
public abstract class AbstractBoundedQueue<T> implements BoundedQueue<T> {
  protected int fillCount;
  protected int capacity;

  @Override
  public int capacity() {
    return capacity;
  }

  @Override
  public int fillCount() {
    return fillCount;
  }
}
