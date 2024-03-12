package org.mdeza.tpchantier.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.mdeza.tpchantier.view.ChantierView;
import org.mdeza.tpchantier.view.OperationView;
import org.mdeza.tpchantier.view.TacheView;
import org.mdeza.tpchantier.view.UserView;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({UserView.class, ChantierView.class, OperationView.class, TacheView.class})
    protected Integer id;

    @NotBlank(message = "Le nom de l'opération ne peut pas être vide")
    @Column(length = 100)
    @Size(min = 2, max = 100, message = "Le nom de l'opération ne peut pas être inférieur à 2 ou supérieur à 100")
    @JsonView({UserView.class, ChantierView.class, OperationView.class, TacheView.class})
    protected String name;

    @JsonView({UserView.class, ChantierView.class, OperationView.class, TacheView.class})
    protected LocalDate date;

    @ManyToOne(optional = false)
    @JsonView(OperationView.class)
    protected Tache tache;

    @ManyToOne(optional = false)
    @JsonView(OperationView.class)
    protected User user;

    @ManyToOne(optional = false)
    @JsonView(OperationView.class)
    protected Chantier chantier;
}
