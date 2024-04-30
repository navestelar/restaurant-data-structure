package view;

public class DefaultView {
  public void showMenu() {
    System.out.println("** Main Menu **");
    System.out.println("------------------------");
    System.out.println("1 - Client");
    System.out.println("2 - Order");
    System.out.println("3 - Table");
    System.out.println("0 - Exit");
    System.out.println("------------------------");
    System.out.print("Enter an option: ");
  }

  public void showMessage(String message) {
    System.out.println(message);
  }
}
