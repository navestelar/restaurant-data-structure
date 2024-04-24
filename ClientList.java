import data_structure.DoublyLinkedList;
import data_structure.HashMapLinked;

public class ClientList {
  private HashMapLinked<Integer, Client> clientList = new HashMapLinked<Integer, Client>();
  private Integer currentId = 0;

  public boolean create(Client client) {
    if (!clientList.contains(client)) {
      client.setId(currentId);
      clientList.put(currentId, client);
      currentId++;
      System.out.println("Client successfully registered!");
      return true;
    }

    System.out.println("Client already exists!");
    return false;
  }

  public Client read(Integer id) {
    Client client = clientList.get(id);

    if (client == null) {
      System.out.println("Client not found!");
    }

    return client;
  }

  public Client update(Integer id, Client client) {
    Client oldClient = clientList.get(id);

    if (oldClient != null) {
      oldClient.setData(client);
      System.out.println("Client updated!");
      return oldClient;
    }

    System.out.println("Client not found!");
    return null;
  }

  public Client delete(Integer id) {
    Client client = clientList.remove(id);

    if (client == null) {
      System.out.println("Client not found!");
      return null;
    }
  
    System.out.println("Client deleted!");
    return client;
  }

  public DoublyLinkedList<Client> readAll() {
    return clientList.values();
  }

  public void showList() {
    clientList.showList();
    System.out.println("----------------------------------------------------");
  }
}
