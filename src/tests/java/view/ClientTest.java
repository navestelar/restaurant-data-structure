package model;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import model.Client;

public class ClientTest {
  static Client aClient = new Client();

  @BeforeClass
  public static void setupClass() {
    aClient.setId(1);
    aClient.setCpf("123.456.789-10");
    aClient.setEmail("test@example.com");
    aClient.setName("Navestelar");
    aClient.setPeopleQuantity(5);
    aClient.setPhone("(47) 99999-9999");
  }

  @Test
  public void testGetId() {
    Integer expected = 1;
    Integer actual = aClient.getId();
    assertEquals("Testing getId", expected, actual);
  }

  public static void main(String[] args) {
    org.junit.runner.JUnitCore.main("ClientTest");
  }
}
