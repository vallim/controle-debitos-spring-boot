package br.com.debitos.api;

import br.com.debitos.domain.orm.Debito;
import br.com.debitos.service.DebitoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DebitoRestService.class)
public class DebitoRestServiceTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private DebitoService debitoService;

    @Test
    public void deveRetornarListaDeDebitos() throws Exception {

        Debito debitoUm = Debito.builder().nome("mensalidade clube")
                .valor(new BigDecimal("57")).build();
        Debito debitoDois = Debito.builder().nome("aluguel")
                .valor(new BigDecimal("800")).pago(true).build();

        List<Debito> debitos = Arrays.asList(debitoUm, debitoDois);

        given(debitoService.findAll()).willReturn(debitos);

        mvc.perform(get("/debitos"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].valor", is(800)))
                .andExpect(jsonPath("$[1].nome", is(debitoDois.getNome())))
                .andExpect(jsonPath("$[1].pago", is(debitoDois.isPago())));
    }
}