package view;

public class TableView {
  public void showMenu() {
    System.out.println("** Table Menu **");
    System.out.println("------------------------");
    System.out.println("1 - Allocate client in table");
    System.out.println("2 - Vacate table");
    System.out.println("3 - See occupied and vacated tables");
    System.out.println("4 - Update table capacity");
    System.out.println("5 - Search Table");
    System.out.println("6 - List Tables");
    System.out.println("0 - Exit");
    System.out.println("------------------------");
    System.out.print("Enter an option: ");
  }
  public Integer readNumber() {
    System.out.print("Table number: ");
    return Integer.parseInt(System.console().readLine());
  }

  public Integer readCapacity() {
    System.out.print("Table capacity: ");
    return Integer.parseInt(System.console().readLine());
  }

  public Integer readClientId() {
    System.out.print("Id of the client to allocate: ");
    return Integer.parseInt(System.console().readLine());
  }

  public String readSearchString() {
    System.out.print("Search table: ");
    return System.console().readLine();
  }

  public void showMessage(String message) {
    System.out.println(message);
  }
}
