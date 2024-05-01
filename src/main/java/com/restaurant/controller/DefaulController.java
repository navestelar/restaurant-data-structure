package com.restaurant.controller;

import com.restaurant.view.DefaultView;
import com.restaurant.view.InputView;

public class DefaulController {
  private DefaultView view;
  private ClientController clientController;
  private TableController tableController;
  private OrderController orderController;
  private EmployeeController employeeController;
  private PaymentController paymentController;
  private ServiceFlowController serviceFlowController;
  private StatisticsController statisticsController;

  public DefaulController() {
    this.view = new DefaultView();
    this.clientController = new ClientController();
    this.tableController = new TableController(clientController);
    this.employeeController = new EmployeeController();
    this.paymentController = new PaymentController();
    this.orderController = new OrderController(tableController, employeeController);
    this.serviceFlowController = new ServiceFlowController(tableController, orderController, paymentController);
    this.statisticsController = new StatisticsController(serviceFlowController, tableController);
  }

  public void start() {
    Integer option = null;

    do {
      view.showMenu();
      option = InputView.readInteger("Option: ");

      switch (option) {
        case 1:
          clientController.start();
          break;
        case 2:
          orderController.start();
          break;
        case 3:
          tableController.start();
          break;
        case 4:
          employeeController.start();
          break;
        case 5:
          serviceFlowController.start();
          break;
        case 6:
          paymentController.listPayments();
          break;
        case 7:
          statisticsController.start();
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
