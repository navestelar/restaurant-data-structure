package com.restaurant.view;

import com.restaurant.model.PaymentMethod;

public class ServiceFlowView {
  public void showMenu() {
    System.out.println("** Service Flow Menu **");
    System.out.println("------------------------");
    System.out.println("1 - Directing clients to available tables");
    System.out.println("2 - Order fulfillment by waiters");
    System.out.println("3 - Preparation of orders by cooks");
    System.out.println("4 - Delivery of orders to customers");
    System.out.println("5 - Billing and closing accounts");
    System.out.println("0 - Exit");
    System.out.println("------------------------");
  }

    public PaymentMethod readPaymentMethod() {
    System.out.println("What is the payment method?");
    System.out.println("------------------------");
    System.out.println("1 - Credit");
    System.out.println("2 - Debit");
    System.out.println("3 - PIX");
    System.out.println("4 - Cash");
    System.out.println("0 - Exit");
    System.out.println("------------------------");

    Integer inputRole = null;
    do {
      inputRole = InputView.readInteger("Payment method number: ");
    } while(inputRole != 1 && inputRole != 2 && inputRole != 3 && inputRole != 4 && inputRole != 0);

    if (inputRole != 0)
      return PaymentMethod.values()[inputRole - 1];

    return null;
  }
}