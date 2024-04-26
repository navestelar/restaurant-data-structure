package data_structure;

public class DoublyLinkedList<T> {
  private Node<T> head = null;
  private Node<T> tail = null;
  private Integer size = 0;

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
    Integer index = 0;

    while (temp != null) {
      if (temp.getData() != null)
        System.out.println(temp.getData().toString());

      temp = temp.getNext();
      index++;
    }
  }

  public void showListIndex() {
    Node<T> temp = head;
    Integer index = 0;

    while (temp != null) {
      if (temp.getData() != null)
        System.out.println("Index: " + index + ", " + temp.getData().toString());

      temp = temp.getNext();
      index++;
    }
  }

  public String toString() {
    Node<T> temp = head;
    String result = "";

    while (temp != null) {
      if (temp.getData() != null)
        result += temp.getData().toString() + "\n";

      temp = temp.getNext();
    }

    return result;
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
      if (temp.getData().equals(data)) {
        return true;
      }
      temp = temp.getNext();
    }

    return false;
  }

  public DoublyLinkedList<T> searchString(String value) {
    DoublyLinkedList<T> result = new DoublyLinkedList<T>();
    Node<T> temp = head;

    while (temp != null) {
      if (temp.getData().toString().contains(value)) {
        result.add(temp.getData());
      }
      temp = temp.getNext();
    }

    return result;
  }

  public boolean update(T data, T newData) {
    Node<T> temp = head;

    while (temp != null) {
      if (temp.getData().equals(data)) {
        temp.setData(newData);
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