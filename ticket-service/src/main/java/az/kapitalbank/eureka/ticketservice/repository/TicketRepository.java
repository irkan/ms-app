package az.kapitalbank.gateway.ticketservice.repository;

import az.kapitalbank.gateway.ticketservice.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, String> {
}
