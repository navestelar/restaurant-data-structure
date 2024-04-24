import data_structure.Queue;

public class OrderQueue {
  private Queue<Integer> orders;

  public void addOrder(Integer orderId) {
    orders.push(orderId);
  }

  public Integer getOrderId() {
    return orders.pop();
  }

  public OrderQueue() {
    orders = new Queue<Integer>(50);
  }

  public Queue<Integer> getOrders() {
    return orders;
  }

  public void setOrders(Queue<Integer> orders) {
    this.orders = orders;
  }
}
