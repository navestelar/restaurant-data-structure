package controller;

import data_structure.HashMapLinked;
import model.Employee;
import model.EmployeeRoles;

public class EmployeeController {
  private HashMapLinked<String, Employee> employeeList = new HashMapLinked<String, Employee>();
  private Integer currentId = 0;

  public EmployeeController() {
    employeeList.put("12345678901", new Employee(0, "12345678901", "Joan", "63995678901", "joan@restaurant.com", EmployeeRoles.WAITER, "07:30", "12:40-13:20", "17:00"));
    employeeList.put("12345678902", new Employee(1, "12345678902", "Maria", "63995678902", "maria@restaurant.com", EmployeeRoles.WAITER, "07:30", "12:40-13:20", "17:00"));
    employeeList.put("12345678903", new Employee(2, "12345678903", "Pedro", "63995678903", "pedro@restaurant.com", EmployeeRoles.WAITER, "17:00", "19:00-19:30", "23:00"));
    employeeList.put("12345678904", new Employee(3, "12345678904", "Ana", "63995678904", "ana@restaurant.com", EmployeeRoles.WAITER, "17:00", "19:00-19:30", "23:00"));
    employeeList.put("12345678905", new Employee(4, "12345678905", "Jose", "63995678905", "jose@restaurant.com", EmployeeRoles.COOK, "07:30", "12:40-13:20", "17:00"));
    employeeList.put("12345678906", new Employee(5, "12345678906", "Joao", "63995678906", "joao@restaurant.com", EmployeeRoles.COOK, "07:30", "12:40-13:20", "17:00"));
    employeeList.put("12345678907", new Employee(6, "12345678907", "Maria", "63995678907", "maria@restaurant.com", EmployeeRoles.COOK, "17:00", "19:00-19:30", "23:00"));
    employeeList.put("12345678908", new Employee(7, "12345678908", "Joana", "63995678908", "joana@restaurant.com", EmployeeRoles.COOK, "17:00", "19:00-19:30", "23:00"));
    employeeList.put("12345678909", new Employee(8, "12345678909", "Josep", "63995678909", "josep@restaurant.com", EmployeeRoles.CASHIER, "07:30", "12:40-13:20", "17:00"));
    employeeList.put("12345678910", new Employee(9, "12345678910", "Renata", "63995678910", "renata@restaurant.com", EmployeeRoles.CASHIER, "17:00", "19:00-19:30", "23:00"));
    employeeList.put("12345678911", new Employee(10, "12345678911", "Juliel", "63995678911", "juliel@restaurant.com", EmployeeRoles.MANAGER, "14:00", "16:00-16:30", "20:00"));
    currentId = 11;
  }

  

  public Employee getEmployeeById(Integer id) {
    HashMapLinked<String, Employee> employees = employeeList.searchString("Employee [id=" + id);
    Employee employee = employees.getByIndex(0);

    if (employee == null) {
      System.out.println("Employee not founded!");
    }

    return employee;
  }
}
