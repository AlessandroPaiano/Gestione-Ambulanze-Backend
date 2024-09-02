package com.alessandroPaiano.GestAmbulanze.services;

import com.alessandroPaiano.GestAmbulanze.models.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    private final UtenteService utenteService;

    @Autowired
    public AuthenticationService(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    // Autentica l'utente tramite email e password
    public Optional<Utente> authenticate(String email, String password) {
        return utenteService.authenticate(email, password);
    }
}
