package data_structure;

public class Stack<T> {
  private Node<T> tail;
  private int size;
  private int capacity;

  public Stack(int capacity) {
    this.capacity = capacity;
    this.tail = null;
    this.size = 0;
  }

  public boolean push(T data) {
    if (hasSpace()) {
      Node<T> newNode = new Node<T>(data);
      tail = newNode;
      size++;
      return true;
    }
    return false;
  }

  public T pop() {
    if (!isEmpty()) {
      Node<T> temp = tail;
      tail = tail.getNext();
      size--;
      return temp.getData();
    }

    return null;
  }

  public T peek() {
    if (!isEmpty()) {
      return tail.getData();
    }
    return null;
  }

  public boolean hasSpace() {
    return size < capacity;
  }

  public boolean isEmpty() {
    return tail == null;
  }

  public int getSize() {
    return size;
  }
}
