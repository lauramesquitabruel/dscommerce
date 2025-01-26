package com.bruel.dscommerce.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

import java.time.Instant;

public class Payment {
    private Long id;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant moment;

    //mapeamento do relacionamento 1:1 do lado dependente
    @OneToOne
    @MapsId
    private Order order;

    public Payment(){}

    public Payment(Long id, Instant moment, Order order) {
        this.id = id;
        this.moment = moment;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
