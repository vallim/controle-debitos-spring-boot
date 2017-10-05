package br.com.debitos.domain.repository;

import br.com.debitos.domain.orm.Debito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DebitoRepository extends JpaRepository<Debito, Long> {


}
