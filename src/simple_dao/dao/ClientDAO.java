package simple_dao.dao;

import simple_dao.entity.Client;

import java.util.List;

public interface ClientDAO {

    void create(Client client);

    Client read(int id);

    void updateByClient(String name, int age, String phone);

    void deleteByClient(String name);

    List<Client> getAll();


}

