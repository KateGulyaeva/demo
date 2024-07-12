package com.examplemvc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.sql.ResultSet;

public class DatabaseHandler extends Config {
    private Connection connection;

    // подключение к БД
    public DatabaseHandler() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName,
                    dbUser, dbPass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    private static final Map<Integer, client> CLIENT_REPOSITORY_MAP = new HashMap<>();
    private static final Map<Integer, client> SERVICE_REPOSITORY_MAP = new HashMap<>();

    // получение всех клиентов из таблицы
    public ResultSet SelectAllClient() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from client");
        return resultSet;
    }

    // получение всех сервисов из БД
    public ResultSet SelectAllMicroservices() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from microservices");
        return resultSet;
    }

    // добавление нового клиента в БД //
    public void AddClient(String fio, String email) throws SQLException {
        String query = String.format("insert into client (fio, email) VALUES ('%s', '%s')", fio, email);
        Statement statement = this.getConnection().createStatement();
        statement.executeUpdate(query);
    }

    // добавление нового сервиса в БД
    public void AddMicroservices(String name) throws SQLException {
        String query = String.format("insert into microservices (name) VALUES ('%s')", name);
        Statement statement = this.getConnection().createStatement();
        statement.executeUpdate(query);
    }

    // удаление клиента по id из БД
    public void deleteClientById(int id_client) throws SQLException {
        String query = String.format("DELETE FROM client WHERE id_client = '%d'", id_client);
        Statement statement = this.getConnection().createStatement();
        statement.executeUpdate(query);
    }
    // удаление клиента по ФИО
    public void deleteClientByFio(String fio) throws SQLException {
        String query = String.format("DELETE FROM client WHERE fio = '%s')", fio);
        Statement statement = this.getConnection().createStatement();
        statement.executeUpdate(query);
    }
    // удаление клиента по email 
    public void deleteClientByEmail(String email) throws SQLException {
        String query = String.format("DELETE FROM client WHERE email = '%s')", email);
        Statement statement = this.getConnection().createStatement();
        statement.executeUpdate(query);
    }

    // удаление сервиса по id из БД
    public void deleteServiceById(int id_ms) throws SQLException {
        String query = String.format("DELETE FROM microservices WHERE id_ms = '%d')", id_ms);
        Statement statement = this.getConnection().createStatement();
        statement.executeUpdate(query);
    }
    // удаление сервиса по названию 
    public void deleteServiceByFio(String name) throws SQLException {
        String query = String.format("DELETE FROM microservices WHERE name = '%s')", name);
        Statement statement = this.getConnection().createStatement();
        statement.executeUpdate(query);
    }

    /*
     * // обновление определеного клиента в БД
     * public void updateClient(String fio, String email) throws SQLException {
     * String query =
     * String.format("UPDATE client SET fio =  '%s') WHERE id_client = ?", fio,
     * email);
     * Statement statement = this.getConnection().createStatement();
     * statement.executeUpdate(query);
     * }
     */
    
    // изменение фамилии определеного клиента в БД
    public void updateClientFio(int id_client, String fio) throws SQLException {
        String query = String.format("UPDATE client SET fio =  '%s' WHERE id_client = %d", fio, id_client);
        Statement statement = this.getConnection().createStatement();
        statement.executeUpdate(query);
    }

    // изменение email определеного клиента в БД
    public void updateClientEmail(int id_client, String email) throws SQLException {
        String query = String.format("UPDATE client SET email =  '%s' WHERE id_client = %d", email, id_client);
        Statement statement = this.getConnection().createStatement();
        statement.executeUpdate(query);
    }

    // изменение имени определеного сервиса в БД
    public void updateServiceName(int id_ms, String email) throws SQLException {
        String query = String.format("UPDATE microservices SET email =  '%s' WHERE id_ms = %d", email, id_ms);
        Statement statement = this.getConnection().createStatement();
        statement.executeUpdate(query);
    }

    // поиск клиента по id
    public client findClient(int id_client) throws SQLException {
        return CLIENT_REPOSITORY_MAP.get(id_client);
    }

    // поиск по ФИО клиента в БД
    public int findClientFio(String fio) throws SQLException {
        String query = String.format("select id_client from client where fio = '%s' ", fio);
        Statement statement = this.getConnection().createStatement();
        int id_client = statement.executeUpdate(query);
        return id_client;
    }

    // поиск по email клиента в БД
    public int findClientEmail(String email) throws SQLException {
        String query = String.format("select id_client from client where email = '%s' ", email);
        Statement statement = this.getConnection().createStatement();
        int id_client = statement.executeUpdate(query);
        return id_client;
    }

    // поиск сервиса по id
    public client findService(int id_ms) throws SQLException {
        return SERVICE_REPOSITORY_MAP.get(id_ms);
    }

    // поиск по названию сервиса в БД
    public int findServiceName(String name) throws SQLException {
        String query = String.format("select id_ms from microservices where name = '%s' ", name);
        Statement statement = this.getConnection().createStatement();
        int id_ms = statement.executeUpdate(query);
        return id_ms;
    }
    
    /*
     * 
     * // write and read into database
     * //PreparedStatement statement = ((Connection)
     * dataSource).prepareStatement(dbHost, ResultSet.TYPE_SCROLL_SENSITIVE,
     * ResultSet.CONCUR_UPDATABLE);
     * 
     * 
     * 
     * public String getFIO() throws SQLException, ClassNotFoundException{
     * String sql = "SELECT query_to_xml('SELECT * FROM rooms', true, false, '')";
     * 
     * try (java.sql.Statement Statement = ((Connection)
     * dataSource).createStatement()) {
     * ResultSet res = Statement.executeQuery(sql);
     * 
     * String tasks = "";
     * while (res.next()) {
     * tasks += res.getString(1);
     * 
     * }
     * return tasks;
     * }
     * }
     */
}
