package br.com.debitos.domain.orm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Debito {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "debito_id_seq")
    @SequenceGenerator(name = "debito_id_seq", sequenceName = "debito_id_seq", allocationSize = 1)
    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private LocalDate vencimento;
    private boolean pago;
}