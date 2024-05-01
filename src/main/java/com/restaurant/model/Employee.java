package com.restaurant.model;

public class Employee {
  private Integer id;
  private String cpf;
  private String name;
  private String phone;
  private String email;
  private EmployeeRoles role;
  private ScaleOfWork scaleOfWork;

  public Employee(Integer id, String cpf, String name, String phone, String email, EmployeeRoles role,
      String arrivalTime, String breakTime, String departureTime) {
    this.id = id;
    this.cpf = cpf;
    this.name = name;
    this.phone = phone;
    this.email = email;
    this.role = role;
    this.scaleOfWork = new ScaleOfWork(arrivalTime, breakTime, departureTime);
  }
  public Employee() {
  }
  public String getCpf() {
    return cpf;
  }
  public void setCpf(String cpf) {
    this.cpf = cpf;
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
  public EmployeeRoles getRole() {
    return role;
  }
  public void setRole(EmployeeRoles role) {
    this.role = role;
  }
  public ScaleOfWork getScaleOfWork() {
    return scaleOfWork;
  }
  public void setScaleOfWork(ScaleOfWork scaleOfWork) {
    this.scaleOfWork = scaleOfWork;
  }
  public Integer getId() {
    return id;
  }
  public void setId(Integer id) {
    this.id = id;
  }
  @Override
  public String toString() {
    return "Employee [id=" + id + ", cpf=" + cpf + ", name=" + name + ", phone=" + phone + ", email=" + email
        + ", role=" + role + ", scaleOfWork=" + scaleOfWork.toString() + "]";
  }
}
