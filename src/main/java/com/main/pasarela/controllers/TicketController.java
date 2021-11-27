package com.main.pasarela.controllers;

import com.main.pasarela.entities.Ticket;
import com.main.pasarela.repositories.TicketRepository;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author frank
 */
@RestController
public class TicketController {
    
    private final TicketRepository ticketRepository;

    public TicketController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }
    
    @GetMapping("/tickets")
    List<Ticket> allTickets(){
        return ticketRepository.findAll();
    }
    
    @PostMapping("/ticket")
    Ticket newTicket(@RequestBody Ticket newTicket){
        return ticketRepository.save(newTicket);
    }
    
    @DeleteMapping("/ticket/{id}")
    void deleteTicket(@PathVariable Integer id) {
        ticketRepository.deleteById(id);
    }
}
