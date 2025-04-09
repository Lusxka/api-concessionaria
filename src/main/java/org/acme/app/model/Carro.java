package org.acme.app.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Carro extends PanacheEntity {

    @Column(nullable = false)
    public String marca;

    @Column(nullable = false)
    public String modelo;

    @Column(nullable = false)
    public int ano;

    @Column(nullable = false)
    public double preco;
}
