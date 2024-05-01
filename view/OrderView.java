package view;

public class OrderView {
  public void showMenu() {
    System.out.println("** Order Menu **");
    System.out.println("------------------------");
    System.out.println("1 - Register Order");
    System.out.println("2 - Update Order");
    System.out.println("3 - Cancel Order");
    System.out.println("4 - Search Order");
    System.out.println("5 - List Orders");
    System.out.println("0 - Exit");
    System.out.println("------------------------");
    System.out.print("Enter an option: ");
  }

  public void showMenuUpdate() {
    System.out.println("What informations do you want to update?");
    System.out.println("------------------------");
    System.out.println("1 - Table");
    System.out.println("2 - Employee");
    System.out.println("3 - Order Items");
    System.out.println("0 - Update Order");
    System.out.println("------------------------");
    System.out.print("Choose the information: ");
  }

  public Integer readTableNumber() {
    Integer input = null;
    Boolean isInputInvalid = false;

    do {
      try {
        System.out.print("Table Number: ");
        input = Integer.parseInt(System.console().readLine());
        isInputInvalid = false;
      } catch (NumberFormatException ex) {
        System.out.println("Not a number, try again");
        isInputInvalid = true;
      }
    } while (isInputInvalid);

    return input;
  }

  public Integer readEmployeeId() {
    Integer input = null;
    Boolean isInputInvalid = false;

    do {
      try {
        System.out.print("Employee id: ");
        input = Integer.parseInt(System.console().readLine());
        isInputInvalid = false;
      } catch (NumberFormatException ex) {
        System.out.println("Not a number, try again");
        isInputInvalid = true;
      }
    } while (isInputInvalid);

    return input;
  }

  public String readOrderItemName() {
    System.out.print("Order item name: ");
    return System.console().readLine();
  }

  public Integer readId() {
    Integer input = null;
    Boolean isInputInvalid = false;

    do {
      try {
        System.out.print("Id: ");
        input = Integer.parseInt(System.console().readLine());
        isInputInvalid = false;
      } catch (NumberFormatException ex) {
        System.out.println("Not a number, try again");
        isInputInvalid = true;
      }
    } while (isInputInvalid);

    return input;
  }

  public boolean readConfirmation() {
    System.out.print("Are you sure?(Y/N): ");
    String resposta = System.console().readLine().toUpperCase();
    return resposta.equals("Y");
  }

  public String readSearchString() {
    System.out.print("Search order: ");
    return System.console().readLine();
  }

  public void showMessage(String message) {
    System.out.println(message);
  }
}
