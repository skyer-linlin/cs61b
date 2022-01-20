/**
 * PACKAGE_NAME
 *
 * @author quanlinlin
 * @date 2022/1/17 00:25
 * @since
 */
public class LinkedListDeque<T> implements Deque<T> {

  // 双端链表
  // 双向指针连接
  // 单哨兵, 哨兵 next 指向头结点, 哨兵 previous 指向尾结点

  // 从哨兵节点开始
  private final Node<T> sentinel;
  private int size;


  public LinkedListDeque() {
    size = 0;
    //  哨兵初始化, 哨兵的内容也为 null
    sentinel = new Node<>(null, null, null);
    sentinel.next = sentinel;
    sentinel.prev = sentinel;
  }

  public static void main(String[] args) {
    final LinkedListDeque<Integer> deque = new LinkedListDeque<>();
    deque.printDeque();

    deque.addFirst(3);
    deque.printDeque();

    deque.addFirst(2);
    deque.printDeque();

    deque.addFirst(1);
    deque.printDeque();

    deque.addLast(4);
    deque.printDeque();

    deque.addLast(5);
    deque.printDeque();

    deque.removeFirst();
    deque.printDeque();

    deque.removeLast();
    deque.printDeque();

    System.out.println("deque.get(2) = " + deque.get(2));

    System.out.println("deque.getRecursive(1) = " + deque.getRecursive(1));

    deque.removeLast();
    deque.removeLast();

    deque.printDeque();
    deque.removeLast();

    deque.printDeque();

  }

  public void addFirst(T item) {
    if (item == null) {
      return;
    }
    final Node<T> cur = new Node<>(sentinel, item, sentinel.next);
    sentinel.next.prev = cur;
    sentinel.next = cur;

    size += 1;
  }

  public void addLast(T item) {
    if (item == null) {
      return;
    }
    final Node<T> cur = new Node<>(sentinel.prev, item, sentinel);
    sentinel.prev.next = cur;
    sentinel.prev = cur;

    size += 1;
  }

  public boolean isEmpty() {
    return sentinel.next.item == null;
  }

  public int size() {
    return size;
  }

  public void printDeque() {
    Node<T> cur = sentinel.next;
    while (cur.item != null) {
      System.out.print(cur.item + " ");
      cur = cur.next;
    }
    System.out.println();
  }

  public T removeFirst() {
    if (sentinel.next.item == null) {
      return null;
    }
    final Node<T> rem = sentinel.next;
    // 处理指针指向, 双向指针都要更新
    sentinel.next = sentinel.next.next;
    sentinel.next.prev = sentinel;
    rem.next = null;
    rem.prev = null;

    size -= 1;
    return rem.item;
  }

  public T removeLast() {
    // 说明是一个空表
    if (sentinel.prev.item == null) {
      return null;
    }
    final Node<T> rem = sentinel.prev;
    //  处理指针指向
    sentinel.prev = sentinel.prev.prev;
    sentinel.prev.next = sentinel;
    rem.next = null;
    rem.prev = null;

    size -= 1;
    return rem.item;
  }

  public T get(int index) {
    int i = 0;
    if (index >= size || index < 0) {
      return null;
    }
    Node<T> ptr = sentinel.next;
    while (i < index) {
      ptr = ptr.next;
      i += 1;
    }
    return ptr.item;
  }

  public T getRecursive(int index) {
    if (index >= size) {
      return null;
    }
    return getRecursive(index, sentinel.next);
  }

  private T getRecursive(int index, Node<T> node) {
    if (index == 0) {
      return node.item;
    }
    return getRecursive(index - 1, node.next);
  }

  static class Node<T> {
    private Node<T> prev;
    private T item;
    private Node<T> next;

    public Node(Node<T> prev, T item, Node<T> next) {
      this.prev = prev;
      this.item = item;
      this.next = next;
    }
  }
}
