package org.example.challenge.it.patagonia.infraestructure.repository;

import org.example.challenge.it.patagonia.domain.model.Transferencia;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DataMongoTest
public class TransferenciaRepositoryTest {


    @Mock
    private MongoTemplate mongoTemplate;

    @Autowired
    private TransferenciaRepository transferenciaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindByFechaTransferenciaAfter() {
        Transferencia transferencia = new Transferencia();
        transferencia.setFechaTransferencia(LocalDate.of(2025, 2, 12));

        when(mongoTemplate.find(any(), any())).thenReturn(List.of(transferencia));

        List<Transferencia> result = transferenciaRepository.findByFechaTransferenciaAfter(LocalDate.of(2025, 2, 1));

        assertEquals(2, result.size());
        assertEquals(LocalDate.of(2025, 2, 12), result.get(0).getFechaTransferencia());
    }
}
