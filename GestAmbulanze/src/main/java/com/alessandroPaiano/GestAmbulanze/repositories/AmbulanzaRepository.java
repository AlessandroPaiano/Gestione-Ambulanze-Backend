package com.alessandroPaiano.GestAmbulanze.repositories;

import com.alessandroPaiano.GestAmbulanze.models.Ambulanza;
import com.alessandroPaiano.GestAmbulanze.models.StatoAmbulanza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmbulanzaRepository extends JpaRepository<Ambulanza, Long> {

    // Trova tutte le ambulanze con un determinato stato
    List<Ambulanza> findByStato(StatoAmbulanza stato);

    // Aggiorna lo stato di un'ambulanza
    default void updateStato(Long id, StatoAmbulanza nuovoStato) {
        Ambulanza ambulanza = findById(id).orElseThrow(() -> new IllegalArgumentException("Ambulanza non trovata"));
        ambulanza.setStato(nuovoStato);
        save(ambulanza);
    }
}
