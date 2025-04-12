package com.barber.shop.api.controller;


import com.barber.shop.api.activity.ClientActivity;
import com.barber.shop.api.exception.NotFoundException;
import com.barber.shop.api.model.Client;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {

    @Autowired
    private ClientActivity activity;

    @PostMapping("/save")
    public ResponseEntity<Client> createClient(@RequestBody Client item ) throws Exception {

        return ResponseEntity.ok(activity.save(item));
    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client item ) {
//        return ResponseEntity.ok(activity.update(id, item));
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        activity.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) {
        return ResponseEntity.ok(activity.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Client>> findAll() {
        return ResponseEntity.ok(activity.findAll());
    }

}
