package view;

public class OrderItemView {
  public void showMenu() {
    System.out.println("** Order Menu Item**");
    System.out.println("------------------------");
    System.out.println("1 - Register Order Item");
    System.out.println("2 - Update Order Item");
    System.out.println("3 - Exclude Order Item");
    System.out.println("4 - Search Order Item");
    System.out.println("5 - List Orders Items");
    System.out.println("0 - Exit");
    System.out.println("------------------------");
  }

  public void showMenuUpdate() {
    System.out.println("What informations do you want to update?");
    System.out.println("------------------------");
    System.out.println("1 - Product");
    System.out.println("2 - Quantity");
    System.out.println("0 - Update Order Item");
    System.out.println("------------------------");
  }

  public Integer readQuantity() {
    Integer input = null;
    Boolean isInputInvalid = false;

    do {
      try {
        System.out.print("Quantity: ");
        input = Integer.parseInt(System.console().readLine());
        isInputInvalid = false;
      } catch (NumberFormatException ex) {
        System.out.println("Not a number, try again");
        isInputInvalid = true;
      }
    } while (isInputInvalid);

    return input;
  }

  public String readProductName() {
    System.out.print("Product name: ");
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
