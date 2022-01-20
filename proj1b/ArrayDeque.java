/**
 * PACKAGE_NAME
 *
 * @author quanlinlin
 * @date 2022/1/17 22:21
 * @since
 */
public class ArrayDeque<T> implements Deque<T> {

  private T[] items;
  private int size;
  private int nextFirstIndex;
  private int nextLastIndex;

  public ArrayDeque() {
    size = 0;
    items = (T[]) new Object[8];
    nextFirstIndex = 3;
    nextLastIndex = 4;
  }

  public static void main(String[] args) {
    final ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

    for (int i = 0; i < 12; i++) {
      if (i % 2 == 1) {
        arrayDeque.addFirst(i);
      } else {
        arrayDeque.addLast(i);
      }
    }

    arrayDeque.printDeque();

    for (int i = 0; i < 8; i++) {
      arrayDeque.removeLast();
    }
    arrayDeque.removeFirst();
    arrayDeque.printDeque();

  }

  @Override
  public void addFirst(T item) {
    if (item == null) {
      return;
    }
    // 如果数组已满,扩容
    if (size == items.length) {
      resize();
    }
    items[nextFirstIndex] = item;

    size += 1;
    nextFirstIndex = getNextFirstIndex();
  }

  // 扩容
  private void resize() {
    T[] array = (T[]) new Object[size * 2];
    // 沿着两边放
    final int newFirst = size + nextFirstIndex;
    System.arraycopy(items, 0, array, 0, nextFirstIndex + 1);
    if (nextLastIndex != 0) {
      System.arraycopy(items, nextLastIndex, array, newFirst + 1, items.length - nextLastIndex);
    }
    items = array;
    nextFirstIndex = newFirst;
    nextLastIndex = getNextLastIndex();
  }

  private int getNextFirstIndex() {
    // todo 头指针和尾指针相遇,说明数组满了,在添加新的元素空间不够时候扩容
    // 完成扩容部分
    return (nextLastIndex - size - 1 + 2 * items.length) % items.length;
  }

  @Override
  public void addLast(T item) {
    if (item == null) {
      return;
    }
    if (items.length == size) {
      resize();
    }
    items[nextLastIndex] = item;

    size += 1;
    nextLastIndex = getNextLastIndex();
  }

  private int getNextLastIndex() {
    return (nextFirstIndex + size + 1) % items.length;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public void printDeque() {
    int ptr = reIndex(nextFirstIndex + 1);
    for (int i = 0; i < size; i++) {
      System.out.print(items[reIndex(ptr + i)] + " ");
    }
    System.out.println();
  }

  @Override
  public T removeFirst() {
    final int index = (nextFirstIndex + 1 + items.length) % items.length;
    final T ans = items[index];
    items[index] = null;

    size -= 1;
    nextFirstIndex = getNextFirstIndex();

    ensureAndDesize();
    return ans;
  }

  private void ensureAndDesize() {
    double loadFactor = size / 1. / items.length;
    if (items.length > 8 && loadFactor < .25) {
      desize();
    }
  }

  // 数组缩容
  private void desize() {
    T[] array = (T[]) new Object[items.length / 2];
    // 右边必须要拷贝, 左边可能不用拷贝
    if (nextFirstIndex < nextLastIndex) {
      System.arraycopy(items, nextFirstIndex + 1, array, 3, size);
      nextLastIndex = 3 + size;
    } else {
      System.arraycopy(items, 0, array, 0, size);
      System.arraycopy(items, nextFirstIndex, array, nextFirstIndex - items.length / 2, items.length - nextFirstIndex);
    }
    items = array;
    nextFirstIndex = getNextFirstIndex();
  }

  @Override
  public T removeLast() {
    final int index = (nextLastIndex - 1 + items.length) % items.length;
    final T ans = items[index];
    items[index] = null;

    size -= 1;
    nextLastIndex = getNextLastIndex();

    ensureAndDesize();
    return ans;
  }

  @Override
  public T get(int index) {
    if (index < 0 || index > items.length || index >= size) {
      return null;
    }
    return items[reIndex(nextFirstIndex + index)];
  }

  private int reIndex(int index) {
    return (index + items.length) % items.length;
  }
}
