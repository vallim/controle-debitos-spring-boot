package br.com.debitos.service;

import br.com.debitos.domain.orm.Debito;
import br.com.debitos.domain.repository.DebitoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DebitoService {

    @Autowired
    private DebitoRepository debitoRepository;

    public List<Debito> findAll() {
        return debitoRepository.findAll();
    }

    public Debito save(Debito debito) {
        return debitoRepository.save(debito);
    }

    public Debito findById(Long id) {
        return debitoRepository.findOne(id);
    }
}