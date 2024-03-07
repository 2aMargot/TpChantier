package org.mdeza.tpchantier.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(nullable = false)
    @NotBlank
    protected String pseudo;

    @Column(nullable = false)
    @NotBlank
    protected String password;

    @ManyToOne(optional = false)
    protected Role role;
}
