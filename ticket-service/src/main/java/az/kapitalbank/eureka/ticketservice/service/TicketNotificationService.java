package az.kapitalbank.eureka.ticketservice.service;

import az.kapitalbank.eureka.ticketservice.model.Ticket;

public interface TicketNotificationService {

    void sendToQueue(Ticket ticket);
}
