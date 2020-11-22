package az.kapitalbank.eureka.ticketservice.repository;

import az.kapitalbank.eureka.ticketservice.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, String> {
}
