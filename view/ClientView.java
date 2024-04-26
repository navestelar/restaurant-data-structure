package view;

public class ClientView {
  public void showMenu() {
    System.out.println("** Client Menu **");
    System.out.println("------------------------");
    System.out.println("1 - Register Client");
    System.out.println("2 - Remove Client");
    System.out.println("3 - Update Client");
    System.out.println("4 - Search Client");
    System.out.println("5 - List Clients");
    System.out.println("0 - Exit");
    System.out.println("------------------------");
    System.out.print("Enter an option: ");
  }

  public void showMenuUpdate() {
    System.out.println("What informations do you want to update?");
    System.out.println("------------------------");
    System.out.println("1 - Name");
    System.out.println("2 - Phone");
    System.out.println("3 - Email");
    System.out.println("0 - Update Client");
    System.out.println("------------------------");
    System.out.print("Choose the information: ");
  }

  public String readSearchString() {
    System.out.print("Search client: ");
    return System.console().readLine();
  }

  public String readCpf() {
    System.out.print("Cpf: ");
    return System.console().readLine();
  }

  public String readName() {
    System.out.print("Name: ");
    return System.console().readLine();
  }

  public String readPhone() {
    System.out.print("Phone: ");
    return System.console().readLine();
  }

  public String readEmail() {
    System.out.print("Email: ");
    return System.console().readLine();
  }

  public Integer readId() {
    System.out.print("Id: ");
    return Integer.parseInt(System.console().readLine());
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
