package com.api.crud.controllers;


import com.api.crud.models.UserModel;
import com.api.crud.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/user")

/*
* ACA DEFINIMOS LAS PETICIONES Y RUTAS
* */
public class UserControllers {
    @Autowired
    private UserServices userService;

    @GetMapping
    public ArrayList<UserModel> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping // request por body/ruta/header para mandarlo por postman
    public UserModel saveUser(UserModel user){
        return this.userService.saveUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id) {
        return this.userService.getById(id);
    }

    @PutMapping(path = "/{id}")
    public UserModel updateUserById(@RequestBody UserModel request, @PathVariable("id") Long id){
        return this.userService.updateById(request, id);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteById(@PathVariable("id") Long id ) {
        boolean ok = this.userService.deleteUser(id);
              if(ok){
                  return "User with id" + id + "Deleted";
              } else {
                  return "Error, problem with the id" + id;
              }

    }


}
