package org.example.challenge.it.patagonia.infraestructure.repository;

import org.example.challenge.it.patagonia.domain.model.Empresa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface EmpresaRepository extends MongoRepository<Empresa, String> {
    @Query("{ 'fechaAdhesion' : { $gte: ?0 } }")
    List<Empresa> findByFechaAdhesionAfter(LocalDate fecha);
    Optional<Empresa> findByCuit(String cuit);
    @Query("{ 'cuit' : { $in: ?0 } }")
    List<Empresa> findAllByCuit(Iterable<String> cuits);
}
