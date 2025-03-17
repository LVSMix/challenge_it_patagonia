package org.example.challenge.it.patagonia.infraestructure.repository;

import org.example.challenge.it.patagonia.domain.model.Empresa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataMongoTest
public class EmpresaRepositoryTest {


    @Autowired
    private EmpresaRepository empresaRepository;

    @BeforeEach
    void setUp() {
        empresaRepository.deleteAll();
    }

    @Test
    void testFindByFechaAdhesionAfter() {
        Empresa empresa = new Empresa("123456789", "Empresa Test", LocalDate.now().minusDays(10));
        empresaRepository.save(empresa);

        List<Empresa> result = empresaRepository.findByFechaAdhesionAfter(LocalDate.now().minusMonths(1));

        assertEquals(1, result.size());
        assertEquals("123456789", result.get(0).getCuit());
    }

    @Test
    void testFindByCuit() {
        Empresa empresa = new Empresa("123456789", "Empresa Test", LocalDate.now());
        empresaRepository.save(empresa);

        Optional<Empresa> result = empresaRepository.findByCuit("123456789");

        assertTrue(result.isPresent());
        assertEquals("123456789", result.get().getCuit());
    }

    @Test
    void testFindAllByCuit() {
        Empresa empresa1 = new Empresa("123456789", "Empresa Test 1", LocalDate.now());
        Empresa empresa2 = new Empresa("987654321", "Empresa Test 2", LocalDate.now());
        empresaRepository.save(empresa1);
        empresaRepository.save(empresa2);

        List<Empresa> result = empresaRepository.findAllByCuit(List.of("123456789", "987654321"));

        assertEquals(2, result.size());
    }
}
