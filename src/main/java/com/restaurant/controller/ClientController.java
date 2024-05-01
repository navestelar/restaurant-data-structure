package com.restaurant.controller;

import com.restaurant.data_structure.HashMapLinked;
import com.restaurant.model.Client;
import com.restaurant.model.Table;
import com.restaurant.view.ClientView;
import com.restaurant.view.InputView;
import com.restaurant.view.View;

public class ClientController {
  private ClientView view;
  private HashMapLinked<String, Client> clientList;
  private Integer currentId = 1;

  public ClientController(ClientView view, HashMapLinked<String, Client> clientList) {
    this.view = view;
    this.clientList = clientList;
  }

  public ClientController() {
    clientList = new HashMapLinked<String, Client>();
    view = new ClientView();
  }

  public void start() {
    Integer option = null;

    do {
      view.showMenu();

      option = InputView.readInteger("Option: ");

      switch (option) {
        case 1:
          registerClient();
          break;
        case 2:
          removeClient();
          break;
        case 3:
          updateClient();
          break;
        case 4:
          searchClient();
          break;
        case 5:
          listClients();
          break;
        case 0:
          View.showMessage("Exiting...");
          break;
        default:
          View.showMessage("Invalid option!");
          break;
      }
    } while (option != 0);
  }

  private void registerClient() {
    View.showMessage("Register Client: ");
    Client client = new Client();
    client.setId(currentId);
    client.setCpf(InputView.readString("Cpf: "));
    client.setName(InputView.readString("Name: "));
    client.setPhone(InputView.readString("Phone: "));
    client.setEmail(InputView.readString("Email: "));

    if (create(client)) {
      View.showMessage("Client registered successfully!");
      currentId++;
    }

    View.showMessage("Already exists a client with this cpf!");
  }

  private boolean removeClient() {
    View.showMessage("Remove Client: ");
    listClients();
    Integer id = InputView.readInteger("Id: ");

    View.showMessage("Client to remove: ");
    Client client = showClient(id);
    if (client != null) {
      boolean canExclude = View.readConfirmation();

      if (canExclude) {
        Table table = client.getTable();
        if (table != null) {
          table.setClient(null);
        }
        clientList.remove(client.getCpf());
        return true;
      }
    }

    return false;
  }

  private boolean updateClient() {
    View.showMessage("Update Client: ");
    listClients();
    Integer id = InputView.readInteger("Id: ");

    View.showMessage("Client to update: ");
    Client client = showClient(id);
    Client newClient = client;

    if (client != null) {
      Integer option = null;
      do {
        view.showMenuUpdate();
        option = InputView.readInteger("Option: ");

        switch (option) {
          case 1:
            newClient.setName(InputView.readString("Name: "));
            break;
          case 2:
            newClient.setPhone(InputView.readString("Phone: "));
            break;
          case 3:
            newClient.setEmail(InputView.readString("Email: "));
            break;
          case 0:
            View.showMessage("Updating client...");
            break;
          default:
            View.showMessage("Invalid option!");
            break;
        }
      } while (option != 0);

      update(newClient);
      View.showMessage("Client updated successfully! ");
      showClient(id);
      return true;
    }

    return false;
  }

  public boolean listClients() {
    if (clientList.size() > 0) {
      clientList.showList();
      return true;
    }

    View.showMessage("Client list is empty");
    return false;
  }

  private boolean searchClient() {
    String value = InputView.readString("Search Client: ");

    HashMapLinked<String, Client> searchClients = clientList.searchString(value);

    if (searchClients.size() > 0) {
      View.showMessage(searchClients.toStringWithKey());
      return true;
    }

    View.showMessage("Client not found!");
    return false;
  }

  public Client setPeopleQuantity() {
    View.showMessage("Set People Quantity: ");
    listClients();
    Integer id = InputView.readInteger("Id: ");
    Client client = showClient(id);

    if (client != null) {
      client.setPeopleQuantity(InputView.readInteger("People Quantity: "));
      View.showMessage("People quantity updated!");
      return client;
    }

    View.showMessage("Client not found!");
    return null;
  }

  public Client showClient(Integer id) {
    HashMapLinked<String, Client> clients = clientList.searchString("Client [id=" + id);
    Client client = clients.getByIndex(0);

    if (client != null) {
      View.showMessage(client.toString());
      return client;
    }

    View.showMessage("Client not found!");
    return null;
  }

  public boolean create(Client client) {
    return clientList.put(client.getCpf(), client);
  }

  public boolean update(Client client) {
    return clientList.update(client.getCpf(), client.getCpf(), client);
  }
}
