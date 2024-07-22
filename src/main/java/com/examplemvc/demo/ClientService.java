package com.examplemvc.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ClientService {
     @Autowired ClientRepository repo;

     // добавить (сохранить) клиента
    public void save(client client) {
        repo.save(client);
    }
     // вывести список клиентов
    public List<client> listAll() {
        return (List<client>) repo.findAll();
    }
    // получение по id
    public client get(int id_client) {
        return (client) repo.findById(id_client);
    }
    //удалить клиента
    public void delete(int id_client) {
        repo.deleteById(id_client);
    }
    // поиск клиента по какому-нибудь признаку
    public List<client> search(String keyword) {
        return repo.search(keyword);
    }
}
