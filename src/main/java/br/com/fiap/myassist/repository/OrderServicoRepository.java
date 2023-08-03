package br.com.fiap.myassist.repository;

import br.com.fiap.myassist.entity.OrdemServico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderServicoRepository extends JpaRepository<OrdemServico, Long> {
}
