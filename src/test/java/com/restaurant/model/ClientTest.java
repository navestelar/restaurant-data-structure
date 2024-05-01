package com.restaurant.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class ClientTest {

  private Client client;

  @Before
  public void setUp() {
    client = new Client();
    client.setId(1);
    client.setCpf("12345678901");
    client.setName("John Doe");
    client.setPhone("123456789");
    client.setEmail("john.doe@example.com");
    client.setTable(null);
    client.setPeopleQuantity(2);
  }

  @Test
  public void testIdNotNull() {
    assertTrue("Client ID should not be null", client.getId() != null);
  }

  @Test
  public void testToString() {
    String expected = "Client [id=1, cpf=12345678901, name=John Doe, phone=123456789, email=john.doe@example.com, table= null, peopleQuantity=2]";
    assertTrue(expected.equals(client.toString()));
  }
}