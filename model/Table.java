package model;

public class Table {
  private Integer number;
  private Integer capacity;
  private Client client;
  public Table(Integer number, Integer capacity) {
    this.number = number;
    this.capacity = capacity;
  }
  public Table() {
  }

  public boolean canOccupate(Integer peopleQuantity) {
    return client == null && peopleQuantity <= capacity;
  }

  public boolean isOccupied() {
    return client != null;
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
    String result = "Table [number=" + number + ", capacity=" + capacity;
    
    if (client != null) {
      result += ", client= " + client.getName() + "]";
    } else {
      result += ", client= " + client + "]";
    }

    return result;
  }

}
