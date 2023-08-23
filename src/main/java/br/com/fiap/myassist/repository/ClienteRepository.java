package br.com.fiap.myassist.repository;

import br.com.fiap.myassist.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
