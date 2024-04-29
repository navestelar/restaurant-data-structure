package controller;

import data_structure.HashMapLinked;
import model.Menu;
import model.OrderItem;
import model.Product;
import view.OrderItemView;

public class OrderItemController {
  OrderItemView view = new OrderItemView();
  Menu menu = new Menu();

  public OrderItemController() {
  }

  public HashMapLinked<String, OrderItem> registerOrderItem(HashMapLinked<String, OrderItem> orderItemList) {
    String input = "c";
    view.showMessage("Register Order Item: ");

    do {
      OrderItem newOrderItem = new OrderItem();
      menu.getProducts().showList();
      Product product = menu.getProduct(view.readProductName());

      if (product != null) {
        newOrderItem.setProduct(product);
        newOrderItem.setQuantity(view.readQuantity());

        if (orderItemList.put(newOrderItem.getProduct().getName(), newOrderItem)) {
          view.showMessage("Order Item registered successfully");
        } else {
          view.showMessage("Already exists an order item with this product!");
        }
      } else {
        view.showMessage("There is no product with this name registered, try again!");
      }

      view.showMessage("Press enter to stop or c to register a new order item...");
      input = System.console().readLine();
      System.out.println("input: " + input);
    } while (input.equals("c"));

    return orderItemList;
  }

  public HashMapLinked<String, OrderItem> updateOrderItem(HashMapLinked<String, OrderItem> orderItemList) {
    String input = "c";
    view.showMessage("Update order item: ");

    do {
      listOrderItems(orderItemList);
      OrderItem orderItem = showOrderItem(orderItemList, view.readProductName());

      if (orderItem != null) {
        orderItem.setQuantity(view.readQuantity());
      } else {
        view.showMessage("There is no order item with this name registered, try again!");
      }

      view.showMessage("Press enter to stop or c to update other order item...");
      input = System.console().readLine();
      System.out.println("input: " + input);
    } while (input.equals("c"));

    return orderItemList;
  }

  public OrderItem removeOrderItem(HashMapLinked<String, OrderItem> orderItemList) {
    view.showMessage("Remove order item: ");
    listOrderItems(orderItemList);
    OrderItem orderItem = showOrderItem(orderItemList, view.readProductName());

    if (orderItem != null) {
      boolean canRemove = view.readConfirmation();

      if (canRemove) {
        orderItemList.remove(orderItem.getProduct().getName());
        view.showMessage("Order item removed successfully!");
        return orderItem;
      }
      return null;
    }

    view.showMessage("There is no order item with this name registered, try again!");
    return null;
  }

  public void listOrderItems(HashMapLinked<String, OrderItem> orderItemList) {
    orderItemList.showList();
  }

  private OrderItem showOrderItem(HashMapLinked<String, OrderItem> orderItemList, String orderItemName) {
    OrderItem orderItem = orderItemList.get(orderItemName);

    if (orderItem != null) {
      view.showMessage(orderItem.toString());
      return orderItem;
    }

    view.showMessage("Order not found!");
    return null;
  }
}
