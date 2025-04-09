package org.acme.app.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Venda extends PanacheEntity {

    @ManyToOne(optional = false)
    @JoinColumn(name = "carro_id", nullable = false)
    public Carro carro;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    public Cliente cliente;

    @Column(nullable = false)
    public LocalDate data;

    @Column(nullable = false)
    public double valor;
}
