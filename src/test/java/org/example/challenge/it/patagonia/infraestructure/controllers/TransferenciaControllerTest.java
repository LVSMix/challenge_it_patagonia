package org.example.challenge.it.patagonia.infraestructure.controllers;

import org.example.challenge.it.patagonia.application.services.TransferenciaService;
import org.example.challenge.it.patagonia.domain.model.Transferencia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TransferenciaControllerTest {

    @Mock
    private TransferenciaService transferenciaService;

    @InjectMocks
    private TransferenciaController transferenciaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistrarTransferencia() {
        Transferencia transferencia = new Transferencia();
        doNothing().when(transferenciaService).registrarTransferencia(transferencia);

        ResponseEntity<String> response = transferenciaController.registrarTransferencia(transferencia);

        assertEquals("Transferencia registrada exitosamente", response.getBody());
        assertEquals(200, response.getStatusCodeValue());
        verify(transferenciaService, times(1)).registrarTransferencia(transferencia);
    }
}
