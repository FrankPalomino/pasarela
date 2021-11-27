package com.main.pasarela.entities;

import java.util.Map;

/**
 *
 * @author frank
 */
public class Analytics {
    
    private Integer totalProductosVendidos;
    private Map<String,Integer> productosVendidosPorTipo;
    private Integer ticketVisa;
    private Integer ticktesMastercard;

    public Analytics() {
    }

    public Analytics(Integer totalProductosVendidos, Map<String, Integer> productosVendidosPorTipo, Integer ticketVisa, Integer ticktesMastercard) {
        this.totalProductosVendidos = totalProductosVendidos;
        this.productosVendidosPorTipo = productosVendidosPorTipo;
        this.ticketVisa = ticketVisa;
        this.ticktesMastercard = ticktesMastercard;
    }

    public Integer getTotalProductosVendidos() {
        return totalProductosVendidos;
    }

    public void setTotalProductosVendidos(Integer totalProductosVendidos) {
        this.totalProductosVendidos = totalProductosVendidos;
    }

    public Map<String, Integer> getProductosVendidosPorTipo() {
        return productosVendidosPorTipo;
    }

    public void setProductosVendidosPorTipo(Map<String, Integer> productosVendidosPorTipo) {
        this.productosVendidosPorTipo = productosVendidosPorTipo;
    }

    public Integer getTicketVisa() {
        return ticketVisa;
    }

    public void setTicketVisa(Integer ticketVisa) {
        this.ticketVisa = ticketVisa;
    }

    public Integer getTicktesMastercard() {
        return ticktesMastercard;
    }

    public void setTicktesMastercard(Integer ticktesMastercard) {
        this.ticktesMastercard = ticktesMastercard;
    }

    @Override
    public String toString() {
        return "Analytics{" + "totalProductosVendidos=" + totalProductosVendidos + ", productosVendidosPorTipo=" + productosVendidosPorTipo + ", ticketVisa=" + ticketVisa + ", ticktesMastercard=" + ticktesMastercard + '}';
    }
}
