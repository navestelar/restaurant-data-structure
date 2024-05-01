package com.restaurant.model;

public class Payment {
  private Table table;
  private Client client;
  private Employee employee;
  private Order order;
  private Float change = null;

  public Payment(Table table, Client client, Employee employee, Order order, Float change) {
    this.table = table;
    this.client = client;
    this.employee = employee;
    this.order = order;
    this.change = change;
  }

  public Float getChange() {
    return change;
  }

  public void setChange(Float change) {
    this.change = change;
  }
  public Table getTable() {
    return table;
  }
  public void setTable(Table table) {
    this.table = table;
  }
  public Client getClient() {
    return client;
  }
  public void setClient(Client client) {
    this.client = client;
  }
  public Employee getEmployee() {
    return employee;
  }
  public void setEmployee(Employee employee) {
    this.employee = employee;
  }
  public Order getOrder() {
    return order;
  }
  public void setOrder(Order order) {
    this.order = order;
  }

  public String getInvoice() {
    String result = "---------------------------------------------------------------------------------------------------------------\n";
    result += "Order: "+ order.getId() + "\n Client: " + client.getName() + "\n People quantity: " + order.getTable().getClient().getPeopleQuantity() + "\n Order: ";

    for (int i = 0; i < order.getOrderItem().size(); i++) {
      OrderItem orderItem = order.getOrderItem().getByIndex(i);
      result += "\n Product: " + orderItem.getProduct().getName() + ", quantity: " + orderItem.getQuantity() + "\n";
    }

    result += "\nTotal price= " + order.getTotalPrice();
  
    if (this.change != null) {
      result += "\n Change: " + this.change;
    }

    result += "\n---------------------------------------------------------------------------------------------------------------";
    return result;
  }

  @Override
  public String toString() {
    return "Payment [table=" + table + ", client=" + client + ", employee=" + employee + ", order=" + order + "]";
  }
  
}
