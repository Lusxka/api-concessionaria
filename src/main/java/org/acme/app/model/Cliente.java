package org.acme.app.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Cliente extends PanacheEntity {

    @Column(nullable = false)
    public String nome;

    @Column(nullable = false, unique = true)
    public String cpf;

    @Column(nullable = false)
    public String endereco;

    @Column(nullable = false)
    public String telefone;
}
