package com.restaurant.controller;

import com.restaurant.view.InputView;
import com.restaurant.view.StatisticsView;
import com.restaurant.view.View;

public class StatisticsController {
  private StatisticsView view;
  private ServiceFlowController serviceFlowController;
  private TableController tableController;

  public StatisticsController(ServiceFlowController serviceFlowController, TableController tableController) {
    this.view = new StatisticsView();
    this.serviceFlowController = serviceFlowController;
    this.tableController = tableController;
  }

  public void start() {
    Integer option = null;

    do {
      view.showMenu();

      option = InputView.readInteger("Option: ");

      switch (option) {
        case 1:
          View.showMessage("Queue size for lunch: " + serviceFlowController.getClientQueue().getSize());
          break;
        case 2:
          View.showMessage("Queue size for checkout: " + serviceFlowController.getClientQueueToCheckout().getSize());
          break;
        case 3:
          View.showMessage("Clients having lunch: " + serviceFlowController.getOrderQueueToDelivery().getSize());
          break;
        case 4:
          View.showMessage("Quantity of clients served: " + serviceFlowController.getQtdClientServed());
          break;
        case 5:
          View.showMessage("How many tables are free: "+tableController.getTablesStatus().getByIndex(0).size());
          break;
        case 0:
          View.showMessage("Exiting...");
          break;
        default:
          View.showMessage("Invalid option!");
          break;
      }
    } while (option != 0);
  }
}
