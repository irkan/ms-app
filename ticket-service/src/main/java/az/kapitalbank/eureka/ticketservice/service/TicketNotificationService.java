package az.kapitalbank.gateway.ticketservice.service;

import az.kapitalbank.gateway.ticketservice.model.Ticket;

public interface TicketNotificationService {

    void sendToQueue(Ticket ticket);
}
