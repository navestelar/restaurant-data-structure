package com.restaurant.view;

public abstract class InputView {
  public static String readString(String message) {
    System.out.print(message);
    return System.console().readLine();
  }

  public static Integer readInteger(String message) {
    Integer input = null;
    Boolean isInputInvalid = false;

    do {
      try {
        System.out.print(message);
        input = Integer.parseInt(System.console().readLine());
        isInputInvalid = false;
      } catch (NumberFormatException ex) {
        System.out.println("Not a number, try again");
        isInputInvalid = true;
      }
    } while (isInputInvalid);

    return input;
  }

  public static Float readFloat(String message) {
    Float input = null;
    Boolean isInputInvalid = false;

    do {
      try {
        System.out.print(message);
        input = Float.parseFloat(System.console().readLine());
        isInputInvalid = false;
      } catch (NumberFormatException ex) {
        System.out.println("Not a number, try again");
        isInputInvalid = true;
      }
    } while (isInputInvalid);

    return input;
  }
}
