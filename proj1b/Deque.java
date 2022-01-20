/**
 * PACKAGE_NAME
 *
 * @author quanlinlin
 * @date 2022/1/19 23:34
 * @since
 */
public interface Deque<T> {
  void addFirst(T item);

  void addLast(T item);

  boolean isEmpty();

  int size();

  void printDeque();

  T removeFirst();

  T removeLast();

  T get(int index);
}
