package simple_dao;

import simple_dao.dao.CarDAO;
import simple_dao.dao.ClientDAO;
import simple_dao.dao.DAOFactory;
import simple_dao.dao.IDAOFactory;
import simple_dao.entity.Car;
import simple_dao.entity.Client;

import java.util.Collections;
import java.util.List;

import static java.util.Comparator.comparing;

public class CarShopService {
    private IDAOFactory factory;
    private CarDAO carDAO;
    private ClientDAO clientDAO;

    public CarShopService() {
        factory = DAOFactory.getInstance();
        carDAO = factory.getCarDAO();
        clientDAO = factory.getClientDAO();

    }

    public void createNewCar() {

        System.out.println("All cars BEFORE insert:");
        printAllCars();

        // A car with existing in db make
        Car car = new Car(4, "Audi", "Q7", 77000);
        carDAO.create(car);

        // A car with non-existing in db make
        car = new Car(5, "Chevrolet", "Corvette", 75000);
        carDAO.create(car);

        System.out.println("\nAll cars AFTER insert:");
        printAllCars();
    }

    public void readCar() {
        Car car = carDAO.read(1);
        System.out.println(car);
    }

    public void updateCar() {
        System.out.println("All cars BEFORE update:");
        printAllCars();

        carDAO.updatePrice(55000, 1);
        carDAO.updatePrice(90000, 2);

        System.out.println("\nAll cars AFTER update:");
        printAllCars();
    }

    public void deleteCar() {
        System.out.println("All cars BEFORE delete:");
        printAllCars();

        // FK should be 'ON UPDATE CASCADE ON DELETE CASCADE'
        carDAO.deleteByMake("Porsche");

        System.out.println("\nAll cars AFTER delete:");
        printAllCars();
    }

    public void printAllCars() {
        List<Car> cars = carDAO.getAll();
        Collections.sort(cars, comparing(Car::getId));
        for(Car car : cars) {
            System.out.println(car);
        }
    }

    //------------------------------------------------------------------------

    public  void createNewClient() {
        System.out.println("All clients BEFORE adding:");
        printAllClients();

        Client client = new Client(4,"Sam", 33, "+380(44)444-44-44");
        clientDAO.create(client);

        client = new Client(5,"Tom", 53, "+380(55)555-55-55");
        clientDAO.create(client);

        System.out.println("\nAll clients AFTER adding:");
        printAllClients();
    }

    public void readClient() {
        Client client = clientDAO.read(2);
        System.out.println(client);

    }

    public  void  updateClient() {
        System.out.println("All clients BEFORE update:");
        printAllClients();

        clientDAO.updateByClient("Max", 21, "+380(11)221-21-21");
        clientDAO.updateByClient("John", 26, "+380(22)226-26-26");

        System.out.println("\nAll clients AFTER update:");
        printAllClients();
    }



    public void deleteClient(){
        System.out.println("All clients BEFORE delete:");
        printAllClients();

        clientDAO.deleteByClient( "Nick");

        System.out.println("\nAll clients AFTER delete:");
        printAllClients();
    }


   public void printAllClients(){
       List<Client> clients = clientDAO.getAll();
       Collections.sort(clients, comparing(Client::getId));
       for(Client client : clients) {
           System.out.println(client);
       }
   }
}
