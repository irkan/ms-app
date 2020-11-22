package az.kapitalbank.eureka.ticketservice.repository.es;

import az.kapitalbank.eureka.ticketservice.model.es.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel, String> {
}
