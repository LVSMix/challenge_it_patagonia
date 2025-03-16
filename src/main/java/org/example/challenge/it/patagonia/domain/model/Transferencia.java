package org.example.challenge.it.patagonia.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "transferencias")
public class Transferencia {

    private String idEmpresa;
    private BigDecimal importe;
    private String cuentaDebito;
    private String cuentaCredito;
    private LocalDate fechaTransferencia;

}
