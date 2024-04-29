package controller;

import data_structure.HashMapLinked;
import model.Order;
import model.OrderStatus;
import model.Table;
import view.OrderView;

public class OrderController {
  private OrderView view = new OrderView();
  private HashMapLinked<Integer, Order> orderList = new HashMapLinked<Integer, Order>();
  private TableController tableController;
  private EmployeeController employeeController;
  private Integer currentId = 0;

  public OrderController(TableController tableController, EmployeeController employeeController) {
    this.tableController = tableController;
    this.employeeController = employeeController;
  }

  public void start() {
    Integer option;

    do {
      view.showMenu();
      option = Integer.parseInt(System.console().readLine());

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

  private void registerOrder() {
    view.showMessage("Register Order: ");

    Order order = new Order();
    order.setId(currentId++);
    order.setTable(tableController.getTableByNumber(view.readTableNumber()));
    order.setEmployee(employeeController.getEmployeeById(view.readEmployeeId()));
    order.setOrderStatus(OrderStatus.PENDING);

    OrderItemController orderItemController = new OrderItemController();
    order.setOrderItem(orderItemController.registerOrderItem());

    orderList.put(currentId, order);
    view.showMessage("Order registered successfully! ");
    currentId++;

    showOrder(order.getId());
  }

  private void updateOrder() {

  }

  private void cancelOrder() {

  }

  private void searchOrder() {

  }

  private void listOrders() {
    view.showMessage(orderList.toString());
  }

  private void showOrder(Integer id) {
    Order order = orderList.get(id);

    if (order != null) {
      view.showMessage(order.toString());
    } else {
      view.showMessage("Order not found");
    }
  }
}
