package simple_dao.dao;

import simple_dao.entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientJDBCDao extends AbstractJdbcDao implements ClientDAO{


    @Override
    public List<Client> getAll() {
        List<Client> allClients = new ArrayList<>();
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try{
            preparedStatement = connection.prepareStatement("select id, name, age, phone from clients");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                int age = resultSet.getInt(3);
                String phone = resultSet.getString(4);

                Client client = new Client(id, name, age, phone);
                allClients.add(client);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disposeResources(connection, preparedStatement);
        }
        return allClients;
    }


    @Override
    public void create(Client client) {
        Connection connection = getConnection();
        PreparedStatement statement = null;

        try{
            statement = connection.prepareStatement("INSERT INTO clients(id, name, age, phone) VALUES (?, ?, ?, ?)");

            statement.setLong(1, client.getId());
            statement.setString(2, client.getName());
            statement.setInt(3, client.getAge());
            statement.setString(4, client.getPhone());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disposeResources(connection, statement);
        }

    }

    @Override
    public Client read(int id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement("select * from clients as cl where cl.id = ?");
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String phone = rs.getString(4);

                Client client = new Client(id, name, age, phone);
                return client;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disposeResources(connection, preparedStatement);
        }
        return null;
    }

    @Override
    public void updateByClient(String name, int age, String phone){
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        try{

            preparedStatement = connection.prepareStatement("UPDATE clients SET age = ? , phone = ? WHERE name = ?");

            preparedStatement.setInt(1, age);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, name);

            int updatedValues = preparedStatement.executeUpdate();
            System.out.println("Values update: " + updatedValues);

    } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disposeResources(connection, preparedStatement);
        }
    }



    @Override
    public void deleteByClient(String name) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;

        try{
            preparedStatement = connection.prepareStatement("DELETE FROM clients  WHERE name = ?");
            preparedStatement.setString(1, name);

            int deletedValues = preparedStatement.executeUpdate();
            System.out.println("Values deleted: " + deletedValues);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disposeResources(connection, preparedStatement);
        }
    }
}
