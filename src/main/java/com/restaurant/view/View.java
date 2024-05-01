package com.restaurant.view;

public abstract class View {
  public static void showMessage(String message) {
    System.out.println(message);
  }

  public static boolean readConfirmation() {
    System.out.print("Are you sure?(Y/N): ");
    String resposta = System.console().readLine().toUpperCase();
    return resposta.equals("Y");
  }
}
