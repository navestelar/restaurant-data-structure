package model;

import data_structure.HashMapLinked;

public class Order {
  private Integer id;
  private Table table;
  private Employee employee;
  private OrderStatus OrderStatus;
  private HashMapLinked<String, OrderItem> orderItem;
  private Float totalPrice;
  public Order() {
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
    return "Order [id=" + id + ", table=" + table.toString() + ", employee=" + employee.getName() + ", OrderStatus=" + OrderStatus
        + ", orderItem=" + orderItem.toString() + ", totalPrice=" + totalPrice + "]";
  } 
}
