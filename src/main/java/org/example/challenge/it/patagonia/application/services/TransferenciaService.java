package org.example.challenge.it.patagonia.application.services;

import org.example.challenge.it.patagonia.domain.model.Empresa;
import org.example.challenge.it.patagonia.domain.model.Transferencia;
import org.example.challenge.it.patagonia.infraestructure.repository.EmpresaRepository;
import org.example.challenge.it.patagonia.infraestructure.repository.TransferenciaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferenciaService {

    private TransferenciaRepository transferenciaRepository;
    private EmpresaRepository empresaRepository;

    public TransferenciaService(TransferenciaRepository transferenciaRepository, EmpresaRepository empresaRepository) {
        this.transferenciaRepository = transferenciaRepository;
        this.empresaRepository = empresaRepository;
    }

    public void registrarTransferencia(Transferencia transferencia) {
        // Validar que la empresa exista
        Optional<Empresa> empresa = empresaRepository.findByCuit(transferencia.getIdEmpresa());

        if (empresa.isEmpty()) {
            throw new RuntimeException("La empresa con ID " + transferencia.getIdEmpresa() + " no existe.");
        }

        // Guardar la transferencia si la empresa existe
        transferenciaRepository.save(transferencia);
    }
}
