package org.example.challenge.it.patagonia.infraestructure.controllers;

import org.example.challenge.it.patagonia.application.services.TransferenciaService;
import org.example.challenge.it.patagonia.domain.model.Transferencia;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

    private final TransferenciaService transferenciaService;

    public TransferenciaController(TransferenciaService transferenciaService) {
        this.transferenciaService = transferenciaService;
    }

    @PostMapping
    public ResponseEntity<String> registrarTransferencia(@RequestBody Transferencia transferencia) {
        transferenciaService.registrarTransferencia(transferencia);
        return ResponseEntity.ok("Transferencia registrada exitosamente");
    }
}
