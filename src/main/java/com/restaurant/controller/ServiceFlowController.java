package com.restaurant.controller;

import com.restaurant.data_structure.Queue;
import com.restaurant.model.Client;
import com.restaurant.model.Order;
import com.restaurant.model.OrderStatus;
import com.restaurant.model.Payment;
import com.restaurant.model.PaymentMethod;
import com.restaurant.view.InputView;
import com.restaurant.view.ServiceFlowView;
import com.restaurant.view.View;

public class ServiceFlowController {
  private ServiceFlowView view;
  private TableController tableController;
  private OrderController orderController;
  private PaymentController paymentController;
  private Queue<Client> clientQueue;
  private Queue<Order> orderQueue;
  private Queue<Order> orderQueueToDelivery;
  private Queue<Client> clientQueueToCheckout;
  private Integer qtdClientServed = 0;

  public ServiceFlowController(TableController tableController, OrderController orderController, PaymentController paymentController) {
    view = new ServiceFlowView();
    this.tableController = tableController;
    this.orderController = orderController;
    this.paymentController = paymentController;

    orderQueue = new Queue<Order>(24);
    orderQueueToDelivery = new Queue<Order>(24);
    clientQueueToCheckout = new Queue<Client>(24);

    clientQueue = new Queue<Client>(12);
    clientQueue.push(new Client("Ana"));
    clientQueue.push(new Client("Julia"));
    clientQueue.push(new Client("Tulio"));
    clientQueue.push(new Client("Joaquim"));
    clientQueue.push(new Client("Renata"));
  }

  public void start() {
    Integer option = null;

    do {
      view.showMenu();
      option = InputView.readInteger("Option: ");

      switch (option) {
        case 1:
          directingClient();
          break;
        case 2:
          writeOrder();
          break;
        case 3:
          preparateOrder();
          break;
        case 4:
          deliveryOrder();
          break;
        case 5:
          checkoutOrder();
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

  private void directingClient() {
    Client client = clientQueue.pop();

    if (client != null) {
      client.setPeopleQuantity(InputView.readInteger("People quantity: "));
      tableController.allocateClientToTable(client);
    } else {
      View.showMessage("No client in queue");
    }
  }

  private void writeOrder() {
    Order order = orderController.registerOrder();

    if (order != null) {
      orderQueue.push(order);
    }
  }

  private void preparateOrder() {
    Order order = orderQueue.pop();

    if (order != null) {
      order.setOrderStatus(OrderStatus.IN_PROGRESS);
      orderQueueToDelivery.push(order);
      View.showMessage("Order prepared: " + order.toString());
    } else {
      View.showMessage("No order in prepare queue");
    }
  }

  private void deliveryOrder() {
    Order order = orderQueueToDelivery.pop();
    if (order != null) {
      order.setOrderStatus(OrderStatus.DELIVERED);
      clientQueueToCheckout.push(order.getTable().getClient());
      qtdClientServed++;
      View.showMessage("Order delivered: " + order.toString());
    } else {
      View.showMessage("No order in delivery queue");
    }
  }

  private void checkoutOrder() {
    Client client = clientQueueToCheckout.pop();

    if (client != null) {
      Order order = client.getTable().getOrder();
      
      order.setTotalPrice(order.calculateTotalPrice());
      View.showMessage("Total Price: " + order.getTotalPrice());
      order.setPaymentMethod(view.readPaymentMethod());
      Float change = null;
  
      if (order.getPaymentMethod() == PaymentMethod.CASH) {
        Float money;
        money = InputView.readFloat("Total money: ");
  
        while (money < order.getTotalPrice()) {
          View.showMessage("Not enough money!");
          money = InputView.readFloat("Total money: ");
        }
  
        change = money - order.getTotalPrice();
        View.showMessage("Change: " + change);
      }
  
      order.setOrderStatus(OrderStatus.PAID);
      Payment payment = new Payment(client.getTable(), client, order.getEmployee(), order, change);
      paymentController.addPayment(payment);
      View.showMessage(payment.getInvoice());
      client.getTable().setClient(null);
      client.setTable(null);
    } else {
      View.showMessage("No client in queue!");
    }
  }

  public Queue<Client> getClientQueue() {
    return clientQueue;
  }

  public Queue<Order> getOrderQueue() {
    return orderQueue;
  }

  public Queue<Order> getOrderQueueToDelivery() {
    return orderQueueToDelivery;
  }

  public Queue<Client> getClientQueueToCheckout() {
    return clientQueueToCheckout;
  }

  public Integer getQtdClientServed() {
    return qtdClientServed;
  }
}
