package com.restaurant.view;

import com.restaurant.model.EmployeeRoles;

public class EmployeeView {
  public void showMenu() {
    System.out.println("** Employee Menu **");
    System.out.println("------------------------");
    System.out.println("1 - Register Employee");
    System.out.println("2 - Remove Employee");
    System.out.println("3 - Scale of work");
    System.out.println("4 - Search Employee");
    System.out.println("5 - List Employees");
    System.out.println("0 - Exit");
    System.out.println("------------------------");
  }

  public EmployeeRoles readEmployeeRoles() {
    System.out.println("What is the employee's role?");
    System.out.println("------------------------");
    System.out.println("1 - Waiter");
    System.out.println("2 - Cook");
    System.out.println("3 - Cashier");
    System.out.println("4 - Manager");
    System.out.println("0 - Exit");
    System.out.println("------------------------");

    Integer inputRole = null;
    do {
      inputRole = InputView.readInteger("Role number: ");
    } while(inputRole != 1 && inputRole != 2 && inputRole != 3 && inputRole != 4 && inputRole != 0);

    if (inputRole != 0)
      return EmployeeRoles.values()[inputRole - 1];

    return null;
  }
}
