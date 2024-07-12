package com.examplemvc.demo;
import lombok.Data;

@Data
public class client {
    /*public static final String CLIENT_TABLE = "client";    
    public static final String CLIENT_ID = "id_client";
    public static final String CLIENT_FIO = "fio";
    public static final String CLIENT_Email = "email";
*/
    
    private int id_client;
    private String Fio;
    private String Email;

    
    public client(int id_client, String fio, String email){
        this.id_client=id_client;
        this.Email = email;
        this.Fio = fio;
	}
    public client( String fio, String email){
        this.Email = email;
        this.Fio = fio;
	}
    public int getId_client(){
        return id_client;

    }
    public String getfio() {
        return Fio;
    }
    public String getEmail() {
        return Email;
    }
/*/
    public void setId_client(int id_client){
        this.id_client = id_client;
    }*/
    public void setFio(String fio) {
        this.Fio = fio;
    }
    public void setEmail(String email) {
        this.Email = email;
    }

    // добавление клиента
    
/*/
    
    // получать подписки клиента -- из базы
    public client findById(Integer id_client) throws SQLException {
    
            try (  Connection connection = DatabaseHandler.dataSource.getConnection()) { // (1)
               PreparedStatement selectStatement = dataSource.prepareStatement("select * from client where id =  ?");
               return Client;
        }
    }

    public client getclientByFio(Integer id_client){
        
        //this.fio = dataSource.getConnection();
        return client;
    }

    public client getclientByEmail(String email){
        
        //this.fio = dataSource.getConnection();
        return client;
    }
    private <ArrayList> client getAllclient(){

    }


    //поиск клиента
 /*   public Client searchforFio(){
        
        return client;
    }

    // удаление 
    public void deleteClient(String fio, String email){


    }

    public static String getClientTable() {
        return CLIENT_TABLE;
    }

    public static String getClientId() {
        return CLIENT_ID;
    }

    public static String getClientFio() {
        return CLIENT_FIO;
    }

    public static String getClientEmail() {
        return CLIENT_Email;
    }
*/
    }

    // добавление клиента

    // обновление клиента





