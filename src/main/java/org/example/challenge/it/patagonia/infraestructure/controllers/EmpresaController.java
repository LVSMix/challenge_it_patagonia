package org.example.challenge.it.patagonia.infraestructure.controllers;

import org.example.challenge.it.patagonia.domain.model.Empresa;
import org.example.challenge.it.patagonia.application.services.EmpresaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/transferencias-mes")
    public List<Empresa> obtenerEmpresasConTransferenciasUltimoMes() {
        return empresaService.obtenerEmpresasConTransferenciasUltimoMes();
    }

    @GetMapping("/adhesiones-mes")
    public List<Empresa> obtenerEmpresasAdheridasUltimoMes() {
        return empresaService.obtenerEmpresasAdheridasUltimoMes();
    }

    @PostMapping("/adhesion")
    public ResponseEntity<String> adherirEmpresa(@RequestBody Empresa empresa) {
        empresaService.adherirEmpresa(empresa);
        return ResponseEntity.ok("Empresa adherida exitosamente");
    }
}
