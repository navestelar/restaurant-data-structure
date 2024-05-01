package com.restaurant.controller;

import org.junit.Before;
import org.junit.Test;

import com.restaurant.data_structure.HashMapLinked;
import com.restaurant.model.Client;
import com.restaurant.view.ClientView;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class ClientControllerTest {

  private ClientController controller;
  private ClientView view;
  private HashMapLinked<String, Client> clientList;

  @Before
  public void setUp() {
    view = mock(ClientView.class);
    clientList = mock(HashMapLinked.class);
    controller = new ClientController(view, clientList);
  }

  @Test
  public void testRegisterClient() {
    // Setup
    Client client = new Client();
    client.setId(1);
    client.setCpf("12345678901");
    client.setName("John Doe");
    client.setPhone("123456789");
    client.setEmail("john.doe@example.com");

    // Mock the behavior of the HashMapLinked mock to return true when put is called
    when(clientList.put(anyString(), any(Client.class))).thenReturn(true);

    // Execute
    boolean result = controller.create(client);

    // Verify
    assertTrue(result);
    verify(clientList, times(1)).put(anyString(), any(Client.class));
  }

  @Test
  public void testRegisterClientDuplicateCpf() {
    // Setup
    Client client = new Client();
    client.setId(1);
    client.setCpf("12345678901");
    client.setName("John Doe");
    client.setPhone("123456789");
    client.setEmail("john.doe@example.com");

    // Mock the behavior of the HashMapLinked mock to return false when put is called
    when(clientList.put(anyString(), any(Client.class))).thenReturn(false);

    // Execute
    boolean result = controller.create(client);

    // Verify
    assertFalse(result);
    verify(clientList, times(1)).put(anyString(), any(Client.class));
  }
}
