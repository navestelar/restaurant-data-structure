package com.restaurant.controller;

import com.restaurant.data_structure.HashMapLinked;
import com.restaurant.model.EmployeeRoles;
import com.restaurant.model.Order;
import com.restaurant.model.OrderItem;
import com.restaurant.model.OrderStatus;
import com.restaurant.model.Table;
import com.restaurant.view.InputView;
import com.restaurant.view.OrderView;

public class OrderController {
  private OrderView view = new OrderView();
  private HashMapLinked<Integer, Order> orderList = new HashMapLinked<Integer, Order>();
  private OrderItemController orderItemController = new OrderItemController();
  private TableController tableController;
  private EmployeeController employeeController;
  private Integer currentId = 1;

  public OrderController(TableController tableController, EmployeeController employeeController) {
    this.tableController = tableController;
    this.employeeController = employeeController;
  }

  public void start() {
    Integer option = null;

    do {
      view.showMenu();
      Boolean isOptionInvalid = false;

      do {
        try {
          System.out.print("Enter an option: ");
          option = Integer.parseInt(System.console().readLine());
          isOptionInvalid = false;
        } catch (NumberFormatException ex) {
          System.out.println("Not a number, try again");
          isOptionInvalid = true;
        }
      } while (isOptionInvalid);

      switch (option) {
        case 1:
          registerOrder();
          break;
        case 2:
          updateOrder();
          break;
        case 3:
          cancelOrder();
          break;
        case 4:
          searchOrder();
          break;
        case 5:
          listOrders();
          break;
        case 0:
          view.showMessage("Exiting...");
          break;
        default:
          view.showMessage("Invalid option!");
          break;
      }
    } while (option != 0);
  }

  public Order registerOrder() {
    view.showMessage("Register Order: ");

    Order order = new Order();
    order.setId(currentId);
    employeeController.listEmployees(EmployeeRoles.WAITER);
    order.setEmployee(employeeController.getEmployeeById(view.readEmployeeId()));
    order.setOrderStatus(OrderStatus.PENDING);
    order.setOrderItem(orderItemController.registerOrderItem(new HashMapLinked<String, OrderItem>()));

    Table table = tableController.getTableByNumber(view.readTableNumber());

    if (table.getClient() != null) {
      order.setTable(table);
      table.setOrder(order);
  
      orderList.put(currentId, order);
      view.showMessage("Order registered successfully! ");
      currentId++;
      
      showOrder(order.getId());
      return order;
    }

    view.showMessage("Table has no client");
    return null;
  }

  private void updateOrder() {
    view.showMessage("Update Order: ");

    listOrders();
    Integer id = view.readId();
    Order order = showOrder(id);

    if (order == null) {
      view.showMessage("Order not found");
      return;
    }

    Integer option = null;
    do {
      view.showMenuUpdate();
      option = InputView.readInteger("Option: ");

      switch (option) {
        case 1:
          order.setTable(tableController.getTableByNumber(view.readTableNumber()));
          break;
        case 2:
          order.setEmployee(employeeController.getEmployeeById(view.readEmployeeId()));
          break;
        case 3:
          order.setOrderItem(orderItemController.updateOrderItem(order.getOrderItem()));
          break;
        case 0:
          view.showMessage("Exiting...");
          break;
        default:
          view.showMessage("Invalid option!");
          break;
      }
    } while (option != 0);
  }

  private void cancelOrder() {
    listOrders();
    Integer id = view.readId();
    Order order = showOrder(id);

    if (order == null) {
      view.showMessage("Order not found");
      return;
    }

    boolean canCancel = view.readConfirmation();
    if (canCancel) {
      order.setOrderStatus(OrderStatus.CANCELED);
      view.showMessage("Order canceled successfully!");
    }
  }

  private void searchOrder() {
    String value = view.readSearchString();

    HashMapLinked<Integer, Order> searchOrders = orderList.searchString(value);

    if (searchOrders.size() > 0) {
      System.out.println(searchOrders.toStringWithKey());
    } else {
      view.showMessage("Client not found!");
    }
  }

  private void listOrders() {
    view.showMessage(orderList.toString());
  }

  private Order showOrder(Integer id) {
    Order order = orderList.get(id);

    if (order != null) {
      view.showMessage(order.toString());
    } else {
      view.showMessage("Order not found");
    }

    return order;
  }
}
