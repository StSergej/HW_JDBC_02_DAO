package simple_dao.dao;

import simple_dao.entity.Car;

import java.util.List;

public interface CarDAO {

    void create(Car car);

    Car read(long id);

    void updatePrice(int price, int carId);

    void deleteByMake(String make);

    List<Car> getAll();
}
