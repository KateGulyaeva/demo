package com.examplemvc.demo;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
public class microservices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id_ms; // первичный ключ
    private String name; // название сервиса
    private String ReportSection; // сообщение, которое будет включено в отчет
    private int order; // приоритет сбора информации

    public microservices( int id_ms, @NonNull String name, String ReportSection, int order){
        this.id_ms = id_ms;
        this.name = name;
        this.ReportSection = ReportSection;
        this.order = order;
    }

}

/*/
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.boot.web.server.Ssl.ClientAuth;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


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
