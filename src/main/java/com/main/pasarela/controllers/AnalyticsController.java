package com.main.pasarela.controllers;

import com.main.pasarela.entities.Analytics;
import com.main.pasarela.entities.Ticket;
import com.main.pasarela.repositories.TicketRepository;
import com.main.pasarela.utils.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author frank
 */
@RestController
public class AnalyticsController {

    private final TicketRepository ticketRepository;

    public AnalyticsController(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @GetMapping("/ticket/analytics")
    Analytics allAnalytic() {
        return gestionarDatos(ticketRepository.findAll());
        
    }

    private Analytics gestionarDatos(List<Ticket> ticketList) {
        Integer totalProductosVendidos = totalProductosVendidos(ticketList);
        Map<String, Integer> productosVendidosPorTipo = productosVendidosPorTipo(ticketList);
        Integer ticketVisa = numeroTicketTipoPago(ticketList, Constants.VISA);
        Integer ticktesMastercard = numeroTicketTipoPago(ticketList, Constants.MASTERCARD);

        return new Analytics(totalProductosVendidos, productosVendidosPorTipo, ticketVisa, ticktesMastercard);
    }

    private Integer totalProductosVendidos(List<Ticket> ticketList) {
        return ticketList.stream()
                .map(ticket -> ticket.getAmount())
                .reduce(0, Integer::sum);
    }

    private Map<String, Integer> productosVendidosPorTipo(List<Ticket> ticketList) {
        Map<String, Integer> aux = new HashMap<>();
        
        ticketList.forEach(ticket ->{
            String type = ticket.getProduct().getProductType().getType();
            Integer cantidad = ticket.getAmount();
            if(aux.containsKey(type)){
                aux.put(type, aux.get(type) + cantidad);
            } else {
                aux.put(type, cantidad);
            }
        });

        return aux;
    }

    private Integer numeroTicketTipoPago(List<Ticket> ticketList, String tipo) {
        return (int) ticketList.stream()
                .filter(ticket -> ticket.getPaymentType().getType().equals(tipo))
                .count();
    }
}
