package br.com.debitos.api;

import br.com.debitos.domain.orm.Debito;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RequestMapping("/debitos")
@RestController
public class DebitoRestService {

    private static List<Debito> debitos = new ArrayList<>();

    static {
        Debito debitoUm = Debito.builder().id(1L).nome("conta de agua")
                .valor(new BigDecimal("67.80"))
                .vencimento(LocalDate.now()).build();

        debitos.add(debitoUm);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Debito>> list() {
        return ResponseEntity.ok(debitos);
    }
}