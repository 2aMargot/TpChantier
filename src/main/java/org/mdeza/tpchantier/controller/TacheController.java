package org.mdeza.tpchantier.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.mdeza.tpchantier.dao.TacheDao;
import org.mdeza.tpchantier.model.Tache;
import org.mdeza.tpchantier.view.OperationView;
import org.mdeza.tpchantier.view.TacheView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TacheController {

    TacheDao tacheDao;

    @Autowired
    public TacheController(TacheDao tacheDao){
        this.tacheDao = tacheDao;
    }

    @GetMapping("/tache/{id}")
    @JsonView(TacheView.class)
    public ResponseEntity<Tache> get(@PathVariable int id){

        Optional<Tache> tacheOptional = tacheDao.findById(id);

        if(tacheOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tacheOptional.get(), HttpStatus.OK);

    }

    @GetMapping("/tache/list")
    @JsonView(TacheView.class)
    public List<Tache> list(){
        return tacheDao.findAll();
    }

    @PostMapping("/tache")
    @JsonView(TacheView.class)
    public String add(@RequestBody Tache newTache){
//        if(newTache.getId() != null){
//            Optional<Tache> tacheDb = tacheDao.findById(newTache.getId());
//            if(tacheDb.isPresent()){
//                this.tacheDao.save(newTache);
//                return ResponseEntity.ok().build();
//            }else {
//                return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
//            }
//        }else {
//            this.tacheDao.save(newTache);
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        }
        this.tacheDao.save(newTache);
        return "Utilisateur sauvegardé";
    }


    @DeleteMapping("/tache/{id}")
    @JsonView(TacheView.class)
    public ResponseEntity<Tache> delete(@PathVariable int id){
        Optional<Tache> tacheToDelete = tacheDao.findById(id);
        if(tacheToDelete.isPresent()){
            tacheDao.deleteById(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }


}
