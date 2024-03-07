package org.mdeza.tpchantier.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Tache {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

    @Column(length = 100)
    @Size(min = 2, max = 100, message = "Le nom de la tâche ne peut pas être inférieur à 2 ou supérieur à 100")
    @NotBlank(message = "Le nom de la tâche ne peut pas être vide")
    protected String name;

    @Min(value = 0, message = "Le temps d'une tâche ne peut pas etre inférieur ou égal à 0")
    protected int temps;

    @ManyToMany
    @JoinTable(
            name = "consommable_tache",
            joinColumns = @JoinColumn(name = "tache_id"),
            inverseJoinColumns = @JoinColumn(name = "consommable_id")
    )
    protected List<Consommable> listConsommable = new ArrayList<>();
}
