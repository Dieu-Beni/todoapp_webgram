package com.jins.db.Todoapp.controller;

import com.jins.db.Todoapp.dto.CreateTacheRequest;
import com.jins.db.Todoapp.model.Tache;
import com.jins.db.Todoapp.service.TacheService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
@RequiredArgsConstructor
public class TacheController {
    private final TacheService tacheService;

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody CreateTacheRequest request) {
        try {
            Tache tache = tacheService.createTache(request);

            return ResponseEntity.status(HttpStatus.CREATED).body(tache);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        try {
            List<Tache> taches = tacheService.getall();
            return ResponseEntity.ok().body(taches);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody CreateTacheRequest request) {
        try {
            Tache t = tacheService.updateTache(request,id);
            if(t == null) return ResponseEntity.badRequest().body("Vous ne disposez pas d'une tache avec cet id");
            return ResponseEntity.ok().body(t);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        try {
            Tache tache = tacheService.getTache(id);
            if (tache == null) return ResponseEntity.badRequest().body("Vous ne disposez pas d'une tache avec cet id");
            return ResponseEntity.ok().body(tache);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            Tache tache = tacheService.deleteTache(id);
            if (tache == null) return ResponseEntity.badRequest().body("Vous ne disposez pas d'une tache avec cet id");
            return ResponseEntity.ok().body(tache);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
