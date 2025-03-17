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

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EmpresaServiceTest {

    @Mock
    private EmpresaRepository empresaRepository;

    @Mock
    private TransferenciaRepository transferenciaRepository;

    @InjectMocks
    private EmpresaService empresaService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerEmpresasConTransferenciasUltimoMes() {
        LocalDate haceUnMes = LocalDate.now().minusMonths(1);
        Transferencia transferencia = new Transferencia();
        transferencia.setIdEmpresa("123456789");
        List<Transferencia> transferencias = Collections.singletonList(transferencia);

        when(transferenciaRepository.findByFechaTransferenciaAfter(haceUnMes)).thenReturn(transferencias);
        when(empresaRepository.findAllByCuit(any(Set.class))).thenReturn(Collections.singletonList(new Empresa()));

        List<Empresa> result = empresaService.obtenerEmpresasConTransferenciasUltimoMes();

        assertEquals(1, result.size());
        verify(transferenciaRepository, times(1)).findByFechaTransferenciaAfter(haceUnMes);
        verify(empresaRepository, times(1)).findAllByCuit(any(Set.class));
    }

    @Test
    void testObtenerEmpresasAdheridasUltimoMes() {
        LocalDate haceUnMes = LocalDate.now().minusMonths(1);
        Empresa empresa = new Empresa();
        List<Empresa> empresas = Collections.singletonList(empresa);

        when(empresaRepository.findByFechaAdhesionAfter(haceUnMes)).thenReturn(empresas);

        List<Empresa> result = empresaService.obtenerEmpresasAdheridasUltimoMes();

        assertEquals(1, result.size());
        verify(empresaRepository, times(1)).findByFechaAdhesionAfter(haceUnMes);
    }

    @Test
    void testAdherirEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setCuit("123456789");

        empresaService.adherirEmpresa(empresa);

        verify(empresaRepository, times(1)).save(empresa);
    }
}
