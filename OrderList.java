import data_structure.DoublyLinkedList;
import data_structure.HashMapLinked;

public class OrderList {
  private HashMapLinked<Integer, Order> orderList;
  private Integer currentId = 0;

  public OrderList() {
    orderList = new HashMapLinked<Integer, Order>();
  }

  public boolean create(Order order) {
    order.setId(currentId);
    orderList.put(currentId, order);
    currentId++;
    
    System.out.println("Order successfully registered!");
    return true;
  }

  public boolean cancel(Integer id) {
    Order order = orderList.get(id);

    if (order == null) {
      System.out.println("Order not found!");
      return false;
    }

    order.setStatus(OrderStatus.CANCELLED);
    System.out.println("Order cancelled!");
    return true;
  }

  public Order read(Integer id) {
    Order order = orderList.get(id);

    if (order == null) {
      System.out.println("Order not found!");
    }

    return order;
  }

  public Order update(Integer id, Order order) {
    Order oldOrder = orderList.get(id);

    if (oldOrder != null) {
      oldOrder.setData(order);
      System.out.println("Order updated!");
      return oldOrder;
    }

    System.out.println("Order not found!");
    return null;
  }

  public DoublyLinkedList<Order> readAll() {
    return orderList.values();
  }

  public void showList() {
    orderList.showList();
    System.out.println("----------------------------------------------------");
  }
}
