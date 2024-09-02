package com.alessandroPaiano.GestAmbulanze.controllers;

import com.alessandroPaiano.GestAmbulanze.models.Ambulanza;
import com.alessandroPaiano.GestAmbulanze.models.StatoAmbulanza;
import com.alessandroPaiano.GestAmbulanze.services.AmbulanzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ambulanze")
public class AmbulanzaController {

    private final AmbulanzaService ambulanzaService;

    @Autowired
    public AmbulanzaController(AmbulanzaService ambulanzaService) {
        this.ambulanzaService = ambulanzaService;
    }

    // Restituisce tutte le ambulanze
    @GetMapping
    public List<Ambulanza> getAllAmbulanze() {
        return ambulanzaService.getAllAmbulanze();
    }

    // Restituisce tutte le ambulanze disponibili
    @GetMapping("/disponibili")
    public List<Ambulanza> getAmbulanzeDisponibili() {
        return ambulanzaService.getAmbulanzeDisponibili();
    }

    // Cambia lo stato di un'ambulanza
    @PutMapping("/{id}/stato")
    public ResponseEntity<Void> cambiaStatoAmbulanza(@PathVariable Long id, @RequestParam StatoAmbulanza nuovoStato) {
        ambulanzaService.cambiaStatoAmbulanza(id, nuovoStato);
        return ResponseEntity.ok().build();
    }

    // Crea o aggiorna un'ambulanza
    @PostMapping
    public Ambulanza saveAmbulanza(@RequestBody Ambulanza ambulanza) {
        return ambulanzaService.saveAmbulanza(ambulanza);
    }

    // Elimina un'ambulanza
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAmbulanza(@PathVariable Long id) {
        ambulanzaService.deleteAmbulanza(id);
        return ResponseEntity.ok().build();
    }
}
