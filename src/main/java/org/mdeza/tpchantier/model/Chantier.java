package org.mdeza.tpchantier.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.mdeza.tpchantier.view.ChantierView;
import org.mdeza.tpchantier.view.OperationView;
import org.mdeza.tpchantier.view.UserView;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Chantier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({UserView.class, ChantierView.class, OperationView.class})
    protected Integer id;

    @NotBlank(message = "Le nom du chantier ne peut pas être vide")
    @Size(min = 2, max = 100, message = "Le nom du chantier ne peut pas être inférieur à 2 ou supérieur à 100")
    @Column(length = 100)
    @JsonView({UserView.class, ChantierView.class, OperationView.class})
    protected String name;

    @Size(min = 2, max = 100, message = "Le nom du chantier ne peut pas être inférieur à 2 ou supérieur à 100")
    @Column(length = 100)
    @JsonView({UserView.class, ChantierView.class, OperationView.class})
    protected String address;

    @ManyToOne(optional = false)
    @JsonView({ChantierView.class})
    protected User user;

    @OneToMany(mappedBy = "chantier")
    @JsonView({ChantierView.class})
    protected List<Operation> operationList  = new ArrayList<>();
}
