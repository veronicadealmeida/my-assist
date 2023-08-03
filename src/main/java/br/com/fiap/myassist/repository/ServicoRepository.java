package br.com.fiap.myassist.repository;

import br.com.fiap.myassist.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
