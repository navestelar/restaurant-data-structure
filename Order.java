import data_structure.DoublyLinkedList;

public class Order {
  private Integer id;
  private Integer table;
  private Employee employee;
  private OrderStatus status;
  private DoublyLinkedList<OrderItem> items;
  private Float totalPrice;

  public Order(Integer table, DoublyLinkedList<OrderItem> items) {
    this.table = table;
    this.status = OrderStatus.PENDING;
    this.items = items;
  }

  public Float calculateTotalPrice() {
    Float total = 0.0f;

    for (int i = 0; i < items.size(); i++) {
      total += items.get(i).getPrice() * items.get(i).getQuantity();
    }

    this.totalPrice = total;
    return total;
  }

  public void setData(Order order) {
    this.table = order.getTable();
    this.items = order.getItems();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getTable() {
    return table;
  }

  public void setTable(Integer table) {
    this.table = table;
  }

  public DoublyLinkedList<OrderItem> getItems() {
    return items;
  }

  public void setItems(DoublyLinkedList<OrderItem> items) {
    this.items = items;
  }

  public Float getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Float totalPrice) {
    this.totalPrice = totalPrice;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Order [id=" + id + ", table=" + table + ", status=" + status + ", items=\n" + items.toString() + ", totalPrice="
        + totalPrice + "]";
  }
}
