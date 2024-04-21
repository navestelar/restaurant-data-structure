package data_structure;

public class DoublyLinkedList<T> {
  private Node<T> head = null;
  private Node<T> tail = null;
  private Integer size = 0;

  // add back
  public void add(T value) {
    Node<T> temp = new Node<T>(value, null, tail);

    if (tail != null) {
      tail.setNext(temp);
    }

    tail = temp;

    if (head == null) {
      head = temp;
    }

    size++;
  }

  public void showList() {
    Node<T> temp = head;

    while (temp != null) {
      if (temp.getData() != null)
        System.out.println(temp.getData().toString());

      temp = temp.getNext();
    }
  }

  public T remove(T data) {
    Node<T> temp = head;

    while (temp != null) {
      if (temp.getData().equals(data)) {
        if (temp != head) {
          temp.getPrev().setNext(temp.getNext());
        } else {
          head = temp.getNext();
        }

        if (temp.getNext() != null) {
          temp.getNext().setPrev(temp.getPrev());
        } else {
          tail = temp;
        }

        size--;
        return temp.getData();
      }

      temp = temp.getNext();
    }

    return null;
  }

  public T get(Integer index) {
    Integer tempIndex = 0;
    Node<T> temp = head;

    while (temp != null) {
      if (tempIndex == index) {
        return temp.getData();
      }
      temp = temp.getNext();
      tempIndex++;
    }

    return null;
  }

  public Integer indexOf(T data) {
    Integer index = 0;
    Node<T> temp = head;

    while (temp != null) {
      if (temp.getData().equals(data)) {
        return index;
      }
      temp = temp.getNext();
      index++;
    }

    return null;
  }

  public boolean contains(T data) {
    Node<T> temp = head;
    
    while (temp != null) {
      if (temp.getData().toString().equals(data.toString())) {
        return true;
      }
      temp = temp.getNext();
    }

    return false;
  }

  public Integer size() {
    return size;
  }

  public boolean isEmpty() {
    return head == null;
  }
}
