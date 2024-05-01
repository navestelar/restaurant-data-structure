package controller;

import data_structure.HashMapLinked;
import model.Client;
import view.ClientView;

public class ClientController {
  private ClientView view = new ClientView();
  private HashMapLinked<String, Client> clientList = new HashMapLinked<String, Client>();
  private Integer currentId = 1;

  public ClientController() {
  }

  public void start() {
    Integer option = null;

    do {
      view.showMenu();
      Boolean isOptionInvalid = false;

      do {
        try {
          System.out.print("Enter an option: ");
          option = Integer.parseInt(System.console().readLine());
          isOptionInvalid = false;
        } catch (NumberFormatException ex) {
          System.out.println("Not a number, try again");
          isOptionInvalid = true;
        }
      } while (isOptionInvalid);

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
    view.showMessage("Register Client: ");
    Client client = new Client();
    client.setId(currentId);
    client.setCpf(view.readCpf());
    client.setName(view.readName());
    client.setPhone(view.readPhone());
    client.setEmail(view.readEmail());

    if (clientList.put(client.getCpf(), client)) {
      System.out.println("Client registered successfully!");
      currentId++;
    } else {
      System.out.println("Already exists a client with this cpf!");
    }
  }

  private void removeClient() {
    view.showMessage("Remove Client: ");
    listClients();
    Integer id = view.readId();

    view.showMessage("Client to remove: ");
    Client client = showClient(id);
    if (client != null) {
      boolean canExclude = view.readConfirmation();

      if (canExclude) {
        clientList.remove(client.getCpf());
      }
    }
  }

  private void updateClient() {
    view.showMessage("Update Client: ");
    listClients();
    Integer id = view.readId();

    view.showMessage("Client to update: ");
    Client client = showClient(id);

    Integer option = null;
    do {
      view.showMenuUpdate();
      Boolean isOptionInvalid = false;

      do {
        try {
          System.out.print("Enter an option: ");
          option = Integer.parseInt(System.console().readLine());
          isOptionInvalid = false;
        } catch (NumberFormatException ex) {
          System.out.println("Not a number, try again");
          isOptionInvalid = true;
        }
      } while (isOptionInvalid);

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

  public void listClients() {
    clientList.showList();
  }

  private void searchClient() {
    String value = view.readSearchString();

    HashMapLinked<String, Client> searchClients = clientList.searchString(value);

    if (searchClients.size() > 0) {
      System.out.println(searchClients.toStringWithKey());
    } else {
      view.showMessage("Client not found!");
    }
  }

  public Client setPeopleQuantity() {
    view.showMessage("Set People Quantity: ");
    listClients();
    Integer id = view.readId();
    Client client = showClient(id);

    if (client != null) {
      client.setPeopleQuantity(view.readPeopleQuantity());
      view.showMessage("People quantity updated!");
      return client;
    }

    view.showMessage("Client not found!");
    return null;
  }

  public Client showClient(Integer id) {
    HashMapLinked<String, Client> clients = clientList.searchString("Client [id=" + id);
    Client client = clients.getByIndex(0);

    if (client != null) {
      view.showMessage(client.toString());
      return client;
    }

    view.showMessage("Client not found!");
    return null;
  }
}
