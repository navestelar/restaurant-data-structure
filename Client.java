public class Client {
  private Integer id;
  private String name;
  private String phone;
  private String email;
  private Table table;
  private Integer peopleQuantity;

  public Client() {
  }

  public Client(Integer id, String name, String phone, String email) {
    this.id = id;
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.table = null;
  }

  public Client(String name) {
    this.name = name;
  }

  public Client(String name, String phone, String email) {
    this.name = name;
    this.phone = phone;
    this.email = email;
  }

  public void setData(Client client) {
    this.setName(client.getName());
    this.setPhone(client.getPhone());
    this.setEmail(client.getEmail());
  }

  public boolean equals(Client client) {
    if (this.getName().equals(client.getName()) && this.getPhone().equals(client.getPhone())
        && this.getEmail().equals(client.getEmail())) {
      return true;
    }

    return false;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Table getTable() {
    return table;
  }

  public void setTable(Table table) {
    this.table = table;
  }

  public Integer getPeopleQuantity() {
    return peopleQuantity;
  }

  public void setPeopleQuantity(Integer peopleQuantity) {
    this.peopleQuantity = peopleQuantity;
  }

  @Override
  public String toString() {
    return "Client [name=" + name + ", phone=" + phone + ", email=" + email + "]";
  }
}
