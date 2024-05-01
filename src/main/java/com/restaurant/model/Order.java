package com.restaurant.model;

import com.restaurant.data_structure.HashMapLinked;

public class Order {
  private Integer id;
  private Table table;
  private Employee employee;
  private OrderStatus OrderStatus;
  private HashMapLinked<String, OrderItem> orderItem;
  private Float totalPrice;
  private PaymentMethod paymentMethod;
  
  public Order() {
  }
  public Float calculateTotalPrice() {
    Float totalPrice = 0f;
    for (int i = 0; i < orderItem.size(); i++) {
      totalPrice += orderItem.getByIndex(i).calculatePrice();
    }
    return totalPrice;
  }
  
  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  public Table getTable() {
    return table;
  }
  public void setTable(Table table) {
    this.table = table;
  }
  public Employee getEmployee() {
    return employee;
  }
  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
  public OrderStatus getOrderStatus() {
    return OrderStatus;
  }
  public void setOrderStatus(OrderStatus orderStatus) {
    OrderStatus = orderStatus;
  }
  public HashMapLinked<String, OrderItem> getOrderItem() {
    return orderItem;
  }
  public void setOrderItem(HashMapLinked<String, OrderItem> orderItem) {
    this.orderItem = orderItem;
  }
  public Float getTotalPrice() {
    return totalPrice;
  }
  public void setTotalPrice(Float totalPrice) {
    this.totalPrice = totalPrice;
  }
  @Override
  public String toString() {
    String result = "Order [id=" + id; 
    
    if (table != null) {
      result += ", table= " + table.getNumber();
    } else {
      result += ", table= " + table;
    }

    if (employee != null) {
      result += ", employee= " + employee.getName();      
    } else {
      result += ", employee= " + employee;
    }

    result += ", OrderStatus= " + OrderStatus;

    if (orderItem != null) {
      result += orderItem.toString();
    } else {
      result += ", orderItem= " + orderItem;
    }

    result += ", totalPrice= " + totalPrice + ", Payment method= " + paymentMethod + "]";

    return result;
  } 
}
