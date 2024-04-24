public class OrderItem {
  private String name;
  private Float price;
  private Integer quantity;

  public OrderItem(String name, Float price, Integer quantity) {
    this.name = name;
    this.price = price;
    this.quantity = quantity;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Float getPrice() {
    return price;
  }
  public void setPrice(Float price) {
    this.price = price;
  }
  public Integer getQuantity() {
    return quantity;
  }
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
  @Override
  public String toString() {
    return "OrderItem [name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
  }
}
