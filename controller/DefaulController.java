package controller;

import view.DefaultView;

public class DefaulController {
  private DefaultView view;
  private ClientController clientController;
  private TableController tableController;
  private OrderController orderController;
  private EmployeeController employeeController;

  public DefaulController() {
    this.view = new DefaultView();
    this.clientController = new ClientController();
    this.tableController = new TableController();
    this.employeeController = new EmployeeController();
    this.orderController = new OrderController(tableController, employeeController);
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
        case 2:
          orderController.start();
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
