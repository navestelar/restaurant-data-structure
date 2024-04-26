package data_structure;

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
    for (Integer i = 0; i < size; i++) {
      System.out.println("Key: " + keyList.get(i) + ", value: " + valueList.get(i));
    }
  }

  public String toString() {
    String result = "";

    for (Integer i = 0; i < size; i++) {
      result += "Key: " + keyList.get(i) + ", value: " + valueList.get(i) + "\n";
    }

    return result;
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