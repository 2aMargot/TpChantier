package org.mdeza.tpchantier.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.mdeza.tpchantier.dao.UserDao;
import org.mdeza.tpchantier.model.User;
import org.mdeza.tpchantier.view.TacheView;
import org.mdeza.tpchantier.view.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    UserDao userDao;

    @Autowired
    public UserController(UserDao userDao){
        this.userDao = userDao;
    }

    @GetMapping("/user/{id}")
    @JsonView(UserView.class)
    public ResponseEntity<User> get(@PathVariable int id){

        Optional<User> userOptional = userDao.findById(id);

        if(userOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userOptional.get(), HttpStatus.OK);

    }

    @GetMapping("/user/list")
    @JsonView(UserView.class)
    public List<User> list(){
        return userDao.findAll();
    }

    @PostMapping("/user")
    @JsonView(UserView.class)
    public String add(@RequestBody User newUser){
//        if(newUser.getId() != null){
//            Optional<User> userDb = userDao.findById(newUser.getId());
//            if(userDb.isPresent()){
//                this.userDao.save(newUser);
//                return ResponseEntity.ok().build();
//            }else {
//                return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
//            }
//        }else {
//            this.userDao.save(newUser);
//            return ResponseEntity.status(HttpStatus.CREATED).build();
//        }
        this.userDao.save(newUser);
        return "Utilisateur sauvegardé";
    }


    @DeleteMapping("/user/{id}")
    @JsonView(UserView.class)
    public ResponseEntity<User> delete(@PathVariable int id){
        Optional<User> userToDelete = userDao.findById(id);
        if(userToDelete.isPresent()){
            userDao.deleteById(id);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }


}
