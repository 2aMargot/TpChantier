package org.mdeza.tpchantier.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.mdeza.tpchantier.dao.OperationDao;
import org.mdeza.tpchantier.model.Operation;
import org.mdeza.tpchantier.view.ChantierView;
import org.mdeza.tpchantier.view.OperationView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OperationController {

    OperationDao operationDao;

    @Autowired
    public OperationController(OperationDao operationDao){
        this.operationDao = operationDao;
    }

    @GetMapping("/operation/{id}")
    @JsonView(OperationView.class)
    public ResponseEntity<Operation> get(@PathVariable int id){

        Optional<Operation> operationOptional = operationDao.findById(id);

        if(operationOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(operationOptional.get(), HttpStatus.OK);

    }

    @GetMapping("/operation/list")
    @JsonView(OperationView.class)
    public List<Operation> list(){
        return operationDao.findAll();
    }

    @PostMapping("/operation")
    @JsonView(OperationView.class)
    public String add(@RequestBody Operation newOperation){
//        if(newOperation.getId() != null){
//            Optional<Operation> operationDb = operationDao.findById(newOperation.getId());
//            if(operationDb.isPresent()){
//                this.operationDao.save(newOperation);
//                return ResponseEntity.ok().build();
//            }else {
//                return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
//            }
//        }else {
//            this.operationDao.save(newOperation);
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        }
        this.operationDao.save(newOperation);
        return "Utilisateur sauvegardé";
    }


    @DeleteMapping("/operation/{id}")
    @JsonView(OperationView.class)
    public ResponseEntity<Operation> delete(@PathVariable int id){
        Optional<Operation> operationToDelete = operationDao.findById(id);
        if(operationToDelete.isPresent()){
            operationDao.deleteById(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }


}
