package controller;

import data_structure.DoublyLinkedList;
import data_structure.HashMapLinked;
import model.Client;
import model.Table;
import view.TableView;

public class TableController {
  private HashMapLinked<Integer, Table> tableList = new HashMapLinked<Integer, Table>();
  private ClientController clientController;
  private TableView view = new TableView();

  public TableController(ClientController clientController) {
    this.clientController = clientController;
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

  public void start() {
    Integer option = null;

    do {
      view.showMenu();
      Boolean isOptionInvalid = false;

      do {
        try {
          System.out.print("Enter an option: ");
          option = Integer.parseInt(System.console().readLine());
          isOptionInvalid = false;
        } catch (NumberFormatException ex) {
          System.out.println("Not a number, try again");
          isOptionInvalid = true;
        }
      } while (isOptionInvalid);

      switch (option) {
        case 1:
          allocateClient();
          break;
        case 2:
          vacateTable();
          break;
        case 3:
          seeOccupiedAndVacatedTables();
          break;
        case 4:
          changeTableCapacity();
          break;
        case 5:
          searchTable();
          break;
        case 6:
          listTables();
          break;
        case 0:
          view.showMessage("Exiting...");
          break;
        default:
          view.showMessage("Invalid option!");
          break;
      }
    } while (option != 0);
  }

  private DoublyLinkedList<Table> getAvailableTables(Integer peopleQuantity) {
    DoublyLinkedList<Table> availableTables = new DoublyLinkedList<Table>();

    for (int i = 0; i < tableList.size(); i++) {
      Table table = tableList.getByIndex(i);

      if (table != null && table.canOccupate(peopleQuantity)) {
        availableTables.add(table);
      }
    }

    return availableTables;
  }

  public boolean allocateClient() {
    Client client = clientController.setPeopleQuantity();

    if (client != null) {
      getAvailableTables(client.getPeopleQuantity()).showList();
      Integer number = view.readNumber();

      Table table = showTable(number);

      if (table != null) {
        if (table.canOccupate(client.getPeopleQuantity())) {
          if (client.getTable() != null) {
            view.showMessage("Change the client table? ");
            if (view.readConfirmation()) {
              client.getTable().setClient(null);
              client.setTable(table);
              table.setClient(client);
              view.showMessage("Client reallocated!");
              return true;
            }
            return false;
          }

          table.setClient(client);
          client.setTable(table);
          view.showMessage("Client allocated!");
          return true;
        }

        view.showMessage("Table already occupied or table capacity exceeded!");
      }
    }

    return false;
  }

  public boolean vacateTable() {
    listTables();
    Integer number = view.readNumber();

    Table table = showTable(number);

    if (table != null) {
      if (table.isOccupied()) {
        table.getClient().setTable(null);
        table.setClient(null);
        view.showMessage("Table vacated successfully!");
        return true;
      }
      view.showMessage("Table already empty!");
    }

    return false;
  }

  private void seeOccupiedAndVacatedTables() {
    view.showMessage(getTablesStatus().toStringWithKey());
  }

  public HashMapLinked<String, DoublyLinkedList<Table>> getTablesStatus() {
    HashMapLinked<String, DoublyLinkedList<Table>> tablesStatus = new HashMapLinked<String, DoublyLinkedList<Table>>();
    DoublyLinkedList<Table> tables = tableList.values();
    DoublyLinkedList<Table> occupiedTables = new DoublyLinkedList<Table>();
    DoublyLinkedList<Table> vacateTable = new DoublyLinkedList<Table>();

    for (Integer i = 0; i < tables.size(); i++) {
      Table table = tables.get(i);
      if (table.isOccupied()) {
        occupiedTables.add(table);
      } else {
        vacateTable.add(table);
      }
    }

    tablesStatus.put("Vacate", vacateTable);
    tablesStatus.put("Occupied", occupiedTables);

    return tablesStatus;
  }

  public void changeTableCapacity() {
    listTables();
    Integer number = view.readNumber();

    Table table = showTable(number);

    if (table != null) {
      Integer capacity = view.readCapacity();
      
      System.out.println("AAAAAAAAAAAA: " + table.isOccupied());
      System.out.println("BBBBBBBBBBBBBB: " + table.getClient().getPeopleQuantity());
      System.out.println("CCCCCCCCCCCCC: " + capacity);
      if ((table.isOccupied()) && (capacity < table.getClient().getPeopleQuantity())) {
        view.showMessage("You can't change the capacity of a table for a number lower than the client people number!");
      } else {
        table.setCapacity(capacity);
        view.showMessage("Table capacity changed!");
      }
    }
  }

  public Table getTableByNumber(Integer number) {
    return tableList.get(number);
  }

  public void listTables() {
    view.showMessage(tableList.toString());
  }

  private void searchTable() {
    String value = view.readSearchString();

    HashMapLinked<Integer, Table> searchTables = tableList.searchString(value);

    if (searchTables.size() > 0) {
      System.out.println(searchTables.toStringWithKey());
    } else {
      view.showMessage("Table not found!");
    }
  }

  public Table showTable(Integer number) {
    Table table = tableList.get(number);

    if (table != null) {
      view.showMessage(table.toString());
    } else {
      view.showMessage("Table not found!");
    }

    return table;
  }
}
