package br.com.debitos.domain.repository;

import br.com.debitos.domain.orm.Debito;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace.NONE;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = NONE)
@ActiveProfiles("test")
public class DebitoRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DebitoRepository debitoRepository;

    @Test
    public void deveSalvarUmDebito() {
        BigDecimal valorDebito = new BigDecimal("10");

        Debito debito = Debito.builder().nome("debito teste").vencimento(LocalDate.now())
                .valor(valorDebito).build();

        debito = debitoRepository.save(debito);

        assertThat(debito.getId()).isNotNull();
        assertThat(debito.getValor()).isEqualTo(valorDebito);
    }
}