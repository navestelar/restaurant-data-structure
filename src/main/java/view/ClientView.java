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
  }

  public void showMenuUpdate() {
    System.out.println("What informations do you want to update?");
    System.out.println("------------------------");
    System.out.println("1 - Name");
    System.out.println("2 - Phone");
    System.out.println("3 - Email");
    System.out.println("0 - Update Client");
    System.out.println("------------------------");
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
    Integer input = null;
    Boolean isInputInvalid = false;
    
    do {
      try {
        System.out.print("Id: ");
        input = Integer.parseInt(System.console().readLine());
        isInputInvalid = false;
      } catch(NumberFormatException ex) {
        System.out.println("Not a number, try again");
        isInputInvalid = true; 
      }
    } while(isInputInvalid);

    return input;
  }

  public Integer readPeopleQuantity() {
    Integer input = null;
    Boolean isInputInvalid = false;

    do {
      try {
        System.out.print("People quantity: ");
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

  public void showMessage(String message) {
    System.out.println(message);
  }
}
