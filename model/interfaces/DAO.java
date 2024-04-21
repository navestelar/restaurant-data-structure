package model.interfaces;

import data_structure.DoublyLinkedList;

public interface DAO<T> {
  boolean create(T data);
  T read(Integer id);
  T update(T data);
  T delete(Integer id);
  DoublyLinkedList<T> readAll();
}
