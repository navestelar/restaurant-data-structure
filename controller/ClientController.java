package controller;

import data_structure.DoublyLinkedList;
import model.BO.ClientBO;
import model.DTO.Client;
import view.ClientView;

public class ClientController {
  private ClientView view;
  private ClientBO clientBO;

  public ClientController() {
    this.view = new ClientView();
    this.clientBO = new ClientBO();
  }

  public void start() {
    Integer option;

    do {
      view.showMenu();
      option = Integer.parseInt(System.console().readLine());

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
          view.showMessage("Exiting...");
          break;
        default:
          view.showMessage("Invalid option!");
          break;
      }
    } while (option != 0);
  }

  private void registerClient() {
    Client client = new Client();
    client.setName(view.readName());
    client.setAge(view.readAge());
    client.setEmail(view.readEmail());
    client.setPhone(view.readPhone());

    if (clientBO.registerClient(client)) {
      view.showMessage("Client registered successfully!");
    } else {
      view.showMessage("This client is already registered, please try again!");
    }
  }

  private void removeClient() {
    listClients();
    Integer id = view.readId();

    view.showMessage("Remove client: ");
    if (showClient(id)) {
      boolean canExclude = view.readConfirmation();
  
      if (canExclude) {
        if (clientBO.removeClient(id) != null) {
          view.showMessage("Client removed successfully!");
        }
      }
    }
  }

  private void updateClient() {
    Client newClient = new Client();

    listClients();
    Integer id = view.readId();

    view.showMessage("Update client: ");
    if (showClient(id)) {
      newClient.setId(id);
      newClient.setName(view.readName());
      newClient.setAge(view.readAge());
      newClient.setEmail(view.readEmail());
      newClient.setPhone(view.readPhone());
  
      if (clientBO.updateClient(newClient) != null) {
        view.showMessage("Client updated successfully!");
        showClient(id);
      } else {
        view.showMessage("Something went wrong, please try again!");
      }
    }
  }

  private void listClients() {
    DoublyLinkedList<Client> clients = clientBO.readClientList();

    for (int i = 0; i < clients.size(); i++) {
      view.showMessage(clients.get(i).getId() + ": " + clients.get(i).toString());
    }
  }

  private void searchClient() {
    listClients();
    Integer id = view.readId();
    showClient(id);
  }

  private boolean showClient(Integer id) {
    Client client = clientBO.readClient(id);

    if (client != null) {
      view.showMessage(client.getId() + ": " + client.toString());
      return true;
    }
    
    view.showMessage("Client not found!");
    return false;
  }
}
