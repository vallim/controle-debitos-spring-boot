package br.com.debitos.service;

import br.com.debitos.domain.orm.Debito;
import br.com.debitos.domain.repository.DebitoRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class DebitoServiceTest {

    @Autowired
    private DebitoService debitoService;

    @MockBean
    private DebitoRepository debitoRepository;

    @Test
    public void deveBuscarPorIdUmDebitoExistente() {
        Debito aluguel = Debito.builder().nome("aluguel").valor(new BigDecimal("800")).vencimento(LocalDate.now().minusDays(1)).build();

        when(debitoRepository.findOne(1L)).thenReturn(aluguel);

        Debito debito = debitoService.findById(1L);

        verify(debitoRepository).findOne(1L);

        assertThat(debito.getNome()).isEqualTo(aluguel.getNome());
    }
}