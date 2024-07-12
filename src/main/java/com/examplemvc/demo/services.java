/*package com.examplemvc.demo;

import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.boot.web.server.Ssl.ClientAuth;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

public record services(
         int id_service,
         String name
) {

    
@Repository
public class ClientRepositoryImpl implements ClientRepository {

    private static final String SQL_GET_SERVICES_BY_ID =
            "select id_service, name,  from services where id_service = :id_service";

    private final PropertyMapper ClientMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ClientRepositoryImpl(   ClientAuth ClientMapper, NamedParameterJdbcTemplate jdbcTemplate ) {
        this.ClientMapper = ClientMapper;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<client> getcLIENTById(int id) {
        var params = new MapSqlParameterSource();
        params.addValue("id_service", id_service);
        return jdbcTemplate.query( SQL_GET_SERVICES_BY_ID,  params,  ClientMapper ).stream().findFirst();
    }
}
    
    
}
*/
