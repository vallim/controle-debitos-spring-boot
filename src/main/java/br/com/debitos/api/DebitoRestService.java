package br.com.debitos.api;

import br.com.debitos.domain.orm.Debito;
import br.com.debitos.service.DebitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        Debito debito = debitoService.findById(id);

        if (debito == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nenhum débito encontrado com o id " + id);
        }

        return ResponseEntity.ok(debito);
    }
}