package org.example.challenge.it.patagonia.application.services;

import org.example.challenge.it.patagonia.domain.model.Empresa;
import org.example.challenge.it.patagonia.domain.model.Transferencia;
import org.example.challenge.it.patagonia.infraestructure.repository.EmpresaRepository;
import org.example.challenge.it.patagonia.infraestructure.repository.TransferenciaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class TransferenciaServiceTest {


    @Mock
    private TransferenciaRepository transferenciaRepository;

    @Mock
    private EmpresaRepository empresaRepository;

    @InjectMocks
    private TransferenciaService transferenciaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegistrarTransferenciaEmpresaExiste() {
        Transferencia transferencia = new Transferencia();
        transferencia.setIdEmpresa("123456789");

        Empresa empresa = new Empresa();
        empresa.setCuit("123456789");

        when(empresaRepository.findByCuit("123456789")).thenReturn(Optional.of(empresa));

        transferenciaService.registrarTransferencia(transferencia);

        verify(transferenciaRepository, times(1)).save(transferencia);
    }

    @Test
    void testRegistrarTransferenciaEmpresaNoExiste() {
        Transferencia transferencia = new Transferencia();
        transferencia.setIdEmpresa("123456789");

        when(empresaRepository.findByCuit("123456789")).thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () -> transferenciaService.registrarTransferencia(transferencia));

        verify(transferenciaRepository, never()).save(transferencia);
    }
}
