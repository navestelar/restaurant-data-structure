package controller;

import data_structure.HashMapLinked;
import model.Menu;
import model.OrderItem;
import model.Product;
import view.OrderItemView;

public class OrderItemController {
  HashMapLinked<String, OrderItem> orderItemList = new HashMapLinked<String, OrderItem>();
  OrderItemView view = new OrderItemView();
  Menu menu = new Menu();

  public OrderItemController() {
  }
  public HashMapLinked<String, OrderItem> registerOrderItem() {
    String input = "q";
    view.showMessage("Register Order Item: ");

    do {
      OrderItem newOrderItem = new OrderItem();
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

      view.showMessage("Press enter to continue or q to register a new order item...");
      input = System.console().readLine();
      System.out.println("input: "+input);
    } while (input.equals("q"));

    return orderItemList;
  }
}
