package controller;

import org.junit.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ClientControllerTest {

  @Mock
  private ClientView view;

  @Mock
  private HashMapLinked<String, Client> clientList;

  @InjectMocks
  private ClientController clientController;

  @Before
  public void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void testRegisterClient() {
    // Arrange
    Client client = new Client();
    client.setId(1);
    client.setCpf("12345678900");
    client.setName("John Doe");
    client.setPhone("1234567890");
    client.setEmail("john.doe@example.com");

    when(clientList.put(anyString(), any(Client.class))).thenReturn(true);
    when(view.readCpf()).thenReturn("12345678900");
    when(view.readName()).thenReturn("John Doe");
    when(view.readPhone()).thenReturn("1234567890");
    when(view.readEmail()).thenReturn("john.doe@example.com");

    // Act
    clientController.registerClient();

    // Assert
    verify(clientList, times(1)).put(anyString(), any(Client.class));
    verify(view, times(1)).showMessage("Client registered successfully!");
  }
}
