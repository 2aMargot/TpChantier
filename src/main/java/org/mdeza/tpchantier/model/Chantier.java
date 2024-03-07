package org.mdeza.tpchantier.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Chantier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @NotBlank(message = "Le nom du chantier ne peut pas être vide")
    @Size(min = 2, max = 100, message = "Le nom du chantier ne peut pas être inférieur à 2 ou supérieur à 100")
    @Column(length = 100)
    protected String name;

    @Size(min = 2, max = 100, message = "Le nom du chantier ne peut pas être inférieur à 2 ou supérieur à 100")
    @Column(length = 100)
    protected String address;

    @ManyToOne(optional = false)
    protected User user;
}
