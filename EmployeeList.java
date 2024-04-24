import data_structure.DoublyLinkedList;
import data_structure.HashMapLinked;

public class EmployeeList {
  private HashMapLinked<Integer, Employee> employeeList = new HashMapLinked<Integer, Employee>();
  private Integer currentId = 0;

  public boolean create(Employee employee) {
    if (!employeeList.contains(employee)) {
      employee.setId(currentId);
      employeeList.put(currentId, employee);
      currentId++;
      System.out.println("Employee successfully registered!");
      return true;
    }

    System.out.println("Employee already exists!");
    return false;
  }

  public Employee read(Integer id) {
    Employee employee = employeeList.get(id);

    if (employee == null) {
      System.out.println("Employee not found!");
    }

    return employee;
  }

  public Employee update(Integer id, Employee employee) {
    Employee oldEmployee = employeeList.get(id);

    if (oldEmployee != null) {
      oldEmployee.setData(employee);
      System.out.println("Employee updated!");
      return oldEmployee;
    }

    System.out.println("Employee not found!");
    return null;
  }

  public Employee delete(Integer id) {
    Employee employee = employeeList.remove(id);

    if (employee == null) {
      System.out.println("Employee not found!");
      return null;
    }
  
    System.out.println("Employee deleted!");
    return employee;
  }

  public DoublyLinkedList<Employee> readAll() {
    return employeeList.values();
  }

  public void showList() {
    employeeList.showList();
    System.out.println("----------------------------------------------------");
  }
}
