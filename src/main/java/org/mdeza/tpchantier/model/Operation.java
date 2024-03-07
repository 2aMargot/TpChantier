package org.mdeza.tpchantier.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @NotBlank(message = "Le nom de l'opération ne peut pas être vide")
    @Column(length = 100)
    @Size(min = 2, max = 100, message = "Le nom de l'opération ne peut pas être inférieur à 2 ou supérieur à 100")
    protected String name;

    protected LocalDate date;

    @ManyToOne(optional = false)
    protected Tache tache;

    @ManyToOne(optional = false)
    protected Chantier chantier;
}
