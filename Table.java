public class Table {
  private Integer number;
  private Integer capacity;
  private Client client;

  public Table(Integer number, Integer capacity) {
    this.number = number;
    this.capacity = capacity;
    this.client = null;
  }

  public boolean canOccupate(Integer peopleQunatity) {
    return client == null && peopleQunatity <= capacity;
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

  public void setData(Table table) {
    this.number = table.getNumber();
    this.capacity = table.getCapacity();
    this.client = table.getClient();
  }

  @Override
  public String toString() {
    return "Table [number=" + number + ", capacity=" + capacity + ", client=" + client + "]";
  }
}
