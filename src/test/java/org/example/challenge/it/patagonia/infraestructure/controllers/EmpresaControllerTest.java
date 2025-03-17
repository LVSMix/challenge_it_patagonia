package org.example.challenge.it.patagonia.infraestructure.controllers;

import org.example.challenge.it.patagonia.application.services.EmpresaService;
import org.example.challenge.it.patagonia.domain.model.Empresa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmpresaControllerTest {
    @Mock
    private EmpresaService empresaService;

    @InjectMocks
    private EmpresaController empresaController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testObtenerEmpresasConTransferenciasUltimoMes() {
        Empresa empresa = new Empresa();
        List<Empresa> empresas = Collections.singletonList(empresa);

        when(empresaService.obtenerEmpresasConTransferenciasUltimoMes()).thenReturn(empresas);

        List<Empresa> result = empresaController.obtenerEmpresasConTransferenciasUltimoMes();

        assertEquals(1, result.size());
        verify(empresaService, times(1)).obtenerEmpresasConTransferenciasUltimoMes();
    }

    @Test
    void testObtenerEmpresasAdheridasUltimoMes() {
        Empresa empresa = new Empresa();
        List<Empresa> empresas = Collections.singletonList(empresa);

        when(empresaService.obtenerEmpresasAdheridasUltimoMes()).thenReturn(empresas);

        List<Empresa> result = empresaController.obtenerEmpresasAdheridasUltimoMes();

        assertEquals(1, result.size());
        verify(empresaService, times(1)).obtenerEmpresasAdheridasUltimoMes();
    }

    @Test
    void testAdherirEmpresa() {
        Empresa empresa = new Empresa();
        doNothing().when(empresaService).adherirEmpresa(empresa);

        ResponseEntity<String> response = empresaController.adherirEmpresa(empresa);

        assertEquals("Empresa adherida exitosamente", response.getBody());
        assertEquals(200, response.getStatusCodeValue());
        verify(empresaService, times(1)).adherirEmpresa(empresa);
    }
}
