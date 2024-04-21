package model.DAO;

import data_structure.DoublyLinkedList;
import data_structure.HashMapLinked;
import model.DTO.Client;
import model.interfaces.DAO;

public class ClientDAO implements DAO<Client> {
  private HashMapLinked<Integer, Client> clientList = new HashMapLinked<Integer, Client>();
  private Integer currentId = 0;

  public boolean create(Client client) {
    if (!clientList.contains(client)) {
      client.setId(currentId);
      clientList.put(currentId, client);
      currentId++;
      return true;
    }

    return false;
  }

  public Client read(Integer id) {
    return clientList.get(id);
  }

  public Client update(Client client) {
    Client oldClient = clientList.get(client.getId());

    if (oldClient != null) {
      oldClient.setData(client);
      return client;
    }

    return null;
  }

  public Client delete(Integer id) {
    return clientList.remove(id);
  }

  public DoublyLinkedList<Client> readAll() {
    return clientList.values();
  }

  public void showList() {
    clientList.showList();
  }
}
