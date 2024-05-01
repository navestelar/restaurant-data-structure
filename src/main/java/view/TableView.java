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
  }

  public Integer readNumber() {
    Integer input = null;
    Boolean isInputInvalid = false;

    do {
      try {
        System.out.print("Table number: ");
        input = Integer.parseInt(System.console().readLine());
        isInputInvalid = false;
      } catch (NumberFormatException ex) {
        System.out.println("Not a number, try again");
        isInputInvalid = true;
      }
    } while (isInputInvalid);

    return input;
  }

  public Integer readCapacity() {
    Integer input = null;
    Boolean isInputInvalid = false;

    do {
      try {
        System.out.print("Table capacity: ");
        input = Integer.parseInt(System.console().readLine());
        isInputInvalid = false;
      } catch (NumberFormatException ex) {
        System.out.println("Not a number, try again");
        isInputInvalid = true;
      }
    } while (isInputInvalid);

    return input;
  }

  public Integer readClientId() {
    Integer input = null;
    Boolean isInputInvalid = false;

    do {
      try {
        System.out.print("Id of the client to allocate: ");
        input = Integer.parseInt(System.console().readLine());
        isInputInvalid = false;
      } catch (NumberFormatException ex) {
        System.out.println("Not a number, try again");
        isInputInvalid = true;
      }
    } while (isInputInvalid);

    return input;
  }

  public String readSearchString() {
    System.out.print("Search table: ");
    return System.console().readLine();
  }

  public boolean readConfirmation() {
    System.out.print("Are you sure?(Y/N): ");
    String resposta = System.console().readLine().toUpperCase();
    return resposta.equals("Y");
  }

  public void showMessage(String message) {
    System.out.println(message);
  }
}
