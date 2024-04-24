import data_structure.DoublyLinkedList;
import data_structure.HashMapLinked;

public class TableList {
  HashMapLinked<Integer, Table> tableList;

  public TableList() {
    tableList = new HashMapLinked<Integer, Table>();
  }

  public boolean create(Table table) {
    if (tableList.put(table.getNumber(), table)) {
      System.out.println("Table successfully registered!");
      return true;
    }

    System.out.println("Already exists a table with this number!");
    return false;
  }

  public Table read(Integer number) {
    Table table = tableList.get(number);

    if (table == null) {
      System.out.println("Table not found!");
    }

    return table;
  }

  public Table update(Integer number, Table table) {
    Table oldTable = tableList.get(number);

    if (oldTable != null) {
      tableList.update(number, table.getNumber(), table);
      System.out.println("Table updated!");
      return table;
    }

    System.out.println("Table not found!");
    return null;
  }

  public Table delete(Integer number) {
    Table table = tableList.remove(number);

    if (table == null) {
      System.out.println("Table not found!");
      return null;
    }

    System.out.println("Table deleted!");
    return table;
  }

  public DoublyLinkedList<Table> readAll() {
    return tableList.values();
  }

  public boolean allocateClient(Integer tableNumber, Client client) {
    Table table = tableList.get(tableNumber);

    if (table == null) {
      System.out.println("Table not found!");
      return false;
    }

    if (client == null) {
      System.out.println("Client not found!");
      return false;
    }

    if (client.getPeopleQuantity() == null) {
      System.out.println("Set a people quantity to client!");
      return false;
    }

    if (!table.canOccupate(client.getPeopleQuantity())) {
      System.out.println("Table capacity is not enough!");
      return false;
    }

    if (client.getTable() != null) {
      System.out.println("Client already has a table!");
      return false;
    }

    table.setClient(client);
    client.setTable(table);
    System.out.println("Client allocated to table!");
    return true;
  }

  public boolean deallocateClient(Integer tableNumber) {
    Table table = tableList.get(tableNumber);

    if (table == null) {
      System.out.println("Table not found!");
      return false;
    }

    Client client = table.getClient();

    if (client == null) {
      System.out.println("Table already deallocated!");
      return false;
    }

    table.setClient(null);
    System.out.println("Table deallocated!");
    return true;
  }

  public DoublyLinkedList<Table> getAvailableTables(Integer peopleQuantity) {
    DoublyLinkedList<Table> availableTables = new DoublyLinkedList<Table>();
    DoublyLinkedList<Table> tables = tableList.values();

    for (int i = 0; i < tables.size(); i++) {
      Table table = tables.get(i);

      if (table.canOccupate(peopleQuantity)) {
        availableTables.add(table);
      }
    }

    return availableTables;
  }

  public DoublyLinkedList<Table> getAvailableTables() {
    DoublyLinkedList<Table> availableTables = new DoublyLinkedList<Table>();
    DoublyLinkedList<Table> tables = tableList.values();

    for (int i = 0; i < tables.size(); i++) {
      Table table = tables.get(i);

      if (table.getClient() == null) {
        availableTables.add(table);
      }
    }

    return availableTables;
  }

  public DoublyLinkedList<Table> getOccupiedTables() {
    DoublyLinkedList<Table> occupiedTables = new DoublyLinkedList<Table>();
    DoublyLinkedList<Table> tables = tableList.values();

    for (int i = 0; i < tables.size(); i++) {
      Table table = tables.get(i);

      if (table.getClient() != null) {
        occupiedTables.add(table);
      }
    }

    return occupiedTables;
  }

  public DoublyLinkedList<Table> getTablesByCapacity(int capacity) {
    DoublyLinkedList<Table> tablesByCapacity = new DoublyLinkedList<Table>();
    DoublyLinkedList<Table> tables = tableList.values();

    for (int i = 0; i < tables.size(); i++) {
      Table table = tables.get(i);

      if (table.getCapacity() == capacity) {
        tablesByCapacity.add(table);
      }
    }

    return tablesByCapacity;
  }

  public void showList() {
    tableList.showList();
    System.out.println("----------------------------------------------------");
  }
}
