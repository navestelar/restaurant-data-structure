package controller;

import view.DefaultView;

public class DefaulController {
  private DefaultView view;
  private ClientController clientController;

  public DefaulController() {
    this.view = new DefaultView();
    this.clientController = new ClientController();
  }

  public void start() {
    Integer option;

    do {
      view.showMenu();
      option = Integer.parseInt(System.console().readLine());

      switch (option) {
        case 1:
          clientController.start();
          break;
        case 0:
          System.exit(0);
          break;
        default:
          System.out.println("Invalid option!");
      }
    } while (option != 0);
  }
}
