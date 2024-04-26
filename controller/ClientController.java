package controller;

import data_structure.HashMapLinked;
import model.Client;
import view.ClientView;

public class ClientController {
  private ClientView view = new ClientView();
  private HashMapLinked<String, Client> clientList = new HashMapLinked<String, Client>();

  public ClientController() {
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
    client.setPhone(view.readPhone());
    client.setEmail(view.readEmail());

    if (clientList.put(client.getCpf(), client)) {
      System.out.println("Client registered successfully!");
    } else {
      System.out.println("Client already exists!");
    }
  }

  private void removeClient() {
    listClients();
    Integer id = view.readId();

    view.showMessage("Remove client: ");
    Client client = showClient(id);
    if (client != null) {
      boolean canExclude = view.readConfirmation();
  
      if (canExclude) {
        clientList.remove(client.getCpf());
      }
    }
  }


  private void updateClient() {
    listClients();
    Integer id = view.readId();

    view.showMessage("Update client: ");
    Client client = showClient(id);

    Integer option;
    do {
      view.showMenuUpdate();
      option = Integer.parseInt(System.console().readLine());

      switch (option) {
        case 1:
          client.setName(view.readName());
          break;
        case 2:
          client.setPhone(view.readPhone());
          break;
        case 3:
          client.setEmail(view.readEmail());
          break;
        case 0:
          view.showMessage("Updating client...");
          break;
        default:
          view.showMessage("Invalid option!");
          break;
      }
    } while (option != 0);

    view.showMessage("Client updated successfully! ");
    showClient(id);
  }

  private void listClients() {
    clientList.showList();
  }

  private void searchClient() {
    listClients();
    Integer id = view.readId();
    showClient(id);
  }

  private Client showClient(Integer id) {
    Client client = clientList.getByIndex(id);

    if (client != null) {
      view.showMessage("Id: " + id + ", Cliente: " + client.toString());
      return client;
    }
    
    view.showMessage("Client not found!");
    return null;
  }
}
