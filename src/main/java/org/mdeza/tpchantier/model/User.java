package org.mdeza.tpchantier.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.mdeza.tpchantier.view.ChantierView;
import org.mdeza.tpchantier.view.OperationView;
import org.mdeza.tpchantier.view.UserView;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({UserView.class, ChantierView.class, OperationView.class})
    protected Integer id;

    @Column(nullable = false)
    @NotBlank
    @JsonView({UserView.class, ChantierView.class, OperationView.class})
    protected String pseudo;

    @Column(nullable = false)
    @NotBlank
    protected String password;

    @ManyToOne(optional = false)
    @JsonView({UserView.class})
    protected Role role;

    @OneToMany(mappedBy = "user")
    @JsonView({UserView.class})
    protected List<Operation> operationList = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonView({UserView.class})
    protected List<Chantier> chantierList = new ArrayList<>();
}
