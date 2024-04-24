public class Employee {
  private Integer id;
  private String name;
  private String phone;
  private String email;
  private String role;
  private String scaleOfWork;

  public Employee(String name, String phone, String email, String role) {
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.role = role;
  }

  public void setData(Employee employee) {
    this.setName(employee.getName());
    this.setPhone(employee.getPhone());
    this.setEmail(employee.getEmail());
    this.setRole(employee.getRole());
    this.setScaleOfWork(employee.getScaleOfWork());
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
  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }
  public String getScaleOfWork() {
    return scaleOfWork;
  }
  public void setScaleOfWork(String scaleOfWork) {
    this.scaleOfWork = scaleOfWork;
  }

  @Override
  public String toString() {
    return "Employee [name=" + name + ", phone=" + phone + ", email=" + email + ", role=" + role + ", scaleOfWork="
        + scaleOfWork + "]";
  }
}
