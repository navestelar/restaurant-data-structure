package com.restaurant.data_structure;

public class HashMapLinked<K, T> {
  private DoublyLinkedList<K> keyList;
  private DoublyLinkedList<T> valueList;
  private Integer size = 0;

  public HashMapLinked() {
    keyList = new DoublyLinkedList<K>();
    valueList = new DoublyLinkedList<T>();
  }

  public boolean put(K key, T value) {
    if (keyList.contains(key))
      return false;

    keyList.add(key);
    valueList.add(value);
    size++;
    return true;
  }

  public T get(K key) {
    return valueList.get(keyList.indexOf(key));
  }

  public T getByIndex(Integer index) {
    return valueList.get(index);
  }

  public T remove(K key) {
    if (!keyList.contains(key))
      return null;
    T value = valueList.get(keyList.indexOf(key));
    keyList.remove(key);
    valueList.remove(value);
    size--;
    return value;
  }

  public boolean update(K key, K newKey, T newData) {
    if (!keyList.contains(key))
      return false;

    valueList.update(valueList.get(keyList.indexOf(key)), newData);
    keyList.update(key, newKey);

    return true;
  }

  public void showList() {
    valueList.showList();
  }

  public String toString() {
    String result = "";

    for (Integer i = 0; i < size; i++) {
      result += "\n"+valueList.get(i).toString();
    }

    return result;
  }

  public String toStringWithKey() {
    String result = "";

    for (Integer i = 0; i < size; i++) {
      result += "\nKey: " + keyList.get(i) + ", value: " + valueList.get(i);
    }

    return result;
  }

  public HashMapLinked<K, T> searchString(String value) {
    HashMapLinked<K, T> resultList = new HashMapLinked<K, T>();
    DoublyLinkedList<T> valuesMatch = valueList.searchString(value);

    for (Integer i = 0; i < valuesMatch.size(); i++) {
      resultList.put(keyList.get(valueList.indexOf(valuesMatch.get(i))), valuesMatch.get(i));
    }
    
    return resultList;
  }

  public boolean containsKey(K key) {
    return keyList.contains(key);
  }

  public boolean contains(T value) {
    return valueList.contains(value);
  }

  public DoublyLinkedList<K> keySet() {
    return keyList;
  }

  public DoublyLinkedList<T> values() {
    return valueList;
  }

  public boolean isEmpty() {
    return keyList.isEmpty();
  }

  public Integer size() {
    return size;
  }
}