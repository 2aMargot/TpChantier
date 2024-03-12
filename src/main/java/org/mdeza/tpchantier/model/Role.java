package org.mdeza.tpchantier.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.mdeza.tpchantier.view.UserView;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView({UserView.class})
    protected Integer id;

    @NotBlank(message = "La designation du role ne peut pas etre vide")
    @Size(min = 2, max = 100, message = "Le role doit faire au minimim 2 caractères et au maximum 100")
    @JsonView({UserView.class})
    @Column(length = 100)
    protected String designation;

    @OneToMany(mappedBy = "role")
    protected List<User> userList = new ArrayList<>();

}
