package simple_dao;

public class Main {
    public static void main(String[] args) {

        CarShopService carShopService = new CarShopService();

        //carShopService.printAllCars();

        // Use case 1. Test CRUD's 'Create' operation
        // carShopService.createNewCar();

        // Use case 2. Test CRUD's 'Read' operation
        // carShopService.readCar();

        // Use case 3. Test CRUD's 'Update' operation
        // carShopService.updateCar();

        // Use case 4. Test CRUD's 'Delete' operation
        // carShopService.deleteCar();
//------------------------------------------------------------

        // Use case 5. Client test 'allClient' operation
         carShopService.printAllClients();

        // Use case 6. Client test 'Create' operation
        // carShopService.createNewClient();

        // Use case 7. Client test 'Read' operation
        // carShopService.readClient();

        // Use case 8. Client test 'Update' operation
        // carShopService.updateClient();

        // Use case 9. Client test 'deleteClient' operation
        // carShopService.deleteClient();

    }
}
