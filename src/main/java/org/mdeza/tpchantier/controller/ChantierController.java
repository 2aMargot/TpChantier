package org.mdeza.tpchantier.controller;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.mdeza.tpchantier.dao.ChantierDao;
import org.mdeza.tpchantier.model.Chantier;
import org.mdeza.tpchantier.view.ChantierView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class ChantierController {

    @Autowired
    ChantierDao chantierDao;

    @GetMapping("/chantier/{id}")
    @JsonView(ChantierView.class)
    public ResponseEntity<Chantier> get(@PathVariable int id) {

        Optional<Chantier> chantierOptional = chantierDao.findById(id);

        if (chantierOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(chantierOptional.get(), HttpStatus.OK);
    }

    @GetMapping("/chantier/list")
    @JsonView(ChantierView.class)
    public List<Chantier> list() {
        return chantierDao.findAll();
    }

    @PostMapping("/chantier")
    @JsonView(ChantierView.class)
    public ResponseEntity<Chantier> add(@Valid @RequestBody Chantier newChantier) {
        if (newChantier.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        chantierDao.save(newChantier);
        return new ResponseEntity<>(newChantier, HttpStatus.CREATED);
    }

    @PutMapping("/chantier/{id}")
    @JsonView(ChantierView.class)
    public ResponseEntity<Chantier> modifier(@Valid @RequestBody Chantier chantier, @PathVariable int id) {
        chantier.setId(id);

        Optional<Chantier> chantierOptional = chantierDao.findById(chantier.getId());

        if (chantierOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        chantierDao.save(chantier);
        return new ResponseEntity<>(chantierOptional.get(), HttpStatus.OK);
    }

    @DeleteMapping("/chantier/{id}")
    @JsonView(ChantierView.class)
    public ResponseEntity<Chantier> delete(@PathVariable int id) {
        Optional<Chantier> chantierOptional = chantierDao.findById(id);

        if (chantierOptional.isPresent()) {
            chantierDao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
