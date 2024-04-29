package controller;

import data_structure.HashMapLinked;
import model.Table;

public class TableController {
  private HashMapLinked<Integer, Table> tableList = new HashMapLinked<Integer, Table>();

  public TableController() {
    tableList.put(1, new Table(1, 1));
    tableList.put(2, new Table(2, 2));
    tableList.put(3, new Table(3, 3));
    tableList.put(4, new Table(4, 4));
    tableList.put(5, new Table(5, 5));
    tableList.put(6, new Table(6, 6));
    tableList.put(7, new Table(7, 7));
    tableList.put(8, new Table(8, 8));
    tableList.put(9, new Table(9, 9));
    tableList.put(10, new Table(10, 10));
    tableList.put(11, new Table(11, 11));
    tableList.put(12, new Table(12, 12));
  }
  public Table getTableByNumber(Integer number) {
    return tableList.get(number);
  }
}
