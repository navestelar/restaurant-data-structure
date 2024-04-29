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
    System.out.print("Enter an option: ");
  }

  public void showMenuUpdate() {
    System.out.println("What informations do you want to update?");
    System.out.println("------------------------");
    System.out.println("1 - Product");
    System.out.println("2 - Quantity");
    System.out.println("0 - Update Order Item");
    System.out.println("------------------------");
    System.out.print("Choose the information: ");
  }

  public Integer readQuantity() {
    System.out.print("Quantity: ");
    return Integer.parseInt(System.console().readLine());
  }

  public String readProductName() {
    System.out.print("Product name: ");
    return System.console().readLine();
  }

  public void showMessage(String message) {
    System.out.println(message);
  }
}
