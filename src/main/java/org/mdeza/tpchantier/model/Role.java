package org.mdeza.tpchantier.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @NotBlank(message = "La designation du role ne peut pas etre vide")
    @Size(min = 2, max = 100, message = "Le role doit faire au minimim 2 caractères et au maximum 100")
    @Column(length = 100)
    protected String designation;
}
