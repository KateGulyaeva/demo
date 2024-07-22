package com.examplemvc.demo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class client {

    private int id_client;
    private String Fio;
    private String Email;

 
    public client(int id_client, String Fio, String email){
        this.id_client=id_client;
        this.Email = email;
        this.Fio = Fio;
	}
    public client( String Fio, String email){
        this.Email = email;
        this.Fio = Fio;
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

    public void setFio(String Fio) {
        this.Fio = Fio;
    }
    public void setEmail(String email) {
        this.Email = email;
    }

    // добавление клиента

    

    //поиск клиента
 /*   public Client searchforFio(){
        
        return client;
    }

    // удаление 
    public void deleteClient(String Fio, String email){
    }
 
*/
  // обновление клиента
    }

  





