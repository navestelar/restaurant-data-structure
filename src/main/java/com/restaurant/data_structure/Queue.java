package com.restaurant.data_structure;

public class Queue<T> {
  private Node<T> head;
  private Node<T> tail;
  private int capacity;
  private int size = 0;

  public Queue(int capacity) {
    this.capacity = capacity;
  }

  public boolean push(T data) {
    if (hasSpace()) {
      Node<T> newNode = new Node<T>(data);

      if (isEmpty()) {
        head = newNode;
        tail = newNode;
      } else {
        tail.setNext(newNode);
        tail = newNode;
      }

      size++;
      return true;
    }
    return false;
  }

  public T pop() {
    if (!isEmpty()) {
      Node<T> temp = head;
      head = head.getNext();
      size--;
      return temp.getData();
    }

    if (isEmpty())
      tail = null;

    return null;
  }

  public T peek() {
    if (!isEmpty()) {
      return head.getData();
    }
    return null;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public boolean hasSpace() {
    return size < capacity;
  }

  public Node<T> getHead() {
    return head;
  }

  public int getSize() {
    return size;
  }
}
