package com.restaurant.model;

public class OrderItem {
  private Product product;
  private Integer quantity;

  public OrderItem() {
  }

  public Float calculatePrice() {
    return product.getPrice() * quantity;
  }

  public Product getProduct() {
    return product;
  }
  public void setProduct(Product product) {
    this.product = product;
  }
  public Integer getQuantity() {
    return quantity;
  }
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
  @Override
  public String toString() {
    return "OrderItem [product=" + product.toString() + ", quantity=" + quantity + "]";
  }

}