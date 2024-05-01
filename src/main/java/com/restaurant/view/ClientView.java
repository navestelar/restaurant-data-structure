package com.restaurant.view;

public class ClientView {
  public void showMenu() {
    System.out.println("** Client Menu **");
    System.out.println("------------------------");
    System.out.println("1 - Register Client");
    System.out.println("2 - Remove Client");
    System.out.println("3 - Update Client");
    System.out.println("4 - Search Client");
    System.out.println("5 - List Clients");
    System.out.println("0 - Exit");
    System.out.println("------------------------");
  }

  public void showMenuUpdate() {
    System.out.println("What informations do you want to update?");
    System.out.println("------------------------");
    System.out.println("1 - Name");
    System.out.println("2 - Phone");
    System.out.println("3 - Email");
    System.out.println("0 - Update Client");
    System.out.println("------------------------");
  }
}
