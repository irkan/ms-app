package az.kapitalbank.gateway.ticketservice.repository.es;

import az.kapitalbank.gateway.ticketservice.model.es.TicketModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface TicketElasticRepository extends ElasticsearchRepository<TicketModel, String> {
}
