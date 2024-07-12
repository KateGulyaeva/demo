package com.examplemvc.demo;

import java.util.Optional;



public interface ClientRepository {

    Optional<client> getClientById(int id);
}