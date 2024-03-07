package org.mdeza.tpchantier.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Consommable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @NotBlank(message = "Le nom du consommable ne peut pas être vide")
    @Size(min = 2, max = 100, message = "Le nom du consommable ne peut pas être inférieur à 2 ou supérieur à 100")
    @Column(length = 100)
    protected String name;

}
