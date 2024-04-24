import data_structure.DoublyLinkedList;

public class Main {
  public static void main(String[] args) {
    // 1. Gestão de Clientes:
    ClientList clientList = new ClientList();

    Client client1 = new Client(1, "Ana", "123456789", "ana@gmail.com");
    Client client2 = new Client(2, "Joaquim", "101112131", "joaquim@gmail.com");
    Client client3 = new Client(3, "Fernanda", "415161718", "fernanda@gmail.com");
    Client client4 = new Client(4, "Lucas", "192021222", "lucas@gmail.com");
    Client client5 = new Client(5, "Joaquim", "101112131", "joaquim@gmail.com");
    Client client6 = new Client(6, "Leonardo", "282930313", "leonardo@gmail.com");

    // 1-a. Cadastro de novos clientes.
    clientList.create(client1);
    clientList.create(client2);
    clientList.create(client3);
    clientList.create(client4);
    clientList.create(client5);
    clientList.create(client6);

    clientList.showList();

    // 1.b- Remoção de clientes.
    clientList.delete(3);
    clientList.showList();

    // 1.c- Atualização de informações dos clientes.
    clientList.update(0, new Client("Ana", "9999999999", "ana@gmail.com"));
    clientList.showList();

    // 1.d- Consulta de clientes cadastrados.
    System.out.println(clientList.read(0));

    // 2. Gestão de Pedidos:
    OrderItem orderItem1 = new OrderItem("x-burger", 20f, 2);
    OrderItem orderItem2 = new OrderItem("x-salada", 10f, 2);
    DoublyLinkedList<OrderItem> orderItems = new DoublyLinkedList<OrderItem>();
    orderItems.add(orderItem1);
    orderItems.add(orderItem2);
    Order order = new Order(1, orderItems);
    OrderList orderList = new OrderList();
    
    // 2.a- Registro de novos pedidos.
    orderList.create(order);
    orderList.read(0).calculateTotalPrice();
    orderList.showList();

    // 2.b- Alteração de pedidos.
    OrderItem orderItem3 = new OrderItem("agua", 5f, 4);
    orderItems.remove(orderItem1);
    orderItems.add(orderItem3);

    orderList.update(0, new Order(1, orderItems));
    orderList.read(0).calculateTotalPrice();
    orderList.showList();

    // 2.c- Cancelamento de pedidos.
    orderList.cancel(0);
    orderList.showList();

    // 2.d- Consulta de pedidos realizados.
    orderList.showList();

    // 3. Gestão de Mesas:
    Table table1 = new Table(1, 2);
    Table table2 = new Table(1, 3);
    Table table3 = new Table(2, 3);
    Table table4 = new Table(3, 4);
    Table table5 = new Table(4, 5);

    TableList tableList = new TableList();
    tableList.create(table1);
    tableList.create(table2);
    tableList.create(table3);
    tableList.create(table4);
    tableList.create(table5);

    tableList.showList();

    tableList.delete(4);
    tableList.showList();

    tableList.update(1, new Table(1, 4));
    tableList.showList();

    tableList.update(2, table5);
    tableList.showList();

    clientList.read(0).setPeopleQuantity(5);
    clientList.read(2).setPeopleQuantity(3);
    // 3-a. Alocação de mesas para clientes.
    tableList.allocateClient(4, clientList.read(0));
    tableList.allocateClient(1, clientList.read(1));
    tableList.allocateClient(1, clientList.read(5));
    tableList.showList();

    // 3-b. Liberação de mesas após a saída dos clientes.
    tableList.deallocateClient(4);
    tableList.showList();

    // 3-c. Consulta de mesas ocupadas e disponíveis.
    System.out.println("Available tables: ");
    tableList.getAvailableTables().showList();
    System.out.println("Occupied tables: ");
    tableList.getOccupiedTables().showList();

    // 3-d. Controle de capacidade das mesas.
    System.out.println("Table with capacity 5: ");
    tableList.getTablesByCapacity(5).showList();

    // 4. Gestão de Funcionários:
    EmployeeList employeeList = new EmployeeList();
    Employee employee1 = new Employee("Natielly", "993456789", "natielly@restaurant.com", "chefe de cozinha");
    Employee employee2 = new Employee("Renato", "101112131", "renato@restaurant.com", "garçon");

    // 4-a. Cadastro de novos funcionários.
    employeeList.create(employee1);
    employeeList.create(employee2);
    employeeList.showList();

    // 4-b. Remoção de funcionários.
    employeeList.delete(1);
    employeeList.showList();

    // 4-c. Escala de trabalho dos funcionários.
    employeeList.read(0).setScaleOfWork("40 hours/week");
    employeeList.showList();

    // 4-d. Consulta de funcionários cadastrados.
    employeeList.read(0);

    // 5. Simulação do Fluxo de Atendimento:
    // 5-a. Encaminhamento de clientes para mesas disponíveis.
    clientList.showList();
    clientList.read(2).setPeopleQuantity(3);
    tableList.getAvailableTables(3).showList();
    tableList.allocateClient(1, clientList.read(2));
    tableList.showList();

    // 5-b. Atendimento de pedidos pelos garçons.
    OrderQueue orderQueue = new OrderQueue();
    Order order5 = new Order(2, orderItems);
    orderList.create(order5);
    orderQueue.addOrder(order5.getId());
    
    // 5-c. Preparação de pedidos pelos cozinheiros.
    Integer orderId = orderQueue.getOrderId();
    Order currentOrder = orderList.read(orderId);
    currentOrder.setStatus(OrderStatus.IN_PROGRESS);
    System.out.println("Order: "+currentOrder.toString());

    // 5-d. Entrega de pedidos aos clientes.
    currentOrder.setStatus(OrderStatus.COMPLETED);
    System.out.println("Order: "+currentOrder.toString());
  
    
  }
}