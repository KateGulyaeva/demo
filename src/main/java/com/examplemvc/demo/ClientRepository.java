package com.examplemvc.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface ClientRepository extends CrudRepository<client, Integer> {

    Optional<client> getClientById(int id);

  //  client save(client client);

    List<client> findAll();

    Object findById(int id_client);

    void deleteById(int id_client);

    @Query(value = "SELECT c FROM client c WHERE c.name LIKE '%' || :keyword || '%'"
            + " OR c.email LIKE '%' || :keyword || '%'")
    public List<client> search(@Param("keyword") String keyword);
}