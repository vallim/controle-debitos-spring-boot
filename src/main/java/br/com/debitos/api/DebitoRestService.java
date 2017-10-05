package br.com.debitos.api;

import br.com.debitos.domain.orm.Debito;
import br.com.debitos.service.DebitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/debitos")
public class DebitoRestService {

    @Autowired
    private DebitoService debitoService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Debito>> list() {
        return ResponseEntity.ok(debitoService.findAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Debito> save(@RequestBody Debito debito) {
        return ResponseEntity.ok(debitoService.save(debito));
    }
}