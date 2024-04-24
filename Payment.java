public class Payment {
  private Order order;
  private Float totalValue;
  private PaymentMethod paymentMethod;
  private Float changeValue;

  public Payment(Order order, Float totalValue, PaymentMethod paymentMethod, Float changeValue) {
    this.order = order;
    this.totalValue = totalValue;
    this.paymentMethod = paymentMethod;
    this.changeValue = changeValue;
  }

  

  public Order getOrder() {
    return order;
  }
  public void setOrder(Order order) {
    this.order = order;
  }
  public Float getTotalValue() {
    return totalValue;
  }
  public void setTotalValue(Float totalValue) {
    this.totalValue = totalValue;
  }
  public PaymentMethod getPaymentMethod() {
    return paymentMethod;
  }
  public void setPaymentMethod(PaymentMethod paymentMethod) {
    this.paymentMethod = paymentMethod;
  }
  public Float getChangeValue() {
    return changeValue;
  }
  public void setChangeValue(Float changeValue) {
    this.changeValue = changeValue;
  }
}
