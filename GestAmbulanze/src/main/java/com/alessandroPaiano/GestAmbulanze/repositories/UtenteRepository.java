package com.alessandroPaiano.GestAmbulanze.repositories;

import com.alessandroPaiano.GestAmbulanze.models.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {

    // Trova un utente per email
    Optional<Utente> findByEmail(String email);
}
