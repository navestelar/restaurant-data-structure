package model.DTO;

public class Client {
  private Integer id;
  private String name;
  private Integer age;
  private String phone;
  private String email;

  public Client() {
  }

  public Client(Integer id, String name, Integer age, String phone, String email) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.phone = phone;
    this.email = email;
  }

  public Client(String name) {
    this.name = name;
  }

  public Client(String name, Integer age, String phone, String email) {
    this.name = name;
    this.age = age;
    this.phone = phone;
    this.email = email;
  }

  public void setData(Client client) {
    this.setName(client.getName());
    this.setAge(client.getAge());
    this.setPhone(client.getPhone());
    this.setEmail(client.getEmail());
  }

  public boolean equals(Client client) {
    if (this.getName().equals(client.getName()) && this.getAge().equals(client.getAge())
        && this.getPhone().equals(client.getPhone()) && this.getEmail().equals(client.getEmail())) {
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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
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

  @Override
  public String toString() {
    return "Client [name=" + name + ", age=" + age + ", phone=" + phone + ", email=" + email + "]";
  }
}
