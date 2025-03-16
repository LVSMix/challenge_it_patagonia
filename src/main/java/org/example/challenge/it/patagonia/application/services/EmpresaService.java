package org.example.challenge.it.patagonia.application.services;

import org.example.challenge.it.patagonia.domain.model.Empresa;
import org.example.challenge.it.patagonia.domain.model.Transferencia;
import org.example.challenge.it.patagonia.infraestructure.repository.EmpresaRepository;
import org.example.challenge.it.patagonia.infraestructure.repository.TransferenciaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;
    private final TransferenciaRepository transferenciaRepository;

    public EmpresaService(EmpresaRepository empresaRepository, TransferenciaRepository transferenciaRepository) {
        this.empresaRepository = empresaRepository;
        this.transferenciaRepository = transferenciaRepository;
    }

    public List<Empresa> obtenerEmpresasConTransferenciasUltimoMes() {
        LocalDate haceUnMes = LocalDate.now().minusMonths(1);
        List<Transferencia> transferencias = transferenciaRepository.findByFechaTransferenciaAfter(haceUnMes);

        // Obtener los IDs de las empresas que hicieron transferencias
        Set<String> empresasIds = transferencias.stream()
                .map(Transferencia::getIdEmpresa)
                .collect(Collectors.toSet());

        // Buscar las empresas con esos IDs
        List<Empresa> result = empresaRepository.findAllByCuit(empresasIds);
        return result;
    }

    public List<Empresa> obtenerEmpresasAdheridasUltimoMes() {
        LocalDate haceUnMes = LocalDate.now().minusMonths(1);
        return empresaRepository.findByFechaAdhesionAfter(haceUnMes);
    }

    public void adherirEmpresa(Empresa empresa) {
        empresaRepository.save(empresa);
    }

}
