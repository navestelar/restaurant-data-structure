package com.restaurant.controller;

import com.restaurant.data_structure.HashMapLinked;
import com.restaurant.model.Employee;
import com.restaurant.model.EmployeeRoles;
import com.restaurant.model.ScaleOfWork;
import com.restaurant.view.EmployeeView;
import com.restaurant.view.InputView;
import com.restaurant.view.View;

public class EmployeeController {
  private HashMapLinked<String, Employee> employeeList;
  private EmployeeView view;
  private Integer currentId = 1;

  public EmployeeController() {
    employeeList = new HashMapLinked<String, Employee>();
    employeeList.put("12345678901", new Employee(0, "12345678901", "Joan", "63995678901", "joan@restaurant.com",
        EmployeeRoles.WAITER, "07:30", "12:40-13:20", "17:00"));
    employeeList.put("12345678902", new Employee(1, "12345678902", "Maria", "63995678902", "maria@restaurant.com",
        EmployeeRoles.WAITER, "07:30", "12:40-13:20", "17:00"));
    employeeList.put("12345678903", new Employee(2, "12345678903", "Pedro", "63995678903", "pedro@restaurant.com",
        EmployeeRoles.WAITER, "17:00", "19:00-19:30", "23:00"));
    employeeList.put("12345678904", new Employee(3, "12345678904", "Ana", "63995678904", "ana@restaurant.com",
        EmployeeRoles.WAITER, "17:00", "19:00-19:30", "23:00"));
    employeeList.put("12345678905", new Employee(4, "12345678905", "Jose", "63995678905", "jose@restaurant.com",
        EmployeeRoles.COOK, "07:30", "12:40-13:20", "17:00"));
    employeeList.put("12345678906", new Employee(5, "12345678906", "Joao", "63995678906", "joao@restaurant.com",
        EmployeeRoles.COOK, "07:30", "12:40-13:20", "17:00"));
    employeeList.put("12345678907", new Employee(6, "12345678907", "Maria", "63995678907", "maria@restaurant.com",
        EmployeeRoles.COOK, "17:00", "19:00-19:30", "23:00"));
    employeeList.put("12345678908", new Employee(7, "12345678908", "Joana", "63995678908", "joana@restaurant.com",
        EmployeeRoles.COOK, "17:00", "19:00-19:30", "23:00"));
    employeeList.put("12345678909", new Employee(8, "12345678909", "Josep", "63995678909", "josep@restaurant.com",
        EmployeeRoles.CASHIER, "07:30", "12:40-13:20", "17:00"));
    employeeList.put("12345678910", new Employee(9, "12345678910", "Renata", "63995678910", "renata@restaurant.com",
        EmployeeRoles.CASHIER, "17:00", "19:00-19:30", "23:00"));
    employeeList.put("12345678911", new Employee(10, "12345678911", "Juliel", "63995678911", "juliel@restaurant.com",
        EmployeeRoles.MANAGER, "14:00", "16:00-16:30", "20:00"));
    view = new EmployeeView();
    currentId = 11;
  }

  public void start() {
    Integer option = null;

    do {
      view.showMenu();
      option = InputView.readInteger("Option: ");

      switch (option) {
        case 1:
          registerEmployee();
          break;
        case 2:
          removeEmployee();
          break;
        case 3:
          showScaleOfWork();
          break;
        case 4:
          searchEmployee();
          break;
        case 5:
          listEmployees();
          break;
        case 0:
          View.showMessage("Exiting...");
          break;
        default:
          View.showMessage("Invalid option!");
          break;
      }
    } while (option != 0);
  }

  private void registerEmployee() {
    Employee employee = new Employee();
    employee.setId(currentId);
    employee.setCpf(InputView.readString("Cpf: "));
    employee.setName(InputView.readString("Name: "));
    employee.setPhone(InputView.readString("Phone: "));
    employee.setEmail(InputView.readString("Email: "));
    employee.setRole(view.readEmployeeRoles());
    employee.setScaleOfWork(new ScaleOfWork(InputView.readString("Arrival time: "),
        InputView.readString("Break time: "), InputView.readString("Departure time: ")));

    if (employeeList.put(employee.getCpf(), employee)) {
      View.showMessage("Employee registered!");
      currentId++;
    } else {
      View.showMessage("Employee with this cpf already registered!");
    }
  }

  private void removeEmployee() {
    View.showMessage("Remove Employee: ");
    listEmployees();
    Integer id = InputView.readInteger("Id: ");

    View.showMessage("Employee to remove: ");
    Employee employee = showEmployee(id);
    if (employee != null) {
      boolean canExclude = View.readConfirmation();

      if (canExclude) {
        employeeList.remove(employee.getCpf());
      }
    }
  }

  private void showScaleOfWork() {
    for (int i = 0; i < employeeList.size(); i++) {
      System.out.println("Employee: "+employeeList.getByIndex(i).getName()+", "+employeeList.getByIndex(i).getScaleOfWork());
    }
  }

  private Employee showEmployee(Integer id) {
    HashMapLinked<String, Employee> employees = employeeList.searchString("Employee [id=" + id);
    Employee employee = employees.getByIndex(0);

    if (employee != null) {
      View.showMessage(employee.toString());
      return employee;
    }

    View.showMessage("Employee not found!");
    return null;
  }

  private void searchEmployee() {
    String input = InputView.readString("Search employee: ");
    HashMapLinked<String, Employee> searchEmployees = employeeList.searchString(input);
    if (searchEmployees.size() > 0) {
      View.showMessage("Employees found: ");
      searchEmployees.showList();
    } else {
      View.showMessage("Employee not found!");
    }
  }

  public void listEmployees() {
    employeeList.showList();
  }

  public void listEmployees(EmployeeRoles employeeRole) {
    for (int i = 0; i < employeeList.size(); i++) {
      Employee employee = employeeList.getByIndex(i);
      if (employee.getRole() == employeeRole) {
        System.out.println(employee.toString());
      }
    }
  }

  public Employee getEmployeeById(Integer id) {
    HashMapLinked<String, Employee> employees = employeeList.searchString("Employee [id=" + id);
    Employee employee = employees.getByIndex(0);

    if (employee == null) {
      System.out.println("Employee not founded!");
    }

    return employee;
  }

  public boolean create(Employee employee) {
    return employeeList.put(employee.getCpf(), employee);
  }

  public boolean update(Employee employee) {
    return employeeList.update(employee.getCpf(), employee.getCpf(), employee);
  }
}
