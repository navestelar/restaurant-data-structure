package model;

import data_structure.HashMapLinked;

public class Menu {
  private HashMapLinked<String, Product> products = new HashMapLinked<String, Product>();
  
  public Menu() {
    products.put("Pizza", new Product("Pizza", 150.50f));
    products.put("Burger", new Product("Burger", 19.99f));
    products.put("Pastel", new Product("Pastel", 6f));
    products.put("Lasagna", new Product("Lasagna", 59.99f));
    products.put("Soup", new Product("Soup", 11.9f));
    products.put("Cake", new Product("Cake", 30f));
    products.put("Coffee", new Product("Coffee", 5.9f));
    products.put("Water", new Product("Water", 2.5f));
    products.put("Wine", new Product("Wine", 199.99f));
  }

  public Product getProduct(String name) {
    return products.get(name);
  }
  
  public HashMapLinked<String, Product> getProducts() {
    return products;
  }

  @Override
  public String toString() {
    return "Menu [products=" + products.toString() + "]";
  }
}
