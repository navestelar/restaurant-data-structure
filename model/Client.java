package model;

public class Client {
  private String cpf;
  private String name;
  private String phone;
  private String email;
  private Table table;
  private Integer peopleQuantity;

  public Client() {
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
  public String getCpf() {
    return cpf;
  }
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  @Override
  public String toString() {
    return "Client [cpf=" + cpf + ", name=" + name + ", phone=" + phone + ", email=" + email + ", table=" + table
        + ", peopleQuantity=" + peopleQuantity + "]";
  }
}
