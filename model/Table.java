package model;

public class Table {
  private Integer number;
  private Integer capacity;
  private Client client;
  public Table() {
  }
  public Integer getNumber() {
    return number;
  }
  public void setNumber(Integer number) {
    this.number = number;
  }
  public Integer getCapacity() {
    return capacity;
  }
  public void setCapacity(Integer capacity) {
    this.capacity = capacity;
  }
  public Client getClient() {
    return client;
  }
  public void setClient(Client client) {
    this.client = client;
  }
  @Override
  public String toString() {
    return "Table [number=" + number + ", capacity=" + capacity + ", client=" + client.toString() + "]";
  }
}
