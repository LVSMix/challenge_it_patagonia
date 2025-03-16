package org.example.challenge.it.patagonia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "empresas")
public class Empresa {

    private String cuit;
    private String razonSocial;
    private LocalDate fechaAdhesion;

}
