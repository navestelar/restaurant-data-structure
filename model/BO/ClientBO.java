package model.BO;

import data_structure.DoublyLinkedList;
import model.DAO.ClientDAO;
import model.DTO.Client;
import model.interfaces.DAO;

public class ClientBO {
  private DAO<Client> dao;

  public ClientBO() {
    this.dao = new ClientDAO();
  }

  public boolean registerClient(Client client) {
    return dao.create(client);
  }

  public Client removeClient(Integer id) {
    return dao.delete(id);
  }

  public Client updateClient(Client client) {
    return dao.update(client);
  }

  public Client readClient(Integer id) {
    return dao.read(id);
  }

  public DoublyLinkedList<Client> readClientList() {
    return dao.readAll();
  }
}