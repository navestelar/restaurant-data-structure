package com.restaurant.controller;

import com.restaurant.data_structure.HashMapLinked;
import com.restaurant.model.Payment;

public class PaymentController {
  private HashMapLinked<Integer, Payment> paymentList = new HashMapLinked<Integer, Payment>();
  private Integer currentId = 1;

  public void addPayment(Payment payment) {
    paymentList.put(currentId, payment);
    currentId++;
  }

  public void listPayments() {
    paymentList.showList();
  }
}
