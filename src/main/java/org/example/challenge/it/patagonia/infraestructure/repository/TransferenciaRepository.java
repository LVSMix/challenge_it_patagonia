package org.example.challenge.it.patagonia.infraestructure.repository;

import org.example.challenge.it.patagonia.domain.model.Transferencia;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransferenciaRepository extends MongoRepository<Transferencia, Integer> {
    @Query("{ 'fechaTransferencia' : { $gte: ?0 } }")
    List<Transferencia> findByFechaTransferenciaAfter(LocalDate fecha);
}
